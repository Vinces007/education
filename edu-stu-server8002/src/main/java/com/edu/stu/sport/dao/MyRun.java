package com.edu.stu.sport.dao;

import lombok.extern.slf4j.Slf4j;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyRun implements Runnable {

    private JdbcTemplate jdbcTemplate;
    private String where;
    private  String name;



    private RabbitTemplate rabbitTemplate;
    public MyRun(){}
    public MyRun(String name, JdbcTemplate jdbcTemplate, RabbitTemplate rabbitTemplate){
        this.name = name;
        this.jdbcTemplate = jdbcTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public synchronized void run() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime localDateTime = LocalDateTime.now();
        //创建当天的文件夹
        String path = "D://java//sportData";
        String fileName = path+"//"+name+"_"+dateTimeFormatter.format(localDateTime);

        File file = new File(path);
        if(!file.isDirectory()){
            file.mkdir();
        }
        File  filedata =  new File(fileName);
        if(!filedata.isDirectory()){
            filedata.mkdir();
        }
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select "+where+" from " + name + " where status = 0");
        if(maps!=null&&maps.size()>0) {
            maps.stream().forEach(r -> {
                jdbcTemplate.update(" update " + name + " set  status = 1  where id =  " + r.get("id").toString());
                try {
                    // 1、生成一个根节点
                    Element root = new Element("root");
                    // 2、为节点添加属性
                    root.setAttribute("formName", name);
                    // 3、生成一个document对象
                    Document document = new Document(root);
                    for (String k : r.keySet()
                    ) {
                        Element property = new Element("property");
                        property.setAttribute("name", k);
                        root.addContent(property);
                        Element value = new Element("value");
                        value.setText(r.get(k).toString());
                        property.addContent(value);
                    }
                    Format format = Format.getCompactFormat();
                    // 设置换行Tab或空格
                    format.setIndent("	");
                    format.setEncoding("UTF-8");
                    // 4、创建XMLOutputter的对象
                    XMLOutputter outputer = new XMLOutputter(format);
                    Map<String,Object> map = new HashMap<>();

                    // 5、利用outputer将document转换成xml文档
                    File fileXml = new File(fileName + "//" + name + "_" + System.currentTimeMillis() + ".xml");
                    map.put("id",fileXml.getName());
                    outputer.output(document, new FileOutputStream(fileXml));
                    ByteArrayOutputStream bo = new ByteArrayOutputStream();
                    outputer.output(document, bo);
                    map.put("data",bo.toString());
                    log.info("发送消息："+fileXml.getName()+"==="+bo.toString());
                    rabbitTemplate.convertAndSend("jinzhou",map);
                    log.info("生成" + name + "xml成功");
                } catch (Exception e) {
                    jdbcTemplate.update(" update " + name + " set  status = 0 ");
                    e.printStackTrace();
                }
            });
        }else{
            log.info(name+"表中无可上报数据");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }






















}

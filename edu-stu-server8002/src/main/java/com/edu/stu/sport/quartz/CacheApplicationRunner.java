package com.edu.stu.sport.quartz;

import com.edu.stu.sport.dao.CaheMap;
import com.edu.stu.sport.dao.MyRun;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CacheApplicationRunner implements ApplicationRunner {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Map<String, Object>> lists = jdbcTemplate.queryForList("select formname from sportname");
        if(lists != null && lists.size()>0){
           CaheMap caheMap =  CaheMap.getInstance();
           Field[] declaredFields = new Field[lists.size()];
           for (int i = 0 ;i <lists.size();i++){
               String name = lists.get(i).get("formname").toString();
               //反射获取类
               try {
                   Class<?> T = Class.forName("com.edu.stu.sport.dao."+name);
                   caheMap.putValue(name,T);
                   declaredFields = T.getDeclaredFields();;//获取属性数组
                   StringBuffer sb = new StringBuffer();
                   for(int j = 0 ; j < declaredFields.length;j++){
                       System.out.println(declaredFields[j].getName());
                       if(!declaredFields[j].getName().equals("status")){
                           declaredFields[j].setAccessible(true);
                           sb.append(declaredFields[j].getName()+",");
                       }
                   }
                   caheMap.putValueStr(name,sb.toString().substring(0,sb.length()-1));
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }

        }
    }
}

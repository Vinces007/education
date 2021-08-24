package com.edu.stu.sport.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataForm {
    @Resource
    private  static  JdbcTemplate jdbcTemplate;

    public static void getData(String name){

        //先获取要上报的表名称
        //根据上报的表进行创建线程
        //根据名称反射到实体类
        //获取实体类的字段
        //
        Field[] declaredFields = new Field[]{};
        try {
            Class<?> T = Class.forName("com.edu.stu.sport.dao."+name);
            declaredFields = T.getDeclaredFields();;//获取属性数组
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < declaredFields.length;i++){
           if(!declaredFields[i].getName().equals("c_status")){
              declaredFields[i].setAccessible(true);
               if(i== declaredFields.length-1){
                   sb.append(declaredFields[i]);
                   break;
               }
               sb.append(declaredFields[i]+",");
           }
        }
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select " + sb.toString() + " from "
                + name + " where c_status = 0 ");
        for(int i = 0;i<maps.size();i++){
            for(int j = 0; j <declaredFields.length;j++){
                if(!declaredFields[j].getName().equals("c_status")){
                    maps.get(i).get(declaredFields[i].getName());//获取值
                }
            }
        }
    }
    public static void main(String[] args) {
       /* Field[] declaredFields = new Field[]{};
        try {
            Class<?> T = Class.forName("com.edu.stu.sport.dao.course");
           // declaredFields   = T.getClass().getDeclaredFields();//获取属性数组
             declaredFields = T.getDeclaredFields();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < declaredFields.length;i++){
            if(i== declaredFields.length-1){
                sb.append(declaredFields[i].getName());
                break;
            }
            sb.append(declaredFields[i].getName()+",");
        }
        System.out.println(sb.toString());*/
        //多线程
        AtomicInteger a = new AtomicInteger();
        /*for(int i = 0 ; i < 5;i++){
           new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"start"+System.currentTimeMillis());
                    System.out.println(Thread.currentThread().getName()+"===="+a.getAndIncrement());
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"end"+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }*/
    }

}

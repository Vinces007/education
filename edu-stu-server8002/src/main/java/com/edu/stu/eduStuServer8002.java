package com.edu.stu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableCircuitBreaker
@RestController
@RequestMapping("/logins")
@EnableTransactionManagement
@EnableScheduling
public class eduStuServer8002 {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(eduStuServer8002.class,args);
    }
    @GetMapping("/")
    @Transactional
   public List getCourse(){
       List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from course");
        jdbcTemplate.update(" update course set  status = 1 ");
       /* int i = 1/0;*/
       return  maps;
   }


}

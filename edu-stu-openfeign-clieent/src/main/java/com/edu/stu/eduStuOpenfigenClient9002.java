package com.edu.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class eduStuOpenfigenClient9002 {
    public static void main(String[] args) {
        SpringApplication.run(eduStuOpenfigenClient9002.class,args);
    }
}

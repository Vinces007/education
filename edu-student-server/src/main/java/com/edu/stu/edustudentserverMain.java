package com.edu.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class edustudentserverMain {
    public static void main(String[] args) {
        SpringApplication.run(edustudentserverMain.class,args);
    }
}

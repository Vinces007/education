package com.edu.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class eduStuServer8002 {
    public static void main(String[] args) {
        SpringApplication.run(eduStuServer8002.class,args);
    }
}

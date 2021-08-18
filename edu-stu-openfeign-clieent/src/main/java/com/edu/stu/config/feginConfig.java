package com.edu.stu.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class feginConfig {
    @Bean
    Logger.Level getLog(){
        return  Logger.Level.FULL;
    }
}

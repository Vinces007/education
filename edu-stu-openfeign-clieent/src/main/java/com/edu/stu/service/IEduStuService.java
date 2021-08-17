package com.edu.stu.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(value = "EDU-STU-SERVER")
public interface IEduStuService {

    @GetMapping("/stu/login")
    public Map<String,Object> login(@RequestParam("pass") String pass, @RequestParam("iphone")String iphone);

    @GetMapping("/stu/logins")
    public Map<String,Object> logins(@RequestParam("pass") String pass, @RequestParam("iphone")String iphone);
}

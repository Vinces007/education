package com.edu.stu.service;


import edu.stu.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(value = "EDU-STU-SERVER")
public interface IEduStuService {

    @GetMapping("/stu/login")
    public CommonResult login(@RequestParam("pass") String pass, @RequestParam("iphone")String iphone);

    @GetMapping("/stu/logins")
    public CommonResult logins(@RequestParam("pass") String pass, @RequestParam("iphone")String iphone);
}

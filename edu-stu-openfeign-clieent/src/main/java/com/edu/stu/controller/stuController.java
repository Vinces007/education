package com.edu.stu.controller;

import com.edu.stu.service.IEduStuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class stuController {
    @Resource
    private IEduStuService iEduStuService;

    @RequestMapping("/login")
    public Map<String,Object> login(String pass,String iphone){
        Map forObject = iEduStuService.login(pass,iphone);
        return forObject;
    }


    @RequestMapping("/logins")
    public Map<String,Object> logins(String pass,String iphone){
        Map forObject = iEduStuService.logins(pass,iphone);
        return forObject;
    }
}

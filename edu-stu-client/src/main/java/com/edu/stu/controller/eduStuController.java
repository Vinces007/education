package com.edu.stu.controller;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/stuclient")
public class eduStuController {

    private final String EDU_STU_SERVER = "http://EDU-STU-SERVER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login")
    public Map<String,Object> login(String pass,String iphone){
/*         return restTemplate.postForObject(EDU_STU_SERVER+"/login/", payment, CommonResult.class);*/
        Map forObject = restTemplate.getForObject(EDU_STU_SERVER + "/stu/login?pass=" + pass + "&&iphone=" + iphone, Map.class);
        return forObject;
    }

}

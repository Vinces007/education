package com.edu.stu.controller;

import com.edu.stu.service.IEduStuService;
import com.edu.stu.service.IShortMessage;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import edu.stu.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class stuController {
    @Resource
    private IEduStuService iEduStuService;

    @Resource
    private IShortMessage iShortMessage;

    @RequestMapping("/login")
    public CommonResult login(String pass, String iphone){
        CommonResult commonResult  = iEduStuService.login(pass,iphone);
        return commonResult;
    }


    @RequestMapping("/logins")
   /* @HystrixCommand(fallbackMethod = "fallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "60000")
    })*/
    public CommonResult logins(String pass,String iphone){
        CommonResult commonResult = iEduStuService.logins(pass,iphone);
        return commonResult;
    }
    public CommonResult fallbackMethod(String pass, String iphone){
        Map<String,Object> result = new HashMap<>();
        result.put("pass",pass);
        result.put("iphone",iphone);
        return CommonResult.result("300","client服务超时降级",result);
    }


    @RequestMapping("/getMessage")
    public CommonResult getMessage(String type,String iphone){
        CommonResult message = iShortMessage.getMessage(type, iphone);
        return message;
    }

    @RequestMapping("/getEdu")
    public CommonResult  getEdu(){
        return CommonResult.success("success");
    }


}

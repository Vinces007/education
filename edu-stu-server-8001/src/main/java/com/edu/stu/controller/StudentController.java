package com.edu.stu.controller;

import com.edu.stu.domain.StudentDomain;
import com.edu.stu.service.IStudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import edu.stu.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

@RestController
@CrossOrigin
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Value("${server.port}")
    private String SERVER_PORT;

    @RequestMapping("/login")
    public CommonResult login(String pass, String iphone){
        System.out.println("端口号为：：："+SERVER_PORT+"参数pass="+pass+"iphone = "+iphone);
        String token = UUID.randomUUID().toString();
        return CommonResult.success(token);
    }
    @RequestMapping("/logins")
    @HystrixCommand(fallbackMethod = "fallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    public CommonResult logins(String pass, String iphone){
        System.out.println("端口号为：：："+SERVER_PORT+"参数pass="+pass+"iphone = "+iphone);
        Map<String,Object> result = new HashMap<>();
        result.put("success","1");
        result.put("SERVER_PORT",SERVER_PORT);
        System.out.println("ssssss"+new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            result.put("success","0");
        }
        System.out.println("ssssss"+new Date());
        return CommonResult.success(result);
    }

   public CommonResult fallbackMethod(String pass, String iphone){
       Map<String,Object> result = new HashMap<>();
       result.put("pass",pass);
       result.put("iphone",iphone);
        return CommonResult.result("300","服务超时降级",result);
   }

    @RequestMapping("/query")
    public List<StudentDomain> queryList() {
        System.out.println("querylist");
        return studentService.queryList();
    }

    @RequestMapping("/queryById/{stuId}")
    public StudentDomain queryByid(@PathVariable("stuId") int stuId) {
        return studentService.queryByid(stuId);
    }

    @RequestMapping("/save")
    public int addStuendt(@RequestBody StudentDomain studentDomain) {
        return studentService.addStuendt(studentDomain);
    }

    @RequestMapping("/delte")
    public int delStudent(int stuId) {
        return studentService.delStudent(stuId);
    }

    @RequestMapping("/update")
    public void updateStudent(@RequestBody StudentDomain studentDomain) {
        studentService.updateStudent(studentDomain);
    }

    @RequestMapping("/toVip")
    public int updateVip(@RequestBody StudentDomain studentDomain) {
        return studentService.updateVip(studentDomain);
    }

}

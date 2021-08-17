package com.edu.stu.controller;

import com.edu.stu.domain.StudentDomain;
import com.edu.stu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Value("${server.port}")
    private String SERVER_PORT;

    @RequestMapping("/login")
    public Map<String,Object> login(String pass,String iphone){
        System.out.println("端口号为：：："+SERVER_PORT+"参数pass="+pass+"iphone = "+iphone);
        System.out.println();
        Map<String,Object> result = new HashMap<>();
        result.put("success","1");
        result.put("SERVER_PORT",SERVER_PORT);
        return result;
    }

    @RequestMapping("/logins")
    public Map<String,Object> logins(String pass,String iphone){
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
        return result;
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

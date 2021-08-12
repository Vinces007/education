package com.edu.stu.controller;

import com.edu.stu.domain.StudentDomain;
import com.edu.stu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/query")
    public List<StudentDomain> queryList() {
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

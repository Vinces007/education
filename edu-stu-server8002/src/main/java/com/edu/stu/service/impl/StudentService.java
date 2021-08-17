package com.edu.stu.service.impl;

import com.edu.stu.domain.StudentDomain;
import com.edu.stu.mapper.StudentMapper;
import com.edu.stu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addStuendt(StudentDomain studentDomain) {
        return studentMapper.addStuendt(studentDomain);
    }

    @Override
    public int delStudent(int stuId) {
        return studentMapper.delStudent(stuId);
    }

    @Override
    public List<StudentDomain> queryList() {
        return studentMapper.queryList();
    }

    @Override
    public StudentDomain queryByid(int stuId) {
        return studentMapper.queryByid(stuId);
    }

    @Override
    public void updateStudent(StudentDomain studentDomain) {
        studentMapper.updateStudent(studentDomain);
    }

    @Override
    public int updateVip(StudentDomain studentDomain) {
        return studentMapper.updateVip(studentDomain);
    }
}

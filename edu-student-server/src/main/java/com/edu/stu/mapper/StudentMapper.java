package com.edu.stu.mapper;


import com.edu.stu.domain.StudentDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentMapper {
    int addStuendt(StudentDomain studentDomain);//增加
    int delStudent(int stuId);//删除
    List<StudentDomain> queryList();//查所有
    StudentDomain queryByid(int stuId);//查一个
    void updateStudent(StudentDomain studentDomain);//修改
    //vip
    int updateVip(StudentDomain studentDomain);//充值vip次数
}

package com.github.dairycode.mybatis.dao;

import com.github.dairycode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    // 查询所有的学生信息,以及对应的老师的信息!
    List<Student> getStudent1();

    List<Student> getStudent2();
}

package com.github.dairycode.mybatis.dao;

import com.github.dairycode.mybatis.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from mybatis.teacher where id = #{id}")
    Teacher getTeacher(@Param("id") int id);
}

package com.fise.tan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fise.tan.config.MyMapper;
import com.fise.tan.entity.Student;
@Mapper
public interface StudentMapper extends MyMapper<Student> {

    List<Student> likeName(String name);

    Student getById(int id);

    String getNameById(int id);
    
    int add(Student stu);

}

package com.fise.tan.mapper;

import com.fise.tan.config.MyMapper;
import com.fise.tan.entity.Student;

public interface StudentMapper extends MyMapper<Student> {

//    List<Student> likeName(String name);
//
//    Student getById(int id);
//
//    String getNameById(int id);
    
    int add(Student stu);

}

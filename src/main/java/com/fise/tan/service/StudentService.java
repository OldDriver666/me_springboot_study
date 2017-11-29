package com.fise.tan.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.fise.tan.entity.Student;
import com.fise.tan.mapper.StudentMapper;

/**
 * Studeng Service
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年1月12日
 */
@Service
public class StudentService {


    @Autowired
    private StudentMapper studentMapper;


    public int testSave(){
        Student stu = new Student();
        stu.setAge(33);
        stu.setName("测试新增");
        return studentMapper.insert(stu);//这里调用的是基础Mapper中的insert方法
    }

}
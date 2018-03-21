package com.fise.tan.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fise.tan.entity.Student;
import com.fise.tan.mapper.StudentMapper;
import com.fise.tan.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/list")
    public List<Student> getStus(){
        logger.info("从数据库读取Student集合");
        return studentService.getList();
    }
    
    @RequestMapping("/likeName")
    public List<Student> likeName(@RequestParam String name){
        return studentMapper.likeName(name);
    }
}
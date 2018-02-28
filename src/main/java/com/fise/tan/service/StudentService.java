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
 * @author 单红宇(365384722)
 * @myblog http://blog.csdn.net/catoop/
 * @create 2016年1月12日
 */
@Service
public class StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Student> getList() {
		String sql = "SELECT ID,NAME, AGE   FROM STUDENT";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("ID"));
				stu.setAge(rs.getInt("AGE"));
				stu.setName(rs.getString("NAME"));
				return stu;
			}

		});
	}
	
	public int add() {
		String sql = "insert into student(id,name,age) values(4,'lileiqq',18);";
		return jdbcTemplate.update(sql);
	}

}
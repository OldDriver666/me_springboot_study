package com.fise.tan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fise.tan.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
public class TanApplicationTests {

	@Autowired
	private StudentService studentService;

	@Test
	public void contextLoads() {

		System.out.println("start");
		studentService.testSave();
	}

}

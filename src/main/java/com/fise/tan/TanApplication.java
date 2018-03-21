package com.fise.tan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan
@SpringBootApplication
public class TanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TanApplication.class, args);
	}
}

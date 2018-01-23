package com.fise.tan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {
	// 在Java类中创建 logger 实例
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	// 在方法中使用日志输出，如
	@RequestMapping("/log")
	public void logTest() {
		logger.debug("日志输出测试 Debug");
		logger.trace("日志输出测试 Trace");
		logger.info("日志输出测试 Info");
	}

	@RequestMapping
	public String hello() {
		return "Hello Spring-Boot";
	}

	@RequestMapping("/info")
	public Map<String, String> getInfo(@RequestParam String name) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		return map;
	}

	@RequestMapping("/list")
	public List<Map<String, String>> getList() {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (int i = 1; i <= 5; i++) {
			map = new HashMap<>();
			map.put("name", "Shanhy-" + i);
			list.add(map);
		}
		return list;
	}
}
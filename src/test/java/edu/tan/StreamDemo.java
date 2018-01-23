package edu.tan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.convert.converter.Converter;

public class StreamDemo {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User(20, "张三"));
		users.add(new User(22, "李四"));
		users.add(new User(10, "王五"));
//		Converter<String, Integer> converter = Integer::valueOf;
//		Integer converted = converter.convert("123");
//		System.out.println(converted); // 123
//		users.forEach(u -> {
//			if (u.getName().equals("张三")) {
//				u.setAge(18);
//			}});
		users.forEach(System.out::println);
		
//		Stream<User> stream = users.stream();
//		stream.filter(p -> p.getAge() > 20); //过滤年龄大于20的
//		stream.filter((User user) ->  user.getAge() > 20).map((User user) -> {return "50";});
//		long count = stream.filter((User user) ->  user.getAge() >= 20).map((User user) -> {return "50";}).count(); //返回流中元素的个数。
//		System.out.println(count);
	}

}
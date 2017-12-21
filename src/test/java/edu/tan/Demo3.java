package edu.tan;


@FunctionalInterface
public interface Demo3 {
	void call();

	default void fun() {
		System.out.println("我是接口的默认方法1中的代码");
	}

	default void fun2() {
		System.out.println("我是接口的默认方法2中的代码");
	}

}
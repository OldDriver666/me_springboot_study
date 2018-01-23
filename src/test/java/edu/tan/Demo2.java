package edu.tan;

public class Demo2 {
	public static void main(String[] args) {
		/*
		 * 方法引用
		 */
		Runnable runnable = Demo2::run;
		new Thread(runnable).start();

	}
	
	
	public static void run(){
		System.out.println("方法引用的代码...");
	}

}
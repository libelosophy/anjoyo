package com.jh.exception;

public class ExceptionTest {

	public ExceptionTest() {
		// TODO Auto-generated constructor stub
	}

	public void method1() throws Exception{ 
		System.out.println("method 1.");
		method2();
	}
	
	public void method2() throws Exception {
		System.out.println("method 2");	
		methodThrowException();
	}
	
	public void methodThrowException() throws Exception {

		System.out.println("method throws  exception.");
		int num = 5/0;
		System.out.println(num);
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		ExceptionTest exce = new ExceptionTest();
		try {
			exce.method1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		System.out.println("Exception test app");
	}
}
package com.jh.thread.communicate;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		Resource re = new Resource();
		Thread t1 = new Thread(re,"t1");
		Thread t2 = new Thread(re, "t2");
		t1.start();
		t2.start();
		
		while(true){
			System.out.println(Thread.currentThread().getName() + " --> " );
			Thread.sleep(1000);
		}
	}

}

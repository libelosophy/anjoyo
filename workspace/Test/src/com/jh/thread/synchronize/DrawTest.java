package com.jh.thread.synchronize;

public class DrawTest {

	public DrawTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Account ac = new Account(1001, "zzz", 800);
		Thread t1 = new Thread(new AccountOperator(ac, -800), "task1");
		Thread t2 = new Thread(new AccountOperator(ac, 200), "task2");
		t1.start();
		
		t2.start();
	}

}

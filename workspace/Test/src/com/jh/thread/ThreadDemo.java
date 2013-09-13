package com.jh.thread;


// 2013.09.04 java 多线程编程

public class ThreadDemo {

	public ThreadDemo() {
		
	}

	public static void main(String[] args) {
		
		Thread task2 = new Thread(new Task(),"Haha Thread1");
		task2.start();
		if( ! Thread.currentThread().isAlive()){
			System.out.println(Thread.currentThread().getName() + " 死了");
		}
		boolean count = true;
		
		for(int i = 0; i < 30; i++){
			
			if( ! task2.isAlive() & count){
				System.out.println( " task2 死了");
				count = false;
			}
				System.out.println(Thread.currentThread().getName() 
				+ ": " + i 
				+ " count " + Thread.activeCount());
				Thread.yield();
				try {
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
		
	}

}



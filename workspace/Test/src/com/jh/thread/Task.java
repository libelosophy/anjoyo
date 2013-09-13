package com.jh.thread;
public class Task implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 30; i++){
			if( ! Thread.currentThread().isAlive()){
				System.out.println(Thread.currentThread().getName() + " ËÀÁË");
			}
			System.out.println(Thread.currentThread().getName() 
					+ " - Runnable Task : " + i 
					+ " count " + Thread.activeCount());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

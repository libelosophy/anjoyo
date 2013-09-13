package com.jh.thread.communicate;


public class Resource implements Runnable {

	static private int count = 0;
	public Num nn = null; 
	
	static class Num{
		public int num;
		public Num(){
			num = 0;
		}	
	}
	
	public Resource() {
		nn = new Num();
	}

	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName() 
				+ " : " + nn.num++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}

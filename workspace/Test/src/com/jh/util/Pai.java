package com.jh.util;

public class Pai {

	public static final long TIME = (long)1E10;
	
	public Pai() {
		
	}

	public static void main(String[] args) {
		
		
		long count = 0;
		for( long i = 0; i < TIME ; i++){
			double x = Math.random();
			double y = Math.random();
			if(x*x + y*y < 1){
				count++;
			}
		}
		System.out.println("count : " + count + "\ttime: " + (double)TIME);
		
		double PI = 4.0 * (double)count / (double)(TIME);
		System.out.println(PI);
		
		
	}

}

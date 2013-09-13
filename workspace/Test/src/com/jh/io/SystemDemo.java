package com.jh.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SystemDemo {

	public SystemDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream("E:/log.txt");
		System.setOut(out);
		System.out.println("标准输出重定向。");
		
		
	}

}

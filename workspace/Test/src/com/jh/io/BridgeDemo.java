package com.jh.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BridgeDemo {

	private static final String filePath = "E:/output.txt";
	private static final String charsetName = "GB2312";
	
	public BridgeDemo() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) throws IOException {

		inputBridge(filePath, charsetName);
	}


	/**
	 * @throws IOException
	 */
	public static void inputBridge(String outPutFileName, String charsetName) throws IOException {
		InputStreamReader isr = null;
		BufferedReader br = null;
		String inputInfo = null;
		System.out.println("please input : ");
		
		try {
			isr = new InputStreamReader(System.in , charsetName);
			br = new BufferedReader(isr);
			System.setOut(new PrintStream(outPutFileName));
			while( (inputInfo = br.readLine()) != null){
				
				System.out.println(inputInfo);
			}
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
			if(isr != null){
				isr.close();
			}
		}
	}

}

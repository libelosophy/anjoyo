package com.jh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

	public SocketServerDemo() {
	
	}


	public static void main(String[] args) throws IOException {
	
		
		ServerSocket ss = new ServerSocket(12345);
		System.out.println("Server is ready... at localhost:12345");
		while(true){
			System.out.println("waiting ... ");
			Socket s = ss.accept();
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(s.getInputStream())
					);
			String line = br.readLine();
			System.out.println(line);
			
			br.close();
			s.close();
			
		}
		
	}
}

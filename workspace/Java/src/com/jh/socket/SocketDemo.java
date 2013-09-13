package com.jh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {

	private Socket s = null;
	private BufferedReader bf = null;
	PrintWriter out = null;
	BufferedReader wt = null;
	
	public SocketDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void  client() throws UnknownHostException, IOException{

		Socket s = null;
		while(true){
			s = new Socket( "127.0.0.1", 12345);
			
	PrintStream ps = new PrintStream(s.getOutputStream());
			
			ps.println("hello, we recieved u msg...");
			
			ps.close();
			s.close();
			
		}
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		client();
	}
}





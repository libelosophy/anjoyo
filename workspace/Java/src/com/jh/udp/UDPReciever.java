package com.jh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReciever {

	public UDPReciever() {
	}

	public static void main(String[] args) {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		byte[] buf = new byte[1024];
		try {
			ds = new DatagramSocket(30000); // 接收时指定端口
			dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			System.out.println("recieved.");
			System.out.println(new String(buf));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

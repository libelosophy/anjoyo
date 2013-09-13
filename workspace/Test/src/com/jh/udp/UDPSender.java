package com.jh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPSender {

	public UDPSender() {
	}

	public static void main(String[] args) throws SocketException {
		DatagramSocket ds = null;
		ds = new DatagramSocket(); // 先用第一第三个构造函数建立
		// 发送时需要指定 地址， 端口  接收时无需指定 理所当然
		DatagramPacket dp = null;
		InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 30000);
		String str = "hello world!!";
		byte[] buf = str.getBytes();
		try {
			dp = new DatagramPacket(buf, buf.length, addr);
			ds.send(dp);
			System.out.println("sended.");			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

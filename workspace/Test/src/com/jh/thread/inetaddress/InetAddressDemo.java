package com.jh.thread.inetaddress;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {

		
		// 得到本地主机地址
		String string = new String();
		string = InetAddress.getLocalHost().getHostAddress();
		System.out.println(string);   

		// 通过 主机名得到主机地址
		string = InetAddress.getByName("jh-ubt").getHostAddress();
		System.out.println(string);   
		
		// 通过网址
		string = InetAddress.getByName("www.baidu.com").getHostAddress();
		System.out.println(string);   
		
		string = Inet6Address.getByName("ipv6.google.com").getHostAddress();
		System.out.println(string);
		
	}

}

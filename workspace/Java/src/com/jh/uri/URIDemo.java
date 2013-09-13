package com.jh.uri;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URIDemo {

	public URIDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void test1() throws MalformedURLException {
		// URL url = new
		// URL("https://developers.google.com/java-dev-tools/download-wbpro?hl=zh-cn");
		// URL url = new
		// URL("https://www.google.com.hk/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&ved=0CDUQFjAB&url=http%3a%2f%2fblog%2ecsdn%2enet%2fei__nino%2farticle%2fdetails%2f7647889&ei=ejonUtG7GrGViAfT74GIBA&usg=AFQjCNF6L8Y6GhJEwbW73kq_2UQDdS9RuQ&bvm=bv.51495398,d.aGc");
		URL url = new URL("http://ipv6.google.com");
		System.out.println(url.getAuthority() + "\n getHost():  "
				+ url.getHost() + "\n getPort():  " + url.getPort()
				+ "\n getDefaultPort:  " + url.getDefaultPort()
				+ "\n getQuery:   " + url.getQuery() + "\n getPath:  "
				+ url.getPath() + "\n getRef(): " + url.getRef()
				+ "\n getUserInfo():  " + url.getUserInfo()
				+ "\n getProtocol():  " + url.getProtocol());
	}

	public static void main(String[] args) throws IOException {
		// test2();
		// test1() ;
		test3();
	}

	// 下载文件 download file  还可以做多线程下载 
	private static void test3() {
		URL url = null;
		String string = null;
		int i = 0;

		BufferedReader br = null;
		FileWriter fr = null;
		String s = null;
		try {
			url = new URL(
					"http://softdl1.tech.qq.com/soft/21/QQ2012Beta3-20120810.exe");

			string = url.openConnection().getContentType();
			System.out.println("\n\n content type : " + string);

			i = url.openConnection().getConnectTimeout();
			System.out.println("time out : " + i);
			
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer sb = new StringBuffer();
			
			do {
				s = br.readLine();
				sb.append(s);
//				System.out.println(s);
			} while (br.readLine() != null);

			fr = null;
			fr = new FileWriter("/home/jh/Downloads/qq2012.exe");
			fr.append(sb);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("download finished.");
		}
	}

	public static void test2() throws MalformedURLException, IOException {
		URL url = new URL("http://www.baidu.com");
		InputStreamReader is = new InputStreamReader(url.openStream());
		BufferedReader br = new BufferedReader(is);
		StringBuffer sb = new StringBuffer();
		do {
			String s = br.readLine();
			sb.append(s);
			System.out.println(sb);
		} while (br.readLine() != null);

		FileWriter fw = new FileWriter("E://baidu.html");
		fw.append(sb);
		fw.close();
	}

}

package com.jh.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

    	// FileInputStream and FileOutputStream are all  Byte streams
    	// 以一个整形的后 8 位存储
        FileInputStream in = null;
        FileOutputStream out = null;
        StringBuffer str = new StringBuffer("");
//        System.out.println(str);
        char cc = 120;
        System.out.println(cc);
        
        for(int i = 0; i<255; i++){
        	System.out.print((char)i + "\t");
        }
        
        
        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;
            for(int i = 0; i<255; i++){
            	System.out.print((char)i + "\t");
            	out.write(i);
            	//out.write((int)' ');
            }
            while ((c = in.read()) != -1) {
            	
            	
                out.write(c);
                str.append((char)c);
                System.out.println("The next byte : " + (char)c + 
                		"\n and its int num is :" + c );
                System.out.println("String : " + str);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
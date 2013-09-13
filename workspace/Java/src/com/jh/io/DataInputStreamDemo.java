package com.jh.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataInputStreamDemo {

	public DataInputStreamDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream in = new FileInputStream(new File("E:\\eclipse\\newfile.txt"));
		DataInputStream dataIn = new DataInputStream(in);

		OutputStream out = new FileOutputStream(new File("E:\\eclipse\\newfile_copy.txt"));
		DataOutputStream dataOut = new DataOutputStream( out );
		
		int i = 0;
		while( ( i = dataIn.readInt() )!= -1) {
			System.out.println(i);
		}
		if( in != null ){
			in.close();
		}
		if(dataOut != null){
			dataOut.close();
		}
		if( out != null ){
			out.close();
		}
		
		
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
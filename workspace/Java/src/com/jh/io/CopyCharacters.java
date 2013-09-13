package com.jh.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

/*    	java.io.Reader (implements java.io.Closeable, java.lang.Readable)
    	java.io.BufferedReader
    	java.io.LineNumberReader
    	java.io.CharArrayReader
    	java.io.FilterReader
    	java.io.PushbackReader
    	java.io.InputStreamReader
    		java.io.FileReader
    	java.io.PipedReader
    	java.io.StringReader
    	*/
    	
    	// characters streams 
    	
        characterDemo();
        String pathName = "e:/eclipse/newfile.txt";
        RandomAccessFile rdaf = new RandomAccessFile(pathName,"rw" );
        rdaf.seek(1);
        rdaf.writeChar('H');
        if(rdaf != null){
        	
        	rdaf.close();
        }

        
            	
            
       
    }

	/**
	 * @throws IOException
	 */
	public static void characterDemo() throws IOException {
		FileReader inputStream = null;
        FileWriter outputStream = null;
        BufferedReader br = null;
        
        
        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");
            br = new BufferedReader(inputStream);
            
            String line = null;
            while((line = br.readLine()) != null){
            	System.out.println(line);
            }
        }catch (IOException e){
        	e.printStackTrace();
        }finally{
        	if(br != null){
        		br.close();
        	}
        	if(inputStream != null){
        		inputStream.close();
        	}
        	if(outputStream != null){
        		outputStream.close();        		
        	}
        }
	}
}
package com.jh.exception;
// Note: This class won't compile by design!
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    public void writeList() {
        PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("OutFile.txt"));
			for (int i = 0; i < SIZE+1; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
            int num = 1/0;
            System.out.println("num");
            int num2 = 1/0;
            System.out.println("num2");
			}
		}		
		catch(IOException e){
			e.printStackTrace();	
			System.out.println("IOException");
		}
		catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		catch (IndexOutOfBoundsException e){
			
			System.out.println("IndexOutOfBoundsException ");
			//e.printStackTrace();
		}

        System.out.println("end");
        out.close();
    }
    
    public static void main(String ...args ){
    	ListOfNumbers listNum = new ListOfNumbers();
    	listNum.writeList();
    }
    
    
    
}
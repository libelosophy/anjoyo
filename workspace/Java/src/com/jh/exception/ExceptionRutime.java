package com.jh.exception;

public class ExceptionRutime extends ArithmeticException {

	public ExceptionRutime() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionRutime(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionRutime exc = new ExceptionRutime("exception my");
		exc.printStackTrace();
		System.out.println(exc.getMessage());
		System.out.println( exc.getLocalizedMessage() );
		int i = 1;
		if(i == 1){
			throw new ExceptionRutime("user defined exception");			
		}		
		i = 2;
		if(i == 2)
		{
		}
		
	}

}

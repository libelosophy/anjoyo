package com.jh.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {

	public LocaleDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		 	String language = new String("zh");
		 	String country = new String("CN");
			Locale currentLocale;
	        ResourceBundle messages;

	        currentLocale = new Locale(language, country);

	        messages = ResourceBundle.getBundle("info", currentLocale);
	        System.out.println(messages.getString("hello"));
	        
	        Locale enLocale = new Locale("en","US");
	        messages = ResourceBundle.getBundle("info", enLocale);
	        System.out.println(messages.getString("hello"));
	        
	        currentLocale = Locale.getDefault();
	        messages = ResourceBundle.getBundle("info", currentLocale);
	        System.out.println(messages.getString("hello"));
	        
	        
	        String str = Locale.CHINA.getISO3Country();
	        System.out.println(str);
	        
	        
	        
	}

}

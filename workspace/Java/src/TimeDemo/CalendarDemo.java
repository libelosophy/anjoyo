package TimeDemo;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CalendarDemo {

	public CalendarDemo() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Calendar.YEAR: " + Calendar.YEAR);
		Calendar calen = Calendar.getInstance();
		calen.set(2013, 8, 8);
		System.out.println(" Year : " + calen.get(Calendar.YEAR)
				+ ", Month :" +  calen.get(Calendar.MONTH)
				+ ", Day : " + calen.get(Calendar.DATE)				
				);
		System.out.println(calen.getTimeZone());
	}

}

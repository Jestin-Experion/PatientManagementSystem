package com.experion.pms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DOBToAge{
	
	private String dt;
	
	public int getAge(String date_y_MM_dd){
		
		dt=date_y_MM_dd;
		return convert(dt) ;
	}
	
	private int convert(String date_y_MM_dd){
		DateFormat dateFormat = new SimpleDateFormat("y-MM-dd"); 
		Date dates;
		try {
			dates = dateFormat.parse(date_y_MM_dd);
			 Calendar cal1 = Calendar.getInstance();
			    cal1.setTime(dates);
			    int year = cal1.get(Calendar.YEAR);
			    int month = cal1.get(Calendar.MONTH);
			    int day = cal1.get(Calendar.DAY_OF_MONTH);				    
				   
				   Calendar cal = new GregorianCalendar(year, (month+1), day);
				    Calendar now = new GregorianCalendar();
				    int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
				    if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
				        || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) > now
				            .get(Calendar.DAY_OF_MONTH))) {
				      res--;
				    }
			return res;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}		
	}
}
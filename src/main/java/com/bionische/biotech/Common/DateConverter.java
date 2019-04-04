package com.bionische.biotech.Common;

 

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	
	

	
	// To convert string to ymd format date
	public static String convertToYMD(String date) {
		
		String convertedDate=null;
		if(date!=null) {
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");
			
			
			Date dmyDate = dmySDF.parse(date);
			
			convertedDate=ymdSDF.format(dmyDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return convertedDate;

	}
	
public static String convertToDMY(String date) {
		
		String convertedDate=date;
		if(date!=null) {
		try {
			if(date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})") || date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2})"))
			{
				if (date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
	               
		        System.out.println("date format is y-m-d ");
		        
		        SimpleDateFormat ymdSDF2 = new SimpleDateFormat("yyyy-MM-dd");

				
				SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");

				Date ymdDate = ymdSDF2.parse(date);
				
				convertedDate=dmySDF.format(ymdDate);
		            
		        }else {
		            System.out.println("date format is   y-m-d H:m:s ");

		            
		            SimpleDateFormat ymdSDF2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					
					SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

					Date ymdDate = ymdSDF2.parse(date);
					
					convertedDate=dmySDF.format(ymdDate);
		            
		        }
			
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		return convertedDate;

	}
	
public static java.sql.Date convertToSqlDate(String date) {
		
		java.sql.Date convertedDate=null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");

			Date dmyDate = dmySDF.parse(date);
			
			System.out.println("converted util date commons "+dmyDate);

			
			

			convertedDate=new java.sql.Date(dmyDate.getTime());
			System.out.println("converted sql date commons "+convertedDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}

public static String currentDateAndTime() {

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	
	String currentDateAndTime=dateFormat.format(date);
	System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

	
	return currentDateAndTime;
	
	
	
}
	
	

}

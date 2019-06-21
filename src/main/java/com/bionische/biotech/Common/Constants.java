package com.bionische.biotech.Common;

import java.util.Random;

public class Constants {

	public static String SITE_URL="https://www.bionische.com/";
	public static String BIONISCHE_ICON="https://www.bionische.com/resources/images/favicon.ico";
	
	public static char[] generateOTP(int length) {
	      String numbers = "1234567890";
	      Random random = new Random();
	      char[] otp = new char[length];

	      for(int i = 0; i< length ; i++) {
	         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
	      }
	      return otp;
	   }
	
}

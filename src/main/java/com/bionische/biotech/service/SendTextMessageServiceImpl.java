package com.bionische.biotech.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class SendTextMessageServiceImpl implements SendTextMessageService{

	@Override
	public String sendTextSms(String subject, String message, String mobileNumber) {
		// TODO Auto-generated method stub
		String sResult = null;
		try 
		{
		// Construct data
		String phonenumbers=mobileNumber;
		String data="user=" + URLEncoder.encode("Bhavinbharatia", "UTF-8");
		data +="&password=" + URLEncoder.encode("Blueblue30!", "UTF-8");
		data +="&message=" + URLEncoder.encode(message, "UTF-8");
		data +="&sender=" + URLEncoder.encode(subject, "UTF-8");
		data +="&mobile=" + URLEncoder.encode(phonenumbers, "UTF-8");
		data +="&type=" + URLEncoder.encode("3", "UTF-8");
		System.out.println(data);
		//Send data
		String s="!@#$";
		System.out.println("s="+s);
		URL url = new URL("http://login.bulksmsgateway.in/sendmessage.php?"+data);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.flush();
		// Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		String sResult1="";
		while ((line = rd.readLine()) != null) 
		{
		// Process line...
		sResult1=sResult1+line+" ";
		}
		wr.close();
		rd.close();
		System.out.println("SMS Result is=="+sResult1);
		return sResult1;
		} 
		catch (Exception e)
		{
		System.out.println("Error SMS "+e);
		return "Error "+e;
		}
		
	}

}

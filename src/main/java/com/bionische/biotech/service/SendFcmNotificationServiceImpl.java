package com.bionische.biotech.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class SendFcmNotificationServiceImpl implements SendFcmNotificationService{

	@Override
	public ResponseEntity<String> notifyUser(String deviceToken, String title, String message, String timeStamp,int notificationType) {
		
		 String response;
			try {
				   String androidFcmKey="AAAA1rouwjc:APA91bFNBiVkWLcIgrtQBHrssxBBPfMBZgmwS6KVQ5AlrMpH1UYHU9wYn_rQqC0_W1-nN6yOO_igWzzzCUHRV6enWaa6-LUV9YVOiXyEAQLDixXZQ9TcbqxO637LNTDVt2fJ3Ale1lSh";
				   String androidFcmUrl="https://fcm.googleapis.com/fcm/send";
			//	   String deviceToken=""
				   	
				   

				   RestTemplate restTemplate = new RestTemplate();
				   HttpHeaders httpHeaders = new HttpHeaders();
				   httpHeaders.set("Authorization", "key=" + androidFcmKey);
				   httpHeaders.set("Content-Type", "application/json");
				   JSONObject data = new JSONObject();
				   JSONObject json = new JSONObject();

				   
				   String image="";
				  
				   data.put("title",title);
				   data.put("message",message);
				   data.put("image",image);
				   data.put("timestamp",timeStamp);
				   data.put("notificationType", notificationType);
				   
				   
			/*	   msg.put("title", "Title");
				   msg.put("message", "Message");
				   msg.put("notificationType", "Test");
				   msg.put("data", data );*/
				   
				  

				   json.put("data", data);
				   json.put("to", deviceToken);
				   System.out.println(json.toString());

				   HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(),httpHeaders);
				   response = restTemplate.postForObject(androidFcmUrl,httpEntity,String.class);
				   System.out.println(response);
					return new ResponseEntity<>(response, HttpStatus.OK);

				} catch (JSONException e) {
				   e.printStackTrace();
				   response=e.getMessage();
				}
		
			return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}

}

package com.bionische.biotech.service;

import java.io.IOException;

import java.io.InputStream;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsNotification;
import com.notnoop.apns.ApnsService;

@Service
public abstract class SendFcmNotificationServiceImpl implements SendFcmNotificationService{

	@Autowired
	Environment env;
	
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
	
	
	@RequestMapping(value = "/notifyiOSUser", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> notifyiOSUser(String deviceToken, String title, String message, String timeStamp,int notificationType) throws JSONException {
		
	
		 try {
			// String deviceToken="";
			 
			   InputStream inputStream = new ClassPathResource("test.p12").getInputStream();
			   ApnsService service;
			   
			   System.out.println("input stream "+inputStream.toString());
			   
			   
			   if (Arrays.asList(env.getActiveProfiles()).contains("pro")) {
			     service = APNS.newService().withCert(inputStream, "Password@123")
			                     .withProductionDestination().build();
			   } else {
			     service = APNS.newService().withCert(inputStream, "Password@123")
			                     .withSandboxDestination().build();
			   }
			   String payload = APNS.newPayload().customField("customData","customData")
			                          .alertBody("Message").build();
			   
			   ApnsNotification apns = service.push(deviceToken, payload);
			   
				return new ResponseEntity<>("success", HttpStatus.OK);

				
			   
			} catch (IOException e) {
			   e.printStackTrace();
			}
	
		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);

	}

}

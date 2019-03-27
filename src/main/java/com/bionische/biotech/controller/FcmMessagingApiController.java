package com.bionische.biotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.FcmNotification;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;

@RestController
public class FcmMessagingApiController {

	/*
	 * 1=Android 2=IOS 3=Web
	 */
	@Autowired
	Environment env;
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
 

	String androidFcmKey = "AAAA1rouwjc:APA91bFNBiVkWLcIgrtQBHrssxBBPfMBZgmwS6KVQ5AlrMpH1UYHU9wYn_rQqC0_W1-nN6yOO_igWzzzCUHRV6enWaa6-LUV9YVOiXyEAQLDixXZQ9TcbqxO637LNTDVt2fJ3Ale1lSh";
	String androidFcmUrl = "https://fcm.googleapis.com/fcm/send";

	
	
	@RequestMapping(value = { "/updateWebToken" }, method = RequestMethod.POST)
	public @ResponseBody Info updateWebToken(@RequestParam("userType")int userType, @RequestParam("userId")int userId) {
		Info info=new Info();
		
		if(userType==1)
		{
			doctorDetailsRepository.updateDoctorWebTokenByDoctorId(userId, "");
		}
		else if(userType==2) {
			 patientDetailsRepository.updateWebToken(userId, "");
		}
		else if(userType==3) {
			 
		}
		else if(userType==4) {
			 
		}
		
		return info;
	}
	
	@RequestMapping(value = { "/sendMessageToDoctor" }, method = RequestMethod.POST)
	public @ResponseBody Info sendMessageToDoctor(@RequestBody FcmNotification fcmNotification) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "key=" + androidFcmKey);
		httpHeaders.set("Content-Type", "application/json");
		Info info = new Info();

		info.setError(true);

		if (fcmNotification.getData().getToDeviceType() == 1 || fcmNotification.getData().getToDeviceType() == 3) {
			try {
				HttpEntity<FcmNotification> httpEntity = new HttpEntity<FcmNotification>(fcmNotification, httpHeaders);
				String response = restTemplate.postForObject(androidFcmUrl, httpEntity, String.class);
				System.out.println(response);

				info.setError(false);
				info.setMessage("Sent Successfuly");
			} catch (Exception e) {
				info.setError(true);
				info.setMessage("Failed to Send");
			}
		} else if (fcmNotification.getData().getToDeviceType() == 2) {
			// IOS
		}
		return info;
	}

	@RequestMapping(value = { "/sendMessageToPatient" }, method = RequestMethod.POST)
	public @ResponseBody Info sendMessageToPatient(@RequestBody FcmNotification fcmNotification) {

		Info info = new Info();

		info.setError(true);
		System.out.println("sendMessageToPatient");

		if (fcmNotification.getData().getToDeviceType() == 0) {

			PatientDetails patientDetails = patientDetailsRepository.findByPatientId(fcmNotification.getData().getId());
			int toDeviceType = patientDetails.getInt1();
			if (toDeviceType == 0)
				fcmNotification.getData().setToDeviceType(1);
			else
				fcmNotification.getData().setToDeviceType(2);
			fcmNotification.setTo(patientDetails.getWebToken());
			info = sendToAndroidUser(fcmNotification);
			fcmNotification.setTo(patientDetails.getString1());
		}

		if (fcmNotification.getData().getToDeviceType() == 1 || fcmNotification.getData().getToDeviceType() == 3) {
			info = sendToAndroidUser(fcmNotification);

		} else if (fcmNotification.getData().getToDeviceType() == 2) {
			// IOS
		}

		return info;
	}

	//Doctor to doctor video call
	
	
	
	@RequestMapping(value = { "/sendVideoCallToDoctor" }, method = RequestMethod.POST)
	public @ResponseBody Info sendVideoCallToDoctor(@RequestBody FcmNotification fcmNotification) {

		Info info = new Info();

		info.setError(true);
		System.out.println("sendVideoCallToDoctor");

	 

			DoctorDetails doctorDetails = doctorDetailsRepository.findByDoctorId(fcmNotification.getData().getId());
			int toDeviceType = doctorDetails.getInt1();
			if (toDeviceType == 0)
				fcmNotification.getData().setToDeviceType(1);
			else
				fcmNotification.getData().setToDeviceType(2);
			fcmNotification.setTo(doctorDetails.getWebToken());
			info = sendToAndroidUser(fcmNotification);
			fcmNotification.setTo(doctorDetails.getString1());
	 

		if (fcmNotification.getData().getToDeviceType() == 1 || fcmNotification.getData().getToDeviceType() == 3) {
			info = sendToAndroidUser(fcmNotification);

		} else if (fcmNotification.getData().getToDeviceType() == 2) {
			// IOS
		}

		return info;
	}

	
	
	
	Info sendToAndroidUser(FcmNotification fcmNotification) {
		 

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "key=" + androidFcmKey);
		httpHeaders.set("Content-Type", "application/json");
		 

	 

		Info info = new Info();
		 
		try {
			HttpEntity<FcmNotification> httpEntity = new HttpEntity<FcmNotification>(fcmNotification, httpHeaders);
			String response = restTemplate.postForObject(androidFcmUrl, httpEntity, String.class);
			System.out.println(response);
			System.out.println(response);

			info.setError(false);
			info.setMessage("Sent Successfuly");
		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);

			info.setMessage("Failed to Send");
			System.out.println("Error " + e.getMessage());
		}

		System.out.println("info " + info.toString());
		return info;
	}
	
	

}

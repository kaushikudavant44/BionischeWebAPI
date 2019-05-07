package com.bionische.biotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.GetVideoShared;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.model.VideoSharing;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.GetVideoSharedRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.PatientNotificationRepository;
import com.bionische.biotech.repository.VideoSharingRepository;
import com.bionische.biotech.service.SendEMailService;
import com.bionische.biotech.service.SendFcmNotificationService;
import com.bionische.biotech.service.SendTextMessageService;

@RestController
@RequestMapping(value = { "/videoSharing"})
public class VideoSharingApiController {

	@Autowired
	VideoSharingRepository videoSharingRepository;
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	@Autowired
	SendTextMessageService sendTextMessageService;
	@Autowired
	SendFcmNotificationService sendFcmNotificationService;
	@Autowired
	SendEMailService sendEMailService;
	@Autowired
	PatientNotificationRepository patientNotificationRepository;
	@Autowired
	GetVideoSharedRepository getVideoSharedRepository;
	
	@RequestMapping(value = { "/uploadVideo" }, method = RequestMethod.POST)
	public @ResponseBody VideoSharing uploadVideo(@RequestBody VideoSharing videoSharing) {
		
		try {
		VideoSharing videoSharingRes=videoSharingRepository.save(videoSharing);
		if(videoSharingRes!=null)
		{
			PatientDetails patientDetails=patientDetailsRepository.getPatientDetailsBYId(videoSharingRes.getPatientId());
			DoctorDetails doctorDetails=doctorDetailsRepository.findByDoctorId(videoSharingRes.getDoctorId());
			  PatientNotification patientNotification = new PatientNotification();
			  patientNotification.setPatientId(videoSharingRes.getPatientId());
			  String msg="Video Shared by Dr."+doctorDetails.getfName()+" "+doctorDetails.getlName();
			  patientNotification.setNotification(msg);
			  patientNotification.setStatus(0);
			  patientNotification.setString2("videoshare");
			  patientNotification.setString1(videoSharingRes.getTitle()+" Video Shared ");
			  patientNotification.setInt1(videoSharingRes.getVideoId());
				patientNotificationRepository.save(patientNotification);
				
				sendEMailService.sendMail("Biocare video shared",msg , patientDetails.getEmail());
				sendTextMessageService.sendTextSms(msg, patientDetails.getContactNo());
				
				
				sendFcmNotificationService.notificationOnWeb(patientDetails.getWebToken(),videoSharingRes.getTitle()+"  Video Shared", msg, "");
				try {
					if(patientDetails.getInt1()==0) {
				sendFcmNotificationService.notifyUser(patientDetails.getString2(), "Biocare Video Shared "+videoSharingRes.getTitle(), msg, DateConverter.currentDateAndTime(), 25);
					}
				 
						else if(patientDetails.getInt1()==1) {
							
							sendFcmNotificationService.notifyiOSUser(patientDetails.getString2(), "Biocare Video Shared", msg,  DateConverter.currentDateAndTime(), 25);
					}
				}
				catch (Exception e) {
					System.out.println("FCM Notification "+e.getMessage());// TODO: handle exception
				}
				return videoSharingRes;
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return  null;
	}
	
	
	
	/*@RequestMapping(value = { "/getSharedVideoById" }, method = RequestMethod.POST)
	public @ResponseBody VideoSharing getSharedVideoById(@RequestParam("videoId")int videoId) {
		
		try {
			return videoSharingRepository.findByVideoId(videoId);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}*/

	@RequestMapping(value = { "/getSharedVideoById" }, method = RequestMethod.POST)
	public @ResponseBody GetVideoShared getSharedVideoById(@RequestParam("videoId")int videoId) {
		
		try {
			return getVideoSharedRepository.getSharedVideoById(videoId);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping(value = { "/getLast10SharedVideo" }, method = RequestMethod.POST)
	public @ResponseBody List<GetVideoShared> getLast10SharedVideo(@RequestParam("patientId")int patientId) {
		
		try {
			return getVideoSharedRepository.getLast10SharedVideo(patientId);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}

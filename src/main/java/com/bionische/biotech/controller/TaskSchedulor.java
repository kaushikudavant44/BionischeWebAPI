package com.bionische.biotech.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.model.lab.LabAppointmentDetails;
import com.bionische.biotech.repository.AppointmentDetailsRepository;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.DoctorSubscriptionDetailsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.lab.LabAppointmentDetailsRepository;
import com.bionische.biotech.service.SendFcmNotificationService;
import com.bionische.biotech.service.SendTextMessageService;

@Component
public class TaskSchedulor {

	@Autowired
	DoctorSubscriptionDetailsRepository doctorSubscriptionDetailsRepository;

	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;

	@Autowired
	SendFcmNotificationService sendFcmNotificationService;
	
	@Autowired
	AppointmentTimeRepository appointmentTimeRepository;
	
	@Autowired
	AppointmentDetailsRepository appointmentDetailsRepository;
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	@Autowired
	LabAppointmentDetailsRepository labAppointmentDetailsRepository;
	 
	@Autowired
	SendTextMessageService sendTextMessageService;
	
	
	
	/*@Autowired
	AppointmentTimeRepository appointmentTimeRepository;
	
	@Autowired
	DocAvailableTimeRepository docAvailableTimeRepository;*/

	/* @Scheduled(cron = "	0 0 9 1/1 * ? *") */
   
	@Scheduled(cron = "0 0 9 * * *")
	public void sendSubscriptionNotification() {

		
		
		List<DoctorDetails> doctorDetailsList = doctorDetailsRepository.getDoctorOfExpiringSubscription();

		if (doctorDetailsList.isEmpty()) {

		} else {
				
			for (int i = 0; i < doctorDetailsList.size(); i++) {
				System.out.println("cncdsj");
				
				String subscriptionNotification = "Dr " + doctorDetailsList.get(i).getfName() + " "
						+ doctorDetailsList.get(i).getlName()+" your subscription is going to expire please subscribe again as early as possible if you already subscribe ignore notification.";
				
				if(doctorDetailsList.get(i).getInt1()==0) {
				sendFcmNotificationService.notifyUser(doctorDetailsList.get(i).getLocation(), "BIONISCHE",
						subscriptionNotification, DateConverter.currentDateAndTime(), 3);
				}else if(doctorDetailsList.get(i).getInt1()==1) {
				
					sendFcmNotificationService.notifyiOSUser(doctorDetailsList.get(i).getLocation(), "BIONISCHE",
							subscriptionNotification, DateConverter.currentDateAndTime(), 3);
				}

			}

		}

	}
	
	/**
	 * This schedular is used to give doctor consult appointment and lab appointment remainder to patient.
	 * Cron is execute every after half hour. 
	 */
	@Scheduled(cron = "0 0 * * * *")
	public void appointmentRemainder() {

		//System.out.println(new SimpleDateFormat("HH:00").format(Calendar.getInstance().getTime()));
		int curHour=Integer.parseInt(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));
		int curMin=Integer.parseInt(new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()));
		
		//System.out.println("current time"+curTime);
		
		int timeId1=curHour+curHour+3;
		int timeId2=curHour+curHour+4;
				
		if(timeId1>48) {
			
			timeId1=timeId1%48;
			timeId2=timeId2%48;
		}		
				
		List<Integer> timeList=new ArrayList<>();
		
		timeList.add(timeId1);
		timeList.add(timeId2);
		
		System.out.println("time id's= "+timeList.toString());
		/**
		 * This is for doctor appointment remainder to patient
		 */
		List<AppointmentDetails> appointmentDetailsList=appointmentDetailsRepository.findAppointmentsofPatients(timeList); 
		
		System.out.println("apointment id list+ "+appointmentDetailsList.toString());
		if(!appointmentDetailsList.isEmpty()) {
		for(int i=0;i<appointmentDetailsList.size();i++) {
			
		PatientDetails patientDetails=patientDetailsRepository.findByPatientId(appointmentDetailsList.get(i).getPatientId());
		String remainderNotification=patientDetails.getfName()+" "+patientDetails.getlName()+" your doctor appointment is start is in some time. Please be on time.";
	
		System.out.println("Appointment Success");
		sendTextMessageService.sendTextSms(remainderNotification, patientDetails.getContactNo());
		
		
		if(patientDetails.getInt1()==0) {
			
			sendFcmNotificationService.notifyUser(patientDetails.getString2(), "BIONISCHE",
					remainderNotification, DateConverter.currentDateAndTime(), 13);
			
		}else if(patientDetails.getInt1()==1) {
			
			sendFcmNotificationService.notifyiOSUser(patientDetails.getString2(), "BIONISCHE",
					remainderNotification, DateConverter.currentDateAndTime(), 13);
		}
			
		}
		}
		
		/**
		 * This is for lab appointment
		 */
		
		List<LabAppointmentDetails> getLabAppointmentList=labAppointmentDetailsRepository.findAppointmentofPatientByTimeIdList(timeList);
		
		if(!getLabAppointmentList.isEmpty()) {
			for(int i=0;i<getLabAppointmentList.size();i++) {
				PatientDetails patientDetails=patientDetailsRepository.findByPatientId(getLabAppointmentList.get(i).getPatientId());
				String remainderNotification=patientDetails.getfName()+" "+patientDetails.getlName()+" your lab appointment is start is in some time. Please be on time.";
				
				sendTextMessageService.sendTextSms(remainderNotification, patientDetails.getContactNo());
				
				if(patientDetails.getInt1()==0)  {
					
					sendFcmNotificationService.notifyUser(patientDetails.getString2(), "BIONISCHE",
							remainderNotification, DateConverter.currentDateAndTime(), 14);
					
				}else if(patientDetails.getInt1()==1) {
				
					sendFcmNotificationService.notifyiOSUser(patientDetails.getString2(), "BIONISCHE",
							remainderNotification, DateConverter.currentDateAndTime(), 14);
				
				}
			}
		}
		
		
	}
	
	/*@Scheduled(cron = "0 0 9 * * *")
	public void checkAvailableTimeofDay() {
		
		System.out.println("c");
		List<AppointmentTime> appointmentTimeList=new ArrayList<AppointmentTime>();
		List<DocAvailableTime> docAvailableTimeList=new ArrayList<DocAvailableTime>();
		try {
			appointmentTimeList=appointmentTimeRepository.findAll();
			docAvailableTimeList=docAvailableTimeRepository.getAvailableTimeofDoctorByCurDate();
			
			for(int i=0;i<docAvailableTimeList.size();i++) {
			List<String> availableTimeList = Arrays.asList(docAvailableTimeList.get(i).getAvailableTime().split(","));
			for(int j=0;j<appointmentTimeList.size();j++)
			{
				for(int k=0;k<availableTimeList.size();k++){
				if(appointmentTimeList.get(j).getTimeId()==Integer.parseInt(availableTimeList.get(k)))
				{
					appointmentTimeList.get(j).setInt1(docAvailableTimeList.get(i).getHospitalId());
					appointmentTimeList.get(j).setString1(docAvailableTimeList.get(i).getDate());
				 
				}   
			}
			}
			}
		
			System.out.println("App List"+appointmentTimeList.toString());
			if(appointmentTimeList.isEmpty()) {
				
				sendFcmNotificationService.notifyUser(doctorDetailsList.get(i).getLocation(), "BIONISCHE",
						subscriptionNotification, DateConverter.currentDateAndTime(), 3);
				
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
	}*/
	

}

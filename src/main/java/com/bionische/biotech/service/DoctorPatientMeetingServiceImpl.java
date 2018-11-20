package com.bionische.biotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorPatientMeeting;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.DoctorPatientMeetingRepository;
import com.bionische.biotech.repository.PatientNotificationRepository;
import com.bionische.biotech.repository.PrescriptionDetailsRepository;
@Service
public class DoctorPatientMeetingServiceImpl implements DoctorPatientMeetingService{

	@Autowired
	DoctorPatientMeetingRepository doctorPatientMeetingRepository;
	
	@Autowired
	PrescriptionDetailsRepository prescriptionDetailsRepository;
	
	@Autowired
	PatientNotificationRepository patientNotificationRepository;
	
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	
	
	@Override
	public Info insertDoctorPatientMeeting(DoctorPatientMeeting doctorPatientMeeting) {
		Info info=new Info();
		try {
		DoctorPatientMeeting doctorPatientMeetingResponse=doctorPatientMeetingRepository.save( doctorPatientMeeting);
		DoctorDetails doctorDetails = doctorDetailsRepository.findByDoctorId(doctorPatientMeeting.getDoctorId());
		
		PatientNotification patientNotification = new PatientNotification();
		
		patientNotification.setPatientId(doctorPatientMeeting.getPatientId());
		patientNotification.setNotification(doctorDetails.getfName()+" "+doctorDetails.getlName());					
		patientNotification.setStatus(0);
		patientNotification.setString1("Rate Your Doctor");
		patientNotification.setString2("drating");
		patientNotification.setInt1(doctorPatientMeeting.getDoctorId());
		patientNotificationRepository.save(patientNotification);
		
		int meetingId =doctorPatientMeetingResponse.getMeetId();
		
		for(int i=0;i<doctorPatientMeeting.getPrescriptionDetailsList().size();i++)
		{
			doctorPatientMeeting.getPrescriptionDetailsList().get(i).setMeetingId(meetingId);
			prescriptionDetailsRepository.save(doctorPatientMeeting.getPrescriptionDetailsList().get(i));
		}
		 if(doctorPatientMeetingResponse!=null)
		 {
			 info.setError(false);
			 info.setMessage("Success");
		 }
		 else {
			 info.setError(true); 
			 info.setMessage("Failed");
		 }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			 info.setError(true);
			 info.setMessage("Failed");
		}
			 return info;
	}
	
	

}

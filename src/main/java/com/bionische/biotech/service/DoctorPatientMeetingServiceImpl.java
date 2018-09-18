package com.bionische.biotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.model.DoctorPatientMeeting;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.DoctorPatientMeetingRepository;
import com.bionische.biotech.repository.PrescriptionDetailsRepository;
@Service
public class DoctorPatientMeetingServiceImpl implements DoctorPatientMeetingService{

	@Autowired
	DoctorPatientMeetingRepository doctorPatientMeetingRepository;
	
	@Autowired
	PrescriptionDetailsRepository prescriptionDetailsRepository;
	
	
	@Override
	public Info insertDoctorPatientMeeting(DoctorPatientMeeting doctorPatientMeeting) {
		Info info=new Info();
		try {
		DoctorPatientMeeting doctorPatientMeetingResponse=doctorPatientMeetingRepository.save( doctorPatientMeeting);
		System.out.println("doctorPatientMeetingResponse:"+doctorPatientMeetingResponse);
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

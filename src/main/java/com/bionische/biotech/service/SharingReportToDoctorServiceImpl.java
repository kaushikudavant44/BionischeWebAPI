package com.bionische.biotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorNotification;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.SharingReportWithDoc;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.DoctorNotificationRepository;
import com.bionische.biotech.repository.SharingReportWithDocRepository;
@Service
public class SharingReportToDoctorServiceImpl implements SharingReportToDoctorService{

	@Autowired
	DoctorNotificationRepository doctorNotificationRepository;
	
	@Autowired
	SharingReportWithDocRepository sharingReportWithDocRepository;
	
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	
	SendFcmNotificationService sendFcmNotificationService;
	
	@Override
	public Info shareReportToDoctor(SharingReportWithDoc sharingReportWithDoc) {


		System.out.println("Comming List "+sharingReportWithDoc.toString());
		SharingReportWithDoc sharingReportWithDocRes=new SharingReportWithDoc();
		
		sharingReportWithDocRes=sharingReportWithDocRepository.getSharingInfo(sharingReportWithDoc.getPatientId(),sharingReportWithDoc.getDoctorId());
		 
		Info info=new Info(); 
				
				try {
			
			if(sharingReportWithDocRes==null)
			{
			
			sharingReportWithDocRes=sharingReportWithDocRepository.save(sharingReportWithDoc); 
			
			 if(sharingReportWithDocRes!=null)
				{
					
					info.setError(false);
					info.setMessage("success");
				}
				else {
					info.setError(true);
					info.setMessage("failed");
				}
			}
			else
			{
			String reportId=","+sharingReportWithDoc.getReportId();	
			DoctorDetails doctorDetails=doctorDetailsRepository.findByDoctorId(sharingReportWithDocRes.getDoctorId());
		    int result=sharingReportWithDocRepository.updateReport(reportId,sharingReportWithDoc.getPatientId(),sharingReportWithDoc.getDoctorId());	
		    if(result>0)
			{
		    	DoctorNotification doctorNotification=new DoctorNotification();
				doctorNotification.setNotification("Pateint  id "+sharingReportWithDocRes.getPatientId()+" Shared His/her Reports.");
				doctorNotification.setDoctorId(sharingReportWithDocRes.getDoctorId());
				doctorNotification.setFcmNo(" ");
				doctorNotification.setStatus(0);
				doctorNotification.setString1("Patient Shre Report");
				doctorNotification.setInt1(sharingReportWithDocRes.getPatientId());
				doctorNotificationRepository.save(doctorNotification);
				String reportNotification="Pateint  id "+sharingReportWithDocRes.getPatientId()+" shared his/her reports with you.";
				
				if(doctorDetails.getInt1()==0) {
				sendFcmNotificationService.notifyUser(doctorDetails.getLocation(), "BIONISCHE", reportNotification, DateConverter.currentDateAndTime(), 7);
				}else if(doctorDetails.getInt1()==1) {
					
					sendFcmNotificationService.notifyiOSUser(doctorDetails.getLocation(), "BIONISCHE", reportNotification, DateConverter.currentDateAndTime(), 7);
				}
				info.setError(false);
				info.setMessage("success");
			}
			else {
				info.setError(true);
				info.setMessage("failed");
			}
			}
			
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
				
		return info;
	}

}

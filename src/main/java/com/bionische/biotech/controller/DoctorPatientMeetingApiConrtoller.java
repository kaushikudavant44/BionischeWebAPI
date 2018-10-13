package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.ConsultingDetails;
import com.bionische.biotech.model.DoctorPatientMeeting;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabNotification;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.LabTestsList;
import com.bionische.biotech.model.PatientCart;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.repository.ConsultingDetailsRepository;
import com.bionische.biotech.repository.PatientCartRepository;
import com.bionische.biotech.service.DoctorPatientMeetingService;

@RestController
public class DoctorPatientMeetingApiConrtoller {

	@Autowired
	DoctorPatientMeetingService  doctorPatientMeetingService;
	
	@Autowired
	PatientCartRepository patientCartRepository;
	
	@Autowired
	ConsultingDetailsRepository consultingDetailsRepository;
	
	// insert specialization
	@RequestMapping(value = { "/insertDoctoPatientMeeting" }, method = RequestMethod.POST)
	public @ResponseBody Info insertDoctoPatientMeeting(@RequestBody DoctorPatientMeeting doctorPatientMeeting) {
  
		
		return doctorPatientMeetingService.insertDoctorPatientMeeting(doctorPatientMeeting);
	}
	
	@RequestMapping(value = { "/addToCart" }, method = RequestMethod.POST)
	public @ResponseBody Info addToCart(@RequestBody PatientCart PatientCart)
	{ 
		Info info=new Info();
		PatientCart patientCart = new PatientCart();
		
		try {
			
			patientCart=patientCartRepository.save(patientCart);
			
			if(patientCart!=null)
			{
				info.setError(false);
				info.setMessage("success");
				
			}
			else {
				info.setError(true);
				info.setMessage("failed");				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
					}		
		return info;
	}
	
	@RequestMapping(value = { "/getAllCartProductsOfPatient"}, method = RequestMethod.POST)
	public @ResponseBody List<ConsultingDetails> getAllCartProductsOfPatient(@RequestParam("patientId") int patientId) {
		
		List<ConsultingDetails> cartProductDetails = new ArrayList<ConsultingDetails>();
		
		try {
			
			cartProductDetails = consultingDetailsRepository.getCartProductDetails(patientId);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
					}
	    return  cartProductDetails;
	}
	
	@RequestMapping(value = { "/getPatientCartCount"}, method = RequestMethod.POST)
	public @ResponseBody int getPatientCartCount(@RequestParam("patientId") int patientId) {
		
		
	    return  patientCartRepository.getPatientCartCount(patientId);
	}
	
	
}

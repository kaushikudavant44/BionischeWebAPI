package com.bionische.biotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PatientCallDetails;
import com.bionische.biotech.repository.PatientCallDetailsRepository;




@RestController
@RequestMapping(value = { "/videoCall"})
public class DoctorVideoApiController {

 
	
	@Autowired
	PatientCallDetailsRepository patientCallDetailsRepository;
	
	@RequestMapping(value = { "/updatePatientCallStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePatientCallStatus(@RequestParam("status")int status,@RequestParam("id")int id )
	{ 
		Info info =new Info();
		
		try {
			
			int res=patientCallDetailsRepository.updateStatus(id, status);
		 
		if(res>0)
		{
			info.setError(false);
			info.setMessage("update SuucessFully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem to Update");
		}
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Problem to Update");
		}
	
		
	
		return info;
	}
	
	
	 
	@RequestMapping(value = { "/getPatientMissCallDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientCallDetails> getPatientMissCallDetails
	(@RequestParam("patientId")int patientId )
	{ 
	 
		return patientCallDetailsRepository.getByPatientIdAndStatus(patientId, 0);
	}


	@RequestMapping(value = { "/updateSeenPatientMissCallStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSeenPatientMissCallStatus(@RequestParam("status")int status,@RequestParam("patientId")int patientId )
	{ 
		Info info =new Info();
		
		try {
			
			int res=patientCallDetailsRepository.updateStatusByPatientId(patientId, status);
		 
		if(res>0)
		{
			info.setError(false);
			info.setMessage("update SuucessFully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem to Update");
		}
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Problem to Update");
		}
	
		
	
		return info;
	}
	
}

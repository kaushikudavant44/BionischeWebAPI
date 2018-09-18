package com.bionische.biotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.MedicalLogin;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientLogin;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
@RestController
public class MedicalApiController {
	@Autowired
	MedicalDetailsRepository medicalDetailsRepository;
	
	@RequestMapping(value = { "/insertMedicalDetails" }, method = RequestMethod.POST)
	public @ResponseBody MedicalDetails insertMedicalDetails(@RequestBody MedicalDetails MedicalDetails)
	{
		System.out.println("Comming Listmeeeeedddiiiicccaaalll "+MedicalDetails.toString());
		MedicalDetails MedicalDetailsRes=new MedicalDetails();
		 
		try {
			MedicalDetailsRes=medicalDetailsRepository.save(MedicalDetails); 
		System.out.println(MedicalDetailsRes.toString());
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return MedicalDetailsRes;
	}
	
	@RequestMapping(value = { "/medicalDetailsById" }, method = RequestMethod.POST)
	public @ResponseBody MedicalDetails medicalDetailsById(@RequestParam("medicalId") int medicalId)
	{
		System.out.println("Comming List "+medicalId);
		MedicalDetails MedicalDetailsRes=new MedicalDetails();
		 
		try {
			MedicalDetailsRes=medicalDetailsRepository.findByMedicalId(medicalId); 
		System.out.println(MedicalDetailsRes.toString());
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return MedicalDetailsRes;
	}
	
	
	
	@RequestMapping(value = { "/medicalLoginProcess" }, method = RequestMethod.POST)
	public @ResponseBody MedicalLogin medicalLoginProcess(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		
		
		MedicalDetails medicalDetails=new MedicalDetails();
		
		MedicalLogin medicalLogin=new MedicalLogin();
		Info info=new Info();
		
		medicalDetails=medicalDetailsRepository.findByUserNameAndPassword(userName,password);
		
		
		if(medicalDetails!=null)
		{
			 
			//patientDetails=patientDetailsRepository.findByUserNameAndPassword(userName, password);
			System.out.println("List "+medicalDetails.toString());
			if(medicalDetails.getPassword().equals(password))
			{
				medicalLogin.setMedicalDetails(medicalDetails);
				info.setError(false);
				info.setMessage("Login Successfull");
				medicalLogin.setInfo(info);
			}
			else{
				info.setError(true);
				info.setMessage("Please enter valid credential");
				medicalLogin.setInfo(info);
			}
		}
		else {
			info.setError(true);
			info.setMessage("Patient Not Register");
			medicalLogin.setInfo(info);
		}
 
		
		
		System.out.println("res "+medicalLogin.toString());
		return medicalLogin;
	}

	@RequestMapping(value = { "/passwordMedicalValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info passwordMedicalValidation(@RequestParam("medicalId") int medicalId,@RequestParam("password") String password)
	
	{
		Info info=new Info();
		MedicalDetails medicalDetailssRes=new MedicalDetails();
	 try {
		 medicalDetailssRes=	medicalDetailsRepository.passwordMedValidation(medicalId,password);
		
		 if(medicalDetailssRes!=null)
			{
				
				info.setError(false);
				info.setMessage("Success");
			}
			else {
				info.setError(true);
				info.setMessage("failed");
			}	 
		 
	 }
	 catch (Exception e) {
		 System.out.println(e.getMessage());
	}
	 return info;
	 
	}
	
	
	//change medical password
	@RequestMapping(value = { "/changeMedicalPassword" }, method = RequestMethod.POST)
	public @ResponseBody Info changeMedicalPassword(@RequestParam("medicalId") int medicalId,@RequestParam("newPassword") String newPassword)
	
	{
		int res;
		
		Info info=new Info();
		try {
			res = medicalDetailsRepository.updateNewPassword(medicalId,newPassword);
			if(res>0)
			{
				info.setMessage("success");
				info.setError(false);
			}
			else {
				info.setMessage("failed");
				info.setError(true);
			}
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return info;
	 
	}
	
	//change lab password
		@RequestMapping(value = { "/updatePharmacyProfilePic" }, method = RequestMethod.POST)
		public @ResponseBody Info updatePharmacyProfilePic(@RequestParam("medicalId") int medicalId,@RequestParam("profilePhoto") String profilePhoto)
		
		{
			int res;
			
			Info info=new Info();
			try {
				res = medicalDetailsRepository.updateProfilePic(medicalId,profilePhoto);
				if(res>0)
				{
					info.setMessage("success");
					info.setError(false);
				}
				else {
					info.setMessage("failed");
					info.setError(true);
				}
				 
			}
			catch (Exception e) {
			e.printStackTrace();
			}
	        return info;
		 
		}
}

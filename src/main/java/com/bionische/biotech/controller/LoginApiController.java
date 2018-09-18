package com.bionische.biotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorLogin;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.LabLogin;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientLogin;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;

@RestController
public class LoginApiController {

	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	 
	@Autowired
	LabDetailsRepository labDetailsRepository;
	
	@RequestMapping(value = { "/patientLoginProcess" }, method = RequestMethod.POST)
	public @ResponseBody PatientLogin patientLoginProcess(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		
		System.out.println("dttfy;"+userName);
		PatientDetails patientDetails=new PatientDetails();
		
		PatientLogin patientLogin=new PatientLogin();
		Info info=new Info();
		
		patientDetails=patientDetailsRepository.getPatientLogin(userName);
		if(patientDetails!=null)
		{
			 
			//patientDetails=patientDetailsRepository.findByUserNameAndPassword(userName, password);
			System.out.println("List "+patientDetails.toString());
			if(patientDetails.getPassword().equals(password))
			{
				patientLogin.setPatientDetails(patientDetails);
				info.setError(false);
				info.setMessage("Login Successfull");
				patientLogin.setInfo(info);
			}
			else{
				info.setError(true);
				info.setMessage("Please enter valid credential");
				patientLogin.setInfo(info);
			}
		}
		else {
			info.setError(true);
			info.setMessage("Patient Not Register");
			patientLogin.setInfo(info);
		}
 
		
		
		System.out.println("res "+patientLogin.toString());
		return patientLogin;
	}
		
	@RequestMapping(value = { "/doctorLoginProcess" }, method = RequestMethod.POST)
	public @ResponseBody DoctorLogin doctorLoginProcess(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		System.out.println("hbd:"+userName);
		
		DoctorDetails doctorDetails=new DoctorDetails(); 
		
		DoctorLogin doctorLogin=new DoctorLogin();
		Info info=new Info();
		try {
		doctorDetails=doctorDetailsRepository.getLoginUserName(userName);
		System.out.println(userName+" Password  "+password+"   List  "+doctorDetails.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		System.out.println(e.getMessage());	// TODO: handle exception
		}
		if(doctorDetails!=null)
		{
			 
			//patientDetails=patientDetailsRepository.findByUserNameAndPassword(userName, password);
			System.out.println(userName+" Password  "+password+"   List  "+doctorDetails.toString());
			 
			if(doctorDetails.getPassword().equals(password))
			{
				doctorLogin.setDoctorDetails(doctorDetails);
				info.setError(false);
				info.setMessage("Login Successfull");
				doctorLogin.setInfo(info);
			}
			else{
				info.setError(true);
				info.setMessage("Please enter valid credential");
				doctorLogin.setInfo(info);
			}
		}
		else {
			info.setError(true);
			info.setMessage("Doctor Not Register");
			doctorLogin.setInfo(info);
		}
 
		
		
		
		return doctorLogin;
	}
		
	
	@RequestMapping(value = { "/labLoginProcess" }, method = RequestMethod.POST)
	public @ResponseBody LabLogin labLoginProcess(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		
		
		LabDetails labDetails=new LabDetails(); 
		
		LabLogin labLogin=new LabLogin();
		Info info=new Info();
		
		labDetails=labDetailsRepository.findByUserNameAndDelStatus(userName, 0);
		if(labDetails!=null)
		{
			 
			//patientDetails=patientDetailsRepository.findByUserNameAndPassword(userName, password);
			
			if(labDetails.getPassword().equals(password))
			{
				labLogin.setLabDetails(labDetails);
				info.setError(false);
				info.setMessage("Login Successfull");
				labLogin.setInfo(info);
			}
			else{
				info.setError(true);
				info.setMessage("Please enter valid credential");
				labLogin.setInfo(info);
			}
		}
		else {
			info.setError(true);
			info.setMessage("Doctor Not Register");
			labLogin.setInfo(info);
		}
 
		
		
		
		return labLogin;
	}
	
	@RequestMapping(value = { "/passwordValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info passwordValidation(@RequestParam("patientId") int patientId,@RequestParam("password") String password)
	
	{
		Info info=new Info();
		PatientDetails patientDetailsRes=new PatientDetails();
	 try {
		 patientDetailsRes=	patientDetailsRepository.passwordValidation(patientId,password);
		
		 if(patientDetailsRes!=null)
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
	
	@RequestMapping(value = { "/passwordDocValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info passwordDocValidation(@RequestParam("doctorId") int doctorId,@RequestParam("password") String password)
	
	{
		Info info=new Info();
		DoctorDetails doctorDetailsRes=new DoctorDetails();
	 try {
		 doctorDetailsRes=	doctorDetailsRepository.passwordDocValidation(doctorId,password);
		
		 if(doctorDetailsRes!=null)
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
	
	
	@RequestMapping(value = { "/passwordLabValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info passwordLabValidation(@RequestParam("labId") int labId,@RequestParam("password") String password)
	
	{
		Info info=new Info();
		LabDetails labDetailsRes=new LabDetails();
	 try {
		 labDetailsRes=	labDetailsRepository.passwordLabValidation(labId,password);
		
		 if(labDetailsRes!=null)
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
	
	
}

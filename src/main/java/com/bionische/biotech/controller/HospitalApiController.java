package com.bionische.biotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.HospitalDetailsRepository;
@RestController
public class HospitalApiController {
	@Autowired
	HospitalDetailsRepository hospitalDetailsRepository;
	
	@RequestMapping(value = { "/getHospitalById" }, method = RequestMethod.POST)
	public @ResponseBody HospitalDetails getHospitalById(@RequestParam("hospitalId") int hospitalId)
	{
		System.out.println("Comming List "+hospitalId);
		HospitalDetails hospitalDetailsRes=new HospitalDetails();
		 
		try {
			hospitalDetailsRes=hospitalDetailsRepository.findByHospitalId(hospitalId); 
		System.out.println(hospitalDetailsRes.toString());
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	
		return hospitalDetailsRes;
	}


@RequestMapping(value = { "/insertHospitalDetails" }, method = RequestMethod.POST)
public @ResponseBody HospitalDetails insertHospitalDetails(@RequestBody HospitalDetails hospitalDetails)
{
System.out.println("Comming List "+hospitalDetails.toString());
HospitalDetails hospitalDetailsRes=new HospitalDetails();

try {
hospitalDetailsRes=hospitalDetailsRepository.save(hospitalDetails); 
System.out.println(hospitalDetails.toString());

}

catch (Exception e) {
System.out.println(e.getMessage());
 
}

return hospitalDetailsRes;
}
	
	/*
	@RequestMapping(value = { "/insertHospitalsDetails" }, method = RequestMethod.POST)
	public @ResponseBody HospitalDetails insertHospitalsDetails(@RequestBody HospitalDetails hospitalDetails)
	{
		System.out.println("Comming List "+hospitalDetails.toString());
		HospitalDetails hospitalDetailsRes=new HospitalDetails();
		 
		try {
			hospitalDetailsRes=hospitalDetailsRepository.save(hospitalDetails); 
		System.out.println(hospitalDetailsRes.toString());
		   
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return hospitalDetailsRes;
	}*/
	/*@RequestMapping(value = { "/getHospitalDetailsBycityId" }, method = RequestMethod.POST)
	public @ResponseBody HospitalDetails getHospitalDetailsBycityId(@RequestParam("hospitalCityId") int hospitalCityId)
	
	{
		HospitalDetails hospitalDetailsRes=new HospitalDetails();
	 try {
		 hospitalDetailsRes=	hospitalDetailsRepository.findByHospitalCityId(hospitalCityId);
		
	 }
	 catch (Exception e) {
System.out.println(e.getMessage());
	}
	 return hospitalDetailsRes;
	 
	}
	*/
}
  
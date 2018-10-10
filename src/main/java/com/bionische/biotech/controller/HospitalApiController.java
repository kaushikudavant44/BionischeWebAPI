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

import com.bionische.biotech.model.DoctorHospitalDetails;
import com.bionische.biotech.model.GetHospitalDetails;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.repository.DoctorHospitalDetailsRepository;
import com.bionische.biotech.repository.GetHospitalDetailsRepository;
import com.bionische.biotech.repository.HospitalDetailsRepository;

@RestController
public class HospitalApiController {
	@Autowired
	HospitalDetailsRepository hospitalDetailsRepository;

	@Autowired
	DoctorHospitalDetailsRepository doctorHospitalDetailsRepository;
	
	@Autowired
	GetHospitalDetailsRepository getHospitalDetailsRepository;
	
	
	@RequestMapping(value = { "/getHospitalById" }, method = RequestMethod.POST)
	public @ResponseBody HospitalDetails getHospitalById(@RequestParam("hospitalId") int hospitalId) {
		
	HospitalDetails getHospitalDetails=new HospitalDetails();
		

		try {
			getHospitalDetails = hospitalDetailsRepository.findByHospitalId(hospitalId);
			System.out.println(getHospitalDetails.toString());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return getHospitalDetails;
	}
	
	@RequestMapping(value = { "/getHospitalByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHospitalDetails> getHospitalByDoctorId(@RequestParam("doctorId") int doctorId) {
		
		List<GetHospitalDetails> getHospitalDetailsList = new ArrayList<GetHospitalDetails>();

		try {
			getHospitalDetailsList = getHospitalDetailsRepository.findHospitalByDoctorId(doctorId);
			System.out.println(getHospitalDetailsList.toString());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return getHospitalDetailsList;
	}

	@RequestMapping(value = { "/insertHospitalDetails" }, method = RequestMethod.POST)
	public @ResponseBody HospitalDetails insertHospitalDetails(@RequestBody HospitalDetails hospitalDetails) {
		System.out.println("Comming List " + hospitalDetails.toString());
		HospitalDetails hospitalDetailsRes = new HospitalDetails();

		try {
			hospitalDetailsRes = hospitalDetailsRepository.save(hospitalDetails);
			System.out.println(hospitalDetails.toString());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return hospitalDetailsRes;
	}

	/*
	 * @RequestMapping(value = { "/insertHospitalsDetails" }, method =
	 * RequestMethod.POST) public @ResponseBody HospitalDetails
	 * insertHospitalsDetails(@RequestBody HospitalDetails hospitalDetails) {
	 * System.out.println("Comming List "+hospitalDetails.toString());
	 * HospitalDetails hospitalDetailsRes=new HospitalDetails();
	 * 
	 * try { hospitalDetailsRes=hospitalDetailsRepository.save(hospitalDetails);
	 * System.out.println(hospitalDetailsRes.toString());
	 * 
	 * }
	 * 
	 * catch (Exception e) { System.out.println(e.getMessage());
	 * 
	 * } return hospitalDetailsRes; }
	 */
	/*
	 * @RequestMapping(value = { "/getHospitalDetailsBycityId" }, method =
	 * RequestMethod.POST) public @ResponseBody HospitalDetails
	 * getHospitalDetailsBycityId(@RequestParam("hospitalCityId") int
	 * hospitalCityId)
	 * 
	 * { HospitalDetails hospitalDetailsRes=new HospitalDetails(); try {
	 * hospitalDetailsRes=
	 * hospitalDetailsRepository.findByHospitalCityId(hospitalCityId);
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * hospitalDetailsRes;
	 * 
	 * }
	 */
	
	@RequestMapping(value = { "/insertDoctorHospital" }, method = RequestMethod.POST)
	public @ResponseBody DoctorHospitalDetails insertDoctorHospital(@RequestBody DoctorHospitalDetails doctorHospitalDetails) {
	
		DoctorHospitalDetails doctorHospitalDetailsRes = new DoctorHospitalDetails();

		try {
			doctorHospitalDetailsRes = doctorHospitalDetailsRepository.save(doctorHospitalDetails);
			System.out.println(doctorHospitalDetailsRes.toString());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return doctorHospitalDetailsRes;
	}
}

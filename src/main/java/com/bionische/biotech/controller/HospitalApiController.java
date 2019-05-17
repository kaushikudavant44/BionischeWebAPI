package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.ResourceNotFoundException;
import com.bionische.biotech.adminpanel3d.model.Info;
import com.bionische.biotech.model.DoctorHospitalDetails;
import com.bionische.biotech.model.GetHospitalDetails;
import com.bionische.biotech.model.GetHospitalDetailsByType;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.repository.DoctorHospitalDetailsRepository;
import com.bionische.biotech.repository.GetHospitalDetailsByTypeRepository;
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
	
	@Autowired
	GetHospitalDetailsByTypeRepository getHospitalDetailsByTypeRepository;
	
	@RequestMapping(value = { "/getHospitalById" }, method = RequestMethod.POST)
	public @ResponseBody HospitalDetails getHospitalById(@RequestParam("hospitalId") int hospitalId) {
		
	HospitalDetails getHospitalDetails=new HospitalDetails();
		

		try {
			getHospitalDetails = hospitalDetailsRepository.findByHospitalIdAndDelstatus(hospitalId,0);
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
	
		 

		try {
			DoctorHospitalDetails doctorHospitalDetailsResponse=doctorHospitalDetailsRepository.findByDoctorIdAndHospitalId(doctorHospitalDetails.getDoctorId(),doctorHospitalDetails.getHospitalId());
			if(doctorHospitalDetailsResponse!=null) { 
				doctorHospitalDetails.setId(doctorHospitalDetailsResponse.getId());
				if(doctorHospitalDetailsResponse.getDelStatus()==1)
					doctorHospitalDetails.setDelStatus(0);
			}
			DoctorHospitalDetails	doctorHospitalDetailsRes = doctorHospitalDetailsRepository.save(doctorHospitalDetails);
			System.out.println(doctorHospitalDetailsRes.toString());
			return doctorHospitalDetailsRes;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return null;
	}
	
	@RequestMapping(value = { "/getAllHospitalByType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHospitalDetails> getAllHospitalByType(@RequestParam("type") int type) {
		
		List<GetHospitalDetails> getHospitalDetailsList = new ArrayList<GetHospitalDetails>();

		try {
			getHospitalDetailsList = getHospitalDetailsRepository.findHospitalByType(type);
			System.out.println(getHospitalDetailsList.toString());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return getHospitalDetailsList;
	}
	
	
	@RequestMapping(value = { "/getHospitalsByTypeAndKeyword" }, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<GetHospitalDetails>> getHospitalsByTypeAndKeyword(@RequestParam("type") int type, @RequestParam("keyword") String keyword) {
		
		List<GetHospitalDetails> getHospitalDetailsList = new ArrayList<GetHospitalDetails>();

	 
			getHospitalDetailsList = getHospitalDetailsRepository.getHospitalsByTypeAndKeyword(type,keyword);
		 
			if (getHospitalDetailsList.isEmpty()) {
				throw new ResourceNotFoundException("Hospital", "keyword", keyword);
			} else {

				return new ResponseEntity<List<GetHospitalDetails>>(getHospitalDetailsList, HttpStatus.OK);
	 
			}	 
	}
	
	
	
	@RequestMapping(value = { "/getHospitalByType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHospitalDetailsByType> getHospitalByType(@RequestParam("type") int type) {
		
		List<GetHospitalDetailsByType> getHospitalDetailsByTypeList = new ArrayList<GetHospitalDetailsByType>();

		try {
			getHospitalDetailsByTypeList = getHospitalDetailsByTypeRepository.findHospitalByType(type);
			System.out.println(getHospitalDetailsByTypeList.toString());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return getHospitalDetailsByTypeList;
	}
	
	@RequestMapping(value = { "/deleteClinicById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteClinicById(@RequestParam("hospitalId") int hospitalId,@RequestParam("doctorId") int doctorId) {
		
		Info info = new Info();

		
		try {
			int delStatus = doctorHospitalDetailsRepository.deleteDoctorHospital(hospitalId,doctorId,1);
			
			if(delStatus!=0) {
				info.setMessage("Clinic Delete Successfully");
				
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return info;
	}
	
	@RequestMapping(value = { "/deleteDoctorHospitalById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDoctorHospitalById(@RequestParam("hospitalId") int hospitalId,@RequestParam("doctorId") int doctorId) {
		
		Info info = new Info();

		
		try {
			
			int delStatus = doctorHospitalDetailsRepository.deleteDoctorHospital(hospitalId,doctorId,1);
			if(delStatus!=0) {
				info.setMessage("Hospital Delete Successfully");
				
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return info;
	}
	
	
	
}

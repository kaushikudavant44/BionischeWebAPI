package com.bionische.biotech.adminpanel3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.adminpanel3d.model.Category3DModel;
import com.bionische.biotech.adminpanel3d.model.Category3DModelList;
import com.bionische.biotech.adminpanel3d.model.Info;
import com.bionische.biotech.adminpanel3d.model.VaccinationDetailss;
import com.bionische.biotech.adminpanel3d.repository.VaccinationDetailssRepository;
import com.bionische.biotech.model.VaccinationAgeDetails;
import com.bionische.biotech.repository.VaccinationAgeDetailsRepository;


@RestController
public class VaccinationController {

	@Autowired
	VaccinationAgeDetailsRepository vaccinationAgeDetailsRepository;
	
	@Autowired
	VaccinationDetailssRepository vaccinationDetailssRepository;
	
	@RequestMapping(value = { "/insertVaccinationAgeDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<VaccinationAgeDetails> insertVaccinationAgeDetails(@RequestBody VaccinationAgeDetails VaccinationAgeDetails) {

		VaccinationAgeDetails VaccinationAgeDetailsRes= new VaccinationAgeDetails();
		List<VaccinationAgeDetails> VaccinationAgeDetailsList = new ArrayList<VaccinationAgeDetails>();
				
		try {
			 VaccinationAgeDetailsRes=vaccinationAgeDetailsRepository.save(VaccinationAgeDetails);
			 if(VaccinationAgeDetailsRes!=null)
			 {
			 VaccinationAgeDetailsList =  vaccinationAgeDetailsRepository.findAll();
			 }
		}catch(Exception e) {
			
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return VaccinationAgeDetailsList;
		
	}
	
	@RequestMapping(value = { "/getAllVaccinationAgeDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<VaccinationAgeDetails> getAllVaccinationAgeDetails() {
		
		List<VaccinationAgeDetails> VaccinationAgeDetailsList = new ArrayList<VaccinationAgeDetails>();
				
		try {
			
			 VaccinationAgeDetailsList =  vaccinationAgeDetailsRepository.findAll();
		}catch(Exception e) {
			
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return VaccinationAgeDetailsList;
		
	}
	
	@RequestMapping(value = { "/deleteVaccinationAgeDetailsById" }, method = RequestMethod.POST)
	public @ResponseBody List<VaccinationAgeDetails> deleteVaccinationAgeDetailsById(@RequestParam("VaccinationAgeDetailsId") int VaccinationAgeDetailsId) {
		
		
		List<VaccinationAgeDetails> VaccinationAgeDetailsList = new ArrayList<VaccinationAgeDetails>();
				
		try {
			 int res=vaccinationAgeDetailsRepository.deleteVaccinatioAgeById(VaccinationAgeDetailsId);	
			 if(res>0)
			 {
			 VaccinationAgeDetailsList =  vaccinationAgeDetailsRepository.findAll();
			 }
		}catch(Exception e) {
			
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return VaccinationAgeDetailsList;
		
	}
	
	@RequestMapping(value = { "/insertVaccinationDetailss" }, method = RequestMethod.POST)
	public @ResponseBody List<VaccinationDetailss> insertVaccinationDetailss(@RequestBody VaccinationDetailss VaccinationDetailss) {
		
		VaccinationDetailss VaccinationAgeDetailsRes= new VaccinationDetailss();
		List<VaccinationDetailss> vaccinationDetailsList = new ArrayList<VaccinationDetailss>();
				
		try {
			 VaccinationAgeDetailsRes=vaccinationDetailssRepository.save(VaccinationDetailss);
			 if(VaccinationAgeDetailsRes!=null)
			 {
				 vaccinationDetailsList =  vaccinationDetailssRepository.getAllVaccinations();
			 }
		}catch(Exception e) {
			
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return vaccinationDetailsList;
		
	}
	

	@RequestMapping(value = { "/getAllVaccinationDetails" }, method = RequestMethod.GET)
	public @ResponseBody List<VaccinationDetailss> getAllVaccinationDetails() {
		
		List<VaccinationDetailss> vaccinationDetailsList = new ArrayList<VaccinationDetailss>();
				
		try {
			vaccinationDetailsList=vaccinationDetailssRepository.getAllVaccinations();
			System.out.println("gvhbvaccinationDetailsList:"+vaccinationDetailsList.toString());
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return vaccinationDetailsList;
		
	}
	
	@RequestMapping(value = { "/deleteVaccinationDetailss" }, method = RequestMethod.POST)
	public @ResponseBody List<VaccinationDetailss> deleteVaccinationDetailss(@RequestParam("vaccinationId") int vaccinationId) {
		
		
		List<VaccinationDetailss> vaccinationDetailsList = new ArrayList<VaccinationDetailss>();
				
		try {
			 int res=vaccinationDetailssRepository.deleteVaccinationById(vaccinationId);
			 if(res>0)
			 {
				 vaccinationDetailsList =  vaccinationDetailssRepository.getAllVaccinations();
			 }
		}catch(Exception e) {
			
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return vaccinationDetailsList;
		
	}
}

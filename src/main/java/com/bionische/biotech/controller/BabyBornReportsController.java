package com.bionische.biotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.BabyBornReports;
import com.bionische.biotech.model.FamilyDetails;
import com.bionische.biotech.model.GetBabyBornReports;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.VaccinationPatientDetails;
import com.bionische.biotech.repository.BabyBornReportsRepository;
import com.bionische.biotech.repository.FamilyDetailsRepository;
import com.bionische.biotech.repository.GetBabyBornReportsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.VaccinationPatientDetailsRepository;

@RestController
public class BabyBornReportsController {

	      
	@Autowired 
	BabyBornReportsRepository babyBornReportsRepository;
	
	@Autowired
	VaccinationPatientDetailsRepository vaccinationPatientDetailsRepository;
	  
		@Autowired
		FamilyDetailsRepository familyDetailsRepository;
		
		@Autowired
		PatientDetailsRepository patientDetailsRepository;
		
		@Autowired
		GetBabyBornReportsRepository getBabyBornReportsRepository;
	
	@RequestMapping(value = { "/insertBornBabyDetails" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails insertBornBabyDetails(@RequestBody PatientDetails patientDetails)
	{
		System.out.println("Comming List "+patientDetails.toString());
		PatientDetails patientDetailsRes=new PatientDetails();
		Info info =new Info();
		try {
			
			if(patientDetails.getFamilyId()==0)
			{
				FamilyDetails familyDetails=new FamilyDetails();
			 
				FamilyDetails familyDetailsRes=familyDetailsRepository.save(familyDetails);
				patientDetails.setFamilyId(familyDetailsRes.getFamilyId());
			}
			patientDetailsRes=patientDetailsRepository.save(patientDetails); 
		
		System.out.println(patientDetailsRes.toString());
		
		 
}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed to insert");
		}
	
		return patientDetailsRes;
	}
	
	
	
	@RequestMapping(value = { "/insertBabyBornReports" }, method = RequestMethod.POST)
	public @ResponseBody Info insertBabyBornReports(@RequestBody BabyBornReports babyBornReports)
	{
		
		Info info=new Info();
		
		try {
		BabyBornReports babyBornReportsRes=babyBornReportsRepository.save(babyBornReports);
		
		info.setError(true);
		info.setMessage("Problem in insert");
		if(babyBornReportsRes!=null)
		{
			info.setError(false);
			info.setMessage("Insert Successfully");
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return info;
	}
	
	
	/*@RequestMapping(value = { "/getBabyBornReports" }, method = RequestMethod.POST)
	public @ResponseBody BabyBornReports getBabyBornReports(@RequestParam("patientId") int patientId)
	{
		BabyBornReports babyBornReports =new BabyBornReports();
		try {
		babyBornReports=babyBornReportsRepository.findByPatientId(patientId);
		System.out.println(babyBornReports.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return babyBornReports;
		
		
	}
	*/
	
	@RequestMapping(value = { "/getBabyBornReports" }, method = RequestMethod.POST)
	public @ResponseBody GetBabyBornReports getBabyBornReports(@RequestParam("patientId") int patientId)
	{
		System.out.println("inaappppppppppiiiiiiiii:"+patientId);
		GetBabyBornReports getBabyBornReports =new GetBabyBornReports();
		try {
			
			getBabyBornReports=getBabyBornReportsRepository.getBabyBornReport(patientId);
		System.out.println(getBabyBornReports.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getBabyBornReports;
		
		
	}
	
	
	@RequestMapping(value = { "/getPatientByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody VaccinationPatientDetails getPatientDetailsById(@RequestParam("patientId") int patientId)
	
	{
		VaccinationPatientDetails patientDetailsRes=new VaccinationPatientDetails();
	 try {
		 patientDetailsRes=	vaccinationPatientDetailsRepository.getPatientByPatientId(patientId);	
	 }
	 catch (Exception e) {
		 
		 System.out.println(e.getMessage());
		 
	}
	 return patientDetailsRes;
	 
	}

}

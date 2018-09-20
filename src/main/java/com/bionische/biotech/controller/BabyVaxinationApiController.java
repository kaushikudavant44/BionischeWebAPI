package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.VaccinationAgeDetails;
import com.bionische.biotech.model.VaccinationDetails;
import com.bionische.biotech.patientpasthistory.model.MenstrualObstetricHistory;
import com.bionische.biotech.patientpasthistory.model.PatientAllPersonalHistory;
import com.bionische.biotech.patientpasthistory.model.PatientFamilyHistory;
import com.bionische.biotech.patientpasthistory.model.PatientHistoryChiefComplaints;
import com.bionische.biotech.patientpasthistory.model.PatientPastHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPastHistoryIIlness;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPsychologicalHistory;
import com.bionische.biotech.patientpasthistory.model.PatientTreatementHistory;
import com.bionische.biotech.patientpasthistory.repository.MenstrualObstetricHistoryRepository;
import com.bionische.biotech.patientpasthistory.repository.PatientFamilyHistoryRepository;
import com.bionische.biotech.patientpasthistory.repository.PatientHistoryChiefComplaintsRepository;
import com.bionische.biotech.patientpasthistory.repository.PatientPastHistoryIIlnessRepository;
import com.bionische.biotech.patientpasthistory.repository.PatientPastHistoryRepository;
import com.bionische.biotech.patientpasthistory.repository.PatientPersonalHistoryRepository;
import com.bionische.biotech.patientpasthistory.repository.PatientPsychologicalHistoryRepository;
import com.bionische.biotech.patientpasthistory.repository.PatientTreatementHistoryRepository;
import com.bionische.biotech.repository.VaccinationAgeDetailsRepository;
import com.bionische.biotech.repository.VaccinationDetailsRepository;
import com.bionische.biotech.stemcell.model.BabyVaxinationDetails;
import com.bionische.biotech.stemcell.model.BabyVaxinationDetailsList;
import com.bionische.biotech.stemcell.model.VaxinationDetails;
import com.bionische.biotech.stemcell.repository.BabyVaxinationDetailsRepository;
import com.bionische.biotech.stemcell.repository.VaxinationDetailsRepository;


 
@RestController
public class BabyVaxinationApiController {

	

	@Autowired
	VaxinationDetailsRepository vaxinationDetailsRepository;
	@Autowired
	BabyVaxinationDetailsRepository babyVaxinationDetailsRepository;
	
	@Autowired
	private VaccinationDetailsRepository vaccinationDetailsRepository;
	
	@Autowired
	private VaccinationAgeDetailsRepository vaccinationAgeDetailsRepository;
	
 
	@RequestMapping(value = { "/insertBabyVaxinationDetails" }, method = RequestMethod.POST)
	public @ResponseBody VaxinationDetails insertBabyVaxinationDetails(@RequestBody VaxinationDetails vaxinationDetails)
	{
		System.out.println("Comming List "+vaxinationDetails.toString());
		 
		//VaxinationDetails vaxinationDetails=new VaxinationDetails();
		//BabyVaxinationDetails babyVaxinationDetails=new BabyVaxinationDetails();
		 
	 try {     
		 
		 VaxinationDetails vaxinationDetailsRes=vaxinationDetailsRepository.findByPatientId(vaxinationDetails.getPatientId());
		 if(vaxinationDetailsRes!=null)
		 {
			 vaxinationDetails.setVaxinationDetailsId(vaxinationDetailsRes.getVaxinationDetailsId());
		 }
		 
		 vaxinationDetailsRepository.save(vaxinationDetails);
		 	 
		System.out.println(vaxinationDetails.toString());
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return vaxinationDetails;
	}
	 
	 
	@RequestMapping(value = { "/getVaxinationDetails" }, method = RequestMethod.POST)
	public @ResponseBody VaxinationDetails getVaxinationDetails(@RequestParam("patientId") int patientId) {
		
		
		System.out.println("patientId"+patientId);
		System.out.println("in methods");
		
		
		VaxinationDetails vaxinationDetails=new VaxinationDetails();
		 
		 
		BabyVaxinationDetails babyVaxinationDetails=new BabyVaxinationDetails();
		//BabyVaxinationDetailsList babyVaxinationDetailsList=new BabyVaxinationDetailsList();
		List<BabyVaxinationDetails> babyVaxinationDetailsList = null;
		try {
			
		//	babyVaxinationDetails=babyVaxinationDetailsRepository.findByPatientId(patientId);
			
			vaxinationDetails=vaxinationDetailsRepository.findByPatientId(patientId);
			System.out.println("Comming data  "+vaxinationDetails.toString());
			/*List<String> patientHistoryList=new ArrayList<String>();
			
			    patientHistoryList= Arrays.asList(vaxinationDetails.getBabyVaxinationDetailsId().split(","));
				//System.out.println("vaxinationDetails"+vaxinationDetails.toString());
				
				babyVaxinationDetailsList=new ArrayList<BabyVaxinationDetails>();
				babyVaxinationDetailsList=babyVaxinationDetailsRepository.getBabyVaxination(patientHistoryList);*/
				//System.out.println("babyVaxinationDetailsList"+babyVaxinationDetailsList.toString());
				
				/*List<VaxinationDetails> vaxinationDetailsList=new ArrayList<VaxinationDetails>();
				vaxinationDetailsList=vaxinationDetailsRepository.getBabyVaxination(patientHistoryList);
			System.out.println("vaxinationDetails"+vaxinationDetailsList.toString());
  */
		  // patientAllPersonalHistory.setPatientPastHistoryIIlnessList(patientPastHistoryIIlnessList);
			 
	//		System.out.println("Comming data  "+vaxinationDetails.toString()); 
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return vaxinationDetails;
	}
	
	@RequestMapping(value = { "/getAllVaccination" }, method = RequestMethod.GET)
	public @ResponseBody List<VaccinationDetails> getAllVaccination()
	
	{
		List<VaccinationDetails> vaccinationDetailsList=new ArrayList<VaccinationDetails>();
	 try {
		 vaccinationDetailsList=vaccinationDetailsRepository.getAllVaccinations();
		 System.out.println("VaccinationDetailsRes:"+vaccinationDetailsList.toString());
		
	 }
	 catch (Exception e) {
		 	System.out.println(e.getMessage());
	}
	 return vaccinationDetailsList;
	 
	}       
	
	@RequestMapping(value = { "/getAllVaccinationAge" }, method = RequestMethod.GET)
	public @ResponseBody List<VaccinationAgeDetails> getAllVaccinationAge()
	
	{
		List<VaccinationAgeDetails> vaccinationAgeDetailsList=new ArrayList<VaccinationAgeDetails>();
	 try {
		 vaccinationAgeDetailsList=vaccinationAgeDetailsRepository.findAll();
		 System.out.println("VaccinationDetailsRes:"+vaccinationAgeDetailsList.toString());
		
	 }
	 catch (Exception e) {
		 	System.out.println(e.getMessage());
	}
	 return vaccinationAgeDetailsList;
	 
	}
	
	
	
	
	
}

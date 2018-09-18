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
import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.model.City;
import com.bionische.biotech.model.Country;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.GetAppointmentDetails;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.model.State;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.HospitalDetailsRepository;
import com.bionische.biotech.stemcell.model.GetPatientEnrollDetails;
import com.bionische.biotech.stemcell.model.GetStemcellBankDetails;
import com.bionische.biotech.stemcell.model.PregnancyCalculator;
import com.bionische.biotech.stemcell.model.StemCellBankDetails;
import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;
import com.bionische.biotech.stemcell.model.PlanDetails;
import com.bionische.biotech.stemcell.model.PatientEnrollDetails;
import com.bionische.biotech.stemcell.repository.GetPatientEnrollDetailsRepository;
import com.bionische.biotech.stemcell.repository.GetStemcellBankDetailsRepository;
 
import com.bionische.biotech.stemcell.repository.StemCellBankDetailsRepository;
import com.bionische.biotech.stemcell.repository.StemCellBankRatingDetailsRepository;
import com.bionische.biotech.stemcell.repository.planDetailsRepository;
import com.bionische.biotech.stemcell.repository.PatientEnrollDetailsRepository;
import com.bionische.biotech.stemcell.repository.PregnancyCalculatorRepository;

@RestController
public class StemCellApiController {
	@Autowired
	GetStemcellBankDetailsRepository getStemcellBankDetailsRepository;
	    
	@Autowired
   PatientEnrollDetailsRepository  patientEnrollDetailsRepository;
	
	@Autowired
	PregnancyCalculatorRepository  pregnancyCalculatorRepository;
	
	@Autowired
	StemCellBankRatingDetailsRepository  stemCellBankRatingDetailsRepository;
	
	@Autowired
	GetPatientEnrollDetailsRepository  getPatientEnrollDetailsRepository;
	
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	
	@Autowired
	HospitalDetailsRepository hospitalDetailsRepository;
	
	@Autowired
	StemCellBankDetailsRepository stemCellBankDetailsRepository;
	
	@Autowired
	planDetailsRepository stemcellrenewalRepository;
	
	
	@RequestMapping(value = { "/getStemcellBankDetailsBycityId"}, method = RequestMethod.POST)
	public @ResponseBody List<GetStemcellBankDetails> getStemcellBankDetailsBycityId(@RequestParam("cityId") int cityId) {
		System.out.println("cityId "+cityId);
		
		
		List<GetStemcellBankDetails> getStemcellBankDetailsList=new ArrayList<>();
		try { 
			getStemcellBankDetailsList=getStemcellBankDetailsRepository.getStemcellBankDetailsByCityId(cityId);
			System.out.println("banks:"+getStemcellBankDetailsList.toString());
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return getStemcellBankDetailsList;
	}
	
	@RequestMapping(value = { "/insertPatientEnrollDetails" }, method = RequestMethod.POST)
	public @ResponseBody PatientEnrollDetails insertPatientEnrollDetails(@RequestBody PatientEnrollDetails patientEnrollDetails)
	{
		System.out.println("Comming List "+patientEnrollDetails.toString());
		PatientEnrollDetails patientEnrollDetailsRes=new PatientEnrollDetails();
		 
		try {
			patientEnrollDetailsRes=patientEnrollDetailsRepository.save(patientEnrollDetails); 
		System.out.println(patientEnrollDetailsRes.toString());
		   
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return patientEnrollDetailsRes;
	}
	
	@RequestMapping(value = { "/insertDueDate" }, method = RequestMethod.POST)
	public @ResponseBody PregnancyCalculator insertDueDate(@RequestBody PregnancyCalculator pregnancyCalculator)
	{
		
		System.out.println("Comming List "+pregnancyCalculator.toString());
		PregnancyCalculator pregnancyCalculatorRes=new PregnancyCalculator();
		 
		try {
			pregnancyCalculatorRes=pregnancyCalculatorRepository.save(pregnancyCalculator); 
		System.out.println(pregnancyCalculatorRes.toString());
		System.out.println("pregnancyCalculatorRes" +pregnancyCalculatorRes);
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
return pregnancyCalculator;
	}
	
	
	@RequestMapping(value = { "/getStemCellReviewByStemcellBankId"}, method = RequestMethod.POST)
	public @ResponseBody List<StemCellBankRatingDetails> getStemCellReviewByStemcellBankId(@RequestParam("stemCellBankId") int stemCellBankId) {
		System.out.println("stemCellBankId "+stemCellBankId);
		
	 
		List<StemCellBankRatingDetails> stemCellRatingDetailsList=new ArrayList<StemCellBankRatingDetails>();
		try {
			stemCellRatingDetailsList=stemCellBankRatingDetailsRepository.findBystemCellBankIdAndDelStatus(stemCellBankId,0); 
			System.out.println("stemCellRatingDetailsList" +stemCellRatingDetailsList);  
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return stemCellRatingDetailsList;
	}
	 //komal 
		//Get stemcellstorage form to patient
	  
		@RequestMapping(value = { "/getEnrollDetailsByPatientId"}, method = RequestMethod.POST)
		public @ResponseBody List<GetPatientEnrollDetails> getEnrollDetailsByPatientId(@RequestParam("familyId") int familyId) {
			System.out.println("familyId "+familyId);
			
			
			 
			List<GetPatientEnrollDetails> getPatientEnrollDetailsList=new ArrayList<>();
			try {
				getPatientEnrollDetailsList=getPatientEnrollDetailsRepository.getPatientEnrollDetailsByPatientId(familyId);
				System.out.println("patientDetails:"+getPatientEnrollDetailsList.toString());
				
				 
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			//e.printStackTrace();   
			}
	        return getPatientEnrollDetailsList;
		}

		
		
		// get renewals by stemcellcompanyId
		
		@RequestMapping(value = { "/getStemcellPlansBycompanyId"}, method = RequestMethod.POST)
		public @ResponseBody List<PlanDetails> getStemcellPlansBycompanyId(@RequestParam("stemCellBankId") int stemCellBankId) {
			System.out.println("stemCellBankId "+stemCellBankId);
			
			
			List<PlanDetails> getstemcellrenewalList=new  ArrayList <PlanDetails>();
			try { 
				getstemcellrenewalList=stemcellrenewalRepository.getstemcellrenewalByStemCellBankId(stemCellBankId);
				System.out.println("renewals of stemcell:"+getstemcellrenewalList.toString());
				 
			}
			catch (Exception e) {
			e.printStackTrace();
			}
	        return getstemcellrenewalList;
		}
		
		
		@RequestMapping(value = { "/getAllHospitalsByCityId" }, method = RequestMethod.POST)
		public @ResponseBody List<HospitalDetails> getAllHospitalsByCityId(@RequestParam("cityId") int cityId) {
			System.out.println("cityId "+cityId);
			List<HospitalDetails> hospitalDetailsList=new ArrayList<HospitalDetails>();
			 
			try {
				hospitalDetailsList=hospitalDetailsRepository.findByCityId(cityId);
				System.out.println("hospital:"+hospitalDetailsList.toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return hospitalDetailsList;
		}
		
		@RequestMapping(value = { "/getAllHospitalsByConsultCityId" }, method = RequestMethod.POST)
		public @ResponseBody List<HospitalDetails> getAllHospitalsByConsultCityId(@RequestParam("cityId") int cityId,@RequestParam("patientId") int patientId) {
			System.out.println("cityId "+cityId);
			System.out.println("patientId "+patientId);
			List<HospitalDetails> hospitalDetailsList=new ArrayList<HospitalDetails>();
			 
			try {
				hospitalDetailsList=hospitalDetailsRepository.getByCityId(cityId,patientId);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return hospitalDetailsList;
		}
		@RequestMapping(value = { "/getAllStemCellBANK" }, method = RequestMethod.GET)
		public @ResponseBody List<StemCellBankDetails> getAllStemCellBANK() {
			
			 List<StemCellBankDetails> stemcellbankList=stemCellBankDetailsRepository.findAll();
			
			 System.out.println("stemcellbankList:"+stemcellbankList.toString());
			return stemcellbankList;
		}
		@RequestMapping(value = { "/getPregnancyDateByPatientId"}, method = RequestMethod.POST)
		public @ResponseBody PregnancyCalculator getPregNancyDateByPatientId(@RequestParam("patientId") int patientId) {
			System.out.println("familyId "+patientId);
			
			
			 
			PregnancyCalculator pregnancyCalculator=new PregnancyCalculator();
			try {
				pregnancyCalculator=pregnancyCalculatorRepository.getPregnancyCalculatorByPatientId(patientId);
				System.out.println("dates:"+pregnancyCalculator.toString());
				
				 
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			//e.printStackTrace();   
			}
	        return pregnancyCalculator;
		}
		
}



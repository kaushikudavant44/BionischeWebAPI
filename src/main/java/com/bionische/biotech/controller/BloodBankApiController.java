package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.bloodbank.model.BloodAvailableDetails;
import com.bionische.biotech.bloodbank.model.BloodBankDetails;
import com.bionische.biotech.bloodbank.model.BloodBankRatingDetails;
import com.bionische.biotech.bloodbank.model.BloodRequestDetails;
import com.bionische.biotech.bloodbank.model.DonorDetails;
import com.bionische.biotech.bloodbank.model.GetBloodBankDetails;
import com.bionische.biotech.bloodbank.repository.BloodAvailableDetailsRepository;
import com.bionische.biotech.bloodbank.repository.BloodBankDetailsRepository;
import com.bionische.biotech.bloodbank.repository.BloodBankRatingDetailsRepository;
import com.bionische.biotech.bloodbank.repository.BloodRequestDetailsRepository;
import com.bionische.biotech.bloodbank.repository.DonorDetailsRepository;
import com.bionische.biotech.bloodbank.repository.GetBloodBankDetailsRepository;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.FamilyDetails;
//import com.bionische.biotech.model.GetStemcellBankDetails;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.PatientDetails;
//import com.bionische.biotech.model.StemcellDetails;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.FamilyDetailsRepository;
import com.bionische.biotech.repository.HospitalDetailsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.stemcell.model.GetStemcellBankDetails;
import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;
@Controller
@RestController
public class BloodBankApiController {

	@Autowired
	BloodBankDetailsRepository bloodBankDetailsRepository;
	
	
	@Autowired
	GetBloodBankDetailsRepository getBloodBankDetailsRepository;
	
	@Autowired
	HospitalDetailsRepository hospitalDetailsRepository;
	
	@Autowired        
	BloodRequestDetailsRepository bloodRequestDetailsRepository;
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	@Autowired
	BloodAvailableDetailsRepository bloodAvailableDetailsRepository;
	
	@Autowired
	DonorDetailsRepository donorDetailsRepository;
	
	@Autowired
	BloodBankRatingDetailsRepository bloodBankRatingDetailsRepository;
	
	
	
	
	//komal
	//insert bloodbank
	@RequestMapping(value = { "/insertBloodBankDetails" }, method = RequestMethod.POST)
	public @ResponseBody BloodBankDetails insertBloodBankDetails(@RequestBody BloodBankDetails bloodBankDetails)
	{
		System.out.println("Comming List "+bloodBankDetails.toString());
		BloodBankDetails bloodBankDetailsRes=new BloodBankDetails();
		 
		try {
			bloodBankDetailsRes=bloodBankDetailsRepository.save(bloodBankDetails); 
		System.out.println(bloodBankDetailsRes.toString());
		 
		}
		
		catch (Exception e) {   
			System.out.println(e.getMessage());
			 
		}
	return bloodBankDetailsRes;
	}
	
	
	
	@RequestMapping(value = { "/getBloodBanksByCityId" }, method = RequestMethod.POST)
	public @ResponseBody List<BloodBankDetails> getLabsByCityId(@RequestParam("cityId") int cityId) {
		System.out.println("cccity "+cityId);
		List<BloodBankDetails> bloodBankDetailsList=new ArrayList<>();
		try {
			bloodBankDetailsList=bloodBankDetailsRepository.getBloodBankByCityId(cityId);
			
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return bloodBankDetailsList;
	}
	
	@RequestMapping(value = { "/insertBloodBankRequestDetails" }, method = RequestMethod.POST)
	public @ResponseBody BloodRequestDetails insertBloodBankRequestDetails(@RequestBody BloodRequestDetails bloodRequestDetails)
	{
		System.out.println("Comming List "+bloodRequestDetails.toString());
		BloodRequestDetails bloodRequestDetailsRes=new BloodRequestDetails();
		 
		try {
			bloodRequestDetailsRes=bloodRequestDetailsRepository.save(bloodRequestDetails); 
		System.out.println(bloodRequestDetailsRes.toString());
		   
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return bloodRequestDetailsRes;
	}

	@RequestMapping(value = { "/getDonorDetailsBycityIdAndbloodGroup"}, method = RequestMethod.POST)
	public @ResponseBody Info getDonorDetailsBycityIdAndbloodGroup(@RequestParam("cityName") String cityName,@RequestParam("bloodGroup") String bloodGroup,@RequestParam("hospitalId") String hospitalId) {
		System.out.println("cityName "+cityName);
		System.out.println("bloodGroup "+bloodGroup);

		Info info=new Info();
		
		List<PatientDetails> getPatientDetailsList=new ArrayList<PatientDetails>();
		try { 
			getPatientDetailsList=patientDetailsRepository.getPatientDetailsListByCityIdAndBloodGroup(cityName,bloodGroup);
			System.out.println("Patientlist from bloodgroup:"+getPatientDetailsList.toString());
			 
			if(getPatientDetailsList!=null)
			{
				info.setError(false);
				info.setMessage("Success");
			}
			else {
				info.setError(true);
				info.setMessage("Failed to insert");
			}
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return info;
	}
	/*@RequestMapping(value = { "/getBloodBankBankDetailsBycityId"}, method = RequestMethod.POST)
	public @ResponseBody List<GetBloodBankDetails> getBloodBankBankDetailsBycityId(@RequestParam("cityId") int cityId) {
		System.out.println("cityId "+cityId);
		
		
		List<GetBloodBankDetails> getBloodBankDetailsList=new ArrayList<>();
		try { 
			getBloodBankDetailsList=getBloodBankDetailsRepository.getBloodBankDetailsByCityId(cityId);
			System.out.println("banks:"+getBloodBankDetailsList.toString());
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return getBloodBankDetailsList;
	}*/
	
	
	@RequestMapping(value = { "/getBloodReviewByBloodBankId"}, method = RequestMethod.POST)
	public @ResponseBody List<BloodBankRatingDetails> getBloodReviewByBloodBankId(@RequestParam("bloodBankId") int bloodBankId) {
		System.out.println("bloodBankId "+bloodBankId);
		
	 
		List<BloodBankRatingDetails> BloodBankRatingDetailsList=new ArrayList<BloodBankRatingDetails>();
		try {
			BloodBankRatingDetailsList=bloodBankRatingDetailsRepository.findBybloodBankIdAndDelStatus(bloodBankId,0); 
			System.out.println("BloodBankRatingDetailsList" +BloodBankRatingDetailsList);  
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return BloodBankRatingDetailsList;
	}

	//komal
		//insert bloodDonorDetails
		@RequestMapping(value = { "/insertBloodDonorDetails" }, method = RequestMethod.POST)
		public @ResponseBody DonorDetails insertBloodDonorDetails(@RequestBody DonorDetails donorDetails)
		{
			System.out.println("Comming List "+donorDetails.toString());
			DonorDetails donorDetailsRes=new DonorDetails();
			 
			try {
				donorDetailsRes=donorDetailsRepository.save(donorDetails); 
			System.out.println(donorDetailsRes.toString());
			 
			}
			
			catch (Exception e) {   
				System.out.println(e.getMessage());
				 
			}
		return donorDetailsRes;
		}
		//insert bloodDonorDetails
				@RequestMapping(value = { "/insertbloodaAvailableDetails" }, method = RequestMethod.POST)
				public @ResponseBody BloodAvailableDetails insertbloodaAvailableDetails(@RequestBody BloodAvailableDetails bloodAvailableDetails)
				{
					System.out.println("Comming List "+bloodAvailableDetails.toString());
					BloodAvailableDetails availableDetailsRes=new BloodAvailableDetails();
					 
					try {
						availableDetailsRes=bloodAvailableDetailsRepository.save(bloodAvailableDetails); 
					System.out.println(availableDetailsRes.toString());
					 
					}
					
					catch (Exception e) {   
						System.out.println(e.getMessage());
						 
					}
				return availableDetailsRes;
				}

				@RequestMapping(value = { "/getLocationBycityId"}, method = RequestMethod.POST)
				public @ResponseBody List<BloodBankDetails> getLocationBycityId(@RequestParam("cityId") int cityId) {
					System.out.println("cityId "+cityId);
					
				 
					List<BloodBankDetails> bloodBankDetailsDetailsList=new ArrayList<BloodBankDetails>();
					try {
						bloodBankDetailsDetailsList=bloodBankDetailsRepository.findByCityIdAndDelStatus(cityId,0); 
						System.out.println("bloodBankDetailsDetailsList" +bloodBankDetailsDetailsList);  
						 
					}
					catch (Exception e) {
					e.printStackTrace();
					}
			        return bloodBankDetailsDetailsList;
				}
				
			/*	@RequestMapping(value = { "/getBloodGroupBylocation"}, method = RequestMethod.POST)
				public @ResponseBody List<GetBloodGroupDetails> getBloodGroupBylocation(@RequestParam("location") int location) {
					System.out.println("location "+location);
					
				 
					List<GetBloodGroupDetails> bloodBankDetailsDetailsList=new ArrayList<GetBloodGroupDetails>();
					try {
						bloodBankDetailsDetailsList=getBloodGroupDetailsRepository.findByCityIdAndDelStatus(location,0); 
						System.out.println("bloodBankDetailsDetailsList" +bloodBankDetailsDetailsList);  
						 
					}
					catch (Exception e) {
					e.printStackTrace();
					}
			        return bloodBankDetailsDetailsList;
				}*/
				@RequestMapping(value = { "/getBloodBankBankDetailsBybloodGroup"}, method = RequestMethod.POST)
				public @ResponseBody List<GetBloodBankDetails> getBloodBankBankDetailsBybloodGroup(@RequestParam("bloodGroup") String bloodGroup,@RequestParam("date") String date,@RequestParam("location") String location) {
					System.out.println("bloodGroup "+bloodGroup);
					System.out.println("date :"+date);
					System.out.println("location :"+location);


					
					List<GetBloodBankDetails> getBloodBankDetailsList=new ArrayList<>();
					try { 
						getBloodBankDetailsList=getBloodBankDetailsRepository.getBloodBankDetailsBybloodGroupANDdateANDlocation(bloodGroup,date,location);
						System.out.println("banks:"+getBloodBankDetailsList.toString());
						 
					}
					catch (Exception e) {
					e.printStackTrace();
					}
			        return getBloodBankDetailsList;
				}
			
				
		}	
	
 

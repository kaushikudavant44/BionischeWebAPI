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

import com.bionische.biotech.patientpasthistory.model.Info;
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
 



@RestController
public class PatientPersonalHistoryApiController {

	@Autowired
	PatientPersonalHistoryRepository patientPersonalHistoryRepository;
	@Autowired
	MenstrualObstetricHistoryRepository menstrualObstetricHistoryRepository;
	@Autowired
	PatientFamilyHistoryRepository patientFamilyHistoryRepository;
	@Autowired
	PatientHistoryChiefComplaintsRepository patientHistoryChiefComplaintsRepository;
	@Autowired
	PatientPastHistoryRepository patientPastHistoryRepository;
	@Autowired
	PatientPastHistoryIIlnessRepository patientPastHistoryIIlnessRepository;
	@Autowired
	PatientPsychologicalHistoryRepository patientPsychologicalHistoryRepository;
	@Autowired
	PatientTreatementHistoryRepository patientTreatementHistoryRepository;
	 
	
	
	
	@RequestMapping(value = { "/insertPatientPersonalDetails" }, method = RequestMethod.POST)
	public @ResponseBody PatientAllPersonalHistory insertPatientPersonalDetails(@RequestBody PatientAllPersonalHistory patientAllPersonalHistory)
	{
		System.out.println("Comming List "+patientAllPersonalHistory.toString());
		 
		PatientPersonalHistory patientPersonalHistory=new PatientPersonalHistory();
		MenstrualObstetricHistory menstrualObstetricHistory=new MenstrualObstetricHistory();
		PatientFamilyHistory patientFamilyHistory=new PatientFamilyHistory();
		PatientHistoryChiefComplaints patientHistoryChiefComplaints=new PatientHistoryChiefComplaints();
		PatientPastHistory patientPastHistory=new PatientPastHistory();
	//	PatientPastHistoryIIlness patientPastHistoryIIlness=new PatientPastHistoryIIlness();
		PatientPsychologicalHistory patientPsychologicalHistory=new PatientPsychologicalHistory();
		PatientTreatementHistory patientTreatementHistory=new PatientTreatementHistory();
		 
		
		
		
		patientPersonalHistory=patientAllPersonalHistory.getPatientPersonalHistory();
		menstrualObstetricHistory=patientAllPersonalHistory.getMenstrualObstetricHistory();
		patientFamilyHistory=patientAllPersonalHistory.getPatientFamilyHistory();
		patientHistoryChiefComplaints=patientAllPersonalHistory.getPatientHistoryChiefComplaints();
		patientPastHistory=patientAllPersonalHistory.getPatientPastHistory();
		//patientPastHistoryIIlness=patientAllPersonalHistory.getPatientPastHistoryIIlness();
		patientPsychologicalHistory=patientAllPersonalHistory.getPatientPsychologicalHistory();
		patientTreatementHistory=patientAllPersonalHistory.getPatientTreatementHistoryp();
		
	 
		
	 try {
		 
		 PatientPersonalHistory patientPersonalHistoryRes=patientPersonalHistoryRepository.findByPatientId(patientPersonalHistory.getPatientId());
		 if(patientPersonalHistoryRes!=null)
		 {
			 patientPersonalHistory.setPersonalHistoryId(patientPersonalHistoryRes.getPersonalHistoryId());
		 }
		 
		 patientPersonalHistoryRepository.save(patientPersonalHistory);
		 
		 
		 
		 
		 
		 MenstrualObstetricHistory menstrualObstetricHistoryRes=menstrualObstetricHistoryRepository.findByPatientId(menstrualObstetricHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 menstrualObstetricHistory.setMenstrualObstetricHistoryId(menstrualObstetricHistoryRes.getMenstrualObstetricHistoryId());
		 }
		 
		 menstrualObstetricHistoryRepository.save(menstrualObstetricHistory);
		 
		 
		 
		 
		 PatientFamilyHistory patientFamilyHistoryRes=patientFamilyHistoryRepository.findByPatientId(patientFamilyHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientFamilyHistory.setFamilyHistoryId(patientFamilyHistoryRes.getFamilyHistoryId());
		 }
		 
		 patientFamilyHistoryRepository.save(patientFamilyHistory);
		 
		 
		 

		 PatientHistoryChiefComplaints patientHistoryChiefComplaintsRes=patientHistoryChiefComplaintsRepository.findByPatientId(patientFamilyHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientHistoryChiefComplaints.setChiefcomplaintsId(patientHistoryChiefComplaintsRes.getChiefcomplaintsId());
		 }
		 
		 patientHistoryChiefComplaintsRepository.save(patientHistoryChiefComplaints);
		 
		 
		 
		 PatientPastHistory patientPastHistoryRes=patientPastHistoryRepository.findByPatientId(patientPastHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientPastHistory.setPatientPastHistoryId(patientPastHistoryRes.getPatientPastHistoryId());
		 }
		 
		 patientPastHistoryRepository.save(patientPastHistory);
		 
		 
		 
		PatientPsychologicalHistory patientPsychologicalHistoryRes=patientPsychologicalHistoryRepository.findByPatientId(patientPsychologicalHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientPsychologicalHistory.setPsychologicaLHistoryId(patientPsychologicalHistoryRes.getPsychologicaLHistoryId());
		 }
		 
		 patientPsychologicalHistoryRepository.save(patientPsychologicalHistory);
		 
		 
		 
		 PatientTreatementHistory patientTreatementHistoryRes=patientTreatementHistoryRepository.findByPatientId(patientTreatementHistory.getpatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientTreatementHistory.settreatementHistoryId(patientTreatementHistoryRes.gettreatementhistoryId());
		 }
		 
		 patientTreatementHistoryRepository.save(patientTreatementHistory);
		 
		  
		 
		  /*
			List<String> patientIdList=new ArrayList<>();
		 	if(patientPastHistory!=null)
		 	{
				
		 		
		 		patientIdList= Arrays.asList(patientPastHistory.getPastHistoryIllnessId().split(","));
		 		
		 		System.out.println("patientIdList   "+patientIdList.toString());
		 		
		 		patientPastHistory.setPatientPastHistoryId(patientPastHistory.getPatientId());
			 
		 		patientPastHistoryRepository.save(patientAllPersonalHistory.getPatientPastHistory()); 

				 	 
		 	}
		 	else {
		 		patientPastHistoryRepository.save(patientAllPersonalHistory.getPatientPastHistory()); 

		 	 }
		 	 */
		 	
		 	 
		System.out.println(patientAllPersonalHistory.toString());
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return patientAllPersonalHistory;
	}
	
	 
	@RequestMapping(value = { "/getPatientHistory" }, method = RequestMethod.POST)
	public @ResponseBody PatientAllPersonalHistory getPatientHistory(@RequestParam("patientId") int patientId) {
		
		
		System.out.println("patientId"+patientId);
		System.out.println("in methods");
		
		
		 PatientAllPersonalHistory patientAllPersonalHistory=new PatientAllPersonalHistory();
		 
		 
		    PatientPersonalHistory patientPersonalHistory=new PatientPersonalHistory();
			MenstrualObstetricHistory menstrualObstetricHistory=new MenstrualObstetricHistory();
			PatientFamilyHistory patientFamilyHistory=new PatientFamilyHistory();
			PatientHistoryChiefComplaints patientHistoryChiefComplaints=new PatientHistoryChiefComplaints();
			PatientPastHistory patientPastHistory=new PatientPastHistory();
			PatientPastHistoryIIlness patientPastHistoryIIlness=new PatientPastHistoryIIlness();
			PatientPsychologicalHistory patientPsychologicalHistory=new PatientPsychologicalHistory();
			PatientTreatementHistory patientTreatementHistory=new PatientTreatementHistory();
			Info info=new Info();
			
		try {
			 
		 
			
		    patientPersonalHistory=patientPersonalHistoryRepository.findByPatientId(patientId);
		    System.out.println("patientPersonalHistory"+patientPersonalHistory);
			menstrualObstetricHistory=menstrualObstetricHistoryRepository.findByPatientId(patientId);
			patientFamilyHistory=patientFamilyHistoryRepository.findByPatientId(patientId);
			patientHistoryChiefComplaints=patientHistoryChiefComplaintsRepository.findByPatientId(patientId);
			patientPastHistory=patientPastHistoryRepository.findByPatientId(patientId);
			 
			List<String> patientHistoryList=new ArrayList<String>();
			
			patientHistoryList= Arrays.asList(patientPastHistory.getPastHistoryIllnessId().split(","));
				System.out.println("patientHistoryList"+patientHistoryList.toString());
				
				List<PatientPastHistoryIIlness> patientPastHistoryIIlnessList=new ArrayList<PatientPastHistoryIIlness>();
				patientPastHistoryIIlnessList=patientPastHistoryIIlnessRepository.getPastHistoryIllness(patientHistoryList);
			System.out.println("fghjkl;khyutrygujk "+patientPastHistoryIIlnessList.toString());
 
		  


			patientPsychologicalHistory=patientPsychologicalHistoryRepository.findByPatientId(patientId); 
			patientTreatementHistory=patientTreatementHistoryRepository.findByPatientId(patientId);
			
			
			
			System.out.println(patientAllPersonalHistory.getMenstrualObstetricHistory());
			patientAllPersonalHistory.setMenstrualObstetricHistory(menstrualObstetricHistory);
			patientAllPersonalHistory.setPatientFamilyHistory(patientFamilyHistory);
			patientAllPersonalHistory.setPatientHistoryChiefComplaints(patientHistoryChiefComplaints);
			patientAllPersonalHistory.setPatientPastHistory(patientPastHistory);
		    patientAllPersonalHistory.setPatientPastHistoryIIlness(patientPastHistoryIIlness);
			patientAllPersonalHistory.setPatientPersonalHistory(patientPersonalHistory);
			patientAllPersonalHistory.setPatientPsychologicalHistory(patientPsychologicalHistory);
			patientAllPersonalHistory.setPatientTreatementHistoryp(patientTreatementHistory);
			patientAllPersonalHistory.setPatientPastHistoryIIlnessList(patientPastHistoryIIlnessList);
			 
			System.out.println("Comming data  "+patientAllPersonalHistory.toString()); 
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return patientAllPersonalHistory;
	}
	
	/*@RequestMapping(value = { "/updatePatientPersonalDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePatientPersonalDetails(@RequestParam("patientId") int patientId)
	{
		
		
		
		 Info info =new Info();
	 try {
		 
		
		
		 //PatientPersonalHistory patientPersonalHistory = patientPersonalHistoryRepository.updateAll(patientId);
		 
		if(patientPersonalHistory!=null)
			{
				info.setError(false);
				info.setMessage("Insert successfully");
			
			}else {
				info.setError(true);
				info.setMessage("Failed to insert");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
	return info;
	}
	
	*/
	

	@RequestMapping(value = { "/updatePatientPersonalDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePatientPersonalDetails(@RequestBody PatientAllPersonalHistory patientAllPersonalHistory)
	{
		
		Info info =new Info();
		System.out.println("Comming List "+patientAllPersonalHistory.toString());
		 
		PatientPersonalHistory patientPersonalHistory=new PatientPersonalHistory();
		MenstrualObstetricHistory menstrualObstetricHistory=new MenstrualObstetricHistory();
		PatientFamilyHistory patientFamilyHistory=new PatientFamilyHistory();
		PatientHistoryChiefComplaints patientHistoryChiefComplaints=new PatientHistoryChiefComplaints();
		PatientPastHistory patientPastHistory=new PatientPastHistory();
	//	PatientPastHistoryIIlness patientPastHistoryIIlness=new PatientPastHistoryIIlness();
		PatientPsychologicalHistory patientPsychologicalHistory=new PatientPsychologicalHistory();
		PatientTreatementHistory patientTreatementHistory=new PatientTreatementHistory();
		 
		
		
		
		patientPersonalHistory=patientAllPersonalHistory.getPatientPersonalHistory();
		menstrualObstetricHistory=patientAllPersonalHistory.getMenstrualObstetricHistory();
		patientFamilyHistory=patientAllPersonalHistory.getPatientFamilyHistory();
		patientHistoryChiefComplaints=patientAllPersonalHistory.getPatientHistoryChiefComplaints();
		patientPastHistory=patientAllPersonalHistory.getPatientPastHistory();
		//patientPastHistoryIIlness=patientAllPersonalHistory.getPatientPastHistoryIIlness();
		patientPsychologicalHistory=patientAllPersonalHistory.getPatientPsychologicalHistory();
		patientTreatementHistory=patientAllPersonalHistory.getPatientTreatementHistoryp();
		
	 
		
	 try {
		 
		 PatientPersonalHistory patientPersonalHistoryRes=patientPersonalHistoryRepository.findByPatientId(patientPersonalHistory.getPatientId());
		 if(patientPersonalHistoryRes!=null)
		 {
			 patientPersonalHistory.setPersonalHistoryId(patientPersonalHistoryRes.getPersonalHistoryId());
		 }
		 
		 patientPersonalHistoryRepository.save(patientPersonalHistory);
		 
		 
		 
		 
		 
		 MenstrualObstetricHistory menstrualObstetricHistoryRes=menstrualObstetricHistoryRepository.findByPatientId(menstrualObstetricHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 menstrualObstetricHistory.setMenstrualObstetricHistoryId(menstrualObstetricHistoryRes.getMenstrualObstetricHistoryId());
		 }
		 
		 menstrualObstetricHistoryRepository.save(menstrualObstetricHistory);
		 
		 
		 
		 
		 PatientFamilyHistory patientFamilyHistoryRes=patientFamilyHistoryRepository.findByPatientId(patientFamilyHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientFamilyHistory.setFamilyHistoryId(patientFamilyHistoryRes.getFamilyHistoryId());
		 }
		 
		 patientFamilyHistoryRepository.save(patientFamilyHistory);
		 
		 
		 

		 PatientHistoryChiefComplaints patientHistoryChiefComplaintsRes=patientHistoryChiefComplaintsRepository.findByPatientId(patientFamilyHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientHistoryChiefComplaints.setChiefcomplaintsId(patientHistoryChiefComplaintsRes.getChiefcomplaintsId());
		 }
		 
		 patientHistoryChiefComplaintsRepository.save(patientHistoryChiefComplaints);
		 
		 
		 
		 PatientPastHistory patientPastHistoryRes=patientPastHistoryRepository.findByPatientId(patientPastHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientPastHistory.setPatientPastHistoryId(patientPastHistoryRes.getPatientPastHistoryId());
		 }
		 
		 patientPastHistoryRepository.save(patientPastHistory);
		 
		 
		 
		PatientPsychologicalHistory patientPsychologicalHistoryRes=patientPsychologicalHistoryRepository.findByPatientId(patientPsychologicalHistory.getPatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientPsychologicalHistory.setPsychologicaLHistoryId(patientPsychologicalHistoryRes.getPsychologicaLHistoryId());
		 }
		 
		 patientPsychologicalHistoryRepository.save(patientPsychologicalHistory);
		 
		 
		 
		 PatientTreatementHistory patientTreatementHistoryRes=patientTreatementHistoryRepository.findByPatientId(patientTreatementHistory.getpatientId());
		 if(menstrualObstetricHistoryRes!=null)
		 {
			 patientTreatementHistory.settreatementHistoryId(patientTreatementHistoryRes.gettreatementhistoryId());
		 }
		 
		 patientTreatementHistoryRepository.save(patientTreatementHistory);
		 
		  
		 
		  /*
			List<String> patientIdList=new ArrayList<>();
		 	if(patientPastHistory!=null)
		 	{
				
		 		
		 		patientIdList= Arrays.asList(patientPastHistory.getPastHistoryIllnessId().split(","));
		 		
		 		System.out.println("patientIdList   "+patientIdList.toString());
		 		
		 		patientPastHistory.setPatientPastHistoryId(patientPastHistory.getPatientId());
			 
		 		patientPastHistoryRepository.save(patientAllPersonalHistory.getPatientPastHistory()); 

				 	 
		 	}
		 	else {
		 		patientPastHistoryRepository.save(patientAllPersonalHistory.getPatientPastHistory()); 

		 	 }
		 	 */
		 	
		 	 
		System.out.println(patientAllPersonalHistory.toString());
		 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return info;
	}
	
	
}

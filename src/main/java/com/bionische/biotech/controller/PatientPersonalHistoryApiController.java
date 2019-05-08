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
	
	 
	
	@RequestMapping(value = { "/getPastHistoryIIlness" }, method = RequestMethod.GET)
	public @ResponseBody List<PatientPastHistoryIIlness> getPastHistoryIIlness()
	{
		return patientPastHistoryIIlnessRepository.findAll();
		
	}
	
	@RequestMapping(value = { "/insertPersonalHistoryDetails" }, method = RequestMethod.POST)
	public @ResponseBody PatientPersonalHistory insertPersonalHistoryDetails(@RequestBody PatientPersonalHistory patientPersonalHistory)
	{
		
		PatientPersonalHistory patientPersonalHistoryRes=patientPersonalHistoryRepository.findByPatientId(patientPersonalHistory.getPatientId());
	if(patientPersonalHistoryRes!=null)
		patientPersonalHistory.setPersonalHistoryId(patientPersonalHistoryRes.getPersonalHistoryId());
		return patientPersonalHistoryRepository.save(patientPersonalHistory);
		
	}
	
	@RequestMapping(value = { "/insertMenstrualObstetricHistory" }, method = RequestMethod.POST)
	public @ResponseBody MenstrualObstetricHistory insertMenstrualObstetricHistory(@RequestBody MenstrualObstetricHistory menstrualObstetricHistory)
	{
		MenstrualObstetricHistory menstrualObstetricHistoryRes=menstrualObstetricHistoryRepository.findByPatientId(menstrualObstetricHistory.getPatientId());
	if(menstrualObstetricHistoryRes!=null)
		menstrualObstetricHistory.setMenstrualObstetricHistoryId(menstrualObstetricHistoryRes.getMenstrualObstetricHistoryId());
		return menstrualObstetricHistoryRepository.save(menstrualObstetricHistory);
		
	}
	
	@RequestMapping(value = { "/insertPatientFamilyHistory" }, method = RequestMethod.POST)
	public @ResponseBody PatientFamilyHistory insertPatientFamilyHistory(@RequestBody PatientFamilyHistory patientFamilyHistory)
	{
		PatientFamilyHistory patientFamilyHistoryRes=patientFamilyHistoryRepository.findByPatientId(patientFamilyHistory.getPatientId());
	if(patientFamilyHistoryRes!=null)
		patientFamilyHistory.setFamilyHistoryId(patientFamilyHistoryRes.getFamilyHistoryId());
		return patientFamilyHistoryRepository.save(patientFamilyHistory);
		
	}
	@RequestMapping(value = { "/insertPatientHistoryChiefComplaints" }, method = RequestMethod.POST)
	public @ResponseBody PatientHistoryChiefComplaints insertPatientHistoryChiefComplaints(@RequestBody PatientHistoryChiefComplaints patientHistoryChiefComplaints)
	{
		PatientHistoryChiefComplaints patientHistoryChiefComplaintsRes=patientHistoryChiefComplaintsRepository.findByPatientId(patientHistoryChiefComplaints.getPatientId());
	if(patientHistoryChiefComplaintsRes!=null)
		patientHistoryChiefComplaints.setChiefcomplaintsId(patientHistoryChiefComplaintsRes.getChiefcomplaintsId());
		return patientHistoryChiefComplaintsRepository.save(patientHistoryChiefComplaints);
		
	}
	
	@RequestMapping(value = { "/insertPatientPastHistory" }, method = RequestMethod.POST)
	public @ResponseBody PatientPastHistory insertPatientPastHistory(@RequestBody PatientPastHistory patientPastHistory)
	{
		System.out.println(patientPastHistory.toString());
		PatientPastHistory patientPastHistoryres=patientPastHistoryRepository.findByPatientId(patientPastHistory.getPatientId());
		if(patientPastHistoryres!=null)
			patientPastHistory.setPatientPastHistoryId(patientPastHistoryres.getPatientPastHistoryId());
		return patientPastHistoryRepository.save(patientPastHistory);
		
	}
	/*@RequestMapping(value = { "/insertPatientPastHistoryList" }, method = RequestMethod.POST)
	public @ResponseBody Info insertPatientPastHistoryList(@RequestBody List<PatientPastHistory> patientPastHistoryList)
	{ 
		Info info=new Info();
		for(PatientPastHistory patientPastHistory : patientPastHistoryList)
		 patientPastHistoryRepository.save(patientPastHistory);
		
		return info;
	}*/
	@RequestMapping(value = { "/insertPatientPastHistoryIIlness" }, method = RequestMethod.POST)
	public @ResponseBody PatientPastHistoryIIlness insertPatientPastHistoryIIlness(@RequestBody PatientPastHistoryIIlness patientPastHistoryIIlness)
	{
		return patientPastHistoryIIlnessRepository.save(patientPastHistoryIIlness);
		
	}
	
	@RequestMapping(value = { "/insertPatientPsychologicalHistory" }, method = RequestMethod.POST)
	public @ResponseBody PatientPsychologicalHistory insertPatientPsychologicalHistory(@RequestBody PatientPsychologicalHistory patientPsychologicalHistory)
	{
		PatientPsychologicalHistory patientPsychologicalHistoryRes=patientPsychologicalHistoryRepository.findByPatientId(patientPsychologicalHistory.getPatientId());
	if(patientPsychologicalHistoryRes!=null)
		patientPsychologicalHistory.setPsychologicaLHistoryId(patientPsychologicalHistoryRes.getPsychologicaLHistoryId());
				return patientPsychologicalHistoryRepository.save(patientPsychologicalHistory);
		
	}
	
	@RequestMapping(value = { "/insertPatientTreatementHistory" }, method = RequestMethod.POST)
	public @ResponseBody PatientTreatementHistory insertPatientTreatementHistory(@RequestBody PatientTreatementHistory patientTreatementHistory)
	{
		PatientTreatementHistory patientTreatementHistoryRes=patientTreatementHistoryRepository.findByPatientId(patientTreatementHistory.getpatientId());
	if(patientTreatementHistoryRes!=null)
		patientTreatementHistory.settreatementHistoryId(patientTreatementHistoryRes.gettreatementhistoryId());
		return patientTreatementHistoryRepository.save(patientTreatementHistory);
		
	}
	
	@RequestMapping(value = { "/getPatientAllHistory" }, method = RequestMethod.POST)
	public @ResponseBody PatientAllPersonalHistory getPatientAllHistory(@RequestParam("patientId") int patientId)
	{
		PatientAllPersonalHistory patientAllPersonalHistory=new PatientAllPersonalHistory();
		try {
		PatientHistoryChiefComplaints patientHistoryChiefComplaints=patientHistoryChiefComplaintsRepository.findByPatientId(patientId);
		patientAllPersonalHistory.setPatientHistoryChiefComplaints(patientHistoryChiefComplaints);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		try {
		PatientPersonalHistory patientPersonalHistory=patientPersonalHistoryRepository.findByPatientId(patientId);
		patientAllPersonalHistory.setPatientPersonalHistory(patientPersonalHistory);
	}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		try {
		PatientFamilyHistory patientFamilyHistory=patientFamilyHistoryRepository.findByPatientId(patientId);
		patientAllPersonalHistory.setPatientFamilyHistory(patientFamilyHistory);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		try {
		PatientTreatementHistory patientTreatementHistory=patientTreatementHistoryRepository.findByPatientId(patientId);
		patientAllPersonalHistory.setPatientTreatementHistoryp(patientTreatementHistory);
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
		try {
			patientAllPersonalHistory.setPatientPsychologicalHistory(patientPsychologicalHistoryRepository.findByPatientId(patientId));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		try {
			patientAllPersonalHistory.setMenstrualObstetricHistory(menstrualObstetricHistoryRepository.findByPatientId(patientId));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		try {
			List<PatientPastHistoryIIlness> patientPastHistoryIIlnessList=patientPastHistoryIIlnessRepository.getPastHistory(patientId);
		System.out.println("patientPastHistoryIIlnessList   "+patientPastHistoryIIlnessList.toString());
			patientAllPersonalHistory.setPatientPastHistoryIIlnessList(patientPastHistoryIIlnessList);
		
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
		 
		return patientAllPersonalHistory;
	}
	
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

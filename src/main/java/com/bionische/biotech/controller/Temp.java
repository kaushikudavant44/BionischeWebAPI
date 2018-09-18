package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.history.model.MajorDetailsList;
import com.bionische.biotech.history.model.MajorDiesesDetails;
import com.bionische.biotech.history.model.PastMedicalHistory;
import com.bionische.biotech.history.model.PatientSystemDetails;
import com.bionische.biotech.history.model.PatientSystemDetailsList;
import com.bionische.biotech.history.model.PatientSystemHeader;
import com.bionische.biotech.history.model.PatientSystemReviews;
import com.bionische.biotech.history.repository.MajorDiesesDetailsRepository;
import com.bionische.biotech.history.repository.PastMedicalHistoryRepository;
import com.bionische.biotech.history.repository.PatientSystemDetailsRepository;
import com.bionische.biotech.history.repository.PatientSystemHeaderRepository;
import com.bionische.biotech.history.repository.PatientSystemReviewsRepository;
import com.bionische.biotech.model.Info;

@RestController
public class Temp {
 
	
	
	@Autowired
	PastMedicalHistoryRepository pastMedicalHistoryRepository;
	
	@Autowired
	MajorDiesesDetailsRepository majorDiesesDetailsRepository;
	@Autowired
	PatientSystemReviewsRepository patientSystemReviewsRepository;
	@Autowired
	PatientSystemDetailsRepository patientSystemDetailsRepository;
	
	@Autowired
	PatientSystemHeaderRepository patientSystemHeaderRepository;
	
	@RequestMapping(value = { "/getPastMedicalHistoryBYPatientId" }, method = RequestMethod.POST)
	public @ResponseBody MajorDetailsList getPastMedicalHistoryBYPatientId(@RequestParam("patientId") int patientId) 
	{
		MajorDetailsList majorDetailsList=new MajorDetailsList();
		List<MajorDiesesDetails> majorDiesesList=new ArrayList<MajorDiesesDetails>();
		Info info=new Info();
		
		PastMedicalHistory pastMedicalHistory= pastMedicalHistoryRepository.findByPatientIdAndDelStatus(patientId, 0);
		List<String> diesesIdList=new ArrayList<>();
		if(pastMedicalHistory!=null)
		{
			diesesIdList= Arrays.asList(pastMedicalHistory.getDiesesId().split(","));
		  majorDiesesList= majorDiesesDetailsRepository.getDiesesDetails(diesesIdList);
			
		}
		
		if(majorDiesesList!=null && !majorDiesesList.isEmpty())
		{
			info.setError(false);
			info.setMessage("Success");
			majorDetailsList.setInfo(info);
			majorDetailsList.setMajorDiesesDetailsList(majorDiesesList);
		}
		else {
			info.setError(true);
			info.setMessage("No records founds!!");
		}
		System.out.println("web"+majorDetailsList.toString());
		return majorDetailsList;
	}
	
	@RequestMapping(value = { "/getPastMonthHistoryBYPatientId" }, method = RequestMethod.POST)
	public @ResponseBody PatientSystemDetailsList getPastMonthHistoryBYPatientId(@RequestParam("patientId") int patientId) 
	{
		PatientSystemDetailsList patientSystemDetailsList=new PatientSystemDetailsList();
		List<PatientSystemDetails> patientDetailsList=new ArrayList<PatientSystemDetails>();
		
		Info info=new Info();
		
		PastMedicalHistory pastMedicalHistory= pastMedicalHistoryRepository.findByPatientIdAndDelStatus(patientId, 0);
		List<String> diesesIdList=new ArrayList<>();
		if(pastMedicalHistory!=null)
		{
			diesesIdList= Arrays.asList(pastMedicalHistory.getDiesesId().split(","));
			patientDetailsList= patientSystemDetailsRepository.getDiesesDetails(diesesIdList);
			
		}
		
		List<PatientSystemHeader> patientSystemHeaderList=patientSystemHeaderRepository.findByDelStatus(0);
		
		
		if(patientDetailsList!=null && !patientDetailsList.isEmpty())
		{
			info.setError(false);
			info.setMessage("Success");
			patientSystemDetailsList.setInfo(info);
			patientSystemDetailsList.setPatientSystemDetailsList(patientDetailsList );
			patientSystemDetailsList.setPatientSystemHeaderList(patientSystemHeaderList);
		}
		else {
			info.setError(true);
			info.setMessage("No records founds!!");
		}
		System.out.println("web"+patientSystemDetailsList.toString());
		return patientSystemDetailsList;
	}
	
}
 
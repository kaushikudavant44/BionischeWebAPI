package com.bionische.biotech.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.model.GetPatientBornReport;
import com.bionische.biotech.model.GetPatientContactDetailsById;
import com.bionische.biotech.model.GetPatientLabReportAndBornReports;
import com.bionische.biotech.model.GetPatientReports;
import com.bionische.biotech.model.GetPatientUploadedReport;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.model.ReportDetails;
import com.bionische.biotech.model.SharingReportWithDoc;
import com.bionische.biotech.repository.BabyBornReportsRepository;
import com.bionische.biotech.repository.GetPatientBornReportRepository;
import com.bionische.biotech.repository.GetPatientContactDetailsByIdRepository;
import com.bionische.biotech.repository.GetPatientReportsRepository;
import com.bionische.biotech.repository.GetPatientUploadedReportsRepository;
import com.bionische.biotech.repository.LabAppointmentRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.LabTestsRepository;
import com.bionische.biotech.repository.PatientNotificationRepository;
import com.bionische.biotech.repository.ReportDetailsRepository;
import com.bionische.biotech.repository.SharingReportWithDocRepository;
import com.bionische.biotech.service.CreateDirectoryService;
import com.bionische.biotech.service.SendEMailService;


@RestController
public class TempLabApiController {

	
	@Autowired
	LabAppointmentRepository labAppointmentRepository;
	
	
	@Autowired
	LabTestsRepository labTypesRepository;
	
	@Autowired
	ReportDetailsRepository reportDetailsRepository;
	
	@Autowired
	LabDetailsRepository labDetailsRepository;
	
	@Autowired
	GetPatientReportsRepository getPatientReportsRepository;
	
	@Autowired
	BabyBornReportsRepository babyBornReportsRepository;
	
	
	@Autowired
	GetPatientBornReportRepository getPatientBornReportRepository;
	
	@Autowired
	SharingReportWithDocRepository sharingReportWithDocRepository;
	
	@Autowired
	GetPatientUploadedReportsRepository getPatientUploadedReportsRepository;
	
	@Autowired
	GetPatientContactDetailsByIdRepository getPatientContactDetailsByIdRepository;
	@Autowired
	SendEMailService sendEMailService;
	
	@Autowired
	CreateDirectoryService createDirectoryService;
	
	@Autowired
	LabTestsRepository labTestsRepository;
	
	@Autowired
	PatientNotificationRepository patientNotificationRepository;
	
	@RequestMapping(value = { "/getAllLabTypes" }, method = RequestMethod.POST)
	public @ResponseBody List<LabTests> getAllLabTypes() {
		
		 List<LabTests> labList=labTypesRepository.findByDelStatus(0);
		
		return labList;
	}

/** insert patient Report*/
	
	@RequestMapping(value = { "/insertPatientReport" }, method = RequestMethod.POST)
	public @ResponseBody Info insertPatientReport(@RequestBody ReportDetails reportDetails)
	{
		System.out.println("Comming List "+reportDetails.toString());
		ReportDetails patientReport=new ReportDetails();
		Info info =new Info();
		try {
			patientReport=reportDetailsRepository.save(reportDetails);
			
		System.out.println(patientReport.toString());
		
		if(patientReport!=null)
		{
			LabDetails LabDetails = labDetailsRepository.findByLabId(patientReport.getLabId());
			LabTests LabTests = labTestsRepository.getTestDetailsByTestId(patientReport.getLabTestId());
			PatientNotification patientNotification = new PatientNotification();
			GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(patientReport.getPatientId());
			 
				sendEMailService.sendMail("Your  Report has been Successfully Uploaded", "Your  Report has been Successfully Uploaded", getPatientContactDetailsById.getEmail());
			
				patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
				patientNotification.setNotification(LabDetails.getLabName()+" has sent your "+LabTests.getLabTestName()+" report on DATE "+patientReport.getReportDate()+" and TIME "+patientReport.getReportTime());					
				patientNotification.setStatus(0);
				patientNotification.setString1("Lab Report");
				patientNotification.setString2("lab");
				patientNotification.setInt1(patientReport.getLabId());
				patientNotificationRepository.save(patientNotification);
			info.setError(false);
			info.setMessage("Success");
		}
		else {
			info.setError(true);
			info.setMessage("Failed to insert");
		}
}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed to insert");
		}
	
		return info;
	}
	
/** get patient report by test*/
	
	
		@RequestMapping(value = { "/getPatientReportsByTest" }, method = RequestMethod.POST)
		public @ResponseBody List<ReportDetails> getPatientReportsByTest(@RequestParam("testId") int testId,@RequestParam("patientId") int patientId)
		
		{
			ReportDetails reportDetails=new ReportDetails();
			List<ReportDetails> reportDetailsList=new ArrayList<ReportDetails>();
		 try {
			 reportDetailsList=	reportDetailsRepository.findBylabTypesIdAndDelStatus(testId,patientId);
			
		 }
		 catch (Exception e) {
	System.out.println(e.getMessage());
		}
		 return reportDetailsList;
		 
		}
	
		/** get patient report by test*/
		
		
		@RequestMapping(value = { "/getPatientReportsByDate" }, method = RequestMethod.POST)
		public @ResponseBody List<ReportDetails> getPatientReportsByDate(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,@RequestParam("patientId") int patientId)
		
		{
			fromDate=DateConverter.convertToYMD(fromDate);
			toDate=DateConverter.convertToYMD(toDate);
			ReportDetails reportDetails=new ReportDetails();
			List<ReportDetails> reportDetailsList=new ArrayList<ReportDetails>();
		 try {
			 reportDetailsList=	reportDetailsRepository.findByreportDateAndpatientIdAndDelStatus(fromDate,toDate,patientId);
			
		 }
		 catch (Exception e) {
	System.out.println(e.getMessage());
		}
		 return reportDetailsList;
		 
		}
		@RequestMapping(value = { "/insertLabDetails" }, method = RequestMethod.POST)
		public @ResponseBody LabDetails insertLabDetails(@RequestBody LabDetails labDetails)
		{
			 
			LabDetails labDetailsRes=new LabDetails();
			 
			try {
				if(labDetails.getLabId()==0) {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
				messageDigest.update(labDetails.getPassword().getBytes(),0, labDetails.getPassword().length());  
				String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
				if (hashedPass.length() < 32) {
				   hashedPass = "0" + hashedPass; 
				}
				labDetails.setPassword(hashedPass);
				}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			try {
				
				labDetailsRes=labDetailsRepository.save(labDetails);  
				if(labDetails.getLabId()!=0)
					createDirectoryService.createNewDirectorForLab(labDetailsRes.getLabId()+"");
				sendEMailService.sendMail("Your Lab has been Successfully Registered", "Your Lab has been Successfully Registered", labDetailsRes.getEmail());
				 
			}
			
			catch (Exception e) {
				System.out.println(e.getMessage());
				 
			}
		return labDetailsRes;
		}
		
		
		@RequestMapping(value = { "/getLabDetailsById" }, method = RequestMethod.POST)
		public @ResponseBody LabDetails getLabDetailsById(@RequestParam("labId") int labId)
		
		{
			LabDetails labDetailsRes=new LabDetails();
		 try {
			 labDetailsRes=	labDetailsRepository.findByLabId(labId);
			
		 }
		 catch (Exception e) {
	System.out.println(e.getMessage());
		}
		 return labDetailsRes;
		 
		 
		}
		  
		@RequestMapping(value = { "/getPatientReportByPatient" }, method = RequestMethod.POST)
		public @ResponseBody GetPatientLabReportAndBornReports getPatientReportByPatient(@RequestParam("patientId") int patientId,@RequestParam("startDate") String startDate,@RequestParam("toDate") String toDate)
		{
			System.out.println("patientId "+patientId);
			GetPatientLabReportAndBornReports getPatientLabReportAndBornReports=new GetPatientLabReportAndBornReports();
			List<GetPatientReports> getPatientReportsList=new ArrayList<GetPatientReports>();
			List<GetPatientBornReport> getPatientBornReportList=new ArrayList<GetPatientBornReport>();
			List<GetPatientUploadedReport> getPatientUploadedReportList=new ArrayList<GetPatientUploadedReport>();
			try {
			 getPatientReportsList=getPatientReportsRepository.getPatientReport(patientId,startDate,toDate);			
			 getPatientUploadedReportList=getPatientUploadedReportsRepository.getSelfUploadedReports(patientId,startDate,toDate,0);
			 System.out.println("cnduscndhsbcshudcb"+getPatientUploadedReportList.toString());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
			//System.out.println("getPatientReportsList "+getPatientReportsList.toString());
			
			try {
			 getPatientBornReportList=getPatientBornReportRepository.getpatientBornReport(patientId);
			System.out.println("getPatientBornReportList  "+getPatientBornReportList.toString());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
			getPatientLabReportAndBornReports.setGetPatientBornReportList(getPatientBornReportList);
			getPatientLabReportAndBornReports.setGetPatientReportsList(getPatientReportsList);
			getPatientLabReportAndBornReports.setGetPatientUploadedReportList(getPatientUploadedReportList);
			System.out.println("getPatientLabReportAndBornReportsxx  "+getPatientLabReportAndBornReports.toString());
		return getPatientLabReportAndBornReports;
		
		
		
		}
		
		
		
		
		 
		
		
		@RequestMapping(value = { "/getPatientReportByPatientAndDocId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetPatientReports> getPatientReportByPatientAndDocId(@RequestParam("patientId") int patientId,@RequestParam("doctorId") int doctorId)
		{
			List<GetPatientReports> getPatientReportListByreportId=new ArrayList<GetPatientReports>();
			SharingReportWithDoc sharingReportWithDocRes=new SharingReportWithDoc();
			
		    sharingReportWithDocRes=sharingReportWithDocRepository.getSharingInfo(patientId,doctorId);	
		    System.out.println(""+sharingReportWithDocRes.toString());
		    GetPatientReports getPatientReports = new GetPatientReports();
			String reportIds=sharingReportWithDocRes.getReportId();
			String[] reportId=reportIds.split(",");
			System.out.println("cccdd"+reportId.toString());
			LinkedHashSet<String> lhSetColors =  
	                new LinkedHashSet<String>(Arrays.asList(reportId));
	        
	        //create array from the LinkedHashSet
	        String[] newArray = lhSetColors.toArray(new String[ lhSetColors.size() ]);
			
			
			System.out.println("checing:"+newArray);
			System.out.println("length:"+newArray.length);
			int length=newArray.length;
			for(int i=length-1;i>0;i--)
			{ 	System.out.println("dddddd");
				System.out.println("newArray[i]:"+newArray[i]);
				getPatientReports=getPatientReportsRepository.getPatientReportByReportId(Integer.parseInt(newArray[i]));
				System.out.println("getPatientReports:"+getPatientReports.toString());
				getPatientReportListByreportId.add(getPatientReports);				
			}
					
			
		return getPatientReportListByreportId;
		
		}
		
		@RequestMapping(value = { "/getPatientReportByPatientAndTest" }, method = RequestMethod.POST)
		public @ResponseBody GetPatientLabReportAndBornReports getPatientReportByPatientAndTest(@RequestParam("patientId") int patientId,@RequestParam("testId") int testId)
		{
			System.out.println("patientId "+patientId);
			GetPatientLabReportAndBornReports getPatientLabReportAndBornReports=new GetPatientLabReportAndBornReports();
			List<GetPatientReports> getPatientReportsList=new ArrayList<GetPatientReports>();
			List<GetPatientBornReport> getPatientBornReportList=new ArrayList<GetPatientBornReport>();
			List<GetPatientUploadedReport> getPatientUploadedReportList=new ArrayList<GetPatientUploadedReport>();
			try {
			 getPatientReportsList=getPatientReportsRepository.getPatientReportBTest(patientId,testId);			
			 getPatientUploadedReportList=getPatientUploadedReportsRepository.getSelfUploadedReports(patientId,testId,0);
			 System.out.println("cnduscndhsbcshudcb"+getPatientUploadedReportList.toString());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
			//System.out.println("getPatientReportsList "+getPatientReportsList.toString());
			
			try {
			 getPatientBornReportList=getPatientBornReportRepository.getpatientBornReport(patientId);
			System.out.println("getPatientBornReportList  "+getPatientBornReportList.toString());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
			getPatientLabReportAndBornReports.setGetPatientBornReportList(getPatientBornReportList);
			getPatientLabReportAndBornReports.setGetPatientReportsList(getPatientReportsList);
			getPatientLabReportAndBornReports.setGetPatientUploadedReportList(getPatientUploadedReportList);
			System.out.println("getPatientLabReportAndBornReportsxx  "+getPatientLabReportAndBornReports.toString());
		return getPatientLabReportAndBornReports;
		
		
		
		}
}

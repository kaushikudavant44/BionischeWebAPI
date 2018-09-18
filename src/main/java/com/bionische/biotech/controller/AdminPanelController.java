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
 
import com.bionische.biotech.insurance.model.GetInsuranceDetails;
import com.bionische.biotech.insurance.model.GetPlanDetailsList;
import com.bionische.biotech.insurance.model.InsuranceCompanyDetails;
import com.bionische.biotech.insurance.model.InsurancePremium;
import com.bionische.biotech.insurance.model.InsuranceRating;
import com.bionische.biotech.insurance.model.InsuranceReview;
import com.bionische.biotech.insurance.repository.GetInsuranceDetailsRepository;
import com.bionische.biotech.insurance.repository.InsuranceCompanyDetailsRepository;
import com.bionische.biotech.insurance.repository.InsurancePremiumRepository;
import com.bionische.biotech.insurance.repository.InsuranceRatingRepository;
import com.bionische.biotech.insurance.repository.InsuranceReviewRepository;
import com.bionische.biotech.model.AdminDetails;
import com.bionische.biotech.model.AdminLogin;
import com.bionische.biotech.model.GetLabRatingReview;
import com.bionische.biotech.model.GetPatientReports;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientLogin;
import com.bionische.biotech.model.PrescriptionToMedical;
import com.bionische.biotech.model.RatingDetails;
import com.bionische.biotech.model.RatingDetailsList;
import com.bionische.biotech.model.TermsAndConditions;
import com.bionische.biotech.repository.AdminDetailsRepository;
import com.bionische.biotech.repository.GetLabRatingReviewRepository;
import com.bionische.biotech.repository.GetPatientReportsRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
import com.bionische.biotech.repository.PrescriptionToMedicalRepository;
import com.bionische.biotech.repository.RatingDetailsRepository;
import com.bionische.biotech.repository.TermsAndConditionsRepository;
import com.bionische.biotech.stemcell.model.GetStemCellsDetails;
import com.bionische.biotech.stemcell.repository.GetStemCellsDetailsRepository;

@RestController
public class AdminPanelController {

	@Autowired
	AdminDetailsRepository adminDetailsRepository;

	@Autowired
	GetInsuranceDetailsRepository getInsuranceDetailsRepository;
	
	@Autowired
	RatingDetailsRepository ratingDetailsRepository;
	
	@Autowired
	LabDetailsRepository labDetailsRepository;
	
	@Autowired
	GetPatientReportsRepository getPatientReportsRepository;
	
	@Autowired
	GetLabRatingReviewRepository getLabRatingReviewRepository;
	
	@Autowired
	MedicalDetailsRepository medicalDetailsRepository;
	
	@Autowired
	PrescriptionToMedicalRepository prescriptionToMedicalRepository;
	
	@Autowired
	InsuranceCompanyDetailsRepository insuranceCompanyDetailsRepository;
	
	@Autowired
	InsurancePremiumRepository insurancePremiumRepository;
	
	@Autowired
	InsuranceRatingRepository insuranceRatingRepository;
	
	@Autowired
	InsuranceReviewRepository insuranceReviewRepository;
	
	@Autowired
	GetStemCellsDetailsRepository getStemCellsDetailsRepository;
	
	@Autowired
	TermsAndConditionsRepository termsAndConditionsRepository;
	/*
	
	@RequestMapping(value = { "/getDoctorAppointmentDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDoctorAppointmentDetails> getDoctorAppointmentDetailsByPatientId(@RequestParam("patientId") int patientId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	{
		
		List<GetDoctorAppointmentDetails> getDoctorAppointmentDetailsList=new ArrayList<GetDoctorAppointmentDetails>();
		try {
		getDoctorAppointmentDetailsList=getDoctorAppointmentDetailsRepository.getAppointmentDetails(patientId, fromDate, toDate);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return getDoctorAppointmentDetailsList;
	}*/
	
	@RequestMapping(value = { "/getInsuranceDetailsByDateAndFamily" }, method = RequestMethod.POST)
	public @ResponseBody List<GetInsuranceDetails> getInsuranceDetailsByDateAndFamily(@RequestParam("familyId") int familyId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	{
		
		fromDate=DateConverter.convertToYMD(fromDate);
		toDate=DateConverter.convertToYMD(toDate);
		
		List<GetInsuranceDetails> getInsuranceDetailsList=new ArrayList<GetInsuranceDetails>();
		try {
			getInsuranceDetailsList=getInsuranceDetailsRepository.getInsuranceDetails(familyId, fromDate, toDate);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		}
		
		return getInsuranceDetailsList;
	}
	
	
	@RequestMapping(value = { "/getDoctorReviewRatingByDaoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<RatingDetails> getDoctorReviewRatingByDaoctorId(@RequestParam("doctorId") int doctorId)
	{
		List<RatingDetails> ratingDetailsList=new ArrayList<RatingDetails>();
		try {
			ratingDetailsList=ratingDetailsRepository.findByDoctorId(doctorId);
		
		 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return ratingDetailsList;
		
	}
	
	
	@RequestMapping(value = { "/deleteDoctorReviewRating" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDoctorReviewRating(@RequestParam("ratingReviewId") int ratingReviewId, @RequestParam("delStatus") int delStatus)
	{
		Info info=new Info();
		try {
			int res=ratingDetailsRepository.updateRatingReviewStatus(ratingReviewId, delStatus);
		
		 if(res>0) {
			 info.setError(false);
			 info.setMessage("Update Successfully");
		 }
		 else
		 {
			 info.setError(true);
			 info.setMessage("problem in Update status");
		 }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;
		
	}
	
	@RequestMapping(value = { "/getLabDetailsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody LabDetails getLabDetailsByLabId(@RequestParam("labId") int labId)
	{
		LabDetails labDetails=new LabDetails();
		try {
			labDetails=labDetailsRepository.getLabDetailsById(labId);
		
		  
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return labDetails;
		
	}
	
	@RequestMapping(value = { "/getReportsDetailLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPatientReports> getReportsDetailLabId(@RequestParam("labId") int labId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	{
		System.out.println("fromDate "+fromDate+" toDate "+toDate);
		fromDate=DateConverter.convertToYMD(fromDate);
		toDate=DateConverter.convertToYMD(toDate);
		
		List<GetPatientReports> GetPatientReportsList=new ArrayList<GetPatientReports>();
		try {
			GetPatientReportsList=getPatientReportsRepository.getPatientReportByLabId(labId, fromDate, toDate);
		
		  
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return GetPatientReportsList;
		
	}
	
	
	@RequestMapping(value = { "/getLabRatingReviewByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabRatingReview> getLabRatingReviewByLabId(@RequestParam("labId") int labId)
	{
		 
		
		List<GetLabRatingReview> getLabRatingReviewList=new ArrayList<GetLabRatingReview>();
		try {
			getLabRatingReviewList=getLabRatingReviewRepository.findByLabId(labId);
		
		  
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getLabRatingReviewList;
		
	}
	
	
	@RequestMapping(value = { "/deleteLabReviewRating" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLabReviewRating(@RequestParam("ratingReviewId") int ratingReviewId, @RequestParam("delStatus") int delStatus)
	{
		 
		
	 Info info=new Info();
		try {
			int res=getLabRatingReviewRepository.updateDeleteStatus(ratingReviewId, delStatus);
		
		  if(res>0)
		  {
			  info.setError(false);
			  info.setMessage("Success");
			  
		  }
		  else
		  {
			  info.setError(true);
			  info.setMessage("Failed");
			  
		  }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;
		
	}
	
	
	@RequestMapping(value = { "/getPharmacyDetailsByMedicalId" }, method = RequestMethod.POST)
	public @ResponseBody MedicalDetails getPharmacyDetailsByMedicalId(@RequestParam("medicalId") int medicalId)
	{
		MedicalDetails medicalDetails=new MedicalDetails();
		try {
			medicalDetails=medicalDetailsRepository.findByMedicalId(medicalId);
		
		  
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return medicalDetails;
		
	}
	
	
	@RequestMapping(value = { "/getPharmacyRequestDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<PrescriptionToMedical> getPharmacyRequestDetails(@RequestParam("medicalId") int medicalId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	{
		
		System.out.println("fromDate "+fromDate+" toDate "+toDate);
		fromDate=DateConverter.convertToYMD(fromDate);
		toDate=DateConverter.convertToYMD(toDate);
		List<PrescriptionToMedical> prescriptionToMedicalList=new ArrayList<PrescriptionToMedical>();
		try {
			
			prescriptionToMedicalList=prescriptionToMedicalRepository.findByMedicalIdAndDateBetween(medicalId, fromDate, toDate);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return prescriptionToMedicalList;
	}
	
	
	 

	@RequestMapping(value = { "/getInsuranceDetailsByInsuranceCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody InsuranceCompanyDetails getInsuranceDetailsByInsuranceCompanyId(@RequestParam("insuranceCompanyId") int insuranceCompanyId)
	{
		
		System.out.println("insuranceCompanyId "+insuranceCompanyId);
		InsuranceCompanyDetails insuranceCompanyDetails=new InsuranceCompanyDetails();
		try {
			insuranceCompanyDetails=insuranceCompanyDetailsRepository.findByInsuranceCompanyId(insuranceCompanyId);
		
		  System.out.println("insuranceCompanyDetails "+insuranceCompanyDetails.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return insuranceCompanyDetails;
		
	}
	
	
	
	

	@RequestMapping(value = { "/getInsuranceCoverListByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<InsurancePremium> getInsuranceCoverListByCompanyId(@RequestParam("insuranceCompanyId") int insuranceCompanyId)
	{
		
		System.out.println("insuranceCompanyId "+insuranceCompanyId);
		List<InsurancePremium> insurancePremiumList=new ArrayList<InsurancePremium>();
		try {
			insurancePremiumList=insurancePremiumRepository.getInsuranceCoverList(insuranceCompanyId);
		
		  System.out.println("insurancePremiumList "+insurancePremiumList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return insurancePremiumList;
		
	}
	
	
	
	
	@RequestMapping(value = { "/getCompanyPlanDetailsByCover" }, method = RequestMethod.POST)
	public @ResponseBody GetPlanDetailsList getCompanyPlanDetailsByCover(@RequestParam("insuranceCompanyId") int insuranceCompanyId, @RequestParam("cover") int cover)
	{
		
		System.out.println("insuranceCompanyId "+insuranceCompanyId);
		GetPlanDetailsList getPlanDetailsList=new GetPlanDetailsList();
		List<InsurancePremium> insurancePremiumList=new ArrayList<InsurancePremium>();
		List<InsurancePremium> familyTypeList=new ArrayList<InsurancePremium>();
		List<InsurancePremium> ageGroupList=new ArrayList<InsurancePremium>();
		try {
			
			familyTypeList=insurancePremiumRepository.getFamilyTypesByCompanyId(insuranceCompanyId);
			ageGroupList=insurancePremiumRepository.getAgeGroupByCompanyId(insuranceCompanyId);
			System.out.println("ageGroupList   "+ageGroupList.toString());
			insurancePremiumList=insurancePremiumRepository.findByCompanyIdAndCover(insuranceCompanyId, cover);
			getPlanDetailsList.setFamilyTypeList(familyTypeList);
			getPlanDetailsList.setInsurancePremiumList(insurancePremiumList);
			getPlanDetailsList.setAgeGroupList(ageGroupList);
		
		  System.out.println("getPlanDetailsList "+getPlanDetailsList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getPlanDetailsList;
		
	}
	
	@RequestMapping(value = { "/getRatingDetailsByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<InsuranceRating> getRatingDetailsByCompanyId(@RequestParam("insuranceCompanyId") int insuranceCompanyId)
	{
		
		
		List<InsuranceRating> insuranceRatingList=new ArrayList<InsuranceRating>();
		 
		try {
			
			insuranceRatingList=insuranceRatingRepository.findByCompanyId(insuranceCompanyId);
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return insuranceRatingList;
	}
	
	
	@RequestMapping(value = { "/getReviewDetailsByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<InsuranceReview> getReviewDetailsByCompanyId(@RequestParam("insuranceCompanyId") int insuranceCompanyId)
	{
		
		
		List<InsuranceReview> insuranceReviewList=new ArrayList<InsuranceReview>();
		 
		try {
			
			insuranceReviewList=insuranceReviewRepository.findByCompanyId(insuranceCompanyId);
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return insuranceReviewList;
	}
	
	
	
	
	@RequestMapping(value = { "/deleteInsuranceCompanyRating" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInsuranceCompanyRating(@RequestParam("ratingReviewId") int ratingReviewId, @RequestParam("delStatus") int delStatus)
	{
		 
		
	 Info info=new Info();
		try {
			int res=insuranceRatingRepository.updateDeleteStatus(ratingReviewId, delStatus);
		
		  if(res>0)
		  {
			  info.setError(false);
			  info.setMessage("Success");
			  
		  }
		  else
		  {
			  info.setError(true);
			  info.setMessage("Failed");
			  
		  }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;
		
	}
	
	
	@RequestMapping(value = { "/deleteInsuranceCompanyReview" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInsuranceCompanyReview(@RequestParam("ratingReviewId") int ratingReviewId, @RequestParam("delStatus") int delStatus)
	{
		 
		
	 Info info=new Info();
		try {
			int res=insuranceReviewRepository.updateDeleteStatus(ratingReviewId, delStatus);
		
		  if(res>0)
		  {
			  info.setError(false);
			  info.setMessage("Success");
			  
		  }
		  else
		  {
			  info.setError(true);
			  info.setMessage("Failed");
			  
		  }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;
		
	}
	
	
	
	

	@RequestMapping(value = { "/getStemCellsDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStemCellsDetails> getStemCellsDetailsByPatientId(@RequestParam("patientId") int patientId)
	{
		
		System.out.println("patientId "+patientId);
		List<GetStemCellsDetails> getStemCellsDetailsList=new ArrayList<GetStemCellsDetails>();
	 
		try {
			
			getStemCellsDetailsList=getStemCellsDetailsRepository.getStemCellsDetails(patientId);
		 
		  System.out.println("getStemCellsDetailsList "+getStemCellsDetailsList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getStemCellsDetailsList;
		
	}
	
	
	
	
	@RequestMapping(value = { "/insertTermsAndConditions" }, method = RequestMethod.POST)
	public @ResponseBody TermsAndConditions insertTermsAndConditions(@RequestBody TermsAndConditions termsAndConditions)
	{
		
		System.out.println("termsAndConditions "+termsAndConditions.toString());
		TermsAndConditions termsAndConditionsRes=new TermsAndConditions();
	 
		try {
			
			termsAndConditionsRes=termsAndConditionsRepository.save(termsAndConditions);
		 
		  System.out.println("termsAndConditionsRes "+termsAndConditionsRes.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return termsAndConditionsRes;
		
	}
	
	@RequestMapping(value = { "/getTermsAndConditionUserType"}, method = RequestMethod.POST)
	public @ResponseBody TermsAndConditions getTermsAndConditionUserType(@RequestParam("userType") int userType)
	{
		
		System.out.println("userType "+userType);
		TermsAndConditions termsAndConditions=new TermsAndConditions();
	 
		try {
			
			termsAndConditions=termsAndConditionsRepository.findByUserTypeAndDelStatus(userType, 0);
		 
		  System.out.println("termsAndConditions "+termsAndConditions.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return termsAndConditions;
		
	}
	
	@RequestMapping(value = { "/adminloginProcess" }, method = RequestMethod.POST)
	public @ResponseBody AdminLogin patientLoginProcess(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		System.out.println("dttfy;"+email);
		AdminDetails adminDetails=new AdminDetails();
		
		AdminLogin adminLogin=new AdminLogin();
		Info info=new Info();
		
		adminDetails=adminDetailsRepository.findByEmail(email);
		if(adminDetails!=null)
		{
			 
			if(adminDetails.getPassword().equals(password))
			{
				adminLogin.setAdminDetails(adminDetails);
				info.setError(false);
				info.setMessage("Login Successfull");
				adminLogin.setInfo(info);
			}
			else{
				info.setError(true);
				info.setMessage("Please enter valid credential");
				adminLogin.setInfo(info);
			}
		}
		else {
			info.setError(true);
			info.setMessage("Patient Not Register");
			adminLogin.setInfo(info);
		}
 
		
		
		System.out.println("res "+adminLogin.toString());
		return adminLogin;
	}
	
}

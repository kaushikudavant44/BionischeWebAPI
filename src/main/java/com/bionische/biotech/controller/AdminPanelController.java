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
import com.bionische.biotech.model.DoctorCertificateDetails;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.GetDocAvailableTimeDetails;
import com.bionische.biotech.model.GetDoctorHospitalDetails;
import com.bionische.biotech.model.GetLabRatingReview;
import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetPackageOffers;
import com.bionische.biotech.model.GetPatientReports;
import com.bionische.biotech.model.GetVerificationPendingCount;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabCertificateDetails;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.PackageDetails;
import com.bionische.biotech.model.PackageOffers;
import com.bionische.biotech.model.PharmacyCertificateDetails;
import com.bionische.biotech.model.RatingDetails;
import com.bionische.biotech.model.TermsAndConditions;
import com.bionische.biotech.repository.AdminDetailsRepository;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.DoctorCertificateDetailsRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.GetDocAvailableTimeDetailsRepository;
import com.bionische.biotech.repository.GetDoctorHospitalDetailsRepository;
import com.bionische.biotech.repository.GetLabRatingReviewRepository;
import com.bionische.biotech.repository.GetPackageOffersRepository;
import com.bionische.biotech.repository.GetPatientReportsRepository;
import com.bionische.biotech.repository.GetVerificationPendingCountRepository;
import com.bionische.biotech.repository.HospitalDetailsRepository;
import com.bionische.biotech.repository.LabCertificateDetailsRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.LabTestsRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
import com.bionische.biotech.repository.PackageDetailsRepository;
import com.bionische.biotech.repository.PackageOffersRepository;
import com.bionische.biotech.repository.PharmacyCertificateDetailsRepository;
import com.bionische.biotech.repository.RatingDetailsRepository;
import com.bionische.biotech.repository.TermsAndConditionsRepository;
import com.bionische.biotech.service.PrescriptionOrderService;
import com.bionische.biotech.service.SendFcmNotificationService;
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
	DoctorDetailsRepository doctorDetailsRepository;
	@Autowired
	PackageOffersRepository packageOffersRepository;
	/*
	 * @Autowired PrescriptionToMedicalRepository prescriptionToMedicalRepository;
	 */

	@Autowired
	PrescriptionOrderService prescriptionOrderService;

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

	@Autowired
	GetDoctorHospitalDetailsRepository getDoctorHospitalDetailsRepository;

	@Autowired
	HospitalDetailsRepository hospitalDetailsRepository;

	@Autowired
	GetDocAvailableTimeDetailsRepository getDocAvailableTimeDetailsRepository;

	@Autowired
	AppointmentTimeRepository appointmentTimeRepository;

	@Autowired
	LabTestsRepository labTestsRepository;
	
	@Autowired
	DoctorCertificateDetailsRepository doctorCertificateDetailsRepository;
	@Autowired
	PharmacyCertificateDetailsRepository pharmacyCertificateDetailsRepository;
	@Autowired
	LabCertificateDetailsRepository labCertificateDetailsRepository;
	
	@Autowired
	GetVerificationPendingCountRepository getVerificationPendingCountRepository;
	@Autowired
	PackageDetailsRepository packageDetailsRepository;
	@Autowired
	GetPackageOffersRepository getPackageOffersRepository;
	
	
	SendFcmNotificationService sendFcmNotificationService;
	/*
	 * 
	 * @RequestMapping(value = { "/getDoctorAppointmentDetailsByPatientId" }, method
	 * = RequestMethod.POST) public @ResponseBody List<GetDoctorAppointmentDetails>
	 * getDoctorAppointmentDetailsByPatientId(@RequestParam("patientId") int
	 * patientId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate")
	 * String toDate) {
	 * 
	 * List<GetDoctorAppointmentDetails> getDoctorAppointmentDetailsList=new
	 * ArrayList<GetDoctorAppointmentDetails>(); try {
	 * getDoctorAppointmentDetailsList=getDoctorAppointmentDetailsRepository.
	 * getAppointmentDetails(patientId, fromDate, toDate);
	 * 
	 * }catch (Exception e) { System.out.println(e.getMessage());// TODO: handle
	 * exception }
	 * 
	 * return getDoctorAppointmentDetailsList; }
	 */

	
	
	@RequestMapping(value = { "/getVerificationPendingCount" }, method = RequestMethod.GET)
	public @ResponseBody GetVerificationPendingCount getVerificationPendingCount() {
 
		return getVerificationPendingCountRepository.getVerificationCount();
	}
	
	@RequestMapping(value = { "/getInsuranceDetailsByDateAndFamily" }, method = RequestMethod.POST)
	public @ResponseBody List<GetInsuranceDetails> getInsuranceDetailsByDateAndFamily(
			@RequestParam("familyId") int familyId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		fromDate = DateConverter.convertToYMD(fromDate);
		toDate = DateConverter.convertToYMD(toDate);

		List<GetInsuranceDetails> getInsuranceDetailsList = new ArrayList<GetInsuranceDetails>();
		try {
			getInsuranceDetailsList = getInsuranceDetailsRepository.getInsuranceDetails(familyId, fromDate, toDate);

		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		}

		return getInsuranceDetailsList;
	}

	@RequestMapping(value = { "/getDoctorReviewRatingByDaoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<RatingDetails> getDoctorReviewRatingByDaoctorId(@RequestParam("doctorId") int doctorId) {
		List<RatingDetails> ratingDetailsList = new ArrayList<RatingDetails>();
		try {
			ratingDetailsList = ratingDetailsRepository.findByDoctorId(doctorId);

		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return ratingDetailsList;

	}

	@RequestMapping(value = { "/deleteDoctorReviewRating" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDoctorReviewRating(@RequestParam("ratingReviewId") int ratingReviewId,
			@RequestParam("delStatus") int delStatus) {
		Info info = new Info();
		try {
			int res = ratingDetailsRepository.updateRatingReviewStatus(ratingReviewId, delStatus);

			if (res > 0) {
				info.setError(false);
				info.setMessage("Update Successfully");
			} else {
				info.setError(true);
				info.setMessage("problem in Update status");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;

	}

	@RequestMapping(value = { "/getLabDetailsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody LabDetails getLabDetailsByLabId(@RequestParam("labId") int labId) {
		LabDetails labDetails = new LabDetails();
		try {
			labDetails = labDetailsRepository.getLabDetailsById(labId);

		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return labDetails;

	}

	@RequestMapping(value = { "/getReportsDetailLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPatientReports> getReportsDetailLabId(@RequestParam("labId") int labId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		System.out.println("fromDate " + fromDate + " toDate " + toDate);

		List<GetPatientReports> GetPatientReportsList = new ArrayList<GetPatientReports>();
		try {
			GetPatientReportsList = getPatientReportsRepository.getPatientReportByLabId(labId, fromDate, toDate);

		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return GetPatientReportsList;

	}

	@RequestMapping(value = { "/getLabRatingReviewByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabRatingReview> getLabRatingReviewByLabId(@RequestParam("labId") int labId) {

		List<GetLabRatingReview> getLabRatingReviewList = new ArrayList<GetLabRatingReview>();
		try {
			getLabRatingReviewList = getLabRatingReviewRepository.findByLabId(labId);

		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getLabRatingReviewList;

	}

	@RequestMapping(value = { "/deleteLabReviewRating" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLabReviewRating(@RequestParam("ratingReviewId") int ratingReviewId,
			@RequestParam("delStatus") int delStatus) {

		Info info = new Info();
		try {
			int res = getLabRatingReviewRepository.updateDeleteStatus(ratingReviewId, delStatus);

			if (res > 0) {
				info.setError(false);
				info.setMessage("Success");

			} else {
				info.setError(true);
				info.setMessage("Failed");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;

	}

	@RequestMapping(value = { "/getPharmacyDetailsByMedicalId" }, method = RequestMethod.POST)
	public @ResponseBody MedicalDetails getPharmacyDetailsByMedicalId(@RequestParam("medicalId") int medicalId) {
		MedicalDetails medicalDetails = new MedicalDetails();
		try {
			medicalDetails = medicalDetailsRepository.findByMedicalId(medicalId);

		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return medicalDetails;

	}

	/*
	 * @RequestMapping(value = { "/getPharmacyRequestDetails" }, method =
	 * RequestMethod.POST) public @ResponseBody List<PrescriptionToMedical>
	 * getPharmacyRequestDetails(@RequestParam("medicalId") int
	 * medicalId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate")
	 * String toDate) {
	 * 
	 * System.out.println("fromDate "+fromDate+" toDate "+toDate);
	 * fromDate=DateConverter.convertToYMD(fromDate);
	 * toDate=DateConverter.convertToYMD(toDate); List<PrescriptionToMedical>
	 * prescriptionToMedicalList=new ArrayList<PrescriptionToMedical>(); try {
	 * 
	 * prescriptionToMedicalList=prescriptionToMedicalRepository.
	 * findByMedicalIdAndDateBetween(medicalId, fromDate, toDate);
	 * 
	 * 
	 * }catch (Exception e) { System.out.println(e.getMessage());// TODO: handle
	 * exception } return prescriptionToMedicalList; }
	 */

	@RequestMapping(value = { "/getInsuranceDetailsByInsuranceCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody InsuranceCompanyDetails getInsuranceDetailsByInsuranceCompanyId(
			@RequestParam("insuranceCompanyId") int insuranceCompanyId) {

		System.out.println("insuranceCompanyId " + insuranceCompanyId);
		InsuranceCompanyDetails insuranceCompanyDetails = new InsuranceCompanyDetails();
		try {
			insuranceCompanyDetails = insuranceCompanyDetailsRepository.findByInsuranceCompanyId(insuranceCompanyId);

			System.out.println("insuranceCompanyDetails " + insuranceCompanyDetails.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return insuranceCompanyDetails;

	}

	@RequestMapping(value = { "/getInsuranceCoverListByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<InsurancePremium> getInsuranceCoverListByCompanyId(
			@RequestParam("insuranceCompanyId") int insuranceCompanyId) {

		System.out.println("insuranceCompanyId " + insuranceCompanyId);
		List<InsurancePremium> insurancePremiumList = new ArrayList<InsurancePremium>();
		try {
			insurancePremiumList = insurancePremiumRepository.getInsuranceCoverList(insuranceCompanyId);

			System.out.println("insurancePremiumList " + insurancePremiumList.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return insurancePremiumList;

	}

	@RequestMapping(value = { "/getCompanyPlanDetailsByCover" }, method = RequestMethod.POST)
	public @ResponseBody GetPlanDetailsList getCompanyPlanDetailsByCover(
			@RequestParam("insuranceCompanyId") int insuranceCompanyId, @RequestParam("cover") int cover) {

		System.out.println("insuranceCompanyId " + insuranceCompanyId);
		GetPlanDetailsList getPlanDetailsList = new GetPlanDetailsList();
		List<InsurancePremium> insurancePremiumList = new ArrayList<InsurancePremium>();
		List<InsurancePremium> familyTypeList = new ArrayList<InsurancePremium>();
		List<InsurancePremium> ageGroupList = new ArrayList<InsurancePremium>();
		try {

			familyTypeList = insurancePremiumRepository.getFamilyTypesByCompanyId(insuranceCompanyId);
			ageGroupList = insurancePremiumRepository.getAgeGroupByCompanyId(insuranceCompanyId);
			System.out.println("ageGroupList   " + ageGroupList.toString());
			insurancePremiumList = insurancePremiumRepository.findByCompanyIdAndCover(insuranceCompanyId, cover);
			getPlanDetailsList.setFamilyTypeList(familyTypeList);
			getPlanDetailsList.setInsurancePremiumList(insurancePremiumList);
			getPlanDetailsList.setAgeGroupList(ageGroupList);

			System.out.println("getPlanDetailsList " + getPlanDetailsList.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getPlanDetailsList;

	}

	@RequestMapping(value = { "/getRatingDetailsByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<InsuranceRating> getRatingDetailsByCompanyId(
			@RequestParam("insuranceCompanyId") int insuranceCompanyId) {

		List<InsuranceRating> insuranceRatingList = new ArrayList<InsuranceRating>();

		try {

			insuranceRatingList = insuranceRatingRepository.findByCompanyId(insuranceCompanyId);
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}

		return insuranceRatingList;
	}

	@RequestMapping(value = { "/getReviewDetailsByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<InsuranceReview> getReviewDetailsByCompanyId(
			@RequestParam("insuranceCompanyId") int insuranceCompanyId) {

		List<InsuranceReview> insuranceReviewList = new ArrayList<InsuranceReview>();

		try {

			insuranceReviewList = insuranceReviewRepository.findByCompanyId(insuranceCompanyId);
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}

		return insuranceReviewList;
	}

	@RequestMapping(value = { "/deleteInsuranceCompanyRating" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInsuranceCompanyRating(@RequestParam("ratingReviewId") int ratingReviewId,
			@RequestParam("delStatus") int delStatus) {

		Info info = new Info();
		try {
			int res = insuranceRatingRepository.updateDeleteStatus(ratingReviewId, delStatus);

			if (res > 0) {
				info.setError(false);
				info.setMessage("Success");

			} else {
				info.setError(true);
				info.setMessage("Failed");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;

	}

	@RequestMapping(value = { "/deleteInsuranceCompanyReview" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteInsuranceCompanyReview(@RequestParam("ratingReviewId") int ratingReviewId,
			@RequestParam("delStatus") int delStatus) {

		Info info = new Info();
		try {
			int res = insuranceReviewRepository.updateDeleteStatus(ratingReviewId, delStatus);

			if (res > 0) {
				info.setError(false);
				info.setMessage("Success");

			} else {
				info.setError(true);
				info.setMessage("Failed");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;

	}

	@RequestMapping(value = { "/getStemCellsDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStemCellsDetails> getStemCellsDetailsByPatientId(
			@RequestParam("patientId") int patientId) {

		System.out.println("patientId " + patientId);
		List<GetStemCellsDetails> getStemCellsDetailsList = new ArrayList<GetStemCellsDetails>();

		try {

			getStemCellsDetailsList = getStemCellsDetailsRepository.getStemCellsDetails(patientId);

			System.out.println("getStemCellsDetailsList " + getStemCellsDetailsList.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getStemCellsDetailsList;

	}

	@RequestMapping(value = { "/insertTermsAndConditions" }, method = RequestMethod.POST)
	public @ResponseBody TermsAndConditions insertTermsAndConditions(
			@RequestBody TermsAndConditions termsAndConditions) {

		System.out.println("termsAndConditions " + termsAndConditions.toString());
		TermsAndConditions termsAndConditionsRes = new TermsAndConditions();

		try {

			termsAndConditionsRes = termsAndConditionsRepository.save(termsAndConditions);

			System.out.println("termsAndConditionsRes " + termsAndConditionsRes.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return termsAndConditionsRes;

	}

	@RequestMapping(value = { "/getTermsAndConditionUserType" }, method = RequestMethod.POST)
	public @ResponseBody TermsAndConditions getTermsAndConditionUserType(@RequestParam("userType") int userType) {

		System.out.println("userType " + userType);
		 TermsAndConditions termsAndConditions  = new TermsAndConditions();

		try {

			termsAndConditions = termsAndConditionsRepository.findByUserTypeAndDelStatus(userType, 0);

			System.out.println("termsAndConditions " + termsAndConditions.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		} 
		return termsAndConditions;

	}

	@RequestMapping(value = { "/adminloginProcess" }, method = RequestMethod.POST)
	public @ResponseBody AdminLogin patientLoginProcess(@RequestParam("email") String email,
			@RequestParam("password") String password) {

		System.out.println("dttfy;" + email);
		AdminDetails adminDetails = new AdminDetails();

		AdminLogin adminLogin = new AdminLogin();
		Info info = new Info();

		adminDetails = adminDetailsRepository.findByEmail(email);
		if (adminDetails != null) {
			info.setError(true);
			if (adminDetails.getPassword().equals(password)) {
				adminLogin.setAdminDetails(adminDetails);
				info.setError(false);
				info.setMessage("Login Successfull");
				adminLogin.setInfo(info);
			} else {
				info.setError(true);
				info.setMessage("Please enter valid credential");
				adminLogin.setInfo(info);
			}
		} else {
			info.setError(true);
			info.setMessage("Invalid User");
			adminLogin.setInfo(info);
		}

		System.out.println("res " + adminLogin.toString());
		return adminLogin;
	}

	@RequestMapping(value = { "/getMedicalOrderDetailsByMedicalIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndDate(
			@RequestParam("medicalId") int medicalId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		return prescriptionOrderService.getMedicalOrderDetailsByMedicalIdAndDate(medicalId, fromDate, toDate);
	}

	@RequestMapping(value = { "/getMedicalOrderDetailsByPatientIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getMedicalOrderDetailsByPatientIdAndDate(
			@RequestParam("patientId") int patientId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		return prescriptionOrderService.getMedicalOrderDetailsByPatientIdAndDate(patientId, fromDate, toDate);
	}

	@RequestMapping(value = { "/getAllDoctorsHospitalDetails" }, method = RequestMethod.POST)
	public List<GetDoctorHospitalDetails> getAllDoctorsHospitalDetails(@RequestParam("doctorId") int doctorId) {

		return getDoctorHospitalDetailsRepository.getHospitalDetailsByDoctorIdAndDelStatus(doctorId);

	}

	@RequestMapping(value = { "/getAllHospitalByType" }, method = RequestMethod.GET)
	public List<HospitalDetails> getAllHospitalByType() {

		return hospitalDetailsRepository.findByType(1);

	}

	@RequestMapping(value = { "/getAvailableTimeDetailsBydate" }, method = RequestMethod.POST)
	public List<GetDocAvailableTimeDetails> getAvailableTimeDetailsBydate(@RequestParam("doctorId") int doctorId,
			@RequestParam("date") String date) {

		List<GetDocAvailableTimeDetails> getDocAvailableTimeDetailsList = getDocAvailableTimeDetailsRepository
				.getDocAvailableTimeDetails(doctorId, date);
		for (int i = 0; i < getDocAvailableTimeDetailsList.size(); i++) {

			List<String> availableTimeList = appointmentTimeRepository.getAppointTimeByIdList(
					Arrays.asList(getDocAvailableTimeDetailsList.get(i).getAvailableTime().split(",")));
			getDocAvailableTimeDetailsList.get(i).setAvailableTime(String.join(", ", availableTimeList));
		}

		return getDocAvailableTimeDetailsList;

	}

	@RequestMapping(value = { "/activeClinicById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteClinicById(@RequestParam("hospitalId") int hospitalId) {

		Info info = new Info();

		try {
			int delStatus = hospitalDetailsRepository.deleteClinic(hospitalId, 0);
			if (delStatus != 0) {
				info.setMessage("Clinic Delete Successfully");

			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return info;
	}

	@RequestMapping(value = { "/getAllLabTestsForAdmin" }, method = RequestMethod.GET)
	public List<LabTests> getAllLabTestsForAdmin() {
		List<LabTests> labTestsList = new ArrayList<LabTests>();
		try {
			labTestsList = labTestsRepository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return labTestsList;

	}

	@RequestMapping(value = { "/insertLabTest" }, method = RequestMethod.POST)
	public LabTests insertLabTest(@RequestBody LabTests LabTests) {
		LabTests labTestsRes = new LabTests();
		try {
			labTestsRes = labTestsRepository.save(LabTests);
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return labTestsRes;
	}

	@RequestMapping(value = { "/deleteLabTest" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLabTest(@RequestParam("labTestId") int labTestId) {
		Info info = new Info();
		try {
			int delStatus = labTestsRepository.updateTestStatus(labTestId, 1);
			if (delStatus != 0) {
				info.setMessage("Test Delete Successfully");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	}
	
	@RequestMapping(value = { "/reactivateLabTest" }, method = RequestMethod.POST)
	public @ResponseBody Info reactivateLabTest(@RequestParam("labTestId") int labTestId) {
		Info info = new Info();
		try {
			int delStatus = labTestsRepository.updateTestStatus(labTestId, 0);
			if (delStatus != 0) {
				info.setMessage("Test Reactive Successfully");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	}
	
	
	@RequestMapping(value = { "/getDoctorCertificate" }, method = RequestMethod.POST)
	public @ResponseBody DoctorCertificateDetails getDoctorCertificate(@RequestParam("doctorId") int doctorId) {
		DoctorCertificateDetails doctorCertificateDetails=new DoctorCertificateDetails();
		try {
			doctorCertificateDetails = doctorCertificateDetailsRepository.findByDoctorIdAndDelStatus(doctorId, 2);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doctorCertificateDetails;
	} 
	
	@RequestMapping(value = { "/getLabCertificate" }, method = RequestMethod.POST)
	public @ResponseBody LabCertificateDetails getLabCertificate(@RequestParam("labId") int labId) {
		LabCertificateDetails labCertificateDetails=new LabCertificateDetails();
		try {
			labCertificateDetails = labCertificateDetailsRepository.findByLabIdAndDelStatus(labId, 2);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return labCertificateDetails;
	}
	
	@RequestMapping(value = { "/getPharmacyCertificate" }, method = RequestMethod.POST)
	public @ResponseBody PharmacyCertificateDetails getPharmacyCertificate(@RequestParam("medicalId") int medicalId) {
		PharmacyCertificateDetails pharmacyCertificateDetails=new PharmacyCertificateDetails();
		try {
			pharmacyCertificateDetails = pharmacyCertificateDetailsRepository.findByMedicalIdAndDelStatus(medicalId, 2);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pharmacyCertificateDetails;
	}
	@RequestMapping(value = { "/getDoctorAllCertificate" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorCertificateDetails> getDoctorAllCertificate(@RequestParam("doctorId") int doctorId) {
		List<DoctorCertificateDetails> doctorCertificateDetailsList=new ArrayList<DoctorCertificateDetails>();
		try {
			doctorCertificateDetailsList = doctorCertificateDetailsRepository.findByDoctorIdOrderByDelStatusDesc(doctorId);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doctorCertificateDetailsList;
	} 
	
	
	
	@RequestMapping(value = { "/doctorVerificationProcess" }, method = RequestMethod.POST)
	public @ResponseBody Info doctorVerificationProcess(@RequestParam("doctorId") int doctorId) {
		Info info=new Info();
		try {
			int res = doctorDetailsRepository.updateDoctorDelStatus(doctorId, 0);
			doctorCertificateDetailsRepository.updateCertificateDelStatus(doctorId,2, "Accepted");
			DoctorDetails doctorDetails=doctorDetailsRepository.findByDoctorId(doctorId);
			
			
			 if(res>0)
			 {
				 info.setError(false);
				 info.setMessage("Doctor DelStatus Update Successfully");
				 
				 if(doctorDetails.getInt1()==0) {
				 sendFcmNotificationService.notifyUser(doctorDetails.getLocation(), "Bionische", "Your Verification Completed. Welcome to Bionische", DateConverter.currentDateAndTime(),1);
				 } else if(doctorDetails.getInt1()==1) {
					 
					 sendFcmNotificationService.notifyiOSUser(doctorDetails.getLocation(), "Bionische", "Your Verification Completed. Welcome to Bionische", DateConverter.currentDateAndTime(),1);
					 
				 }
				 
				 
				 
			}
			 else 
			 {
				 info.setError(true);
				 info.setMessage("Failed to update Doctor DelStatus");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	} 
	@RequestMapping(value = { "/doctorVerificationReject" }, method = RequestMethod.POST)
	public @ResponseBody Info doctorVerificationReject(@RequestParam("doctorId") int doctorId, @RequestParam("message")String message) {
		Info info=new Info();
		try {
			int res = doctorDetailsRepository.updateDoctorDelStatus(doctorId, 3);
			doctorCertificateDetailsRepository.updateCertificateDelStatus(doctorId, 1, message);
			DoctorDetails doctorDetails=doctorDetailsRepository.findByDoctorId(doctorId);
			String msg="Please re-submit your documents. Verification failed.";
			 if(res>0)
			 {
				 info.setError(false);
				 info.setMessage("Doctor DelStatus Update Successfully");
				 
				 if(doctorDetails.getInt1()==0) {
				 sendFcmNotificationService.notifyUser(doctorDetails.getLocation(), "Bionische", msg, DateConverter.currentDateAndTime(),2);
				 }else if(doctorDetails.getInt1()==1) {
					 
					 sendFcmNotificationService.notifyiOSUser(doctorDetails.getLocation(), "Bionische", msg, DateConverter.currentDateAndTime(),2); 
				 }
				 
				 
				}
			 else 
			 {
				 info.setError(true);
				 info.setMessage("Failed to update Doctor DelStatus");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	} 
	
	@RequestMapping(value = { "/getDoctorPendingVerificationList" }, method = RequestMethod.GET)
	public @ResponseBody List<DoctorCertificateDetails> getDoctorPendingVerificationList() {
		List<DoctorCertificateDetails> doctorCertificateDetailsList=new ArrayList<DoctorCertificateDetails>();
		try {
			doctorCertificateDetailsList = doctorCertificateDetailsRepository.getDoctorPendingVerificationList();
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doctorCertificateDetailsList;
	} 
	
	
	@RequestMapping(value = { "/getLabAllCertificate" }, method = RequestMethod.POST)
	public @ResponseBody List<LabCertificateDetails> getLabAllCertificate(@RequestParam("labId") int labId) {
		List<LabCertificateDetails> labCertificateDetailsList=new ArrayList<LabCertificateDetails>();
		try {
			labCertificateDetailsList = labCertificateDetailsRepository.findByLabIdOrderByDelStatusDesc(labId);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return labCertificateDetailsList; 
	} 
	
	
	@RequestMapping(value = { "/getLabPendingVerificationList" }, method = RequestMethod.GET)
	public @ResponseBody List<LabCertificateDetails> getLabPendingVerificationList() {
		List<LabCertificateDetails> labCertificateDetailsList=new ArrayList<LabCertificateDetails>();
		try {
			labCertificateDetailsList = labCertificateDetailsRepository.getLabPendingVerificationList();
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return labCertificateDetailsList;
	} 
	@RequestMapping(value = { "/labVerificationReject" }, method = RequestMethod.POST)
	public @ResponseBody Info labVerificationReject(@RequestParam("labId") int labId, @RequestParam("message")String message) {
		Info info=new Info();
		try {
			int res = labDetailsRepository.updateLabDelStatus(labId, 3);
			labCertificateDetailsRepository.updateCertificateDelStatus(labId, 1, message);
			 if(res>0)
			 {
				 info.setError(false);
				 info.setMessage("Lab DelStatus Update Successfully");
			 }
			 else 
			 {
				 info.setError(true);
				 info.setMessage("Failed to update Lab DelStatus");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	} 

	@RequestMapping(value = { "/labVerificationProcess" }, method = RequestMethod.POST)
	public @ResponseBody Info labVerificationProcess(@RequestParam("labId") int labId) {
		Info info=new Info();
		try {
			int res = labDetailsRepository.updateLabDelStatus(labId, 0);
			labCertificateDetailsRepository.updateCertificateDelStatus(labId,2, "Accepted");
			 if(res>0)
			 {
				 info.setError(false);
				 info.setMessage("Lab DelStatus Update Successfully");
			 }
			 else 
			 {
				 info.setError(true);
				 info.setMessage("Failed to update Lab DelStatus");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	} 
	
	
	@RequestMapping(value = { "/getPharmacyPendingVerificationList" }, method = RequestMethod.GET)
	public @ResponseBody List<PharmacyCertificateDetails> getPharmacyPendingVerificationList() {
		List<PharmacyCertificateDetails> pharmacyCertificateDetailsList=new ArrayList<PharmacyCertificateDetails>();
		try {
			pharmacyCertificateDetailsList = pharmacyCertificateDetailsRepository.getPharmacyPendingVerificationList();
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pharmacyCertificateDetailsList;
	} 
	
	@RequestMapping(value = { "/getPharmacyAllCertificate" }, method = RequestMethod.POST)
	public @ResponseBody List<PharmacyCertificateDetails> getPharmacyAllCertificate(@RequestParam("medicalId") int medicalId) {
		List<PharmacyCertificateDetails> pharmacyCertificateDetailsList=new ArrayList<PharmacyCertificateDetails>();
		try {
			pharmacyCertificateDetailsList = pharmacyCertificateDetailsRepository.findByMedicalIdOrderByDelStatusDesc(medicalId);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pharmacyCertificateDetailsList; 
	} 
	
	@RequestMapping(value = { "/pharmacyVerificationReject" }, method = RequestMethod.POST)
	public @ResponseBody Info pharmacyVerificationReject(@RequestParam("medicalId") int medicalId, @RequestParam("message")String message) {
		Info info=new Info();
		try {
			int res = medicalDetailsRepository.updateMedicalDelStatus(medicalId, 3);
			pharmacyCertificateDetailsRepository.updateCertificateDelStatus(medicalId, 1, message);
			 if(res>0)
			 {
				 info.setError(false);
				 info.setMessage("medical DelStatus Update Successfully");
				 
			 }
			 else 
			 {
				 info.setError(true);
				 info.setMessage("Failed to update medical DelStatus");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	} 
	
	@RequestMapping(value = { "/pharmacyVerificationProcess" }, method = RequestMethod.POST)
	public @ResponseBody Info pharmacyVerificationProcess(@RequestParam("medicalId") int medicalId) {
		Info info=new Info();
		try {
			int res = medicalDetailsRepository.updateMedicalDelStatus(medicalId, 0);
			pharmacyCertificateDetailsRepository.updateCertificateDelStatus(medicalId,2, "Accepted");
			 if(res>0)
			 {
				 info.setError(false);
				 info.setMessage("Pharmacy DelStatus Update Successfully");
			 }
			 else 
			 {
				 info.setError(true);
				 info.setMessage("Failed to update Pharmacy DelStatus");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;
	} 
	
	
	 
	@RequestMapping(value = { "/insertPackageDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertPackageDetails(@RequestBody PackageDetails packageDetails) {
	 
		Info info=new Info();
		try {
			PackageDetails packageDetailsRes = packageDetailsRepository.save(packageDetails);
			
			 if(packageDetailsRes!=null)
			 {
				 info.setError(false);
				 info.setMessage("Package Details Save successfully");
			 }
			 else
			 {
				 info.setError(true);
				 info.setMessage("Failed to save package details");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 info.setError(true);
			 info.setMessage("Failed to save package details");
		}
		return info; 
	} 
	@RequestMapping(value = { "/getCurrentPackageDetailsByUserType" }, method = RequestMethod.POST)
	public @ResponseBody List<PackageDetails> getCurrentPackageDetailsByUserType(@RequestParam("userType")int userType) {
	 
		List<PackageDetails> packageDetailsList=new ArrayList<PackageDetails>();
		
		try {
			packageDetailsList= packageDetailsRepository.findByUserTypeAndDelStatus(userType,0);
			
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		 
		}
		return packageDetailsList; 
	} 
	
	@RequestMapping(value = { "/insertPackageOffers" }, method = RequestMethod.POST)
	public @ResponseBody Info insertPackageOffers(@RequestBody PackageOffers packageOffers) {
	 
		Info info=new Info();
		try {
			PackageOffers packageOffersRes = packageOffersRepository.save(packageOffers);
			
			 if(packageOffersRes!=null)
			 {
				 info.setError(false);
				 info.setMessage("Package Offers Save successfully");
			 }
			 else
			 {
				 info.setError(true);
				 info.setMessage("Failed to save package Offers");
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 info.setError(true);
			 info.setMessage("Failed to save package details");
		}
		return info; 
	} 
	@RequestMapping(value = { "/getCurrentActivePackageOffers" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPackageOffers> getCurrentActivePackageOffers() {
	 
		List<GetPackageOffers> getPackageOffersList=new ArrayList<GetPackageOffers>();
		
		try {
			getPackageOffersList= getPackageOffersRepository.getCurrentActivePackageOffers();
			
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		 
		}
		return getPackageOffersList; 
	} 
	
	@RequestMapping(value = { "/deletePackageOffer" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePackageOffer(@RequestParam("offerId")int offerId) {
	 
		Info info=new Info();
		try {
			int res= packageOffersRepository.deletePackageOffers(offerId);
			if(res>0)
			{
				info.setError(false);
				info.setMessage("Offer Delete Successfully");
			}
			else
			{
				info.setError(true);
				info.setMessage("Failed to Delete offer");
			}
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed to Delete offer");
		 
		}
		return info; 
	} 
	@RequestMapping(value = { "/deletePackage" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePackage(@RequestParam("packageId")int packageId) {
	 
		Info info=new Info();
		try {
			int res= packageDetailsRepository.deletePackage(packageId);
			if(res>0)
			{
				info.setError(false);
				info.setMessage("Package Delete Successfully");
			}
			else
			{
				info.setError(true);
				info.setMessage("Failed to Delete Package");
			}
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed to Delete Package");
		 
		}
		return info; 
	} 
}

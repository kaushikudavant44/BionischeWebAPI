package com.bionische.biotech.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.Constants;
import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.ewallet.model.ReferalDetails;
import com.bionische.biotech.ewallet.model.WalletDetails;
import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.AppointmentList;
import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.AppointmentTimeList;
import com.bionische.biotech.model.City;
import com.bionische.biotech.model.Country;
import com.bionische.biotech.model.DocAvailableTime;
import com.bionische.biotech.model.DoctorCertificateDetails;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorDetailsInformation;
import com.bionische.biotech.model.DoctorNotification;
import com.bionische.biotech.model.FamilyDetails;
import com.bionische.biotech.model.ForgetPwdVerificationCode;
import com.bionische.biotech.model.FreequantlyUsedMedicines;
import com.bionische.biotech.model.GetAppointmentDetails;
import com.bionische.biotech.model.GetDoctorDetails;
import com.bionische.biotech.model.GetDoctorListForAppointment;
import com.bionische.biotech.model.GetDoctorProfile;
import com.bionische.biotech.model.GetDoctorRatingReviewCount;
import com.bionische.biotech.model.GetHospitalClinicByDoctorIdAndAvailDate;
import com.bionische.biotech.model.GetLabAppointment;
import com.bionische.biotech.model.GetLabRatingReview;
import com.bionische.biotech.model.GetPatientContactDetailsById;
import com.bionische.biotech.model.GetPatientDetailsForEdit;
import com.bionische.biotech.model.GetPatientReviews;
import com.bionische.biotech.model.GetRatingCount;
import com.bionische.biotech.model.GetUsersCount;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabCertificateDetails;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.PatientAddress;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientMemberRelation;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.model.PatientSuscriptionDetails;
import com.bionische.biotech.model.PharmacyCertificateDetails;
import com.bionische.biotech.model.PrescriptionDetails;
import com.bionische.biotech.model.RatingDetails;
import com.bionische.biotech.model.RatingDetailsList;
import com.bionische.biotech.model.SharingReportWithDoc;
import com.bionische.biotech.model.SpecializationDetails;
import com.bionische.biotech.model.SpecializationDetailsList;
import com.bionische.biotech.model.State;
import com.bionische.biotech.model.TermsAndConditions;
import com.bionische.biotech.repository.AppointmentDetailsRepository;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.CityRepository;
import com.bionische.biotech.repository.CountryRepository;
import com.bionische.biotech.repository.DocAvailableTimeRepository;
import com.bionische.biotech.repository.DoctorCertificateDetailsRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.DoctorNotificationRepository;
import com.bionische.biotech.repository.DoctorPatientMeetingRepository;
import com.bionische.biotech.repository.FamilyDetailsRepository;
import com.bionische.biotech.repository.ForgetPwdVerificationCodeRepository;
import com.bionische.biotech.repository.FreequantlyUsedMedicinesRepository;
import com.bionische.biotech.repository.GetAppointmentDetailsRepository;
import com.bionische.biotech.repository.GetDoctorDetailsInformationRepository;
import com.bionische.biotech.repository.GetDoctorDetailsRepository;
import com.bionische.biotech.repository.GetDoctorListForAppointmentRepository;
import com.bionische.biotech.repository.GetDoctorProfileRepository;
import com.bionische.biotech.repository.GetHospitalClinicByDoctorIdAndAvailDateRepository;
import com.bionische.biotech.repository.GetLabAppointmentRrepository;
import com.bionische.biotech.repository.GetLabRatingReviewRepository;
import com.bionische.biotech.repository.GetPatientContactDetailsByIdRepository;
import com.bionische.biotech.repository.GetPatientDetailsForEditRepository;
import com.bionische.biotech.repository.GetRatingCountRepository;
import com.bionische.biotech.repository.GetUsersCountRepository;
import com.bionische.biotech.repository.HospitalDetailsRepository;
import com.bionische.biotech.repository.LabCertificateDetailsRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.LabNotificationRepository;
import com.bionische.biotech.repository.LabTestsRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
import com.bionische.biotech.repository.PatientAddressRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.PatientMemberRelationRepository;
import com.bionische.biotech.repository.PatientNotificationRepository;
import com.bionische.biotech.repository.PatientSuscriptionDetailsRepository;
import com.bionische.biotech.repository.PharmacyCertificateDetailsRepository;
import com.bionische.biotech.repository.PrescriptionDetailsRepository;
import com.bionische.biotech.repository.RatingDetailsRepository;
import com.bionische.biotech.repository.ReferalDetailsRepository;
import com.bionische.biotech.repository.SharingReportWithDocRepository;
import com.bionische.biotech.repository.SpecializationDetailsRepository;
import com.bionische.biotech.repository.StateRepository;
import com.bionische.biotech.repository.TermsAndConditionsRepository;
import com.bionische.biotech.repository.WalletDetailsRepository;
import com.bionische.biotech.repository.lab.LabAppointmentDetailsRepository;
import com.bionische.biotech.service.CreateDirectoryService;
import com.bionische.biotech.service.FixDoctorScheduleService;
import com.bionische.biotech.service.SendEMailService;
import com.bionische.biotech.service.SendFcmNotificationService;
import com.bionische.biotech.service.SendTextMessageService;
import com.bionische.biotech.service.SharingReportToDoctorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestApiController {

	private static final char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	@Autowired
	SharingReportToDoctorService sharingReportToDoctorService;
	@Autowired
	GetPatientDetailsForEditRepository getPatientDetailsForEditRepository;
	@Autowired
	SendFcmNotificationService sendFcmNotificationService;

	@Autowired
	FreequantlyUsedMedicinesRepository freequantlyUsedMedicinesRepository;

	@Autowired
	ForgetPwdVerificationCodeRepository forgetPwdVerificationCodeRepository;

	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;

	@Autowired
	PatientDetailsRepository patientDetailsRepository;

	@Autowired
	SpecializationDetailsRepository specializationDetailsRepository;

	@Autowired
	RatingDetailsRepository ratingDetailsRepository;

	@Autowired
	AppointmentDetailsRepository appointmentDetailsRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	PrescriptionDetailsRepository prescriptionDetailsRepository;

	@Autowired
	AppointmentTimeRepository appointmentTimeRepository;

	@Autowired
	GetDoctorListForAppointmentRepository getDoctorListForAppointmentRepository;

	@Autowired
	GetAppointmentDetailsRepository getAppointmentDetailsRepository;

	@Autowired
	GetLabAppointmentRrepository getLabAppointmentRrepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	FamilyDetailsRepository familyDetailsRepository;

	@Autowired
	LabDetailsRepository labDetailsRepository;

	@Autowired
	MedicalDetailsRepository medicalDetailsRepository;

	@Autowired
	GetDoctorProfileRepository getDoctorProfileRepository;

	@Autowired
	SharingReportWithDocRepository sharingReportWithDocRepository;

	@Autowired
	GetRatingCountRepository getRatingCountRepository;

	@Autowired
	DoctorPatientMeetingRepository doctorPatientMeetingRepository;

	@Autowired
	GetLabRatingReviewRepository getLabRatingReviewRepository;

	@Autowired
	DocAvailableTimeRepository docAvailableTimeRepository;

	@Autowired
	GetDoctorDetailsInformationRepository getDoctorDetailsInformationRepository;

	@Autowired
	PatientAddressRepository patientAddressRepository;

	@Autowired
	GetPatientContactDetailsByIdRepository getPatientContactDetailsByIdRepository;

	@Autowired
	SendEMailService sendEMailService;

	@Autowired
	SendTextMessageService sendTextMessageService;

	@Autowired
	HospitalDetailsRepository hospitalDetailsRepository;

	@Autowired
	GetDoctorDetailsRepository getDoctorDetailsRepository;

	@Autowired
	TermsAndConditionsRepository termsAndConditionsRepository;

	@Autowired
	PatientMemberRelationRepository patientMemberRelationRepository;

	@Autowired
	CreateDirectoryService createDirectoryService;

	@Autowired
	DoctorNotificationRepository doctorNotificationRepository;

	@Autowired
	LabTestsRepository labTestsRepository;

	@Autowired
	LabNotificationRepository labNotificationRepository;

	@Autowired
	PatientNotificationRepository patientNotificationRepository;

	@Autowired
	DoctorCertificateDetailsRepository doctorCertificateDetailsRepository;

	@Autowired
	GetHospitalClinicByDoctorIdAndAvailDateRepository getHospitalClinicByDoctorIdAndAvailDateRepository;

	@Autowired
	GetUsersCountRepository getUsersCountRepository;

	@Autowired
	LabCertificateDetailsRepository labCertificateDetailsRepository;

	@Autowired
	PharmacyCertificateDetailsRepository pharmacyCertificateDetailsRepository;
	@Autowired
	PatientSuscriptionDetailsRepository patientSuscriptionDetailsRepository;
	@Autowired
	FixDoctorScheduleService fixDoctorScheduleService;

	@Autowired
	ReferalDetailsRepository referalDetailsRepository;
	@Autowired
	WalletDetailsRepository walletDetailsRepository;
	String MESSAGE;
	@Autowired
	LabAppointmentDetailsRepository labAppointmentDetailsRepository;

	@RequestMapping(value = { "/insertPatientSuscriptionDetails" }, method = RequestMethod.POST)
	public @ResponseBody PatientSuscriptionDetails insertPatientSuscriptionDetails(
			@RequestBody PatientSuscriptionDetails patientSuscriptionDetails) {
		return patientSuscriptionDetailsRepository.save(patientSuscriptionDetails);

	}

	@RequestMapping(value = { "/insertDoctorDetails" }, method = RequestMethod.POST)
	public @ResponseBody DoctorDetails insertDoctorDetails(@RequestBody DoctorDetails doctorDetails) {

		DoctorDetails doctorDetailsRes = new DoctorDetails();

		try {
			if (doctorDetails.getDoctorId() == 0) {

				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(doctorDetails.getPassword().getBytes(), 0, doctorDetails.getPassword().length());
				String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
				if (hashedPass.length() < 32) {
					hashedPass = "0" + hashedPass;
				}
				doctorDetails.setPassword(hashedPass);
			}

			// Create refferal code for doctor
			char[] characterSet = CHARSET_AZ_09;
			Random random = new SecureRandom();
			char[] result = new char[8];
			for (int i = 0; i < result.length; i++) {
				// picks a random index out of character set > random character
				int randomCharIndex = random.nextInt(characterSet.length);
				result[i] = characterSet[randomCharIndex];
			}

			String reffCode = new String(result);
			doctorDetails.setRefferalCode(reffCode);
			System.out.println("Refferal Code is= " + reffCode);

			doctorDetailsRes = doctorDetailsRepository.save(doctorDetails);
			if (doctorDetails.getDoctorId() != 0) {
				createDirectoryService.createNewDirectorForDoctor(doctorDetailsRes.getDoctorId() + "");
			}
			doctorDetailsRes.setPassword("");
			System.out.println(doctorDetailsRes.toString());

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return doctorDetailsRes;
	}

	@RequestMapping(value = { "/getDoctorDetailsById" }, method = RequestMethod.POST)
	public @ResponseBody DoctorDetails getDoctorDetailsById(@RequestParam("doctorId") int doctorId)

	{
		DoctorDetails doctorDetailsRes = new DoctorDetails();
		try {

			doctorDetailsRes = doctorDetailsRepository.findByDoctorId(doctorId);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doctorDetailsRes;

	}

	// Get Doctor Profile
	// Ganesh
	@RequestMapping(value = { "/getDoctorProfile" }, method = RequestMethod.POST)
	public @ResponseBody GetDoctorProfile getDoctorProfile(@RequestParam("doctorId") int doctorId)

	{
		/* DoctorDetails getDoctorProfile=new DoctorDetails(); */
		GetDoctorProfile getDoctorProfile = new GetDoctorProfile();
		try {
			getDoctorProfile = getDoctorProfileRepository.getDoctorProfile(doctorId);
			System.out.println(getDoctorProfile.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return getDoctorProfile;

	}
	// Insert Patient Details

	@RequestMapping(value = { "/insertPatientDetails" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails insertPatientDetails(@RequestBody PatientDetails patientDetails) {
		System.out.println("Comming List " + patientDetails.toString());
		PatientDetails patientDetailsRes = new PatientDetails();
		// Info info =new Info();
		try {

			if (patientDetails.getFamilyId() == 0) {
				// if(patientDetails.getPatientId()==0) {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(patientDetails.getPassword().getBytes(), 0, patientDetails.getPassword().length());
				String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
				if (hashedPass.length() < 32) {
					hashedPass = "0" + hashedPass;
				}
				patientDetails.setPassword(hashedPass);
				// }

				FamilyDetails familyDetails = new FamilyDetails();

				FamilyDetails familyDetailsRes = familyDetailsRepository.save(familyDetails);
				patientDetails.setFamilyId(familyDetailsRes.getFamilyId());
				// Create refferal code for patient
				char[] characterSet = CHARSET_AZ_09;
				Random random = new SecureRandom();
				char[] result = new char[6];
				for (int i = 0; i < result.length; i++) {
					// picks a random index out of character set > random character
					int randomCharIndex = random.nextInt(characterSet.length);
					result[i] = characterSet[randomCharIndex];
				}

				String reffCode = new String(result);

				System.out.println("Refferal Code is= " + reffCode);
				patientDetails.setRefferalCode(reffCode + "" + familyDetailsRes.getFamilyId());

			}

			patientDetailsRes = patientDetailsRepository.save(patientDetails);
			if (patientDetails.getPatientId() != 0)
				createDirectoryService.createNewDirectorForPatient(patientDetailsRes.getPatientId() + "");
			System.out.println(patientDetailsRes.toString());

			if (patientDetailsRes != null) {
				// GetPatientContactDetailsById
				// getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(patientDetailsRes.getPatientId());
				if (patientDetails.getPatientId() != 0)
					sendEMailService.sendMail("Patient Details Update Successfully",
							"Patient Details Update Successfully", patientDetailsRes.getEmail());
				else {
					sendEMailService.sendMail("Patient Register Successfully", "Patient Register Successfully",
							patientDetailsRes.getEmail());
				}
				// info.setError(false);
				// info.setMessage("Success");
			}
			/*
			 * else { info.setError(true); info.setMessage("Failed to insert"); }
			 */
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			// info.setError(true);
			// info.setMessage("Failed to insert");
		}

		return patientDetailsRes;
	}

	// Get Patient detail

	@RequestMapping(value = { "/getPatientDetailsById" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails getPatientDetailsById(@RequestParam("patientId") int patientId)

	{
		PatientDetails patientDetailsRes = new PatientDetails();
		try {
			if (patientSuscriptionDetailsRepository.findByPatientIdAndStatus(patientId, 1) != null) {
				patientDetailsRes = patientDetailsRepository.getPatientDetailsBYId(patientId);
				System.out.println("patientDetailsRes:" + patientDetailsRes.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return patientDetailsRes;

	}

	@RequestMapping(value = { "/getPatientDetailsWithCityNameById" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails getPatientDetailsWithCityNameById(@RequestParam("patientId") int patientId)

	{
		PatientDetails patientDetailsRes = new PatientDetails();
		try {
			patientDetailsRes = patientDetailsRepository.getPatientDetailsWithCityNameById(patientId);
			System.out.println("patientDetailsRes:" + patientDetailsRes.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return patientDetailsRes;

	}

	// insert specialization
	@RequestMapping(value = { "/insertSpecialization" }, method = RequestMethod.POST)
	public @ResponseBody Info insertSpecialization(@RequestBody SpecializationDetails specializationDetails) {
		SpecializationDetails specializationDetailsRes = new SpecializationDetails();
		System.out.println("Comming List " + specializationDetails.toString());
		Info info = new Info();
		try {
			specializationDetailsRes = specializationDetailsRepository.save(specializationDetails);
			System.out.println(specializationDetailsRes.toString());

			if (specializationDetailsRes != null) {
				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("Failed to insert");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed to insert");
		}

		return info;
	}

	// Specialist List
	@RequestMapping(value = { "/getAllSpecialization" }, method = RequestMethod.GET)
	public @ResponseBody SpecializationDetailsList getAllSpecialization()

	{

		SpecializationDetailsList specializationDetailsList = new SpecializationDetailsList();
		Info info = new Info();
		try {
			List<SpecializationDetails> specializationDetails = specializationDetailsRepository.findByDelStatus(0);

			System.out.println("Specialist List " + specializationDetails.toString());

			if (specializationDetails != null && !specializationDetails.isEmpty()) {
				specializationDetailsList.setSpecializationDetailsList(specializationDetails);
				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("failed");
		}
		specializationDetailsList.setInfo(info);

		return specializationDetailsList;
	}

	@RequestMapping(value = { "/insertRatingDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertRatingDetails(@RequestBody RatingDetails ratingDetails)

	{
		Info info = new Info();
		RatingDetails ratingDetailsRes = new RatingDetails();
		try {

			RatingDetails ratingDetailsResult = ratingDetailsRepository
					.getRatingByPatientAndDoctorId(ratingDetails.getDoctorId(), ratingDetails.getPatientId());

			if (ratingDetailsResult != null) {
				ratingDetails.setRatingReviewId(ratingDetailsResult.getRatingReviewId());
				ratingDetailsRes = ratingDetailsRepository.save(ratingDetails);
			} else {
				ratingDetailsRes = ratingDetailsRepository.save(ratingDetails);
			}

			if (ratingDetailsRes != null) {
				info.setError(false);
				info.setMessage("success");
				DoctorNotification doctorNotification = new DoctorNotification();
				doctorNotification.setNotification(
						"Review :  " + ratingDetails.getReview() + " and Rating : " + ratingDetails.getRating());
				doctorNotification.setDoctorId(ratingDetails.getDoctorId());
				doctorNotification.setFcmNo(" ");
				doctorNotification.setStatus(0);
				doctorNotification.setString1("Patient submit Rating and Review");
				doctorNotification.setInt1(0);
				doctorNotificationRepository.save(doctorNotification);

			} else {
				info.setError(true);
				info.setMessage("failed to insert");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMessage("failed to insert");
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return info;
	}

	/** get rating details */

	@RequestMapping(value = { "/getRatingDetailsByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<RatingDetailsList> getRatingDetailsByDoctorId(
			@RequestParam("doctorId") List<String> doctorId) {
		List<RatingDetails> ratingDetails = ratingDetailsRepository.getByDoctorIdAndDelStatus(doctorId, 0);

		System.out.println("Rating List " + ratingDetails.toString());
		List<RatingDetailsList> ratingDetailList = new ArrayList<RatingDetailsList>();

		List<GetPatientReviews> getPatientReviewsList = new ArrayList<GetPatientReviews>();

		for (int i = 0; i < doctorId.size(); i++) {
			RatingDetailsList ratingDetailObject = new RatingDetailsList();
			float sumOfRatings = 0;
			int countOfPatients = 0;

			int flag = 0;

			getPatientReviewsList = new ArrayList<GetPatientReviews>();
			for (RatingDetails list : ratingDetails) {

				GetPatientReviews getPatientReviews = new GetPatientReviews();
				if (list.getDoctorId() == Integer.parseInt(doctorId.get(i))) {
					flag = 1;
					System.out.println("patintid:" + list.getPatientId());
					sumOfRatings = sumOfRatings + list.getRating();

					countOfPatients++;
					getPatientReviews.setPatientId(list.getPatientId());
					getPatientReviews.setPatientName(list.getPatientName());
					getPatientReviews.setReviews(list.getReview());
					getPatientReviews.setCreateDate(list.getCreateDate());

					getPatientReviewsList.add(getPatientReviews);

				}

			}
			System.out.println("caammeee:" + getPatientReviewsList.toString());
			if (flag == 1) {
				System.out.println("count:" + countOfPatients);
				float doctorRating = 0;
				try {
					doctorRating = (sumOfRatings * 5) / (countOfPatients * 5);

				} catch (Exception e) {
					doctorRating = 0;
				}
				System.out.println("doctorRating:" + doctorRating);

				ratingDetailObject.setDoctor_id(Integer.parseInt(doctorId.get(i)));
				ratingDetailObject.setRating(doctorRating);
				ratingDetailObject.setGetPatientReviews(getPatientReviewsList);

				ratingDetailList.add(ratingDetailObject);

			}
		}
		System.out.println("final List " + ratingDetailList.toString());
		return ratingDetailList;

	}

	/** insert Appointment */

	@RequestMapping(value = { "/insertAppointmentDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertAppointmentDetails(@RequestBody AppointmentDetails appointmentDetails) {
		System.out.println("Comming List " + appointmentDetails.toString());
		AppointmentDetails appointmentDetailsRes = new AppointmentDetails();
		Info info = new Info();
		try {
			appointmentDetailsRes = appointmentDetailsRepository.save(appointmentDetails);
			System.out.println(appointmentDetailsRes.toString());
			if (appointmentDetailsRes != null) {
				GetPatientContactDetailsById getPatientContactDetailsById = getPatientContactDetailsByIdRepository
						.getPatientContactDetailsById(appointmentDetailsRes.getPatientId());
				AppointmentTime appointmentTime = appointmentTimeRepository
						.findByTimeId(appointmentDetailsRes.getTime());
				DoctorDetails doctorDetails = doctorDetailsRepository
						.findByDoctorId(appointmentDetailsRes.getDoctorId());
				HospitalDetails hospitalDetails = hospitalDetailsRepository
						.findByHospitalId(Integer.parseInt(appointmentDetails.getHospitalId()));
				try {
					DoctorNotification doctorNotification = new DoctorNotification();
					if (appointmentDetailsRes.getInt1() == 1) {
						MESSAGE = getPatientContactDetailsById.getfName() + " "
								+ getPatientContactDetailsById.getlName() + ", you have an e-consult with doctor "
								+ doctorDetails.getfName() + " " + doctorDetails.getmName() + " "
								+ doctorDetails.getlName() + " on DATE " + appointmentDetailsRes.getDate()
								+ " and TIME " + appointmentTime.getTime()
								+ ". It will open this valuable time slot for others waiting in line to visit your doctor.";
						doctorNotification.setNotification(getPatientContactDetailsById.getfName() + " "
								+ getPatientContactDetailsById.getlName() + " is booked e-consult appointment on DATE "
								+ appointmentDetailsRes.getDate() + " and TIME " + appointmentTime.getTime());
						sendFcmNotificationService.notificationOnWeb(doctorDetails.getWebToken(),
								"New Appointment Booked", MESSAGE, "");
					} else {
						MESSAGE = getPatientContactDetailsById.getfName() + " "
								+ getPatientContactDetailsById.getlName() + ", you have an appointment at "
								+ hospitalDetails.getHospitalName() + " hospital on date "
								+ appointmentDetailsRes.getDate() + " " + appointmentTime.getTime() + " with Dr."
								+ doctorDetails.getfName() + " " + doctorDetails.getmName() + " "
								+ doctorDetails.getlName() + " please reach on time at address "
								+ hospitalDetails.getAddress() + ". for any query contact on "
								+ hospitalDetails.getContactNo();
						doctorNotification.setNotification(getPatientContactDetailsById.getfName() + " "
								+ getPatientContactDetailsById.getlName() + " is booked appointment on DATE "
								+ appointmentDetailsRes.getDate() + " and TIME " + appointmentTime.getTime());
						sendFcmNotificationService.notificationOnWeb(doctorDetails.getWebToken(),
								"New Appointment Booked", MESSAGE, "");
					}
					doctorNotification.setDoctorId(appointmentDetailsRes.getDoctorId());
					doctorNotification.setFcmNo(" ");
					doctorNotification.setStatus(0);
					doctorNotification.setString1("Appointment Booked");
					doctorNotification.setInt1(appointmentDetails.getPatientId());
					doctorNotificationRepository.save(doctorNotification);
					sendTextMessageService.sendTextSms(MESSAGE, getPatientContactDetailsById.getContactNo());

					sendEMailService.sendMail("Appointment Notification", MESSAGE,
							getPatientContactDetailsById.getEmail());

					String appointmentNotification = getPatientContactDetailsById.getfName() + " "
							+ getPatientContactDetailsById.getlName() + " is booked e-consult appointment on DATE "
							+ appointmentDetailsRes.getDate() + " and TIME " + appointmentTime.getTime();

					if (doctorDetails.getInt1() == 0) {
						System.out.println(
								"FCM" + doctorDetails.toString() + "Date" + DateConverter.currentDateAndTime());
						ResponseEntity<String> s = sendFcmNotificationService.notifyUser(doctorDetails.getLocation(),
								"BIONISCHE", appointmentNotification, "cdcd", 4);
						System.out.println("Details=" + s);
					} else if (doctorDetails.getInt1() == 1) {

						sendFcmNotificationService.notifyiOSUser(doctorDetails.getLocation(), "BIONISCHE",
								appointmentNotification, DateConverter.currentDateAndTime(), 4);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				info.setError(false);
				info.setMessage(MESSAGE);
			} else {
				info.setError(true);
				info.setMessage("Problem to Book Appointment");
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Problem in server to Book Appointment");
		}

		return info;
	}

	// Appointment List
	@RequestMapping(value = { "/getAllAppointmentByDoctorId" }, method = RequestMethod.GET)
	public @ResponseBody AppointmentList getAllAppointmentByDoctorId(@RequestParam("doctorId") int doctorId,
			@RequestParam("date") String date)

	{

		AppointmentList appointmentDetailsList = new AppointmentList();
		Info info = new Info();
		try {
			List<AppointmentDetails> appointmentDetails = appointmentDetailsRepository.findByDoctorIdAndDate(doctorId,
					date);

			System.out.println("appointment List " + appointmentDetails.toString());

			if (appointmentDetails != null && !appointmentDetails.isEmpty()) {
				appointmentDetailsList.setAppointmentDetailsList(appointmentDetails);
				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("failed");
		}
		appointmentDetailsList.setInfo(info);

		return appointmentDetailsList;
	}

	@RequestMapping(value = { "/getAllCityByStateId" }, method = RequestMethod.POST)
	public @ResponseBody List<City> getAllCityByStateId(@RequestParam("stateId") int stateId) {

		List<City> cityList = cityRepository.findByStateIdOrderByCityNameAsc(stateId);

		return cityList;
	}

	@RequestMapping(value = { "/getCityByCityId" }, method = RequestMethod.POST)
	public @ResponseBody City getCityByCityId(@RequestParam("cityId") int cityId) {

		City city = new City();

		city = cityRepository.findByCityId(cityId);
		System.out.println("cityName:" + city.toString());

		return city;
	}

	@RequestMapping(value = { "/insertCity" }, method = RequestMethod.POST)
	public @ResponseBody Info insertCity(@RequestBody City city) {

		Info info = new Info();
		try {
			City cityRes = cityRepository.save(city);
			if (cityRes != null) {
				info.setError(false);
				info.setMessage("Insert SuccessFully");
			} else

			{
				info.setError(true);
				info.setMessage("Failed to Insert");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}

		return info;
	}

	@RequestMapping(value = { "/deleteByCityId" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteByCityId(@RequestParam("cityId") int cityId) {

		try {
			Info info = new Info();
			int res = cityRepository.deleteByCityId(cityId);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Insert SuccessFully");
			} else

			{
				info.setError(true);
				info.setMessage("Failed to Insert");
			}
			return info;
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}

		return null;
	}

	@RequestMapping(value = { "/insertState" }, method = RequestMethod.POST)
	public @ResponseBody Info insertState(@RequestBody State state) {

		Info info = new Info();
		try {
			State stateRes = stateRepository.save(state);
			if (stateRes != null) {
				info.setError(false);
				info.setMessage("Insert SuccessFully");
			} else

			{
				info.setError(true);
				info.setMessage("Failed to Insert");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}

		return info;
	}

	@RequestMapping(value = { "/insertCountry" }, method = RequestMethod.POST)
	public @ResponseBody Info insertCountry(@RequestBody Country country) {

		Info info = new Info();
		try {
			Country countryRes = countryRepository.save(country);
			if (countryRes != null) {
				info.setError(false);
				info.setMessage("Insert SuccessFully");
			} else

			{
				info.setError(true);
				info.setMessage("Failed to Insert");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}

		return info;
	}

	@RequestMapping(value = { "/getDoctorsBySpecialistId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDoctorListForAppointment> getDoctorsBySpecialistId(@RequestParam("cityId") int cityId,
			@RequestParam("specId") int specId, @RequestParam("date") String date) {
		System.out.println("cccity " + cityId);

		try {
			List<GetDoctorListForAppointment> getDoctorListForAppointmentLsit = getDoctorListForAppointmentRepository
					.getDoctorListForAppointment(specId, cityId, date);
			System.out.println(getDoctorListForAppointmentLsit.toString());

			List<Integer> doctorIdList = new ArrayList<Integer>();
			doctorIdList.add(0);
			for (int i = 0; i < getDoctorListForAppointmentLsit.size(); i++) {
				doctorIdList.add(getDoctorListForAppointmentLsit.get(i).getDoctorId());
			}

			List<GetDoctorListForAppointment> getDoctorListForAppointmentLsitRes = new ArrayList<GetDoctorListForAppointment>();
			getDoctorListForAppointmentLsitRes = fixDoctorScheduleService.getDoctorListForAppointment(specId, cityId,
					doctorIdList, date);
			System.out.println("fix Schedule " + getDoctorListForAppointmentLsitRes.toString());

			ObjectMapper mapper = new ObjectMapper();

			for (int ii = 0; ii < getDoctorListForAppointmentLsitRes.size(); ii++) {
				// if(getDoctorListForAppointmentLsit.get(i).getDoctorId()==getDoctorListForAppointmentLsitRes.get(ii).getDoctorId())
				// {

				// }else
				// {

				List<AppointmentTime> appointmentTimeList = mapper.readValue(
						getDoctorListForAppointmentLsitRes.get(ii).getAvailableTime(),
						new TypeReference<List<AppointmentTime>>() {
						});

				for (int jj = 0; jj < appointmentTimeList.size(); jj++) {
					// System.out.println("fix Schedule appointmentTime"
					// +appointmentTime.toString());
					getDoctorListForAppointmentLsitRes.get(ii).setFromTime(appointmentTimeList.get(jj).getTime());
					getDoctorListForAppointmentLsitRes.get(ii)
							.setToTime(appointmentTimeList.get(appointmentTimeList.size() - 1).getTime());
					break;
				}
				getDoctorListForAppointmentLsitRes.get(ii).setAvailableTime(null); // from Fix schedule time why
																					// available time=111
				// getDoctorListForAppointmentLsitRes.set(ii,
				// getDoctorListForAppointmentLsit.get(i));

				// }
			}
			for (int i = 0; i < getDoctorListForAppointmentLsit.size(); i++) {

				List<String> availableTimeList = Arrays
						.asList(getDoctorListForAppointmentLsit.get(i).getAvailableTime().split(","));

				for (int j = 0; j < availableTimeList.size(); j++) {
					List<AppointmentTime> appointmentTimeList = appointmentTimeRepository.getDoctorAppointMentTime(
							availableTimeList.get(j), availableTimeList.get(availableTimeList.size() - 1));

					for (int k = 0; k < appointmentTimeList.size(); k++) {
						if (appointmentTimeList.get(k).getTimeId() == Integer.parseInt(availableTimeList.get(j)))
							getDoctorListForAppointmentLsit.get(i).setFromTime(appointmentTimeList.get(k).getTime());
						else if (appointmentTimeList.get(k).getTimeId() == Integer
								.parseInt(availableTimeList.get(availableTimeList.size() - 1)))
							getDoctorListForAppointmentLsit.get(i).setToTime(appointmentTimeList.get(k).getTime());
					}
					j = j + availableTimeList.size();

				}
			}
			for (GetDoctorListForAppointment getDoctorListForAppointment : getDoctorListForAppointmentLsit)
				getDoctorListForAppointmentLsitRes.add(getDoctorListForAppointment);
			return getDoctorListForAppointmentLsitRes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getTimeByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<AppointmentTime> getTimeByDoctorId(@RequestParam("doctorId") int doctorId,
			@RequestParam("appointmentDate") int appointmentDate) {

		List<AppointmentTime> appointmentTimeList = new ArrayList<>();

		try {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return appointmentTimeList;
	}

	// Get Patient username details

	@RequestMapping(value = { "/getUserNameInfo" }, method = RequestMethod.POST)
	public @ResponseBody Info getUserNameInfo(@RequestParam("uName") String uName)

	{
		PatientDetails patientDetailsRes = new PatientDetails();
		Info info = new Info();
		try {
			patientDetailsRes = patientDetailsRepository.findByUserNameAndDelStatus(uName, 0);

			if (patientDetailsRes != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// get prescription by patid and date

	@RequestMapping(value = { "/getPrescriptionByPatientIdAndDateAndDelStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<PrescriptionDetails> getPrescriptionByPatientIdAndDateAndDelStatus(
			@RequestParam("patientId") int patientId, @RequestParam("date") String date) {
		System.out.println("patientId " + patientId);
		List<PrescriptionDetails> prescriptionDetailsList = new ArrayList<>();
		try {
			prescriptionDetailsList = prescriptionDetailsRepository
					.getPrescriptionByPatientIdAndDateAndDelStatus(patientId, date);

			System.out.println("pp " + prescriptionDetailsList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prescriptionDetailsList;
	}

	@RequestMapping(value = { "/getAppmtDetailsByAppointmentId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAppointmentDetails> getAppmtDetailsByAppointmentId(
			@RequestParam("appointmentId") int appointmentId) {

		List<GetAppointmentDetails> appointmentDetailsList = new ArrayList<>();
		try {
			appointmentDetailsList = getAppointmentDetailsRepository
					.getAppointmentDetailsByAppointmentid(appointmentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDetailsList;
	}

	@RequestMapping(value = { "/getAppmtDetailsByPatientIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAppointmentDetails> getAppmtDetailsByPatientIdAndDate(
			@RequestParam("patientId") int patientId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.out.println("patientId " + fromDate + toDate);

		List<GetAppointmentDetails> appointmentDetailsList = new ArrayList<>();
		try {
			appointmentDetailsList = getAppointmentDetailsRepository.getAppointmentDetails(fromDate, toDate, patientId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDetailsList;
	}

	@RequestMapping(value = { "/updateDoctorAppointmentStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateDoctorAppointmentStatus(@RequestParam("appId") int appId,
			@RequestParam("status") int status) {
		System.out.println("appIdstatusstatusstatusstatusstatus " + status);

		Info info = new Info();
		try {
			int res = appointmentDetailsRepository.updateStatusAppointment(appId, status);
			if (res > 0) {
				PatientNotification patientNotification = new PatientNotification();
				GetAppointmentDetails getAppointmentDetails = getAppointmentDetailsRepository
						.getAppmtDetailsByAppointId(appId);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();

				GetPatientContactDetailsById getPatientContactDetailsById = getPatientContactDetailsByIdRepository
						.getPatientContactDetailsByDoctorAppointId(appId);
				
				if (status == 3 || status==2) {
				MESSAGE = getPatientContactDetailsById.getfName() + " " + getPatientContactDetailsById.getlName()
						+ ", your doctor consult appointment cancel because of some issue reschedule your appointment"+ Constants.SITE_URL+"showBookDoctorAppointment?appPatientId=1&currency=&doctorCity=1&countryId=1&stateId=1&CityId=1&specId=1&appDate="
						+ formatter.format(date) + "&consultType=1&submit=Submit";
				}
				else if(status == 1) {
				MESSAGE = getPatientContactDetailsById.getfName() + " " + getPatientContactDetailsById.getlName()
				+ ", your appointment with Dr. "+getAppointmentDetails.getDoctorName()+" is completed. Please login to your Biocare account for prescription & other details."+Constants.SITE_URL;
				 
				}
				sendTextMessageService.sendTextSms(MESSAGE, getPatientContactDetailsById.getContactNo());

				sendEMailService.sendMail("APPOINTMENT CANCEL", MESSAGE, getPatientContactDetailsById.getEmail());

				if (status == 3) {
					patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
					patientNotification.setNotification(
							getPatientContactDetailsById.getfName() + " your appointment has been cancelled by Dr."
									+ getAppointmentDetails.getDoctorName() + " on DATE "
									+ getAppointmentDetails.getDate() + " and TIME " + getAppointmentDetails.getTime());
					patientNotification.setStatus(0);
					patientNotification.setString1("Appointment Status");
					patientNotification.setString2("doctor");
					patientNotification.setInt1(getAppointmentDetails.getDoctorId());
					patientNotificationRepository.save(patientNotification);
				}
				info.setMessage("Your Appointment Delete Successfully!!");
				info.setError(false);
			} else {
				info.setMessage("Your Appointment Delete Failed!!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/cancelDoctorAppointment" }, method = RequestMethod.POST)
	public @ResponseBody Info cancelDoctorAppointment(@RequestParam("appId") int appId) {
		System.out.println("appId " + appId);

		Info info = new Info();
		try {
			int res = appointmentDetailsRepository.cancelDoctorAppointmentByPatient(appId);

			AppointmentDetails appointmentDetails = appointmentDetailsRepository.findByAppointId(appId);

			DoctorDetails doctorDetails = doctorDetailsRepository.findByDoctorId(appointmentDetails.getDoctorId());

			if (res > 0) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				System.out.println(formatter.format(date));
				GetPatientContactDetailsById getPatientContactDetailsById = getPatientContactDetailsByIdRepository
						.getPatientContactDetailsByDoctorAppointId(appId);
				MESSAGE = getPatientContactDetailsById.getfName() + " " + getPatientContactDetailsById.getlName()
						+ ", your doctor consult appointment cancel successfully. For reschedule your appointment click on link https://www.bionische.com/biocare/showBookDoctorAppointment?appPatientId=1&currency=&doctorCity=1&countryId=1&stateId=1&CityId=1&specId=1&appDate="
						+ formatter.format(date) + "&consultType=1&submit=Submit";
				sendTextMessageService.sendTextSms(MESSAGE, getPatientContactDetailsById.getContactNo());
				sendEMailService.sendMail("BIONISCHE APPOINTMENT NOTIFICATION", MESSAGE,
						getPatientContactDetailsById.getEmail());

				DoctorNotification doctorNotification = new DoctorNotification();
				doctorNotification.setNotification(getPatientContactDetailsById.getfName() + " "
						+ getPatientContactDetailsById.getlName() + ", Canceled consult appointment.");
				doctorNotification.setDoctorId(doctorDetailsRepository.getDoctorId(appId));
				doctorNotification.setFcmNo(" ");
				doctorNotification.setStatus(0);
				doctorNotification.setString1("Appointment Canceled");
				doctorNotification.setInt1(getPatientContactDetailsById.getPatientId());
				doctorNotificationRepository.save(doctorNotification);

				String mobileNotification = "Appointment has been canceled by "
						+ getPatientContactDetailsById.getfName() + " " + getPatientContactDetailsById.getlName()
						+ " of date " + appointmentDetails.getDate();

				if (doctorDetails.getInt1() == 0) {
					sendFcmNotificationService.notifyUser(doctorDetails.getLocation(), "BIONISCHE", mobileNotification,
							DateConverter.currentDateAndTime(), 5);
					sendFcmNotificationService.notificationOnWeb(doctorDetails.getWebToken(), "Cancel Appointment ", mobileNotification, "");
				} else if (doctorDetails.getInt1() == 1) {

					sendFcmNotificationService.notifyiOSUser(doctorDetails.getLocation(), "BIONISCHE",
							mobileNotification, DateConverter.currentDateAndTime(), 5);

				}
				info.setMessage(MESSAGE);
				info.setError(false);
			} else {
				info.setMessage("Your Appointment Delete Failed!!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	// Ganesh
	// Get Appointment to doctor

	@RequestMapping(value = { "/getAppmtDetailsByDoctorIdDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAppointmentDetails> getAppmtDetailsByDoctorIdDate(
			@RequestParam("doctorId") int doctorId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.out.println("Doctor " + doctorId);

		/*
		 * fromDate=DateConverter.convertToYMD(fromDate);
		 * toDate=DateConverter.convertToYMD(toDate);
		 */
		System.out.println("fromDate:-" + fromDate + "to date" + toDate);
		List<GetAppointmentDetails> appointmentDetailsList = new ArrayList<>();
		try {
			appointmentDetailsList = getAppointmentDetailsRepository.getAppointmentDetailsByDoctor(fromDate, toDate,
					doctorId);
			System.out.println("qhjdahbd:" + appointmentDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDetailsList;
	}

	@RequestMapping(value = { "/getAppointmentDetailsByDoctorForAdmin" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAppointmentDetails> getAppointmentDetailsByDoctorForAdmin(
			@RequestParam("doctorId") int doctorId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.out.println("Doctor " + doctorId);

		/*
		 * fromDate=DateConverter.convertToYMD(fromDate);
		 * toDate=DateConverter.convertToYMD(toDate);
		 */
		System.out.println("fromDate:-" + fromDate + "to date" + toDate);
		List<GetAppointmentDetails> appointmentDetailsList = new ArrayList<>();
		try {
			appointmentDetailsList = getAppointmentDetailsRepository.getAppointmentDetailsByDoctorForAdmin(fromDate,
					toDate, doctorId);
			System.out.println("qhjdahbd:" + appointmentDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDetailsList;
	}

	@RequestMapping(value = { "/getAppmtDetailsByDoctorIdPatName" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAppointmentDetails> getAppmtDetailsByDoctorIdPatName(
			@RequestParam("doctorId") int doctorId, @RequestParam("fullName") String fullName) {
		System.out.println("Doctor " + doctorId);

		List<GetAppointmentDetails> appointmentDetailsList = new ArrayList<>();
		try {
			appointmentDetailsList = getAppointmentDetailsRepository.getAppmtDetailsByDoctorIdPatName(doctorId,
					fullName);
			System.out.println("qhjdahbd:" + appointmentDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDetailsList;
	}

	// Ganesh
	// Get Lab Appointment to lab

	@RequestMapping(value = { "/getLabAppointmentByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabAppointment> getLabAppointmentByLabId(@RequestParam("labId") int labId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		System.out.println("labId " + labId + "vdfvfd" + fromDate + "ffdd" + toDate);

		// fromDate=DateConverter.convertToYMD(fromDate);
		// toDate=DateConverter.convertToYMD(toDate);
		List<GetLabAppointment> getLabAppointmentList = new ArrayList<>();
		try {
			getLabAppointmentList = getLabAppointmentRrepository.getLabAppointment(fromDate, toDate, labId);

			System.out.println(getLabAppointmentList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getLabAppointmentList;
	}

	@RequestMapping(value = { "/getLabAppointmentByLabAndPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabAppointment> getLabAppointmentByLabAndPatientId(
			@RequestParam("patientId") int patientId, @RequestParam("labId") int labId) {
		System.out.println("labId " + labId + "vdfvfd" + patientId + "ffdd" + patientId);

		List<GetLabAppointment> getLabAppointmentList = new ArrayList<>();
		try {
			getLabAppointmentList = getLabAppointmentRrepository.getLabAppointmentByPatID(labId, patientId);

			System.out.println("ggggggggggg" + getLabAppointmentList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getLabAppointmentList;
	}

	@RequestMapping(value = { "/getLabAppointmentByPatientName" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabAppointment> getLabAppointmentByPatientName(@RequestParam("labId") int labId,
			@RequestParam("fullName") String fullName) {
		System.out.println("labId " + labId);

		List<GetLabAppointment> getLabAppointmentList = new ArrayList<>();
		try {
			getLabAppointmentList = getLabAppointmentRrepository.getLabAppointmentByPatientName(labId, fullName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getLabAppointmentList;
	}

	/* get state by country id */

	@RequestMapping(value = { "/getAllStateByCountryId" }, method = RequestMethod.POST)
	public @ResponseBody List<State> getAllStateByCountryId(@RequestParam("countryId") int countryId) {

		System.out.println("czemeee" + countryId);
		List<State> stateList = stateRepository.findByCountryIdOrderByStateNameAsc(countryId);

		System.out.println("stateList:" + stateList.toString());
		return stateList;
	}

	/* get state by country id */

	@RequestMapping(value = { "/getAllCountry" }, method = RequestMethod.GET)
	public @ResponseBody List<Country> getAllCountry() {

		List<Country> countryList = countryRepository.getAllOrderByCountryName();

		System.out.println("countryList:" + countryList.toString());
		return countryList;
	}

	// Ganesh
	// Edit doctor patient Appointment
	@RequestMapping(value = { "/editDoctorAppointment" }, method = RequestMethod.POST)
	public @ResponseBody Info editDoctorAppointment(@RequestParam("appId") int appId, @RequestParam("date") String date,
			@RequestParam("timeId") int timeId) {
		System.out.println("date " + date);

		Info info = new Info();
		try {
			int res = appointmentDetailsRepository.editAppointment(appId, date, timeId);
			System.out.println("resssssss:" + res);
			if (res > 0) {
				PatientNotification patientNotification = new PatientNotification();
				GetPatientContactDetailsById getPatientContactDetailsById = getPatientContactDetailsByIdRepository
						.getPatientContactDetailsByDoctorAppointId(appId);
				GetDoctorDetails getDoctorDetails = getDoctorDetailsRepository.findByAppointmentId(appId);
				GetAppointmentDetails getAppointmentDetails = getAppointmentDetailsRepository
						.getAppmtDetailsByAppointId(appId);

				AppointmentTime appointmentTime = appointmentTimeRepository.findByTimeId(timeId);
				// DoctorDetails
				// doctorDetails=doctorDetailsRepository.findByDoctorId(appointmentDetailsRes.getDoctorId());
				HospitalDetails hospitalDetails = hospitalDetailsRepository
						.findByHospitalId(getDoctorDetails.getHospitalId());
				MESSAGE = "CONFIRMED Appointment ID: " + appId + " for date " + date + " at "
						+ appointmentTime.getTime() + " with Dr. " + getDoctorDetails.getDoctorfName() + " "
						+ getDoctorDetails.getDoctormName() + " " + getDoctorDetails.getDoctorlName() + ". "
						+ hospitalDetails.getHospitalName() + ", " + hospitalDetails.getAddress() + ", Ph: "
						+ hospitalDetails.getContactNo();
				sendTextMessageService.sendTextSms(MESSAGE, getPatientContactDetailsById.getContactNo());
				sendEMailService.sendMail("Your Appointment Is edited!!", MESSAGE,
						getPatientContactDetailsById.getEmail());

				PatientDetails patientDetails = patientDetailsRepository
						.findByPatientId(getPatientContactDetailsById.getPatientId());
				patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
				patientNotification.setNotification(
						getPatientContactDetailsById.getfName() + " Your Appointment has been confirmed by Dr."
								+ getAppointmentDetails.getDoctorName() + " on DATE " + getAppointmentDetails.getDate()
								+ " and TIME " + getAppointmentDetails.getTime());
				patientNotification.setStatus(0);
				patientNotification.setString1("Appointment Confirmed");
				patientNotification.setString2("doctor");
				patientNotification.setInt1(getAppointmentDetails.getDoctorId());
				patientNotificationRepository.save(patientNotification);

				String confirmAppointmentNotification = "Your Appointment has been confirmed by Dr."
						+ getAppointmentDetails.getDoctorName() + " on DATE " + getAppointmentDetails.getDate()
						+ " and TIME " + getAppointmentDetails.getTime();
				sendFcmNotificationService.notificationOnWeb(patientDetails.getWebToken(), "BIONISCHE", confirmAppointmentNotification, Constants.SITE_URL);
				if (patientDetails.getInt1() == 0) {
					sendFcmNotificationService.notifyUser(patientDetails.getString2(), "BIONISCHE",
							confirmAppointmentNotification, DateConverter.currentDateAndTime(), 11);
					
					
				} else if (patientDetails.getInt1() == 1) {

					sendFcmNotificationService.notifyiOSUser(patientDetails.getString2(), "BIONISCHE",
							confirmAppointmentNotification, DateConverter.currentDateAndTime(), 11);
				}

				info.setMessage("Your Appointment Change Successfully!!");
				info.setError(false);
			} else {
				info.setMessage("Your Appointment Change Failed!!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	// getFamily Members
	// Ganesh
	@RequestMapping(value = { "/getPatientFamilyMembersList" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientDetails> getPatientFamilyMembersList(@RequestParam("familyId") int familyId) {
		System.out.println("familyId " + familyId);

		List<PatientDetails> patientDetailsList = new ArrayList<PatientDetails>();

		try {
			patientDetailsList = patientDetailsRepository.findByFamilyIdAndDelStatus(familyId, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientDetailsList;
	}

	// username validation
	@RequestMapping(value = { "/usernameValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info usernameValidation(@RequestParam("userName") String userName)

	{
		Info info = new Info();
		PatientDetails patientDetailsRes = new PatientDetails();
		try {
			patientDetailsRes = patientDetailsRepository.getPatientLogin(userName);

			if (patientDetailsRes != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/usernameValidationPharmacy" }, method = RequestMethod.POST)
	public @ResponseBody Info usernameValidationPharmacy(@RequestParam("userName") String userName)

	{
		Info info = new Info();
		MedicalDetails medicalDetails = new MedicalDetails();
		try {
			medicalDetails = medicalDetailsRepository.findByUserNameAndDelStatus(userName, 0);

			if (medicalDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/usernameValidationOfDoctor" }, method = RequestMethod.POST)
	public @ResponseBody Info usernameValidationOfDoctor(@RequestParam("userName") String userName)

	{
		Info info = new Info();
		DoctorDetails doctorDetails = new DoctorDetails();
		try {
			doctorDetails = doctorDetailsRepository.getLoginUserName(userName);

			if (doctorDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/usernameValidationOfLab" }, method = RequestMethod.POST)
	public @ResponseBody Info usernameValidationOfLab(@RequestParam("userName") String userName)

	{
		Info info = new Info();
		LabDetails labDetails = new LabDetails();
		try {
			labDetails = labDetailsRepository.findByUserNameAndDelStatus(userName, 0);

			if (labDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// lab appointment
	@RequestMapping(value = { "/getLabAppmtDetailsByPatientIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabAppointment> getLabAppmtDetailsByPatientIdAndDate(
			@RequestParam("patientId") int patientId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.out.println("patientId " + patientId + " " + fromDate + " " + toDate);

		// fromDate=DateConverter.convertToYMD(fromDate);
		// toDate=DateConverter.convertToYMD(toDate);
		List<GetLabAppointment> labappointmentDetailsList = new ArrayList<GetLabAppointment>();
		try {
			labappointmentDetailsList = getLabAppointmentRrepository.getLabAppointmentToPatient(fromDate, toDate,
					patientId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return labappointmentDetailsList;
	}

	@RequestMapping(value = { "/submitSharingReportWithDoc" }, method = RequestMethod.POST)
	public @ResponseBody Info submitSharingReportWithDoc(@RequestBody SharingReportWithDoc sharingReportWithDoc)

	{

		return sharingReportToDoctorService.shareReportToDoctor(sharingReportWithDoc);
	}

	// change patient password
	@RequestMapping(value = { "/changePatientPassword" }, method = RequestMethod.POST)
	public @ResponseBody Info changePatientPassword(@RequestParam("patientId") int patientId,
			@RequestParam("newPassword") String newPassword)

	{
		int res;

		Info info = new Info();
		try {

			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}

			res = patientDetailsRepository.updateNewPassword(patientId, hashedPass);
			if (res > 0) {
				GetPatientContactDetailsById getPatientContactDetailsById = getPatientContactDetailsByIdRepository
						.getPatientContactDetailsById(patientId);

				sendEMailService.sendMail("Your Password is Successfully changed",
						"Your Password is Successfully changed", getPatientContactDetailsById.getEmail());

				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = { "/getRatingAndReviewsDetailsOfDoctor" }, method = RequestMethod.POST)
	public @ResponseBody GetDoctorRatingReviewCount getRatingAndReviewsDetailsOfDoctor(
			@RequestParam("doctorId") int doctorId) {

		GetDoctorRatingReviewCount getDoctorRatingReviewCount = new GetDoctorRatingReviewCount();
		List<RatingDetails> ratingDetails = ratingDetailsRepository.getRatingByDoctorId(doctorId, 0);

		List<GetRatingCount> getRatingCountList = getRatingCountRepository.getRatingCount(doctorId);

		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int sumOfRating = 0;

		for (GetRatingCount list : getRatingCountList) {
			sumOfRating += list.getCount();
		}
		for (GetRatingCount list : getRatingCountList) {
			if (list.getRating() == 1) {
				one = list.getCount() * 100 / sumOfRating;
			}
			if (list.getRating() == 2) {
				two = list.getCount() * 100 / sumOfRating;
			}
			if (list.getRating() == 3) {
				three = list.getCount() * 100 / sumOfRating;
			}
			if (list.getRating() == 4) {
				four = list.getCount() * 100 / sumOfRating;
			}
			if (list.getRating() == 5) {
				five = list.getCount() * 100 / sumOfRating;
			}

		}

		getDoctorRatingReviewCount.setOneStar(one);
		getDoctorRatingReviewCount.setTwoStar(two);
		getDoctorRatingReviewCount.setThreeStar(three);
		getDoctorRatingReviewCount.setFourStar(four);
		getDoctorRatingReviewCount.setFivaeStar(five);
		getDoctorRatingReviewCount.setRatingDetails(ratingDetails);

		return getDoctorRatingReviewCount;

	}

	@RequestMapping(value = { "/updateRatingConsult" }, method = RequestMethod.POST)
	public @ResponseBody Info updateRatingConsult(@RequestParam("meetId") int meetId) {
		System.out.println("appIdstatusstatusstatusstatusstatus " + meetId);

		Info info = new Info();
		try {
			int res = doctorPatientMeetingRepository.updateRatingStatus(meetId);
			if (res > 0) {
				info.setMessage("Your Appointment Delete Successfully!!");
				info.setError(false);
			} else {
				info.setMessage("Your Appointment Delete Failed!!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/insertFreequentlyUsedMedicine" }, method = RequestMethod.POST)
	public Info insertFreequentlyUsedMedicine(@RequestBody FreequantlyUsedMedicines freequantlyUsedMedicinesList1) {
		Info info = new Info();

		int doctorId = freequantlyUsedMedicinesList1.getDoctorId();
		String medicineName = freequantlyUsedMedicinesList1.getMedicineName();

		try {

			FreequantlyUsedMedicines freequantlyUsedMedicines = freequantlyUsedMedicinesRepository
					.findByDoctorIdAndMedicineName(doctorId, medicineName);

			if (freequantlyUsedMedicines != null) {
				info.setMessage("Medicine Already Exist");
			} else {
				freequantlyUsedMedicines = freequantlyUsedMedicinesRepository.save(freequantlyUsedMedicinesList1);
			}
			if (freequantlyUsedMedicines != null) {
				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return info;
	}

	@RequestMapping(value = { "/getFreequentlyUsedMedByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<FreequantlyUsedMedicines> getFreequentlyUsedMedByDoctorId(
			@RequestParam("doctorId") int doctorId) {

		List<FreequantlyUsedMedicines> freequantlyUsedMedicinesList = new ArrayList<FreequantlyUsedMedicines>();

		freequantlyUsedMedicinesList = freequantlyUsedMedicinesRepository.getFrequentlyUsedMedicineBYDoctorUd(doctorId,
				0);

		return freequantlyUsedMedicinesList;
	}

	@RequestMapping(value = { "/deleteMedicineById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMedicineById(@RequestParam("medicineId") int medicineId) {
		System.out.println("appIdstatusstatusstatusstatusstatus " + medicineId);

		Info info = new Info();
		try {
			int res = freequantlyUsedMedicinesRepository.deleteMedicine(medicineId);
			if (res > 0) {
				info.setMessage("Delete Successfully!!");
				info.setError(false);
			} else {
				info.setMessage("Delete Failed!!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	// submit lab rating and review
	@RequestMapping(value = { "/insertLabRatingDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertLabRatingDetails(@RequestBody GetLabRatingReview ratingDetails)

	{
		Info info = new Info();
		try {

			GetLabRatingReview ratingDetailsRes = getLabRatingReviewRepository.save(ratingDetails);

			if (ratingDetailsRes != null) {
				info.setError(false);
				info.setMessage("success");
			} else {
				info.setError(true);
				info.setMessage("failed to insert");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMessage("failed to insert");
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return info;
	}

	@RequestMapping(value = { "/updateRatingStatusOFLab" }, method = RequestMethod.POST)
	public @ResponseBody Info updateRatingStatusOFLab(@RequestParam("labAppId") int labAppId) {
		System.out.println("appIdstatusstatusstatusstatusstatus " + labAppId);

		Info info = new Info();
		try {
			int res = labAppointmentDetailsRepository.updateLabRatingStatus(labAppId);
			if (res > 0) {
				info.setMessage("Your Appointment Delete Successfully!!");
				info.setError(false);
			} else {
				info.setMessage("Your Appointment Delete Failed!!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/getAvailableDoctorTimeList" }, method = RequestMethod.POST)
	public List<DocAvailableTime> getAvailableDoctorTimeList(@RequestParam("doctorId") int doctorId) {

		List<DocAvailableTime> docAvailableTimeList = new ArrayList<DocAvailableTime>();

		try {
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			docAvailableTimeList = docAvailableTimeRepository.getAllTimeBYDoctorId(doctorId, date);

			System.out.println("docAvailableTimeList;" + docAvailableTimeList.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return docAvailableTimeList;
	}

	@RequestMapping(value = { "/getAllAppointmentTimeList" }, method = RequestMethod.GET)
	public @ResponseBody List<AppointmentTime> getAllAppointmentTimeList() {

		List<AppointmentTime> timeList = appointmentTimeRepository.findAll();

		System.out.println("timeList:" + timeList.toString());
		return timeList;
	}

	// change patient password
	@RequestMapping(value = { "/changeDoctorPassword" }, method = RequestMethod.POST)
	public @ResponseBody Info changeDoctorPassword(@RequestParam("doctorId") int doctorId,
			@RequestParam("newPassword") String newPassword)

	{
		int res;

		Info info = new Info();
		try {

			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;

			}
			res = doctorDetailsRepository.updateNewPassword(doctorId, hashedPass);
			if (res > 0) {
				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	// change lab password
	@RequestMapping(value = { "/changeLabPassword" }, method = RequestMethod.POST)
	public @ResponseBody Info changeLabPassword(@RequestParam("labId") int labId,
			@RequestParam("newPassword") String newPassword)

	{
		int res;

		Info info = new Info();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}
			res = labDetailsRepository.updateNewPassword(labId, hashedPass);

			if (res > 0) {
				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = { "/getDoctorsListByCityName" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorDetailsInformation> getDoctorsListByCityId(
			@RequestParam("cityName") String cityName)

	{
		List<DoctorDetailsInformation> doctorDetailsInformationList = doctorDetailsInformationList = new ArrayList<DoctorDetailsInformation>();
		;

		try {
			doctorDetailsInformationList = getDoctorDetailsInformationRepository.findByCityIdAndDelStatus(cityName);

			for (int i = 0; i < doctorDetailsInformationList.size(); i++) {

				List<String> availableTimeList = Arrays
						.asList(doctorDetailsInformationList.get(i).getAvailableTime().split(","));
				List<AppointmentTime> appointmentTimeList = appointmentTimeRepository.getDoctorAppointMentTime(
						availableTimeList.get(0), availableTimeList.get(availableTimeList.size() - 1));

				System.out.println(appointmentTimeList.toString());

				if (appointmentTimeList.size() != 0) {
					String docAvailableTime = appointmentTimeList.get(i).getTime() + " To "
							+ appointmentTimeList.get(i + 1).getTime();

					doctorDetailsInformationList.get(i).setAvailableTime(docAvailableTime);
				} else {
					doctorDetailsInformationList.get(i).setAvailableTime("0");
				}
			}
			System.out.println(doctorDetailsInformationList.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return doctorDetailsInformationList;

	}

	@RequestMapping(value = { "/getDoctorsListByCityIdAndSpecId" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorDetailsInformation> getDoctorsListByCityIdAndSpecId(
			@RequestParam("cityName") String cityName, @RequestParam("specId") int specId)

	{
		List<DoctorDetailsInformation> doctorDetailsInformationList = doctorDetailsInformationList = new ArrayList<DoctorDetailsInformation>();

		try {
			doctorDetailsInformationList = getDoctorDetailsInformationRepository
					.findBySpecIdAndCityIdAndDelStatus(specId, cityName);

			for (int i = 0; i < doctorDetailsInformationList.size(); i++) {

				List<String> availableTimeList = Arrays
						.asList(doctorDetailsInformationList.get(i).getAvailableTime().split(","));
				List<AppointmentTime> appointmentTimeList = appointmentTimeRepository.getDoctorAppointMentTime(
						availableTimeList.get(0), availableTimeList.get(availableTimeList.size() - 1));

				System.out.println(appointmentTimeList.toString());

				if (appointmentTimeList.size() != 0) {
					String docAvailableTime = appointmentTimeList.get(i).getTime() + " To "
							+ appointmentTimeList.get(i + 1).getTime();

					doctorDetailsInformationList.get(i).setAvailableTime(docAvailableTime);
				} else {
					doctorDetailsInformationList.get(i).setAvailableTime("0");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return doctorDetailsInformationList;

	}
	// Get Patient username details

	@RequestMapping(value = { "/getPatientByUserNameForForgotPassword" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails getPatientByUserNameForForgotPassword(@RequestParam("userName") String uName)

	{
 
		try {

			PatientDetails patientDetailsRes = patientDetailsRepository.findByUserNameAndDelStatus(uName, 0);
			if (patientDetailsRes != null) {
				 
				 
				String otp = String.valueOf(Constants.generateOTP(6));
				sendTextMessageService.sendTextSms("One Time Password is "+otp+" for Forgot Password", patientDetailsRes.getContactNo());
				patientDetailsRes.setPassword(otp);
				String contactNo="******"+patientDetailsRes.getContactNo().substring(patientDetailsRes.getContactNo().length()-4, patientDetailsRes.getContactNo().length());
				patientDetailsRes.setContactNo(contactNo);
				return patientDetailsRes;
				
			} 

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@RequestMapping(value = { "/doctorDetailsByUsrname" }, method = RequestMethod.POST)
	public @ResponseBody DoctorDetails doctorDetailsByUsrname(@RequestParam("userName") String userName)

	{
		Info info = new Info();
		DoctorDetails doctorDetails = new DoctorDetails();
		try {
			doctorDetails = doctorDetailsRepository.getLoginUserName(userName);
if(doctorDetails!=null)
{
 
	      
	 
	String otp = String.valueOf(Constants.generateOTP(6));
	sendTextMessageService.sendTextSms("One Time Password is "+otp+" for Forgot Password", doctorDetails.getContactNo());
	doctorDetails.setPassword(otp);
	String contactNo="******"+doctorDetails.getContactNo().substring(doctorDetails.getContactNo().length()-4, doctorDetails.getContactNo().length());
	doctorDetails.setContactNo(contactNo);
}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doctorDetails;

	}
	
	
	

	@RequestMapping(value = { "/pharmacyDetailsByUsrname" }, method = RequestMethod.POST)
	public @ResponseBody MedicalDetails pharmacyDetailsByUsrname(@RequestParam("userName") String userName)

	{
		Info info = new Info();
		MedicalDetails medicalDetails = new MedicalDetails();
		try {
			medicalDetails = medicalDetailsRepository.findByUserNameAndDelStatus(userName, 0);

			if(medicalDetails!=null)
			{
			 
				      
				 
				String otp = String.valueOf(Constants.generateOTP(6));
				sendTextMessageService.sendTextSms("One Time Password is "+otp+" for Forgot Password", medicalDetails.getContact());
				medicalDetails.setPassword(otp);
				String contactNo="******"+medicalDetails.getContact().substring(medicalDetails.getContact().length()-4, medicalDetails.getContact().length());
				medicalDetails.setContact(contactNo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return medicalDetails;

	}

	@RequestMapping(value = { "/getAppmtDetailsByDoctorIdPatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAppointmentDetails> getAppmtDetailsByDoctorIdPatId(
			@RequestParam("doctorId") int doctorId, @RequestParam("patientId") int patientId) {
		System.out.println("Doctor " + doctorId);

		List<GetAppointmentDetails> appointmentDetailsList = new ArrayList<>();
		try {
			appointmentDetailsList = getAppointmentDetailsRepository.getAppmtDetailsByDoctorIdPatId(doctorId,
					patientId);
			System.out.println("qhjdahbd:" + appointmentDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDetailsList;
	}

	// change doctor profile
	@RequestMapping(value = { "/updateDoctorProfilePic" }, method = RequestMethod.POST)
	public @ResponseBody Info updateDoctorProfilePic(@RequestParam("doctorId") int doctorId,
			@RequestParam("profilePhotoName") String profilePhotoName)

	{
		int res;

		Info info = new Info();
		try {
			res = doctorDetailsRepository.updateDoctorPic(doctorId, profilePhotoName);
			if (res > 0) {
				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = { "/getPatientAddressDetails" }, method = RequestMethod.POST)
	public @ResponseBody PatientAddress getPatientAddressDetails(@RequestParam("patientId") int patientId)

	{
		PatientAddress patientAddress = new PatientAddress();
		try {
			patientAddress = patientAddressRepository.getPatientAddress(patientId);
			System.out.println("patientDetailsRes:" + patientAddress.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return patientAddress;

	}

	// change patient password
	@RequestMapping(value = { "/changePatientPasswordByUserName" }, method = RequestMethod.POST)
	public @ResponseBody Info changePatientPasswordByUserName(@RequestParam("userName") String userName,
			@RequestParam("newPassword") String newPassword)

	{
		int res;

		Info info = new Info();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;

			}
			res = patientDetailsRepository.updateNewPasswordByUserName(userName, hashedPass);

			if (res > 0) {
				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = { "/getDoctorAppointmentTimeStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<AppointmentTime> getDoctorAppointTimeStatus(@RequestParam("doctorId") int doctorId,
			@RequestParam("date") String date) {

		List<AppointmentTime> allAppointmentTime = new ArrayList<>();
		try {
			allAppointmentTime = appointmentTimeRepository.getDoctorAppointMentTimeStatus(doctorId, date);
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return allAppointmentTime;
	}

	@RequestMapping(value = { "/submitVerificationCode" }, method = RequestMethod.POST)
	public @ResponseBody Info submitVerificationCode(@RequestBody ForgetPwdVerificationCode forgetPwdVerificationCode) {

		Info info = new Info();
		ForgetPwdVerificationCode forgetPwdVerificationCodeRes = new ForgetPwdVerificationCode();
		try {
			int res = forgetPwdVerificationCodeRepository.deleteCodeByTypeAndUserName(
					forgetPwdVerificationCode.getUserName(), forgetPwdVerificationCode.getType());
			forgetPwdVerificationCodeRes = forgetPwdVerificationCodeRepository.save(forgetPwdVerificationCode);
			if (forgetPwdVerificationCodeRes != null) {
				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/getVerificationCodeByUserName" }, method = RequestMethod.POST)
	public @ResponseBody ForgetPwdVerificationCode getVerificationCodeByUserName(
			@RequestParam("userName") String userName, @RequestParam("type") int type) {

		System.out.println("userName:" + userName + " " + type);
		ForgetPwdVerificationCode forgetPwdVerificationCode = new ForgetPwdVerificationCode();
		try {
			forgetPwdVerificationCode = forgetPwdVerificationCodeRepository.getCodeDetailsByUserName(userName, type);
			System.out.println("forgetPwdVerificationCode:" + forgetPwdVerificationCode.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forgetPwdVerificationCode;
	}

	@RequestMapping(value = { "/getGetPatientContactDetailsById" }, method = RequestMethod.POST)
	public @ResponseBody GetPatientContactDetailsById getGetPatientContactDetailsById(
			@RequestParam("patientId") int patientId) {

		return getPatientContactDetailsByIdRepository.getPatientContactDetailsById(patientId);
	}

	// change patient password
	@RequestMapping(value = { "/changeDoctorPasswordByUserName" }, method = RequestMethod.POST)
	public @ResponseBody Info changeDoctorPasswordByUserName(@RequestParam("userName") String userName,
			@RequestParam("newPassword") String newPassword)

	{
		int res;

		Info info = new Info();
		try {

			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;

			}
			res = doctorDetailsRepository.updateNewPasswordByuserName(userName, hashedPass);
			if (res > 0) {
				info.setMessage("Password Successfully Change");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = { "/mailForSendOTP" }, method = RequestMethod.POST)
	public @ResponseBody Info mailForSendOTP(@RequestParam("generatedOTP") int generatedOTP,
			@RequestParam("mail") String mail) {
		Info info = new Info();
		try {
			sendEMailService.sendMail("Bionische OTP",
					generatedOTP + "is your One Time Password for verification of user", mail);
			info.setMessage("Mail Send Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	// change lab password
	@RequestMapping(value = { "/changeLabPasswordByUserName" }, method = RequestMethod.POST)
	public @ResponseBody Info changeLabPasswordByUserName(@RequestParam("userName") String userName,
			@RequestParam("newPassword") String newPassword)

	{
		int res;

		Info info = new Info();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}
			res = labDetailsRepository.updateNewPasswordByUserName(userName, hashedPass);

			if (res > 0) {
				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed to change password!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	// change patient password
	@RequestMapping(value = { "/deleteVerificationCodeById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteVerificationCodeById(@RequestParam("verificationId") int verificationId)

	{
		int res;

		Info info = new Info();
		try {

			res = forgetPwdVerificationCodeRepository.deleteVerifivcationCode(verificationId);
			if (res > 0) {
				info.setMessage("success");
				info.setError(false);
			} else {
				info.setMessage("Failed delete verification code!");
				info.setError(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = { "/getPatientDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails getPatientDetailsByPatientId(@RequestParam("patientId") int patientId)

	{
		PatientDetails patientDetailsRes = new PatientDetails();
		try {

			patientDetailsRes = patientDetailsRepository.findByPatientId(patientId);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return patientDetailsRes;

	}

	@RequestMapping(value = { "/getLabAppointMentTimeStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<AppointmentTime> getLabAppointMentTimeStatus(@RequestParam("labId") int labId,
			@RequestParam("fromTime") int fromTime, @RequestParam("toTime") int toTime,
			@RequestParam("date") String date)

	{

		return appointmentTimeRepository.getLabAppointMentTimeStatus(labId, date, fromTime, toTime);

	}

	@RequestMapping(value = { "/getAllAppointTime" }, method = RequestMethod.POST)
	public @ResponseBody AppointmentTimeList getAllAppointTime(@RequestParam("doctorId") int doctorId,
			@RequestParam("date") String date) {

		AppointmentTimeList appointmentTimeList = new AppointmentTimeList();
		System.out.println("before " + date);

		List<AppointmentTime> appointmentTime = new ArrayList<>();
		List<AppointmentTime> allAppointmentTime = new ArrayList<>();
		try {

			// DocAvailableTime docAvailableTime =
			// docAvailableTimeRepository.getAvailableTimeDBYDoctorId(doctorId, date);

			appointmentTime = appointmentTimeRepository.getAllAppointmentTime(doctorId, date);
			appointmentTimeList.setAppointmentTimeList(appointmentTime);
			// List<String> unavailableTimeList =
			// Arrays.asList(docAvailableTime.getUnavailableTime().split(","));
			// allAppointmentTime=
			// appointmentTimeRepository.getDoctorAppointMentTime(docAvailableTime.getFromTime(),
			// docAvailableTime.getToTime(), unavailableTimeList);
			System.out.println("allAppointmentTime:" + allAppointmentTime.toString());

			appointmentTimeList.setAllAppointmentTimeList(allAppointmentTime);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return appointmentTimeList;
	}

	@RequestMapping(value = { "/messageForSendOTP" }, method = RequestMethod.POST)
	public @ResponseBody Info messageForSendOTP(@RequestParam("generatedOTP") int generatedOTP,
			@RequestParam("contactNo") String contactNo) {
		Info info = new Info();
		MESSAGE = generatedOTP + " is your One Time Password for verification of user mobile number";
		try {

			sendTextMessageService.sendTextSms(MESSAGE, contactNo);
			info.setMessage("Message Send Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/getTermsAndConditionByUserType" }, method = RequestMethod.POST)
	public @ResponseBody TermsAndConditions getTermsAndConditionByUserType(@RequestParam("userType") int userType) {

		TermsAndConditions termsAndConditions = new TermsAndConditions();

		try {
			termsAndConditions = termsAndConditionsRepository.findByUserTypeAndDelStatus(userType, 0);
			System.out.println(termsAndConditions.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return termsAndConditions;
	}

	@RequestMapping(value = { "/getAllRelations" }, method = RequestMethod.GET)
	public @ResponseBody List<PatientMemberRelation> getAllRelations() {

		List<PatientMemberRelation> allRelations = new ArrayList<>();

		try {
			allRelations = patientMemberRelationRepository.getAllRelations();
			System.out.println(allRelations.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRelations;
	}

	@RequestMapping(value = { "/getRelations" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientMemberRelation> getRelations(@RequestBody List<String> relations) {

		List<PatientMemberRelation> allRelations = new ArrayList<>();

		try {
			allRelations = patientMemberRelationRepository.getRelations(relations);
			System.out.println(allRelations.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRelations;
	}

	// username validation
	@RequestMapping(value = { "/mobileValidationOfDoctor" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyContactNumber(@RequestParam("contactNo") String contactNo)

	{
		System.out.println("ssss" + contactNo);
		Info info = new Info();
		DoctorDetails doctorDetails = new DoctorDetails();
		try {
			doctorDetails = doctorDetailsRepository.getContactNumbers(contactNo);

			if (doctorDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/verifyDoctorEmail" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyDoctorEmail(@RequestParam("email") String email)

	{

		Info info = new Info();
		DoctorDetails doctorDetails = new DoctorDetails();
		try {
			doctorDetails = doctorDetailsRepository.getDoctorEmail(email);

			if (doctorDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/verifyPatientContactNumber" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyPatientContactNumber(@RequestParam("contactNo") String contactNo)

	{

		Info info = new Info();
		PatientDetails patientDetails = new PatientDetails();
		try {
			patientDetails = patientDetailsRepository.getContactNumbers(contactNo);

			if (patientDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/verifyPatientEmail" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyPatientEmail(@RequestParam("email") String email)

	{

		Info info = new Info();
		PatientDetails patientDetails = new PatientDetails();
		try {
			patientDetails = patientDetailsRepository.getPatientEmail(email);

			if (patientDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/verifyLabContactNumber" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyLabContactNumber(@RequestParam("contactNo") String contactNo)

	{

		Info info = new Info();
		LabDetails labDetails = new LabDetails();
		try {
			labDetails = labDetailsRepository.getContactNumbers(contactNo);

			if (labDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/verifyLabEmail" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyLabEmail(@RequestParam("email") String email)

	{

		Info info = new Info();
		LabDetails labDetails = new LabDetails();
		try {
			labDetails = labDetailsRepository.getLabEmail(email);

			if (labDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/verifyPharmacyContactNumber" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyPharmacyContactNumber(@RequestParam("contactNo") String contactNo)

	{

		Info info = new Info();
		MedicalDetails medicalDetails = new MedicalDetails();
		try {
			medicalDetails = medicalDetailsRepository.getContactNumbers(contactNo);

			if (medicalDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// username validation
	@RequestMapping(value = { "/verifyPharmacyEmail" }, method = RequestMethod.POST)
	public @ResponseBody Info verifyPharmacyEmail(@RequestParam("email") String email)

	{

		Info info = new Info();
		MedicalDetails medicalDetails = new MedicalDetails();
		try {
			medicalDetails = medicalDetailsRepository.getPharmacyEmail(email);

			if (medicalDetails != null) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	// amruta Lab Rating
	@RequestMapping(value = { "/getDoctorRatingByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody GetRatingCount getDoctorRatingByDoctorId(@RequestParam("doctorId") int doctorId) {

		GetRatingCount getRatingCount = new GetRatingCount();
		try {
			getRatingCount = getRatingCountRepository.getDoctorRating(doctorId);
			System.out.println("getRatingCount:" + getRatingCount.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getRatingCount;
	}

	@RequestMapping(value = { "/getDoctorNotification" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorNotification> getDoctorNotification(@RequestParam("doctorId") int doctorId) {

		return doctorNotificationRepository.findFirst20ByDoctorIdOrderByNotificationIdDesc(doctorId);
	}

	@RequestMapping(value = { "/getAllDoctorNotification" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorNotification> getAllDoctorNotification(@RequestParam("doctorId") int doctorId) {

		return doctorNotificationRepository.findFirst100ByDoctorIdOrderByNotificationIdDesc(doctorId);
	}

	@RequestMapping(value = { "/changeDoctorNotificationStatus" }, method = RequestMethod.POST)
	public @ResponseBody int changeDoctorNotificationStatus(@RequestParam("notificationId") int notificationId) {

		return doctorNotificationRepository.updateNotificationStatus(notificationId, 1);
	}

	@RequestMapping(value = { "/getPatientNotification" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientNotification> getPatientNotification(@RequestParam("familyId") int familyId) {

		List<PatientDetails> patientDetailsList = patientDetailsRepository.findByFamilyIdAndDelStatus(familyId, 0);

		List<PatientNotification> patientNotificationList = new ArrayList<PatientNotification>();
		for (PatientDetails list : patientDetailsList) {
			List<PatientNotification> patientNotificationRes = patientNotificationRepository
					.findFirst20ByPatientIdOrderByNotificationIdDesc(list.getPatientId());
			if (patientNotificationRes != null) {
				patientNotificationList.addAll(patientNotificationRes);
			}
		}
		patientNotificationList.sort(Comparator.comparingDouble(PatientNotification::getNotificationId).reversed());

		return patientNotificationList;
	}

	@RequestMapping(value = { "/changePatientNotificationStatus" }, method = RequestMethod.POST)
	public @ResponseBody int changePatientNotificationStatus(@RequestParam("notificationId") int notificationId) {

		return patientNotificationRepository.updateNotificationStatus(notificationId, 1);
	}

	@RequestMapping(value = { "/getAllPatientNotification" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientNotification> getAllPatientNotification(@RequestParam("patientId") int patientId) {

		return patientNotificationRepository.findFirst100ByPatientIdOrderByNotificationIdDesc(patientId);
	}

	@RequestMapping(value = { "/insertDoctorCertificateDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertDoctorCertificateDetails(
			@RequestBody DoctorCertificateDetails doctorCertificateDetails) {
		Info info = new Info();
		try {
			doctorCertificateDetailsRepository.save(doctorCertificateDetails);
			
			doctorDetailsRepository.updateDoctorDelStatus(doctorCertificateDetails.getDoctorId(), 2);
			info.setError(false);
			info.setMessage("success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed");
		}
		return info;
	}

	@RequestMapping(value = { "/insertLabCertificateDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertLabCertificateDetails(@RequestBody LabCertificateDetails labCertificateDetails) {
		Info info = new Info();
		try {
			labCertificateDetailsRepository.save(labCertificateDetails);
			info.setError(false);
			info.setMessage("success");
			labDetailsRepository.updateLabDelStatus(labCertificateDetails.getLabId(), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed");
		}
		return info;
	}

	@RequestMapping(value = { "/insertPharmacyCertificateDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertPharmacyCertificateDetails(
			@RequestBody PharmacyCertificateDetails pharmacyCertificateDetails) {
		Info info = new Info();
		try {
			pharmacyCertificateDetailsRepository.save(pharmacyCertificateDetails);
			
			medicalDetailsRepository.updateMedicalDelStatus(pharmacyCertificateDetails.getMedicalId(), 2);
			info.setError(false);
			info.setMessage("success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed");
		}
		return info;
	}

	@RequestMapping(value = { "/getHospitalClinicByDoctorIdAndAvailDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdAndAvailDate(
			@RequestParam("doctorId") int doctorId, @RequestParam("date") String date) {

		List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdAndAvailDateList = getHospitalClinicByDoctorIdAndAvailDateRepository
				.getHospitalClinicByDoctorIdAndAvailDate(doctorId, date);

		for (int i = 0; i < getHospitalClinicByDoctorIdAndAvailDateList.size(); i++) {
			List<String> availableTimeList = Arrays
					.asList(getHospitalClinicByDoctorIdAndAvailDateList.get(i).getAvailableTime().split(","));

			for (int j = 0; j < availableTimeList.size(); j++) {
				List<AppointmentTime> appointmentTimeList = appointmentTimeRepository.getDoctorAppointMentTime(
						availableTimeList.get(j), availableTimeList.get(availableTimeList.size() - 1));

				for (int k = 0; k < appointmentTimeList.size(); k++) {
					if (appointmentTimeList.get(k).getTimeId() == Integer.parseInt(availableTimeList.get(j)))
						getHospitalClinicByDoctorIdAndAvailDateList.get(i)
								.setFromTime(appointmentTimeList.get(k).getTime());
					else if (appointmentTimeList.get(k).getTimeId() == Integer
							.parseInt(availableTimeList.get(availableTimeList.size() - 1)))
						getHospitalClinicByDoctorIdAndAvailDateList.get(i)
								.setToTime(appointmentTimeList.get(k).getTime());
				}
				j = j + availableTimeList.size();

			}
		}

		return getHospitalClinicByDoctorIdAndAvailDateList;
	}

	// Ganesh
	@RequestMapping(value = { "/getUserCounts" }, method = RequestMethod.GET)
	public @ResponseBody GetUsersCount getUserCounts() {
		return getUsersCountRepository.getUserCounts();
	}

	@RequestMapping(value = { "/updateRatingDoneNotificatiion" }, method = RequestMethod.POST)
	public @ResponseBody Info updateRatingDoneNotificatiion(@RequestParam("notificationId") int notificationId) {

		int res = patientNotificationRepository.updateDoneRating(notificationId);

		Info info = new Info();
		if (res > 0) {
			info.setMessage("success");
			info.setError(false);
		} else {
			info.setMessage("failed");
			info.setError(true);
		}

		return info;
	}

	@RequestMapping(value = { "/updateLabRatingDoneNotificatiion" }, method = RequestMethod.POST)
	public @ResponseBody Info updateLabRatingDoneNotificatiion(@RequestParam("notificationId") int notificationId) {

		int res = patientNotificationRepository.updateLabDoneRating(notificationId, "ldone");

		Info info = new Info();
		if (res > 0) {
			info.setMessage("success");
			info.setError(false);
		} else {
			info.setMessage("failed");
			info.setError(true);
		}

		return info;
	}

	@RequestMapping(value = { "/getHospitalClinicByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorId(
			@RequestParam("doctorId") int doctorId) {

		List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdAndAvailDateList = getHospitalClinicByDoctorIdAndAvailDateRepository
				.getHospitalClinicByDoctorId(doctorId);

		for (int i = 0; i < getHospitalClinicByDoctorIdAndAvailDateList.size(); i++) {
			List<String> availableTimeList = Arrays
					.asList(getHospitalClinicByDoctorIdAndAvailDateList.get(i).getAvailableTime().split(","));

			for (int j = 0; j < availableTimeList.size(); j++) {
				List<AppointmentTime> appointmentTimeList = appointmentTimeRepository.getDoctorAppointMentTime(
						availableTimeList.get(j), availableTimeList.get(availableTimeList.size() - 1));

				for (int k = 0; k < appointmentTimeList.size(); k++) {
					if (appointmentTimeList.get(k).getTimeId() == Integer.parseInt(availableTimeList.get(j)))
						getHospitalClinicByDoctorIdAndAvailDateList.get(i)
								.setFromTime(appointmentTimeList.get(k).getTime());
					else if (appointmentTimeList.get(k).getTimeId() == Integer
							.parseInt(availableTimeList.get(availableTimeList.size() - 1)))
						getHospitalClinicByDoctorIdAndAvailDateList.get(i)
								.setToTime(appointmentTimeList.get(k).getTime());
				}
				j = j + availableTimeList.size();

			}
		}

		return getHospitalClinicByDoctorIdAndAvailDateList;
	}

	@RequestMapping(value = { "/sendOtpOnMobile" }, method = RequestMethod.POST)
	public @ResponseBody Info sendOtpOnMobile(@RequestParam("contactNo") String contactNo) {
		Info info = new Info();
		// create instance of Random class
		 
		// Generate random integers in range 0 to 999
		String generatedOTP=String.valueOf(Constants.generateOTP(6));
		 

		MESSAGE = generatedOTP + " is your One Time Password for verification of user mobile number";
		try {

			sendTextMessageService.sendTextSms(MESSAGE, contactNo);
			info.setMessage("" + generatedOTP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping(value = { "/getPatientDetailsForEdit" }, method = RequestMethod.POST)
	public @ResponseBody GetPatientDetailsForEdit getPatientDetailsForEdit(@RequestParam("patientId") int patientId) {

		return getPatientDetailsForEditRepository.getPatientDetailsByPatientId(patientId);
	}

	@RequestMapping(value = { "/updatePatientProfilePic" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePatientProfilePic(@RequestParam("patientId") int patientId,
			@RequestParam("profilePhotoName") String profilePhotoName)

	{
		int res = 0;
		Info info = new Info();
		try {
			res = patientDetailsRepository.updatePatientProfile(patientId, profilePhotoName);

			if (res > 0) {

				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return info;

	}

	@RequestMapping(value = { "/sendConsultingPaymentRequest" }, method = RequestMethod.POST)
	public @ResponseBody Info sendConsultingPaymentRequest(@RequestParam("patientId") int patientId,
			@RequestParam("appointmentId") int appointmentId) {

		PatientNotification patientNotification = new PatientNotification();
		patientNotification.setPatientId(patientId);
		patientNotification
				.setNotification("Your Appointment payment is pending Please make a payment to consult with doctor");
		patientNotification.setStatus(0);
		patientNotification.setString1("Appointment Status");
		patientNotification.setString2("cpayment");
		patientNotification.setInt1(appointmentId);
		try {
			patientNotificationRepository.save(patientNotification);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Payment Request sent successfully!");

			return info;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/isReferalCorrect" }, method = RequestMethod.POST)
	public @ResponseBody ReferalDetails isReferalCorrect(@RequestParam("referal") String referal) {

		ReferalDetails referalDetails = new ReferalDetails();

		try {

			referalDetails = referalDetailsRepository.findByReferal(referal);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return referalDetails;
	}

	@RequestMapping(value = { "/isPatientReferalCorrect" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails isPatientReferalCorrect(@RequestParam("referal") String referal) {

		PatientDetails patientDetails = new PatientDetails();

		try {

			patientDetails = patientDetailsRepository.findByReferal(referal);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientDetails;
	}

	@RequestMapping(value = { "/getUserWalletDetails" }, method = RequestMethod.POST)
	public @ResponseBody WalletDetails getUserWalletDetails(@RequestParam("userId") int userId,
			@RequestParam("userType") int userType) {

		WalletDetails walletDetails = new WalletDetails();

		try {

			walletDetails = walletDetailsRepository.findByUserIdAndUserType(userId, userType);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return walletDetails;
	}
}

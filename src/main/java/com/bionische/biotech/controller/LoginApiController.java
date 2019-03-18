package com.bionische.biotech.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorLogin;
import com.bionische.biotech.model.DoctorSubscriptionDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.LabLogin;
import com.bionische.biotech.model.LabSubscriptionDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientLogin;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.DoctorSubscriptionDetailsRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.LabSubscriptionDetailsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.PatientSuscriptionDetailsRepository;
import com.bionische.biotech.service.UpdateTokenAndDeviceTypeService;

@RestController
public class LoginApiController {

	@Autowired
	PatientDetailsRepository patientDetailsRepository;

	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;

	@Autowired
	UpdateTokenAndDeviceTypeService updateTokenAndDeviceTypeService;

	@Autowired
	LabDetailsRepository labDetailsRepository;

	@Autowired
	DoctorSubscriptionDetailsRepository doctorSubscriptionDetailsRepository;
	@Autowired
	PatientSuscriptionDetailsRepository patientSuscriptionDetailsRepository;
	@Autowired
	LabSubscriptionDetailsRepository labSubscriptionDetailsRepository;

	
	@RequestMapping(value = { "/getPatientDetailsByIdAndUpdateToken" }, method = RequestMethod.POST)
	public @ResponseBody PatientDetails getPatientDetailsByIdAndUpdateToken(@RequestParam("patientId") int patientId, @RequestParam("token") String token)
	
	{
		PatientDetails patientDetailsRes=new PatientDetails();
	 try {
		 if(patientSuscriptionDetailsRepository.findByPatientIdAndStatus(patientId, 1)!=null) {
		 patientDetailsRes=	patientDetailsRepository.getPatientDetailsBYId(patientId);
		 patientDetailsRepository.updateWebToken(patientId, token);
	 
		 System.out.println("patientDetailsRes:"+patientDetailsRes.toString());
		 }
	 }
	 catch (Exception e) {
System.out.println(e.getMessage());
	}
	 return patientDetailsRes;
	  
	}
	@RequestMapping(value = { "/patientLoginProcess" }, method = RequestMethod.POST)
	public @ResponseBody PatientLogin patientLoginProcess(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {

		System.out.println("dttfy;" + userName);
		PatientDetails patientDetails = new PatientDetails();

		PatientLogin patientLogin = new PatientLogin();
		Info info = new Info();

		patientDetails = patientDetailsRepository.getPatientLogin(userName);
		if (patientDetails != null) {

			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(password.getBytes(), 0, password.length());
				String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
				if (hashedPass.length() < 32) {
					hashedPass = "0" + hashedPass;
				}
				System.out.println(hashedPass);
				System.out.println(patientDetails.getPassword());
				if (patientDetails.getPassword().equals(hashedPass)) {
					patientDetails.setPassword("");
					patientLogin.setPatientDetails(patientDetails);
					info.setError(false);
					info.setMessage("Login Successfull");

					patientLogin.setInfo(info);
					Info suscriptionInfo = new Info();
					suscriptionInfo.setError(true);
					if (patientSuscriptionDetailsRepository.findByPatientIdAndStatus(patientDetails.getPatientId(),
							1) != null) {

						suscriptionInfo.setError(false);
						suscriptionInfo.setMessage("Valid Patient");
					} else {
						suscriptionInfo.setError(true);
						suscriptionInfo.setMessage("Patient payment Not Update yet");
					}
				} else {
					info.setError(true);
					info.setMessage("Please enter valid credential");
					patientLogin.setInfo(info);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
		} else {
			info.setError(true);
			info.setMessage("Patient Not Register");
			patientLogin.setInfo(info);
		}

		System.out.println("res " + patientLogin.toString());
		return patientLogin;
	}

	@RequestMapping(value = { "/doctorLoginProcess" }, method = RequestMethod.POST)
	public @ResponseBody DoctorLogin doctorLoginProcess(@RequestParam("userName") String userName,
			@RequestParam("password") String password,@RequestParam("webToken") String webToken) {
		System.out.println("hbd:" + userName);

		DoctorDetails doctorDetails = new DoctorDetails();

		DoctorLogin doctorLogin = new DoctorLogin();
		Info info = new Info();
		try {
			doctorDetails = doctorDetailsRepository.getLoginUserName(userName);
			System.out.println(userName + " Password  " + password + "   List  " + doctorDetails.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()); // TODO: handle exception
		}
		if (doctorDetails != null) {

			// patientDetails=patientDetailsRepository.findByUserNameAndPassword(userName,
			// password);
			System.out.println(userName + " Password  " + password + "   List  " + doctorDetails.toString());
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(password.getBytes(), 0, password.length());
				String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
				if (hashedPass.length() < 32) {
					hashedPass = "0" + hashedPass;
				}
				System.out.println(hashedPass);
				if (doctorDetails.getPassword().equals(hashedPass)) {
					
					doctorLogin.setDoctorDetails(doctorDetails);
					info.setError(false);
					info.setMessage("Login Successfull");
					doctorLogin.setInfo(info);
					Info doctorSuscriptionInfo = new Info();
					doctorSuscriptionInfo.setError(true);
					DoctorSubscriptionDetails doctorSubscriptionDetailsRes = doctorSubscriptionDetailsRepository
							.findByPackageExpDateGreaterThanEqualAndDoctorIdAndTxnStatus(
									new SimpleDateFormat("yyyy-MM-dd").format(new Date()), doctorDetails.getDoctorId(),
									1);
					if (doctorSubscriptionDetailsRes != null) {
						doctorSuscriptionInfo.setError(false);
						doctorSuscriptionInfo.setMessage(doctorSubscriptionDetailsRes.getPackageExpDate());
						doctorLogin.setDoctorSuscriptionInfo(doctorSuscriptionInfo);
						doctorDetailsRepository.updateDoctorWebTokenByDoctorId(doctorDetails.getDoctorId(), webToken);
						 
						doctorDetails.setPassword("");
						
					} else {
						doctorSuscriptionInfo.setError(true);
						doctorSuscriptionInfo.setMessage("Doctor Suscription is pendding");
						doctorLogin.setDoctorSuscriptionInfo(doctorSuscriptionInfo);
					}

				} else {
					info.setError(true);
					info.setMessage("Please enter valid credential");
					doctorLogin.setInfo(info);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
		} else {
			info.setError(true);
			info.setMessage("Doctor Not Register");
			doctorLogin.setInfo(info);
		}

		return doctorLogin;
	}

	@RequestMapping(value = { "/labLoginProcess" }, method = RequestMethod.POST)
	public @ResponseBody LabLogin labLoginProcess(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {

		LabDetails labDetails = new LabDetails();

		LabLogin labLogin = new LabLogin();
		Info info = new Info();

		labDetails = labDetailsRepository.getLoginByUserName(userName);
		if (labDetails != null) {

			// patientDetails=patientDetailsRepository.findByUserNameAndPassword(userName,
			// password);
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(password.getBytes(), 0, password.length());
				String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
				if (hashedPass.length() < 32) {
					hashedPass = "0" + hashedPass;
				}
				System.out.println(hashedPass);
				if (labDetails.getPassword().equals(hashedPass)) {
					labDetails.setPassword("");
					labLogin.setLabDetails(labDetails);
					info.setError(false);
					info.setMessage("Login Successfull");
					labLogin.setInfo(info);

					Info labSuscriptionInfo = new Info();
					labSuscriptionInfo.setError(true);
					LabSubscriptionDetails labSubscriptionDetailsRes = labSubscriptionDetailsRepository
							.findByPackageExpDateGreaterThanEqualAndLabIdAndTxnStatus(
									new SimpleDateFormat("yyyy-MM-dd").format(new Date()), labDetails.getLabId(), 1);

					if (labSubscriptionDetailsRes != null) {
						labSuscriptionInfo.setError(false);
						labSuscriptionInfo.setMessage(labSubscriptionDetailsRes.getPackageExpDate());
						labLogin.setLabSuscriptionInfo(labSuscriptionInfo);
					} else {
						labSuscriptionInfo.setError(true);
						labSuscriptionInfo.setMessage("Lab Suscription is pendding");
						labLogin.setLabSuscriptionInfo(labSuscriptionInfo);
					}

				} else {
					info.setError(true);
					info.setMessage("Please enter valid credential");
					labLogin.setInfo(info);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
		} else {
			info.setError(true);
			info.setMessage("Doctor Not Register");
			labLogin.setInfo(info);
		}

		return labLogin;
	}

	@RequestMapping(value = { "/passwordValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info passwordValidation(@RequestParam("patientId") int patientId,
			@RequestParam("password") String password)

	{
		Info info = new Info();
		PatientDetails patientDetailsRes = new PatientDetails();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes(), 0, password.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}
			patientDetailsRes = patientDetailsRepository.passwordValidation(patientId, hashedPass);

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

	@RequestMapping(value = { "/passwordDocValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info passwordDocValidation(@RequestParam("doctorId") int doctorId,
			@RequestParam("password") String password)

	{
		Info info = new Info();
		DoctorDetails doctorDetailsRes = new DoctorDetails();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes(), 0, password.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}
			doctorDetailsRes = doctorDetailsRepository.passwordDocValidation(doctorId, hashedPass);

			if (doctorDetailsRes != null) {

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

	@RequestMapping(value = { "/passwordLabValidation" }, method = RequestMethod.POST)
	public @ResponseBody Info passwordLabValidation(@RequestParam("labId") int labId,
			@RequestParam("password") String password)

	{
		Info info = new Info();
		LabDetails labDetailsRes = new LabDetails();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes(), 0, password.length());
			String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}
			labDetailsRes = labDetailsRepository.passwordLabValidation(labId, hashedPass);

			if (labDetailsRes != null) {

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

	/*
	 * @RequestMapping(value = { "/updateFCMToken" }, method = RequestMethod.POST)
	 * public @ResponseBody Info updateFCMToken(@RequestBody FCMNotificationDetails
	 * fcmNotificationDetails) { Info info=new Info();
	 * 
	 * 
	 *//**
		 * If userType=1 is for patient token update and userType=2 is for doctor token
		 * update.
		 *//*
			 * 
			 * 
			 * if(fcmNotificationDetails.getUserType()==1){
			 * //patientDetailsRepository.updateDoctorTokenAsString2ByPatientId(
			 * fcmNotificationDetails.getUserId(),fcmNotificationDetails.getToken()); }else
			 * { //doctorDetailsRepository.updateDoctorTokenAslocationByDoctorId(
			 * fcmNotificationDetails.getUserId(),fcmNotificationDetails.getToken()); }
			 * return info;
			 * 
			 * 
			 * }
			 */

	@RequestMapping(value = { "/patientLoginProcessForMobileApp" }, method = RequestMethod.POST)
	public @ResponseBody PatientLogin patientLoginProcessForMobileApp(@RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("token") String token,
			@RequestParam("deviceType") int deviceType) {

		System.out.println("dttfy;" + userName);
		PatientDetails patientDetails = new PatientDetails();

		PatientLogin patientLogin = new PatientLogin();
		Info info = new Info();

		patientDetails = patientDetailsRepository.getPatientLogin(userName);
		if (patientDetails != null) {

			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(password.getBytes(), 0, password.length());
				String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
				if (hashedPass.length() < 32) {
					hashedPass = "0" + hashedPass;
				}
				System.out.println(hashedPass);
				System.out.println(patientDetails.getPassword());
				if (patientDetails.getPassword().equals(hashedPass)) {
					
					info.setError(false);
					info.setMessage("Login Successfull");
					int updatePatientTokenAndDevice = patientDetailsRepository
							.updatePatientTokenAsString2ByPatientId(patientDetails.getPatientId(), token, deviceType);
					patientDetails.setPassword("");
					patientLogin.setPatientDetails(patientDetails);
					patientLogin.setInfo(info);
					Info suscriptionInfo = new Info();
					suscriptionInfo.setError(true);
					if (patientSuscriptionDetailsRepository.findByPatientIdAndStatus(patientDetails.getPatientId(),
							1) != null) {

						suscriptionInfo.setError(false);
						suscriptionInfo.setMessage("Valid Patient");
					} else {
						suscriptionInfo.setError(true);
						suscriptionInfo.setMessage("Patient payment Not Update yet");
					}
				} else {
					info.setError(true);
					info.setMessage("Please enter valid credential");
					patientLogin.setInfo(info);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
		} else {
			info.setError(true);
			info.setMessage("Patient Not Register");
			patientLogin.setInfo(info);
		}

		System.out.println("res " + patientLogin.toString());
		return patientLogin;
	}

	@RequestMapping(value = { "/doctorLoginProcessForMobileApp" }, method = RequestMethod.POST)
	public @ResponseBody DoctorLogin doctorLoginProcessForMobileApp(@RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("token") String token,
			@RequestParam("deviceType") int deviceType) {
		System.out.println("hbd:" + userName);

		DoctorDetails doctorDetails = new DoctorDetails();

		DoctorLogin doctorLogin = new DoctorLogin();
		Info info = new Info();
		try {
			doctorDetails = doctorDetailsRepository.getLoginUserName(userName);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()); // TODO: handle exception
		}
		if (doctorDetails != null) {

			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(password.getBytes(), 0, password.length());
				String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
				if (hashedPass.length() < 32) {
					hashedPass = "0" + hashedPass;
				}

				if (doctorDetails.getPassword().equals(hashedPass)) {
					
					updateTokenAndDeviceTypeService.updateDoctorTokenAslocationByDoctorId(doctorDetails.getDoctorId(),
							token, deviceType);
					doctorDetails.setPassword("");
					doctorLogin.setDoctorDetails(doctorDetails);
					
					info.setError(false);
					info.setMessage("Login Successfull");
					//System.out.println("doctorLogin kaushik");
					
					
					//System.out.println("doctorLoginxscsc ram");
					doctorLogin.setInfo(info);
					Info doctorSuscriptionInfo = new Info();
					doctorSuscriptionInfo.setError(true);
					DoctorSubscriptionDetails doctorSubscriptionDetailsRes = doctorSubscriptionDetailsRepository
							.findByPackageExpDateGreaterThanEqualAndDoctorIdAndTxnStatus(
									new SimpleDateFormat("yyyy-MM-dd").format(new Date()), doctorDetails.getDoctorId(),
									1);
					if (doctorSubscriptionDetailsRes != null) {
						doctorSuscriptionInfo.setError(false);
						doctorSuscriptionInfo.setMessage(doctorSubscriptionDetailsRes.getPackageExpDate());
						doctorLogin.setDoctorSuscriptionInfo(doctorSuscriptionInfo);
					} else {
						doctorSuscriptionInfo.setError(true);
						doctorSuscriptionInfo.setMessage("Doctor Suscription is pendding");
						doctorLogin.setDoctorSuscriptionInfo(doctorSuscriptionInfo);
					}

				} else {
					info.setError(true);
					info.setMessage("Please enter valid credential");
					doctorLogin.setInfo(info);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
		} else {
			info.setError(true);
			info.setMessage("Doctor Not Register");
			doctorLogin.setInfo(info);
		}

		return doctorLogin;
	}

}

package com.bionische.biotech.ewallet.controller;

import java.text.DateFormat;
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
import com.bionische.biotech.adminpanel3d.model.Info;
import com.bionische.biotech.ewallet.model.BankTransferRequest;
import com.bionische.biotech.ewallet.model.GetWalletTransactionDetails;
import com.bionische.biotech.ewallet.model.TransactionWalletDetails;
import com.bionische.biotech.ewallet.model.WalletDetails;
import com.bionische.biotech.ewallet.repository.GetWalletTransactionDetailsRepository;
import com.bionische.biotech.ewallet.repository.UserWalletDetailsRepository;
import com.bionische.biotech.ewallet.repository.UserWalletTransactionRepository;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.repository.BankTransferRequestRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.TransactionWalletDetailsRepository;
import com.bionische.biotech.repository.WalletDetailsRepository;
import com.bionische.biotech.service.SendEMailService;
import com.bionische.biotech.service.SendFcmNotificationService;
import com.bionische.biotech.service.SendTextMessageService;

@RestController
public class UserWalletApiController {

	@Autowired
	private UserWalletTransactionRepository userWalletTransactionRepository;
	
	@Autowired
	private UserWalletDetailsRepository userWalletDetailsRepository;

	@Autowired
	private WalletDetailsRepository walletDetailsRepository;  
	
	@Autowired
	private TransactionWalletDetailsRepository transactionWalletDetailsRepository;
	
	@Autowired
	LabDetailsRepository labDetailsRepository;
	
	@Autowired
	MedicalDetailsRepository medicalDetailsRepository;

	@Autowired
	private GetWalletTransactionDetailsRepository getWalletTransactionDetailsRepository;
	
	@Autowired
	private BankTransferRequestRepository bankTransferRequestRepository;
	
	@Autowired
	SendEMailService sendEMailService;
	
	@Autowired
	SendTextMessageService sendTextMessageService;
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	

	
	
	String url="www.bionische.com";
	
	String PATIENT_REFERAL_URL="www.bionische.com";
	
	String DOCTOR_REFERAL_URL="www.bionische.com123";
	/*
	 * @author Ganesh
	 * get user All wallet  details 
	*/
	/*@RequestMapping(value = { "/getUserWalletDetails" }, method = RequestMethod.POST)
	public @ResponseBody UserWalletDetails getUserWalletDetails(@RequestParam("userId") int userId, @RequestParam("userType") int userType)
	{
		UserWalletDetails userWalletDetails=new UserWalletDetails();
		try {
		 
			userWalletDetails=	userWalletDetailsRepository.findByUserIdAndUserType(userId, userType);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		} 
		
		return userWalletDetails;
	}
	
	
	 * @author Ganesh
	 * get user Latest 10 wallet transaction records 
	
	@RequestMapping(value = { "/getUserLatestTransactionDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWalletTransactionDetails> getUserLatestTransactionDetails(@RequestParam("userId") int userId, @RequestParam("userType") int userType)
	{
		List<GetWalletTransactionDetails> getWalletTransactionDetailsList=new ArrayList<GetWalletTransactionDetails>();
		try {
		 
			getWalletTransactionDetailsList=	getWalletTransactionDetailsRepository.getWalletLatestTransactionDetails(userId, userType);
			System.out.println("getWalletTransactionDetailsList  "+getWalletTransactionDetailsList.toString());
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		}
		
		return getWalletTransactionDetailsList;
	}
	
	
	 * @author Ganesh
	 * get user All wallet transaction records 
	
	@RequestMapping(value = { "/getUserAllTransactionDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWalletTransactionDetails> getUserAllTransactionDetails(@RequestParam("userId") int userId, @RequestParam("userType") int userType)
	{
		List<GetWalletTransactionDetails> getWalletTransactionDetailsList=new ArrayList<GetWalletTransactionDetails>();
		try {
		 
			getWalletTransactionDetailsList=	getWalletTransactionDetailsRepository.getWalletTransactionDetails(userId, userType);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		} 
		
		return getWalletTransactionDetailsList;
	}
	 */
	/*@RequestMapping(value = { "/insertMoneyInWallet" }, method = RequestMethod.POST)
	public @ResponseBody WalletDetails insertMoneyInWallet(@RequestBody WalletDetails walletDetails)
	{
		try {
			
			
			 WalletDetails userWalletDetails=new WalletDetails();
			
			userWalletDetails=	walletDetailsRepository.save(walletDetails);
			
			
			return userWalletDetails;

		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
			
			return new WalletDetails();

		} 
		
	}*/
	
	@RequestMapping(value = { "/insertWalletTransaction" }, method = RequestMethod.POST)
	public @ResponseBody TransactionWalletDetails insertWalletTransaction(@RequestBody TransactionWalletDetails transactionWalletDetails)
	{
		TransactionWalletDetails userWalletTransaction=new TransactionWalletDetails();
		try {
			
			userWalletTransaction=transactionWalletDetailsRepository.save(transactionWalletDetails);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		} 
		
		return userWalletTransaction;
	}
	
	@RequestMapping(value = { "/findByUserId" }, method = RequestMethod.POST)
	public @ResponseBody TransactionWalletDetails findByUserId(@RequestParam("userId") int userId)
	{
		TransactionWalletDetails transactionWalletDetails=new TransactionWalletDetails(); 
		try {
		 
		transactionWalletDetails=transactionWalletDetailsRepository.findByToUserIdAndTransactionType(userId, 0);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		} 
		
		return transactionWalletDetails;
	}
	
	@RequestMapping(value = { "/isLabReferalCorrect"}, method = RequestMethod.POST)
	public @ResponseBody LabDetails isLabReferalCorrect(@RequestParam("referal") String referal) {
	
		LabDetails labDetails=new LabDetails();
		
	try {
	
	
		labDetails=labDetailsRepository.findByString3(referal);
			
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return labDetails;
	}
	@RequestMapping(value = { "/isMedicalReferalCorrect"}, method = RequestMethod.POST)
	public @ResponseBody MedicalDetails isMedicalReferalCorrect(@RequestParam("referal") String referal) {
	
		MedicalDetails medicalDetails=new MedicalDetails();
		
	try {
	
	
		medicalDetails=medicalDetailsRepository.findByString3(referal);
			
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return medicalDetails;
	}
	
@RequestMapping(value = { "/getWalletTransactionDetails"}, method = RequestMethod.POST)
	public @ResponseBody List<GetWalletTransactionDetails> getWalletTransactionDetails(@RequestParam("userId") int userId,@RequestParam("userType") int userType) {
	
		List<GetWalletTransactionDetails> getWalletTransactionDetailsList=new ArrayList<GetWalletTransactionDetails>();
		
	try {
	System.out.println(userId+" And "+userType);
		
	GetWalletTransactionDetails getWalletTransactionDetails=new GetWalletTransactionDetails();
		
		getWalletTransactionDetailsList=getWalletTransactionDetailsRepository.getWalletTransactionDetails(userId,userType);
		
		
		
		System.out.println("wallet details ="+getWalletTransactionDetailsList.toString());
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return getWalletTransactionDetailsList;
	}


@RequestMapping(value = { "/getAllWalletTransactionDetails"}, method = RequestMethod.POST)
public @ResponseBody List<GetWalletTransactionDetails> getAllWalletTransactionDetails(@RequestParam("userId") int userId,@RequestParam("userType") int userType) {

	List<GetWalletTransactionDetails> getWalletTransactionDetailsList=new ArrayList<GetWalletTransactionDetails>();
	
try {
System.out.println(userId+" And "+userType);

	getWalletTransactionDetailsList=getWalletTransactionDetailsRepository.getAllWalletTransactionDetails(userId,userType);
		System.out.println("wallet details ="+getWalletTransactionDetailsList.toString());
}
catch (Exception e) {
	e.printStackTrace();
}
return getWalletTransactionDetailsList;
}



@RequestMapping(value = { "/sendEmailOfReferal"}, method = RequestMethod.POST)
public @ResponseBody Info sendEmailOfReferal(@RequestParam("email") String email,@RequestParam("referal") String referal,@RequestParam("userProfession")int userProfession) {

	Info info=new Info();
	
try {
	if(userProfession==0) {
	sendEMailService.sendMail("REFERAL", "Hi! Get Discount on installation use referal code is "+referal+", Download App now & get 25Rs flat discount."+url+" "+PATIENT_REFERAL_URL, email);
	}else 
	{
		sendEMailService.sendMail("REFERAL", "Hi! Get Discount on installation use referal code is "+referal+", Download App now & get 25Rs flat discount."+ url+" "+DOCTOR_REFERAL_URL, email);	
	}
}
catch (Exception e) {
	e.printStackTrace();
}
return info;
}

@RequestMapping(value = { "/sendPhoneOfReferal"}, method = RequestMethod.POST)
public @ResponseBody Info sendPhoneOfReferal(@RequestParam("phoneNo") String phoneNo,@RequestParam("referal") String referal,@RequestParam("userProfession")int userProfession) {

	Info info=new Info();
	
try {
	if(userProfession==0) {
	sendTextMessageService.sendTextSms("Hi! Get Discount on installation use referal code is "+referal+", Download App now & get 25Rs flat discount. "+url+" "+PATIENT_REFERAL_URL, phoneNo);
	}else 
	{
		sendTextMessageService.sendTextSms("Hi! Get Discount on installation use referal code is "+referal+", Download App now & get 25Rs flat discount. "+url+" "+DOCTOR_REFERAL_URL, phoneNo);	
	}
}
catch (Exception e) {
	e.printStackTrace();
}
return info;
}


@RequestMapping(value = { "/insertWalletMoneyBankTransferRequest" }, method = RequestMethod.POST)
public @ResponseBody BankTransferRequest insertWalletMoneyBankTransferRequest(@RequestBody BankTransferRequest bankTransferRequest)
{
	BankTransferRequest bankTransferRequestRes=new BankTransferRequest();
	try {
		
		bankTransferRequestRes=bankTransferRequestRepository.save(bankTransferRequest);
		
		if(bankTransferRequestRes!=null) {
			
			
			
			WalletDetails walletDetails=walletDetailsRepository.findByWalletId(bankTransferRequestRes.getWalletId());
			
			int walletId=bankTransferRequestRes.getWalletId();
			float updatedWalletAmount=walletDetails.getWalletAmount()-bankTransferRequestRes.getRequestAmount();
			int result=walletDetailsRepository.updateWalletAmount(walletId,updatedWalletAmount);
			
			TransactionWalletDetails transactionWalletDetails=new TransactionWalletDetails();
			transactionWalletDetails.setAmount(bankTransferRequestRes.getRequestAmount());
			transactionWalletDetails.setFromUserId(walletDetails.getUserId());
			transactionWalletDetails.setToUserId(0);
			transactionWalletDetails.setToUserType(0);
			transactionWalletDetails.setTransactionType(4);
			transactionWalletDetails.setUserType(walletDetails.getUserType());
			transactionWalletDetails.setWalletId(walletDetails.getWalletId());
			transactionWalletDetails=transactionWalletDetailsRepository.save(transactionWalletDetails);
			
			
			if(walletDetails.getUserType()==0) {
				
				DoctorDetails doctorDetails=doctorDetailsRepository.findByDoctorId(walletDetails.getUserId());
				sendTextMessageService.sendTextSms(doctorDetails.getfName()+" "+doctorDetails.getlName()+" your request update successfully we are processing on your request money will transfer 24-48 hours.", doctorDetails.getContactNo());
				
			}else if(walletDetails.getUserType()==1) {
				
				PatientDetails patientDetails=patientDetailsRepository.findByPatientId(walletDetails.getUserId());
				sendTextMessageService.sendTextSms(patientDetails.getfName()+" "+patientDetails.getlName()+" your request update successfully we are processing on your request money will transfer 24-48 hours.", patientDetails.getContactNo());
				
			}else if(walletDetails.getUserType()==2) {
				
				LabDetails labDetails=labDetailsRepository.findByLabId(walletDetails.getUserId());
				sendTextMessageService.sendTextSms(labDetails.getLabName()+" your request update successfully we are processing on your request money will transfer 24-48 hours.", labDetails.getContact());
				
				
			}else if(walletDetails.getUserType()==3) {
				
				MedicalDetails medicalDetails=medicalDetailsRepository.findByMedicalId(walletDetails.getUserId());
				sendTextMessageService.sendTextSms(medicalDetails.getMedicalName()+" your request update successfully we are processing on your request money will transfer 24-48 hours.", medicalDetails.getContact());
			}
		
			
		}
		
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
		e.printStackTrace();
	} 
	
	return bankTransferRequestRes;
}
	
	
}

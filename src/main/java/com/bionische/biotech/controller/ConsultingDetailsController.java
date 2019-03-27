package com.bionische.biotech.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.ewallet.model.TransactionWalletDetails;
import com.bionische.biotech.ewallet.model.WalletDetails;
import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.ConsultingDetails;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.GetDocAndLabForRating;
import com.bionische.biotech.model.GetLabAppointment;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.MedicalsInfo;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PrescriptionDetails;
import com.bionische.biotech.repository.AppointmentDetailsRepository;
import com.bionische.biotech.repository.ConsultingDetailsRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.GetLabAppointmentRrepository;
import com.bionische.biotech.repository.GetPrescriptionWithBillRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
import com.bionische.biotech.repository.MedicalsInfoRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.PrescriptionDetailsRepository;
import com.bionische.biotech.repository.PrescriptionToMedicalRepository;
import com.bionische.biotech.repository.SubmitPrescBillRepository;
import com.bionische.biotech.repository.TransactionWalletDetailsRepository;
import com.bionische.biotech.repository.WalletDetailsRepository;
import com.bionische.biotech.service.SendTextMessageService;

@RestController
public class ConsultingDetailsController {

	@Autowired
	ConsultingDetailsRepository consultingDetailsRepository;
	@Autowired
	PrescriptionDetailsRepository prescriptionDetailsRepository;
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	@Autowired
	MedicalsInfoRepository medicalsInfoRepository;
	@Autowired
	MedicalDetailsRepository medicalDetailsRepository;
	@Autowired
	PrescriptionToMedicalRepository prescriptionToMedicalRepository; 
	@Autowired
	SubmitPrescBillRepository submitPrescBillRepository;
	@Autowired
	GetPrescriptionWithBillRepository getPrescriptionWithBillRepository;
	@Autowired
	GetLabAppointmentRrepository getLabAppointmentRrepository;
	@Autowired
	AppointmentDetailsRepository appointmentDetailsRepository;
	
	@Autowired
	WalletDetailsRepository walletDetailsRepository;

	@Autowired
	TransactionWalletDetailsRepository transactionWalletDetailsRepository;
	
	@Autowired
	SendTextMessageService sendTextMessageService;
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	@RequestMapping(value = { "/getConsultingByDoctorIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List getConsultingByDoctorIdAndDate(@RequestParam("doctorId") int doctorId,
			@RequestParam("patientId") int patientId, @RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate)

	{

		List<ConsultingDetails> consultingList = new ArrayList<ConsultingDetails>();
		Info info = new Info();
		try {

			if (doctorId != 0) {
				consultingList = consultingDetailsRepository.getConsultingDetailsByDoctor(doctorId, patientId);

			} else {
				System.out.println("hello");
				/*
				 * startdate=DateConverter.convertToYMD(startdate);
				 * enddate=DateConverter.convertToYMD(enddate);
				 */
				consultingList = consultingDetailsRepository.getConsultingDetailsByDate(startdate, enddate, patientId);

			}

			System.out.println("Consulting List " + consultingList.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return consultingList;
	}

	
	@RequestMapping(value = { "/getLast10ConsultingByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List getConsultingByDoctorIdAndDate(@RequestParam("patientId") int patientId)

	{

		List<ConsultingDetails> consultingList = new ArrayList<ConsultingDetails>();
		 
		try {

			 
				consultingList = consultingDetailsRepository.getLast10ConsultingByPatientId(patientId);

			 

			System.out.println("Consulting List " + consultingList.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return consultingList;
	}

	
	
	
	@RequestMapping(value = { "/getConsultingByDoctorAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List getConsultingByDoctorAndDate(@RequestParam("doctorId") int doctorId,
			@RequestParam("startdate") String startdate, @RequestParam("enddate") String enddate)

	{
		System.out.println("doctorId:" + doctorId);
		System.out.println("startdate:" + startdate);
		System.out.println("enddate:" + enddate);

		List<ConsultingDetails> consultingList = new ArrayList<ConsultingDetails>();
		Info info = new Info();
		try {

			consultingList = consultingDetailsRepository.getConsultingDetailsByDateANDdoctorId(startdate, enddate,
					doctorId);
			System.out.println("Consulting List " + consultingList.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return consultingList;
	}

	@RequestMapping(value = { "/getConsultingByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List getConsultingByDoctorId(@RequestParam("doctorId") int doctorId)

	{
		System.out.println("doctorId:" + doctorId);

		List<ConsultingDetails> consultingList = new ArrayList<ConsultingDetails>();
		Info info = new Info();
		try {

			consultingList = consultingDetailsRepository.getConsultingDetailsByDoctorId(doctorId);
			System.out.println("Consulting List " + consultingList.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return consultingList;
	}

	@RequestMapping(value = { "/getPrescriptionByMeetingId" }, method = RequestMethod.POST)
	public @ResponseBody List<PrescriptionDetails> getPrescriptionByMeetingId(@RequestParam("meetingId") int meetingId)

	{

		List<PrescriptionDetails> PrescriptionDetails = new ArrayList<PrescriptionDetails>();
		Info info = new Info();
		try {

			PrescriptionDetails = prescriptionDetailsRepository.findByMeetingId(meetingId);

			System.out.println("prescription list " + PrescriptionDetails.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return PrescriptionDetails;
	}

	@RequestMapping(value = { "/getDoctorDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List getDoctorDetailsByPatientId(@RequestParam("patientId") int patientId)

	{

		List<DoctorDetails> doctorDetails = new ArrayList<DoctorDetails>();
		Info info = new Info();
		try {
			System.out.println("cammmee");
			doctorDetails = doctorDetailsRepository.getDoctorsByPatientAppointment(patientId);

			System.out.println("prescription list " + doctorDetails.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return doctorDetails;
	}

	// medicals by cityname
	@RequestMapping(value = { "/getMedicalsByCityName" }, method = RequestMethod.POST)
	public @ResponseBody List<MedicalsInfo> getMedicalsByCityName(@RequestParam("cityName") String cityName)

	{

		List<MedicalsInfo> medicalsInfo = new ArrayList<MedicalsInfo>();
		Info info = new Info();
		try {

			medicalsInfo = medicalsInfoRepository.getMedicalsByCityName(cityName);

			System.out.println("medicalsInfo list " + medicalsInfo.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return medicalsInfo;
	}

	// medicals by patientId
	@RequestMapping(value = { "/getMedicalsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<MedicalDetails> getMedicalsByPatientId(@RequestParam("patientId") int patientId)

	{

		List<MedicalDetails> medicalsInfo = new ArrayList<MedicalDetails>();
		System.out.println("patientIdddddddddddddddddddddddddddddddddd:" + patientId);
		try {

			medicalsInfo = medicalDetailsRepository.getMedicalsDetailsByPatient(patientId);

			System.out.println("medicalsInfo list " + medicalsInfo.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return medicalsInfo;
	}

	// medicals by pincode
	@RequestMapping(value = { "/getPharmacyByPincode" }, method = RequestMethod.POST)
	public @ResponseBody List<MedicalDetails> getPharmacyByPincode(@RequestParam("pincode") int pincode,@RequestParam("deliveryStatus") int deliveryStatus)

	{

		List<MedicalDetails> medicalsInfo = new ArrayList<MedicalDetails>();
		System.out.println("pincode:" + pincode);
		try {

			medicalsInfo = medicalDetailsRepository.getPharmacyByPincode(pincode,deliveryStatus);

			System.out.println("medicalsInfo list " + medicalsInfo.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return medicalsInfo;
	}

	@RequestMapping(value = { "/submitMedicalRegProcess" }, method = RequestMethod.POST)
	public @ResponseBody MedicalsInfo submitMedicalRegProcess(@RequestBody MedicalsInfo medicalsInfo) {
		MedicalsInfo medicalsInfoRes = new MedicalsInfo();

		try {
			medicalsInfoRes = medicalsInfoRepository.save(medicalsInfo);
			System.out.println(medicalsInfoRes.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return medicalsInfoRes;
	}

	// patient appointment confirmed by doctor(get doctors)

	@RequestMapping(value = { "/getDoctorsByPatientApp" }, method = RequestMethod.POST)
	public @ResponseBody List getDoctorsByPatientApp(@RequestParam("patientId") int patientId)

	{

		List<DoctorDetails> doctorDetails = new ArrayList<DoctorDetails>();

		try {

			doctorDetails = doctorDetailsRepository.getDoctorsByPatientAppointment(patientId);

			System.out.println("prescription list " + doctorDetails.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return doctorDetails;
	}

	@RequestMapping(value = { "/DoctorsAndLabsForRating" }, method = RequestMethod.POST)
	public @ResponseBody GetDocAndLabForRating DoctorsAndLabsForRating(@RequestParam("familyId") int familyId)

	{

		GetDocAndLabForRating getDocAndLabForRating = new GetDocAndLabForRating();
		Info info = new Info();
		try {
			String date = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)));

			List<ConsultingDetails> consultingDetails = consultingDetailsRepository
					.getConsultingDetailsByRatingStatus(familyId, date);
			List<GetLabAppointment> getReportDetailsForLab = getLabAppointmentRrepository
					.getLabAppointmentForRating(familyId, date);

			getDocAndLabForRating.setDoctorsInfo(consultingDetails);
			getDocAndLabForRating.setLabInfo(getReportDetailsForLab);
			System.out.println("getDocAndLabForRating " + getDocAndLabForRating.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return getDocAndLabForRating;
	}

	@RequestMapping(value = { "/getPatientConsultingHistoryToDoctor" }, method = RequestMethod.POST)
	public @ResponseBody List getPatientConsultingHistoryToDoctor(@RequestParam("patientId") int patientId,
			@RequestParam("doctorId") int doctorId)

	{
		System.out.println("doctorId:" + doctorId);
		System.out.println("patientId:" + patientId);

		List<ConsultingDetails> consultingList = new ArrayList<ConsultingDetails>();
		Info info = new Info();
		try {

			consultingList = consultingDetailsRepository.getConsultingHistoryDetailsByDoctorAndPatientId(patientId,
					doctorId);
			System.out.println("Consulting List " + consultingList.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return consultingList;
	}

	// having prescription
	@RequestMapping(value = { "/getConsultingByDoctorIdAndDatePresc" }, method = RequestMethod.POST)
	public @ResponseBody List getConsultingByDoctorIdAndDatePresc(@RequestParam("doctorId") int doctorId,
			@RequestParam("patientId") int patientId, @RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate)

	{
		System.out.println("patientId:" + patientId);
		System.out.println("doctorId:" + doctorId);
		System.out.println("startdate:" + startdate);
		System.out.println("enddate:" + enddate);

		List<ConsultingDetails> consultingList = new ArrayList<ConsultingDetails>();
		Info info = new Info();
		try {

			if (doctorId != 0) {
				consultingList = consultingDetailsRepository.getConsultingDetailsByDoctorHavePresc(doctorId, patientId);

			} else {
				System.out.println("hello");

				consultingList = consultingDetailsRepository.getConsultingDetailsByDateHavePresc(startdate, enddate,
						patientId);

			}

			System.out.println("Consulting List " + consultingList.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return consultingList;
	}
	
	
	@RequestMapping(value = { "/getLast10ConsultingDeatils" }, method = RequestMethod.POST)
	public @ResponseBody List getLast10ConsultingDeatils(@RequestParam("patientId") int patientId)

	{
		System.out.println("patientId:" + patientId);
	 

		List<ConsultingDetails> consultingList = new ArrayList<ConsultingDetails>();
		Info info = new Info();
		try {

		 

				consultingList = consultingDetailsRepository.getLast10ConsultingDeatils(patientId);

			 

			System.out.println("Consulting List " + consultingList.toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		return consultingList;
	}
	
	@RequestMapping(value = { "/updateAppointmentPayment" }, method = RequestMethod.POST)
	public @ResponseBody Info updateAppointmentPayment(@RequestParam("appointId") int appointId,
			@RequestParam("paymentStatus") int paymentStatus, @RequestParam("amount") float amount,
			@RequestParam("txnId") String txnId, @RequestParam("walletAmount") float walletAmount,
			@RequestParam("consultingAmount") float consultingAmount, @RequestParam("orderId") String orderId,@RequestParam("walletId") int walletId)

	{
		int res=0;
		int isPaymentStatus=0;
		Info info = new Info();
		try {
			if(walletAmount!=0) {
			isPaymentStatus=1;
			 res = appointmentDetailsRepository.updateAppointmentPayment(appointId, paymentStatus, amount, txnId,orderId,walletAmount,consultingAmount,isPaymentStatus);
			}else {
			
			 res = appointmentDetailsRepository.updateAppointmentPayment(appointId, paymentStatus, amount, txnId,orderId,walletAmount,consultingAmount,isPaymentStatus);
			}
			 
			 if (res > 0) {
				
				info.setError(false);
				info.setMessage("Payment update successfully");
				AppointmentDetails appointmentDetails=appointmentDetailsRepository.findByAppointId(appointId);
				if(walletAmount!=0) {
					
				
				float wallAmount=0;
				walletDetailsRepository.updateWalletAmount(walletId, wallAmount);
				TransactionWalletDetails transactionWalletDetails=new TransactionWalletDetails(); 
				
				transactionWalletDetails.setAmount(walletAmount);
				transactionWalletDetails.setFromUserId(appointmentDetails.getPatientId());
				transactionWalletDetails.setToUserId(0);
				transactionWalletDetails.setToUserType(0);
				transactionWalletDetails.setTransactionType(1);
				transactionWalletDetails.setUserType(1);
				transactionWalletDetails.setWalletId(walletId);
				transactionWalletDetails=transactionWalletDetailsRepository.save(transactionWalletDetails);
			
				}
				PatientDetails patientDetails=patientDetailsRepository.findByPatientId(appointmentDetails.getPatientId());
				DoctorDetails doctorDetails=doctorDetailsRepository.findByDoctorId(appointmentDetails.getDoctorId());
				
				sendTextMessageService.sendTextSms("Transaction Id"+appointmentDetails.getTxnId()+" "+patientDetails.getfName()+" "+patientDetails.getlName()+" your consulting payment "+consultingAmount+" rs. successfully done for doctor "+doctorDetails.getfName()+" "+doctorDetails.getlName()+".", patientDetails.getContactNo());
				sendTextMessageService.sendTextSms("Transaction Id"+appointmentDetails.getTxnId()+" Dr. "+doctorDetails.getfName()+" "+doctorDetails.getlName()+"  your consulting payment "+consultingAmount+" rs. successfully paid by "+patientDetails.getfName()+" "+patientDetails.getlName()+".", doctorDetails.getContactNo());
			
			
			} else {
				info.setError(true);
				info.setMessage("Payment update Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			
			info.setError(true);
			info.setMessage("Payment update Failed");
			System.out.println(e.getMessage());
		}
		return info;
	}
	
	@RequestMapping(value = { "/updateAppointmentPaymentByWallet" }, method = RequestMethod.POST)
	public @ResponseBody Info updateAppointmentPaymentByWallet(@RequestParam("appointId") int appointId, @RequestParam("walletAmount") float walletAmount,
			@RequestParam("consultingAmount") float consultingAmount, @RequestParam("orderId") String orderId,@RequestParam("walletId") int walletId)

	{
		Info info = new Info();
		try {
			
			int paymentStatus=1;
			
			int res = appointmentDetailsRepository.updateAppointmentPaymentUsingWallet(appointId,consultingAmount,orderId,paymentStatus);
			if (res > 0) {
				info.setError(false);
				info.setMessage("Payment update successfully");
				AppointmentDetails appointmentDetails=appointmentDetailsRepository.findByAppointId(appointId);
				walletAmount=walletAmount-consultingAmount;
				walletDetailsRepository.updateWalletAmount(walletId, walletAmount);
				TransactionWalletDetails transactionWalletDetails=new TransactionWalletDetails(); 
				transactionWalletDetails.setAmount(consultingAmount);
				transactionWalletDetails.setFromUserId(appointmentDetails.getPatientId());
				transactionWalletDetails.setToUserId(0);
				transactionWalletDetails.setToUserType(0);
				transactionWalletDetails.setTransactionType(1);
				transactionWalletDetails.setUserType(1);
				transactionWalletDetails.setWalletId(walletId);
				transactionWalletDetails=transactionWalletDetailsRepository.save(transactionWalletDetails);
				
				
			} else {
				info.setError(true);
				info.setMessage("Payment update Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMessage("Payment update Failed");
			System.out.println(e.getMessage());
		}
		return info;
	}
}






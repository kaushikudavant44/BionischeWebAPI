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

import com.bionische.biotech.account.model.BrokerageDetails;
import com.bionische.biotech.account.model.DoctorBankAccountInfo;
import com.bionische.biotech.account.model.DoctorConsultingReceipt;
import com.bionische.biotech.account.model.DoctorSuscriptionReceipt;
import com.bionische.biotech.account.model.GetDoctorConsultingPaymentForReceipt;
import com.bionische.biotech.account.model.GetDoctorConsultingReceipt;
import com.bionische.biotech.account.model.GetLabReportPaymentForReceipt;
import com.bionische.biotech.account.model.GetLabReportReceipt;
import com.bionische.biotech.account.model.LabBankAccountInfo;
import com.bionische.biotech.account.model.LabReportReceipt;
import com.bionische.biotech.account.model.LabSuscriptionReceipt;
import com.bionische.biotech.account.model.UpdateReceiptStatusAndReceiptNo;
import com.bionische.biotech.account.repository.BrokerageDetailsRepository;
import com.bionische.biotech.account.repository.DoctorBankAccountInfoRepository;
import com.bionische.biotech.account.repository.DoctorConsultingReceiptRepository;
import com.bionische.biotech.account.repository.DoctorSuscriptionReceiptRepository;
import com.bionische.biotech.account.repository.GetDoctorConsultingPaymentForReceiptRepository;
import com.bionische.biotech.account.repository.GetDoctorConsultingReceiptRepository;
import com.bionische.biotech.account.repository.GetLabReportPaymentForReceiptRepository;
import com.bionische.biotech.account.repository.GetLabReportReceiptRepository;
import com.bionische.biotech.account.repository.LabBankAccountInfoRepository;
import com.bionische.biotech.account.repository.LabReportReceiptRepository;
import com.bionische.biotech.account.repository.LabSuscriptionReceiptRepository;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.AppointmentDetailsRepository;
import com.bionische.biotech.repository.TransactionDetailsRepository;

@RestController
public class AccountingApiController {

	@Autowired
	DoctorBankAccountInfoRepository  doctorBankAccountInfoRepository;
	@Autowired
	DoctorSuscriptionReceiptRepository doctorSuscriptionReceiptRepository;
	@Autowired
	DoctorConsultingReceiptRepository doctorConsultingReceiptRepository;
	@Autowired
	GetDoctorConsultingPaymentForReceiptRepository getDoctorConsultingPaymentForReceiptRepository;
	@Autowired
	BrokerageDetailsRepository brokerageDetailsRepository;
	@Autowired
	AppointmentDetailsRepository appointmentDetailsRepository;
	@Autowired
	GetDoctorConsultingReceiptRepository getDoctorConsultingReceiptRepository;
	@Autowired
	LabBankAccountInfoRepository labBankAccountInfoRepository;
	@Autowired
	LabSuscriptionReceiptRepository labSuscriptionReceiptRepository;
	@Autowired
	GetLabReportPaymentForReceiptRepository getLabReportPaymentForReceiptRepository;
	@Autowired
	LabReportReceiptRepository labReportReceiptRepository;
	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;
	@Autowired
	GetLabReportReceiptRepository getLabReportReceiptRepository;

	@RequestMapping(value = { "/insertBrokerageDetails" }, method = RequestMethod.POST)
	public @ResponseBody BrokerageDetails insertBrokerageDetails(@RequestBody BrokerageDetails brokerageDetails) {
 
		 
		try{
			BrokerageDetails brokerageDetailsRes=brokerageDetailsRepository.save(brokerageDetails);
			return brokerageDetailsRes;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return null;
		}
	
	@RequestMapping(value = { "/getBrokerageDetails" }, method = RequestMethod.GET)
	public @ResponseBody BrokerageDetails getBrokerageDetails() {
 
		DoctorBankAccountInfo doctorBankAccountInfoRes=new DoctorBankAccountInfo();
		try{
			BrokerageDetails brokerageDetailsRes=brokerageDetailsRepository.findByDelStatus(0);
			return brokerageDetailsRes;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return null;
		}
	
	
	
	@RequestMapping(value = { "/insertDoctorBankDetails" }, method = RequestMethod.POST)
	public @ResponseBody DoctorBankAccountInfo insertDoctorBankDetails(@RequestBody DoctorBankAccountInfo doctorBankAccountInfo) {
 
		DoctorBankAccountInfo doctorBankAccountInfoRes=new DoctorBankAccountInfo();
		try{
			doctorBankAccountInfoRes=doctorBankAccountInfoRepository.save(doctorBankAccountInfo);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return doctorBankAccountInfoRes;
		}
	@RequestMapping(value = { "/getDoctorBankDetails" }, method = RequestMethod.POST)
	public @ResponseBody DoctorBankAccountInfo getDoctorBankDetails(@RequestParam("doctorId")int doctorId) {
 
		DoctorBankAccountInfo doctorBankAccountInfoRes=new DoctorBankAccountInfo();
		try{
			doctorBankAccountInfoRes=doctorBankAccountInfoRepository.findByDoctorIdAndDelStatus(doctorId, 0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return doctorBankAccountInfoRes;
		}
	
	
	@RequestMapping(value = { "/insertLabBankDetails" }, method = RequestMethod.POST)
	public @ResponseBody LabBankAccountInfo insertLabBankDetails(@RequestBody LabBankAccountInfo labBankAccountInfo) {
 
		LabBankAccountInfo labBankAccountInfoRes=new LabBankAccountInfo();
		try{
			labBankAccountInfoRes=labBankAccountInfoRepository.save(labBankAccountInfo);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return labBankAccountInfoRes;
		}
	@RequestMapping(value = { "/getLabBankDetails" }, method = RequestMethod.POST)
	public @ResponseBody LabBankAccountInfo getLabBankDetails(@RequestParam("labId")int labId) {
 
		LabBankAccountInfo labBankAccountInfoRes=new LabBankAccountInfo();
		try{
			labBankAccountInfoRes=labBankAccountInfoRepository.findByLabIdAndDelStatus(labId, 0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return labBankAccountInfoRes;
		}
	
	

	
	
	
	@RequestMapping(value = { "/getDoctorSuscriptionReceipt" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorSuscriptionReceipt> getDoctorSuscriptionReceipt(@RequestParam("doctorId")int doctorId) {
 
		List<DoctorSuscriptionReceipt> doctorSuscriptionReceiptList=new ArrayList<DoctorSuscriptionReceipt>();
		try{
			doctorSuscriptionReceiptList=doctorSuscriptionReceiptRepository.getDoctorSuscriptionReceipt(doctorId);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return doctorSuscriptionReceiptList;
		}
	
	
	
	
	@RequestMapping(value = { "/getDoctorConsultingPaymentForReceipt" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDoctorConsultingPaymentForReceipt> getDoctorConsultingPaymentForReceipt(@RequestParam("doctorId") int doctorId, @RequestParam("toDate") String toDate, @RequestParam("fromDate") String fromDate) {
 
		 
		try{
			List<GetDoctorConsultingPaymentForReceipt> getDoctorConsultingPaymentForReceiptList=getDoctorConsultingPaymentForReceiptRepository.getDoctorConsultingPaymentForReceipt(doctorId, fromDate, toDate);
			return getDoctorConsultingPaymentForReceiptList;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return null;
		}
	
	@RequestMapping(value = { "/getLastDateByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody Info getLastDateByDoctorId(@RequestParam("doctorId")int doctorId) {
 
		 Info info=new Info();
		 info.setError(true);
		try{
			 
			String res=doctorConsultingReceiptRepository.getLastDateByDoctorId(doctorId);
			System.out.println(res);
			info.setMessage(res);
			 info.setError(false);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return info;
		}
	@RequestMapping(value = { "/saveDoctorConsultingReceipt" }, method = RequestMethod.POST)
	public @ResponseBody DoctorConsultingReceipt saveDoctorConsultingReceipt(@RequestBody DoctorConsultingReceipt doctorConsultingReceipt) {
 
		 
		try{
			DoctorConsultingReceipt doctorConsultingReceiptRes=doctorConsultingReceiptRepository.save(doctorConsultingReceipt);
			return doctorConsultingReceiptRes;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return null;
		}
	

@RequestMapping(value = { "/updateDoctorConsultingBillStatus" }, method = RequestMethod.POST)
public @ResponseBody Info updateDoctorConsultingBillStatus(@RequestBody UpdateReceiptStatusAndReceiptNo UpdateReceiptStatusAndReceiptNo) {

	 Info info=new Info();
	 info.setError(true);
	try{
		int res=appointmentDetailsRepository.updateConsultingReceiptStatusAndReceiptNo(UpdateReceiptStatusAndReceiptNo.getAppointmentId(),UpdateReceiptStatusAndReceiptNo.getReceiptNo());
		if(res>0) {
			
			info.setError(false);
			info.setMessage("Update successfully");
		 
		
		}
		else
			info.setMessage("Failed to Update");
	}
	catch (Exception e) {
		info.setMessage("Failed to Update");
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return info;
	}

@RequestMapping(value = { "/getDoctorConsultingReceipt" }, method = RequestMethod.POST)
public @ResponseBody List<GetDoctorConsultingReceipt> getDoctorConsultingReceipt(@RequestParam("doctorId") int doctorId, @RequestParam("toDate") String toDate, @RequestParam("fromDate") String fromDate) {

	 
	try{
		List<GetDoctorConsultingReceipt> getDoctorConsultingReceiptList=getDoctorConsultingReceiptRepository.getDoctorConsultingReceipt(fromDate, toDate, doctorId);
		return getDoctorConsultingReceiptList;
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return null;
	}



@RequestMapping(value = { "/getLabSuscriptionReceipt" }, method = RequestMethod.POST)
public @ResponseBody List<LabSuscriptionReceipt> getLabSuscriptionReceipt(@RequestParam("labId")int labId) {

	 
	try{
		List<LabSuscriptionReceipt>	labSuscriptionReceiptList=labSuscriptionReceiptRepository.getLabSuscriptionReceipt(labId);
	return labSuscriptionReceiptList;
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return null;
	}

@RequestMapping(value = { "/getLabReportPaymentForReceipt" }, method = RequestMethod.POST)
public @ResponseBody List<GetLabReportPaymentForReceipt> getLabReportPaymentForReceipt(@RequestParam("labId") int labId, @RequestParam("toDate") String toDate, @RequestParam("fromDate") String fromDate) {

	 
	try{
		List<GetLabReportPaymentForReceipt> getLabConsultingPaymentForReceiptList=getLabReportPaymentForReceiptRepository.getLabConsultingPaymentForReceipt(labId, fromDate, toDate);
		return getLabConsultingPaymentForReceiptList;
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return null;
	}
@RequestMapping(value = { "/getLastDateOfReportByLabId" }, method = RequestMethod.POST)
public @ResponseBody Info getLastDateOfReportByLabId(@RequestParam("labId")int labId) {

	 Info info=new Info();
	 info.setError(true);
	try{
		 
		String res=labReportReceiptRepository.getLastDateOfReportByLabId(labId);
		System.out.println(res);
		info.setMessage(res);
		 info.setError(false);
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return info;
	}


@RequestMapping(value = { "/saveLabReportReceipt" }, method = RequestMethod.POST)
public @ResponseBody LabReportReceipt saveLabReportReceipt(@RequestBody LabReportReceipt labReportReceipt) {

	 
	try{
		LabReportReceipt labReportReceiptRes=labReportReceiptRepository.save(labReportReceipt);
		return labReportReceiptRes;
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return null;
	}

@RequestMapping(value = { "/updateLabReportBillStatus" }, method = RequestMethod.POST)
public @ResponseBody Info updateLabReportBillStatus(@RequestBody UpdateReceiptStatusAndReceiptNo UpdateReceiptStatusAndReceiptNo) {

	 Info info=new Info();
	 info.setError(true);
	try{
		int res=transactionDetailsRepository.updateReportReceiptStatusAndReceiptNo(UpdateReceiptStatusAndReceiptNo.getAppointmentId(),UpdateReceiptStatusAndReceiptNo.getReceiptNo());
		if(res>0) {
			
			info.setError(false);
			info.setMessage("Update successfully");
		 
		
		}
		else
			info.setMessage("Failed to Update");
	}
	catch (Exception e) {
		info.setMessage("Failed to Update");
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return info;
	}



@RequestMapping(value = { "/getLabReportReceipt" }, method = RequestMethod.POST)
public @ResponseBody List<GetLabReportReceipt> getLabReportReceipt(@RequestParam("labId") int labId, @RequestParam("toDate") String toDate, @RequestParam("fromDate") String fromDate) {

	 
	try{
		List<GetLabReportReceipt> getLabReportReceiptList=getLabReportReceiptRepository.getLabReportReceipt(fromDate, toDate, labId);
		return getLabReportReceiptList;
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	return null;
	}



}

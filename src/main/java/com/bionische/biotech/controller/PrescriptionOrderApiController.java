package com.bionische.biotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.Constants;
import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetPrescriptionDetailsForOrder;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.PrescriptionOrderDetails;
import com.bionische.biotech.model.PrescriptionToMedical;
import com.bionische.biotech.model.SelfUploadedPrescriptionToMedical;
import com.bionische.biotech.repository.GetMedicalOrderDetailsRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
import com.bionische.biotech.repository.PrescriptionToMedicalRepository;
import com.bionische.biotech.service.PrescriptionOrderService;
import com.bionische.biotech.service.SendFcmNotificationService;
import com.bionische.biotech.stemcell.repository.SelfUploadedPrescriptionToMedicalRepository;

@RestController
public class PrescriptionOrderApiController {

	@Autowired
	PrescriptionOrderService prescriptionOrderService;
	@Autowired
	MedicalDetailsRepository medicalDetailsRepository;
	@Autowired
	SendFcmNotificationService sendFcmNotificationService;
	
	/*@Autowired
	SelfUploadedPrescriptionToMedicalRepository selfUploadedPrescriptionToMedicalRepository;*/
	
	
	
	@Autowired
	GetMedicalOrderDetailsRepository getMedicalOrderDetailsRepository;
	
	@Autowired
	PrescriptionToMedicalRepository prescriptionToMedicalRepository;
	
	@RequestMapping(value = { "/insertOrderPrescription" }, method = RequestMethod.POST)
	public @ResponseBody PrescriptionToMedical insertOrderPrescription(@RequestBody PrescriptionToMedical prescriptionToMedical) {
  
		try {
			PrescriptionToMedical prescriptionToMedicalRes=prescriptionOrderService.orderPrescription(prescriptionToMedical);
			
			MedicalDetails medicalDetails=medicalDetailsRepository.findByMedicalId(prescriptionToMedicalRes.getMedicalId());
			String message="Customer order medicine. Order Id :- "+prescriptionToMedicalRes.getRequestToMedicalId();
			sendFcmNotificationService.notificationOnWeb(medicalDetails.getToken(), "New Order Received", message, Constants.SITE_URL);
			return prescriptionToMedicalRes;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return null;
	}
	
	
	/*@RequestMapping(value = { "/insertUploadedOrderPrescription" }, method = RequestMethod.POST)
	public @ResponseBody SelfUploadedPrescriptionToMedical insertUploadedOrderPrescription(@RequestBody SelfUploadedPrescriptionToMedical selfUploadedPrescriptionToMedical) {
  
		try {
			SelfUploadedPrescriptionToMedical selfUploadedPrescriptionToMedicalRes=selfUploadedPrescriptionToMedicalRepository.save(selfUploadedPrescriptionToMedical);
			
			MedicalDetails medicalDetails=medicalDetailsRepository.findByMedicalId(selfUploadedPrescriptionToMedicalRes.getMedicalId());
			String message="Customer order medicine. Order Id :- "+selfUploadedPrescriptionToMedicalRes.getMedicalRequestId();
			sendFcmNotificationService.notificationOnWeb(medicalDetails.getToken(), "New Order Received", message, Constants.SITE_URL);
			return selfUploadedPrescriptionToMedicalRes;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return null;
	}*/
	
	@RequestMapping(value = { "/getMedicalOrderDetailsByMedicalIdAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatus(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status) {
  
		
		return prescriptionOrderService.getMedicalOrderDetailsByMedicalIdAndStatus(medicalId, status);
	}
	
	@RequestMapping(value = { "/getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatus(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status) {
  
		
		return getMedicalOrderDetailsRepository.getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatus(medicalId, status);
	}
	
	@RequestMapping(value = { "/getMedicalOrderDetailsByMedicalIdAndStatusAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatusAndDate(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status,@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate) {
  
		
		return prescriptionOrderService.getMedicalOrderDetailsByMedicalIdAndStatusAndDate(medicalId, status, fromDate, toDate);
	}
	
	@RequestMapping(value = { "/getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatusAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatusAndDate(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status,@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate) {
  
		
		return getMedicalOrderDetailsRepository.getUploadedMedicalOrderDetailsByMedicalIdAndStatusAndDate(medicalId, status, fromDate, toDate);
	}
	

	@RequestMapping(value = { "/getPrescriptionDetailsForOrder" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPrescriptionDetailsForOrder> getPrescriptionDetailsForOrder(@RequestParam("requestId")int requestId) {
  
		
		return prescriptionOrderService.getPrescriptionDetailsForOrder(requestId);
	}
	
	
	@RequestMapping(value = { "/updatePrescriptionDetailsForOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePrescriptionDetailsForOrder(@RequestBody List<PrescriptionOrderDetails> prescriptionOrderDetailsList) {
  
		
		return prescriptionOrderService.updatePrescriptionDetailsForOrder(prescriptionOrderDetailsList);
	}
	
	@RequestMapping(value = { "/updateMedicalOrderStatusAndAmount" }, method = RequestMethod.POST)
	public @ResponseBody Info updateMedicalOrderStatusAndAmount(@RequestParam("requestId")int requestId, @RequestParam("status")int status,@RequestParam("totAmount")float totAmount) {
  
		
		return prescriptionOrderService.updateMedicalOrderStatusAndAmount(requestId,status,totAmount);
	}
	
	
	@RequestMapping(value = { "/updateUploadedPrescriptionMedicalOrderStatusAndAmount" }, method = RequestMethod.POST)
	public @ResponseBody int updateUploadedPrescriptionMedicalOrderStatusAndAmount(@RequestParam("requestId")int requestId, @RequestParam("status")int status,@RequestParam("totAmount")float totAmount) {
  
	
		return prescriptionToMedicalRepository.updateMedicalOrderStatusAndAmount(requestId,status,totAmount);
	}
	
	@RequestMapping(value = { "/updateMedicineOrderPaidStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateMedicineOrderPaidStatus(@RequestParam("requestId")int requestId, @RequestParam("paidStatus")int paidStatus) {
  
		
		return prescriptionOrderService.updateMedicineOrderPaidStatus(requestId,paidStatus);
	}
	
	/*@RequestMapping(value = { "/updateUploadedPrescriptionMedicineOrderPaidStatus" }, method = RequestMethod.POST)
	public @ResponseBody int updateUploadedPrescriptionMedicineOrderPaidStatus(@RequestParam("requestId")int requestId, @RequestParam("paidStatus")int paidStatus) {
  
		
		return selfUploadedPrescriptionToMedicalRepository.updateMedicineOrderPaidStatus(requestId,paidStatus);
	}*/
	

	@RequestMapping(value = { "/updateMedicineOrderDeliveredStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateMedicineOrderDeliveredStatus(@RequestParam("requestId")int requestId, @RequestParam("status")int status) {
  
		
		return prescriptionOrderService.updateMedicineOrderDeliveredStatus(requestId,status);
	}
	
	/*@RequestMapping(value = { "/updateUploadedPrescriptionMedicineOrderDeliveredStatus" }, method = RequestMethod.POST)
	public @ResponseBody int updateUploadedPrescriptionMedicineOrderDeliveredStatus(@RequestParam("requestId")int requestId, @RequestParam("status")int status) {
  
		
		return selfUploadedPrescriptionToMedicalRepository.updateMedicineOrderDeliveredStatus(requestId,status);
	}*/
	
	
	@RequestMapping(value = { "/getMedicalCancelledOrderByMedicalIdAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getMedicalCancelledOrderByMedicalIdAndStatus(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status) {
  
		
		return prescriptionOrderService.getMedicalCancelledOrderByMedicalIdAndStatus(medicalId, status);
	}
	
	
	@RequestMapping(value = { "/getPrescriptionMedicalCancelledOrderByMedicalIdAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getPrescriptionMedicalCancelledOrderByMedicalIdAndStatus(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status) {
  
		
		return getMedicalOrderDetailsRepository.getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatus(medicalId, status);
	}
	
	
	
	@RequestMapping(value = { "/updatePatientMedicinePayment" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePatientMedicinePayment(@RequestParam("txnAmt")float txnAmt,@RequestParam("orderId")String orderId,
			@RequestParam("txnId")String txnId,
			@RequestParam("txnStatus")int txnStatus,@RequestParam("requestToMedicalId")int requestToMedicalId,
			@RequestParam("walletAmount")float walletAmount,@RequestParam("walletId")int walletId,
			@RequestParam("totalMedicineAmount")float totalMedicineAmount) {
  
	 
		
		return prescriptionOrderService.updatePatientMedicinePayment(txnAmt, orderId,txnId,txnStatus,requestToMedicalId,walletAmount,walletId,totalMedicineAmount);
	}
	 
}

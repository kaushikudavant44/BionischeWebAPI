package com.bionische.biotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetPrescriptionDetailsForOrder;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PrescriptionOrderDetails;
import com.bionische.biotech.model.PrescriptionToMedical;
import com.bionische.biotech.service.PrescriptionOrderService;

@RestController
public class PrescriptionOrderApiController {

	@Autowired
	PrescriptionOrderService prescriptionOrderService;
 
	
	@RequestMapping(value = { "/insertOrderPrescription" }, method = RequestMethod.POST)
	public @ResponseBody PrescriptionToMedical insertOrderPrescription(@RequestBody PrescriptionToMedical prescriptionToMedical) {
  
		
		return prescriptionOrderService.orderPrescription(prescriptionToMedical);
	}
	
	@RequestMapping(value = { "/getMedicalOrderDetailsByMedicalIdAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatus(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status) {
  
		
		return prescriptionOrderService.getMedicalOrderDetailsByMedicalIdAndStatus(medicalId, status);
	}
	
	@RequestMapping(value = { "/getMedicalOrderDetailsByMedicalIdAndStatusAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatusAndDate(@RequestParam("medicalId")int medicalId,@RequestParam("status")int status,@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate) {
  
		
		return prescriptionOrderService.getMedicalOrderDetailsByMedicalIdAndStatusAndDate(medicalId, status, fromDate, toDate);
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
	
	
	@RequestMapping(value = { "/updateMedicineOrderPaidStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateMedicineOrderPaidStatus(@RequestParam("requestId")int requestId, @RequestParam("paidStatus")int paidStatus) {
  
		
		return prescriptionOrderService.updateMedicineOrderPaidStatus(requestId,paidStatus);
	}
	
	

	@RequestMapping(value = { "/updateMedicineOrderDeliveredStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateMedicineOrderDeliveredStatus(@RequestParam("requestId")int requestId, @RequestParam("status")int status) {
  
		
		return prescriptionOrderService.updateMedicineOrderDeliveredStatus(requestId,status);
	}
	
}

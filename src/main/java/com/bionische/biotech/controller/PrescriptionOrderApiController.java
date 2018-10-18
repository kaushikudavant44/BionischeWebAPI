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

	@RequestMapping(value = { "/getPrescriptionDetailsForOrder" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPrescriptionDetailsForOrder> getPrescriptionDetailsForOrder(@RequestParam("requestId")int requestId) {
  
		
		return prescriptionOrderService.getPrescriptionDetailsForOrder(requestId);
	}
	
}

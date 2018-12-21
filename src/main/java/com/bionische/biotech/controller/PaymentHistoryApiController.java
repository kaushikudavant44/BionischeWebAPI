package com.bionische.biotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.DoctorSubscriptionDetails;
import com.bionische.biotech.model.LabSubscriptionDetails;
import com.bionische.biotech.model.PatientSuscriptionDetails;
import com.bionische.biotech.model.PharmacySubscriptionDetails;
import com.bionische.biotech.paymenthistory.model.GetConsultingPaymentDetails;
import com.bionische.biotech.paymenthistory.model.GetLabPaymentDetails;
import com.bionische.biotech.paymenthistory.model.GetPharmacyPaymentDetails;
import com.bionische.biotech.paymenthistory.repository.GetConsultingPaymentDetailsRepository;
import com.bionische.biotech.paymenthistory.repository.GetLabPaymentDetailsRepository;
import com.bionische.biotech.paymenthistory.repository.GetPharmacyPaymentDetailsRepository;
import com.bionische.biotech.repository.DoctorSubscriptionDetailsRepository;
import com.bionische.biotech.repository.LabSubscriptionDetailsRepository;
import com.bionische.biotech.repository.PatientSuscriptionDetailsRepository;
import com.bionische.biotech.repository.PharmacySubscriptionDetailsRepository;

@RestController
@RequestMapping(value = { "/paymentDetails"})
public class PaymentHistoryApiController {

	@Autowired
	GetConsultingPaymentDetailsRepository getConsultingPaymentDetailsRepository;
	@Autowired
	DoctorSubscriptionDetailsRepository doctorSubscriptionDetailsRepository;
	@Autowired
	PatientSuscriptionDetailsRepository patientSubscriptionDetailsRepository;
	@Autowired
	LabSubscriptionDetailsRepository labSubscriptionDetailsRepository;
	@Autowired
	PharmacySubscriptionDetailsRepository pharmacySubscriptionDetailsRepository;
	@Autowired
	GetLabPaymentDetailsRepository getLabPaymentDetailsRepository;
	@Autowired
	GetPharmacyPaymentDetailsRepository getPharmacyPaymentDetailsRepository;
	
	@RequestMapping(value = { "/getConsultingPaymentDetailsByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetConsultingPaymentDetails> getConsultingPaymentDetailsByDoctorId(@RequestParam("doctorId")int doctorId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return getConsultingPaymentDetailsRepository.getConsultingPaymentDetailsByDoctorId(doctorId, fromDate, toDate);
	}
	
	@RequestMapping(value = { "/getConsultingPaymentDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetConsultingPaymentDetails> getConsultingPaymentDetailsByPatientId(@RequestParam("patientId")int patientId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return getConsultingPaymentDetailsRepository.getConsultingPaymentDetailsByDoctorId(patientId, fromDate, toDate);
	}
	
	
	@RequestMapping(value = { "/getDoctorSubscriptionPaymentDetailsByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorSubscriptionDetails> getDoctorSubscriptionPaymentDetailsByDoctorId(@RequestParam("doctorId")int doctorId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return doctorSubscriptionDetailsRepository.findByCreatedDateBetweenAndTxnStatusNotAndDoctorId(doctorId,fromDate, toDate);
	}
	
	@RequestMapping(value = { "/getPatientSubscriptionPaymentDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody PatientSuscriptionDetails getPatientSubscriptionPaymentDetailsByPatientId(@RequestParam("patientId")int patientId) {
		PatientSuscriptionDetails patientSuscriptionDetails=patientSubscriptionDetailsRepository.findByStatusNotAndPatientId(0, patientId);
		System.out.println("patientSuscriptionDetails  "+patientSuscriptionDetails.toString() );
		return patientSuscriptionDetails;
	}
	
	@RequestMapping(value = { "/getLabSubscriptionPaymentDetailsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<LabSubscriptionDetails> getLabSubscriptionPaymentDetailsByDoctorId(@RequestParam("labId")int labId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return labSubscriptionDetailsRepository.findByPaymentDateBetweenAndTxnStatusNotAndLabId(fromDate,toDate,0, labId);
	}
	
	@RequestMapping(value = { "/getPharmacySubscriptionPaymentDetailsByMedicalId" }, method = RequestMethod.POST)
	public @ResponseBody List<PharmacySubscriptionDetails> getPharmacySubscriptionPaymentDetailsByMedicalId(@RequestParam("medicalId")int medicalId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return pharmacySubscriptionDetailsRepository.findByPaymentDateBetweenAndTxnStatusNotAndMedicalId(fromDate,toDate,0, medicalId);
	}
	
	

	@RequestMapping(value = { "/getLabReportsPaymentDetailsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabPaymentDetails> getLabReportsPaymentDetailsByLabId(@RequestParam("labId")int labId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return getLabPaymentDetailsRepository.getLabPaymentByLabId(fromDate,toDate, labId);
	}
	
	@RequestMapping(value = { "/getLabReportsPaymentDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabPaymentDetails> getLabReportsPaymentDetailsByPatientId(@RequestParam("patientId")int patientId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return getLabPaymentDetailsRepository.getLabPaymentByPatientId(fromDate,toDate, patientId);
	}
	
	@RequestMapping(value = { "/gePharmacysPaymentDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPharmacyPaymentDetails> gePharmacysPaymentDetailsByPatientId(@RequestParam("patientId")int patientId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return getPharmacyPaymentDetailsRepository.getPharmacyPaymentDetailsByPatientId(fromDate, toDate, patientId);
	}
	
	@RequestMapping(value = { "/gePharmacysPaymentDetailsByMedicalId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPharmacyPaymentDetails> gePharmacysPaymentDetailsByMedicalId(@RequestParam("medicalId")int medicalId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
 
		return getPharmacyPaymentDetailsRepository.getPharmacyPaymentDetailsByMedicalId(fromDate, toDate, medicalId);
	}
	
}

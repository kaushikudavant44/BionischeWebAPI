package com.bionische.biotech.service;

import java.util.List;

import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetPrescriptionDetailsForOrder;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PrescriptionOrderDetails;
import com.bionische.biotech.model.PrescriptionToMedical;

public interface PrescriptionOrderService {

	
	PrescriptionToMedical orderPrescription(PrescriptionToMedical prescriptionToMedical);
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatus(int medicalId,int status);
	List<GetPrescriptionDetailsForOrder> getPrescriptionDetailsForOrder(int requestId);
	Info updateMedicalOrderStatusAndAmount(int requestId, int status, float totAmount);
	Info updatePrescriptionDetailsForOrder(List<PrescriptionOrderDetails> prescriptionOrderDetailsList);
	Info updateMedicineOrderPaidStatus(int requestId, int paidStatus);
	Info updateMedicineOrderDeliveredStatus(int requestId, int status);
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatusAndDate(int medicalId, int status,
			String fromDate, String toDate);
	
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByPatientIdAndDate(int patientId, 
			String fromDate, String toDate);
	
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndDate(int medicalId,
			String fromDate, String toDate);
	
	List<GetMedicalOrderDetails> getMedicalCancelledOrderByMedicalIdAndStatus(int medicalId,int status);
	Info updatePatientMedicinePayment(float txnAmt, String orderId, String txnId, int txnStatus,
			int requestToMedicalId);
}

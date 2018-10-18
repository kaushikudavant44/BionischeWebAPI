package com.bionische.biotech.service;

import java.util.List;

import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetPrescriptionDetailsForOrder;
import com.bionische.biotech.model.PrescriptionToMedical;

public interface PrescriptionOrderService {

	
	PrescriptionToMedical orderPrescription(PrescriptionToMedical prescriptionToMedical);
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatus(int medicalId,int status);
	List<GetPrescriptionDetailsForOrder> getPrescriptionDetailsForOrder(int requestId);
}

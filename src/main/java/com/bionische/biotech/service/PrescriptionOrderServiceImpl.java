package com.bionische.biotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bionische.biotech.model.PrescriptionDetails;
import com.bionische.biotech.model.PrescriptionOrderDetails;
import com.bionische.biotech.model.PrescriptionToMedical;
import com.bionische.biotech.repository.PrescriptionDetailsRepository;
import com.bionische.biotech.repository.PrescriptionOrderDetailsRepository;
import com.bionische.biotech.repository.PrescriptionToMedicalRepository;

public class PrescriptionOrderServiceImpl implements PrescriptionOrderService{

	
	@Autowired
	PrescriptionToMedicalRepository prescriptionToMedicalRepository;
	
	@Autowired
	PrescriptionDetailsRepository prescriptionDetailsRepository;
	
	@Autowired
	PrescriptionOrderDetailsRepository prescriptionOrderDetailsRepository;
	
	@Override
	public PrescriptionToMedical orderPrescription(PrescriptionToMedical prescriptionToMedical) {
		// TODO Auto-generated method stub
		
		PrescriptionToMedical prescriptionToMedicalRes=prescriptionToMedicalRepository.save(prescriptionToMedical); 
		
		List<PrescriptionDetails> prescriptionDetailsList=prescriptionDetailsRepository.findByMeetingId(prescriptionToMedicalRes.getMeetId());
		
		for(int i=0;i<prescriptionDetailsList.size();i++)
		{
		PrescriptionOrderDetails prescriptionOrderDetails=new PrescriptionOrderDetails();
		
		prescriptionOrderDetails.setDelStatus(0);
		prescriptionOrderDetails.setPrescriptionId(prescriptionDetailsList.get(i).getPrescriptionId());
		prescriptionOrderDetails.setRequestId(prescriptionToMedicalRes.getRequestToMedicalId());
		prescriptionOrderDetails.setStatus(0);
		prescriptionOrderDetails.setPrice(00);
		
		PrescriptionOrderDetails prescriptionOrderDetailsRes=prescriptionOrderDetailsRepository.save(prescriptionOrderDetails);
		
		}
		
		return prescriptionToMedicalRes;
	}

	
}

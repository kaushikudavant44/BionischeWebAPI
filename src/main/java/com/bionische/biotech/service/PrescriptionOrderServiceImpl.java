package com.bionische.biotech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetPrescriptionDetailsForOrder;
import com.bionische.biotech.model.PrescriptionDetails;
import com.bionische.biotech.model.PrescriptionOrderDetails;
import com.bionische.biotech.model.PrescriptionToMedical;
import com.bionische.biotech.repository.GetMedicalOrderDetailsRepository;
import com.bionische.biotech.repository.GetPrescriptionDetailsForOrderRepository;
import com.bionische.biotech.repository.PrescriptionDetailsRepository;
import com.bionische.biotech.repository.PrescriptionOrderDetailsRepository;
import com.bionische.biotech.repository.PrescriptionToMedicalRepository;

@Service
public class PrescriptionOrderServiceImpl implements PrescriptionOrderService{

	
	@Autowired
	PrescriptionToMedicalRepository prescriptionToMedicalRepository;
	
	@Autowired
	PrescriptionDetailsRepository prescriptionDetailsRepository;
	
	@Autowired
	PrescriptionOrderDetailsRepository prescriptionOrderDetailsRepository;
	
	@Autowired
	GetMedicalOrderDetailsRepository getMedicalOrderDetailsRepository;
	
	@Autowired
	GetPrescriptionDetailsForOrderRepository getPrescriptionDetailsForOrderRepository;
	
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
		prescriptionOrderDetails.setQuantity(Integer.parseInt(prescriptionDetailsList.get(i).getMedicineQuantity()));
		
		PrescriptionOrderDetails prescriptionOrderDetailsRes=prescriptionOrderDetailsRepository.save(prescriptionOrderDetails);
		
		}
		
		return prescriptionToMedicalRes;
	}
	@Override
	public List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatus(int medicalId, int status) {
		List<GetMedicalOrderDetails> getMedicalOrderDetailsList=new ArrayList<GetMedicalOrderDetails>();
try {
	getMedicalOrderDetailsList=getMedicalOrderDetailsRepository.getMedicalOrderDetailsByMedicalIdAndStatus(medicalId, status);
		
}
catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		return getMedicalOrderDetailsList;
	}
	@Override
	public List<GetPrescriptionDetailsForOrder> getPrescriptionDetailsForOrder(int requestId) {
		List<GetPrescriptionDetailsForOrder> getPrescriptionDetailsForOrderList=new ArrayList<GetPrescriptionDetailsForOrder>();
	
		try{
			getPrescriptionDetailsForOrderList=getPrescriptionDetailsForOrderRepository.getPrescriptionDetailsForOrderByRequestIdId(requestId);
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return getPrescriptionDetailsForOrderList;
	}
	
}

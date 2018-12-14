package com.bionische.biotech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.ConstantFileUploadPath;
import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetPatientContactDetailsById;
import com.bionische.biotech.model.GetPrescriptionDetailsForOrder;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PrescriptionDetails;
import com.bionische.biotech.model.PrescriptionOrderDetails;
import com.bionische.biotech.model.PrescriptionToMedical;
import com.bionische.biotech.repository.GetMedicalOrderDetailsRepository;
import com.bionische.biotech.repository.GetPatientContactDetailsByIdRepository;
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
	
	@Autowired
	SendEMailService sendEMailService;
	
	@Autowired
	SendTextMessageService sendTextMessageService;
	
	@Autowired
	GetPatientContactDetailsByIdRepository getPatientContactDetailsByIdRepository;
	
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
		GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(prescriptionToMedical.getPatientId());
		
		sendEMailService.sendMail("Your Order has been successfully Place", getPatientContactDetailsById.getfName()+" "+getPatientContactDetailsById.getlName()+" Your order has been successfully place. \n To view your order "+ConstantFileUploadPath.FRONTEND_URL+"showMyOrder/ \n We will notify you about order status\n Thank you.", getPatientContactDetailsById.getEmail());
		
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
	@Override
	public Info updateMedicalOrderStatusAndAmount(int requestId, int status, float totAmount) {
		Info info=new Info();
		try {
		int res=prescriptionToMedicalRepository.updateMedicalOrderStatusAndAmount(requestId,status,totAmount);
		
		if(res>0)
		{
			int patientId=prescriptionToMedicalRepository.getPatientId(requestId);
			GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(patientId);
			
			sendEMailService.sendMail("Your Order is Ready", getPatientContactDetailsById.getfName()+" "+getPatientContactDetailsById.getlName()+" Your order is Ready. If your order is Home delivery then your order delivered soon. \n Your payable amount is : Rs. "+totAmount+" You can pay your order bill online by click on following link. "+ConstantFileUploadPath.FRONTEND_URL+"showMyOrder/ \n We will notify you about order status\n Thank you.", getPatientContactDetailsById.getEmail());
			
			info.setError(false);
			info.setMessage("Order Status update successfully");
		}
		else {
			 
				info.setError(true);
				info.setMessage("Failed to Update Order Status");
			  
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;
	}
	@Override
	public Info updatePrescriptionDetailsForOrder(List<PrescriptionOrderDetails> prescriptionOrderDetailsList) {
		 Info info=new Info();
		try {
			prescriptionOrderDetailsRepository.saveAll(prescriptionOrderDetailsList);
			info.setError(false);
			info.setMessage("Successfully Updated");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return info;
	}
	@Override
	public Info updateMedicineOrderPaidStatus(int requestId, int paidStatus) {
		Info info=new Info();
try {
		int res=prescriptionToMedicalRepository.updateMedicineOrderPaidStatus(requestId,paidStatus);
		if(res>0)
		{
			info.setError(false);
			info.setMessage("Order Status update successfully");
		}
		else {
			 
				info.setError(true);
				info.setMessage("Failed to Update Order Status");
			 
		}
}catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		return info;
	}
	@Override
	public Info updateMedicineOrderDeliveredStatus(int requestId, int status) {
		Info info=new Info();
		try {
				int res=prescriptionToMedicalRepository.updateMedicineOrderDeliveredStatus(requestId,status);
				if(res>0)
				{
					int patientId=prescriptionToMedicalRepository.getPatientId(requestId);
					GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(patientId);
					
					sendEMailService.sendMail("Your Order is Delivered Successfully", getPatientContactDetailsById.getfName()+" "+getPatientContactDetailsById.getlName()+" Your order is Deliverd successfully. "+ConstantFileUploadPath.FRONTEND_URL+"showMyOrder/ \n  Thank you.", getPatientContactDetailsById.getEmail());
					
					info.setError(false);
					info.setMessage("Order Status update successfully");
				}
				else {
					 
						info.setError(true);
						info.setMessage("Failed to Update Order Status");
					 
				}
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
				return info;
	}
	@Override
	public List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatusAndDate(int medicalId, int status,
			String fromDate, String toDate) {
		List<GetMedicalOrderDetails> getMedicalOrderDetailsList=new ArrayList<GetMedicalOrderDetails>();
		try {
			getMedicalOrderDetailsList=getMedicalOrderDetailsRepository.getMedicalOrderDetailsByMedicalIdAndStatusAndDate(medicalId, status,fromDate,toDate);
				
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
				return getMedicalOrderDetailsList;
	}
	@Override
	public List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndDate(int medicalId, 
			String fromDate, String toDate) {
		List<GetMedicalOrderDetails> getMedicalOrderDetailsList=new ArrayList<GetMedicalOrderDetails>();
		try {
			getMedicalOrderDetailsList=getMedicalOrderDetailsRepository.getMedicalOrderDetailsByMedicalIdAndDate(medicalId, fromDate,toDate);
				
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
				return getMedicalOrderDetailsList;
	}
	@Override
	public List<GetMedicalOrderDetails> getMedicalOrderDetailsByPatientIdAndDate(int patientId,
			String fromDate, String toDate) {
		
		List<GetMedicalOrderDetails> getMedicalOrderDetailsList=new ArrayList<GetMedicalOrderDetails>();
		try {
			getMedicalOrderDetailsList=getMedicalOrderDetailsRepository.getMedicalOrderDetailsByPatientIdAndStatusAndDate(patientId,fromDate,toDate);
				
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
				return getMedicalOrderDetailsList;
				
	}
	
	@Override
	public List<GetMedicalOrderDetails> getMedicalCancelledOrderByMedicalIdAndStatus(int medicalId, int status) {
		List<GetMedicalOrderDetails> getMedicalOrderDetailsList=new ArrayList<GetMedicalOrderDetails>();
try {
	getMedicalOrderDetailsList=getMedicalOrderDetailsRepository.getMedicalCancelledOrderByMedicalIdAndStatus(medicalId, status);
		
}
catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		return getMedicalOrderDetailsList;
	}
	@Override
	public Info updatePatientMedicinePayment(float txnAmt, String orderId, String txnId, int txnStatus,
			int requestToMedicalId) {
		
		Info info=new Info();
		info.setError(true);
		try {
		int res=prescriptionToMedicalRepository.updateMedicinePayment(txnAmt,orderId,txnId,txnStatus,requestToMedicalId);
		if(res>0)
		{
			info.setError(false);
			info.setMessage("Payment update successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Payment update Failed");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMessage("Payment update Failed");
			System.out.println(e.getMessage());
		}
		return info;
	}
}

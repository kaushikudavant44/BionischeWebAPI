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

import com.bionische.biotech.model.ConsultingDetails;
import com.bionische.biotech.model.DoctorPatientMeeting;
import com.bionische.biotech.model.GetCartProducts;
import com.bionische.biotech.model.GetRatingCount;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabNotification;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.LabTestsList;
import com.bionische.biotech.model.PatientAddressList;
import com.bionische.biotech.model.PatientCart;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.repository.ConsultingDetailsRepository;
import com.bionische.biotech.repository.GetCartProductsRepository;
import com.bionische.biotech.repository.PatientAddressListRepository;
import com.bionische.biotech.repository.PatientCartRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.service.DoctorPatientMeetingService;
import com.bionische.biotech.service.PrescriptionOrderService;

@RestController
public class DoctorPatientMeetingApiConrtoller {

	@Autowired
	DoctorPatientMeetingService  doctorPatientMeetingService;
	
	@Autowired
	PatientCartRepository patientCartRepository;
	
	@Autowired
	ConsultingDetailsRepository consultingDetailsRepository;
	
	@Autowired
	PatientAddressListRepository patientAddressListRepository;
	
	@Autowired
	GetCartProductsRepository getCartProductsRepository;
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	
	
	// insert specialization
	@RequestMapping(value = { "/insertDoctoPatientMeeting" }, method = RequestMethod.POST)
	public @ResponseBody Info insertDoctoPatientMeeting(@RequestBody DoctorPatientMeeting doctorPatientMeeting) {
  
		
		return doctorPatientMeetingService.insertDoctorPatientMeeting(doctorPatientMeeting);
	}
	
	
	
	@RequestMapping(value = { "/getAllCartProductsOfPatient"}, method = RequestMethod.POST)
	public @ResponseBody List<GetCartProducts> getAllCartProductsOfPatient(@RequestParam("familyId") int familyId) {
		
		List<GetCartProducts> getCartProductsList = new ArrayList<GetCartProducts>();;
		
		List<PatientDetails> patientDetailsList = patientDetailsRepository.findByFamilyIdAndDelStatus(familyId, 0);
		final ArrayList<GetCartProducts> getCartProductsListFinal = new ArrayList<GetCartProducts>();
		try {
			for(PatientDetails list:patientDetailsList)
			{  			
				getCartProductsList = getCartProductsRepository.getCartProductDetails(list.getPatientId());
				if(getCartProductsList!=null)
				{
				getCartProductsListFinal.addAll(getCartProductsList);
				}
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
					}
	    return  getCartProductsListFinal;
	}
	
	@RequestMapping(value = { "/getPatientCartCount"}, method = RequestMethod.POST)
	public @ResponseBody int getPatientCartCount(@RequestParam("familyId") int familyId) {
		
		List<PatientDetails> patientDetailsList = patientDetailsRepository.findByFamilyIdAndDelStatus(familyId,0);
		
		int count =0;
		for(PatientDetails list:patientDetailsList)
		{  			
			count = count + patientCartRepository.getPatientCartCount(list.getPatientId());
		}
		
	    return  count;
	}
	
	@RequestMapping(value = { "/addToCartAndGetCartCount"}, method = RequestMethod.POST)
	public @ResponseBody int addToCartAndGetCartCount(@RequestBody PatientCart patientCart) {
		
		System.out.println("comig:"+patientCart.toString());
		 int count=0;
		 try {
			  PatientCart patientCartVerify = null;
			  PatientCart patientCartRes = null;
			  patientCartVerify = patientCartRepository.getCartProductByMeetId(patientCart.getPatientId(), patientCart.getMeetId());
			 
			 if(patientCartVerify==null)
			 {
				 List<PatientDetails> patientDetailsList = patientDetailsRepository.getPatientDetailsListByFamilydAndPatientId(patientCart.getPatientId());
				
		      patientCartRes =patientCartRepository.save(patientCart);
		      for(PatientDetails list:patientDetailsList)
				{  			
					count = count + patientCartRepository.getPatientCartCount(list.getPatientId());
				}
			 }
			 else
			 {
				 count = -1;
			 }
		 
		 
			}catch (Exception e) {
				System.out.println(e.getMessage());
						}
		return count;
	}
	
	@RequestMapping(value = { "/addAddressToPatientAddressList" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientAddressList> addAddressToPatientAddressList(@RequestBody PatientAddressList patientAddressList)
	{ 
		Info info=new Info();
		PatientAddressList patientAddressListRes = new PatientAddressList();
		List<PatientAddressList> allPatientAddressList = null;
		
		try {
			
			patientAddressListRes=patientAddressListRepository.save(patientAddressList);
			if(patientAddressListRes!=null)
			{
				allPatientAddressList =  patientAddressListRepository.getPatientAddress(patientAddressList.getPatientId());
				System.out.println("adrressoutput:"+allPatientAddressList.toString());
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
					}		
		return allPatientAddressList;
	}
	
	@RequestMapping(value = { "/getAddressListOfPatient" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientAddressList> getAddressListOfPatient(@RequestParam("patientId") int patientId)
	{ 
				return  patientAddressListRepository.getPatientAddress(patientId);	
	}
	
	@RequestMapping(value = { "/deletePatientAddressList" }, method = RequestMethod.POST)
	public @ResponseBody List<PatientAddressList> deletePatientAddressList(@RequestParam("addressId") int addressId,@RequestParam("patientId") int patientId)
	{ 
		List<PatientAddressList> allPatientAddressList = null;
		int res=0;
		
		try {
			
			res=patientAddressListRepository.deleteAddress(addressId);
			if(res>0)
			{				
					allPatientAddressList =  patientAddressListRepository.getPatientAddress(patientId);
							
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
					}		
		return allPatientAddressList;
	}
	
	@RequestMapping(value = { "/deleteCartItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCartItem(@RequestParam("cartId") int cartId)
	{ 
		Info info = new Info();
		int res=0;
		
		try {
			
			res=patientCartRepository.deleteCartItem(cartId);
			if(res>0)
			{				
				info.setError(false);
				info.setMessage("success");
				
			}
			else {
				info.setError(true);
				info.setMessage("failed");				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
					}		
		return info;
	}
	
}

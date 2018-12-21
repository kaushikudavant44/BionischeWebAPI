package com.bionische.biotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.DoctorSubscriptionDetails;
import com.bionische.biotech.model.GetPromoCodeValidRes;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.DoctorSubscriptionDetailsRepository;
import com.bionische.biotech.repository.GetPromoCodeValidResRepository;

@RestController
@RequestMapping(value = { "/doctorSuscription"})
public class DoctorSuscriptionApiController {

	@Autowired
	DoctorSubscriptionDetailsRepository doctorSubscriptionDetailsRepository;
	@Autowired
	GetPromoCodeValidResRepository getPromoCodeValidResRepository;
	
	@RequestMapping(value = { "/insertDoctorSuscriptionDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info insertDoctorSuscriptionDetails(@RequestBody DoctorSubscriptionDetails doctorSubscriptionDetails)
	{
		Info info=new Info();
		info.setError(true);
		try {
			DoctorSubscriptionDetails doctorSubscriptionDetailsRes=doctorSubscriptionDetailsRepository.save(doctorSubscriptionDetails);
	if(doctorSubscriptionDetailsRes!=null)
	{
		info.setError(false);
		info.setMessage("Doctor Suscription Insert Successfully");
	}
	else
	{
		info.setError(true);
		info.setMessage("Failed to insert Doctor Suscription details");
	}
		 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			info.setError(true);
			info.setMessage("Failed to insert Doctor Suscription details");
		}
		
		return info;
	}
	
	@RequestMapping(value = { "/getDoctorSuscriptionDetailsByDoctorIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody DoctorSubscriptionDetails getDoctorSuscriptionDetailsByDoctorIdAndDate(@RequestParam("doctorId")int doctorId, @RequestParam("date")String date)
	{
		DoctorSubscriptionDetails doctorSubscriptionDetailsRes=new DoctorSubscriptionDetails();
	 
		try {
			  doctorSubscriptionDetailsRes=doctorSubscriptionDetailsRepository.findByPackageExpDateGreaterThanEqualAndDoctorIdAndTxnStatus(date, doctorId,0);
 
		 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			 
		}
		
		return doctorSubscriptionDetailsRes;
	}
	
	
	@RequestMapping(value = { "/checkPromoCodeValidation" }, method = RequestMethod.POST)
	public @ResponseBody GetPromoCodeValidRes checkPromoCodeValidation(@RequestParam("promoCode")String promoCode, @RequestParam("userType")int userType)
	{
		
	  
			GetPromoCodeValidRes getPromoCodeValidRes=getPromoCodeValidResRepository.checkPromoCodeValidation(promoCode, userType);
			//System.out.println("getPromoCodeValidRes "+getPromoCodeValidRes.toString());
			//getPromoCodeValidRes.setError(true);
		 if(getPromoCodeValidRes!=null)
		 {
			 getPromoCodeValidRes.setError(false);
			 getPromoCodeValidRes.setMessage("Promo Code Applied Successfully");
		 }
		 else
		 {
			 getPromoCodeValidRes=new GetPromoCodeValidRes();
			 getPromoCodeValidRes.setError(true);
			 getPromoCodeValidRes.setMessage("Invalid Promo code!");
		 }
		 
		return getPromoCodeValidRes;
	}
	
}

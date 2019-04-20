package com.bionische.biotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.AdvertiseDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.AdvertiseDetailsRepository;

@RestController
@RequestMapping(value = { "/advertisement"})
public class AdvertisementApiController {

	@Autowired
	AdvertiseDetailsRepository advertiseDetailsRepository;
	
	@RequestMapping(value = { "/addNewAds" }, method = RequestMethod.POST)
	public @ResponseBody AdvertiseDetails addNewAds(@RequestBody AdvertiseDetails advertiseDetails) {
		
		return advertiseDetailsRepository.save(advertiseDetails);
	}
	
	@RequestMapping(value = { "/getRandom10Ads" }, method = RequestMethod.GET)
	public @ResponseBody List<AdvertiseDetails> addNewAds() {
		
		return advertiseDetailsRepository.getRandom10Ads();
	}
	
	@RequestMapping(value = { "/getCurrentActiveAdsByUser" }, method = RequestMethod.POST)
	public @ResponseBody List<AdvertiseDetails> getCurrentActiveAdsByUser(@RequestParam("userType")int userType, @RequestParam("adsFrom")int adsFrom) {
		
		return advertiseDetailsRepository.getByAdsFromAndFromTypeAndDelStatus(adsFrom,userType);
	}
	
	@RequestMapping(value = { "/removeAdByAdsId" }, method = RequestMethod.GET)
	public @ResponseBody Info removeAdByAdsId(@RequestParam("adsId")int adsId) {
		
		Info info=new Info();
		info.setError(true);
		int res= advertiseDetailsRepository.updateStatus(1, adsId);
		 if(res>0)
		 {
			 info.setError(false);
			 info.setMessage("Advertise successfully remove");
		 }
		 else {
			 info.setError(true);
			 info.setMessage("Failed to remove Advertise ");
		 }
		 return info;
	}
	

}

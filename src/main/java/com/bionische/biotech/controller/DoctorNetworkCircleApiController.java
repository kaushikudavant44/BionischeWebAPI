package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.DoctorCircle;
import com.bionische.biotech.model.GetDoctorBasicDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.DoctorCircleRepository;
import com.bionische.biotech.repository.GetDoctorBasicDetailsRepository;

@RestController
@RequestMapping(value = { "/doctorCircle"})
public class DoctorNetworkCircleApiController {

	@Autowired
	DoctorCircleRepository doctorCircleRepository;
	@Autowired
	GetDoctorBasicDetailsRepository getDoctorBasicDetailsRepository;
	
	@RequestMapping(value = { "/sendDoctorNetworkCircleRequest" }, method = RequestMethod.POST)
	public @ResponseBody Info sendDoctorNetworkCircleRequest(@RequestBody DoctorCircle doctorCircle)
 
	{
		Info info=new Info();
		info.setError(true);
 try {
		DoctorCircle doctorCircleRes=doctorCircleRepository.getDoctorNetwork(doctorCircle.getFromDoctorId(), doctorCircle.getToDoctorId(),1);
		if(doctorCircleRes==null) {
		doctorCircleRepository.save(doctorCircle);
		info.setError(false);
		info.setMessage("Request sent succefully");
		return info;
		}
 }
		catch (Exception e) {
			// TODO: handle exception
			info.setError(true);
			info.setMessage("Failed to send Request ");
		}
	return info;
	}
	
	@RequestMapping(value = { "/acceptDoctorNetworkCircleRequest" }, method = RequestMethod.POST)
	public @ResponseBody Info acceptDoctorNetworkCircleRequest(@RequestParam("fromId")int fromId,@RequestParam("toId")int toId,@RequestParam("status")int status) 
	{
		Info info=new Info();
		try {
			
	 
		int res= doctorCircleRepository.changeStatus(status, fromId,toId);
		 if(res>0)
		 {
			 info.setError(false);
				info.setMessage("Request accept succefully");
				return info;
		 }
		 else {
			 info.setError(false);
				info.setMessage("record not found");
		 }
	}catch (Exception e) {
		info.setError(true);
		info.setMessage("Failed to accept Request ");
	}
		return info;
	}
	@RequestMapping(value = { "/getDoctorNetworkCircleRequest" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDoctorBasicDetails> getDoctorNetworkCircleRequest(@RequestParam("doctorId")int doctorId) 
	{
		return getDoctorBasicDetailsRepository.getByToDoctorIdAndStatus(doctorId, 0);
	}
	
	@RequestMapping(value = { "/getDoctorForCircle" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDoctorBasicDetails> getDoctorForCircle(@RequestParam("doctorId")int doctorId,@RequestParam("specId")String specId, @RequestParam("cityId")int cityId) 
	{
		 List<String> list = new ArrayList<String>(Arrays.asList(specId.split(",")));
		return getDoctorBasicDetailsRepository.getDoctorForCircle(doctorId, list, cityId);
	}
	
	@RequestMapping(value = { "/getDoctorCircleByDoctorId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDoctorBasicDetails> getDoctorCircleByDoctorId(@RequestParam("doctorId")int doctorId) 
	{
		 
		return getDoctorBasicDetailsRepository.getDoctorCircleByDoctorId(doctorId);
	}
	
}

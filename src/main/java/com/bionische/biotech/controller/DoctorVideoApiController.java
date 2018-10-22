package com.bionische.biotech.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.DoctorAudio;
import com.bionische.biotech.model.DoctorVideo;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.DoctorAudioRepository;
import com.bionische.biotech.repository.DoctorVideoRepository;




@RestController
public class DoctorVideoApiController {

	@Autowired
	DoctorVideoRepository doctorVideoRepository;
	
	@Autowired
	DoctorAudioRepository doctorAudioRepository;
	
	
	@RequestMapping(value = { "/insertDoctorVideo" }, method = RequestMethod.POST)
	public @ResponseBody Info insertDoctorVideo(@RequestBody DoctorVideo doctorVideo)
	{
		//System.out.println("Comming List "+doctorVideo.toString());
		
		DoctorVideo doctorVideoRes=new DoctorVideo();

		Info info =new Info();
		
		try {
			
			doctorVideoRes=doctorVideoRepository.save(doctorVideo);
		
		//System.out.println(doctorVideoRes.toString());
		if(doctorVideoRes!=null)
		{
			info.setError(false);
			info.setMessage("save SuucessFully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem to save details");
		}
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Problem in server to save details");
		}
	
		
	
		return info;
	}
	
	
	@RequestMapping(value = { "/getVideoBypatientIdAndstatus" }, method = RequestMethod.POST)
	public @ResponseBody DoctorVideo getVideoBypatientIdAndstatus(@RequestParam("patientId") int patientId)
	
	{
		
		DoctorVideo doctorVideo = new DoctorVideo();
		Info info=new Info();
		try {
			 
			String toDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String  fromDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis() - 10000));
			
			
			doctorVideo=doctorVideoRepository.getvideoByPatientIdAndStatus(patientId, fromDateTime, toDateTime);
				
			
			//System.out.println("doctorDetails list "+doctorVideo.toString());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return doctorVideo;
	}


	@RequestMapping(value = { "/insertDoctorAudio" }, method = RequestMethod.POST)
	public @ResponseBody Info insertDoctorAudio(@RequestBody DoctorAudio doctorAudio)
	{
		//System.out.println("Comming List "+doctorAudio.toString());
		
		DoctorAudio doctorAudioRes=new DoctorAudio();

		Info info =new Info();
		
		try {
			
			doctorAudioRes=doctorAudioRepository.save(doctorAudio);
		
		//System.out.println(doctorAudioRes.toString());
		if(doctorAudioRes!=null)
		{
			info.setError(false);
			info.setMessage("save SuucessFully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem to save details");
		}
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Problem in server to save details");
		}
	
		
	
		return info;
	}
	
	
	@RequestMapping(value = { "/getAudioBypatientIdAndstatus" }, method = RequestMethod.POST)
	public @ResponseBody DoctorAudio getAudioBypatientIdAndstatus(@RequestParam("patientId") int patientId)
	
	{
		
		DoctorAudio doctorAudio = new DoctorAudio();
		Info info=new Info();
		try {
			 
			String toDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String  fromDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis() - 10000));
			
			
			doctorAudio=doctorAudioRepository.getaudioByPatientIdAndStatus(patientId, fromDateTime, toDateTime);
				
			
			//System.out.println("doctorAudio list "+doctorAudio.toString());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return doctorAudio;
	}
	
	@RequestMapping(value = { "/updateVideoBypatientIdAndstatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateVideoBypatientIdAndstatus(@RequestParam("patientId") int patientId)
	
	{
		
		
		Info info=new Info();
		int Status = 0;
		try {
			 
			
			Status=doctorVideoRepository.updateVideoBypatientId(patientId);
			
			if(Status!=0)
			{
				info.setError(false);
				info.setMessage("Delete Successfully");
			}
			else {
				info.setError(true);
				info.setMessage("Failed to delete");
				} 
			    
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return info;
	}
	
	@RequestMapping(value = { "/updateAudioBypatientIdAndstatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateAudioBypatientIdAndstatus(@RequestParam("patientId") int patientId)
	
	{
		
		
		Info info=new Info();
		int Status = 0;
		try {
			 
			
			Status=doctorAudioRepository.updateAudioBypatientId(patientId);
			
			if(Status!=0)
			{
				info.setError(false);
				info.setMessage("Delete Successfully");
			}
			else {
				info.setError(true);
				info.setMessage("Failed to delete");
				} 
			    
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return info;
	}
	
	 


	
}

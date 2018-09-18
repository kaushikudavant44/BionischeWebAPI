package com.bionische.biotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.DoctorPatientMeeting;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.service.DoctorPatientMeetingService;

@RestController
public class DoctorPatientMeetingApiConrtoller {

	@Autowired
	DoctorPatientMeetingService  doctorPatientMeetingService;
	
	// insert specialization
	@RequestMapping(value = { "/insertDoctoPatientMeeting" }, method = RequestMethod.POST)
	public @ResponseBody Info insertDoctoPatientMeeting(@RequestBody DoctorPatientMeeting doctorPatientMeeting) {
  
		
		return doctorPatientMeetingService.insertDoctorPatientMeeting(doctorPatientMeeting);
	}
	
	
}

package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.DocAvailableTime;
import com.bionische.biotech.model.GetDoctorHospitalDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.DocAvailableTimeRepository;
import com.bionische.biotech.repository.GetDoctorHospitalDetailsRepository;

@RestController
@RequestMapping(value = { "/doctorAvailableTime"})
public class DoctorAvailableTimeApiController {

	@Autowired
	GetDoctorHospitalDetailsRepository getDoctorHospitalDetailsRepository;
	
	@Autowired
	AppointmentTimeRepository appointmentTimeRepository;
	
	@Autowired
	DocAvailableTimeRepository docAvailableTimeRepository;
	
	@RequestMapping(value = { "/getDoctorHospitalDetails"}, method = RequestMethod.POST)
	public  List<GetDoctorHospitalDetails> getDoctorHospitalDetails(@RequestParam("doctorId") int doctorId) {
		 
		return getDoctorHospitalDetailsRepository.getHospitalDetailsByDoctorIdAndDelStatus(doctorId, 0);
	
	
	}
	@RequestMapping(value = { "/getAvailableDocTimeDetailsWithHospital"}, method = RequestMethod.POST)
	public  List<AppointmentTime> getAvailableDocTimeDetailsWithHospital(@RequestParam("doctorId") int doctorId, @RequestParam("date") String date) {
		System.out.println("date "+date+"  doctorId  "+doctorId);
		
		List<AppointmentTime> appointmentTimeList=new ArrayList<AppointmentTime>();
		List<DocAvailableTime> docAvailableTimeList=new ArrayList<DocAvailableTime>();
		try {
			appointmentTimeList=appointmentTimeRepository.findAll();
			docAvailableTimeList=docAvailableTimeRepository.getAvailableTimeByDoctorIdAndDate(doctorId,date);
			
			for(int i=0;i<docAvailableTimeList.size();i++) {
			List<String> availableTimeList = Arrays.asList(docAvailableTimeList.get(i).getAvailableTime().split(","));
			for(int j=0;j<appointmentTimeList.size();j++)
			{
				for(int k=0;k<availableTimeList.size();k++){
				if(appointmentTimeList.get(j).getTimeId()==Integer.parseInt(availableTimeList.get(k)))
				{
					appointmentTimeList.get(j).setInt1(docAvailableTimeList.get(i).getHospitalId());
					appointmentTimeList.get(j).setString1(docAvailableTimeList.get(i).getDate());
				 
				}
			}
			}
			}
		/*	DocAvailableTime
			appointmentTimeRepository
			*/
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return appointmentTimeList;
	}
	
@RequestMapping(value = { "/insertAvailableDocTimeDetails"}, method = RequestMethod.POST)
	public  Info insertAvailableDocTimeDetails(@RequestBody DocAvailableTime docAvailableTime) {
	
	
	Info info=new Info();
	
	DocAvailableTime docAvailableTime1 =new DocAvailableTime();
	
	docAvailableTime1 = docAvailableTimeRepository.getAvailableTimeByDoctorIdAndHospitalId(docAvailableTime.getDoctorId(), docAvailableTime.getDate(), docAvailableTime.getHospitalId());
	if(docAvailableTime1!=null)
	{
		docAvailableTime.setDocAvailableId(docAvailableTime1.getDocAvailableId());
	}
	
	docAvailableTimeRepository.save(docAvailableTime);
	
	
	return info;
}
	

@RequestMapping(value = { "/getClinicAvailabledTimeForAppointment"}, method = RequestMethod.POST)
public  List<AppointmentTime> getClinicAvailabledTimeForAppointment(@RequestParam("doctorId") int doctorId, @RequestParam("date") String date,@RequestParam("hospitalId") int hospitalId) {
	System.out.println("date "+date+"  doctorId  "+doctorId);
	
	List<AppointmentTime> appointmentTimeList=new ArrayList<AppointmentTime>();
	 
	try {
		 
		DocAvailableTime docAvailableTime=docAvailableTimeRepository.findByDoctorIdAndDateAndHospitalId(doctorId,date,hospitalId);
		
		 
		List<String> availableTimeList = Arrays.asList(docAvailableTime.getAvailableTime().split(","));
		 
		appointmentTimeList=appointmentTimeRepository.getClinicAvailabledAppointTime(doctorId, hospitalId, date, availableTimeList, docAvailableTime.getNoOfPatient());
	
		
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	
	
	return appointmentTimeList;
}

}

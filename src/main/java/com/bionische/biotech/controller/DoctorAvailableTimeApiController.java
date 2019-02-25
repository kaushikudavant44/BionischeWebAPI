package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.DocAvailableTime;
import com.bionische.biotech.model.DoctorLeavesDetails;
import com.bionische.biotech.model.FixDoctorAppointSchedule;
import com.bionische.biotech.model.GetDoctorHospitalDetails;
import com.bionische.biotech.model.GetHospitalClinicByDoctorIdAndAvailDate;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.DocAvailableTimeRepository;
import com.bionische.biotech.repository.DoctorLeavesDetailsRepository;
import com.bionische.biotech.repository.FixDoctorAppointScheduleRepository;
import com.bionische.biotech.repository.GetDoctorHospitalDetailsRepository;
import com.bionische.biotech.repository.GetHospitalClinicByDoctorIdAndAvailDateRepository;
import com.bionische.biotech.service.FixDoctorScheduleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = { "/doctorAvailableTime"})
public class DoctorAvailableTimeApiController {

	@Autowired
	GetDoctorHospitalDetailsRepository getDoctorHospitalDetailsRepository;
	
	@Autowired
	AppointmentTimeRepository appointmentTimeRepository;
	
	@Autowired
	DocAvailableTimeRepository docAvailableTimeRepository;
	@Autowired
	FixDoctorAppointScheduleRepository fixDoctorAppointScheduleRepository;
	@Autowired
	FixDoctorScheduleService fixDoctorScheduleService;
	@Autowired
	DoctorLeavesDetailsRepository doctorLeavesDetailsRepository;
	
	@Autowired
	GetHospitalClinicByDoctorIdAndAvailDateRepository getHospitalClinicByDoctorIdAndAvailDateRepository;
	
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
	info.setError(true);
	DocAvailableTime docAvailableTime1 =new DocAvailableTime();
	try {
	docAvailableTime1 = docAvailableTimeRepository.getAvailableTimeByDoctorIdAndHospitalId(docAvailableTime.getDoctorId(), docAvailableTime.getDate(), docAvailableTime.getHospitalId());
	if(docAvailableTime1!=null)
	{
		docAvailableTime.setDocAvailableId(docAvailableTime1.getDocAvailableId());
	}
	
	docAvailableTimeRepository.save(docAvailableTime);
	info.setError(false);
	info.setMessage("save Data AvailableDocTimeDetails");
	}
	catch (Exception e) {
		info.setError(true);
		info.setMessage("failed to save Data");
		// TODO: handle exception
	}
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


@RequestMapping(value = { "/insertDoctorFixSchedule"}, method = RequestMethod.POST)
public  Info insertDoctorFixSchedule(@RequestBody List<FixDoctorAppointSchedule> fixDoctorAppointScheduleList) {
	 
	Info info=new Info();
	info.setError(true);
	try {
		
		
		 for(int i=0;i<fixDoctorAppointScheduleList.size();i++) {
			 if(i==0)
			 fixDoctorAppointScheduleRepository.updateDelStatus(fixDoctorAppointScheduleList.get(i).getDoctorId());
			 fixDoctorScheduleService.insertFixDoctorAppointSchedule(fixDoctorAppointScheduleList.get(i));
		
		info.setError(false);
		info.setMessage("Insert Schedule Successfully");
		
		 }
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
		info.setError(true);
		info.setMessage("failed Insert Schedule");
	}
	
	
	return info;
}


@RequestMapping(value = { "/getDoctorFixSchedule"}, method = RequestMethod.POST)
public  String getDoctorFixSchedule(@RequestParam("doctorId")int doctorId, @RequestParam("clinicId")int clinicId) {
	 
 
	try { 
		FixDoctorAppointSchedule fixDoctorAppointSchedule=fixDoctorAppointScheduleRepository.findByDoctorIdAndClinicIdAndDelStatus(doctorId, clinicId,0);
		 
		return fixDoctorAppointSchedule.getTimeJson();
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
		 
	}
	
	
	return null;
}

@RequestMapping(value = { "/getDoctorAppointmentTimeByDateAndClinicId"}, method = RequestMethod.POST)
public  List<AppointmentTime> getDoctorAppointmentTimeByDateAndClinicId(@RequestParam("doctorId")int doctorId, @RequestParam("hospitalId")int hospitalId, @RequestParam("date")String date) {
	 
 int noOfPatient=0;
 List<String> availableTimeList=new ArrayList<String>();
	try { 
		FixDoctorAppointSchedule fixDoctorAppointSchedule=fixDoctorAppointScheduleRepository.findByDoctorIdAndClinicIdAndDelStatus(doctorId, hospitalId,0);
		noOfPatient=fixDoctorAppointSchedule.getNoOfPatient();
		ObjectMapper mapper = new ObjectMapper();
		
		List<AppointmentTime> appointmentTimeList = mapper.readValue(fixDoctorAppointSchedule.getTimeJson(),new TypeReference<List<AppointmentTime>>() { });
		 
		 for(AppointmentTime appointmentTime :appointmentTimeList)
			 availableTimeList.add(appointmentTime.getTimeId()+"");
	
	try {
		return appointmentTimeRepository.getClinicAvailabledAppointTime(doctorId, hospitalId, date, availableTimeList, noOfPatient);
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
		 
	}
	return null;
}



@RequestMapping(value = { "/getHospitalClinicByDoctorIdWithFixSchedule"}, method = RequestMethod.POST)
public  List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdWithFixSchedule(@RequestParam("doctorId")int doctorId, @RequestParam("clinicId")int clinicId ) {

	
	try {
	List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdAndAvailDateList=getHospitalClinicByDoctorIdAndAvailDateRepository.getHospitalClinicByDoctorIdWithFixSchedule(doctorId, clinicId);
	ObjectMapper mapper = new ObjectMapper();
	for(int ii=0;ii<getHospitalClinicByDoctorIdAndAvailDateList.size();ii++) {
	 List<AppointmentTime> appointmentTimeList = mapper.readValue(getHospitalClinicByDoctorIdAndAvailDateList.get(ii).getAvailableTime(),new TypeReference<List<AppointmentTime>>() { });
	 

		for(int jj=0;jj<appointmentTimeList.size();jj++)
		{
		//	System.out.println("fix Schedule appointmentTime" +appointmentTime.toString());
			getHospitalClinicByDoctorIdAndAvailDateList.get(ii).setFromTime(appointmentTimeList.get(jj).getTime());
			getHospitalClinicByDoctorIdAndAvailDateList.get(ii).setToTime(appointmentTimeList.get(appointmentTimeList.size()-1).getTime());
			break;
		}
	}
	return getHospitalClinicByDoctorIdAndAvailDateList;
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	return null;
}

@RequestMapping(value = { "/getDoctorFixScheduleByDoctorId"}, method = RequestMethod.POST)
public  List<AppointmentTime> getDoctorFixScheduleByDoctorId(@RequestParam("doctorId")int doctorId) {

	
	try {
		List<FixDoctorAppointSchedule> fixDoctorAppointScheduleList=fixDoctorAppointScheduleRepository.findByDoctorIdAndDelStatus(doctorId, 0);
	ObjectMapper mapper = new ObjectMapper();
	 List<AppointmentTime> appointmentTimeList=new  ArrayList<AppointmentTime>();
	for(int ii=0;ii<fixDoctorAppointScheduleList.size();ii++) {
	 List<AppointmentTime> appointmentTimeList1 = mapper.readValue(fixDoctorAppointScheduleList.get(ii).getTimeJson(),new TypeReference<List<AppointmentTime>>() { });
	 
	 appointmentTimeList.addAll(appointmentTimeList1);
	 
		 
	}
	List<Integer> timeIdList=new ArrayList<Integer>();

	for(int i=0;i<appointmentTimeList.size();i++)
	{
		appointmentTimeList.get(i).setInt1(1);
		timeIdList.add(appointmentTimeList.get(i).getTimeId());
	}
	List<AppointmentTime> appointmentTimeList2=appointmentTimeRepository.findByTimeIdNotIn(timeIdList);
	appointmentTimeList.addAll(appointmentTimeList2);
	 Collections.sort(appointmentTimeList, new SortbyTimeId()); 
	return appointmentTimeList;
	}
	catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	return null;
}

class SortbyTimeId implements Comparator<AppointmentTime> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(AppointmentTime a, AppointmentTime b) 
    { 
        return a.timeId - b.timeId; 
    } 
} 

@RequestMapping(value = { "/getDoctorLeaves"}, method = RequestMethod.POST)
public  List<DoctorLeavesDetails> insertDoctorLeave(@RequestParam("date")String date, @RequestParam("doctorId")int doctorId) {
	try {
	return doctorLeavesDetailsRepository.findByDateGreaterThanEqualAndDoctorId(date, doctorId);
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}

@RequestMapping(value = { "/insertDoctorLeave"}, method = RequestMethod.POST)
public  DoctorLeavesDetails insertDoctorLeave(@RequestBody DoctorLeavesDetails doctorLeavesDetails) {
	try {
		if(doctorLeavesDetailsRepository.findByDateAndDoctorId(doctorLeavesDetails.getDate(), doctorLeavesDetails.getDoctorId())==null)
	return doctorLeavesDetailsRepository.save(doctorLeavesDetails);
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}
@RequestMapping(value = { "/deleteDoctorLeave"}, method = RequestMethod.POST)
public  Info deleteDoctorLeave(@RequestParam("leaveId")int leaveId) {
	System.out.println("leaveId "+leaveId);
	Info info=new Info();
	info.setError(true);
	try {
		int res =doctorLeavesDetailsRepository.deleteDoctorLeave(leaveId);
		if(res>0)
		{
			
			info.setError(false);
			info.setMessage("Successfully Deleted");
			return info;
		}
		else {
			info.setError(true);
			info.setMessage("Failed To Deleted");
		}
	}
	catch (Exception e) {
		 
		info.setError(true);
		info.setMessage("Failed To Deleted");
		return info;
	}
	return info;
}
 


}

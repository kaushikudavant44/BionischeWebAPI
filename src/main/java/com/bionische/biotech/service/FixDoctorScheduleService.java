package com.bionische.biotech.service;

import java.util.List;

import com.bionische.biotech.model.FixDoctorAppointSchedule;
import com.bionische.biotech.model.GetDoctorListForAppointment;

public interface FixDoctorScheduleService {

	FixDoctorAppointSchedule insertFixDoctorAppointSchedule(FixDoctorAppointSchedule fixDoctorAppointSchedule);

	List<GetDoctorListForAppointment> getDoctorListForAppointment(int specId, int cityId, List<Integer> doctorIdList, String date);
	 
}

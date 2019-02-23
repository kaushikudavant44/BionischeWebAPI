package com.bionische.biotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.model.FixDoctorAppointSchedule;
import com.bionische.biotech.model.GetDoctorListForAppointment;
import com.bionische.biotech.repository.FixDoctorAppointScheduleRepository;
import com.bionische.biotech.repository.GetDoctorListForAppointmentRepository;
@Service
public class FixDoctorScheduleServiceImpl implements FixDoctorScheduleService {

	@Autowired
	FixDoctorAppointScheduleRepository fixDoctorAppointScheduleRepository;
	@Autowired
	GetDoctorListForAppointmentRepository getDoctorListForAppointmentRepository;

	@Override
	public FixDoctorAppointSchedule insertFixDoctorAppointSchedule(FixDoctorAppointSchedule fixDoctorAppointSchedule) {
		try {
			FixDoctorAppointSchedule fixDoctorAppointScheduleRes = fixDoctorAppointScheduleRepository
					.findByDoctorIdAndClinicId(fixDoctorAppointSchedule.getDoctorId(),
							fixDoctorAppointSchedule.getClinicId());
			if (fixDoctorAppointScheduleRes != null)
				fixDoctorAppointSchedule.setScheduleId(fixDoctorAppointScheduleRes.getScheduleId());
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception

		}

		return fixDoctorAppointScheduleRepository.save(fixDoctorAppointSchedule);
	}





 
public  String getDoctorFixSchedule(int doctorId, int clinicId) {
	 
 
	try { 
		FixDoctorAppointSchedule fixDoctorAppointSchedule=fixDoctorAppointScheduleRepository.findByDoctorIdAndClinicIdAndDelStatus(doctorId, clinicId,0);
		 
		return fixDoctorAppointSchedule.getTimeJson();
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
		 
	}
	 
	
	return null;
}






@Override
public List<GetDoctorListForAppointment> getDoctorListForAppointment(int specId, int cityId, List<Integer> doctoridList, String date) {
	return getDoctorListForAppointmentRepository.getDoctorListForAppointment( specId,  cityId,doctoridList,date);
	 
}

}
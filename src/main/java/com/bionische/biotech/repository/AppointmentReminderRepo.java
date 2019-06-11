package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.AppointmentReminder;

public interface AppointmentReminderRepo extends JpaRepository<AppointmentReminder, Integer> {
	
	
	

@Query(value="SELECT a.appoint_id,  a.date, t.time , CONCAT(d.f_name, ' ', d.l_name ) AS doctor_name , CONCAT(p.f_name,' ', p.l_name ) AS patient_name, p.contact , p.int1,p.string1 ,h.hospital_name , h.contact_no FROM doctor_appointment a, appointment_time t , doctor_details d , hospital_details h , patient_details p WHERE a.status=1 AND a.date =  CURDATE() AND t.time_id IN (:timeIdList) AND a.time=t.time_id AND d.doctor_id =a.doctor_id AND h.hospital_id=a.hospital_id	 AND p.patient_id= a.patient_id",nativeQuery=true)
List<AppointmentReminder> findAppointmentsofPatients(@Param("timeIdList")List<Integer> timeIdList);

	

}

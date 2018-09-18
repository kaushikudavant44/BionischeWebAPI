package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.AppointmentTime;

public interface AppointmentTimeRepository extends JpaRepository<AppointmentTime, Integer>{

	
	@Query(value=" SELECT * from appointment_time t where t.time_id NOT IN(select a.time from doctor_appointment a where a.doctor_id=:doctorId AND a.date=:date)",nativeQuery=true)
	List<AppointmentTime> getAllAppointmentTime(@Param("doctorId")int doctorId, @Param("date")String date);

	List<AppointmentTime> findAll();

	@Query(value="select t.* from  appointment_time t where t.time_id between :fromTime AND :toTime AND t.time_id NOT IN(select l.time from lab_appointments l where l.lab_app_date=:date AND l.del_status=0 AND l.lab_id=:labId)",nativeQuery=true)
	List<AppointmentTime> getLabAppointMent(@Param("labId")int labId, @Param("date")String date, @Param("fromTime")int fromTime, @Param("toTime")int toTime);
	
	@Query(value="select t.* from  appointment_time t where t.time_id between :fromTime AND :toTime", nativeQuery=true)
	List<AppointmentTime> getDoctorAppointMentTime(@Param("fromTime")int fromTime, @Param("toTime")int toTime);
	

 


}

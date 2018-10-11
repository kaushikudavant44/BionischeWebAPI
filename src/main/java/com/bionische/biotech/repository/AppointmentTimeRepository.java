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

	@Query(value="SELECT t.time_id, t.time, t.string1, COALESCE((SELECT d.time FROM doctor_appointment d WHERE d.time=t.time_id"
			+ " AND d.date=:date AND d.doctor_id=:doctorId),0) AS int_1 FROM appointment_time t, doc_available_time dt WHERE t.time_id BETWEEN dt.from_time AND dt.to_time AND dt.doctor_id=:doctorId AND dt.date=:date", nativeQuery=true)
	List<AppointmentTime> getDoctorAppointMentTimeStatus(@Param("doctorId")int doctorId, @Param("date")String date);
	

	@Query(value="SELECT t.time_id, t.time, t.int_1, t.string1 FROM appointment_time t, lab_details l WHERE t.time_id"
			+ " NOT IN (SELECT a.time FROM lab_appointments a WHERE a.lab_id=:labId AND a.lab_app_date=:date) AND"
			+ " t.time_id BETWEEN :fromTime AND :toTime AND l.lab_id=:labId", nativeQuery=true)
	List<AppointmentTime> getLabAppointMentTimeStatus(@Param("labId")int labId, @Param("date")String date, @Param("fromTime")int fromTime, @Param("toTime")int toTime);
	

	AppointmentTime findByTimeId(int time);
	
	@Query(value="select t.* from  appointment_time t where t.time_id between :fromTime AND :toTime AND t.time_id NOT IN(:unavailableTimeList)", nativeQuery=true)
	List<AppointmentTime> getDoctorAppointMentTime(@Param("fromTime")int fromTime, @Param("toTime")int toTime, @Param("unavailableTimeList")List<String> unavailableTimeList);
	

	
	
}

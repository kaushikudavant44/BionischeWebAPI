package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.FixDoctorAppointSchedule;

public interface FixDoctorAppointScheduleRepository extends JpaRepository<FixDoctorAppointSchedule, Integer>{

	FixDoctorAppointSchedule save(FixDoctorAppointSchedule fixDoctorAppointSchedule);
	
	FixDoctorAppointSchedule findByDoctorIdAndClinicId(int doctorId, int clinicId);
	
	@Transactional
	@Modifying
	@Query("UPDATE FixDoctorAppointSchedule  SET delStatus =1 WHERE doctorId=:doctorId")
	 
	int updateDelStatus(@Param("doctorId")int doctorId);

	FixDoctorAppointSchedule findByDoctorIdAndClinicIdAndDelStatus(int doctorId, int clinicId, int delStatus);
	List<FixDoctorAppointSchedule> findByDoctorIdAndDelStatus(int doctorId, int delStatus);

	@Query(value="SELECT CASE WHEN (SELECT COUNT(a.doc_available_time_id) FROM doc_available_time a"
			+ " WHERE a.doctor_id=:doctorId && a.date=:date)THEN 11 WHEN (SELECT COUNT(f.schedule_id) FROM fix_doctor_schedule f"
			+ " WHERE f.doctor_id=:doctorId && f.del_status=0)>0 THEN 1 ELSE 0 END AS time_status", nativeQuery=true)
	int getAvalableTimeStatus(@Param("doctorId")int doctorId, @Param("date")String date);
}

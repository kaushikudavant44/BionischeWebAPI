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
}

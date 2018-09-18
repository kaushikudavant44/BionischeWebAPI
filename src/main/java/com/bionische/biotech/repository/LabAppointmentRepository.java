package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.LabAppointment;

public interface LabAppointmentRepository extends JpaRepository<LabAppointment, Integer>{
	
	@Query(value=" SELECT * from lab_appointments where lab_test_id=:labTestId AND lab_id=:labId AND del_status=0",nativeQuery=true)
	List<LabAppointment> appointmentDetailsOfLab(@Param("labTestId")int testId, @Param("labId")int labTestId);
	
	@Transactional  
	@Modifying
	@Query("UPDATE  LabAppointment l SET l.labAppDate=:date,l.timeId=:time,l.int1=1 WHERE l.labAppId=:appId")
	int editLabAppointmentByLab(@Param("appId")int appId, @Param("date")String date,@Param("time")int time);
	
	@Transactional
	@Modifying
	@Query("UPDATE  LabAppointment l SET l.int1=:status WHERE l.labAppId=:appId")
	int cancelLabAppointmentByLab(@Param("appId")int appId, @Param("status")int status);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabAppointment a SET a.int1 =2  WHERE a.labAppId=:appId")
	int updateLabAppointmentStatus(@Param("appId")int appId);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabAppointment a SET a.int2 =1  WHERE a.labAppId=:appId")
	int updateLabRatingStatus(@Param("appId")int appId);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabAppointment a SET a.int1 =4  WHERE a.labAppId=:appointId")
	int finishedAppointments(@Param("appointId")int appointId);
	
	

}

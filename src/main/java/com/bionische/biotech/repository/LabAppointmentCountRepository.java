package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.LabAppointmentCount;

public interface LabAppointmentCountRepository extends JpaRepository<LabAppointmentCount, Integer>{
	
	@Query(value="SELECT COUNT(a.lab_app_id) AS total_app,(SELECT COUNT(lab_app_id) FROM lab_appointments  WHERE lab_id=:labId AND lab_app_date=:appDate AND int_1=4) AS completed_app FROM lab_appointments a  WHERE a.lab_id=:labId AND a.lab_app_date=:appDate AND (a.int_1!=2 AND a.int_1!=3)" ,nativeQuery=true)
	LabAppointmentCount getAppointmentCount(@Param("labId") int labId,@Param("appDate") String appDate);
}

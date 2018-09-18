package com.bionische.biotech.radiology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.radiology.model.PndtPatientBasicDetails;

public interface PndtPatientBasicDetailsRepository extends JpaRepository<PndtPatientBasicDetails, Long>{

	@Query(value="SELECT DISTINCT pd.patient_id, pn.pndt_id, pd.f_name, pd.l_name, pd.m_name, pd.address, pd.contact, pd.email, dm.doctor_id FROM patient_details pd,doctor_patient_meeting dm, pndt_patient_details pn WHERE dm.doctor_id=:doctorId AND pd.patient_id=pn.patient_id GROUP BY pd.patient_id",nativeQuery=true)
	List<PndtPatientBasicDetails> findByDoctorId(@Param("doctorId")int doctorId);
} 
  
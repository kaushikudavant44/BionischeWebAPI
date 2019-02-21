package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPatientContactDetailsById;

public interface GetPatientContactDetailsByIdRepository extends JpaRepository<GetPatientContactDetailsById, Integer>{

	@Query(value="select patient_id,f_name, l_name, m_name, contact, email from patient_details where patient_id=:patientId",nativeQuery=true)
	GetPatientContactDetailsById getPatientContactDetailsById(@Param("patientId") int patient);
	
	@Query(value="select p.patient_id,p.f_name, p.l_name, p.m_name, p.contact, p.email from patient_details p, doctor_appointment a where p.patient_id=a.patient_id AND appoint_id=:appointId",nativeQuery=true)
	GetPatientContactDetailsById getPatientContactDetailsByDoctorAppointId(@Param("appointId") int appointId);
	
	@Query(value="select p.patient_id,p.f_name, p.l_name, p.m_name, p.contact, p.email from patient_details p, t_lab_appointment_details a where p.patient_id=a.patient_id AND lab_app_id=:appointId",nativeQuery=true)
	GetPatientContactDetailsById getPatientContactDetailsByLabAppointId(@Param("appointId") int appointId);
	
}

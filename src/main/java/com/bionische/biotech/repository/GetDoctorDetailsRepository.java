package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetailsInformation;
import com.bionische.biotech.model.GetDoctorDetails;

public interface GetDoctorDetailsRepository extends JpaRepository<GetDoctorDetails, Integer>{
	
	@Query(value="SELECT a.appoint_id,a.doctor_id,d.f_name,d.l_name,d.m_name,a.hospital_Id FROM doctor_details d, doctor_appointment a WHERE d.doctor_id=a.doctor_id AND appoint_id=:appointId",nativeQuery=true)
	GetDoctorDetails findByAppointmentId(@Param("appointId") int appointId);

}

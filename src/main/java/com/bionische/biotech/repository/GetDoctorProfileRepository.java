package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetDoctorProfile;

public interface GetDoctorProfileRepository extends JpaRepository<GetDoctorProfile, Integer>{

	
	
	@Query(value=" SELECT d.doctor_id, d.f_name, d.l_name, d.m_name,d.gender, d.city_id,"
			+ " c.city_name, d.state_id, d.country_id, d.hospital_id, d.address, d.year_of_exp,"
			+ " d.about_me, d.profile_photo, d.contact, d.email, d.qualification, d.college,"
			+ " d.passing_year,d.signature, d.spec_id, s.spec_type, d.council_reg_no, d.council_name,d.fees , d.int_2, d.del_status"
			+ " from doctor_details d, doctor_specialization s, city c where doctor_id=:doctorId AND d.city_id=c.city_id AND d.spec_id=s.spec_id ",nativeQuery=true)
	GetDoctorProfile getDoctorProfile(@Param("doctorId")int doctorId);

	
	
	
	
}

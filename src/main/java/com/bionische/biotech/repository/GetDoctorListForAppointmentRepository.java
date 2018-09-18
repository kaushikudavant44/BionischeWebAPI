package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetDoctorListForAppointment;

public interface GetDoctorListForAppointmentRepository extends JpaRepository<GetDoctorListForAppointment, Integer>{
	
 
	
		@Query(value="SELECT d.doctor_id, d.f_name, d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me,"
				+" d.profile_photo, d.contact, d.email, d.qualification, d.college, d.passing_year, d.spec_id, d.hospital_id,"
				+" d.council_reg_no, d.council_name, COALESCE((select ((SUM(r.rating)*5)/(count(r.rating_review_id)*5)) from rating_details r,"
				+" doctor_details dd where r.doctor_id=d.doctor_id),0) AS rating, h.hospital_name, h.address as hospital_address from doctor_details d,"
				+" hospital_details h where d.spec_id=:specId AND d.city_id=:cityId AND d.del_status=0 AND d.hospital_id=h.hospital_id",nativeQuery=true)
	List<GetDoctorListForAppointment> getDoctorListForAppointment(@Param("specId")int specId, @Param("cityId")int cityId);
}

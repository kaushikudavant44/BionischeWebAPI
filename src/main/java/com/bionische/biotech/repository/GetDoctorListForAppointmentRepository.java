package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetDoctorListForAppointment;

public interface GetDoctorListForAppointmentRepository extends JpaRepository<GetDoctorListForAppointment, Integer>{
	
 
	
		@Query(value="SELECT d.doctor_id, d.f_name, d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me,d.fees,"
				+" d.profile_photo, d.contact, d.email, d.qualification, d.college, d.passing_year, d.spec_id, s.spec_type,"
				+" d.council_reg_no, d.council_name, COALESCE((select ((SUM(r.rating)*5)/(count(r.rating_review_id)*5)) from rating_details r"
				+"  where r.doctor_id=d.doctor_id),0) AS rating from doctor_details d,"
				+"  doctor_specialization s, doc_available_time a where d.spec_id=:specId AND d.city_id=:cityId AND d.del_status=0 AND d.spec_id=s.spec_id AND d.doctor_id=a.doctor_id AND a.date=:date GROUP BY a.doctor_id ",nativeQuery=true)
	List<GetDoctorListForAppointment> getDoctorListForAppointment(@Param("specId")int specId, @Param("cityId")int cityId, @Param("date")String date);
}

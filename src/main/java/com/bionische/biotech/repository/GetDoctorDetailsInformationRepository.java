package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetailsInformation;

public interface GetDoctorDetailsInformationRepository extends JpaRepository<DoctorDetailsInformation, Integer>{

	@Query(value="SELECT d.doctor_id, d.state_id, d.gender, d.country_id, d.f_name, d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me,d.fees,\r\n" + 
			" d.profile_photo, d.contact, d.email, d.qualification, d.college, d.passing_year, d.spec_id, s.spec_type,\r\n" + 
			" d.council_reg_no, d.council_name,c.city_name, COALESCE((SELECT ((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)) FROM rating_details r\r\n" + 
			" WHERE r.doctor_id=d.doctor_id),0) AS rating FROM doctor_details d,\r\n" + 
			" doctor_specialization s, city c WHERE d.city_id=:cityId AND\r\n" + 
			"  d.del_status=0 AND d.spec_id=s.spec_id AND c.city_id=d.city_id",nativeQuery=true)
	List<DoctorDetailsInformation> findByCityIdAndDelStatus(@Param("cityId")int cityId);
	
	
	@Query(value="SELECT d.doctor_id, d.state_id, d.gender, d.country_id, d.f_name, d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me,d.fees,\r\n" + 
			"d.profile_photo, d.contact, d.email, d.qualification, d.college, d.passing_year, d.spec_id, s.spec_type,\r\n" + 
			"d.council_reg_no, d.council_name, c.city_name, COALESCE((SELECT ((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)) FROM rating_details r\r\n" + 
			"WHERE r.doctor_id=d.doctor_id),0) AS rating FROM doctor_details d,\r\n" + 
			"doctor_specialization s, city c WHERE d.city_id=:cityId AND s.spec_id=:specId AND\r\n" + 
			"d.del_status=0 AND d.spec_id=s.spec_id AND c.city_id=d.city_id",nativeQuery=true)
	List<DoctorDetailsInformation> findBySpecIdAndCityIdAndDelStatus(@Param("specId")int specId,@Param("cityId")int cityId);
}

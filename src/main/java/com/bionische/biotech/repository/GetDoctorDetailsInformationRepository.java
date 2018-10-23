package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetailsInformation;

public interface GetDoctorDetailsInformationRepository extends JpaRepository<DoctorDetailsInformation, Integer>{

	@Query(value="SELECT d.doctor_id, d.state_id, d.country_id, d.f_name, d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me,d.fees,d.gender,\r\n" + 
			"d.profile_photo, d.contact, d.email, d.qualification, d.college, d.passing_year, d.spec_id, s.spec_type, dh.hospital_id, h.hospital_name,h.contact_no,\r\n" + 
			"h.email_id,h.address AS hospital_address, d.council_reg_no, d.council_name, c.city_name, COALESCE((SELECT ((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)) FROM rating_details r\r\n" + 
			"WHERE r.doctor_id=d.doctor_id),0) AS rating, COALESCE((SELECT a.available_time FROM doc_available_time a\r\n" + 
			"WHERE d.doctor_id=a.doctor_id AND a.date=CURDATE() AND h.hospital_id=a.hospital_id),0) AS available_time FROM doctor_details d, hospital_details h,\r\n" + 
			"doctor_specialization s, city c, doctor_hospital_details dh WHERE d.city_id=:cityId AND\r\n" + 
			"d.del_status=0 AND d.spec_id=s.spec_id AND c.city_id=d.city_id AND dh.doctor_id=d.doctor_id AND dh.del_status=0 AND dh.hospital_id=h.hospital_id GROUP BY d.doctor_id",nativeQuery=true)
	List<DoctorDetailsInformation> findByCityIdAndDelStatus(@Param("cityId")int cityId);
	
	
	@Query(value="SELECT d.doctor_id, d.state_id, d.country_id, d.f_name, d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me,d.fees,d.gender,\r\n" + 
			"d.profile_photo, d.contact, d.email, d.qualification, d.college, d.passing_year, d.spec_id, s.spec_type, dh.hospital_id, h.hospital_name,h.contact_no,\r\n" + 
			"h.email_id,h.address AS hospital_address, d.council_reg_no, d.council_name, c.city_name, COALESCE((SELECT ((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)) FROM rating_details r\r\n" + 
			"WHERE r.doctor_id=d.doctor_id),0) AS rating, COALESCE((SELECT a.available_time FROM doc_available_time a\r\n" + 
			"WHERE d.doctor_id=a.doctor_id AND a.date=CURDATE() AND h.hospital_id=a.hospital_id),0) AS available_time FROM doctor_details d, hospital_details h,\r\n" + 
			"doctor_specialization s, city c, doctor_hospital_details dh WHERE d.city_id=:cityId AND s.spec_id=:specId AND\r\n" + 
			"d.del_status=0 AND d.spec_id=s.spec_id AND c.city_id=d.city_id AND dh.doctor_id=d.doctor_id AND dh.del_status=0 AND dh.hospital_id=h.hospital_id GROUP BY d.doctor_id",nativeQuery=true)
	List<DoctorDetailsInformation> findBySpecIdAndCityIdAndDelStatus(@Param("specId")int specId,@Param("cityId")int cityId);
}

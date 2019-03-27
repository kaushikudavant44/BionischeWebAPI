package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetDoctorBasicDetails;

public interface GetDoctorBasicDetailsRepository extends JpaRepository<GetDoctorBasicDetails, Integer>{

	
	 
	@Query(value="select d.doctor_id, CONCAT(d.f_name,' ',d.l_name) as doctor_name, d.qualification, d.spec_id, "
			+ "d.gender, d.address, d.year_of_exp, d.about_me, d.profile_photo, d.contact, d.email, dc.status,"
			+ "s.spec_type, c.city_name from doctor_details d, t_doctor_circle dc, city c, doctor_specialization s where d.city_id=c.city_id AND"
			+ " s.spec_id=d.spec_id AND d.doctor_id=dc.from_doctor_id AND dc.to_doctor_id=:toDoctorId AND dc.status=:status",nativeQuery=true)
	List<GetDoctorBasicDetails> getByToDoctorIdAndStatus(@Param("toDoctorId")int toDoctorId,@Param("status")int status);
	
	
	@Query(value="SELECT d.doctor_id, CONCAT(d.f_name,' ',d.l_name) AS doctor_name, d.qualification, d.spec_id, " + 
			"d.gender, d.address, d.year_of_exp, d.about_me, d.profile_photo, d.contact, d.email, " + 
			"s.spec_type, c.city_name, " + 
			"COALESCE( (SELECT t.status FROM t_doctor_circle t WHERE t.to_doctor_id=d.doctor_id AND t.from_doctor_id=:doctorId), " + 
			"(SELECT  " + 
			"CASE " + 
			"WHEN dc.status=0 THEN 3 " + 
			"WHEN dc.status=1 THEN 4 " + 
			"WHEN dc.status=2 THEN 5 " + 
			"END  FROM t_doctor_circle dc WHERE dc.from_doctor_id=d.doctor_id AND dc.to_doctor_id=:doctorId) " + 
			",6)AS status " + 
			"FROM doctor_details d,   city c, doctor_specialization s WHERE d.city_id=c.city_id AND " + 
			"s.spec_id=d.spec_id  AND d.doctor_id!=:doctorId AND d.del_status=0 AND d.city_id=:cityId AND d.spec_id IN(:specId)",nativeQuery=true)
	List<GetDoctorBasicDetails> getDoctorForCircle(@Param("doctorId")int toDoctorId, @Param("specId")List<String> specId, @Param("cityId")int cityId);
	
	@Query(value="select d.doctor_id, CONCAT(d.f_name,' ',d.l_name) as doctor_name, d.qualification, d.spec_id, "
			+ "d.gender, d.address, d.year_of_exp, d.about_me, d.profile_photo, d.contact, d.email, dc.status,"
			+ "s.spec_type, c.city_name from doctor_details d, t_doctor_circle dc, city c, doctor_specialization s where d.city_id=c.city_id AND"
			+ " s.spec_id=d.spec_id AND "
			+ "((dc.to_doctor_id=:doctorId AND d.doctor_id=dc.from_doctor_id  AND (dc.status=0 || dc.status=1)) || (  dc.from_doctor_id=:doctorId AND d.doctor_id=dc.to_doctor_id AND dc.status=1))",nativeQuery=true)
	List<GetDoctorBasicDetails> getDoctorCircleByDoctorId(@Param("doctorId")int doctorId);
	
}

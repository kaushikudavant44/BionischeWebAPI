package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetDoctorListForAppointment;

public interface GetDoctorListForAppointmentRepository extends JpaRepository<GetDoctorListForAppointment, Integer>{
	
 
	
		@Query(value="SELECT d.doctor_id, d.f_name, d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me,"
				+ "d.fees, a.hospital_id, h.hospital_name, h.address as hospital_address, h.lat, h.longitude, h.contact_no as hospital_contact_no, c.city_name, a.available_time,"
				+" d.profile_photo, d.contact, d.email, d.qualification, d.college, d.passing_year, d.spec_id, s.spec_type,"
				+" d.council_reg_no, d.council_name, COALESCE((SELECT CAST(ROUND(((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)),1) AS DECIMAL(10,1)) from rating_details r"
				+"  where r.doctor_id=d.doctor_id),0) AS rating from doctor_details d, hospital_details h, city c, "
				+"  doctor_specialization s, doc_available_time a, t_doctor_subscription_details ds where d.spec_id=:specId AND d.city_id=:cityId AND d.del_status=0 AND"
				+ " d.spec_id=s.spec_id AND d.doctor_id=a.doctor_id AND a.date=:date AND h.hospital_id=a.hospital_id AND c.city_id=h.cityid AND d.doctor_id=ds.doctor_id"
				+ " AND ds.package_exp_date>=NOW() AND ds.txn_status=1 AND d.doctor_id NOT IN(SELECT l.doctor_id FROM t_doctor_leaves l  WHERE d.doctor_id=l.doctor_id AND l.date=:date) GROUP BY a.doctor_id ",nativeQuery=true)
	List<GetDoctorListForAppointment> getDoctorListForAppointment(@Param("specId")int specId, @Param("cityId")int cityId, @Param("date")String date);

		@Query(value="SELECT d.doctor_id, d.f_name,d.l_name, d.m_name, d.city_id, d.address, d.year_of_exp, d.about_me, d.fees, a.hospital_id,"
				+ " h.hospital_name, h.address AS hospital_address, h.lat,  h.longitude, h.contact_no AS hospital_contact_no, c.city_name,"
				+ " a.time_json AS available_time, d.profile_photo, d.contact, d.email,  d.qualification, d.college, d.passing_year, d.spec_id,"
				+ " s.spec_type, d.council_reg_no, d.council_name, COALESCE((SELECT CAST(ROUND(((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)),1) AS DECIMAL(10,1))  FROM rating_details r"
				+ " WHERE r.doctor_id=d.doctor_id), 0) AS rating    FROM  doctor_details d, hospital_details h, city c, doctor_specialization s,"
				+ " fix_doctor_schedule a, t_doctor_subscription_details ds  WHERE d.spec_id=:specId AND d.city_id=:cityId  AND d.del_status=0  AND"
				+ " d.spec_id=s.spec_id  AND d.doctor_id=a.doctor_id  AND h.hospital_id=a.hospital_id AND c.city_id=h.cityid AND"
				+ " d.doctor_id=ds.doctor_id AND ds.package_exp_date>=NOW() AND ds.txn_status=1   AND a.del_status=0 AND a.doctor_id NOT IN (:doctoridList) AND d.doctor_id NOT IN(SELECT l.doctor_id FROM t_doctor_leaves l  WHERE d.doctor_id=l.doctor_id AND l.date=:date) GROUP BY a.doctor_id",nativeQuery=true) 
		List<GetDoctorListForAppointment> getDoctorListForAppointment(@Param("specId")int specId, @Param("cityId")int cityId, @Param("doctoridList")List<Integer> doctoridList, @Param("date")String date);
}
 
package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetHospitalClinicByDoctorIdAndAvailDate;

public interface GetHospitalClinicByDoctorIdAndAvailDateRepository extends JpaRepository<GetHospitalClinicByDoctorIdAndAvailDate, Integer>{

	@Query(value="select h.hospital_id, h.hospital_name, h.type, h.contact_no, h.email_id, h.address, h.cityid,c.city_name, h.lat, h.longitude, dt.available_time"
			+ " from hospital_details h, city c, doctor_hospital_details dh, doc_available_time dt where dh.doctor_id=:doctorId AND dh.hospital_id=h.hospital_id AND "
			+ "h.del_status=0 AND dt.doctor_id=:doctorId AND dt.date=:date AND dt.hospital_id=h.hospital_id AND c.city_id=h.cityid",nativeQuery=true)
	List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdAndAvailDate(@Param("doctorId") int doctorId, @Param("date") String date);
	
	
	@Query(value="SELECT h.hospital_id, h.hospital_name, h.type, h.contact_no, h.email_id, h.address, h.cityid,c.city_name, h.lat, h.longitude,\r\n" + 
			"COALESCE((SELECT a.available_time FROM doc_available_time a\r\n" + 
			"WHERE dh.doctor_id=a.doctor_id AND a.date=CURDATE() AND h.hospital_id=a.hospital_id),0) AS available_time\r\n" + 
			"FROM hospital_details h, city c, doctor_hospital_details dh WHERE dh.doctor_id=:doctorId AND dh.hospital_id=h.hospital_id AND \r\n" + 
			"h.del_status=0 AND c.city_id=h.cityid AND dh.del_status=0;",nativeQuery=true)
	List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorId(@Param("doctorId") int doctorId);
	
	@Query(value="SELECT h.hospital_id, h.hospital_name, h.type, h.contact_no, h.email_id, h.address, h.cityid,c.city_name, h.lat, h.longitude, dt.time_json as available_time " + 
			"FROM hospital_details h, city c, doctor_hospital_details dh, fix_doctor_schedule dt WHERE dh.doctor_id=:doctorId AND dh.hospital_id=h.hospital_id AND " + 
			"h.del_status=0 AND dt.doctor_id=:doctorId AND  dt.hospital_id=h.hospital_id AND c.city_id=h.cityid AND dt.hospital_id!=:clinicId",nativeQuery=true)
	List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdWithFixSchedule(@Param("doctorId") int doctorId, @Param("clinicId") int clinicId);
}

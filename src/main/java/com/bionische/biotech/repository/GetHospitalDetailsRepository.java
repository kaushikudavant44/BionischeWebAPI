package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetHospitalDetails;
import com.bionische.biotech.model.HospitalDetails;

public interface GetHospitalDetailsRepository extends JpaRepository<GetHospitalDetails, Integer>{

	@Query(value="SELECT d.id,h.type, d.doctor_id, d.hospital_id, h.hospital_name, h.cityid, c.city_name, h.state_id, s.state_name, h.email_id, h.address, h.contact_no\r\n" + 
			"FROM doctor_hospital_details d, hospital_details h, city c, state s\r\n" + 
			"WHERE doctor_id=:doctorId AND d.hospital_id=h.hospital_id AND h.cityid=c.city_id AND h.state_id=s.state_id;",nativeQuery=true)
	List<GetHospitalDetails> findHospitalByDoctorId(@Param("doctorId")int doctorId);

	@Query(value="SELECT d.id, h.type, d.doctor_id, h.hospital_name, h.contact_no, h.email_id, \r\n" + 
			"h.country_id,h.state_id,h.address,h.cityid,h.hospital_id,c.city_name,s.state_name \r\n" + 
			"FROM doctor_hospital_details d, hospital_details h, city c, state s WHERE h.hospital_id=:hospitalId AND h.cityid=c.city_id AND h.state_id=s.state_id;",nativeQuery=true)
	GetHospitalDetails findByHospitalId(@Param("hospitalId")int hospitalId);
	
	
	@Query(value="SELECT d.id, h.type, d.doctor_id, h.hospital_name, h.contact_no, h.email_id, \r\n" + 
			"h.country_id,h.state_id,h.address,h.cityid,h.hospital_id,c.city_name,s.state_name \r\n" + 
			"FROM doctor_hospital_details d, hospital_details h, city c, state s WHERE h.type=:type"
			+ " AND h.cityid=c.city_id AND h.state_id=s.state_id;",nativeQuery=true)
	List<GetHospitalDetails> findHospitalByType(@Param("type")int type);

}

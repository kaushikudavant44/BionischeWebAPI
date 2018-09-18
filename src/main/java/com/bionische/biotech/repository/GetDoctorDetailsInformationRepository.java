package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetailsInformation;

public interface GetDoctorDetailsInformationRepository extends JpaRepository<DoctorDetailsInformation, Integer>{

	@Query(value="SELECT * ,s.spec_type, c.city_name, COALESCE((SELECT ((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)) FROM rating_details r, "
			+ "doctor_details dd WHERE r.doctor_id=d.doctor_id),0) AS rating, h.hospital_name, h.address AS hospital_address FROM"
			+ " doctor_details d,hospital_details h , doctor_specialization s, city c WHERE d.city_id=:cityId AND c.city_id=d.city_id AND d.del_status=0 AND d.hospital_id=h.hospital_id AND d.spec_id=s.spec_id",nativeQuery=true)
	List<DoctorDetailsInformation> findByCityIdAndDelStatus(@Param("cityId")int cityId);
	
	
	@Query(value="SELECT * ,s.spec_type, c.city_name, COALESCE((SELECT ((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)) FROM rating_details r, "
			+ "doctor_details dd WHERE r.doctor_id=d.doctor_id),0) AS rating, h.hospital_name, h.address AS hospital_address FROM"
			+ " doctor_details d,hospital_details h , doctor_specialization s, city c WHERE s.spec_id=:specId AND d.city_id=:cityId AND c.city_id=d.city_id AND d.del_status=0 AND d.hospital_id=h.hospital_id AND d.spec_id=s.spec_id",nativeQuery=true)
	List<DoctorDetailsInformation> findBySpecIdAndCityIdAndDelStatus(@Param("specId")int specId,@Param("cityId")int cityId);
}

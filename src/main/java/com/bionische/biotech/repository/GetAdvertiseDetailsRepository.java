package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetAdvertiseDetails;

public interface GetAdvertiseDetailsRepository extends JpaRepository<GetAdvertiseDetails, Integer>{

	
	@Query(value=" SELECT a.*, CASE "
			+ "WHEN a.from_type=0 THEN (SELECT CONCAT(f_name,' ',l_name) FROM doctor_details WHERE doctor_id=a.ads_from)"
			+ " WHEN a.from_type=2 THEN (SELECT lab_name FROM lab_details WHERE lab_id=a.ads_from)"
			+ " WHEN a.from_type=3 THEN (SELECT medical_name FROM medical_details WHERE medical_id=a.ads_from) END AS from_name"
			+ " FROM t_advertise_details a WHERE a.del_status=:delStatus  AND a.from_type=:userType",nativeQuery=true)
	List<GetAdvertiseDetails> getByFromTypeAndDelStatus(  @Param("userType")int userType,@Param("delStatus")int delStatus);

}

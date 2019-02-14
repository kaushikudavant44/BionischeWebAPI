package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.ewallet.model.ReferalDetails;

public interface ReferalDetailsRepository extends JpaRepository<ReferalDetails, Integer>{

	@Query(value="SELECT doctor_id AS user_id, 0 AS user_type FROM doctor_details WHERE refferal_code =  :referal " + 
			" UNION " + 
			"SELECT patient_id AS user_id, 1 AS user_type FROM patient_details WHERE refferal_code =  :referal " + 
			"  UNION " + 
			"SELECT lab_id AS user_id, 2 AS user_type FROM lab_details WHERE string3 =  :referal " + 
			"UNION " + 
			"SELECT medical_id AS user_id, 3 AS user_type FROM medical_details WHERE string3 = :referal",nativeQuery=true)
	ReferalDetails findByReferal(@Param("referal")String referal);

	
}

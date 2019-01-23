package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.PharmacyDayOrderDetails;


public interface PharmacyDayOrderDetailsRepository extends JpaRepository<PharmacyDayOrderDetails, Integer>{
	
	@Query(value="SELECT COUNT(medical_request_id) AS order_count,SUM( CASE WHEN int_1=1 THEN total_amt ELSE 0 END) AS collection,COUNT( CASE WHEN STATUS=4 THEN medical_request_id END) AS delivered FROM prescription_to_medical WHERE medical_id=:medicald AND order_date LIKE ':appDate%'" ,nativeQuery=true)
	PharmacyDayOrderDetails getPharmacyOrderDetails(@Param("medicald") int medicald,@Param("appDate") String appDate);
}

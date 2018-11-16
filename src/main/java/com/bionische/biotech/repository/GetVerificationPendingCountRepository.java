package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.biotech.model.GetVerificationPendingCount;

public interface GetVerificationPendingCountRepository extends JpaRepository<GetVerificationPendingCount, Integer>{

	@Query(value="SELECT 1 as id, (SELECT count(c.cetrificate_id) from doctor_certificate_details c where c.del_status=0)as doctor_count, 1 as lab_count, 1 as pharmacy_count",nativeQuery=true)
	GetVerificationPendingCount getVerificationCount();
	
}

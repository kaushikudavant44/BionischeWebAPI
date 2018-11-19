package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.PharmacyCertificateDetails;

public interface PharmacyCertificateDetailsRepository extends JpaRepository<PharmacyCertificateDetails, Integer>{

	
	PharmacyCertificateDetails save(PharmacyCertificateDetails pharmacyCertificateDetails);
	
	PharmacyCertificateDetails findByMedicalIdAndDelStatus(int medicalId, int delStatus);
	
	List<PharmacyCertificateDetails> findByMedicalIdOrderByDelStatusDesc(int medicalId);
	@Transactional
	@Modifying
	@Query("UPDATE PharmacyCertificateDetails a SET a.delStatus =:delStatus, message=:message  WHERE a.medicalId=:medicalId AND delStatus=0")
	int updateCertificateDelStatus(@Param("medicalId")int medicalId,@Param("delStatus")int delStatus,@Param("message")String message);
	 
	
	@Query(value=" SELECT c.certificate_id, c.certificate, c.medical_id, d.medical_name as string1,"
			+ "c.create_date, c.last_modified_date,c.message, c.int_1, c.del_status from m_pharmacy_certificate_details c, medical_details d where c.del_status=0 AND d.medical_id=c.medical_id",nativeQuery=true)
	List<PharmacyCertificateDetails> getPharmacyPendingVerificationList();

	 

	  
	
}

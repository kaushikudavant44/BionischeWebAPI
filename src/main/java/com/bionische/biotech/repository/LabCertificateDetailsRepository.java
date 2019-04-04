package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.LabCertificateDetails;
import com.bionische.biotech.model.PharmacyCertificateDetails;

public interface LabCertificateDetailsRepository extends JpaRepository<LabCertificateDetails, Integer>{
	
	LabCertificateDetails save(LabCertificateDetails labCertificateDetails);
	
	LabCertificateDetails findByLabIdAndDelStatus(int labId,int delStatus);
	
	List<LabCertificateDetails> findByLabIdOrderByDelStatusDesc(int labId);
	@Transactional
	@Modifying
	@Query("UPDATE LabCertificateDetails a SET a.delStatus =:delStatus, message=:message  WHERE a.labId=:labId AND delStatus=0")
	int updateCertificateDelStatus(@Param("labId")int labId,@Param("delStatus")int delStatus,@Param("message")String message);
	 
	
	@Query(value=" SELECT c.certificate_id, c.certificate, c.lab_id, d.lab_name as string1,"
			+ "c.create_date, c.last_modified_date,c.message, c.int_1, c.del_status from m_lab_certificate_details c, lab_details d where c.del_status=0 AND d.lab_id=c.lab_id",nativeQuery=true)
	List<LabCertificateDetails> getLabPendingVerificationList();

	@Query(value=" SELECT * from m_lab_certificate_details WHERE lab_id=:labId AND del_status=1 ORDER BY cetrificate_id DESC  LIMIT 1",nativeQuery=true)
	 LabCertificateDetails getLastRejectedLabCertificate(@Param("labId")int labId);
	
}

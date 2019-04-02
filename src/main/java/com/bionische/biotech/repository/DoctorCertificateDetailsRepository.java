package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorCertificateDetails;
import com.bionische.biotech.model.DoctorDetails;

public interface DoctorCertificateDetailsRepository extends JpaRepository<DoctorCertificateDetails, Integer>{

	
	DoctorCertificateDetails save(DoctorCertificateDetails doctorCertificateDetails);
	
	DoctorCertificateDetails findByDoctorIdAndDelStatus(int doctorId, int delStatus);

	List<DoctorCertificateDetails> findByDoctorIdOrderByDelStatusDesc(int doctorId);
	@Transactional
	@Modifying
	@Query("UPDATE DoctorCertificateDetails a SET a.delStatus =:delStatus, message=:message  WHERE a.doctorId=:doctorId AND delStatus=0")
	int updateCertificateDelStatus(@Param("doctorId")int doctorId,@Param("delStatus")int delStatus,@Param("message")String message);
	 
	
	@Query(value=" SELECT c.cetrificate_id, c.certificate, c.doctor_id, concat(d.f_name,' ',d.m_name,' ',d.l_name)as string1,"
			+ "c.create_date, c.last_modified_date,c.message, c.int_1, c.del_status from doctor_certificate_details c, doctor_details d where c.del_status=0 AND d.doctor_id=c.doctor_id",nativeQuery=true)
	List<DoctorCertificateDetails> getDoctorPendingVerificationList();
	
	@Query(value=" SELECT * from doctor_certificate_details WHERE doctor_id=:doctorId AND del_status=1 ORDER BY cetrificate_id DESC  LIMIT 1",nativeQuery=true)
	DoctorCertificateDetails getLastRejectedDoctorCertificate(@Param("doctorId")int doctorId);
	
	
} 

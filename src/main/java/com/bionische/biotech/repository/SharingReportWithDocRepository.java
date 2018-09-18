package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bionische.biotech.model.SharingReportWithDoc;

public interface SharingReportWithDocRepository extends JpaRepository<SharingReportWithDoc, Integer> {
	
	SharingReportWithDoc  save(SharingReportWithDoc sharingReportWithDoc);
	
	@Query(value=" SELECT * from sharing_report_with_doctor where patient_id=:patientId AND doctor_id=:doctorId AND del_status=0 ",nativeQuery=true)
	SharingReportWithDoc getSharingInfo(@Param("patientId")int patientId,@Param("doctorId")int doctorId);
	

	@Transactional
	@Modifying
	@Query("UPDATE SharingReportWithDoc SET reportId=CONCAT(reportId,:reporId) WHERE patientId=:patId and doctorId=:docId and delStatus=0")
	int updateReport(@Param("reporId")String reporId,@Param("patId")int patId,@Param("docId")int docId);
}

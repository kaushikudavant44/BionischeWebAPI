package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.ReportDetails;

public interface ReportDetailsRepository extends JpaRepository<ReportDetails, Integer>{
	
	ReportDetails save(ReportDetails reportDetails);
	
	
	
	@Query(value=" SELECT * from patient_reports where lab_types_id=:testId AND patient_id=:patientId AND del_status=0",nativeQuery=true)
	List<ReportDetails> findBylabTypesIdAndDelStatus(@Param("testId")int testId, @Param("patientId")int patientId);
	
	
	@Query(value=" SELECT * from patient_reports where report_date between :fromDate And :toDate AND patient_id=:patientId AND del_status=0",nativeQuery=true)
	List<ReportDetails> findByreportDateAndpatientIdAndDelStatus(@Param("fromDate")String fromDate,@Param("toDate")String reportDate, @Param("patientId")int patientId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE ReportDetails p SET p.int2 =1  WHERE p.reportId=:reportId")
	int updatePaymentStatusByReportId(@Param("reportId")int reportId);
	
	
	
	 
}

package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPatientUploadedReport;

public interface GetPatientUploadedReportsRepository extends JpaRepository<GetPatientUploadedReport, Integer>{

	@Query(value=" SELECT DISTINCT r.report_id , r.patient_id, r.lab_test_id, r.lab_id, r.report_file_name, r.report_date, r.int_1 FROM patient_reports r,"
			+ " lab_tests t, lab_details l WHERE r.patient_id=:patientId AND  r.report_date BETWEEN :startDate AND :toDate AND r.lab_id=:labId ",nativeQuery=true)
	List<GetPatientUploadedReport> getSelfUploadedReports(@Param("patientId")int patientId,@Param("startDate")String startDate,@Param("toDate")String toDate,@Param("labId")int labId);
	
	@Query(value="SELECT DISTINCT r.report_id , r.patient_id, r.lab_test_id, r.lab_id, r.report_file_name, r.report_date, r.int_1 FROM patient_reports r,\r\n" + 
			" lab_tests t, lab_details l WHERE r.patient_id=:patientId AND r.lab_test_id=:testId  AND r.lab_id=:labId",nativeQuery=true)
	List<GetPatientUploadedReport> getSelfUploadedReports(@Param("patientId")int patientId,@Param("testId")int testId,@Param("labId")int labId);
}

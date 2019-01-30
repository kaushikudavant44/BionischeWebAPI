package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPatientReports;

public interface GetPatientReportsRepository extends JpaRepository<GetPatientReports, Integer>{

	
	
	@Query(value=" SELECT DISTINCT(r.report_id), r.patient_id,(CASE WHEN r.lab_test_id = 0 THEN 0 ELSE r.lab_test_id END) AS lab_test_id, " + 
			"(CASE WHEN r.lab_test_id != 0 THEN t.lab_test_name ELSE \"Birth Report\" END) AS lab_test_name, " + 
			"(CASE WHEN r.lab_test_id != 0 THEN l.lab_name ELSE 'Birth Report' END) AS lab_name, " + 
			"r.lab_id, r.report_file_name, r.report_date, r.int_1 FROM patient_reports r, lab_tests t, lab_details l  " + 
			"WHERE r.patient_id=:patientId AND  r.report_date BETWEEN :startDate AND :toDate AND " + 
			"(r.lab_test_id=t.lab_test_id OR r.lab_test_id=0) AND r.int_2=1 AND ( r.lab_test_id = 0 || r.lab_id=l.lab_id) ORDER BY r.report_date DESC",nativeQuery=true)
	List<GetPatientReports> getPatientReport(@Param("patientId")int patientId,@Param("startDate")String startDate,@Param("toDate")String toDate);
	
	
	@Query(value=" SELECT DISTINCT(r.report_id), r.patient_id, r.lab_id,  " + 
			"(CASE WHEN r.lab_test_id = 0 THEN 0 ELSE r.lab_test_id END) AS lab_test_id,  " + 
			"(CASE WHEN r.lab_test_id != 0 THEN t.lab_test_name ELSE \"Birth Report\" END) AS lab_test_name, " + 
			"(CASE WHEN r.lab_test_id != 0 THEN l.lab_name ELSE 'Birth Report' END) AS lab_name, " + 
			"r.report_file_name, " + 
			"r.report_date, r.int_1 FROM patient_reports r, lab_tests t, lab_details l WHERE r.report_id=:reportId AND " + 
			"(r.lab_test_id=t.lab_test_id OR r.lab_test_id=0) AND ( r.lab_test_id = 0 || r.lab_id=l.lab_id)",nativeQuery=true)
	GetPatientReports getPatientReportByReportId(@Param("reportId")int reportId);
	
	@Query(value="SELECT r.patient_id, r.lab_test_id, r.report_id, CONCAT(p.f_name,' ', p.l_name)AS lab_test_name, r.lab_id, l.lab_name,r.report_file_name,"
			+ " r.report_date, r.int_1 FROM patient_reports r, lab_tests t, lab_details l, patient_details p WHERE  "
			+ "r.lab_test_id=t.lab_test_id AND r.lab_id=:labId AND r.patient_id=p.patient_id AND r.report_date BETWEEN :fromDate AND :toDate AND r.lab_id=l.lab_id",nativeQuery=true)
	List<GetPatientReports> getPatientReportByLabId(@Param("labId")int labId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
	@Query(value=" SELECT r.patient_id, r.lab_test_id, r.report_id, t.lab_test_name, r.lab_id, l.lab_name,"
			+ " r.report_file_name, r.report_date, r.int_1 from patient_reports r, lab_tests t, lab_details l"
			+ " where r.patient_id=:patientId AND r.lab_test_id=:testId  AND r.lab_test_id=t.lab_test_id AND r.lab_id=l.lab_id ORDER BY r.report_date DESC",nativeQuery=true)
	List<GetPatientReports> getPatientReportBTest(@Param("patientId")int patientId,@Param("testId")int testId);


	@Query(value=" SELECT r.patient_id, r.report_id, " + 
			"(CASE WHEN r.lab_test_id = 0 THEN 0 ELSE r.lab_test_id END) AS lab_test_id, " + 
			"  (CASE WHEN r.lab_test_id != 0 THEN t.lab_test_name ELSE \"Birth Report\" END) AS lab_test_name, " + 
			"   (CASE WHEN r.lab_id = 0 THEN 0 ELSE r.lab_id END) AS lab_id,  " + 
			"  (CASE WHEN r.lab_id = 0 OR r.lab_test_id = 0 THEN 'self' ELSE l.lab_name END) AS lab_name, " + 
			"  r.report_file_name, " + 
			"  r.report_date, r.int_1 FROM patient_reports r, lab_tests t, lab_details l WHERE r.report_id IN(:reportIdList) AND r.int_2=1 AND " + 
			"  (r.lab_test_id=t.lab_test_id OR r.lab_test_id=0) AND (CASE WHEN r.lab_id != 0 THEN ( r.lab_test_id = 0 || r.lab_id=l.lab_id) ELSE r.lab_id=0 END) GROUP BY r.report_id",nativeQuery=true)
	List<GetPatientReports> getPatientReport(@Param("reportIdList")List<String> reportIdList);
	
	
	
	
}

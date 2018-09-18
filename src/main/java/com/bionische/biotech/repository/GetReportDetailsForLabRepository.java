package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetReportDetailsForLab;


public interface GetReportDetailsForLabRepository extends JpaRepository<GetReportDetailsForLab, Integer>{
	
	@Query(value=" SELECT r.report_id,p.patient_id,p.f_name,p.l_name,r.report_file_name,r.report_date,r.int_2,r.del_status,r.report_time,r.int_1,l.lab_id,l.lab_name,t.lab_test_name FROM \r\n" + 
			"patient_details p,patient_reports r,lab_details l,lab_tests t WHERE r.lab_id=:labId AND r.lab_test_id=:testId AND r.report_date BETWEEN \r\n" + 
			":fromDate AND :toDate AND r.lab_id=l.lab_id AND r.lab_test_id=t.lab_test_id AND r.patient_id=p.patient_id ",nativeQuery=true)
	List<GetReportDetailsForLab> getReportDetailsForLab(@Param("labId")int labId,@Param("testId")int testId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value=" SELECT DISTINCT r.report_id,r.patient_id,r.report_file_name,r.report_date,r.report_time,r.int_1,p.f_name,p.l_name,l.lab_name,l.lab_id,t.lab_test_name,r.del_status,r.int_2 FROM lab_details l,\r\n" + 
			"patient_details p,patient_reports r,lab_tests t WHERE r.int_2=1 AND r.del_status=0 AND r.patient_id=p.patient_id AND \r\n" + 
			" r.patient_id IN (SELECT p.patient_id FROM patient_details p WHERE p.family_id=:familyId) AND r.lab_id=l.lab_id AND r.lab_test_id=t.lab_test_id;",nativeQuery=true)
	List<GetReportDetailsForLab> getReportDetailsByRatingStatus(@Param("familyId")int familyId);
}

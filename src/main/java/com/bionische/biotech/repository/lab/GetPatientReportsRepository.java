package com.bionische.biotech.repository.lab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.lab.GetPatientReports;

public interface GetPatientReportsRepository extends JpaRepository<GetPatientReports, Integer>{

	
	@Query(value="SELECT r.report_id, r.appointment_id, r.file_name, r.status, r.patient_id, r.date, r.lab_test_id, "
			+ " r.lab_id, r.file_type, l.lab_name, t.lab_test_name, CONCAT(p.f_name,' ', p.l_name)AS patient_name "
			+ " from t_patient_report_details r, patient_details p,lab_details l, lab_tests t WHERE r.lab_id=:labId AND r.lab_id=l.lab_id AND r.date BETWEEN :fromDate AND :toDate AND r.patient_id=p.patient_id AND r.lab_test_id=t.lab_test_id ORDER BY r.date DESC",nativeQuery=true)
	List<GetPatientReports> getReportsByLabIdAndDate(@Param("labId")int labId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);

	@Query(value="SELECT r.report_id, r.appointment_id, r.file_name, r.status, r.patient_id, r.date, r.lab_test_id,"
			+ " r.lab_id,  r.file_type, CASE WHEN r.lab_id = 0 THEN 'Lab Name Not Available' WHEN r.lab_id != 0 THEN l.lab_name END AS lab_name,"
			+ " t.lab_test_name, CONCAT(p.f_name,' ', p.l_name)AS patient_name  FROM t_patient_report_details r,"
			+ " patient_details p,lab_details l, lab_tests t  WHERE r.patient_id=:patientId AND (r.lab_id=l.lab_id || r.lab_id=0) AND"
			+ "  r.patient_id=p.patient_id   AND r.date BETWEEN :fromDate AND :toDate AND r.lab_test_id=t.lab_test_id GROUP BY r.report_id ORDER BY r.date DESC",nativeQuery=true)
List<GetPatientReports> getReportsByPatientIdAndDate(@Param("patientId")int patientId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);

	@Query(value="SELECT r.report_id, r.appointment_id, r.file_name, r.status, r.patient_id, r.date, r.lab_test_id,"
			+ " r.lab_id,  r.file_type, CASE WHEN r.lab_id = 0 THEN 'Lab Name Not Available' WHEN r.lab_id != 0 THEN l.lab_name END AS lab_name,"
			+ " t.lab_test_name, CONCAT(p.f_name,' ', p.l_name)AS patient_name  FROM t_patient_report_details r,"
			+ " patient_details p,lab_details l, lab_tests t  WHERE r.patient_id=:patientId AND (r.lab_id=l.lab_id || r.lab_id=0) AND FIND_IN_SET(r.report_id, (select sd.shared_report_id from sharing_report_with_doctor sd where sd.patient_id=:patientId AND sd.doctor_id=:doctorId)) AND "
			+ "  r.patient_id=p.patient_id AND r.status=1  AND r.lab_test_id=t.lab_test_id GROUP BY r.report_id ORDER BY r.date DESC",nativeQuery=true)
List<GetPatientReports> getReportsByPatientIdAndDoctorId(@Param("patientId")int patientId, @Param("doctorId")int doctorId);
	
	
}
 
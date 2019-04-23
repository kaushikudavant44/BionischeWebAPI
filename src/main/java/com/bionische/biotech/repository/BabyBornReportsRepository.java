package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.BabyBornReports;

public interface BabyBornReportsRepository extends JpaRepository<BabyBornReports, Integer>{

	
	BabyBornReports save(BabyBornReports babyBornReports);
	
	BabyBornReports findByPatientId(int patientId);
	
	List<BabyBornReports> findByPatientIdAndDelStatus(int patientId, int delStatus);
	
	@Query(value="SELECT b.baby_report_id, b.mother_name, b.dob, b.birth_time, b.length, b.birth_weight, b.blood_group, " + 
			"b.delivery_type, b.family_id, b.patient_id, b.doctor_id, b.del_status, b.hospital_id, b.int_2, CONCAT(d.f_name,' ',d.l_name) AS string1, " + 
			"b.string2, b.hospital_name, b.head_circumference, b.sex " + 
			"FROM baby_born_reports b,doctor_details d WHERE b.baby_report_id=:babyReportId AND b.doctor_id=d.doctor_id  AND b.del_status=0",nativeQuery=true)
	BabyBornReports findByBabyReportId(@Param("babyReportId")int babyReportId);
}

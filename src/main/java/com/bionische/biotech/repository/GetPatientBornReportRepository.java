package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPatientBornReport;

public interface GetPatientBornReportRepository extends JpaRepository<GetPatientBornReport, Integer>{

	
	@Query(value="SELECT b.*, d.f_name, d.l_name, d.m_name, s.spec_type, d.spec_id from baby_born_reports b, doctor_details d,"
			+ " doctor_specialization s where d.doctor_id=b.doctor_id AND d.spec_id=s.spec_id AND b.patient_id=:patientId",nativeQuery=true)
	
	List<GetPatientBornReport> getpatientBornReport(@Param("patientId") int patientid);
}

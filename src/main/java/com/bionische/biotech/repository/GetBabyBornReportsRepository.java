package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetBabyBornReports;

public interface GetBabyBornReportsRepository extends JpaRepository<GetBabyBornReports, Integer>{

	@Query(value="select b.*, CONCAT(d.f_name, ' ', d.l_name)as doctor_name, s.spec_type as specialist from baby_born_reports b, "
			+ " doctor_details d, doctor_specialization s where b.patient_id=:patientId AND b.doctor_id=d.doctor_id AND d.spec_id=s.spec_id",nativeQuery=true)
	GetBabyBornReports getBabyBornReport(@Param("patientId") int patientId);
	
}

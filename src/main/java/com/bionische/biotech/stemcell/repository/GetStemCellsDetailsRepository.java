package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.stemcell.model.GetStemCellsDetails;

public interface GetStemCellsDetailsRepository extends JpaRepository<GetStemCellsDetails, Integer>{

	@Query(value=" SELECT s.patientenroll_id, s.patient_id, s.pregnancy_type, s.time, s.date, s.stemcellbank_id, co.stemcellbank_name, "
			+ "  s.country_id, s.state_id, s.city_id, s.hospital_id, s.plan_id, s.delivery_date, c.city_name,"
			+ "  p.plan_type, p.plan_name, p.plan_cost, p.plan_days, h.hospital_name from stemcellbank_details co, stemcell_enroll s, stemcellplan_details p, city c, hospital_details h"
			+ " where s.city_id=c.city_id AND s.hospital_id=h.hospital_id AND s.plan_id=p.plan_id AND s.patient_id=:patientId AND s.stemcellbank_id=co.stemcellbank_id" 
			+ "",nativeQuery=true)
	List<GetStemCellsDetails> getStemCellsDetails(@Param("patientId") int patientId);
}
 
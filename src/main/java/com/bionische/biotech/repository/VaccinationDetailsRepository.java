package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.biotech.model.VaccinationDetails;


public interface VaccinationDetailsRepository extends JpaRepository<VaccinationDetails, Integer>{
	
	@Query(value="SELECT *, a.vaxination_age_name FROM vaccination_details v, vaccination_age a WHERE v.vaccination_age_id=a.vaxination_age_id order by v.vaccination_age_id",nativeQuery=true)
	List<VaccinationDetails> getAllVaccinations();

}

package com.bionische.biotech.adminpanel3d.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.adminpanel3d.model.VaccinationDetailss;

public interface VaccinationDetailssRepository extends JpaRepository<VaccinationDetailss, Integer>{

	
	VaccinationDetailss save(VaccinationDetailss VaccinationDetailss);
	
	@Query(value="SELECT v.vaccination_id,v.vaccination_name,v.vaccination_age_id,v.int_1,v.int_2,a.vaxination_age_name AS string_2 FROM \r\n" + 
			"vaccination_details v,vaccination_age a WHERE v.int_2=0 AND v.vaccination_age_id=a.vaxination_age_id",nativeQuery=true)
	List<VaccinationDetailss> getAllVaccinations();
	
	@Transactional
	@Modifying
	@Query("DELETE FROM VaccinationDetailss WHERE vaccinationId=:vaccinationId")
	int deleteVaccinationById(@Param("vaccinationId")int vaccinationId);
	
}

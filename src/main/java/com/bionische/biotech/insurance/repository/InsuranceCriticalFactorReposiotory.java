package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bionische.biotech.insurance.model.InsuranceCriticalFactor;

public interface InsuranceCriticalFactorReposiotory extends JpaRepository<InsuranceCriticalFactor, Integer>{
	
	
	
	@Query(value="SELECT critical_factor from insurance_critical_factor where company_id=:id AND del_status=0",nativeQuery=true)
	List<String> getCriticalFactors(@Param("id")int id);

}

package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 
import com.bionische.biotech.stemcell.model.BabyVaxinationDetails;
import com.bionische.biotech.stemcell.model.VaxinationDetails;
 
 

public interface BabyVaxinationDetailsRepository extends JpaRepository<BabyVaxinationDetails, Integer> {

	BabyVaxinationDetails  save(BabyVaxinationDetails BabyVaxinationDetails);
//	PatientPastHistoryIIlness findByPatientId(int patientId);

	
	@Query(value=" SELECT * from baby_vaxination_details b, vaxination_age a where  b.baby_vaxination_details_id IN(:patientHistoryList) AND a.vaxination_age_id in(:patientHistoryList)",nativeQuery=true)
	List<BabyVaxinationDetails> getBabyVaxination(@Param("patientHistoryList")List<String> patientHistoryList);
	
	
   
	//BabyVaxinationDetails  save(BabyVaxinationDetails babyVaxinationDetails);
	
	
	
	//BabyVaxinationDetails findByPatientId(int patientId);
	
	
	
}

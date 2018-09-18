package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.stemcell.model.VaxinationDetails;

public interface VaxinationDetailsRepository extends JpaRepository<VaxinationDetails, Integer> {

	
	
	VaxinationDetails  save(VaxinationDetails vaxinationDetails);
	
	
	
	VaxinationDetails findByPatientId(int patientId);
	
	/*VaxinationDetails  save(VaxinationDetails vaxinationDetails);
//	PatientPastHistoryIIlness findByPatientId(int patientId);

	
	@Query(value=" SELECT * from vaxination_details where  baby_vaxination_details_id IN(:patientHistoryList)",nativeQuery=true)
	List<VaxinationDetails> getBabyVaxination(@Param("patientHistoryList")List<String> patientHistoryList);
	*/
	
	
	 
	
	
}

package com.bionische.biotech.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.bloodbank.model.BloodBankDetails;
import com.bionische.biotech.bloodbank.model.BloodBankRatingDetails;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.LabDetails;

 

public interface BloodBankDetailsRepository extends JpaRepository<BloodBankDetails, Integer>{

	BloodBankDetails save(BloodBankDetails bloodBankDetails);
	
	//BloodBankDetails findByBloodBankCityId(int bloodBankCityId);
	

	List<BloodBankDetails> findByDelStatus(int delStatus);


	List<BloodBankDetails> getBloodBankByCityId(int cityId);

	/*@Query(value="select * from bloodbank_details where del_status=:delStatus AND city_id IN(:cityId)",nativeQuery=true)
	List<BloodBankDetails> getByBloodCityIdAndDelStatus(@Param("cityId")List<String> city_id, @Param("delStatus")int delStatus);
*/

	List<BloodBankDetails> findByCityIdAndDelStatus(int cityId, int i);



	//List<BloodBankDetails>getByBloodBankCityId(int bloodBankCityId);


	  
 }
       
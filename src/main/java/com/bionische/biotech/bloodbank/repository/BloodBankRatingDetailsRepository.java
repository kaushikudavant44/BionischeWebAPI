package com.bionische.biotech.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.bloodbank.model.BloodBankRatingDetails;
import com.bionische.biotech.stemcell.model.GetPatientEnrollDetails;
import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;

public interface BloodBankRatingDetailsRepository extends JpaRepository<BloodBankRatingDetails, Integer>{
	
	
	
	@Query(value="select * from bloodbankrating_details where del_status=:delStatus AND bloodbank_id IN(:bloodBankId)",nativeQuery=true)
	List<BloodBankRatingDetails> getByBloodBankIdAndDelStatus(@Param("bloodBankId")List<String> bloodbank_id, @Param("delStatus")int delStatus);


	List<BloodBankRatingDetails> findBybloodBankIdAndDelStatus(int bloodBankId, int i);

}
          
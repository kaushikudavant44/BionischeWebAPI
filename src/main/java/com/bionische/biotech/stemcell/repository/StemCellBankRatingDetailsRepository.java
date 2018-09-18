package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.RatingDetails;
import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;

 

public interface StemCellBankRatingDetailsRepository extends JpaRepository<StemCellBankRatingDetails, Integer>{
	
	StemCellBankRatingDetails save(StemCellBankRatingDetails stemCellRatingDetails);

	
	@Query(value="select * from stemcellbankrating_details where del_status=:delStatus AND stemcellbank_id IN(:stemCellBankId)",nativeQuery=true)
	List<StemCellBankRatingDetails> getByStemCellBankIdAndDelStatus(@Param("stemCellBankId")List<String> stemcellbank_id, @Param("delStatus")int delStatus);


	List<StemCellBankRatingDetails> findBystemCellBankIdAndDelStatus(int stemCellBankId, int i);


	//List<StemCellBankRatingDetails> findBystemCellIdAndDelStatus(int stemCellBankId, int i);


	//List<StemCellRatingDetails> findBystemCellIdAndDelStatus(int stemCellId, int i);

	
         
	   


	
}

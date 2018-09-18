package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetAppointmentDetails;
//import com.bionische.biotech.model.GetStemcellBankDetails;
import com.bionische.biotech.stemcell.model.GetStemcellBankDetails;

public interface GetStemcellBankDetailsRepository extends JpaRepository<GetStemcellBankDetails, Integer>{
	
	@Query(value=" SELECT s.stemcellbank_id, s.stemcellbank_name, s.city_id, s.address, s.photo, s.contact1, s.email_id,COALESCE((select ((SUM(r.rating)*5)/(count(r.rating_review_id)*5)) from stemcellbankrating_details r where r.stemcellbank_id=s.stemcellbank_id),0) AS rating from stemcellbank_details s where s.city_id=:cityId AND s.del_status=0;",nativeQuery=true)
	List<GetStemcellBankDetails> getStemcellBankDetailsByCityId(@Param("cityId")int cityId);
	
}
               
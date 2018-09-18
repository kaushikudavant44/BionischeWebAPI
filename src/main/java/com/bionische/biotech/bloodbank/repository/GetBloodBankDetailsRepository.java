package com.bionische.biotech.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.bloodbank.model.GetBloodBankDetails;

public interface GetBloodBankDetailsRepository extends JpaRepository<GetBloodBankDetails, Integer>{
	
	
	/*@Query(value=" SELECT s.bloodbank_id, s.bloodbank_name, s.bloodbank_cityid, s.bloodbank_address, s.image, s.bloodbank_contact, s.bloodbank_emailid,COALESCE((select ((SUM(r.rating)*5)/(count(r.rating_review_id)*5)) from bloodbankrating_details r where r.bloodbank_id=s.bloodbank_id),0) AS rating from bloodbank_details s where s.bloodbank_cityid=:cityId AND s.del_status=0;",nativeQuery=true)

	List<GetBloodBankDetails> getBloodBankDetailsByCityId(@Param("cityId")int cityId);*/
/*
	@Query(value="SELECT s.bloodbank_id, s.bloodbank_name,s.location,a.date,a.blood_group,s.bloodbank_cityid, s.bloodbank_address, s.image, s.bloodbank_contact, s.bloodbank_emailid from bloodbank_details s,blood_available a where s.location=:location AND s.bloodbank_id=a.bloodbank_id AND a.blood_group LIKE  %:bloodGroup%  AND a.date=:date",nativeQuery=true)*/

	@Query(value="SELECT s.bloodbank_id, s.bloodbank_name,s.location,a.date,a.blood_group,s.bloodbank_cityid, s.bloodbank_address, s.image, s.bloodbank_contact, s.bloodbank_emailid,COALESCE((select ((SUM(r.rating)*5)/(count(r.rating_review_id)*5)) from bloodbankrating_details r where r.bloodbank_id=s.bloodbank_id),0) AS rating  from bloodbank_details s,blood_available a where s.location=:location AND s.bloodbank_id=a.bloodbank_id AND a.blood_group LIKE  %:bloodGroup%  AND a.date=:date AND s.del_status=0",nativeQuery=true)
	List<GetBloodBankDetails> getBloodBankDetailsBybloodGroupANDdateANDlocation(@Param("bloodGroup")String bloodGroup, @Param("date")String date, @Param("location")String location);
		

}

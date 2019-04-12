package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.AdvertiseDetails;

public interface AdvertiseDetailsRepository extends JpaRepository<AdvertiseDetails, Integer>{

	
	AdvertiseDetails save(AdvertiseDetails advertiseDetails);

	@Query(value=" SELECT * from t_advertise_details where del_status=0 AND exp_date>=CURDATE() ORDER BY RAND() LIMIT 10;",nativeQuery=true)
	List<AdvertiseDetails> getRandom10Ads();
	
	@Transactional
	@Modifying
	@Query("UPDATE AdvertiseDetails  SET delStatus =:delStatus WHERE adsId=:adsId")
	int removeAdvertise(@Param("delStatus")int delStatus, @Param("adsId")int adsId);

	@Query(value=" SELECT * from t_advertise_details where del_status!=1 AND ads_from=:adsFrom AND from_type=:userType",nativeQuery=true)
	List<AdvertiseDetails> getByAdsFromAndFromTypeAndDelStatus( @Param("adsFrom")int adsFrom,  @Param("userType")int userType);
}

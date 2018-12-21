package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPromoCodeValidRes;

public interface GetPromoCodeValidResRepository extends JpaRepository<GetPromoCodeValidRes, Integer>{

	@Query(value="SELECT offer_id, discount_per from m_package_offers where now() BETWEEN start_date AND end_date AND promo_code=:promoCode AND user_type=:usertype AND del_status=0",nativeQuery=true)
	GetPromoCodeValidRes checkPromoCodeValidation(@Param("promoCode")String promoCode, @Param("usertype")int usertype);
}

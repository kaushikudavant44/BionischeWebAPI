package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.PackageOffers;

public interface PackageOffersRepository extends JpaRepository<PackageOffers, Integer>{

	PackageOffers save(PackageOffers packageOffers);

	@Query(value="Select offer_id, package_id, offer_title, start_date, end_date, user_type,"
			+ " discount_per, terms_and_condition, create_date, last_modified_date, del_status,"
			+ " promo_code, max_user, current_user_count from m_package_offer WHERE NOW() BETWEEN start_date AND end_date AND del_status=0",nativeQuery=true)
	List<PackageOffers> getCurrentActivePackageOffers();
	
	@Query(value="SELECT offer_id, package_id, offer_title, start_date, end_date, user_type, discount_per, terms_and_condition,"
			+ " create_date, last_modified_date, del_status, promo_code, max_user, current_user_count FROM m_package_offers WHERE"
			+ " (start_date BETWEEN :fromDate AND :toDate) || (end_date BETWEEN :fromDate AND :toDate)",nativeQuery=true)
	List<PackageOffers> getAllPackageOffersBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
}

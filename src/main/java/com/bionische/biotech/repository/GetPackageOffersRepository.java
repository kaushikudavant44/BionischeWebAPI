package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPackageOffers;

public interface GetPackageOffersRepository extends JpaRepository<GetPackageOffers, Integer>{

	
	@Query(value="Select o.offer_id, o.package_id, o.offer_title, o.start_date, o.end_date, o.user_type, p.package_cost, p.package_name, p.package_duration, p.duration_type,"
			+ " o.discount_per, o.terms_and_condition, o.create_date, o.last_modified_date, o.del_status,"
			+ " o.promo_code, o.max_user, o.current_user_count from m_package_offers o, m_package p  WHERE NOW() BETWEEN o.start_date AND o.end_date AND o.del_status=0 AND p.package_id=o.package_id AND p.del_status=0",nativeQuery=true)
	List<GetPackageOffers> getCurrentActivePackageOffers();
	
	@Query(value="SELECT o.offer_id, o.package_id, o.offer_title, o.start_date, o.end_date, o.user_type, o.discount_per, o.terms_and_condition , p.package_cost, p.package_name, p.package_duration, p.duration_type,"
			+ " o.create_date, o.last_modified_date, o.del_status, o.promo_code, o.max_user, o.current_user_count FROM m_package_offers o,m_package p  WHERE"
			+ " (o.start_date BETWEEN :fromDate AND :toDate) || (o.end_date BETWEEN :fromDate AND :toDate) AND p.package_id=o.package_id AND p.del_status=0",nativeQuery=true)
	List<GetPackageOffers> getAllPackageOffersBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value="Select o.offer_id, o.package_id, o.offer_title, o.start_date, o.end_date, o.user_type, p.package_cost, p.package_name, p.package_duration, p.duration_type,"
			+ " o.discount_per, o.terms_and_condition, o.create_date, o.last_modified_date, o.del_status,"
			+ " o.promo_code, o.max_user, o.current_user_count from m_package_offers o, m_package p  WHERE NOW() BETWEEN o.start_date AND o.end_date AND o.del_status=0 AND p.package_id=o.package_id AND p.del_status=0 AND o.user_type=:userType",nativeQuery=true)
	List<GetPackageOffers> getCurrentActivePackageOffersByUserType(@Param("userType")int userType);

}

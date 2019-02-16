package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetLabForAppointment;

public interface GetLabForAppointmentRepository extends JpaRepository<GetLabForAppointment, Integer>{
	
	
	@Query(value=" SELECT COALESCE((select ((SUM(r.rating)*5)/(count(r.rating_review_id)*5)) from lab_rating_review r"
			+"  where r.lab_id=l.lab_id),0) AS rating, l.tests_types, l.tests_types as tests_name, l.lab_id, l.city_id, l.lab_name, c.city_name, l.address, l.from_time, l.to_time, l.lic_no, l.photo,"
	+" l.contact, l.email, l.lat, l.longitude from lab_details l, city c, t_lab_subscription_details ls where l.city_id=c.city_id AND l.city_id=:cityId AND l.tests_types"
			+" LIKE :testId AND l.del_status=0 AND ls.package_exp_date>=NOW() AND l.lab_id=ls.lab_id AND ls.txn_status=1 ORDER BY rating DESC ",nativeQuery=true)
	List<GetLabForAppointment> getLabForAppointment(@Param("cityId")int cityId, @Param("testId")String testId);

	/*
	 * Ganesh 
	 * 2018-02-08
	*/
	@Query(value=" SELECT COALESCE((SELECT ((SUM(r.rating)*5)/(COUNT(r.rating_review_id)*5)) FROM lab_rating_review r WHERE r.lab_id=l.lab_id),0)"
			+ " AS rating, GROUP_CONCAT(t.lab_test_id SEPARATOR  ',')AS tests_types,  l.lab_id, l.city_id, l.lab_name,  c.city_name, l.address,"
			+ "  l.from_time, l.to_time, l.lic_no, l.photo,l.contact, l.email, GROUP_CONCAT(t.lab_test_name SEPARATOR  ', ')as tests_name, l.lat,   l.longitude FROM lab_details l, city c, t_lab_subscription_details ls,"
			+ " t_tests_in_lab lt, lab_tests t WHERE l.city_id=:cityId AND l.city_id=c.city_id AND"
			+ " l.lab_id=ls.lab_id AND lt.lab_id=l.lab_id AND lt.test_id IN(:testIdList) AND lt.test_id=t.lab_test_id AND l.del_status=0 AND lt.del_status=0"
			+ " AND ls.txn_status=1 AND  ls.package_exp_date>=NOW()  GROUP BY lt.lab_id  ORDER BY rating DESC",nativeQuery=true)
	List<GetLabForAppointment> getLabForAppointmentByTestList(@Param("cityId")int cityId, @Param("testIdList")List<String> testIdList);
}
 
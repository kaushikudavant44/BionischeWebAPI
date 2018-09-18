package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetLabDetails;

public interface GetLabDetailsRepository extends JpaRepository<GetLabDetails, Integer>{

	
	@Query(value="SELECT l.*, c.city_name, s.state_name from lab_details l, city c, state s where l.lab_id=:labId AND l.city_id=c.city_id AND l.state_id=s.state_id",nativeQuery=true)
	GetLabDetails getLabDetailsByLabId(@Param("labId")int labId);
}

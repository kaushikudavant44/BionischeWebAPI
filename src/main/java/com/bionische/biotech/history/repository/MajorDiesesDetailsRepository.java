package com.bionische.biotech.history.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.history.model.MajorDiesesDetails;
import com.bionische.biotech.model.City;
import com.bionische.biotech.model.LabTests;

public interface MajorDiesesDetailsRepository extends JpaRepository<MajorDiesesDetails, Integer>{
	
	List<MajorDiesesDetails> findByDelStatus(int delStatus);

	
	@Query(value=" SELECT * from major_dieses where major_dieses_id IN(:diesesIdList) AND del_status=0",nativeQuery=true)
	List<MajorDiesesDetails> getDiesesDetails(@Param("diesesIdList")List<String> diesesIdList);

 
	
	
}

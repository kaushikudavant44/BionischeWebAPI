package com.bionische.biotech.adminpanel3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.adminpanel3d.model.SaveFrequentlyUsedModel;

public interface SaveFrequentlyUsedModelRepository extends JpaRepository<SaveFrequentlyUsedModel, Integer>{

	
	SaveFrequentlyUsedModel save(SaveFrequentlyUsedModel saveFrequentlyUsedModel);
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE SaveFrequentlyUsedModel s set s.delStatus=1 where s.frequentlyUsedId=:frequentlyUsedId")
	int deleteFrequentlyUsedModel(@Param("frequentlyUsedId")int frequentlyUsedId);

	SaveFrequentlyUsedModel findByUserIdAndSubModelId(int userId, int subModelId);
}

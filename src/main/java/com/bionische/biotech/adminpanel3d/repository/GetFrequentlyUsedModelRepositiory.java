package com.bionische.biotech.adminpanel3d.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.adminpanel3d.model.GetFrequentlyUsedModel;

public interface GetFrequentlyUsedModelRepositiory extends JpaRepository<GetFrequentlyUsedModel, Integer>{

	@Query(value="select s.*, m.model_id,m.model_name,c.cat_id,c.category, f.frequently_used_id,f.user_id, f.del_status from 3d_sub_model s,3d_main_model m,3d_model_category c, 3d_frequently_used_model f where f.user_id=:userId and s.sub_model_id=f.sub_model_id and s.main_model_id=m.model_id and c.cat_id=m.cat_id and f.del_status=0",nativeQuery=true)
	List<GetFrequentlyUsedModel> findByUserId(@Param("userId")int userId);

}
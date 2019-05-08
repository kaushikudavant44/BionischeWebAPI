package com.bionische.biotech.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.BlogCreation;


public interface BlogCreationRepository extends JpaRepository<BlogCreation, Integer>{
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE BlogCreation b SET b.isUsed=0  WHERE b.blogId=:blogId")
	int deleteById(@Param("blogId")int blogId);
	
}

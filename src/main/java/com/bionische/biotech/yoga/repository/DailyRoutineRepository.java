package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.yoga.model.DailyRoutine;

public interface DailyRoutineRepository extends JpaRepository<DailyRoutine, Integer> {
	List<DailyRoutine> findAll();

	@Query(value=" SELECT * from daily_routine where dailyroutinetype_id IN(:dailytypesIdList)",nativeQuery=true)
	List<DailyRoutine> getTypesDetails(@Param("dailytypesIdList")List<String> dailytypesIdList);



	

}

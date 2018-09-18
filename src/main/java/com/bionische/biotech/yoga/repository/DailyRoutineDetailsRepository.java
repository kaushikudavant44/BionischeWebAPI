package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.yoga.model.DailyRoutineDetails;
import com.bionische.biotech.yoga.model.HealthWellnessDetails;

public interface DailyRoutineDetailsRepository extends JpaRepository<DailyRoutineDetails, Integer> {

	@Query(value="SELECT d.dailyroutindetail_id,d.string1,d.int_1,d.int_2,d.del_status,d.dailyroutinetype_id,d.teacher_id,d.description,d.image from daily_routinedetails d where d.dailyroutinetype_id=:dailyroutineTypeId",nativeQuery=true)
	List<DailyRoutineDetails> getDailyRoutineByDailyroutineTypeId(@Param("dailyroutineTypeId") int dailyroutineTypeId);

	//List<HealthWellnessDetails> getHealthByHealthTypeId(@Param("healthTypeId") int healthTypeId);

}

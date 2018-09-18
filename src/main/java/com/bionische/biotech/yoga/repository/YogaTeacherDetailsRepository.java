package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.yoga.model.YogaTeacherDetails;

public interface YogaTeacherDetailsRepository extends JpaRepository<YogaTeacherDetails, Integer> {

	YogaTeacherDetails save(YogaTeacherDetails yogaTeacherDetails);

	@Query(value=" SELECT * from yogateacher_details where uname=:userName AND del_status=0",nativeQuery=true)
	YogaTeacherDetails getYogaTeacherLogin(@Param("userName")String userName);

	List<YogaTeacherDetails> findByCityIdAndDelStatus(int cityId, int i);

	List<YogaTeacherDetails> getTeacherListBylocation(String location);

	List<YogaTeacherDetails> findByLocationAndDelStatus(String location, int i);


	YogaTeacherDetails findByTeacherIdAndDelStatus(int teacherId, int delStatus);

	YogaTeacherDetails findByTeacherId(int teacherId);


}

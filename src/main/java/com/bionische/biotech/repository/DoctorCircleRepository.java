package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorCircle;

public interface DoctorCircleRepository extends JpaRepository<DoctorCircle, Integer>{

	
	DoctorCircle save(DoctorCircle doctorCircle);
	
	@Query(value="select * from t_doctor_circle WHERE (from_doctor_id=:fromDoctorId AND to_doctor_id=:toDoctorId) OR (from_doctor_id=:toDoctorId AND to_doctor_id=:fromDoctorId) AND status=:status",nativeQuery=true)
	DoctorCircle getDoctorNetwork(@Param("fromDoctorId")int fromDoctorId, @Param("toDoctorId")int toDoctorId,@Param("status")int status);
	
	List<DoctorCircle> findByToDoctorIdAndStatus(int toDoctorId, int status);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorCircle  SET status =:status WHERE fromDoctorId=:fromId AND toDoctorId=:toId")
	int changeStatus(@Param("status")int status,@Param("fromId")int fromId, @Param("toId")int toId );
}

package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorHospitalDetails;
import com.bionische.biotech.model.GetHospitalDetails;

public interface DoctorHospitalDetailsRepository extends JpaRepository<DoctorHospitalDetails, Long>{

	DoctorHospitalDetails save(DoctorHospitalDetails doctorHospitalDetails);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorHospitalDetails  SET delStatus =:delStatus WHERE hospitalId=:hospitalId AND doctorId=:doctorId")
	int deleteDoctorHospital(@Param("hospitalId")int hospitalId, @Param("doctorId")int doctorId,@Param("delStatus")int delStatus);

	DoctorHospitalDetails findByDoctorIdAndHospitalId(int doctorId, int hospitalId);
	
}

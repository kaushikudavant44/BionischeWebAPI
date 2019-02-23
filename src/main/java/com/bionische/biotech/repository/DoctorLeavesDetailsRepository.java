package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorLeavesDetails;

public interface DoctorLeavesDetailsRepository  extends JpaRepository<DoctorLeavesDetails, Integer>{

	
	DoctorLeavesDetails save(DoctorLeavesDetails doctorLeavesDetails);
	
	DoctorLeavesDetails findByDateAndDoctorId(String date, int doctorId);
	List<DoctorLeavesDetails> findByDateGreaterThanEqualAndDoctorId(String date, int doctorId);

	@Transactional
	  @Modifying
	@Query("DELETE from  DoctorLeavesDetails  where leaveId=:leaveId")
	int deleteDoctorLeave(@Param("leaveId") int leaveId);
}
 
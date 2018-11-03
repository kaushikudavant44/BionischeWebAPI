package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.FreequantlyUsedMedicines;


public interface FreequantlyUsedMedicinesRepository extends JpaRepository<FreequantlyUsedMedicines, Integer> {
	
	FreequantlyUsedMedicines  save(FreequantlyUsedMedicines appointmentDetails);
	
	
	@Query(value=" SELECT * from frequently_used_medicine where doctor_id=:doctorId AND del_status=:delAtatus ORDER BY medicine_name ASC",nativeQuery=true)
	List<FreequantlyUsedMedicines> getFrequentlyUsedMedicineBYDoctorUd(@Param("doctorId")int doctorId, @Param("delAtatus")int delAtatus);
	
	@Transactional
	@Modifying
	@Query("DELETE from FreequantlyUsedMedicines  where freequantlyUsedMedicinesId=:medicineId")
	int deleteMedicine(@Param("medicineId")int medicineId);

	FreequantlyUsedMedicines findByDoctorIdAndMedicineName(int doctorId,String medicineName);

}

package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.biotech.model.GetUsersCount;

public interface GetUsersCountRepository extends JpaRepository<GetUsersCount, Integer>
{

	@Query(value="SELECT 1 as id, (SELECT COUNT(patient_id) FROM patient_details)AS patient_count, "
			+ "(SELECT COUNT(doctor_id) FROM doctor_details)AS doctor_count, "
			+ "(SELECT COUNT(lab_id) FROM lab_details)AS lab_count, "
			+ "(SELECT COUNT(medical_id) FROM medical_details)AS pharmacy_count, "
			+ "(SELECT COUNT(hospital_id) FROM hospital_details where type=1)AS hospital_count  ",nativeQuery=true)
	GetUsersCount getUserCounts();
}

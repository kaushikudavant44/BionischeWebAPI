package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetDocAvailableTimeDetails;

public interface GetDocAvailableTimeDetailsRepository extends JpaRepository<GetDocAvailableTimeDetails, Integer>{

	@Query(value="Select a.doc_available_time_id, a.doctor_id, CONCAT(d.f_name, ' ', d.l_name)as doctor_name, a.date, a.hospital_id, h.hospital_name, a.available_time, a.no_of_patient, h.address, h.type"
			+ " from hospital_details h, doc_available_time a, doctor_details d where a.date=:date AND a.doctor_id=:doctorId AND a.doctor_id=d.doctor_id AND a.hospital_id=h.hospital_id ",nativeQuery=true)
	List<GetDocAvailableTimeDetails> getDocAvailableTimeDetails(@Param("doctorId")int doctorId, @Param("date")String date);
}

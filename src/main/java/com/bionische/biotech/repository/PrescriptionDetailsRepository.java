package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.PrescriptionDetails;

public interface PrescriptionDetailsRepository extends JpaRepository<PrescriptionDetails, Integer>{

	
	PrescriptionDetails save(PrescriptionDetails prescriptionDetails);
	
	@Query(value=" SELECT * FROM prescription_details where del_status=0 and meeting_id=(select meet_id from doctor_patient_meeting where patient_id=:patientId and date:date and del_status=0)",nativeQuery=true)
	List<PrescriptionDetails> getPrescriptionByPatientIdAndDateAndDelStatus(@Param("patientId")int patientId, @Param("date")String date);
	
	List<PrescriptionDetails> findByMeetingId(int meetingId);
	
	List<PrescriptionDetails> findByPrescriptionId(int prescId);
}

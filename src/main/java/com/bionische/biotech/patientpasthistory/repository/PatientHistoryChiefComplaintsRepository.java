package com.bionische.biotech.patientpasthistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.patientpasthistory.model.PatientHistoryChiefComplaints;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;

public interface PatientHistoryChiefComplaintsRepository extends JpaRepository<PatientHistoryChiefComplaints, Integer>  {

	PatientHistoryChiefComplaints  save(PatientHistoryChiefComplaints patientHistoryChiefComplaints);
	PatientHistoryChiefComplaints findByPatientId(int patientId);
	
}

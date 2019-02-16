package com.bionische.biotech.repository.lab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.lab.PatientReportsDetails;

public interface PatientReportsDetailsRepository extends JpaRepository<PatientReportsDetails, Integer>{

	
	PatientReportsDetails save(PatientReportsDetails patientReportsDetails);
	
	PatientReportsDetails findByReportIdAndStatus(int reportId, int status);
	
	List<PatientReportsDetails> findByPatientIdAndStatus(int patineId, int status);

	@Transactional
	@Modifying
	@Query("UPDATE PatientReportsDetails  SET status =:txnStatus WHERE appointmentId=:appointmentId")
	int updatePaymentStatusByAppointmentId( @Param("appointmentId")int appointmentId,  @Param("txnStatus")int txnStatus);

	
 
}

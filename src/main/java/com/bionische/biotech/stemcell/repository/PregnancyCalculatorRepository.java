package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.stemcell.model.PatientEnrollDetails;
import com.bionische.biotech.stemcell.model.PregnancyCalculator;

public interface PregnancyCalculatorRepository extends JpaRepository<PregnancyCalculator, Integer>{
	
	
	PregnancyCalculator save(PregnancyCalculator pregnancyCalculator);
	
	@Query(value=" SELECT * from preganancy_calci where patient_id=:patientId AND del_status=0",nativeQuery=true)
	//DoctorDetails getLoginUserName(  @Param("userName") String userName);

	PregnancyCalculator getPregnancyCalculatorByPatientId( @Param("patientId") int patientId);


}
         
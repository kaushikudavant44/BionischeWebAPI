package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.PatientOrderAddresses;


public interface PatientOrderAddressesRepository extends JpaRepository<PatientOrderAddresses, Integer>{
	
	@Query(value=" SELECT medical_request_id,patient_contact,city,land_mark,address,pincode from prescription_to_medical where patient_id=:patientId AND string_1=:type AND delivery_type=0 AND del_status=0",nativeQuery=true)
	List<PatientOrderAddresses> getOrdredAddressOfpatient(@Param("patientId")int patientId,@Param("type")String type);

}

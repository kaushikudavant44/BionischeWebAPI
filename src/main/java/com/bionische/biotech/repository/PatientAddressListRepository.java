package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.PatientAddressList;


public interface PatientAddressListRepository extends JpaRepository<PatientAddressList, Long>{
	
	PatientAddressList save(PatientAddressList patientAddressList);
	
	@Query(value="SELECT * from patient_address_list where patient_id=:patientId",nativeQuery=true)
	List<PatientAddressList> getPatientAddress(@Param("patientId") int patientId);
	
	@Transactional
	@Modifying
	@Query("DELETE from PatientAddressList  WHERE patientAddressListId=:addressId")
	int deleteAddress(@Param("addressId")int addressId);
	
}

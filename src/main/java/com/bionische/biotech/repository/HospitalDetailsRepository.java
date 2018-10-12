package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.stemcell.model.PlanDetails;

 

public interface HospitalDetailsRepository extends JpaRepository<HospitalDetails, Integer>{

	HospitalDetails save(HospitalDetails hospitalDetails);
	
    
	
	HospitalDetails findByHospitalId(int hospitalId);

	HospitalDetails findByHospitalIdAndDelstatus(int hospitalId,int delstatus);
	
	List<HospitalDetails> findAll();                                  
	
	@Query(value="SELECT h.hospital_name,contact_no,h.mail_id,h.lat,h.longitude,h.country_id,h.state_id,h.address,h.int_1,h.int_2,h.string1,h.string2,h.cityid,h.hospital_id,h.del_status from hospital_details h where h.hospital_id IN (select h.hospital_id from hospital_details h,doctor_patient_meeting m,doctor_details d where m.patient_id=:patientId and m.doctor_id=d.doctor_id and d.hospital_id=h.hospital_id and h.cityid=:cityId)",nativeQuery=true)
	List<HospitalDetails> getByCityId(@Param("cityId")int cityId,@Param("patientId")int patientId);
	List<HospitalDetails> findByCityId(int cityId);

	
}   

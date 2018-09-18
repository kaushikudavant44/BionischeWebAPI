package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetAppointmentDetails;
import com.bionische.biotech.stemcell.model.GetPatientEnrollDetails;

public interface GetPatientEnrollDetailsRepository extends JpaRepository<GetPatientEnrollDetails, Integer>{


	
	
/*@Query(value="select s.patientenroll_id,s.pregnancy_type,s.patient_id,s.hospital_id, s.del_status,s.int_1,s.int_2,s.city_id,s.country_id,s.state_id,s.string1,s.string2,s.stemcellbank_id,s.date,s.time,s.delivery_date,r.plan_name,r.stemcellbank_id,r.del_status,r.terms_condition,r.message,r.plan_type,r.plan_cost,r.plan_days,r.plan_id FROM stemcell_enroll s,plan_details r WHERE r.plan_id=s.plan_id AND s.patient_id in(select p.patient_id from patient_details p where p.family_id=s.patient_id;",nativeQuery=true) 
*/				

@Query(value="select s.patientenroll_id, s.time,s.date, s.plan_id, s.delivery_date,r.plan_type,r.plan_name,r.plan_cost,r.plan_days from stemcell_enroll s,stemcellplan_details r where r.plan_id=s.plan_id AND s.patient_id IN(select p.patient_id from patient_details p where p.family_id=:familyId)",nativeQuery=true) 

List<GetPatientEnrollDetails> getPatientEnrollDetailsByPatientId(@Param("familyId") int familyId);
		}
      
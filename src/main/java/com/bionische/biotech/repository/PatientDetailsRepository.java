package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PrescriptionDetails;
import com.bionische.biotech.radiology.model.PndtPatientBasicDetails;

 

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer>{
	
	PatientDetails save(PatientDetails patientDetails);	
	
	PatientDetails findByPatientId(int patientId);	
	
	@Query(value=" SELECT * from patient_details where uname=:userName AND del_status=0",nativeQuery=true)
	PatientDetails getPatientLogin(@Param("userName")String userName);
	
	@Query(value=" SELECT * from patient_details where patient_id=:patientId AND password=:password AND del_status=0",nativeQuery=true)
	PatientDetails passwordValidation(@Param("patientId")int patientId,@Param("password")String password);
	
	@Query(value=" SELECT * from patient_details where blood_group=:bloodGroup ANd del_status=0 AND city_id in (select city_id from city where city_name=:cityName)",nativeQuery=true)
	List<PatientDetails> getPatientDetailsListByCityIdAndBloodGroup(@Param("cityName")String cityName,@Param("bloodGroup")String bloodGroup);
 
	@Query(value=" SELECT p.* FROM patient_details p,t_patient_suscription_details s WHERE p.family_id IN (SELECT f.family_id FROM patient_details f WHERE f.patient_id=:patientId) AND s.patient_id=p.patient_id AND s.status=1",nativeQuery=true)
	List<PatientDetails> getPatientDetailsListByFamilydAndPatientId(@Param("patientId")int patientId);
	
	PatientDetails findByUserNameAndPassword(String userName, String password);


	PatientDetails findByUserNameAndDelStatus(String uName, int i);

	@Query(value=" SELECT p.* FROM patient_details p, t_patient_suscription_details s WHERE p.family_id=:familyId AND p.del_status=:delStatus AND s.patient_id=p.patient_id AND s.status=1",nativeQuery=true)
	List<PatientDetails> findByFamilyIdAndDelStatus(@Param("familyId")int familyId, @Param("delStatus")int delStatus);
	
	@Transactional
	@Modifying
	@Query("UPDATE PatientDetails a SET a.password =:newPassword  WHERE a.patientId=:patientId")
	int updateNewPassword(@Param("patientId")int patientId,@Param("newPassword")String newPassword);
	
	@Transactional
	@Modifying
	@Query("UPDATE PatientDetails a SET a.password =:newPassword  WHERE a.userName=:userName")
	int updateNewPasswordByUserName(@Param("userName")String userName,@Param("newPassword")String newPassword);
	
	
	@Query(value=" SELECT * FROM patient_details WHERE patient_id=:patientId",nativeQuery=true)
	PatientDetails getPatientDetailsBYId(@Param("patientId")int patientId);
	
	@Query(value=" SELECT p.l_name,p.f_name,p.m_name,p.birth_date,p.blood_group,p.gender,p.contact,p.email,c.city_name AS string1,p.patient_id,p.family_id," + 
			"p.address,p.reg_date,p.city_id,p.del_status,p.refferal_code," + 
			"p.age,p.int_1,p.int_2,p.string2,p.state_id,p.password,p.uname," + 
			"p.qualification,p.profile_photo,p.country_id FROM patient_details p, city c  WHERE patient_id=:patientId AND c.city_id=p.city_id",nativeQuery=true)
	PatientDetails getPatientDetailsWithCityNameById(@Param("patientId")int patientId);
 
	@Query(value=" SELECT * from patient_details where contact=:contactNo AND del_status=0",nativeQuery=true)
	PatientDetails getContactNumbers(@Param("contactNo")String contactNo);
	
	@Query(value=" SELECT * from patient_details where email=:email AND del_status=0",nativeQuery=true)
	PatientDetails getPatientEmail(@Param("email")String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE PatientDetails a SET a.string2 =:token, a.int1=:deviceType WHERE a.patientId=:patientId")
	int updatePatientTokenAsString2ByPatientId(@Param("patientId")int patientId,@Param("token")String token,@Param("deviceType")int deviceType);
	
	@Transactional
	@Modifying
	@Query("UPDATE PatientDetails a SET a.profilePhoto =:profilePhotoName  WHERE a.patientId=:patientId")
	int updatePatientProfile(@Param("patientId")int patientId,@Param("profilePhotoName")String profilePhotoName);
	
}

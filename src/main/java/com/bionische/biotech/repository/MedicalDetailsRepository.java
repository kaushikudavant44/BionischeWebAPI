package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.MedicalDetails;

public interface MedicalDetailsRepository extends JpaRepository<MedicalDetails, Integer>{

	MedicalDetails save(MedicalDetails medicalDetails);

	MedicalDetails findByUserNameAndPassword(String userName, String password);

	MedicalDetails findByMedicalId(int medicalId);
	
	@Query(value="SELECT m.medical_id,m.medical_name,m.address,m.contact ,m.city_id,m.state_id,m.country_id,m.licence_no,m.photo,m.del_status,m.owner,m.email,m.latitude,m.longitude,m.username,m.password,m.int_1,m.int_2,m.int_3,m.string1,m.string2,s.package_exp_date AS string3  FROM medical_details m,t_pharmacy_subscription_details s WHERE m.medical_id=:medicalId AND s.medical_id=:medicalId",nativeQuery=true)
	MedicalDetails getMedicalsDetailsByMedicalId(@Param("medicalId")int medicalId);
	
	MedicalDetails findByUserNameAndDelStatus(String uName, int i);
	
	@Query(value="SELECT m.medical_id,m.medical_name,m.address,m.contact ,m.city_id,m.state_id,m.country_id,m.licence_no,m.photo,m.del_status,m.owner,m.email,m.latitude,m.longitude,m.username,m.password,m.int_1,m.int_2,m.int_3,m.string1,m.string2,m.string3   FROM prescription_to_medical p,medical_details m,t_pharmacy_subscription_details ms WHERE p.patient_id=:patientId AND p.medical_id=m.medical_id AND ms.package_exp_date>=NOW() AND m.medical_id=ms.medical_id AND ms.txn_status=1 GROUP BY m.medical_id",nativeQuery=true)
	List<MedicalDetails> getMedicalsDetailsByPatient(@Param("patientId")int patientId);
	
	@Query(value="SELECT * FROM medical_details m,t_pharmacy_subscription_details ms WHERE m.int_3=:pincode and m.int_2=:deliveryStatus and m.del_status=0  AND ms.package_exp_date>=NOW() AND m.medical_id=ms.medical_id AND ms.txn_status=1",nativeQuery=true)
	List<MedicalDetails> getPharmacyByPincode(@Param("pincode")int pincode,@Param("deliveryStatus")int deliveryStatus);
	
	@Query(value=" SELECT * from medical_details where medical_id=:medicalId AND password=:password AND del_status=0",nativeQuery=true)
	MedicalDetails passwordMedValidation(@Param("medicalId")int medicalId,@Param("password")String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE MedicalDetails a SET a.password =:newPassword  WHERE a.medicalId=:medicalId")
	int updateNewPassword(@Param("medicalId")int medicalId,@Param("newPassword")String newPassword);
	
	@Transactional
	@Modifying
	@Query("UPDATE MedicalDetails a SET a.photo =:profilePhoto  WHERE a.medicalId=:medicalId")
	int updateProfilePic(@Param("medicalId")int medicalId,@Param("profilePhoto")String profilePhoto);
	
	@Transactional
	@Modifying
	@Query("UPDATE MedicalDetails a SET a.password =:newPassword  WHERE a.userName=:userName")
	int updateNewPasswordByUserName(@Param("userName")String userName,@Param("newPassword")String newPassword);
	
	
	@Query(value=" SELECT * from medical_details where contact=:contactNo AND del_status=0",nativeQuery=true)
	MedicalDetails getContactNumbers(@Param("contactNo")String contactNo);
	
	@Query(value=" SELECT * from medical_details where email=:email AND del_status=0",nativeQuery=true)
	MedicalDetails getPharmacyEmail(@Param("email")String email);

	@Transactional
	@Modifying
	@Query("UPDATE MedicalDetails a SET a.delStatus =:delStatus  WHERE a.medicalId=:medicalId")
	int updateMedicalDelStatus(@Param("medicalId")int medicalId,@Param("delStatus")int delStatus);
	
	@Query(value="SELECT m.* FROM medical_details m WHERE m.string3=:referal",nativeQuery=true)
	MedicalDetails findByString3(@Param("referal")String referal);
}

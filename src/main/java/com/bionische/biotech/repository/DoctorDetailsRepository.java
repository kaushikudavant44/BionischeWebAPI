package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorDetailsInformation;
import com.bionische.biotech.model.PatientDetails;

 

public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Long>{

	DoctorDetails save(DoctorDetails doctorDetails);
	
	DoctorDetails findByDoctorId(int doctorId);

	@Query(value=" SELECT * from doctor_details where uname=:userName AND del_status!=1",nativeQuery=true)
	DoctorDetails getLoginUserName(  @Param("userName") String userName);
	
	@Query(value=" SELECT d.* from doctor_details d, t_doctor_subscription_details s where d.spec_id=:specId AND d.city_id=:cityId AND d.del_status=0 AND d.doctor_id=s.doctor_id AND s.package_exp_date>=NOW() AND s.txn_status=1",nativeQuery=true)
	List<DoctorDetails> getBySpecIdAndCityIdAndDelStatus(@Param("specId")int specId, @Param("cityId")int cityId);
	
	@Query(value="SELECT * FROM doctor_details WHERE doctor_id IN (SELECT doctor_id FROM doctor_patient_meeting WHERE patient_id=:patientId)",nativeQuery=true)
	List<DoctorDetails> getDoctorDetailsByPatientId(@Param("patientId")int patientId);
	
	@Query(value="SELECT * FROM doctor_details WHERE doctor_id IN (SELECT doctor_id FROM doctor_appointment WHERE patient_id=:patientId)",nativeQuery=true)
	List<DoctorDetails> getDoctorsByPatientAppointment(@Param("patientId")int patientId);
	
	@Query(value=" SELECT * from doctor_details where doctor_id=:doctorId AND password=:password AND del_status=0",nativeQuery=true)
	DoctorDetails passwordDocValidation(@Param("doctorId")int patientId,@Param("password")String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorDetails a SET a.password =:newPassword  WHERE a.doctorId=:doctorId")
	int updateNewPassword(@Param("doctorId")int doctorId,@Param("newPassword")String newPassword);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorDetails a SET a.hospitalId =:hospitalId  WHERE a.doctorId=:doctorId")
	int updateHospitalId(@Param("doctorId")int doctorId,@Param("hospitalId")int hospitalId);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorDetails a SET a.profilePhoto =:profilePhotoName  WHERE a.doctorId=:doctorId")
	int updateDoctorPic(@Param("doctorId")int doctorId,@Param("profilePhotoName")String profilePhotoName);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorDetails a SET a.password =:newPassword  WHERE a.userName=:userName")
	int updateNewPasswordByuserName(@Param("userName")String userName,@Param("newPassword")String newPassword);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorDetails a SET a.delStatus =:delStatus  WHERE a.doctorId=:doctorId")
	int updateDoctorDelStatus(@Param("doctorId")int doctorId,@Param("delStatus")int delStatus);
	
	@Query(value="SELECT * FROM doctor_details WHERE contact=:contactNo AND del_status=0;",nativeQuery=true)
	DoctorDetails getContactNumbers(@Param("contactNo") String contactNo);
	
	@Query(value="SELECT * FROM doctor_details WHERE email=:email AND del_status=0;",nativeQuery=true)
	DoctorDetails getDoctorEmail(@Param("email") String email);
	
	@Query(value=" SELECT doctor_id from doctor_appointment where appoint_id=:appointId",nativeQuery=true)
	int getDoctorId( @Param("appointId")int appointId);
	
	
	
}

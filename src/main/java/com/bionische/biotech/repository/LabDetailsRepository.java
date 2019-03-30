 package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.SpecializationDetails;



public interface LabDetailsRepository extends JpaRepository<LabDetails, Integer>{

	
	LabDetails findByLabIdAndDelStatus(int labId, int delStatus);
	LabDetails save(LabDetails labDetails);
    LabDetails findByLabId(int labId);
    
    LabDetails findByUserNameAndDelStatus(String userName, int delStatus);
    
    @Query(value=" SELECT * from lab_details where user_name=:userName AND del_status!=1",nativeQuery=true)
	LabDetails getLoginByUserName(@Param("userName")String userName);

	
	@Query(value=" SELECT l.* from lab_details l, t_lab_subscription_details ls where l.city_id=:cityId AND l.del_status=0 AND ls.package_exp_date>=NOW() AND l.lab_id=ls.lab_id AND ls.txn_status=1",nativeQuery=true)
	List<LabDetails> getByCityIdAndDelStatus(@Param("cityId")int cityId);
	
	List<LabDetails> findByDelStatus(int delStatus);
	 

	@Query(value=" SELECT l.* from lab_details l, t_lab_subscription_details ls where l.city_id=:cityId AND l.tests_types LIKE :testId AND l.del_status=0  AND l.del_status=0 AND ls.package_exp_date>=NOW() AND l.lab_id=ls.lab_id AND ls.txn_status=1",nativeQuery=true)

	List<LabDetails> getByCityIdAndTestIdAndDelStatus(@Param("cityId")int cityId, @Param("testId")String testId);
	
	
	@Query(value=" SELECT * from lab_details where lab_id=:labId",nativeQuery=true)
	LabDetails getLabDetailsById(@Param("labId")int labId);
	
	@Query(value=" SELECT * from lab_details where lab_id=:labId AND password=:password AND del_status=0",nativeQuery=true)
	LabDetails passwordLabValidation(@Param("labId")int labId,@Param("password")String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabDetails a SET a.password =:newPassword  WHERE a.labId=:labId")
	int updateNewPassword(@Param("labId")int labId,@Param("newPassword")String newPassword);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabDetails SET teststypes=CONCAT(teststypes,:testId) WHERE labId=:labId")
	int updateLabTest(@Param("testId")String testId,@Param("labId")int labId);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabDetails SET teststypes=:tests WHERE labId=:labId")
	int updateLabTestAfterDelete(@Param("tests")String tests,@Param("labId")int labId);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabDetails SET photo=:profilePhoto WHERE labId=:labId")
	int updateLabProfilePic(@Param("labId")int labId,@Param("profilePhoto")String profilePhoto);

	@Transactional
	@Modifying
	@Query("UPDATE LabDetails a SET a.password =:newPassword  WHERE a.userName=:userName")
	int updateNewPasswordByUserName(@Param("userName")String userName,@Param("newPassword")String newPassword);
	
	@Query(value=" SELECT * from lab_details where contact=:contactNo AND del_status=0",nativeQuery=true)
	LabDetails getContactNumbers(@Param("contactNo")String contactNo);
	
	@Query(value=" SELECT * from lab_details where email=:email AND del_status=0",nativeQuery=true)
	LabDetails getLabEmail(@Param("email")String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabDetails a SET a.delStatus =:delStatus  WHERE a.labId=:labId")
	int updateLabDelStatus(@Param("labId")int labId, @Param("delStatus")int delStatus);
	
	@Query(value="SELECT l.* FROM lab_details l WHERE l.string3=:referal",nativeQuery=true)
	LabDetails findByString3(@Param("referal")String referal);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabDetails a SET a.token =:token  WHERE a.labId=:labId")
	int updateLabToken(@Param("labId")int labId, @Param("token")String token);
}

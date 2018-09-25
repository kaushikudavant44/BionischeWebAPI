 package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.SpecializationDetails;



public interface LabDetailsRepository extends JpaRepository<LabDetails, Integer>{

	
	LabDetails findByLabIdAndDelStatus(int labId, int delStatus);
	LabDetails save(LabDetails labDetails);
    LabDetails findByLabId(int labId);
    
    LabDetails findByUserNameAndDelStatus(String userName, int delStatus);

	
	@Query(value=" SELECT * from lab_details where city_id=:cityId AND del_status=0",nativeQuery=true)
	List<LabDetails> getByCityIdAndDelStatus(@Param("cityId")int cityId);
	
	List<LabDetails> findByDelStatus(int delStatus);
	 

	@Query(value=" SELECT * from lab_details where city_id=:cityId AND tests_types LIKE :testId AND del_status=0 ",nativeQuery=true)

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
}

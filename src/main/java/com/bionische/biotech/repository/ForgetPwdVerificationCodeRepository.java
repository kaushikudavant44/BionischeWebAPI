package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.ForgetPwdVerificationCode;

public interface ForgetPwdVerificationCodeRepository extends JpaRepository<ForgetPwdVerificationCode, Integer> {
	
	ForgetPwdVerificationCode  save(ForgetPwdVerificationCode forgetPwdVerificationCode);
	
	@Query(value=" SELECT * from forgetpwd_verification_code where user_name=:userName AND type=:type",nativeQuery=true)
	ForgetPwdVerificationCode getCodeDetailsByUserName(@Param("userName")String userName, @Param("type")int type);

}

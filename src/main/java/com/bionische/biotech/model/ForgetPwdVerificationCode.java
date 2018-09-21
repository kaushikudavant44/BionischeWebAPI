package com.bionische.biotech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="forgetpwd_verification_code")
@EntityListeners(AuditingEntityListener.class)

public class ForgetPwdVerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="verification_code_id")
	private int verificationCodeId;
	
	@Column(name="type")
	private int type;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name = "time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date time;
	
	@Column(name="code")
	private String code;
	

	public int getVerificationCodeId() {
		return verificationCodeId;
	}

	public void setVerificationCodeId(int verificationCodeId) {
		this.verificationCodeId = verificationCodeId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getTime() {
		return time;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ForgetPwdVerificationCode [verificationCodeId=" + verificationCodeId + ", type=" + type + ", userName="
				+ userName + ", time=" + time + ", code=" + code + "]";
	}

	

}

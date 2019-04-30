package com.bionische.biotech.ewallet.model;

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

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="m_wallet_details")
@EntityListeners(AuditingEntityListener.class)
public class WalletDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wallet_id")
	int walletId;
	
	@Column(name = "user_id")
	int userId;
	
	//0=doctor;
	//1=patient;
	//2=lab;
	//3=pharmacy
	@Column(name = "user_type")
	int userType;
	
	@Column(name = "wallet_amount")
	float walletAmount;
	
	@Column(name="created_date",updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name="last_modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date lastModifiedDate;
	
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss", timezone="GMT+5:30")
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public float getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(float walletAmount) {
		this.walletAmount = walletAmount;
	}

	@Override
	public String toString() {
		return "WalletDetails [walletId=" + walletId + ", userId=" + userId + ", userType=" + userType
				+ ", walletAmount=" + walletAmount + ", createDate=" + createDate + ", lastModifiedDate="
				+ lastModifiedDate + "]";
	}




	
	
}

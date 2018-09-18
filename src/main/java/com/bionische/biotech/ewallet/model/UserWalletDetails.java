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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="user_e_wallet")
@EntityListeners(AuditingEntityListener.class)
public class UserWalletDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_wallet_id")
	private int userWalletId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_type")
	private int userType;
	
	@Column(name="promo_balance")
	private float promoBalance;

	@Column(name="balance")
	private float balance;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	/** Last modified date */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name="del_status")
	private int delStatus;
	
	public int getUserWalletId() {
		return userWalletId;
	}

	public void setUserWalletId(int userWalletId) {
		this.userWalletId = userWalletId;
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

	public float getPromoBalance() {
		return promoBalance;
	}

	public void setPromoBalance(float promoBalance) {
		this.promoBalance = promoBalance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Date getCreateDate() {
		return createDate;
	}

 

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	 

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "UserWalletDetails [userWalletId=" + userWalletId + ", userId=" + userId + ", userType=" + userType
				+ ", promoBalance=" + promoBalance + ", balance=" + balance + ", createDate=" + createDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", delStatus=" + delStatus + "]";
	}

	 
	
	
}

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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
 @EntityListeners(AuditingEntityListener.class)
public class GetWalletTransactionDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private long transactionId;
	
	@Column(name = "txn_type")
	private int txnType;
	
	
	@Column(name="user_id")
	private int userId;
	
	
	@Column(name="user_type")
	private int userType;

	@Column(name = "from_to")
	private int fromTo;
	
	 
	@Column(name = "from_to_name")
	private String fromToName;
	


	@Column(name = "from_to_user_type")
	private int fromToUserType;
	
	@Column(name = "amount")
	private float amount;
	
	
	@Column(name = "date_time")
	private String dateTime;

	@Column(name = "amount_type")
	private int amountType;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "status")
	private int status;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public int getTxnType() {
		return txnType;
	}

	public void setTxnType(int txnType) {
		this.txnType = txnType;
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

	public int getFromTo() {
		return fromTo;
	}

	public void setFromTo(int fromTo) {
		this.fromTo = fromTo;
	}

	public String getFromToName() {
		return fromToName;
	}

	public void setFromToName(String fromToName) {
		this.fromToName = fromToName;
	}

	public int getFromToUserType() {
		return fromToUserType;
	}

	public void setFromToUserType(int fromToUserType) {
		this.fromToUserType = fromToUserType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	 

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getAmountType() {
		return amountType;
	}

	public void setAmountType(int amountType) {
		this.amountType = amountType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GetWalletTransactionDetails [transactionId=" + transactionId + ", txnType=" + txnType + ", userId="
				+ userId + ", userType=" + userType + ", fromTo=" + fromTo + ", fromToName=" + fromToName
				+ ", fromToUserType=" + fromToUserType + ", amount=" + amount + ", dateTime=" + dateTime
				+ ", amountType=" + amountType + ", comment=" + comment + ", status=" + status + "]";
	}

	
	
}

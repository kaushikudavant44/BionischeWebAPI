package com.bionische.biotech.ewallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="t_bank_transfer_request")
@EntityListeners(AuditingEntityListener.class)
public class BankTransferRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id")
	private int requestId;
	
	@Column(name = "request_amount")
	private float requestAmount;
	
	@Column(name = "wallet_id")
	private int walletId;
	
	@Column(name = "user_type")
	private int userType;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "transaction_type")
	private int transactionType;
	
	@Column(name = "entry_by")
	private int entryBy;
	
	@Column(name = "user_id")
	private int userId;

	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public float getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(float requestAmount) {
		this.requestAmount = requestAmount;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public int getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(int entryBy) {
		this.entryBy = entryBy;
	}

	@Override
	public String toString() {
		return "BankTransferRequest [requestId=" + requestId + ", requestAmount=" + requestAmount + ", walletId="
				+ walletId + ", userType=" + userType + ", status=" + status + ", transactionId=" + transactionId
				+ ", transactionType=" + transactionType + ", entryBy=" + entryBy + ", userId=" + userId + "]";
	}

	

	
	
	
	
}

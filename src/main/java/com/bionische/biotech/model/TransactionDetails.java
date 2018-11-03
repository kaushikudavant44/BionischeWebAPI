package com.bionische.biotech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="transaction")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transactionId;
	
	@Column(name="user_type")
	private int userType;

	@Column(name="from_user_id")
	private int fromUserId;
	
	@Column(name="to_user_id")
	private int toUserId;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	@Column(name="amount_type")
	private int amountType;
	
	@Column(name="status")
	private int status;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="totalAmount")
	private int totalAmount;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string_1")
	private String string1;
	
	@Column(name="report_id")
	private int reportId;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getAmountType() {
		return amountType;
	}

	public void setAmountType(int amountType) {
		this.amountType = amountType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", userType=" + userType + ", fromUserId="
				+ fromUserId + ", toUserId=" + toUserId + ", createdDate=" + createdDate + ", amountType=" + amountType
				+ ", status=" + status + ", amount=" + amount + ", discount=" + discount + ", totalAmount="
				+ totalAmount + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", reportId=" + reportId
				+ "]";
	}

	
	
	
	
}

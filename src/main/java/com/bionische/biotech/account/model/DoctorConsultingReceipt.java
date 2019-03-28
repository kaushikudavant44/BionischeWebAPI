package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="t_doctor_consulting_receipt")
public class DoctorConsultingReceipt {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="receipt_no")
	private int receiptNo;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="tot_amount")
	private float totAmount;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name = "date")
	private String date;
 
	@Column(name="from_date")
	private String fromDate;
	
	@Column(name="to_date")
	private String toDate;

	@Column(name="paid_amt")
	private float paidAmt;
	
	@Column(name="commission_amt")
	private float commissionAmt;
	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
 

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getDate() {
		return DateConverter.convertToDMY(date);
	}

	public void setDate(String date) {
		this.date = date;
	}

 

	public String getFromDate() {
		return DateConverter.convertToDMY(fromDate);
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return DateConverter.convertToDMY(toDate);
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public float getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(float totAmount) {
		this.totAmount = totAmount;
	}

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}

	public float getCommissionAmt() {
		return commissionAmt;
	}

	public void setCommissionAmt(float commissionAmt) {
		this.commissionAmt = commissionAmt;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "DoctorConsultingReceipt [receiptNo=" + receiptNo + ", doctorId=" + doctorId + ", createdDate="
				+ createdDate + ", totAmount=" + totAmount + ", txnId=" + txnId + ", date=" + date + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", paidAmt=" + paidAmt + ", commissionAmt=" + commissionAmt + "]";
	}

	 

	 

	 
	
	
}

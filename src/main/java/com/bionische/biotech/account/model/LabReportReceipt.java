package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_lab_report_receipt")
public class LabReportReceipt {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="receipt_no")
	private int receiptNo;
	
	@Column(name="lab_id")
	private int labId;
	
	
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

	public int getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public float getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(float totAmount) {
		this.totAmount = totAmount;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
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

	@Override
	public String toString() {
		return "LabReportReceipt [receiptNo=" + receiptNo + ", labId=" + labId + ", createdDate=" + createdDate
				+ ", totAmount=" + totAmount + ", txnId=" + txnId + ", date=" + date + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", paidAmt=" + paidAmt + ", commissionAmt=" + commissionAmt + "]";
	}
	
	
	
}

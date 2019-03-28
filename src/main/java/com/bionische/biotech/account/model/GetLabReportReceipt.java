package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
 
public class GetLabReportReceipt {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="receipt_no")
	private int receiptNo;
	
	@Column(name="lab_id")
	private int labId;
	
	@Column(name="lab_name")
	private String labName;
	
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
	
	@Column(name="company_gst_no")
	private String companyGstNo;
	
	@Column(name="gst_no")
	private String gstNo;
	
	@Column(name="contact_no1")
	private String contactNo1;
	
	@Column(name="contact_no2")
	private String contactNo2;
	
	@Column(name="email")
	private String email;
	
	@Column(name="website")
	private String website;
	
	@Column(name="address")
	private String address;
	 
	@Column(name="company_name")
	private String companyName;

	
	 

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
		return DateConverter.convertToDMY(createdDate);
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCompanyGstNo() {
		return companyGstNo;
	}

	public void setCompanyGstNo(String companyGstNo) {
		this.companyGstNo = companyGstNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	 
	 

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	@Override
	public String toString() {
		return "GetLabReportReceipt [receiptNo=" + receiptNo + ", labId=" + labId + ", labName=" + labName
				+ ", createdDate=" + createdDate + ", totAmount=" + totAmount + ", txnId=" + txnId + ", date=" + date
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", paidAmt=" + paidAmt + ", commissionAmt="
				+ commissionAmt + ", companyGstNo=" + companyGstNo + ", gstNo=" + gstNo + ", contactNo1=" + contactNo1
				+ ", contactNo2=" + contactNo2 + ", email=" + email + ", website=" + website + ", address=" + address
				+ ", companyName=" + companyName + "]";
	}

	 
	
	
}

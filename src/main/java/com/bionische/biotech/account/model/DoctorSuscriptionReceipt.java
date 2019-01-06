package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
 
public class DoctorSuscriptionReceipt {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="suscription_id")
	private int suscriptionId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="order_id")
	private String orderId;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name="package_amt")
	private float packageAmt;
	
	 
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
	 
	@Column(name="Company_name")
	private String CompanyName;

	public int getSuscriptionId() {
		return suscriptionId;
	}

	public void setSuscriptionId(int suscriptionId) {
		this.suscriptionId = suscriptionId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public float getPackageAmt() {
		return packageAmt;
	}

	public void setPackageAmt(float packageAmt) {
		this.packageAmt = packageAmt;
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
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	@Override
	public String toString() {
		return "DoctorSuscriptionReceipt [suscriptionId=" + suscriptionId + ", doctorId=" + doctorId + ", amount="
				+ amount + ", orderId=" + orderId + ", createdDate=" + createdDate + ", txnId=" + txnId
				+ ", packageAmt=" + packageAmt + ", companyGstNo=" + companyGstNo + ", gstNo=" + gstNo + ", contactNo1="
				+ contactNo1 + ", contactNo2=" + contactNo2 + ", email=" + email + ", website=" + website + ", address="
				+ address + ", CompanyName=" + CompanyName + "]";
	}
	
	
	
}

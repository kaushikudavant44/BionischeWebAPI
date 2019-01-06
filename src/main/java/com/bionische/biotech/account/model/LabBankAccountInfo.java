package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lab_bank_info")
public class LabBankAccountInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="lab_id")
	private int labId;
	
	@Column(name="account_no")
	private String accountNo;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_branch")
	private String bankBranch;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="acc_holder_name")
	private String accHolderName;
	
	@Column(name="pan_no")
	private String panNo;
	
	@Column(name="gst_no")
	private String gstNo;
	
	@Column(name="del_status")
	private int delStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 
	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "LabBankAccountInfo [id=" + id + ", labId=" + labId + ", accountNo=" + accountNo + ", bankName="
				+ bankName + ", bankBranch=" + bankBranch + ", ifscCode=" + ifscCode + ", accHolderName="
				+ accHolderName + ", panNo=" + panNo + ", gstNo=" + gstNo + ", delStatus=" + delStatus + "]";
	}

	 
	
}

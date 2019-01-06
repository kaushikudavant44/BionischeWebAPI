package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_bionische_company_info")
public class BionischeCompanyInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="Company_name")
	private String CompanyName;
	
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

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
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

	@Override
	public String toString() {
		return "BionischeCompanyInfo [id=" + id + ", CompanyName=" + CompanyName + ", contactNo1=" + contactNo1
				+ ", contactNo2=" + contactNo2 + ", email=" + email + ", website=" + website + ", address=" + address
				+ ", panNo=" + panNo + ", gstNo=" + gstNo + ", delStatus=" + delStatus + "]";
	}

	 
	 
	
	
	
}

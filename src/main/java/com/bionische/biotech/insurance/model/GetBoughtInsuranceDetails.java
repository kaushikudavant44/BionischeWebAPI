package com.bionische.biotech.insurance.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;



@Entity
public class GetBoughtInsuranceDetails {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insu_reg_id")
	private int registrationId;
	@Column(name="registration_date")
	private String regDate;
	@Column(name="dueDate")
	private String dueDate;
	@Column(name="insu_premium")
	private  int premium;
	@Column(name="comp_id")
	private int companyId;
	@Column(name="Insurance_company_name")
	private String companyName;
	@Column(name="no_of_adult")
	private int noOfAdult;
	@Column(name="no_of_child")
	private int noOfChild;
	@Column(name="insu_cover")
	private int cover;
	@Column(name="app_status")
	private String status;
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	@Column(name="string1")
	private String string1;
	@Column(name="string2")
	private String string2;
	
	
	@Transient
	List<AdultMember> AdultMemberList;
	@Transient
	List<ChildMemberDetails> ChildMemberList;
	
	
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getNoOfAdult() {
		return noOfAdult;
	}
	public void setNoOfAdult(int noOfAdult) {
		this.noOfAdult = noOfAdult;
	}
	public int getNoOfChild() {
		return noOfChild;
	}
	public void setNoOfChild(int noOfChild) {
		this.noOfChild = noOfChild;
	}
	public int getCover() {
		return cover;
	}
	public void setCover(int cover) {
		this.cover = cover;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	public List<AdultMember> getAdultMemberList() {
		return AdultMemberList;
	}
	public void setAdultMemberList(List<AdultMember> adultMemberList) {
		AdultMemberList = adultMemberList;
	}
	public List<ChildMemberDetails> getChildMemberList() {
		return ChildMemberList;
	}
	public void setChildMemberList(List<ChildMemberDetails> childMemberList) {
		ChildMemberList = childMemberList;
	}
	@Override
	public String toString() {
		return "GetBoughtInsuranceDetails [registrationId=" + registrationId + ", regDate=" + regDate + ", dueDate="
				+ dueDate + ", premium=" + premium + ", companyId=" + companyId + ", companyName=" + companyName
				+ ", noOfAdult=" + noOfAdult + ", noOfChild=" + noOfChild + ", cover=" + cover + ", status=" + status
				+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2
				+ ", AdultMemberList=" + AdultMemberList + ", ChildMemberList=" + ChildMemberList + "]";
	}
	
	
	 
	
}

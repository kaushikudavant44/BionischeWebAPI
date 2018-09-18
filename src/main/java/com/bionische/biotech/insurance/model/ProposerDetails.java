package com.bionische.biotech.insurance.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="insurance_registration_details ")
public class ProposerDetails {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insu_reg_id")
	private int insuRegistrationId;
	
	@Column(name="comp_id")
	private int companyId;
	
	@Column(name="family_id")
	private int familyId;
	
	@Column(name="proposer_m_name")
	private String proposerMiddleName;
	
	@Column(name="no_of_adult")
	private int noOfAdult;
	
	@Column(name="no_of_child")
	private int noOfChildren;
	
	@Column(name="eldest_mem_age")
	private int eldestMemberAge;
	
	@Column(name="insu_cover")
	private int cover;
	
	@Column(name="insu_premium")
	private int premium;		
	
	@Column(name="mobile_no")
	private String proposerContactNo;
	
	@Column(name="email")
	private String proposerEmailId;
	
	@Column(name="proposer_f_name")
	private String proposerFirstName;
	
	@Column(name="proposer_l_name")
	private String proposerLastName;
	
	@Column(name="proposer_dob")
	private String proposerDob;
	
	@Column(name="pan_no")
	private String proposerPanNo;
	
	@Column(name="adhar_no")
	private String proposerAdharNo;
	
	@Column(name="annual_income")
	private int proposerAnualIncome;
	
	@Column(name="temp_address")
	private String proposerTempAddress;
	
	@Column(name="country_id")
	private int proposerCountryId;
	
	@Column(name="state_id")
	private int proposerStateId;
	
	@Column(name="city_id")
	private int proposerCityId;
	
	@Column(name="pin_code")
	private int proposerPincode;
	
	@Column(name="permanant_address")
	private String proposerPermanentAddress;
	
	@Column(name="permanant_state_id")
	private int proposerPermanentStateId;
	
	@Column(name="permanant_city_id")
	private int proposerPermanentCityId;
	
	@Column(name="permanant_pin_code")
	private int proposerPermanentPinCode;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string1")
	private String string1;
	
	@Column(name="string2")
	private String string2;
	
	@Column(name="no_of_years")
	private int noOfYears;
	
	@Column(name="app_status")
	private int appStatus;
	
	@Column(name="registration_date")
	private String regDate;
	
	@Column(name="due_date")
	private String dueDate;
	
	
	@Transient
	List<AdultMember> adultMemberList;
	
	@Transient
	List<ChildMemberDetails> childMemberDetailsList;
	
	

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getInsuRegistrationId() {
		return insuRegistrationId;
	}

	public void setInsuRegistrationId(int insuRegistrationId) {
		this.insuRegistrationId = insuRegistrationId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public String getProposerMiddleName() {
		return proposerMiddleName;
	}

	public void setProposerMiddleName(String proposerMiddleName) {
		this.proposerMiddleName = proposerMiddleName;
	}

	public int getNoOfAdult() {
		return noOfAdult;
	}

	public void setNoOfAdult(int noOfAdult) {
		this.noOfAdult = noOfAdult;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public int getEldestMemberAge() {
		return eldestMemberAge;
	}

	public void setEldestMemberAge(int eldestMemberAge) {
		this.eldestMemberAge = eldestMemberAge;
	}

	public int getCover() {
		return cover;
	}

	public void setCover(int cover) {
		this.cover = cover;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public String getProposerContactNo() {
		return proposerContactNo;
	}

	public void setProposerContactNo(String proposerContactNo) {
		this.proposerContactNo = proposerContactNo;
	}

	public String getProposerEmailId() {
		return proposerEmailId;
	}

	public void setProposerEmailId(String proposerEmailId) {
		this.proposerEmailId = proposerEmailId;
	}

	public String getProposerFirstName() {
		return proposerFirstName;
	}

	public void setProposerFirstName(String proposerFirstName) {
		this.proposerFirstName = proposerFirstName;
	}

	public String getProposerLastName() {
		return proposerLastName;
	}

	public void setProposerLastName(String proposerLastName) {
		this.proposerLastName = proposerLastName;
	}

	public String getProposerDob() {
		return proposerDob;
	}

	public void setProposerDob(String proposerDob) {
		this.proposerDob = proposerDob;
	}

	public String getProposerPanNo() {
		return proposerPanNo;
	}

	public void setProposerPanNo(String proposerPanNo) {
		this.proposerPanNo = proposerPanNo;
	}

	public String getProposerAdharNo() {
		return proposerAdharNo;
	}

	public void setProposerAdharNo(String proposerAdharNo) {
		this.proposerAdharNo = proposerAdharNo;
	}

	public int getProposerAnualIncome() {
		return proposerAnualIncome;
	}

	public void setProposerAnualIncome(int proposerAnualIncome) {
		this.proposerAnualIncome = proposerAnualIncome;
	}

	public String getProposerTempAddress() {
		return proposerTempAddress;
	}

	public void setProposerTempAddress(String proposerTempAddress) {
		this.proposerTempAddress = proposerTempAddress;
	}

	public int getProposerCountryId() {
		return proposerCountryId;
	}

	public void setProposerCountryId(int proposerCountryId) {
		this.proposerCountryId = proposerCountryId;
	}

	public int getProposerStateId() {
		return proposerStateId;
	}

	public void setProposerStateId(int proposerStateId) {
		this.proposerStateId = proposerStateId;
	}

	public int getProposerCityId() {
		return proposerCityId;
	}

	public void setProposerCityId(int proposerCityId) {
		this.proposerCityId = proposerCityId;
	}

	public int getProposerPincode() {
		return proposerPincode;
	}

	public void setProposerPincode(int proposerPincode) {
		this.proposerPincode = proposerPincode;
	}

	public String getProposerPermanentAddress() {
		return proposerPermanentAddress;
	}

	public void setProposerPermanentAddress(String proposerPermanentAddress) {
		this.proposerPermanentAddress = proposerPermanentAddress;
	}

	public int getProposerPermanentStateId() {
		return proposerPermanentStateId;
	}

	public void setProposerPermanentStateId(int proposerPermanentStateId) {
		this.proposerPermanentStateId = proposerPermanentStateId;
	}

	public int getProposerPermanentCityId() {
		return proposerPermanentCityId;
	}

	public void setProposerPermanentCityId(int proposerPermanentCityId) {
		this.proposerPermanentCityId = proposerPermanentCityId;
	}

	public int getProposerPermanentPinCode() {
		return proposerPermanentPinCode;
	}

	public void setProposerPermanentPinCode(int proposerPermanentPinCode) {
		this.proposerPermanentPinCode = proposerPermanentPinCode;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public int getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(int appStatus) {
		this.appStatus = appStatus;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public List<AdultMember> getAdultMemberList() {
		return adultMemberList;
	}

	public void setAdultMemberList(List<AdultMember> adultMemberList) {
		this.adultMemberList = adultMemberList;
	}

	public List<ChildMemberDetails> getChildMemberDetailsList() {
		return childMemberDetailsList;
	}

	public void setChildMemberDetailsList(List<ChildMemberDetails> childMemberDetailsList) {
		this.childMemberDetailsList = childMemberDetailsList;
	}

	@Override
	public String toString() {
		return "ProposerDetails [insuRegistrationId=" + insuRegistrationId + ", companyId=" + companyId + ", familyId="
				+ familyId + ", proposerMiddleName=" + proposerMiddleName + ", noOfAdult=" + noOfAdult
				+ ", noOfChildren=" + noOfChildren + ", eldestMemberAge=" + eldestMemberAge + ", cover=" + cover
				+ ", premium=" + premium + ", proposerContactNo=" + proposerContactNo + ", proposerEmailId="
				+ proposerEmailId + ", proposerFirstName=" + proposerFirstName + ", proposerLastName="
				+ proposerLastName + ", proposerDob=" + proposerDob + ", proposerPanNo=" + proposerPanNo
				+ ", proposerAdharNo=" + proposerAdharNo + ", proposerAnualIncome=" + proposerAnualIncome
				+ ", proposerTempAddress=" + proposerTempAddress + ", proposerCountryId=" + proposerCountryId
				+ ", proposerStateId=" + proposerStateId + ", proposerCityId=" + proposerCityId + ", proposerPincode="
				+ proposerPincode + ", proposerPermanentAddress=" + proposerPermanentAddress
				+ ", proposerPermanentStateId=" + proposerPermanentStateId + ", proposerPermanentCityId="
				+ proposerPermanentCityId + ", proposerPermanentPinCode=" + proposerPermanentPinCode + ", delStatus="
				+ delStatus + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2
				+ ", noOfYears=" + noOfYears + ", appStatus=" + appStatus + ", regDate=" + regDate
				+ ", adultMemberList=" + adultMemberList + ", childMemberDetailsList=" + childMemberDetailsList + "]";
	}

	 
	
}

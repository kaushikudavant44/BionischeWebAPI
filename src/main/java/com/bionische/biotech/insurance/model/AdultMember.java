package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_adult_member_details ")
public class AdultMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="adult_memb_id")
	private int adultMemberId;
	
	@Column(name="insu_reg_id")
	private int insuRegistrationId;
	
	@Column(name="adult_memb_fname")
	private String adultFirstName;
	
	@Column(name="adult_memb_mname")
	private String adultMiddleName;
	
	@Column(name="adult_memb_lname")
	private String adultLastName;
	
	@Column(name="gender")
	private String adultGender;
	
	@Column(name="relation_with_proposer")
	private String proposerRelation;
	
	@Column(name="occupation")
	private String adultOccupation;
	
	@Column(name="dob")
	private String adultDob;
	
	@Column(name="height")
	private float adultHeight;
	
	@Column(name="weight")
	private float adultWeight;
	
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
	
	@Column(name="policy_no")
	private int policyNo;
	
	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public int getAdultMemberId() {
		return adultMemberId;
	}

	public void setAdultMemberId(int adultMemberId) {
		this.adultMemberId = adultMemberId;
	}

	public int getInsuRegistrationId() {
		return insuRegistrationId;
	}

	public void setInsuRegistrationId(int insuRegistrationId) {
		this.insuRegistrationId = insuRegistrationId;
	}

	public String getAdultFirstName() {
		return adultFirstName;
	}

	public void setAdultFirstName(String adultFirstName) {
		this.adultFirstName = adultFirstName;
	}

	public String getAdultMiddleName() {
		return adultMiddleName;
	}

	public void setAdultMiddleName(String adultMiddleName) {
		this.adultMiddleName = adultMiddleName;
	}

	public String getAdultLastName() {
		return adultLastName;
	}

	public void setAdultLastName(String adultLastName) {
		this.adultLastName = adultLastName;
	}

	public String getAdultGender() {
		return adultGender;
	}

	public void setAdultGender(String adultGender) {
		this.adultGender = adultGender;
	}

	public String getProposerRelation() {
		return proposerRelation;
	}

	public void setProposerRelation(String proposerRelation) {
		this.proposerRelation = proposerRelation;
	}

	public String getAdultOccupation() {
		return adultOccupation;
	}

	public void setAdultOccupation(String adultOccupation) {
		this.adultOccupation = adultOccupation;
	}

	public String getAdultDob() {
		return adultDob;
	}

	public void setAdultDob(String adultDob) {
		this.adultDob = adultDob;
	}

	public float getAdultHeight() {
		return adultHeight;
	}

	public void setAdultHeight(float adultHeight) {
		this.adultHeight = adultHeight;
	}

	public float getAdultWeight() {
		return adultWeight;
	}

	public void setAdultWeight(float adultWeight) {
		this.adultWeight = adultWeight;
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

	@Override
	public String toString() {
		return "AdultMember [adultMemberId=" + adultMemberId + ", insuRegistrationId=" + insuRegistrationId
				+ ", adultFirstName=" + adultFirstName + ", adultMiddleName=" + adultMiddleName + ", adultLastName="
				+ adultLastName + ", adultGender=" + adultGender + ", proposerRelation=" + proposerRelation
				+ ", adultOccupation=" + adultOccupation + ", adultDob=" + adultDob + ", adultHeight=" + adultHeight
				+ ", adultWeight=" + adultWeight + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2
				+ ", string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	
	
	
}

package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_members_type")

public class MembersType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="members_type_id")
    private int membersTypeId;
	
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="members_type")
	private String membersType;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="float_1")
	private float float1;
	 
	@Column(name="float_2")
	private float float2;
	
	@Column(name="string_1")
	private String string1;
	
	@Column(name="string_2")
	private String string2;

	public int getMembersTypeId() {
		return membersTypeId;
	}

	public void setMembersTypeId(int membersTypeId) {
		this.membersTypeId = membersTypeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getMembersType() {
		return membersType;
	}

	public void setMembersType(String membersType) {
		this.membersType = membersType;
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

	public float getFloat1() {
		return float1;
	}

	public void setFloat1(float float1) {
		this.float1 = float1;
	}

	public float getFloat2() {
		return float2;
	}

	public void setFloat2(float float2) {
		this.float2 = float2;
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
		return "MembersType [membersTypeId=" + membersTypeId + ", companyId=" + companyId + ", membersType="
				+ membersType + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", float1=" + float1
				+ ", float2=" + float2 + ", string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	
	
	
	
	
	
}

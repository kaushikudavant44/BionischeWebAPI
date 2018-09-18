package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_cover")
public class InsuranceCover {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insurance_cover_id")
	private int insuranceCoverId;
	@Column(name="insurance_company_id")
	private int insuranceCompanyId;
	@Column(name="cover_amount")
	private int coverAmount;
	@Column(name="float_1")
	private float float1;
	@Column(name="float_2")
	private float float2;
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	@Column(name="string1")
	private String string1;
	@Column(name="string2")
	private String String2;
	@Column(name="del_status")
	private int delStatus;
	public int getInsuranceCoverId() {
		return insuranceCoverId;
	}
	public void setInsuranceCoverId(int insuranceCoverId) {
		this.insuranceCoverId = insuranceCoverId;
	}
	public int getInsuranceCompanyId() {
		return insuranceCompanyId;
	}
	public void setInsuranceCompanyId(int insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}
	public int getCoverAmount() {
		return coverAmount;
	}
	public void setCoverAmount(int coverAmount) {
		this.coverAmount = coverAmount;
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
		return String2;
	}
	public void setString2(String string2) {
		String2 = string2;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@Override
	public String toString() {
		return "InsuranceCover [insuranceCoverId=" + insuranceCoverId + ", insuranceCompanyId=" + insuranceCompanyId
				+ ", coverAmount=" + coverAmount + ", float1=" + float1 + ", float2=" + float2 + ", int1=" + int1
				+ ", int2=" + int2 + ", string1=" + string1 + ", String2=" + String2 + ", delStatus=" + delStatus + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}

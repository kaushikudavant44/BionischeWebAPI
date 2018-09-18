package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_premium_table")
public class InsurancePremium {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="premium_id")
	private int insurancePremiumId;
	
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="cover")
	private int cover;
	
	@Column(name="family")
	private String family;
	
	@Column(name="age")
	private String age;
	
	@Column(name="premium")
	private int premium;
	
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
	
	@Column(name="del_status")
	private int delStatus;

	public int getInsurancePremiumId() {
		return insurancePremiumId;
	}

	public void setInsurancePremiumId(int insurancePremiumId) {
		this.insurancePremiumId = insurancePremiumId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCover() {
		return cover;
	}

	public void setCover(int cover) {
		this.cover = cover;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "InsurancePremium [insurancePremiumId=" + insurancePremiumId + ", companyId=" + companyId + ", cover="
				+ cover + ", family=" + family + ", age=" + age + ", premium=" + premium + ", int1=" + int1 + ", int2="
				+ int2 + ", float1=" + float1 + ", float2=" + float2 + ", string1=" + string1 + ", string2=" + string2
				+ ", delStatus=" + delStatus + "]";
	}
	
	

}

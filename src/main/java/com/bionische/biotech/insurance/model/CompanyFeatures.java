package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_company_feature ")
public class CompanyFeatures {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insurance_company_feature_id")
	private int companyFeatureId;
	
	@Column(name="plan_name")
	private String planName;
	
	@Column(name="pre_post_hospitalization")
	private String prePostHospitalization;
	
	@Column(name="co_pay")
	private String coPay;
	
	@Column(name="renevability")
	private String renevability;
	
	@Column(name="pre_existing_disease_cover")
	private String preExistingDiseaseCover;
	
	@Column(name="network_hospital")
	private int networkHospital;
	
	@Column(name="room_rent_eligibility")
	private String roomRentEligibility;
	
	@Column(name="maternity_cover")
	private String maternityCover;
	
	@Column(name="outpatient_benefit")
	private String outpatientBenefit;
	
	@Column(name="insurance_company_id")
	private int insuranceCompanyId;
	
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

	public int getCompanyFeatureId() {
		return companyFeatureId;
	}

	public void setCompanyFeatureId(int companyFeatureId) {
		this.companyFeatureId = companyFeatureId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPrePostHospitalization() {
		return prePostHospitalization;
	}

	public void setPrePostHospitalization(String prePostHospitalization) {
		this.prePostHospitalization = prePostHospitalization;
	}

	public String getCoPay() {
		return coPay;
	}

	public void setCoPay(String coPay) {
		this.coPay = coPay;
	}

	public String getRenevability() {
		return renevability;
	}

	public void setRenevability(String renevability) {
		this.renevability = renevability;
	}

	public String getPreExistingDiseaseCover() {
		return preExistingDiseaseCover;
	}

	public void setPreExistingDiseaseCover(String preExistingDiseaseCover) {
		this.preExistingDiseaseCover = preExistingDiseaseCover;
	}

	public int getNetworkHospital() {
		return networkHospital;
	}

	public void setNetworkHospital(int networkHospital) {
		this.networkHospital = networkHospital;
	}

	public String getRoomRentEligibility() {
		return roomRentEligibility;
	}

	public void setRoomRentEligibility(String roomRentEligibility) {
		this.roomRentEligibility = roomRentEligibility;
	}

	public String getMaternityCover() {
		return maternityCover;
	}

	public void setMaternityCover(String maternityCover) {
		this.maternityCover = maternityCover;
	}

	public String getOutpatientBenefit() {
		return outpatientBenefit;
	}

	public void setOutpatientBenefit(String outpatientBenefit) {
		this.outpatientBenefit = outpatientBenefit;
	}

	public int getInsuranceCompanyId() {
		return insuranceCompanyId;
	}

	public void setInsuranceCompanyId(int insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
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
		return "CompanyFeatures [companyFeatureId=" + companyFeatureId + ", planName=" + planName
				+ ", prePostHospitalization=" + prePostHospitalization + ", coPay=" + coPay + ", renevability="
				+ renevability + ", preExistingDiseaseCover=" + preExistingDiseaseCover + ", networkHospital="
				+ networkHospital + ", roomRentEligibility=" + roomRentEligibility + ", maternityCover="
				+ maternityCover + ", outpatientBenefit=" + outpatientBenefit + ", insuranceCompanyId="
				+ insuranceCompanyId + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", string1="
				+ string1 + ", string2=" + string2 + "]";
	}
	
	
	
}

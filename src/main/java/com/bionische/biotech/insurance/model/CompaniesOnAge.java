package com.bionische.biotech.insurance.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Transient;

@Entity

public class CompaniesOnAge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="premium_id")
	private int premiumId;
	
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="Insurance_company_name")
	private String companyName;
	
	@Transient
	private String betweenAge;
	
	@Column(name="family")
	private String membersType;
	
	@Column(name="insurance_rating")
	private int ratings;
	
	@Transient
	private int premiumPerday;
	
	@Transient
	List<CoverDetails> coverDetails;
	
	@Transient
	private List<String> criticalFactors;
	
	@Transient
	private List<InsuranceReview> insuranceReview;
	
	@Transient
	private List<CompanyFeatures> companyFeatures;
	
	public int getPremiumPerday() {
		return premiumPerday;
	}

	public void setPremiumPerday(int premiumPerday) {
		this.premiumPerday = premiumPerday;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
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

	public String getBetweenAge() {
		return betweenAge;
	}

	public void setBetweenAge(String betweenAge) {
		this.betweenAge = betweenAge;
	}

	public String getMembersType() {
		return membersType;
	}

	public void setMembersType(String membersType) {
		this.membersType = membersType;
	}

	public List<String> getCriticalFactors() {
		return criticalFactors;
	}

	public void setCriticalFactors(List<String> criticalFactors) {
		this.criticalFactors = criticalFactors;
	}
	
	public int getPremiumId() {
		return premiumId;
	}

	public void setPremiumId(int premiumId) {
		this.premiumId = premiumId;
	}

	public List<CoverDetails> getCoverDetails() {
		return coverDetails;
	}

	public void setCoverDetails(List<CoverDetails> coverDetails) {
		this.coverDetails = coverDetails;
	}
	
	public List<InsuranceReview> getInsuranceReview() {
		return insuranceReview;
	}

	public void setInsuranceReview(List<InsuranceReview> insuranceReview) {
		this.insuranceReview = insuranceReview;
	}

	public List<CompanyFeatures> getCompanyFeatures() {
		return companyFeatures;
	}

	public void setCompanyFeatures(List<CompanyFeatures> companyFeatures) {
		this.companyFeatures = companyFeatures;
	}

	@Override
	public String toString() {
		return "CompaniesOnAge [premiumId=" + premiumId + ", companyId=" + companyId + ", companyName=" + companyName
				+ ", betweenAge=" + betweenAge + ", membersType=" + membersType + ", ratings=" + ratings
				+ ", premiumPerday=" + premiumPerday + ", coverDetails=" + coverDetails + ", criticalFactors="
				+ criticalFactors + ", insuranceReview=" + insuranceReview + ", companyFeatures=" + companyFeatures
				+ "]";
	}

	
	
}

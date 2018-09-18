package com.bionische.biotech.insurance.model;

import java.util.List;

public class GetPlanDetailsList {

	
	List<InsurancePremium> insurancePremiumList;
	List<InsurancePremium> familyTypeList;
	
	List<InsurancePremium> ageGroupList;
	
	
	public List<InsurancePremium> getInsurancePremiumList() {
		return insurancePremiumList;
	}
	public void setInsurancePremiumList(List<InsurancePremium> insurancePremiumList) {
		this.insurancePremiumList = insurancePremiumList;
	}
	public List<InsurancePremium> getFamilyTypeList() {
		return familyTypeList;
	}
	public void setFamilyTypeList(List<InsurancePremium> familyTypeList) {
		this.familyTypeList = familyTypeList;
	}
	public List<InsurancePremium> getAgeGroupList() {
		return ageGroupList;
	}
	public void setAgeGroupList(List<InsurancePremium> ageGroupList) {
		this.ageGroupList = ageGroupList;
	}
	@Override
	public String toString() {
		return "GetPlanDetailsList [insurancePremiumList=" + insurancePremiumList + ", familyTypeList=" + familyTypeList
				+ ", ageGroupList=" + ageGroupList + "]";
	}
	 
	 
	
	
}

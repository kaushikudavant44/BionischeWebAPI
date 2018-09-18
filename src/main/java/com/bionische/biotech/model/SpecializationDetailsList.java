package com.bionische.biotech.model;

import java.util.List;

public class SpecializationDetailsList {

	
	List<SpecializationDetails> specializationDetailsList;
	
	Info info;

	public List<SpecializationDetails> getSpecializationDetailsList() {
		return specializationDetailsList;
	}

	public void setSpecializationDetailsList(List<SpecializationDetails> specializationDetailsList) {
		this.specializationDetailsList = specializationDetailsList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "SpecializationDetailsList [specializationDetailsList=" + specializationDetailsList + ", info=" + info
				+ "]";
	}
	
	
}

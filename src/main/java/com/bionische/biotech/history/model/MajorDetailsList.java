package com.bionische.biotech.history.model;

import java.util.List;

import com.bionische.biotech.model.Info;

public class MajorDetailsList {

	
	List<MajorDiesesDetails> majorDiesesDetailsList;
	Info info;
	public List<MajorDiesesDetails> getMajorDiesesDetailsList() {
		return majorDiesesDetailsList;
	}
	public void setMajorDiesesDetailsList(List<MajorDiesesDetails> majorDiesesDetailsList) {
		this.majorDiesesDetailsList = majorDiesesDetailsList;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "MajorDetailsList [majorDiesesDetailsList=" + majorDiesesDetailsList + ", info=" + info + "]";
	}
	
}

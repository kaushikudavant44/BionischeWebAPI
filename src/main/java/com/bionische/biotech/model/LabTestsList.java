package com.bionische.biotech.model;

import java.util.List;

public class LabTestsList {

	
	List<LabTests> labTestsList;
	Info info;
	public List<LabTests> getLabTestsList() {
		return labTestsList;
	}
	public void setLabTestsList(List<LabTests> labTestsList) {
		this.labTestsList = labTestsList;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "LabTestsList [labTestsList=" + labTestsList + ", info=" + info + "]";
	}
	
	
	
}

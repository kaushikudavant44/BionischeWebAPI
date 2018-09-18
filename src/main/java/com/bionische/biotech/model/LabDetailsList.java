package com.bionische.biotech.model;

import java.util.List;

public class LabDetailsList {
	
	private  List<LabDetails> labDetailsList;
	private   Info info;
	public List<LabDetails> getLabDetailsList() {
		return labDetailsList;
	}
	public void setLabDetailsList(List<LabDetails> labDetailsList) {
		this.labDetailsList = labDetailsList;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "LabDetailsList [labDetailsList=" + labDetailsList + ", info=" + info + "]";
	}
	


	
	
	
	

}

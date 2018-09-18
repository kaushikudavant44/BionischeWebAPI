package com.bionische.biotech.model;

public class LabLogin {
	
	LabDetails labDetails;
	Info info;
	public LabDetails getLabDetails() {
		return labDetails;
	}
	public void setLabDetails(LabDetails labDetails) {
		this.labDetails = labDetails;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "LabLogin [labDetails=" + labDetails + ", info=" + info + "]";
	}
	
	

}

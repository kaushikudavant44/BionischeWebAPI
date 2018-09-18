package com.bionische.biotech.model;

public class AdminLogin {

	AdminDetails adminDetails;
	
	Info info;

	public AdminDetails getAdminDetails() {
		return adminDetails;
	}

	public void setAdminDetails(AdminDetails adminDetails) {
		this.adminDetails = adminDetails;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "AdminLogin [adminDetails=" + adminDetails + ", info=" + info + "]";
	}
	
	
	
}

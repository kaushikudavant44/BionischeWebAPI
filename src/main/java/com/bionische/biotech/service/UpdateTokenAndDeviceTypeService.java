package com.bionische.biotech.service;

public interface UpdateTokenAndDeviceTypeService {
	
	public int updateDoctorTokenAslocationByDoctorId(int doctorId,String token,int deviceType);

}

package com.bionische.biotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.repository.DoctorDetailsRepository;

@Service
public class UpdateTokenAndDeviceTypeServiceImpl implements UpdateTokenAndDeviceTypeService{

	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	
	@Override
	public int updateDoctorTokenAslocationByDoctorId(int doctorId, String token, int deviceType) {
		
		int updateTokenAndDevice=doctorDetailsRepository.updateDoctorTokenAslocationByDoctorId(doctorId,token,deviceType);
		
		
		return updateTokenAndDevice;
	}

}

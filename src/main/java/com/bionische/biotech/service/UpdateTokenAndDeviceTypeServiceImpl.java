package com.bionische.biotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;

@Service
public class UpdateTokenAndDeviceTypeServiceImpl implements UpdateTokenAndDeviceTypeService {

	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	
	@Override
	public int updateDoctorTokenAslocationByDoctorId(int doctorId, String token, int deviceType) {
		
		int updateTokenAndDevice=doctorDetailsRepository.updateDoctorTokenAslocationByDoctorId(doctorId,token,deviceType);
		
		
		return updateTokenAndDevice;
	}

	@Override
	public int updatePatientTokenAsString2ByPatientId(int patientId, String token, int deviceType) {
		
		int updateTokenAndDevice=patientDetailsRepository.updatePatientTokenAsString2ByPatientId(patientId, token, deviceType);
		
		return updateTokenAndDevice;
	}

}

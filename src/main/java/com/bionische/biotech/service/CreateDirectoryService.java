package com.bionische.biotech.service;

public interface CreateDirectoryService {

	
	public void createNewDirectorForDoctor(String folderName);
	public void createNewDirectorForPatient(String folderName);
	public void createNewDirectorForLab(String folderName);
	public void createNewDirectorForPharmacy(String folderName);
}

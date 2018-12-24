package com.bionische.biotech.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.bionische.biotech.ConstantFileUploadPath;

 
@Service
public class CreateDirectoryServiceImpl implements CreateDirectoryService{

	@Override
	public void createNewDirectorForDoctor(String folderName) {
		try{
		    
			   

		    // Create one directory
		    boolean success = (new File(ConstantFileUploadPath.DOCTOR_PATH+folderName).mkdir());
		    if (success) {
		      System.out.println("Directory: " + folderName + " created");
		      
		      new File(ConstantFileUploadPath.DOCTOR_PATH+folderName+"/profile").mkdir();
		      new File(ConstantFileUploadPath.DOCTOR_PATH+folderName+"/documents").mkdir();
		      new File(ConstantFileUploadPath.DOCTOR_PATH+folderName+"/signature").mkdir();
		    } 
		    
		  }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }  
		
		
	}

	@Override
	public void createNewDirectorForPatient(String folderName) {
		try{
		    
			   

		    // Create one directory
		    boolean success = (new File(ConstantFileUploadPath.PATIENT_PATH+folderName).mkdir());
		    if (success) {
		      System.out.println("Directory: " + folderName + " created");
		      
		      new File(ConstantFileUploadPath.PATIENT_PATH+folderName+"/profile").mkdir();
		      new File(ConstantFileUploadPath.PATIENT_PATH+folderName+"/reports").mkdir();
		     
		    } 
		    
		  }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }  
		
		
	}

	@Override
	public void createNewDirectorForLab(String folderName) {
		try{
	    // Create one directory
	    boolean success = (new File(ConstantFileUploadPath.LAB_PATH+folderName).mkdir());
	    if (success) {
	      System.out.println("Directory: " + folderName + " created");
	      
	      new File(ConstantFileUploadPath.LAB_PATH+folderName+"/profile").mkdir();
	      new File(ConstantFileUploadPath.LAB_PATH+folderName+"/documents").mkdir();
	     
	    } 
	    
	  }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }  
	
		
	}

	@Override
	public void createNewDirectorForPharmacy(String folderName) {
		try{
	    // Create one directory
	    boolean success = (new File(ConstantFileUploadPath.PHARMACY_PATH+folderName).mkdir());
	    if (success) {
	      System.out.println("Directory: " + folderName + " created");
	      
	      new File(ConstantFileUploadPath.PHARMACY_PATH+folderName+"/profile").mkdir();
	      new File(ConstantFileUploadPath.PHARMACY_PATH+folderName+"/documents").mkdir();
	     
	    } 
	    
	  }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }  
	
		
	}

	
}

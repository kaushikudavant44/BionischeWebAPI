package com.bionische.biotech.radiology.service;

import java.util.List;

import com.bionische.biotech.model.Info;
import com.bionische.biotech.radiology.model.ChildsModel;
import com.bionische.biotech.radiology.model.IndicationsModel;
import com.bionische.biotech.radiology.model.PNDTPatientDetails;

public interface PndtPatientDetailsService {
	
	Info insertPndtPatientDetails(PNDTPatientDetails pndtPatientDetails);
	
	//List<IndicationsModel> getIndicationByPndtId(int pndtId);
	List<ChildsModel> getChildsByPndtId(int pndtId);

}

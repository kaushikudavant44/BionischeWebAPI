package com.bionische.biotech.patientpasthistory.model;

import java.util.List;
 
import com.bionische.biotech.model.Info;

public class PatientHistoryIllnessList {

	
	
List<PatientPastHistoryIIlness> PatientPastHistoryIIlnessList;
	
	Info info;

	/**
	 * @return the patientPastHistoryIIlnessList
	 */
	public List<PatientPastHistoryIIlness> getPatientPastHistoryIIlnessList() {
		return PatientPastHistoryIIlnessList;
	}

	/**
	 * @param patientPastHistoryIIlnessList the patientPastHistoryIIlnessList to set
	 */
	public void setPatientPastHistoryIIlnessList(List<PatientPastHistoryIIlness> patientPastHistoryIIlnessList) {
		PatientPastHistoryIIlnessList = patientPastHistoryIIlnessList;
	}

	/**
	 * @return the info
	 */
	public Info getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(Info info) {
		this.info = info;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PatientHistoryIllnessList [PatientPastHistoryIIlnessList=" + PatientPastHistoryIIlnessList + ", info="
				+ info + "]";
	}
	
	
}

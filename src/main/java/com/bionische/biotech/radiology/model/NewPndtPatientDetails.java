package com.bionische.biotech.radiology.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_pndt_patient_details")
public class NewPndtPatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pndt_patient_id")
	int pndtPatientId;

	@Column(name = "m_name")
	String mName;

	@Column(name = "l_name")
	String lName;

	@Column(name = "patient_name")
	String patientName;

	@Column(name = "mobile_no")
	String mobileNo;

	@Column(name = "del_status")
	int delStatus;

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getPndtPatientId() {
		return pndtPatientId;
	}

	public void setPndtPatientId(int pndtPatientId) {
		this.pndtPatientId = pndtPatientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "NewPndtPatientDetails [pndtPatientId=" + pndtPatientId + ", mName=" + mName + ", lName=" + lName
				+ ", patientName=" + patientName + ", mobileNo=" + mobileNo + ", delStatus=" + delStatus + "]";
	}

}

package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPatientContactDetailsById {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="f_name")
	private String fName;
	
	@Column(name="l_name")
	private String lName; 
	
	@Column(name="m_name")
	private String mName;
	
	@Column(name="contact")
	private String contactNo;
	
	@Column(name="email")
	private String email;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GetPatientContactDetailsById [patientId=" + patientId + ", fName=" + fName + ", lName=" + lName
				+ ", mName=" + mName + ", contactNo=" + contactNo + ", email=" + email + "]";
	}
	
	
}

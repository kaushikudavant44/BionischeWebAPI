package com.bionische.biotech.radiology.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PndtPatientBasicDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "pndt_id")
	private int pndtId;

	@Column(name = "f_name")
	private String fName;

	@Column(name = "l_name")
	private String lName;

	@Column(name = "m_name")
	private String mName;

	@Column(name = "address")
	private String address;

	@Column(name = "contact")
	private String contactNo;

	@Column(name = "email")
	private String email;

	@Column(name = "doctor_id")
	private int doctorId;

	public int getPndtId() {
		return pndtId;
	}

	public void setPndtId(int pndtId) {
		this.pndtId = pndtId;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public String toString() {
		return "PndtPatientBasicDetails [patientId=" + patientId + ", pndtId=" + pndtId + ", fName=" + fName
				+ ", lName=" + lName + ", mName=" + mName + ", address=" + address + ", contactNo=" + contactNo
				+ ", email=" + email + ", doctorId=" + doctorId + "]";
	}

}

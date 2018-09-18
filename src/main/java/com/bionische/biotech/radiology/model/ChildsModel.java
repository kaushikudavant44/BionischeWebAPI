package com.bionische.biotech.radiology.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pndt_patient_children_details")
public class ChildsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="child_id")
	private int id;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private String dob;	
	
	@Column(name="pndt_id")
	private int pndtId;
	
	@Column(name="int_2")
	private int int_2;
	
	@Column(name="string1")
	private String string1;
	
	@Column(name="string2")
	private String string2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
	
	public int getInt_2() {
		return int_2;
	}

	public void setInt_2(int int_2) {
		this.int_2 = int_2;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public int getPndtId() {
		return pndtId;
	}

	public void setPndtId(int pndtId) {
		this.pndtId = pndtId;
	}

	@Override
	public String toString() {
		return "ChildsModel [id=" + id + ", patientId=" + patientId + ", gender=" + gender + ", dob=" + dob
				+ ", pndtId=" + pndtId + ", int_2=" + int_2 + ", string1=" + string1 + ", string2=" + string2 + "]";
	}

	

	
	
	
	
}

package com.bionische.biotech.radiology.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pndt_patient_indication_details")
public class IndicationsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="indication_id")
	private int id;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="indication")
	private String indications;
	
	@Column(name="pndt_id")
	private int pndtId;
	
	@Column(name="int_2")
	private int int_2;
	
	@Column(name="string_1")
	private String string1;
	
	@Column(name="string_2")
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

	public String getIndications() {
		return indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
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
		return "IndicationsModel [id=" + id + ", patientId=" + patientId + ", indications=" + indications + ", pndtId="
				+ pndtId + ", int_2=" + int_2 + ", string1=" + string1 + ", string2=" + string2 + "]";
	}

	
	
	
	
}

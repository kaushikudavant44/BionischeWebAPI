package com.bionische.biotech.adminpanel3d.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccination_details")
public class VaccinationDetailss {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="vaccination_id")
	private int vaccinationId;
	
	@Column(name="vaccination_name")
	private String vaccinationName;
	
	@Column(name="vaccination_age_id")
	private int vaccinationAgeId;
	
	@Column(name="int_1")
	private int int1;
	   
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string_2")
	private String string2;

	public int getVaccinationId() {
		return vaccinationId;
	}

	public void setVaccinationId(int vaccinationId) {
		this.vaccinationId = vaccinationId;
	}

	public String getVaccinationName() {
		return vaccinationName;
	}

	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}

	public int getVaccinationAgeId() {
		return vaccinationAgeId;
	}

	public void setVaccinationAgeId(int vaccinationAgeId) {
		this.vaccinationAgeId = vaccinationAgeId;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	@Override
	public String toString() {
		return "VaccinationDetailss [vaccinationId=" + vaccinationId + ", vaccinationName=" + vaccinationName
				+ ", vaccinationAgeId=" + vaccinationAgeId + ", int1=" + int1 + ", int2=" + int2 + ", string2="
				+ string2 + "]";
	}
	
	
	

}

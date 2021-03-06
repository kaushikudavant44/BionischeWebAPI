package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccination_age")
public class VaccinationAgeDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="vaxination_age_id")
	private int vaxinationAgeId;
	
	@Column(name="vaxination_age_name")
	private String vaxinationAgeName;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string1")
	private String string1;
	
	@Column(name="string2")
	private String string2;

	public int getVaxinationAgeId() {
		return vaxinationAgeId;
	}

	public void setVaxinationAgeId(int vaxinationAgeId) {
		this.vaxinationAgeId = vaxinationAgeId;
	}

	public String getVaxinationAgeName() {
		return vaxinationAgeName;
	}

	public void setVaxinationAgeName(String vaxinationAgeName) {
		this.vaxinationAgeName = vaxinationAgeName;
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

	@Override
	public String toString() {
		return "VaccinationAgeDetails [vaxinationAgeId=" + vaxinationAgeId + ", vaxinationAgeName=" + vaxinationAgeName
				+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	

}

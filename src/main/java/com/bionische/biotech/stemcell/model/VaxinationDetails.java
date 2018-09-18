package com.bionische.biotech.stemcell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaxination_details")
public class VaxinationDetails {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="vaxination_details_id")
	private int VaxinationDetailsId;
	@Column(name="patient_id")
	private  int patientId;
	@Column(name="baby_vaxination_details_id")
	private String babyVaxinationDetailsId;
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	@Column(name="baby_age_ids")
	private String babyAge;
	@Column(name="string2",nullable = true)
	private String string2;
	/**
	 * @return the vaxinationDetailsId
	 */
	public int getVaxinationDetailsId() {
		return VaxinationDetailsId;
	}
	/**
	 * @param vaxinationDetailsId the vaxinationDetailsId to set
	 */
	public void setVaxinationDetailsId(int vaxinationDetailsId) {
		VaxinationDetailsId = vaxinationDetailsId;
	}
	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}   
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the babyVaxinationDetailsId
	 */
	public String getBabyVaxinationDetailsId() {
		return babyVaxinationDetailsId;
	}
	/**
	 * @param babyVaxinationDetailsId the babyVaxinationDetailsId to set
	 */
	public void setBabyVaxinationDetailsId(String babyVaxinationDetailsId) {
		this.babyVaxinationDetailsId = babyVaxinationDetailsId;
	}
	/**
	 * @return the int1
	 */
	public int getInt1() {
		return int1;
	}
	/**
	 * @param int1 the int1 to set
	 */
	public void setInt1(int int1) {
		this.int1 = int1;
	}
	/**
	 * @return the int2
	 */
	public int getInt2() {
		return int2;
	}
	/**
	 * @param int2 the int2 to set
	 */
	public void setInt2(int int2) {
		this.int2 = int2;
	}

	/**
	 * @return the string2
	 */
	public String getString2() {
		return string2;
	}
	/**
	 * @param string2 the string2 to set
	 */
	public void setString2(String string2) {
		this.string2 = string2;
	}
	/**
	 * @return the babyAge
	 */
	public String getBabyAge() {
		return babyAge;
	}
	/**
	 * @param babyAge the babyAge to set
	 */
	public void setBabyAge(String babyAge) {
		this.babyAge = babyAge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VaxinationDetails [VaxinationDetailsId=" + VaxinationDetailsId + ", patientId=" + patientId
				+ ", babyVaxinationDetailsId=" + babyVaxinationDetailsId + ", int1=" + int1 + ", int2=" + int2
				+ ", babyAge=" + babyAge + ", string2=" + string2 + "]";
	}
	
	
	
}

package com.bionische.biotech.stemcell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="baby_vaxination_details")
public class BabyVaxinationDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="baby_vaxination_details_id")
	private int babyVaxinationDetailsId;
	@Column(name="vaxination_name")
	private  String vaxinationName;
	@Column(name="description")
	private String Description;   
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	@Column(name="string1")
	private String string1;
	@Column(name="string2")
	private String string2;
	/**
	 * @return the babyVaxinationDetailsId
	 */
	public int getBabyVaxinationDetailsId() {
		return babyVaxinationDetailsId;
	}
	/**
	 * @param babyVaxinationDetailsId the babyVaxinationDetailsId to set
	 */
	public void setBabyVaxinationDetailsId(int babyVaxinationDetailsId) {
		this.babyVaxinationDetailsId = babyVaxinationDetailsId;
	}
	/**
	 * @return the vaxinationName
	 */
	public String getVaxinationName() {
		return vaxinationName;
	}
	/**
	 * @param vaxinationName the vaxinationName to set
	 */
	public void setVaxinationName(String vaxinationName) {
		this.vaxinationName = vaxinationName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
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
	 * @return the string1
	 */
	public String getString1() {
		return string1;
	}
	/**
	 * @param string1 the string1 to set
	 */
	public void setString1(String string1) {
		this.string1 = string1;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BabyVaxinationDetails [babyVaxinationDetailsId=" + babyVaxinationDetailsId + ", vaxinationName="
				+ vaxinationName + ", Description=" + Description + ", int1=" + int1 + ", int2=" + int2 + ", string1="
				+ string1 + ", string2=" + string2 + "]";
	}
	 
	
}

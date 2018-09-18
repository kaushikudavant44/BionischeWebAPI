package com.bionische.biotech.stemcell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaxination_age")
public class VaxinationAge {
    
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
	/**
	 * @return the vaxinationAgeId
	 */
	public int getVaxinationAgeId() {
		return vaxinationAgeId;
	}
	/**
	 * @param vaxinationAgeId the vaxinationAgeId to set
	 */
	public void setVaxinationAgeId(int vaxinationAgeId) {
		this.vaxinationAgeId = vaxinationAgeId;
	}
	/**
	 * @return the vaxinationAgeName
	 */
	public String getVaxinationAgeName() {
		return vaxinationAgeName;
	}
	/**  
	 * @param vaxinationAgeName the vaxinationAgeName to set
	 */
	public void setVaxinationAgeName(String vaxinationAgeName) {
		this.vaxinationAgeName = vaxinationAgeName;
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
		return "VaxinationAge [vaxinationAgeId=" + vaxinationAgeId + ", vaxinationAgeName=" + vaxinationAgeName
				+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	
}

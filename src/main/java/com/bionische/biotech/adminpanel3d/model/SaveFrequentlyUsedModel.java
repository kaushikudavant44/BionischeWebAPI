package com.bionische.biotech.adminpanel3d.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="3d_frequently_used_model")
public class SaveFrequentlyUsedModel {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="frequently_used_id")
	private int frequentlyUsedId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="sub_model_id")
	private int subModelId;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="string1")
	private String string1;
	
	@Column(name="string2")
	private String string2;
	
	@Column(name="int_1")
	private int int_1;
	
	@Column(name="int_2")
	private int int_2;

	public int getFrequentlyUsedId() {
		return frequentlyUsedId;
	}

	public void setFrequentlyUsedId(int frequentlyUsedId) {
		this.frequentlyUsedId = frequentlyUsedId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSubModelId() {
		return subModelId;
	}

	public void setSubModelId(int subModelId) {
		this.subModelId = subModelId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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

	public int getInt_1() {
		return int_1;
	}

	public void setInt_1(int int_1) {
		this.int_1 = int_1;
	}

	public int getInt_2() {
		return int_2;
	}

	public void setInt_2(int int_2) {
		this.int_2 = int_2;
	}

	@Override
	public String toString() {
		return "SaveFrequentlyUsedModel [frequentlyUsedId=" + frequentlyUsedId + ", userId=" + userId + ", subModelId="
				+ subModelId + ", delStatus=" + delStatus + ", string1=" + string1 + ", string2=" + string2 + ", int_1="
				+ int_1 + ", int_2=" + int_2 + "]";
	}
	
	
	
}

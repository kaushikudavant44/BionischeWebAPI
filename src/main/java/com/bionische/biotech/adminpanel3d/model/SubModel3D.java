package com.bionische.biotech.adminpanel3d.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="3d_sub_model")
public class SubModel3D {

		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_model_id")
	private int subModelId;
	
	@Column(name="main_model_id")
	private int mainModelId;
	 
	@Column(name="sub_model_name")
	private String subModelName;
	
	@Column(name="status")
	private int status;
	
	@Column(name="update_status")
	private int updateStatus;
 
 

	 
	
	@Column(name="int_1")
	private int int1;

	@Column(name="int_2")
	private int int2;
	
	@Column(name="string1")
	private String string1;

	@Column(name="string2")
	private String string2;
	
	@Column(name="type")
	private int type;

	public int getSubModelId() {
		return subModelId;
	}

	public void setSubModelId(int subModelId) {
		this.subModelId = subModelId;
	}

	public int getMainModelId() {
		return mainModelId;
	}

	public void setMainModelId(int mainModelId) {
		this.mainModelId = mainModelId;
	}

	public String getSubModelName() {
		return subModelName;
	}

	public void setSubModelName(String subModelName) {
		this.subModelName = subModelName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(int updateStatus) {
		this.updateStatus = updateStatus;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SubModel3D [subModelId=" + subModelId + ", mainModelId=" + mainModelId + ", subModelName="
				+ subModelName + ", status=" + status + ", updateStatus=" + updateStatus + ", int1=" + int1 + ", int2="
				+ int2 + ", string1=" + string1 + ", string2=" + string2 + ", type=" + type + "]";
	}
	
 
	 
}

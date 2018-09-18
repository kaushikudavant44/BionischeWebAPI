package com.bionische.biotech.adminpanel3d.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetFrequentlyUsedModel {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="sub_model_id")
	private int subModelId;
	
	
	@Column(name="frequently_used_id")
	private int frequentlyUsedId;
	
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="category")
	private String category;
	
	@Column(name="model_id")
	private String modelId;
	
	@Column(name="model_name")
	private String modelName;
	
	
	
	@Column(name="sub_model_name")
	private String subModelName;
	
	@Column(name="status")
	private int status;
	
	@Column(name="update_status")
	private int updateStatus;
 
	@Column(name="bumpmap")
	private float bumpmap;

	@Column(name="obj_x")
	private int objx;
 
	@Column(name="obj_y")
	private int objy;
	 
	@Column(name="obj_z")
	private int objz;
 
	@Column(name="rotation_speed")
	private float rotationSpeed;
	
	@Column(name="shininess")
	private int shininess;
	
	@Column(name="type")
	private int type;

	@Column(name="int_1")
	private int int1;
 
	@Column(name="int_2")
	private int int2;
	 
	@Column(name="string1")
	private String string1;
 
	@Column(name="string2")
	private String string2;

	
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="del_status")
	private int delStatus;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getFrequentlyUsedId() {
		return frequentlyUsedId;
	}

	public void setFrequentlyUsedId(int frequentlyUsedId) {
		this.frequentlyUsedId = frequentlyUsedId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getSubModelId() {
		return subModelId;
	}

	public void setSubModelId(int subModelId) {
		this.subModelId = subModelId;
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

	public float getBumpmap() {
		return bumpmap;
	}

	public void setBumpmap(float bumpmap) {
		this.bumpmap = bumpmap;
	}

	public int getObjx() {
		return objx;
	}

	public void setObjx(int objx) {
		this.objx = objx;
	}

	public int getObjy() {
		return objy;
	}

	public void setObjy(int objy) {
		this.objy = objy;
	}

	public int getObjz() {
		return objz;
	}

	public void setObjz(int objz) {
		this.objz = objz;
	}

	public float getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(float rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	public int getShininess() {
		return shininess;
	}

	public void setShininess(int shininess) {
		this.shininess = shininess;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
		return "GetFrequentlyUsedModel [catId=" + catId + ", category=" + category + ", modelId=" + modelId
				+ ", modelName=" + modelName + ", subModelId=" + subModelId + ", subModelName=" + subModelName
				+ ", status=" + status + ", updateStatus=" + updateStatus + ", bumpmap=" + bumpmap + ", objx=" + objx
				+ ", objy=" + objy + ", objz=" + objz + ", rotationSpeed=" + rotationSpeed + ", shininess=" + shininess
				+ ", type=" + type + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2="
				+ string2 + ", frequentlyUsedId=" + frequentlyUsedId + ", userId=" + userId + ", delStatus=" + delStatus
				+ "]";
	}

	
	
}

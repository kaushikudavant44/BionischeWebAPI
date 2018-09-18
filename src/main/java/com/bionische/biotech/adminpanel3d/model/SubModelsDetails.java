package com.bionische.biotech.adminpanel3d.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="3d_sub_model_details")
public class SubModelsDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_model_Detail_id")
	private int subModelDetailId;

	@Column(name="sub_model_id")
	private int subModelId;
	

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
	
	@Column(name="shininess")
	private int shininess;

	@Column(name="camera_pos_x")
	private int cameraPosX;
	
	@Column(name="camera_pos_y")
	private int cameraPosY;
	
	@Column(name="camera_pos_z")
	private int cameraPosZ;
	
	@Column(name="color_code_of_back_light")
	private String colorCodeOfBackLight;
	
	@Column(name="color_code_of_ambient_light")
	private String colorCodeOfAmbientLight;

	@Column(name="color_code_of_point_light")
	private String colorCodeOfPointLight;
	
	
	@Column(name="intensity_back_light")
	private float intensityBackLight;
	
	@Column(name="intensity_ambient_light")
	private float intensityAmbientLight;
	
	@Column(name="intensity_point_light")
	private float intensityPointLight;
	
	@Column(name="background_color")
	private float backgroundColor;
	
	@Column(name="background_color_intensity")
	private float backgroundColorIntensity;

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

	public int getCameraPosX() {
		return cameraPosX;
	}

	public void setCameraPosX(int cameraPosX) {
		this.cameraPosX = cameraPosX;
	}

	public int getCameraPosY() {
		return cameraPosY;
	}

	public void setCameraPosY(int cameraPosY) {
		this.cameraPosY = cameraPosY;
	}

	public int getCameraPosZ() {
		return cameraPosZ;
	}

	public void setCameraPosZ(int cameraPosZ) {
		this.cameraPosZ = cameraPosZ;
	}

	public String getColorCodeOfBackLight() {
		return colorCodeOfBackLight;
	}

	public void setColorCodeOfBackLight(String colorCodeOfBackLight) {
		this.colorCodeOfBackLight = colorCodeOfBackLight;
	}

	public String getColorCodeOfAmbientLight() {
		return colorCodeOfAmbientLight;
	}

	public void setColorCodeOfAmbientLight(String colorCodeOfAmbientLight) {
		this.colorCodeOfAmbientLight = colorCodeOfAmbientLight;
	}

	public String getColorCodeOfPointLight() {
		return colorCodeOfPointLight;
	}

	public void setColorCodeOfPointLight(String colorCodeOfPointLight) {
		this.colorCodeOfPointLight = colorCodeOfPointLight;
	}

	public float getIntensityBackLight() {
		return intensityBackLight;
	}

	public void setIntensityBackLight(float intensityBackLight) {
		this.intensityBackLight = intensityBackLight;
	}

	public float getIntensityAmbientLight() {
		return intensityAmbientLight;
	}

	public void setIntensityAmbientLight(float intensityAmbientLight) {
		this.intensityAmbientLight = intensityAmbientLight;
	}

	public float getIntensityPointLight() {
		return intensityPointLight;
	}

	public void setIntensityPointLight(float intensityPointLight) {
		this.intensityPointLight = intensityPointLight;
	}

	public float getBackgroundColor() { 
		return backgroundColor;
	}

	public void setBackgroundColor(float backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public float getBackgroundColorIntensity() {
		return backgroundColorIntensity;
	}

	public void setBackgroundColorIntensity(float backgroundColorIntensity) {
		this.backgroundColorIntensity = backgroundColorIntensity;
	}

	public int getSubModelDetailId() {
		return subModelDetailId;
	}

	public void setSubModelDetailId(int subModelDetailId) {
		this.subModelDetailId = subModelDetailId;
	}

	@Override
	public String toString() {
		return "SubModelsDetails [subModelDetailId=" + subModelDetailId + ", subModelId=" + subModelId
				+ ", subModelName=" + subModelName + ", status=" + status + ", updateStatus=" + updateStatus
				+ ", bumpmap=" + bumpmap + ", objx=" + objx + ", objy=" + objy + ", objz=" + objz + ", rotationSpeed="
				+ rotationSpeed + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2
				+ ", shininess=" + shininess + ", type=" + type + ", cameraPosX=" + cameraPosX + ", cameraPosY="
				+ cameraPosY + ", cameraPosZ=" + cameraPosZ + ", colorCodeOfBackLight=" + colorCodeOfBackLight
				+ ", colorCodeOfAmbientLight=" + colorCodeOfAmbientLight + ", colorCodeOfPointLight="
				+ colorCodeOfPointLight + ", intensityBackLight=" + intensityBackLight + ", intensityAmbientLight="
				+ intensityAmbientLight + ", intensityPointLight=" + intensityPointLight + ", backgroundColor="
				+ backgroundColor + ", backgroundColorIntensity=" + backgroundColorIntensity + "]";
	}

	 
	
	
}

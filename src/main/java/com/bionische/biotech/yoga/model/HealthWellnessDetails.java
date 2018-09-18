package com.bionische.biotech.yoga.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="healthwellness_details")



public class HealthWellnessDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="healthtypedetail_id")
	private int healthTypeDetailId;
	
	
	@Column(name="healthtype_id")
private String healthTypeId;
	
	@Column(name="teacher_id")
private String teacherId;
	
	@Column(name="description")
private String description;
	
	@Column(name="image")
private String image;




public int getHealthTypeDetailId() {
	return healthTypeDetailId;
}

public void setHealthTypeDetailId(int healthTypeDetailId) {
	this.healthTypeDetailId = healthTypeDetailId;
}

public String getHealthTypeId() {
	return healthTypeId;
}

public void setHealthTypeId(String healthTypeId) {
	this.healthTypeId = healthTypeId;
}

public String getTeacherId() {
	return teacherId;
}

public void setTeacherId(String teacherId) {
	this.teacherId = teacherId;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

@Override
public String toString() {
	return "HealthWellnessDetails [healthTypeDetailId=" + healthTypeDetailId + ", healthTypeId=" + healthTypeId
			+ ", teacherId=" + teacherId + ", description=" + description + ", image=" + image + "]";
}


	
	

	}

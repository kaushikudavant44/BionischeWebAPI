package com.bionische.biotech.yoga.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yogatype_details")

public class YogaTypeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="yogatype_id")
	private int yogaTypeId;
	
	@Column(name="type_id")
private int typeId;
	

	@Column(name="teacher_id")
private String teacherId;
	
 
	@Column(name="description")
private String description;
	
	@Column(name="image")
private String image;

	public int getYogaTypeId() {
		return yogaTypeId;
	}

	public void setYogaTypeId(int yogaTypeId) {
		this.yogaTypeId = yogaTypeId;
	}

	
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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


	}

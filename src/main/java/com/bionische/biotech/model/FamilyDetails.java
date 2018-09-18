package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="family_details")
public class FamilyDetails {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="family_id")
	int familyId;
 
	
	@Column(name="del_status")
	int delStatus;


	public int getFamilyId() {
		return familyId;
	}


	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	@Override
	public String toString() {
		return "FamilyDetails [familyId=" + familyId + ", delStatus=" + delStatus + "]";
	}

	 
	
	
}

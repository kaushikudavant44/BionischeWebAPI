package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_member_relation")
public class PatientMemberRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="relation_id")
	private int relationId;
	
	@Column(name="relation_type")
	private String relationType;

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	@Override
	public String toString() {
		return "PatientMemberRelation [relationId=" + relationId + ", relationType=" + relationType + "]";
	}
	
	
}

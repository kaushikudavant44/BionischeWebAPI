package com.bionische.biotech.radiology.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pndt_indications")
public class PndtIndications {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "indication_id")
	int indicationId;
	
	@Column(name = "indication_name")
	String indicationName;
	
	@Column(name = "del_status")
	int delStatus;

	public int getIndicationId() {
		return indicationId;
	}

	public void setIndicationId(int indicationId) {
		this.indicationId = indicationId;
	}

	public String getIndicationName() {
		return indicationName;
	}

	public void setIndicationName(String indicationName) {
		this.indicationName = indicationName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "PndtIndications [indicationId=" + indicationId + ", indicationName=" + indicationName + ", delStatus="
				+ delStatus + "]";
	}
	
	
	
}

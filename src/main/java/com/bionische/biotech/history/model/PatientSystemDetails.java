package com.bionische.biotech.history.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_sys_details")
public class PatientSystemDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_detail_id")
	private int patient_Sys_ReviewsId;
	
	@Column(name="header_id")
    private int headerId;
	
	@Column(name="details_name")
   private String details_Name;
	 
	
	@Column(name="del_status")
    private int delStatus;
	
	@Column(name="int_1")
private int int1;
	
	@Column(name="int_2")
private int int2;
	
	@Column(name="string1")
private String string1;
	
	@Column(name="string2")
private String string2;
	

	public int getPatient_Sys_ReviewsId() {
		return patient_Sys_ReviewsId;
	}

	public void setPatient_Sys_ReviewsId(int patient_Sys_ReviewsId) {
		this.patient_Sys_ReviewsId = patient_Sys_ReviewsId;
	}

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public String getDetails_Name() {
		return details_Name;
	}

	public void setDetails_Name(String details_Name) {
		this.details_Name = details_Name;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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
		return "PatientSystemDetails [patient_Sys_ReviewsId=" + patient_Sys_ReviewsId + ", headerId=" + headerId
				+ ", details_Name=" + details_Name + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2
				+ ", string1=" + string1 + ", string2=" + string2 + "]";
	}

	
	
	
	

}

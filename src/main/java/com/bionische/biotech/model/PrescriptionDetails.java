package com.bionische.biotech.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prescription_details")
public class PrescriptionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prescription_id")
	private int prescriptionId;

	@Column(name = "meeting_id")
	private int meetingId;

	@Column(name = "medicine_name")
	private String medicineName;

	@Column(name = "medicine_quantity")
	private String medicineQuantity;

	@Column(name = "medicine_timing")
	private String medicineTiming;

	@Column(name = "medicine_instruction")
	private String medicineInstruction;
	
	@Column(name = "medicine_duration",nullable=true)
	private String medicineDuration;

	@Column(name = "float_1")
	private float float1;

	@Column(name = "int_1")
	private int int1;

	@Column(name = "int_2")
	private int int2;

	@Column(name = "string_1")
	private String string1;

	@Column(name = "string_2")
	private String string2;

	@Column(name = "del_status")
	private int delstatus;

	public String getMedicineInstruction() {
		return medicineInstruction;
	}

	public void setMedicineInstruction(String medicineInstruction) {
		this.medicineInstruction = medicineInstruction;
	}

	public String getMedicineDuration() {
		return medicineDuration;
	}

	public void setMedicineDuration(String medicineDuration) {
		this.medicineDuration = medicineDuration;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	 

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
 
	 

	public String getMedicineQuantity() {
		return medicineQuantity;
	}

	public void setMedicineQuantity(String medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}

	public String getMedicineTiming() {
		return medicineTiming;
	}

	public void setMedicineTiming(String medicineTiming) {
		this.medicineTiming = medicineTiming;
	}

	public float getFloat1() {
		return float1;
	}

	public void setFloat1(float float1) {
		this.float1 = float1;
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

	public int getDelstatus() {
		return delstatus;
	}

	@Override
	public String toString() {
		return "PrescriptionDetails [prescriptionId=" + prescriptionId + ", meetingId=" + meetingId + ", medicineName="
				+ medicineName + ", medicineQuantity=" + medicineQuantity + ", medicineTiming=" + medicineTiming
				+ ", medicineInstruction=" + medicineInstruction + ", medicineDuration=" + medicineDuration
				+ ", float1=" + float1 + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2="
				+ string2 + ", delstatus=" + delstatus + "]";
	}

	public void setDelstatus(int delstatus) {
		this.delstatus = delstatus;
	}
 
}

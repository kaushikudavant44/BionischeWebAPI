package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="priscription_bill")
public class SubmitPrescBill {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prescription_bill_id")
	private int prescBillId;
	
	@Column(name="medical_request_id")
	private int medicalRequestId;
	
	@Column(name="price")
	private float price;
	
	@Column(name="medicine_id")
	private int medicineId;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="bill_date")
	private String billDate;

	public int getPrescBillId() {
		return prescBillId;
	}

	public void setPrescBillId(int prescBillId) {
		this.prescBillId = prescBillId;
	}

	public int getMedicalRequestId() {
		return medicalRequestId;
	}

	public void setMedicalRequestId(int medicalRequestId) {
		this.medicalRequestId = medicalRequestId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public int getMeetId() {
		return meetId;
	}

	public void setMeetId(int meetId) {
		this.meetId = meetId;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}

	public String getBillDate() {
		return DateConverter.convertToDMY(billDate);
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	
}

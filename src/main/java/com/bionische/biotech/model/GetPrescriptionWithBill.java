package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPrescriptionWithBill {
	
	

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
	
	@Column(name="payment_status")
	private int paymentStatus;
	
	@Column(name="deliver_status")
	private int DeliverStatus;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="total_bill")
	private float totalBill;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="bill_date")
	private String billDate;
	
	@Column(name = "medicine_name")
	private String medicineName;

	@Column(name = "medicine_quantity")
	private String medicineQuantity;

	
	
	public void setPrice(float price) {
		this.price = price;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

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

	public void setPrice(int price) {
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

	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
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
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
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

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getDeliverStatus() {
		return DeliverStatus;
	}

	public void setDeliverStatus(int deliverStatus) {
		DeliverStatus = deliverStatus;
	}

	@Override
	public String toString() {
		return "GetPrescriptionWithBill [prescBillId=" + prescBillId + ", medicalRequestId=" + medicalRequestId
				+ ", price=" + price + ", medicineId=" + medicineId + ", meetId=" + meetId + ", paymentStatus="
				+ paymentStatus + ", DeliverStatus=" + DeliverStatus + ", int1=" + int1 + ", int2=" + int2
				+ ", totalBill=" + totalBill + ", delStatus=" + delStatus + ", medicalId=" + medicalId + ", billDate="
				+ billDate + ", medicineName=" + medicineName + ", medicineQuantity=" + medicineQuantity + "]";
	}

	
}

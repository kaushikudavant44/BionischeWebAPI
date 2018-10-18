package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPrescriptionDetailsForOrder {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prescription_order_details_id")
	private int prescriptionOrderDetailsId;
	
	@Column(name="request_id")
	private int requestId;
	
	@Column(name="prescription_id")
	private int prescriptionId;
	
 
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private float price;
	
	@Column(name="status")
	private int status;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name = "medicine_name")
	private String medicineName;
 
	@Column(name = "medicine_timing")
	private String medicineTiming;

	@Column(name = "medicine_instruction")
	private String medicineInstruction;
	
	@Column(name = "medicine_duration",nullable=true)
	private String medicineDuration;

	public int getPrescriptionOrderDetailsId() {
		return prescriptionOrderDetailsId;
	}

	public void setPrescriptionOrderDetailsId(int prescriptionOrderDetailsId) {
		this.prescriptionOrderDetailsId = prescriptionOrderDetailsId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	 

	public String getMedicineTiming() {
		return medicineTiming;
	}

	public void setMedicineTiming(String medicineTiming) {
		this.medicineTiming = medicineTiming;
	}

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

	@Override
	public String toString() {
		return "GetPrescriptionDetailsForOrder [prescriptionOrderDetailsId=" + prescriptionOrderDetailsId
				+ ", requestId=" + requestId + ", prescriptionId=" + prescriptionId + ", quantity=" + quantity
				+ ", price=" + price + ", status=" + status + ", delStatus=" + delStatus + ", medicineName="
				+ medicineName + ", medicineTiming=" + medicineTiming + ", medicineInstruction=" + medicineInstruction
				+ ", medicineDuration=" + medicineDuration + "]";
	}

	 
	
	
}

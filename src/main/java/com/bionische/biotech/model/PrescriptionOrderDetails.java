package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prescription_order_details")
public class PrescriptionOrderDetails {
	
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
	
	@Column(name="delStatus")
	private int delStatus;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PrescriptionOrderDetails [prescriptionOrderDetailsId=" + prescriptionOrderDetailsId + ", requestId="
				+ requestId + ", prescriptionId=" + prescriptionId + ", quantity=" + quantity + ", price=" + price
				+ ", status=" + status + ", delStatus=" + delStatus + "]";
	}

	 

	 

	
	 
}

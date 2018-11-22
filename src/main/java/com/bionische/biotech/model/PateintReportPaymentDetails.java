package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PateintReportPaymentDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="report_id")
	private int reportId;
	
	@Column(name="report_date")
	private String reportDate;
	
	@Column(name="lab_name")
	private String labName;
	
	@Column(name="report_file_name")
	private String reportFileName;
	
	@Column(name="payment_status")
	private int paymentStatus;
	
	@Column(name="lab_test_name")
	private String labTestName;

	@Column(name="lab_test_id")
	private int labTestId;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="amount_type")
	private int amountType;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="total_amount")
	private float totalAmount;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getReportFileName() {
		return reportFileName;
	}

	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getLabTestName() {
		return labTestName;
	}

	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
	}

	public int getLabTestId() {
		return labTestId;
	}

	public void setLabTestId(int labTestId) {
		this.labTestId = labTestId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getAmountType() {
		return amountType;
	}

	public void setAmountType(int amountType) {
		this.amountType = amountType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "PateintReportPaymentDetails [reportId=" + reportId + ", reportDate=" + reportDate + ", labName="
				+ labName + ", reportFileName=" + reportFileName + ", paymentStatus=" + paymentStatus + ", labTestName="
				+ labTestName + ", labTestId=" + labTestId + ", createdDate=" + createdDate + ", amountType="
				+ amountType + ", amount=" + amount + ", discount=" + discount + ", totalAmount=" + totalAmount + "]";
	}
	
	
	
	
	
	
}

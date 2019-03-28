package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="t_lab_subscription_details")
@EntityListeners(AuditingEntityListener.class)
public class LabSubscriptionDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="suscription_id")
	private int suscriptionId;
	
	@Column(name="lab_id")
	private int labId;
	
	@Column(name="package_id")
	private int packageId;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="order_id")
	private String orderId;
	
	@Column(name = "payment_date")
	private String paymentDate;
	
	@Column(name="package_exp_date")
	private String packageExpDate;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name="txn_status")
	private int txnStatus;
	
	@Column(name="offer_id")
	private int offerId;
	
	@Column(name="package_amt")
	private float packageAmt;
	
	public int getSuscriptionId() {
		return suscriptionId;
	}

	public void setSuscriptionId(int suscriptionId) {
		this.suscriptionId = suscriptionId;
	}
 

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getPackageExpDate() {
		return packageExpDate;
	}

	public void setPackageExpDate(String packageExpDate) {
		this.packageExpDate = packageExpDate;
	}

 

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

 

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public int getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(int txnStatus) {
		this.txnStatus = txnStatus;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getPaymentDate() {
		return DateConverter.convertToDMY(paymentDate);
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public float getPackageAmt() {
		return packageAmt;
	}

	public void setPackageAmt(float packageAmt) {
		this.packageAmt = packageAmt;
	}

	@Override
	public String toString() {
		return "LabSubscriptionDetails [suscriptionId=" + suscriptionId + ", labId=" + labId + ", packageId="
				+ packageId + ", amount=" + amount + ", delStatus=" + delStatus + ", orderId=" + orderId
				+ ", paymentDate=" + paymentDate + ", packageExpDate=" + packageExpDate + ", txnId=" + txnId
				+ ", txnStatus=" + txnStatus + ", offerId=" + offerId + ", packageAmt=" + packageAmt + "]";
	}
 
	 

	 
	 

	 
	 
	
	
}

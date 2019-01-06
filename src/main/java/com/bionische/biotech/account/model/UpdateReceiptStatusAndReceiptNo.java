package com.bionische.biotech.account.model;

import java.util.List;

public class UpdateReceiptStatusAndReceiptNo {

	int receiptNo;
	List<Integer> appointmentId;
	public int getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}
	public List<Integer> getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(List<Integer> appointmentId) {
		this.appointmentId = appointmentId;
	}
	@Override
	public String toString() {
		return "UpdateReceiptStatusAndReceiptNo [receiptNo=" + receiptNo + ", appointmentId=" + appointmentId + "]";
	}
	 
	
	
}

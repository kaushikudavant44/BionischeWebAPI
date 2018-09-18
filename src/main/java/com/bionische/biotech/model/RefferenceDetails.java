package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="refference_details")
public class RefferenceDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="refference_id")
	private int refferenceId;
	
	@Column(name="sender_id")
	private int sender_id;
	
	@Column(name="receiver")
	private String receiver_address;
	 
	@Column(name="refference_code")
	private String refferenceCode;
	
	@Column(name="status")
	private int status;

	public int getRefferenceId() {
		return refferenceId;
	}

	public void setRefferenceId(int refferenceId) {
		this.refferenceId = refferenceId;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public String getReceiver_address() {
		return receiver_address;
	}

	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}

	public String getRefferenceCode() {
		return refferenceCode;
	}

	public void setRefferenceCode(String refferenceCode) {
		this.refferenceCode = refferenceCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RefferenceDetails [refferenceId=" + refferenceId + ", sender_id=" + sender_id + ", receiver_address="
				+ receiver_address + ", refferenceCode=" + refferenceCode + ", status=" + status + "]";
	}
	
	
	
	

}

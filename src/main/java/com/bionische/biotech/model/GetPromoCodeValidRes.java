package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity

public class GetPromoCodeValidRes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="offer_id")
	private int offerId;

	
	@Transient
	private String message;
	
	@Column(name="discount_per")
	private float discountPer;
	
	 @Transient
	private boolean isError;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
	}

	 

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	@Override
	public String toString() {
		return "GetPromoCodeValidRes [offerId=" + offerId + ", message=" + message + ", discountPer=" + discountPer
				+ ", isError=" + isError + "]";
	}

	 
}

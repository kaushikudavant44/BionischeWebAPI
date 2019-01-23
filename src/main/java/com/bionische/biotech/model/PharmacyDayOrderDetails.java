package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PharmacyDayOrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_count")
	private int orderCount;
	
	@Column(name="collection")
	private int collection;

	@Column(name="delivered")
	private int delivered;

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public int getDelivered() {
		return delivered;
	}

	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}

	@Override
	public String toString() {
		return "PharmacyDayOrderDetails [orderCount=" + orderCount + ", collection=" + collection + ", delivered="
				+ delivered + "]";
	}


	
}

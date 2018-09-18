package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetRatingCount {
	
	
	@Column(name="count")
	private int count;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rating")
	private int rating;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "GetRatingCount [count=" + count + ", rating=" + rating + "]";
	}
	
	
	

}

package com.bionische.biotech.model;

import java.util.List;

public class StemCellRatingDetailsList {
	
   
    public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getStemcell_id() {
		return stemcell_id;
	}

	public void setStemcell_id(int stemcell_id) {
		this.stemcell_id = stemcell_id;
	}

	private float rating;
	
    List<GetPatientReviews> getPatientReviews;
	
	public List<GetPatientReviews> getGetPatientReviews() {
		return getPatientReviews;
	}

	public void setGetPatientReviews(List<GetPatientReviews> getPatientReviews) {
		this.getPatientReviews = getPatientReviews;
	}

	private int stemcell_id;

	@Override
	public String toString() {
		return "StemRatingDetailsList [rating=" + rating + ", getPatientReviews=" + getPatientReviews + ", stemcell_id="
				+ stemcell_id + "]";
	}

	
	
		
}






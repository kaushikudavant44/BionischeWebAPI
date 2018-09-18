package com.bionische.biotech.history.repository;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stemcellrating_details")
public class StemcellRatingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rating_review_id")
	private int ratingReviewId;
	
	@Column(name="stemcell_id")
	private int stemCellId;
	
	@Column(name="rating")
	private float rating;
	
	@Column(name="review")
	private String review;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="patient_name")
   private String patientName;
	
	@Column(name="int_1")
     private int int1;
	
	@Column(name="int_2")
      private int int2;
	
	@Column(name="string_1")
     private String string1;
    
	@Column(name="string_2")
    private String string2;
	
	@Column(name="del_status")
   private int delStatus;
    
	
	
	 

}

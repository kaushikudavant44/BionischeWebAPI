package com.bionische.biotech.stemcell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetStemcellBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="stemcellbank_id")
	private int stemCellBankId;
	
	
	@Column(name="stemcellbank_name")
    private String stemCellBankName;    
	
	      
	@Column(name="city_id")
	private int stemCellBankcityId;
	
	     
	@Column(name="address")
     private String stemCellBankAddress;
	
	@Column(name="contact1")
    private String contact1;
	
    @Column(name="email_id")
    private String emailId;
	

	@Column(name="rating")
	private int rating;





	public int getStemCellBankId() {
		return stemCellBankId;
	}





	public void setStemCellBankId(int stemCellBankId) {
		this.stemCellBankId = stemCellBankId;
	}





	public String getStemCellBankName() {
		return stemCellBankName;
	}





	public void setStemCellBankName(String stemCellBankName) {
		this.stemCellBankName = stemCellBankName;
	}





	

   public int getStemCellBankcityId() {
		return stemCellBankcityId;
	}





	public void setStemCellBankcityId(int stemCellBankcityId) {
		this.stemCellBankcityId = stemCellBankcityId;
	}





	public String getStemCellBankAddress() {
		return stemCellBankAddress;
	}





	public void setStemCellBankAddress(String stemCellBankAddress) {
		this.stemCellBankAddress = stemCellBankAddress;
	}





	public String getContact1() {
		return contact1;
	}





	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}





	public String getEmailId() {
		return emailId;
	}





	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}





	public int getRating() {
		return rating;
	}





	public void setRating(int rating) {
		this.rating = rating;
	}





	@Override
	public String toString() {
		return "GetStemcellBankDetails [stemCellBankId=" + stemCellBankId + ", stemCellBankName=" + stemCellBankName
				+ ", stemCellBankcityId=" + stemCellBankcityId + ", stemCellBankAddress=" + stemCellBankAddress
				+ ", contact1=" + contact1 + ", emailId=" + emailId + ", rating=" + rating + "]";
	}





	




	


	

	
}

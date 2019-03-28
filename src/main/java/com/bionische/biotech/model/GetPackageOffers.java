package com.bionische.biotech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.bionische.biotech.Common.DateConverter;

@Entity
 
public class GetPackageOffers {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="offer_id")
	private int offerId;
	
	@Column(name="package_id")
	private int packageId;
	
	@Column(name="offer_title")
	private String offerTitle;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;
	
	@Column(name="user_type")
	private int userType;

	@Column(name="discount_per")
	private float discountPer;
	
	@Column(name="terms_and_condition")
	private String termsAndCondition;
	
	
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	/** Last modified date */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	

	@Column(name="del_status")
	private int delStatus;
	
		
	@Column(name="promo_code")
	private String promoCode;
	
	@Column(name="max_user")
	private int maxUser;
	
	@Column(name="current_user_count")
	private int currentUserCount;
	
	@Column(name="package_name")
	private String packageName;
	
	@Column(name="package_cost")
	private int packageCost;
	
	@Column(name="package_duration")
	private int packageDuration;
	
	@Column(name="duration_type")
	private int durationType;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getOfferTitle() {
		return offerTitle;
	}

	public void setOfferTitle(String offerTitle) {
		this.offerTitle = offerTitle;
	}

	public String getStartDate() {
		return DateConverter.convertToDMY(startDate);
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return DateConverter.convertToDMY(endDate);
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	 
	public String getTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	public Date getCreateDate() {
		return  createDate;
	}
 

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

 

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public int getMaxUser() {
		return maxUser;
	}

	public void setMaxUser(int maxUser) {
		this.maxUser = maxUser;
	}

	public int getCurrentUserCount() {
		return currentUserCount;
	}

	public void setCurrentUserCount(int currentUserCount) {
		this.currentUserCount = currentUserCount;
	}

	public float getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(int packageCost) {
		this.packageCost = packageCost;
	}

	public int getPackageDuration() {
		return packageDuration;
	}

	public void setPackageDuration(int packageDuration) {
		this.packageDuration = packageDuration;
	}

	public int getDurationType() {
		return durationType;
	}

	public void setDurationType(int durationType) {
		this.durationType = durationType;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "GetPackageOffers [offerId=" + offerId + ", packageId=" + packageId + ", offerTitle=" + offerTitle
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", userType=" + userType + ", discountPer="
				+ discountPer + ", termsAndCondition=" + termsAndCondition + ", createDate=" + createDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", delStatus=" + delStatus + ", promoCode=" + promoCode
				+ ", maxUser=" + maxUser + ", currentUserCount=" + currentUserCount + ", packageName=" + packageName
				+ ", packageCost=" + packageCost + ", packageDuration=" + packageDuration + ", durationType="
				+ durationType + "]";
	}

	 

	 
	 
	
}

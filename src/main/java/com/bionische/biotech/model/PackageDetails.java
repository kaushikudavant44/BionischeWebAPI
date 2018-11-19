package com.bionische.biotech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="m_package")
@EntityListeners(AuditingEntityListener.class)
public class PackageDetails {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="package_id")
	private int packageId;
	
	@Column(name="package_name")
	private String packageName;
 
	
	@Column(name="user_type")
	private int userType;
 
	
	@Column(name="package_desc")
	private String packageDesc;
	
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
	
	@Column(name="packageDuration")
	private int packageDuration;
	
	@Column(name="duration_type")
	private int durationType;
	
	
	@Column(name="package_cost")
	private int packageCost;


	public int getPackageId() {
		return packageId;
	}


	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public int getUserType() {
		return userType;
	}


	public void setUserType(int userType) {
		this.userType = userType;
	}


	public String getPackageDesc() {
		return packageDesc;
	}


	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}


	public String getTermsAndCondition() {
		return termsAndCondition;
	}


	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}


	public Date getCreateDate() {
		return createDate;
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


 

	public int getPackageDuration() {
		return packageDuration;
	}


	public void setPackageDuration(int packageDuration) {
		this.packageDuration = packageDuration;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public int getDurationType() {
		return durationType;
	}


	public void setDurationType(int durationType) {
		this.durationType = durationType;
	}


	public int getPackageCost() {
		return packageCost;
	}


	public void setPackageCost(int packageCost) {
		this.packageCost = packageCost;
	}


	@Override
	public String toString() {
		return "PackageDetails [packageId=" + packageId + ", packageName=" + packageName + ", userType=" + userType
				+ ", packageDesc=" + packageDesc + ", termsAndCondition=" + termsAndCondition + ", createDate="
				+ createDate + ", lastModifiedDate=" + lastModifiedDate + ", delStatus=" + delStatus
				+ ", packageDuration=" + packageDuration + ", durationType=" + durationType + ", packageCost="
				+ packageCost + "]";
	}


	 
	
	
}

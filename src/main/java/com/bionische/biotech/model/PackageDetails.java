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

@Entity
@Table(name="m_package")
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
	private int package_duration;
	
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


	public int getPackage_duration() {
		return package_duration;
	}


	public void setPackage_duration(int package_duration) {
		this.package_duration = package_duration;
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
				+ ", package_duration=" + package_duration + ", durationType=" + durationType + ", packageCost="
				+ packageCost + "]";
	}
	
	
}

package com.bionische.biotech.stemcell.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stemcellplan_details")
public class PlanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@Column(name="plan_id")  
	private int planId;
	
	@Column(name="stemcellbank_id")  
  private int stemCellBankId;
	
	@Column(name="plan_name")  
private String planName;             
	
	@Column(name="plan_cost")  
 private String planCost;
	    
	@Column(name="plan_days")  
	private String planDays;
	
	@Column(name="message")  
private String message;
	@Column(name="plan_type")  
	private String planType;
	
	@Column(name="terms_condition")  
private String termsCondition;
	


public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}

public int getStemCellBankId() {
	return stemCellBankId;
}
public void setStemCellBankId(int stemCellBankId) {
	this.stemCellBankId = stemCellBankId;
}
public String getPlanName() {
	return planName;
}
public void setPlanName(String planName) {
	this.planName = planName;
}
public String getPlanCost() {
	return planCost;
}
public void setPlanCost(String planCost) {
	this.planCost = planCost;
}
public String getPlanDays() {
	return planDays;
}
public void setPlanDays(String planDays) {
	this.planDays = planDays;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getTermsCondition() {
	return termsCondition;
}
public void setTermsCondition(String termsCondition) {
	this.termsCondition = termsCondition;
}
public int getPlanId() {
	return planId;
}
public void setPlanId(int planId) {
	this.planId = planId;
}
@Override
public String toString() {
	return "plan_details [planId=" + planId + ", stemCellBankId=" + stemCellBankId + ", planName=" + planName
			+ ", planCost=" + planCost + ", planDays=" + planDays + ", message=" + message + ", planType=" + planType
			+ ", termsCondition=" + termsCondition + "]";
}



}

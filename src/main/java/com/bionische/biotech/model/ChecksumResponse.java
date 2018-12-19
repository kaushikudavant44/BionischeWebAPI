package com.bionische.biotech.model;

public class ChecksumResponse {


    private String callbackUrl;

    private String channelId;


    private String checksumHash;

    private String custId;


    private String email;

    private String industryId;


    private String mid;

    private String mobileNo;
    
    private String orderId;

    private String txnAmount;


    private String website;


    
    
    
	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getCallbackUrl() {
		return callbackUrl;
	}


	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}


	public String getChannelId() {
		return channelId;
	}


	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}


	public String getChecksumHash() {
		return checksumHash;
	}


	public void setChecksumHash(String checksumHash) {
		this.checksumHash = checksumHash;
	}


	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getIndustryId() {
		return industryId;
	}


	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getTxnAmount() {
		return txnAmount;
	}


	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	@Override
	public String toString() {
		return "ChecksumResponse [callbackUrl=" + callbackUrl + ", channelId=" + channelId + ", checksumHash="
				+ checksumHash + ", custId=" + custId + ", email=" + email + ", industryId=" + industryId + ", mid="
				+ mid + ", mobileNo=" + mobileNo + ", orderId=" + orderId + ", txnAmount=" + txnAmount + ", website="
				+ website + "]";
	}


	
    

}

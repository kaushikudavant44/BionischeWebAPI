package com.bionische.biotech.controller;

import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Checksum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.ChecksumResponse;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.Common.PaytmConstants;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@RestController
public class PaymentApiController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentApiController.class);

	@RequestMapping(value = { "/getChecksumhash" }, method = RequestMethod.POST)
	public @ResponseBody Info getChecksumhash(@RequestParam(name = "orderId") String orderId,
			@RequestParam(name = "custId") String custId, @RequestParam(name = "txnId") String txnId,
			@RequestParam(name = "mobileNo") String mobileNo, @RequestParam(name = "email") String email) {
		Info info = new Info();
		try {

			TreeMap<String, String> parameters = new TreeMap<String, String>();
			String paytmChecksum = "";

			parameters.put("MID", PaytmConstants.MID);
			parameters.put("ORDER_ID", orderId);
			parameters.put("CUST_ID", custId);
			parameters.put("INDUSTRY_TYPE_ID", PaytmConstants.INDUSTRY_TYPE_ID);
			parameters.put("CHANNEL_ID", PaytmConstants.CHANNEL_ID);
			parameters.put("TXN_AMOUNT", "1");
			parameters.put("WEBSITE", PaytmConstants.WEBSITE);

			String checkSum = CheckSumServiceHelper.getCheckSumServiceHelper()
					.genrateCheckSum(PaytmConstants.MERCHANT_KEY, parameters);

			logger.info("checksum is " + checkSum);

			info.setError(false);
			info.setMessage(checkSum);

		} catch (Exception e) {

			info.setError(true);
			info.setMessage(e.getMessage());
			System.out.println(e.getMessage());
		}
		return info;

	}

	@RequestMapping(value = { "/checksumGeneration" }, method = RequestMethod.POST)
	public @ResponseBody ChecksumResponse checksumGeneration(@RequestParam(name = "orderId") String orderId,
			@RequestParam(name = "custId") String custId, @RequestParam(name = "txnAmt") String txnAmt,
			@RequestParam(name = "mobileNo") String mobileNo, @RequestParam(name = "email") String email) {

		ChecksumResponse checksumResponse = new ChecksumResponse();

		TreeMap<String, String> paramMap = new TreeMap<String, String>();

		paramMap.put("MID", PaytmConstants.MID);
		paramMap.put("ORDER_ID", orderId);
		paramMap.put("CUST_ID", custId);
		paramMap.put("INDUSTRY_TYPE_ID", PaytmConstants.INDUSTRY_TYPE_ID);
		paramMap.put("TXN_AMOUNT", txnAmt);
		paramMap.put("CHANNEL_ID", PaytmConstants.CHANNEL_ID);
		paramMap.put("WEBSITE", PaytmConstants.WEBSITE);
		paramMap.put("EMAIL", email);
		paramMap.put("MOBILE_NO", mobileNo);
		paramMap.put("CALLBACK_URL", PaytmConstants.CALLBACK_URL + orderId);

		checksumResponse.setCallbackUrl(PaytmConstants.CALLBACK_URL + orderId);
		checksumResponse.setChannelId(PaytmConstants.CHANNEL_ID);
		checksumResponse.setCustId(custId);
		checksumResponse.setEmail(email);
		checksumResponse.setIndustryId(PaytmConstants.INDUSTRY_TYPE_ID);
		checksumResponse.setMid(PaytmConstants.MID);
		checksumResponse.setMobileNo(mobileNo);
		checksumResponse.setOrderId(orderId);
		checksumResponse.setTxnAmount(txnAmt);
		checksumResponse.setWebsite(PaytmConstants.WEBSITE);
	
		Info info = new Info();

		try {
			String checkSum = CheckSumServiceHelper.getCheckSumServiceHelper()
					.genrateCheckSum(PaytmConstants.MERCHANT_KEY, paramMap);
			paramMap.put("CHECKSUMHASH", checkSum);

			checksumResponse.setChecksumHash(checkSum);

			System.out.println("Paytm Payload: " + checksumResponse.toString());

			info.setMessage(checkSum);
			info.setError(false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return checksumResponse;

	}

	/*
	 * @RequestMapping(value = { "/checksumVerification" }, method =
	 * RequestMethod.POST) public @ResponseBody Info
	 * checksumVerification(@RequestBody ChecksumResponse response) { Info info =
	 * new Info();
	 * 
	 * String paytmChecksum = "";
	 * 
	 * Map<String, String> mapData = new TreeMap<String,String>(); mapData.put("MID"
	 * , response.getMID()); mapData.put("ORDER_ID" , response.getORDER_ID());
	 * mapData.put("CUST_ID" , response.getCUST_ID());
	 * mapData.put("INDUSTRY_TYPE_ID" , response.getINDUSTRY_TYPE_ID());
	 * mapData.put("CHANNEL_ID" , response.getCHANNEL_ID());
	 * mapData.put("TXN_AMOUNT" , response.getTXN_AMOUNT()); mapData.put("WEBSITE" ,
	 * response.getWEBSITE()); mapData.put("EMAIL" , response.getEMAIL());
	 * mapData.put("MOBILE_NO" , response.getMOBILE_NO());
	 * mapData.put("CALLBACK_URL" , response.getCALLBACK_URL());
	 * mapData.put("CHECKSUMHASH" , response.getCHECKSUMHASH());
	 * 
	 * 
	 * TreeMap<String, String> paytmParams = new TreeMap<String,String>();
	 * 
	 * for (Map.Entry<String, String> entry : mapData.entrySet()) {
	 * if(entry.getKey().equals("CHECKSUMHASH")){ paytmChecksum = entry.getKey();
	 * }else{ paytmParams.put(entry.getKey(), entry.getValue()); } }
	 * 
	 * 
	 * boolean isValideChecksum = false; try{
	 * 
	 * isValideChecksum =
	 * CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(
	 * PaytmConstants.MERCHANT_KEY, paytmParams, paytmChecksum);
	 * 
	 * info.setError(isValideChecksum); info.setMessage("checksumvalidation");
	 * 
	 * System.out.println(isValideChecksum);
	 * 
	 * // if checksum is validated Kindly verify the amount and status // if
	 * transaction is successful // kindly call Paytm Transaction Status API and
	 * verify the transaction amount and status. // If everything is fine then mark
	 * that transaction as successful into your DB.
	 * 
	 * 
	 * }catch(Exception e){ e.printStackTrace();
	 * 
	 * info.setError(true); info.setMessage("excep: "+e.getMessage());
	 * 
	 * } return info;
	 * 
	 * }
	 */

}

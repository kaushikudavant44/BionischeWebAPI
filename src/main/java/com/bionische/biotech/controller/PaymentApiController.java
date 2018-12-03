package com.bionische.biotech.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.Common.PaytmConstants;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@RestController
public class PaymentApiController {

	// @RequestParam("patientId") int patientId,@RequestParam("password") String
	// password

	
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentApiController.class);

	@RequestMapping(value = { "/getChecksumhash" }, method = RequestMethod.POST)
	public @ResponseBody Info getChecksumhash(@RequestParam( name ="orderId") String orderId,@RequestParam( name ="custId") String custId,@RequestParam( name ="txnId") String txnId,@RequestParam( name ="mobileNo") String mobileNo,@RequestParam(name ="email") String email) {
		Info info = new Info();
		try {

			TreeMap<String,String> parameters = new TreeMap<String,String>();
			String paytmChecksum =  "";
			
/*			paramMap.put( “ORDER_ID” , “ORDER0000000001”);
			paramMap.put( “CUST_ID” , “10000988111”);
			paramMap.put( “TXN_AMOUNT” , “1”);
*/

			
			parameters.put("MID",PaytmConstants.MID);
			parameters.put("CHANNEL_ID",PaytmConstants.CHANNEL_ID);
			parameters.put("INDUSTRY_TYPE_ID",PaytmConstants.INDUSTRY_TYPE_ID);
			parameters.put("WEBSITE",PaytmConstants.WEBSITE);
			parameters.put("MOBILE_NO", mobileNo);
			parameters.put("EMAIL", email);
			parameters.put("CUST_ID", custId);
			parameters.put("ORDER_ID", orderId);
			parameters.put("TXN_AMOUNT", txnId);

			parameters.put("CALLBACK_URL", "http://192.168.2.18:8081/paytm/response");
		
			String checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(PaytmConstants.MERCHANT_KEY, parameters);
				
			logger.info("checksum is "+checkSum);
			
			info.setError(false);
			info.setMessage(checkSum);
			
			
		} catch (Exception e) {
			
			info.setError(true);
			info.setMessage(e.getMessage());
			System.out.println(e.getMessage());
		}
		return info;

	}

}

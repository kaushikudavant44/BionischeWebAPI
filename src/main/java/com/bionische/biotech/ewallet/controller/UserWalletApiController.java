package com.bionische.biotech.ewallet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.ewallet.model.GetWalletTransactionDetails;
import com.bionische.biotech.ewallet.model.UserWalletDetails;
import com.bionische.biotech.ewallet.repository.GetWalletTransactionDetailsRepository;
import com.bionische.biotech.ewallet.repository.UserWalletDetailsRepository;
import com.bionische.biotech.ewallet.repository.UserWalletTransactionRepository;

@RestController
public class UserWalletApiController {

	@Autowired
	private UserWalletTransactionRepository userWalletTransactionRepository;
	
	@Autowired 
	private GetWalletTransactionDetailsRepository getWalletTransactionDetailsRepository;
	
	@Autowired
	private UserWalletDetailsRepository userWalletDetailsRepository;

	
	
	/*
	 * @author Ganesh
	 * get user All wallet  details 
	*/
	@RequestMapping(value = { "/getUserWalletDetails" }, method = RequestMethod.POST)
	public @ResponseBody UserWalletDetails getUserWalletDetails(@RequestParam("userId") int userId, @RequestParam("userType") int userType)
	{
		UserWalletDetails userWalletDetails=new UserWalletDetails();
		try {
		 
			userWalletDetails=	userWalletDetailsRepository.findByUserIdAndUserType(userId, userType);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		} 
		
		return userWalletDetails;
	}
	
	/*
	 * @author Ganesh
	 * get user Latest 10 wallet transaction records 
	*/
	@RequestMapping(value = { "/getUserLatestTransactionDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWalletTransactionDetails> getUserLatestTransactionDetails(@RequestParam("userId") int userId, @RequestParam("userType") int userType)
	{
		List<GetWalletTransactionDetails> getWalletTransactionDetailsList=new ArrayList<GetWalletTransactionDetails>();
		try {
		 
			getWalletTransactionDetailsList=	getWalletTransactionDetailsRepository.getWalletLatestTransactionDetails(userId, userType);
			System.out.println("getWalletTransactionDetailsList  "+getWalletTransactionDetailsList.toString());
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		}
		
		return getWalletTransactionDetailsList;
	}
	
	/*
	 * @author Ganesh
	 * get user All wallet transaction records 
	*/
	@RequestMapping(value = { "/getUserAllTransactionDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWalletTransactionDetails> getUserAllTransactionDetails(@RequestParam("userId") int userId, @RequestParam("userType") int userType)
	{
		List<GetWalletTransactionDetails> getWalletTransactionDetailsList=new ArrayList<GetWalletTransactionDetails>();
		try {
		 
			getWalletTransactionDetailsList=	getWalletTransactionDetailsRepository.getWalletTransactionDetails(userId, userType);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			e.printStackTrace();
		} 
		
		return getWalletTransactionDetailsList;
	}
	 
}

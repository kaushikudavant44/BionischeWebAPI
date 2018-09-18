package com.bionische.biotech.insurance.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.insurance.model.AdultMember;
import com.bionische.biotech.insurance.model.ChildMemberDetails;
import com.bionische.biotech.insurance.model.CompaniesOnAge;
import com.bionische.biotech.insurance.model.CompanyFeatures;
import com.bionische.biotech.insurance.model.CoverDetails;
import com.bionische.biotech.insurance.model.GetBoughtInsuranceDetails;
import com.bionische.biotech.insurance.model.GetCompareInsuranceComapny;
import com.bionische.biotech.insurance.model.InsuranceCover;
import com.bionische.biotech.insurance.model.InsuranceCriticalFactor;
import com.bionische.biotech.insurance.model.InsurancePremiumDetails;
import com.bionische.biotech.insurance.model.InsuranceReview;
import com.bionische.biotech.insurance.model.MakePayment;
import com.bionische.biotech.insurance.model.ProposerDetails;
import com.bionische.biotech.insurance.repository.AdultMemberRepository;
import com.bionische.biotech.insurance.repository.ChildMemberDetailsRepository;
import com.bionische.biotech.insurance.repository.CompaniesOnAgeRepository;
import com.bionische.biotech.insurance.repository.CompanyFeaturesReposiory;
import com.bionische.biotech.insurance.repository.CoverDetailsRepository;
import com.bionische.biotech.insurance.repository.GetBoughtInsuranceDetailsRepository;
import com.bionische.biotech.insurance.repository.GetCompareInsuranceComapnyRepository;
import com.bionische.biotech.insurance.repository.InsuranceCompanyDetailsRepository;
import com.bionische.biotech.insurance.repository.InsuranceCriticalFactorReposiotory;
import com.bionische.biotech.insurance.repository.InsurancePremiumDetailsRepository;
import com.bionische.biotech.insurance.repository.InsuranceReviewRepository;
import com.bionische.biotech.insurance.repository.MakePaymentRepository;
import com.bionische.biotech.insurance.repository.ProposerDetailsRepository;
import com.bionische.biotech.model.Info;

@RestController
public class InsuranceDetailsController {
	
	
	
	@Autowired
	CompaniesOnAgeRepository companiesOnAgeRepository;
	
	@Autowired
	InsuranceReviewRepository insuranceReviewRepository;
	
	@Autowired
	CoverDetailsRepository coverDetailsRepository;
	
	@Autowired
	InsuranceCriticalFactorReposiotory insuranceCriticalFactorReposiotory;
	
	@Autowired
	ProposerDetailsRepository proposerDetailsRepository;
	
	@Autowired
	AdultMemberRepository adultMemberRepository;
	
	@Autowired
	ChildMemberDetailsRepository childMemberDetailsRepository;
	
	@Autowired
	InsuranceCompanyDetailsRepository insuranceCompanyDetailsRepository;
	
	@Autowired
	MakePaymentRepository makePaymentRepository;
	
	@Autowired
	CompanyFeaturesReposiory companyFeaturesReposiory;
	
	
	@Autowired
	GetBoughtInsuranceDetailsRepository getBoughtInsuranceDetailsRepository;
	
	

	@Autowired
	GetCompareInsuranceComapnyRepository getCompareInsuranceComapnyRepository;
	
	@Autowired
	InsurancePremiumDetailsRepository insurancePremiumDetailsRepository;
 
	
	
	@RequestMapping(value = { "/getInsuranceCompanies" }, method = RequestMethod.POST)
	public @ResponseBody List<CompaniesOnAge> getInsuranceCompanies(@RequestParam("age") String age,@RequestParam("membersType") String membersType) {
		
		
		Calendar c = Calendar.getInstance();
		int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);	
		
	System.out.println("In method:"+monthMaxDays);
	List<CompaniesOnAge> companiesList=new ArrayList<CompaniesOnAge>();
	List<CompaniesOnAge> companiesListTwo=new ArrayList<CompaniesOnAge>();
	
	List<CoverDetails> insuranceCover=new ArrayList<CoverDetails>();
	List<String> criticalFactors=new ArrayList<String>();
	try {
		System.out.println("age:"+age);
		System.out.println("membersType:"+membersType);
		companiesList=companiesOnAgeRepository.getInsuranceCompanies(age,membersType); 
	    System.out.println(companiesList.toString());
	    List<InsuranceReview> reviews=new ArrayList<InsuranceReview>();
	    List<CompanyFeatures> features=new ArrayList<CompanyFeatures>();
	    for (CompaniesOnAge companies : companiesList) 
	    {
	    	CompaniesOnAge companiesOnAge=new CompaniesOnAge();
	    	int id=companies.getCompanyId();
	    	System.out.println("id:"+id);
	    	companiesOnAge.setCompanyId(id);
	    	companiesOnAge.setBetweenAge(age);
	    	companiesOnAge.setCompanyName(companies.getCompanyName());
	    	companiesOnAge.setRatings(companies.getRatings());
	    	companiesOnAge.setPremiumId(companies.getPremiumId());
	    	companiesOnAge.setMembersType(companies.getMembersType());
	    	
	    		
	    		insuranceCover=	coverDetailsRepository.getCompaniesCover(id,age,membersType);
	    		
	    		int monthPremium=insuranceCover.get(0).getPremium();
	    		int premiumPerday=monthPremium/monthMaxDays;
	    		
	    		criticalFactors=	insuranceCriticalFactorReposiotory.getCriticalFactors(id);
	    		reviews=insuranceReviewRepository.getReviewByCompanyId(id); 
	    		features=companyFeaturesReposiory.getFeaturesById(id);
	    		System.out.println("done:"+reviews.toString());
	    	companiesOnAge.setCoverDetails(insuranceCover);
	    	companiesOnAge.setCriticalFactors(criticalFactors);
	    	companiesOnAge.setInsuranceReview(reviews);
	    	companiesOnAge.setCompanyFeatures(features);
	    	companiesOnAge.setPremiumPerday(premiumPerday);
	    	companiesListTwo.add(companiesOnAge);
	    	System.out.println("firstdone:"+companiesOnAge.toString());
	    	
	    }
	   
	   
	}
	
	
	catch (Exception e) {
		System.out.println(e.getMessage());
		 
	}

	System.out.println("companiesOnAgefinal:"+companiesListTwo.toString());

	return companiesListTwo;
}


	@RequestMapping(value = { "/getPremiumByCover" }, method = RequestMethod.POST)
	public @ResponseBody int getPremiumByCover(@RequestParam("cover") int cover)
	{
		
		int premium=0;
	    System.out.println("In method");
	
	try {
		
		premium=companiesOnAgeRepository.getPremiumByCover(cover); 
	    System.out.println("premium:"+premium);
   
	}
	
	
	catch (Exception e) {
		System.out.println(e.getMessage());
		 
	}

	return premium;
}

	@RequestMapping(value = { "/getReviewByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<InsuranceReview> getReviewByCompanyId(@RequestParam("companyId") int companyId) {
		
		 List<InsuranceReview> reviews=new ArrayList<InsuranceReview>();
	System.out.println("In method");
	
	try {
		
		reviews=insuranceReviewRepository.getReviewByCompanyId(companyId); 
	    System.out.println("companyId:"+companyId);
   
	}
	
	
	catch (Exception e) {
		System.out.println(e.getMessage());
		 
	}

	return reviews;
}

	@RequestMapping(value = { "/insertInsuranceRegistrationDetails" }, method = RequestMethod.POST)
	public @ResponseBody MakePayment insertInsuranceRegistrationDetails(@RequestBody ProposerDetails proposerDetails) {
	
		int insuRegistrationId;
		String companyName;
		Info info=new Info();
		MakePayment makePayment=new MakePayment();
		
		ProposerDetails proposerDetailsRes=proposerDetailsRepository.save(proposerDetails);
		if(proposerDetailsRes!=null)
		{
		 insuRegistrationId=proposerDetailsRes.getInsuRegistrationId();
		 companyName  =insuranceCompanyDetailsRepository.getCompanyName(proposerDetailsRes.getCompanyId());
		
		
		for(int i=0;i<proposerDetails.getAdultMemberList().size();i++)
		{
		proposerDetails.getAdultMemberList().get(i).setInsuRegistrationId(insuRegistrationId);
			
		adultMemberRepository.save(proposerDetails.getAdultMemberList().get(i));
		}
		
		for(int i=0;i<proposerDetails.getChildMemberDetailsList().size();i++)
		{
			proposerDetails.getChildMemberDetailsList().get(i).setInsuRegId(insuRegistrationId);
			childMemberDetailsRepository.save(proposerDetails.getChildMemberDetailsList().get(i));
		}
		
		info.setError(false);
		info.setMessage("Insurance Buy Successfully");
		
		makePayment.setAppId(insuRegistrationId);
		makePayment.setCompanyName(companyName);
		makePayment.setCover(proposerDetailsRes.getCover());
		makePayment.setPremium(proposerDetailsRes.getPremium());
		
		}
		else {
			info.setError(true);
			info.setMessage("Problem Insurance Buy!!");
		}
		return makePayment;
		
	}
	
	
	
	@RequestMapping(value = { "/getBoughtInsuDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<MakePayment> getBoughtInsuDetails(@RequestParam("familyId") int familyId) {
	
		
		List<MakePayment> makePayment=new ArrayList<MakePayment>();
		makePayment=makePaymentRepository.getBoughtInsuDetails(familyId);
		
		return makePayment;
		
	}

	
	
	

	@RequestMapping(value = { "/getBoughtInsuDetailsByAppId" }, method = RequestMethod.POST)
	public @ResponseBody GetBoughtInsuranceDetails getBoughtInsuDetailsByInsuRegId(@RequestParam("insuRegId") int insuRegId) {
		
	System.out.println("In method"+insuRegId);
	 
	GetBoughtInsuranceDetails getBoughtInsuranceDetails=new GetBoughtInsuranceDetails();
	
	try {
	getBoughtInsuranceDetails=getBoughtInsuranceDetailsRepository.getBoughtInsuranceDetails(insuRegId);
	System.out.println("came:"+getBoughtInsuranceDetails.toString());
	
	List<AdultMember> getInsuranceAdultInfoList=new ArrayList<AdultMember>();
	
	List<ChildMemberDetails> getInsuranceChildInfoList=new ArrayList<ChildMemberDetails>();
	
	if(getBoughtInsuranceDetails!=null )
	{
		System.out.println("came");
		getInsuranceAdultInfoList=adultMemberRepository.getInsuranceAdultInfoList(insuRegId);
		
		getInsuranceChildInfoList=childMemberDetailsRepository.getInsuranceChildInfoList(insuRegId);
		System.out.println("getInsuranceAdultInfoList:"+getInsuranceAdultInfoList.toString());
		System.out.println("getInsuranceChildInfoList:"+getInsuranceChildInfoList.toString());
	}
	
	getBoughtInsuranceDetails.setAdultMemberList(getInsuranceAdultInfoList);
	getBoughtInsuranceDetails.setChildMemberList(getInsuranceChildInfoList);
	
	System.out.println("done:"+getBoughtInsuranceDetails.toString());
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return getBoughtInsuranceDetails;
}

	@RequestMapping(value = { "/getAllCompareInsuranceComapny" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCompareInsuranceComapny> getAllCompareInsuranceComapny(@RequestParam("companyId")List<String>companyId,@RequestParam("cover")List<String>cover,@RequestParam("premium")List<String>premium) {
		
		
		System.out.println("Comming data  "+companyId.toString()); 
		 
		 
		List<GetCompareInsuranceComapny> getCompareInsuranceComapnyList=new ArrayList<>();
		 
		
		
		
		  
		  
		  for (int i=0;i<companyId.size();i++)
		    {
			  GetCompareInsuranceComapny getCompareInsuranceComapny=new GetCompareInsuranceComapny();
		
		 
			  
			  getCompareInsuranceComapny=getCompareInsuranceComapnyRepository.getCompanyToCompare(Integer.parseInt(companyId.get(i)),Integer.parseInt(cover.get(i)));
			  getCompareInsuranceComapny.setInt1(Integer.parseInt(premium.get(i)));
			  
			  getCompareInsuranceComapnyList.add(getCompareInsuranceComapny);
		    }
		  System.out.println("Comming data  1 "+getCompareInsuranceComapnyList.toString()); 
		  
		 
		return getCompareInsuranceComapnyList;
		
	}
	 
	@RequestMapping(value = { "/insertInsurancePremiumDetails" }, method = RequestMethod.POST)
	public @ResponseBody InsurancePremiumDetails insertInsurancePremiumDetails(@RequestBody InsurancePremiumDetails insurancePremiumDetails)
	{
		System.out.println("Comming List "+insurancePremiumDetails.toString());
		InsurancePremiumDetails insurancePremiumDetailsRes=new InsurancePremiumDetails();
		 
		try {
			insurancePremiumDetailsRes=insurancePremiumDetailsRepository.save(insurancePremiumDetails); 
		System.out.println(insurancePremiumDetailsRes.toString());
		   
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return insurancePremiumDetailsRes;
	}
	
	
	
}


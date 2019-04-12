package com.bionische.biotech.adminpanel3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.adminpanel3d.model.Category3DModel;
import com.bionische.biotech.adminpanel3d.model.GetFrequentlyUsedModel;
import com.bionische.biotech.adminpanel3d.model.Info;
import com.bionische.biotech.adminpanel3d.model.MainModel3D;
import com.bionische.biotech.adminpanel3d.model.SaveFrequentlyUsedModel;
import com.bionische.biotech.adminpanel3d.model.SubModel3D;
import com.bionische.biotech.adminpanel3d.model.SubModelsDetails;
import com.bionische.biotech.adminpanel3d.model.UserDetails;
import com.bionische.biotech.adminpanel3d.repository.Category3DModelRepository;
import com.bionische.biotech.adminpanel3d.repository.GetFrequentlyUsedModelRepositiory;
import com.bionische.biotech.adminpanel3d.repository.MainModel3DRepository;
import com.bionische.biotech.adminpanel3d.repository.SaveFrequentlyUsedModelRepository;
import com.bionische.biotech.adminpanel3d.repository.SubModel3DRepository;
import com.bionische.biotech.adminpanel3d.repository.SubModelsDetailsRepository;
import com.bionische.biotech.adminpanel3d.repository.UserDetailsRepository;



@RestController
public class ModelMasterController {
	
	@Autowired
	GetFrequentlyUsedModelRepositiory getFrequentlyUsedModelRepositiory;
	
	@Autowired
	Category3DModelRepository category3DModelRepository;
	
	@Autowired
	MainModel3DRepository mainModel3DRepository;
	
	@Autowired
	SubModel3DRepository subModel3DRepository;
	
	@Autowired
	SaveFrequentlyUsedModelRepository saveFrequentlyUsedModelRepository;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	SubModelsDetailsRepository subModelsDetailsRepository;
	
	@RequestMapping(value = { "/save3DModelCategory" }, method = RequestMethod.POST)
	public @ResponseBody Category3DModel save3DModelCategory(@RequestBody Category3DModel category3DModel)
	{
		Category3DModel category3DModelRes=new Category3DModel();
		System.out.println(category3DModel.toString());
		try {
		category3DModelRes=category3DModelRepository.save(category3DModel);
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return category3DModelRes;
	}
	
	@RequestMapping(value = { "/get3DModelCategory" }, method = RequestMethod.GET)
	public @ResponseBody List<Category3DModel> get3DModelCategory()
	{
		
	
		List<Category3DModel> category3DModelList=new ArrayList<Category3DModel>();
		try {
			category3DModelList=category3DModelRepository.findAll();
			System.out.println("category3DModelList="+category3DModelList.toString());
		
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return category3DModelList;
	}
	
	

	@RequestMapping(value = { "/save3DMainModel" }, method = RequestMethod.POST)
	public @ResponseBody MainModel3D save3DMainModel(@RequestBody MainModel3D mainModel3D)
	{
		
		MainModel3D mainModel3DRes=new MainModel3D();
		try {
		mainModel3DRes=mainModel3DRepository.save(mainModel3D);
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return mainModel3DRes;
	}
	
	@RequestMapping(value = { "/get3DMainModel" }, method = RequestMethod.POST)
	public @ResponseBody List<MainModel3D> get3DMainModel(@RequestParam("catId") int catId)
	{
	
		List<MainModel3D> mainModel3DList=new ArrayList<MainModel3D>();
		try {
			mainModel3DList=mainModel3DRepository.findByCatId(catId);
	
		
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return mainModel3DList;
	}
	
	@RequestMapping(value = { "/save3DSubModel" }, method = RequestMethod.POST)
	public @ResponseBody SubModel3D save3DSubModel(@RequestBody SubModel3D subModel3D)
	{
		
		SubModel3D subModel3DRes=new SubModel3D();
		try {
			subModel3DRes=subModel3DRepository.save(subModel3D);
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return subModel3DRes;
	}
	
	@RequestMapping(value = { "/get3DSubModel" }, method = RequestMethod.POST)
	public @ResponseBody List<SubModel3D> get3DSubModel(@RequestParam("mainModelId") int mainModelId)
	{
	
		List<SubModel3D> subModel3DList=new ArrayList<SubModel3D>();
		try {
			subModel3DList=subModel3DRepository.findByMainModelId(mainModelId);
	
		
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return subModel3DList;
	}
	
	
	@RequestMapping(value = { "/saveFrequentlyUsedModel" }, method = RequestMethod.POST)
	public @ResponseBody SaveFrequentlyUsedModel saveFrequentlyUsedModel(@RequestBody SaveFrequentlyUsedModel saveFrequentlyUsedModel)
	{
		SaveFrequentlyUsedModel saveFrequentlyUsedModelRes=new SaveFrequentlyUsedModel();
		System.out.println(saveFrequentlyUsedModel.toString());
		try {
			System.out.println("UID=="+saveFrequentlyUsedModel.getUserId()+"FID="+saveFrequentlyUsedModel.getSubModelId());
			SaveFrequentlyUsedModel saveFrequentlyRes=saveFrequentlyUsedModelRepository.findByUserIdAndSubModelId(saveFrequentlyUsedModel.getUserId(),saveFrequentlyUsedModel.getSubModelId());
			System.out.println("chndsjn response="+saveFrequentlyRes);
			if(saveFrequentlyRes==null) {
			saveFrequentlyUsedModelRes=saveFrequentlyUsedModelRepository.save(saveFrequentlyUsedModel);
			}else {
				saveFrequentlyUsedModel.setFrequentlyUsedId(saveFrequentlyRes.getFrequentlyUsedId());
				saveFrequentlyUsedModelRes=saveFrequentlyUsedModelRepository.save(saveFrequentlyUsedModel);		
				System.out.println("not store");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return saveFrequentlyUsedModelRes;
	}

	@RequestMapping(value = { "/showFrequentlyUsedModel" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFrequentlyUsedModel> showFrequentlyUsedModel(@RequestParam("userId") int userId)
	{
		System.out.println("nvffdf"+userId);
		List<GetFrequentlyUsedModel> getFrequentlyUsedModelList=new ArrayList<GetFrequentlyUsedModel>();
		try {
			getFrequentlyUsedModelList=getFrequentlyUsedModelRepositiory.findByUserId(userId);
	
			System.out.println(getFrequentlyUsedModelList.toString());
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return getFrequentlyUsedModelList;
	}

	/**
	 * This method is used to delete architect 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/removeFrequentlyUsedModel" }, method = RequestMethod.POST)
	public @ResponseBody Info removeFrequentlyUsedModel(@RequestParam("frequentlyUsedId") int frequentlyUsedId) {
		Info info=new Info();
		int delStatus = 0;
		System.out.println("fjudfsd");
		try {
			delStatus=saveFrequentlyUsedModelRepository.deleteFrequentlyUsedModel(frequentlyUsedId);
			
			
		System.out.println(delStatus);
		if(delStatus!=0)
		{
			info.setError(false);
			info.setMessage("Delete Successfully");
		}
		else {
			info.setError(true);
			info.setMessage("Failed to delete");
			} 
		    
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		
		return info;
	}
	
	
	/**
	 * 
	 * @param logInId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = { "/loginProcess" }, method = RequestMethod.POST)
	public @ResponseBody UserDetails loginProcess(@RequestParam("email") String email,@RequestParam("password") String password) {
				
		System.out.println("Name  AND Pass  "+ email+"  "+password);
		UserDetails userDetails=new UserDetails();
		userDetails=userDetailsRepository.findByEmailAndPassword(email, password);
		System.out.println("Res  "+userDetails.toString());
		return userDetails;
		
	}   
	

	/**
	 * 
	 * @param SubModelsDetails
	 save
	 * @return
	 */
	
	@RequestMapping(value = { "/saveSubModelDetails" }, method = RequestMethod.POST)
	public @ResponseBody SubModelsDetails saveSubModelDetails(@RequestBody SubModelsDetails subModelsDetails) {
		
		System.out.println("subModelsDetails "+subModelsDetails.toString());
		SubModelsDetails subModelsDetailsRes=new SubModelsDetails();
		try {
		
			subModelsDetailsRes=subModelsDetailsRepository.save(subModelsDetails);
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return subModelsDetailsRes;
	}
	/**
	 * 
	 * @param subModeodelId
	 
	 * @return
	 */
	
	@RequestMapping(value = { "/getSubModelDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<SubModelsDetails> getSubModelDetails(@RequestParam("subModelId") int subModelId) {
		
		System.out.println("subModelId "+subModelId);
		List<SubModelsDetails> subModelsDetailsList=new ArrayList<SubModelsDetails>();
		try {
		
		subModelsDetailsList=subModelsDetailsRepository.findBySubModelId(subModelId);
		System.out.println(subModelsDetailsList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return subModelsDetailsList;
	}
	
}

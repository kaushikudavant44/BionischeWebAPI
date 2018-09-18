package com.bionische.biotech.adminpanel3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.adminpanel3d.model.Category3DModel;
import com.bionische.biotech.adminpanel3d.model.Category3DModelList;
import com.bionische.biotech.adminpanel3d.model.Info;
import com.bionische.biotech.adminpanel3d.repository.Category3DModelRepository;
import com.bionische.biotech.adminpanel3d.repository.SubModel3DRepository;

@RestController
public class ModelUserController {

	@Autowired
	Category3DModelRepository category3DModelRepository;
	/**
	 * This method is used to get all architect details pictures.
	 * @return
	 */
	@RequestMapping(value = { "/getAllDoctorCategories" }, method = RequestMethod.GET)
	public @ResponseBody Category3DModelList getArchitectDetails() {
		
		Info info=new Info();
		Category3DModelList category3DModelList=new Category3DModelList();
		System.out.println("Hello You Are in getArchitectDetails ");
		
		try {
		List<Category3DModel> returnCategoryList=category3DModelRepository.findAll();
		System.out.println(returnCategoryList.toString());
		
		info.setError(false);
		info.setMessage("Architect List Found Successfully");
		category3DModelList.setCategory3DModelList(returnCategoryList);
		
		category3DModelList.setInfo(info);
		
		System.out.println(category3DModelList.toString());
		
		
		}catch(Exception e) {
			
			info.setError(true);
			info.setMessage("Data is not found");
						
		}
		return category3DModelList;
		
	}
	
}

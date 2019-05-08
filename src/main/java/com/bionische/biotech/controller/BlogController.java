package com.bionische.biotech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.BlogCreation;
import com.bionische.biotech.model.DocAvailableTime;
import com.bionische.biotech.model.GetBlogs;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.repository.BlogCreationRepository;
import com.bionische.biotech.repository.GetBlogsRepository;

@RestController
@RequestMapping(value = { "/blogs" })
public class BlogController {

	@Autowired
	BlogCreationRepository blogCreationRepository;
	
	@Autowired
	GetBlogsRepository blogsRepository;
	
	
 
	@RequestMapping(value = { "/addNewBlog" }, method = RequestMethod.POST)
	public Info addNewBlog(@RequestBody BlogCreation blogCreation) {

		try {

			Info info = new Info();
			blogCreationRepository.save(blogCreation);

			info.setError(false);
			info.setMessage("Blog Created Successfully");
			return info;
			
		} catch (Exception e) {
			e.printStackTrace();

			Info info = new Info();
			info.setError(true);
			info.setMessage("Blog Creation Failed");
			
			return info;
		}
	}
	
	
	@RequestMapping(value = { "/getBlogsList" }, method = RequestMethod.GET)
	public List<GetBlogs> getBlogsList (){
				
		return blogsRepository.findAll();
		
	}
	
	
	@RequestMapping(value = { "/getBlogsDetailsByBlogId" }, method = RequestMethod.POST)
	public GetBlogs getBlogsDetailsByBlogId (@RequestParam("blogId") int blogId){
				
		return blogsRepository.findByBlogId(blogId);
		
	}
	
	@RequestMapping(value = { "/getBlogsDetailsByDrId" }, method = RequestMethod.POST)
	public List<GetBlogs> getBlogsDetailsByBloggerId (@RequestParam("drId") int drId){
				
		return blogsRepository.findByDrId(drId);
				
	}
	
	
	
	@RequestMapping(value = { "/deleteBlogByBlogId" }, method = RequestMethod.POST)
	public Info deleteBlogByBlogId (@RequestParam("blogId") int blogId){
				
		int result= blogCreationRepository.deleteById(blogId);
		
		if(result==1) {
			
			Info info = new Info();
			info.setError(false);
			info.setMessage("Deleted");
			return info;
		}else {
			Info info = new Info();
			info.setError(true);
			info.setMessage("Delete Failed");
			return info;
		}
		
	}
	
	
}

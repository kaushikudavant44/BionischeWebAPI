package com.bionische.biotech.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bionische.biotech.ConstantFileUploadPath;
import com.bionische.biotech.model.Info;

@RestController
public class VpsFileUploadApiController {

	
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public @ResponseBody Info uploadFile(@RequestParam("files") List<MultipartFile> files,@RequestParam("userId")int userId, @RequestParam("imageType")int imageType,  @RequestParam("imageName")String imageName) throws IOException
	{
		
		Info info=new Info();
		
		for (MultipartFile file : files) {

			if (file.isEmpty()) {

				continue;

			}
			Path path =null;
			byte[] bytes = file.getBytes();
			if(imageType==1) {
			  
				System.out.println("1111111");
			path = Paths.get(ConstantFileUploadPath.DOCTOR_PATH+userId+"/profile/" + imageName);
			
			}
		
			Files.write(path, bytes);
		}
		return info;
		
	}
}

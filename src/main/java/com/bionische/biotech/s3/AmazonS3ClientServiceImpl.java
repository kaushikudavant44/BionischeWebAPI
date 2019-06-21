package com.bionische.biotech.s3;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.bionische.biotech.model.Info;

@Component

public class AmazonS3ClientServiceImpl implements AmazonS3ClientService{
	
	 private String awsS3AudioBucket;
	    private AmazonS3 amazonS3;
	    private static final Logger logger = LoggerFactory.getLogger(AmazonS3ClientServiceImpl.class);

	    @Autowired
	    public AmazonS3ClientServiceImpl(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider, String awsS3AudioBucket) 
	    {
	        this.amazonS3 = AmazonS3ClientBuilder.standard()
	                .withCredentials(awsCredentialsProvider)
	                .withRegion(awsRegion.getName()).build();
	        this.awsS3AudioBucket = awsS3AudioBucket;
	    }

	    @Async
	    public Info uploadFileToS3Bucket(MultipartFile multipartFile,String fileName, String prefix, boolean enablePublicReadAccess) 
	    {
	        //String fileName = multipartFile.getOriginalFilename();
	    	Info info=new Info();
	    	info.setError(true);
	        try {
	            //creating the file in the server (temporarily)
	            File file = new File(fileName);
	            FileOutputStream fos = new FileOutputStream(file);
	            fos.write(multipartFile.getBytes());
	            fos.close();

	            PutObjectRequest putObjectRequest = new PutObjectRequest(this.awsS3AudioBucket, prefix+"/"+fileName, file);

	            if (enablePublicReadAccess) {
	                putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
	            }
	            this.amazonS3.putObject(putObjectRequest);
	            //removing the file created in the server
	            file.delete();

				info.setError(false);
				info.setMessage("File Upload Successfully");
	        } catch (IOException | AmazonServiceException ex) {
	        	info.setError(true);
				info.setMessage("Failed to Upload File ");
	            logger.error("error [" + ex.getMessage() + "] occurred while uploading [" + fileName + "] ");
	        }
	        return info;
	    }

	    @Async
	    public void deleteFileFromS3Bucket(String fileName) 
	    {
	        try {
	            amazonS3.deleteObject(new DeleteObjectRequest(awsS3AudioBucket, fileName));
	        } catch (AmazonServiceException ex) {
	            logger.error("error [" + ex.getMessage() + "] occurred while removing [" + fileName + "] ");
	        }
	    }

	
	
}

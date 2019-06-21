package com.bionische.biotech.s3;

import org.springframework.web.multipart.MultipartFile;

import com.bionische.biotech.model.Info;

public interface AmazonS3ClientService {

	

	Info uploadFileToS3Bucket(MultipartFile multipartFile,String fileName, String prefix, boolean enablePublicReadAccess);

    void deleteFileFromS3Bucket(String fileName);
}

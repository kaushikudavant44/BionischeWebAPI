package com.bionische.biotech.service;

import java.io.File;

import javax.mail.MessagingException;

public interface SendEMailService {

	public String sendMail(String subject, String body, String email);
	public String sendMailAttachment(String subject, String body, String email, File attachmentFile, String attachmentFileName) throws MessagingException;
}

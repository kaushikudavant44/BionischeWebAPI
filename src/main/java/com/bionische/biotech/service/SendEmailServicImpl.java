package com.bionische.biotech.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
public class SendEmailServicImpl implements SendEMailService{

	@Autowired
    private JavaMailSender sender;
	
	public String sendMail(String subject, String body, String email) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setText(body);
            helper.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }
 
    public String sendMailAttachment(String subject, String body, String email, File attachmentFile, String attachmentFileName) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        try {
            helper.setTo(email);
            helper.setText(body);
            helper.setSubject(subject);
            FileSystemResource file 
            = new FileSystemResource(attachmentFile);
          helper.addAttachment(attachmentFileName, file); 
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }
	
}

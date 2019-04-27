package com.bionische.biotech.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface SendFcmNotificationService {

	/**
	 * 
	 * @param deviceToken -this token is used for send to particular device login
	 * @param title - notification title
	 * @param message - message with notification
	 * @param timeStamp - current date and time
	 * This are for doctor notification
	 * @param notificationType is 1=verification successful
	 *        notificationType is 2=verification Rejected
	 *        notificationType is 3=doctor subscription
	 *        notificationType is 4=Appointment Book successful
	 *        notificationType is 5=Appointment Canceled
	 *        notificationType is 6=Payment Successful
	 *        notificationType is 7=Report Share
	 *        notificationType is 8=Fill Available Time
	 *        notificationType is 9=Payment Receipt
	 *        This are for Patient notification
	 *        notificationType is 11=confirm dr appointment
	 *        notificationType is 12=Confirm Lab appointment
	 *        notificationType is 13=Doctor Remainder
	 *        notificationType is 14=Lab Remainder
	 *        notificationType is 15=Prescription
	 *        notificationType is 16=Order Confirm
	 *        notificationType is 17=Payment Request Lab
	 *        notificationType is 18=Review and Rating
	 *        notificationType is 19=Lab Shared report with you
	 *        notificationType is 20=Medicine Deliverd Successful
	 *          notificationType is 25=Video Share
	 *        
	 * @return
	 */
	public ResponseEntity<String> notifyUser(String deviceToken,String title, String message,String timeStamp, int notificationType);
	
	public ResponseEntity<String> notifyiOSUser(String deviceToken,String title, String message,String timeStamp, int notificationType);
	
	public ResponseEntity<String> notificationOnWeb(String deviceToken,String title, String message, String clickAction);
	
}

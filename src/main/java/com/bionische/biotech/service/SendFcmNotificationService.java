package com.bionische.biotech.service;

import org.springframework.http.ResponseEntity;

public interface SendFcmNotificationService {

	/**
	 * 
	 * @param deviceToken -this token is used for send to particular device login
	 * @param title - notification title
	 * @param message - message with notification
	 * @param timeStamp - current date and time
	 * @param notificationType is 1=verification successful
	 *        notificationType is 2=verification Rejected
	 *        notificationType is 3=doctor subscription
	 *        notificationType is 4=Appointment Book successful
	 *        notificationType is 5=Appointment Canceled
	 *        notificationType is 6=Payment Successful
	 *        notificationType is 7=Report Share
	 *        notificationType is 8=Fill Available Time
	 *        notificationType is 9=Payment Receipt
	 * @return
	 */
	public ResponseEntity<String> notifyUser(String deviceToken,String title, String message,String timeStamp, int notificationType);
	
}

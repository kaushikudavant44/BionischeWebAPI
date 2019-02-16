package com.bionische.biotech.repository.lab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.lab.LabAppointmentDetails;

public interface LabAppointmentDetailsRepository extends JpaRepository<LabAppointmentDetails, Integer>{

	
	LabAppointmentDetails save(LabAppointmentDetails labAppointmentDetails);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE LabAppointmentDetails  SET status =:status WHERE labAppId=:labAppId")
	int updateLabAppointmentStatus(@Param("labAppId")int labAppId, @Param("status")int status);
	

	@Transactional
	@Modifying
	@Query("UPDATE LabAppointmentDetails  SET status =:status,paidAmount=:paidAmount, totalAmount=:totalAmount,discount=:discount, amount=:amount,paymentDate=NOW(),amountType=:amountType, paymentStatus=:paymentStatus  WHERE labAppId=:labAppId")
	int collectSampleWithPaymentDetails(@Param("labAppId")int labAppId, @Param("status")int status,@Param("totalAmount")float totalAmount, @Param("paidAmount")float paidAmount, @Param("discount")float discount, @Param("amount")float amount , @Param("amountType")int amountType, @Param("paymentStatus")int paymentStatus);
	

	@Transactional
	@Modifying
	@Query("UPDATE LabAppointmentDetails  SET status =:status, labAppDate=:date, timeId=:timeId WHERE labAppId=:appId")
	int editLabAppointmentByLab( @Param("appId")int appId,  @Param("status")int status,  @Param("date")String date,  @Param("timeId")int timeId);


	LabAppointmentDetails findByLabAppId(int appointmentId);

	@Transactional
	@Modifying
	@Query("UPDATE LabAppointmentDetails  SET paymentStatus =:txnStatus, txnId=:txnId,  labAppDate=NOW(), orderId=:orderId, paidAmount=:txnAmt WHERE labAppId=:appointmentId")
	int updateLabAppointmentPayment(@Param("appointmentId")int appointmentId, @Param("txnStatus")int txnStatus, @Param("txnId")String txnId, @Param("orderId")String orderId, @Param("txnAmt")float txnAmt);

	
} 

package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.TransactionDetails;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer>{

	TransactionDetails save(TransactionDetails transactionDetails);

	@Transactional
	@Modifying
	@Query("UPDATE TransactionDetails a SET a.paymentDate=NOW(), a.amountType=:amountType, a.status =:txnStatus,a.txnId=:txnId,a.orderId=:orderId,a.amount=:txnAmt    WHERE a.id=:txnTableId")
	int updateLabReportsPayment(@Param("amountType")int amountType,@Param("txnTableId")int txnTableId,@Param("txnStatus")int txnStatus,@Param("txnId")String txnId,@Param("orderId")String orderId,@Param("txnAmt")float txnAmt);
 
	
 
	
	
}

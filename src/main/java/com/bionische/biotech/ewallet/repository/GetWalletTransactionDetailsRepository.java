package com.bionische.biotech.ewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.ewallet.model.GetWalletTransactionDetails;

public interface GetWalletTransactionDetailsRepository extends JpaRepository<GetWalletTransactionDetails, Long>{

	
	
	
	@Query(value="SELECT *, CASE  " + 
			"WHEN t.to_user_type = 0 THEN (SELECT CONCAT(d.f_name,' ', d.l_name) FROM doctor_details d WHERE d.doctor_id=t.to_user_id)  " + 
			"WHEN t.to_user_type = 1 THEN (SELECT CONCAT(p.f_name,' ', p.l_name) FROM patient_details p WHERE p.patient_id=t.to_user_id) " + 
			"WHEN t.to_user_type = 2 THEN (SELECT l.lab_name FROM lab_details l WHERE l.lab_id=t.to_user_id)  " + 
			"WHEN t.to_user_type = 3 THEN (SELECT m.medical_name FROM medical_details m WHERE m.medical_id=t.to_user_id) " + 
			"ELSE 'other' END AS to_user_name FROM t_wallet_transactions t WHERE  t.from_user_id=:userId AND " + 
			"t.user_type=:userType AND t.transaction_type != 3  ",nativeQuery=true)
    List<GetWalletTransactionDetails> getWalletTransactionDetails(@Param("userId")int userId, @Param("userType")int userType);
	
	/*@Query(value="select CASE "
			 + " WHEN t.from_to_user_type = 1 THEN (select CONCAT(d.f_name,' ', d.l_name) FROM doctor_details d where d.doctor_id=t.from_to) "
			 + " WHEN t.from_to_user_type = 2 THEN (select CONCAT(p.f_name,' ', p.l_name) FROM patient_details p where p.patient_id=t.from_to)"
			 + " WHEN t.from_to_user_type = 3 THEN (select l.lab_name FROM lab_details l where l.lab_id=t.from_to) "
			 + " WHEN t.from_to_user_type = 4 THEN (select m.medical_name FROM medical_details m where m.medical_id=t.from_to) "
			 + " ELSE 'other' END AS from_to_name, "
			 + "t.transaction_id , t.amount ,t.amount_type,t.comment, t.date_time , t.from_to ,t.from_to_user_type,"
			 + " t.status, t.txn_type ,t.user_id, t.user_type  from     e_wallet_transactions t  where  t.user_id=:userId and "
			 + "t.user_type=:userType  order by t.transaction_id desc",nativeQuery=true)
		    List<GetWalletTransactionDetails> getWalletTransactionDetails(@Param("userId")int userId, @Param("userType")int userType);*/
			
	
}

package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorSubscriptionDetails;

public interface DoctorSubscriptionDetailsRepository extends JpaRepository<DoctorSubscriptionDetails, Integer>{

	DoctorSubscriptionDetails save(DoctorSubscriptionDetails doctorSubscriptionDetails);
	
	DoctorSubscriptionDetails findTop1ByPackageExpDateGreaterThanEqualAndDoctorIdAndTxnStatusOrderBySuscriptionIdDesc(String date, int doctorId,int txnStatus);
	
	@Query(value=" SELECT * from t_doctor_subscription_details where created_date BETWEEN :fromDate AND :toDate AND txn_status!=0 AND doctor_id=:doctorId",nativeQuery=true)
	List<DoctorSubscriptionDetails> findByCreatedDateBetweenAndTxnStatusNotAndDoctorId(@Param("doctorId")int doctorId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
}

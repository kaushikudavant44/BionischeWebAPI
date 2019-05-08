package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.LabSubscriptionDetails;

public interface LabSubscriptionDetailsRepository extends JpaRepository<LabSubscriptionDetails, Integer>{

	
	LabSubscriptionDetails save(LabSubscriptionDetails LabSubscriptionDetails);
	
	LabSubscriptionDetails findTop1ByPackageExpDateGreaterThanEqualAndLabIdAndTxnStatusOrderBySuscriptionIdDesc(String date, int labId,int txnStatus);

	LabSubscriptionDetails findByTxnStatusNotAndLabId(int i, int labId);

	List<LabSubscriptionDetails> findByPaymentDateBetweenAndTxnStatusNotAndLabId(String fromDate, String toDate, int i,
			int labId);

}

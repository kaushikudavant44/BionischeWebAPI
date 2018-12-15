package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.LabSubscriptionDetails;

public interface LabSubscriptionDetailsRepository extends JpaRepository<LabSubscriptionDetails, Integer>{

	
	LabSubscriptionDetails save(LabSubscriptionDetails LabSubscriptionDetails);
	
	LabSubscriptionDetails findByPackageExpDateGreaterThanEqualAndLabIdAndTxnStatus(String date, int labId,int txnStatus);

}

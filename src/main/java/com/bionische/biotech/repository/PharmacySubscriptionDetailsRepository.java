package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.PharmacySubscriptionDetails;

public interface PharmacySubscriptionDetailsRepository extends JpaRepository<PharmacySubscriptionDetails, Integer>{

	PharmacySubscriptionDetails save(PharmacySubscriptionDetails PharmacySubscriptionDetails);
	PharmacySubscriptionDetails findByPackageExpDateGreaterThanEqualAndMedicalIdAndTxnStatus(String date, int medicalId,int txnStatus);
	List<PharmacySubscriptionDetails> findByPaymentDateBetweenAndTxnStatusNotAndMedicalId(String fromDate,
			String toDate, int i, int medicalId);

}

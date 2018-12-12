package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.DoctorSubscriptionDetails;

public interface DoctorSubscriptionDetailsRepository extends JpaRepository<DoctorSubscriptionDetails, Integer>{

	DoctorSubscriptionDetails save(DoctorSubscriptionDetails doctorSubscriptionDetails);
	
	DoctorSubscriptionDetails findByPackageExpDateGreaterThanEqualAndDoctorIdAndTxnStatus(String date, int doctorId,int txnStatus);
}

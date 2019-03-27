package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorCollectionAndReportDetail;


public interface DoctorCollectionAndReportDetailRepository extends JpaRepository<DoctorCollectionAndReportDetail, Integer>{
	
	@Query(value="SELECT COUNT(n.notification_id) AS unread_report,(SELECT  COALESCE(SUM(amount),0) FROM doctor_appointment  WHERE doctor_id=:doctorId AND DATE=:appDate AND STATUS=4) AS total_collection FROM doctor_notification n  WHERE n.doctor_id=:doctorId AND n.status=0 AND n.string1=\"Patient Shre Report\"" ,nativeQuery=true)
	DoctorCollectionAndReportDetail getCollectionAndReportDetail(@Param("doctorId") int doctorId,@Param("appDate") String appDate);
	
	
}

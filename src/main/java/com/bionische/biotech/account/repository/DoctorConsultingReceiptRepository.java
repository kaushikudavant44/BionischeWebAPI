package com.bionische.biotech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.DoctorConsultingReceipt;

public interface DoctorConsultingReceiptRepository extends JpaRepository<DoctorConsultingReceipt, String>{

	DoctorConsultingReceipt save(DoctorConsultingReceipt DoctorConsultingReceipt);
	
	
	@Query(value="SELECT COALESCE((SELECT r.date FROM t_doctor_consulting_receipt r WHERE r.doctor_id=:doctorId ORDER BY r.receipt_no DESC LIMIT 1),(SELECT a.payment_date FROM doctor_appointment a WHERE a.doctor_id=:doctorId AND a.payment_status=1 ORDER BY a.payment_date ASC LIMIT 1))AS date",nativeQuery=true)
	String getLastDateByDoctorId(@Param("doctorId")int doctorId);
}

package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetSelfUploadedPrescriptionToMedical;

public interface GetSelfUploadedPrescriptionToMedicalRepository extends JpaRepository<GetSelfUploadedPrescriptionToMedical, Integer>{

	@Query(value="SELECT r.medical_req_id, r.medical_id, m.medical_name, " + 
			"r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.delivery_type, " + 
			" r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status, " + 
			" r.address, m.email AS medical_email, m.contact as medical_contact, r.payment_date,r.prescription_name FROM patient_details p, medical_details m, " + 
			" self_uploaded_prescription_to_medical r WHERE r.medical_id=:medicalId AND r.status=:status AND " + 
			" r.patient_id=p.patient_id AND r.medical_id=m.medical_id ORDER BY r.medical_req_id DESC",nativeQuery=true)
	List<GetSelfUploadedPrescriptionToMedical> getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatus(@Param("medicalId")int medicalId, @Param("status")int status);
	
	
	@Query(value="SELECT r.medical_req_id, r.medical_id, m.medical_name, " + 
			"r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.delivery_type, " + 
			"r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,  " + 
			"r.address, m.email AS medical_email, m.contact AS medical_contact, r.payment_date,r.prescription_name FROM patient_details p, medical_details m,  " + 
			"self_uploaded_prescription_to_medical r WHERE r.medical_id=:medicalId AND r.status=:status AND  " + 
			"r.patient_id=p.patient_id AND r.medical_id=m.medical_id AND r.order_date BETWEEN :fromDate AND :toDate ORDER BY r.medical_req_id DESC",nativeQuery=true)
	List<GetSelfUploadedPrescriptionToMedical> getMedicalOrderDetailsByMedicalIdAndStatusAndDate(@Param("medicalId")int medicalId, @Param("status")int status,
			@Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
	
	@Query(value="SELECT r.medical_req_id, r.medical_id, m.medical_name, " + 
			"r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.delivery_type, " + 
			"r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,  " + 
			"r.address, m.email AS medical_email, m.contact AS medical_contact, r.payment_date,r.prescription_name FROM patient_details p, medical_details m,  " + 
			"self_uploaded_prescription_to_medical r WHERE r.status=2 AND  " + 
			"r.patient_id=p.patient_id AND r.medical_id=m.medical_id AND r.medical_req_id=:requestId",nativeQuery=true)
	GetSelfUploadedPrescriptionToMedical getPatientOrderDetailsByRequestId(@Param("requestId")int requestId);
	
}

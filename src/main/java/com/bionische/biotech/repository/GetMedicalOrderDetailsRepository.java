package com.bionische.biotech.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.GetMedicalOrderDetails;
import com.bionische.biotech.model.GetSelfUploadedPrescriptionToMedical;

public interface GetMedicalOrderDetailsRepository extends JpaRepository<GetMedicalOrderDetails, Integer> {

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,"
			+ " r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,"
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type,"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,"
			+ " r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,"
			+ " prescription_to_medical r WHERE r.medical_id=:medicalId AND r.status=:status AND r.doctor_id=d.doctor_id AND"
			+ " r.patient_id=p.patient_id AND r.medical_id=m.medical_id ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatus(@Param("medicalId") int medicalId,
			@Param("status") int status);

	@Query(value = "SELECT r.medical_request_id,r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,r.order_date, r.patient_id, "
			+ " CONCAT(p.f_name,' ',p.l_name)AS patient_name,r.doctor_id, 'self' AS doctor_name,'self' AS doctor_contact, "
			+ "  r.delivery_type,r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, "
			+ "  r.status, r.address, m.email,  m.contact, r.payment_date, r.string_1 FROM patient_details p, "
			+ "  medical_details m,prescription_to_medical r WHERE "
			+ "  r.medical_id=:medicalId AND r.status=:status AND r.meet_id=0 AND r.patient_id=p.patient_id AND r.medical_id=m.medical_id ORDER BY "
			+ "  r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getUploadedPrescriptionMedicalOrderDetailsByMedicalIdAndStatus(
			@Param("medicalId") int medicalId, @Param("status") int status);
	
	@Query(value = "SELECT r.medical_request_id,r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,r.order_date, r.patient_id, "
			+ " CONCAT(p.f_name,' ',p.l_name)AS patient_name,r.doctor_id, 'self' AS doctor_name,'self' AS doctor_contact, "
			+ "  r.delivery_type,r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, "
			+ "  r.status, r.address, m.email,  m.contact, r.payment_date, r.string_1 FROM patient_details p, "
			+ "  medical_details m,prescription_to_medical r WHERE "
			+ "  r.medical_id=:medicalId AND r.status=:status AND r.meet_id=0 AND r.patient_id=p.patient_id AND r.medical_id=m.medical_id "
			+ " AND r.order_date BETWEEN :fromDate AND :toDate ORDER BY "
			+ "  r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getUploadedMedicalOrderDetailsByMedicalIdAndStatusAndDate(
			@Param("medicalId") int medicalId,
			@Param("status") int status, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,"
			+ " r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,"
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type,"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,"
			+ " r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,"
			+ " prescription_to_medical r WHERE r.medical_id=:medicalId AND r.status=:status AND r.doctor_id=d.doctor_id AND"
			+ " r.patient_id=p.patient_id AND r.medical_id=m.medical_id AND r.order_date BETWEEN :fromDate AND :toDate ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndStatusAndDate(@Param("medicalId") int medicalId,
			@Param("status") int status, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date, "
			+ "r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id, "
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type, "
			+ " r.total_amt, r.pincode, r.patient_contact, r.payment_status, r.del_status, r.status, "
			+ "			r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m, "
			+ "			prescription_to_medical r WHERE r.patient_id=:patientId AND r.order_date>:date  AND r.doctor_id=d.doctor_id AND "
			+ "			 r.patient_id=p.patient_id AND r.medical_id=m.medical_id ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getPatientOrderDetailsByPatientId(@Param("patientId") int patientId,
			@Param("date") Date date);
	
	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,\r\n"
			+ "r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,\r\n"
			+ " 'self' AS doctor_name, 'self' AS doctor_contact, r.delivery_type,\r\n"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,\r\n"
			+ "	r.address, m.email, m.contact, r.payment_date, r.string_1 FROM patient_details p, medical_details m,\r\n"
			+ "	prescription_to_medical r WHERE r.patient_id=:patientId AND r.order_date>:date  AND "
			+ " r.patient_id=p.patient_id AND r.meet_id=0 AND r.medical_id=m.medical_id ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getUploadedPrescriptionPatientOrderDetailsByPatientId(@Param("patientId") int patientId,
			@Param("date") Date date);

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,\r\n"
			+ "r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,\r\n"
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type,\r\n"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,\r\n"
			+ "			r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,\r\n"
			+ "			prescription_to_medical r WHERE r.patient_id=:patientId  AND r.doctor_id=d.doctor_id AND\r\n"
			+ "			 r.patient_id=p.patient_id AND r.medical_id=m.medical_id ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getPatientAllOrderDetailsByPatientId(@Param("patientId") int patientId);

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,\r\n"
			+ "r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,\r\n"
			+ " CONCAT(d.f_name,' ',d.l_name) AS doctor_name, d.contact AS doctor_contact, r.delivery_type,\r\n"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,\r\n"
			+ "			r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,\r\n"
			+ "			prescription_to_medical r WHERE r.medical_request_id=:requestId  AND r.doctor_id=d.doctor_id AND\r\n"
			+ "			 r.patient_id=p.patient_id AND r.medical_id=m.medical_id", nativeQuery = true)
	GetMedicalOrderDetails getPatientOrderDetailsByRequestId(@Param("requestId") int requestId);
	
	
	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date, "
			+ "r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id, "
			+ " 'self' AS doctor_name, 'self' AS doctor_contact, r.delivery_type, "
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status, "
			+ "r.address, m.email, m.contact, r.payment_date, r.string_1 FROM patient_details p, medical_details m, "
			+ "prescription_to_medical r WHERE r.medical_request_id=:requestId AND r.meet_id=0 AND "
			+ "r.patient_id=p.patient_id AND r.medical_id=m.medical_id", nativeQuery = true)
	GetMedicalOrderDetails getPatientOrderDetailsBillByRequestId(@Param("requestId") int requestId);
	

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,"
			+ " r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,"
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type,"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,"
			+ " r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,"
			+ " prescription_to_medical r WHERE r.medical_id=:medicalId  AND r.doctor_id=d.doctor_id AND"
			+ " r.patient_id=p.patient_id AND r.medical_id=m.medical_id AND r.order_date BETWEEN :fromDate AND :toDate ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByMedicalIdAndDate(@Param("medicalId") int medicalId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,"
			+ " r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,"
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type,"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,"
			+ " r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,"
			+ " prescription_to_medical r WHERE r.patient_id=:patientId  AND r.doctor_id=d.doctor_id AND"
			+ " r.patient_id=p.patient_id AND r.medical_id=m.medical_id AND r.order_date BETWEEN :fromDate AND :toDate ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getMedicalOrderDetailsByPatientIdAndStatusAndDate(@Param("patientId") int patientId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,"
			+ " r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,"
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type,"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,"
			+ " r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,"
			+ " prescription_to_medical r WHERE r.medical_id=:medicalId AND r.status=:status AND r.doctor_id=d.doctor_id AND"
			+ " r.patient_id=p.patient_id AND r.medical_id=m.medical_id ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getMedicalCancelledOrderByMedicalIdAndStatus(@Param("medicalId") int medicalId,
			@Param("status") int status);
	
	
	@Query(value = "SELECT r.medical_request_id, r.meet_id, r.medical_id, m.medical_name, r.last_modified_date,"
			+ " r.order_date, r.patient_id, CONCAT(p.f_name,' ',p.l_name)AS patient_name, r.doctor_id,"
			+ " CONCAT(d.f_name,' ',d.l_name)AS doctor_name, d.contact AS doctor_contact, r.delivery_type,"
			+ " r.total_amt, r.pincode, p.contact AS patient_contact, r.payment_status, r.del_status, r.status,"
			+ " r.address, m.email, m.contact, r.payment_date, r.string_1 FROM doctor_details d, patient_details p, medical_details m,"
			+ " prescription_to_medical r WHERE r.medical_id=:medicalId AND r.status=:status AND r.doctor_id=d.doctor_id AND"
			+ " r.patient_id=p.patient_id AND r.medical_id=m.medical_id ORDER BY r.medical_request_id DESC", nativeQuery = true)
	List<GetMedicalOrderDetails> getUploadMedicalCancelledOrderByMedicalIdAndStatus(@Param("medicalId") int medicalId,
			@Param("status") int status);
	

}

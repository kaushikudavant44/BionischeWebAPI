package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.PrescriptionToMedical;

public interface PrescriptionToMedicalRepository extends JpaRepository<PrescriptionToMedical, Integer>{
	
	
	
	PrescriptionToMedical save(PrescriptionToMedical prescriptionToMedical);
	@Transactional
	@Modifying
	@Query("UPDATE PrescriptionToMedical p SET p.status =:status, p.totalAmt=:totAmount  WHERE p.requestToMedicalId=:requestId")
	int updateMedicalOrderStatusAndAmount(@Param("requestId")int requestId, @Param("status")int status,@Param("totAmount") float totAmount);
	
	@Transactional
	@Modifying
	@Query("UPDATE PrescriptionToMedical p SET p.paymentStatus =:paidStatus  WHERE p.requestToMedicalId=:requestId")
	int updateMedicineOrderPaidStatus(@Param("requestId")int requestId, @Param("paidStatus")int paidStatus);
	
	@Transactional
	@Modifying
	@Query("UPDATE PrescriptionToMedical p SET p.status =:status  WHERE p.requestToMedicalId=:requestId")
	int updateMedicineOrderDeliveredStatus(@Param("requestId")int requestId, @Param("status")int status);
	
	@Query(value=" SELECT patient_id from prescription_to_medical where medical_request_id=:requestId",nativeQuery=true)
	int getPatientId(@Param("requestId")int requestId); 
	
	/*
	@Query(value=" SELECT p.medical_request_id,p.patient_name,m.medical_name,p.doctor_name,p.hospital_name,p.meet_id,p.date,p.time,p.int_1,p.int_2,d.contact AS string_1,p.string_2,p.medical_id,\r\n" + 
			"p.del_status,p.status,p.patient_id,p.doctor_id,p.patient_contact,p.pincode,p.city,p.land_mark,p.address,p.delivery_type\r\n" + 
			"  FROM prescription_to_medical p,doctor_details d,medical_details m WHERE p.medical_id=:medicalId AND p.date=:date AND p.del_status=0 AND p.medical_id=m.medical_id AND p.int_1=0 AND p.doctor_id=d.doctor_id",nativeQuery=true)
	List<PrescriptionToMedical> getPrescriptionsOfMedical(@Param("medicalId")int medicalId, @Param("date")String date);

	
	
	@Transactional
	@Modifying
	@Query("UPDATE PrescriptionToMedical p SET p.status =2  WHERE p.patientRequestToMedicalId=:patientRequestToMedicalId")
	int editDeliveredPrescription(@Param("patientRequestToMedicalId")int patientRequestToMedicalId);
	
	@Query(value=" SELECT p.medical_request_id,p.patient_name,m.medical_name,p.doctor_name,p.hospital_name,p.meet_id,p.date,p.time,p.int_1,p.int_2,d.contact AS string_1,p.string_2,p.medical_id,\r\n" + 
			"p.del_status,p.status,p.patient_id,p.doctor_id,p.patient_contact,p.pincode,p.city,p.land_mark,p.address,p.delivery_type\r\n" + 
			"  FROM medical_details m,prescription_to_medical p,doctor_details d WHERE p.medical_id=:medicalId AND p.DATE=:date AND p.medical_id=m.medical_id AND p.int_1=1 AND (p.int_2=0 || p.STATUS=0) AND p.doctor_id=d.doctor_id",nativeQuery=true)
	List<PrescriptionToMedical> getCompletedPrescOfMedical(@Param("medicalId")int medicalId, @Param("date")String date);
	
	@Query(value=" SELECT p.medical_request_id,p.patient_name,p.doctor_name,m.medical_name,p.hospital_name,p.meet_id,p.date,p.time,p.int_1,p.int_2,d.contact AS string_1,p.string_2,p.medical_id,\r\n" + 
			"p.del_status,p.status,p.patient_id,p.doctor_id,p.patient_contact,p.pincode,p.city,p.land_mark,p.address,p.delivery_type\r\n" + 
			"  FROM prescription_to_medical p,doctor_details d,medical_details m WHERE p.medical_id=:medicalId AND p.date BETWEEN :fromDate AND :toDate AND p.status=1 AND p.int_2=1 AND p.medical_id=m.medical_id AND p.doctor_id=d.doctor_id",nativeQuery=true)
	List<PrescriptionToMedical> getHistoryOfMedical(@Param("medicalId")int medicalId, @Param("fromDate")String fromDate,@Param("toDate")String toDate);

	List<PrescriptionToMedical> findByMedicalIdAndDateBetween(int medicalId, String fromDate, String toDate);
	
	@Query(value="SELECT p.medical_request_id,p.patient_name,p.doctor_name,p.hospital_name,p.meet_id,p.date,p.time,p.int_1,p.int_2,d.contact AS string_1,p.string_2,p.medical_id,"
			+ " p.del_status,p.status,p.patient_id,p.doctor_id,p.patient_contact,p.pincode,p.city,p.land_mark,p.address,p.delivery_type,m.medical_name "
			+ "FROM medical_details m, prescription_to_medical p,doctor_details d WHERE p.patient_id=:patientId AND p.medical_id=m.medical_id AND p.date BETWEEN :fromDate AND :toDate AND p.status=1 AND p.int_2=1 AND p.doctor_id=d.doctor_id",nativeQuery=true)
	List<PrescriptionToMedical> getHistoryOfMedicalToPatient(@Param("patientId")int patientId, @Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value=" SELECT * FROM prescription_to_medical WHERE patient_id=:patientId AND doctor_id=:doctorId AND int_2=0;",nativeQuery=true)
	List<PrescriptionToMedical> getConsultingHistoryToDoctor(@Param("patientId")int patientId,@Param("doctorId")int doctorId );
	
	@Query(value="SELECT p.medical_request_id,p.patient_name,p.doctor_name,p.hospital_name,p.meet_id,p.date,p.time,p.int_1,p.int_2,d.contact AS string_1,p.string_2,p.medical_id, "
			+ "p.del_status,p.status,p.patient_id,p.doctor_id,p.patient_contact,p.pincode,p.city,p.land_mark,p.address,p.delivery_type,m.medical_name FROM medical_details m, "
			+ "prescription_to_medical p,doctor_details d WHERE p.patient_id=:patientId AND p.medical_id=m.medical_id AND p.status=1 AND p.int_2=1 AND p.doctor_id=d.doctor_id ORDER BY p.medical_request_id DESC LIMIT 10",nativeQuery=true)
	List<PrescriptionToMedical> getRecentHistoryOfMedicalToPatient(@Param("patientId")int patientId);*/

}

package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetAppointmentDetails;

public interface GetAppointmentDetailsRepository extends JpaRepository<GetAppointmentDetails, Integer>{

	
	@Query(value="SELECT a.appoint_id,a.int_1, a.doctor_id, a.patient_id, a.date, a.hospital_id, a.del_status, a.status, CONCAT(p.f_name,' ', p.l_name)AS patient_name, d.fees as amount,"
			+" CONCAT(d.f_name,' ', d.l_name)AS doctor_name, h.address, h.hospital_name,t.time_id, t.time,p.profile_photo from appointment_time t, doctor_appointment a, doctor_details d,"
			+" hospital_details h, patient_details p WHERE a.date BETWEEN :fromDate AND :toDate AND a.patient_id=:patientId AND a.hospital_id=h.hospital_id AND"
			+" a.doctor_id=d.doctor_id AND a.patient_id=p.patient_id AND a.time=t.time_id ORDER BY a.date DESC",nativeQuery=true)
	List<GetAppointmentDetails> getAppointmentDetails(@Param("fromDate")String fromDate,@Param("toDate")String toDate, @Param("patientId")int patientId);
	
	@Query(value="SELECT a.appoint_id, a.doctor_id, a.patient_id, a.date, a.hospital_id, a.int_1,a.del_status, a.status, CONCAT(p.f_name,' ', p.l_name)AS patient_name,d.fees as amount,"
			+" CONCAT(d.f_name,' ', d.l_name)AS doctor_name, h.address, h.hospital_name, t.time_id,t.time,p.profile_photo from appointment_time t, doctor_appointment a, doctor_details d,"
			+" hospital_details h, patient_details p WHERE a.date BETWEEN :fromDate AND :toDate AND a.status!=2 AND a.status!=4 AND a.doctor_id=:doctorId AND a.hospital_id=h.hospital_id AND"
			+" a.doctor_id=d.doctor_id AND a.patient_id=p.patient_id AND a.time=t.time_id ORDER BY a.date DESC, a.status, a.del_status, a.time",nativeQuery=true)
	List<GetAppointmentDetails> getAppointmentDetailsByDoctor(@Param("fromDate")String fromDate,@Param("toDate")String toDate, @Param("doctorId")int doctorId);
	
	@Query(value="SELECT a.appoint_id, a.doctor_id, a.patient_id, a.date, a.hospital_id, a.int_1,a.del_status, a.status, CONCAT(p.f_name,' ', p.l_name)AS patient_name,d.fees as amount,"
			+ "CONCAT(d.f_name,' ', d.l_name)AS doctor_name, h.address, h.hospital_name, t.time_id,t.time,p.profile_photo FROM appointment_time t, doctor_appointment a,"
			+ " doctor_details d,hospital_details h, patient_details p WHERE a.patient_id IN(SELECT patient_id FROM patient_details WHERE CONCAT(f_name,l_name)=:fullName) AND"
			+ " a.doctor_id=:doctorId AND a.hospital_id=h.hospital_id AND a.doctor_id=d.doctor_id AND a.patient_id=p.patient_id AND a.time=t.time_id ORDER BY a.date DESC, a.status, a.del_status, a.time",nativeQuery=true)
	List<GetAppointmentDetails> getAppmtDetailsByDoctorIdPatName(@Param("doctorId")int doctorId,@Param("fullName")String fullName);
	

	@Query(value="SELECT a.appoint_id, a.doctor_id, a.patient_id, a.date, a.hospital_id, a.int_1,a.del_status, a.status, CONCAT(p.f_name,' ', p.l_name)AS patient_name,d.fees as amount,"
			+" CONCAT(d.f_name,' ', d.l_name)AS doctor_name, h.address, h.hospital_name, t.time_id,t.time,p.profile_photo from appointment_time t, doctor_appointment a, doctor_details d,"
			+" hospital_details h, patient_details p WHERE a.patient_id=:patientId AND a.status!=2 AND a.status!=4 AND a.doctor_id=:doctorId AND a.hospital_id=h.hospital_id AND"
			+" a.doctor_id=d.doctor_id AND a.patient_id=p.patient_id AND a.time=t.time_id ORDER BY a.date DESC, a.status, a.del_status, a.time",nativeQuery=true)
	List<GetAppointmentDetails> getAppmtDetailsByDoctorIdPatId(@Param("doctorId")int doctorId,@Param("patientId")int patientId);
	
	@Query(value="SELECT a.appoint_id, a.doctor_id, a.patient_id, a.date, a.hospital_id, a.int_1,a.del_status, a.status, CONCAT(p.f_name,' ', p.l_name)AS patient_name,d.fees as amount,\r\n" + 
			"CONCAT(d.f_name,' ', d.l_name)AS doctor_name, h.address, h.hospital_name, t.time_id,t.time,p.profile_photo FROM appointment_time t, doctor_appointment a, doctor_details d,\r\n" + 
			"hospital_details h, patient_details p WHERE a.appoint_id=:appId AND a.hospital_id=h.hospital_id AND\r\n" + 
			"a.doctor_id=d.doctor_id AND a.patient_id=p.patient_id AND a.time=t.time_id ORDER BY a.date DESC, a.status, a.del_status, a.time",nativeQuery=true)
	GetAppointmentDetails getAppmtDetailsByAppointId(@Param("appId")int appId);
}

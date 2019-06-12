package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.GetLabAppointment;

public interface GetLabAppointmentRrepository extends JpaRepository<GetLabAppointment, Integer>{

	  
	@Query(value="SELECT a.lab_app_id, a.patient_id, t.time,t.time_id,a.int_1, a.lab_app_date, l.address, a.lab_test_id, tt.lab_test_name, a.patient_name, a.lab_id,"
			+ " a.patient_contact, a.patient_email, l.lab_name, a.del_status from lab_tests tt, lab_appointments a, lab_details l,"
			+ " appointment_time t where a.lab_app_date BETWEEN :fromDate AND :toDate AND a.lab_id=l.lab_id AND a.lab_id=:labId AND a.int_1!=2  AND a.int_1!=4 AND tt.lab_test_id=a.lab_test_id AND  t.time_id=a.time ORDER BY a.lab_app_date DESC, a.del_status,"
			+ "  a.time",nativeQuery=true)
	List<GetLabAppointment> getLabAppointment(@Param("fromDate")String fromDate,@Param("toDate")String toDate, @Param("labId")int labId);
	
	@Query(value="SELECT a.lab_app_id, a.patient_id, t.time,t.time_id,a.int_1, a.lab_app_date, l.address, a.lab_test_id, tt.lab_test_name, a.patient_name, a.lab_id,"
			+ " a.patient_contact, a.patient_email, l.lab_name, a.del_status from lab_tests tt, lab_appointments a, lab_details l,"
			+ " appointment_time t where a.lab_app_date AND a.patient_id=:patientId AND a.lab_id=l.lab_id AND a.lab_id=:labId AND a.int_1!=2  AND a.int_1!=4 AND tt.lab_test_id=a.lab_test_id AND  t.time_id=a.time ORDER BY a.lab_app_date DESC, a.del_status,"
			+ "  a.time",nativeQuery=true)
	List<GetLabAppointment> getLabAppointmentByPatID(@Param("labId")int labId,@Param("patientId")int patientId);
	
	@Query(value="SELECT a.lab_app_id, a.patient_id, t.time,t.time_id,a.int_1, a.lab_app_date, l.address, a.lab_test_id, tt.lab_test_name, a.patient_name,"
			+ "a.lab_id,a.patient_contact, a.patient_email, l.lab_name, a.del_status FROM lab_tests tt, lab_appointments a, lab_details l,"
			+ "appointment_time t WHERE a.patient_id IN (SELECT patient_id FROM patient_details WHERE CONCAT(f_name,l_name)=:fullName) AND a.lab_id=l.lab_id AND"
			+ " a.lab_id=:labId AND tt.lab_test_id=a.lab_test_id AND  t.time_id=a.time ORDER BY a.lab_app_date DESC, a.del_status, a.time",nativeQuery=true)
	List<GetLabAppointment> getLabAppointmentByPatientName(@Param("labId")int labId,@Param("fullName")String fullName);
	
	@Query(value="SELECT a.lab_app_id,t.time_id ,a.int_1,a.patient_id, t.time, a.lab_app_date, l.address, a.lab_test_id, tt.lab_test_name, a.patient_name, a.lab_id,"
			+ " a.patient_contact, a.patient_email, l.lab_name, a.del_status from lab_tests tt, lab_appointments a, lab_details l,"
			+ " appointment_time t where a.lab_app_date BETWEEN :fromDate AND :toDate AND a.lab_id=l.lab_id AND a.patient_id=:patientId AND tt.lab_test_id=a.lab_test_id AND  t.time_id=a.time ORDER BY a.lab_app_date DESC, a.del_status,"
			+ "  a.time",nativeQuery=true)
	List<GetLabAppointment> getLabAppointmentToPatient(@Param("fromDate")String fromDate,@Param("toDate")String toDate, @Param("patientId")int patientId);
	
/*	@Query(value="SELECT a.lab_app_id,t.time_id ,a.int_1,a.patient_id, t.time, a.lab_app_date, l.address, a.lab_test_id, tt.lab_test_name, a.patient_name, a.lab_id," + 
			"a.patient_contact, a.patient_email, l.lab_name, a.del_status FROM lab_tests tt, lab_appointments a, lab_details l," + 
			"appointment_time t WHERE a.int_1=4 AND a.int_2=0 AND a.lab_app_date<:date AND " + 
			"a.patient_id IN (SELECT p.patient_id FROM patient_details p WHERE p.family_id=:familyId) AND a.lab_id=l.lab_id AND a.lab_test_id=a.lab_test_id GROUP BY a.lab_app_id",nativeQuery=true)
	List<GetLabAppointment> getLabAppointmentForRating(@Param("familyId")int familyId,@Param("date")String date);*/
	
	@Query(value="SELECT a.lab_app_id, a.patient_id, t.time,t.time_id,a.int_1, a.lab_app_date, l.address, a.lab_test_id, tt.lab_test_name, a.patient_name, a.lab_id,\r\n" + 
			" a.patient_contact, a.patient_email, l.lab_name, a.del_status FROM lab_tests tt, lab_appointments a, lab_details l,\r\n" + 
			"  appointment_time t WHERE a.lab_app_id=:appId AND a.lab_id=l.lab_id  AND \r\n" + 
			"  tt.lab_test_id=a.lab_test_id AND  t.time_id=a.time ",nativeQuery=true)
	GetLabAppointment getLabAppointmentDetails(@Param("appId")int appId);

	
	
	
	
	/*
	Ganesh 
	2019-02-08
	*/
	@Query(value="SELECT a.lab_app_id, t.time_id , a.status, a.payment_status, a.total_amount, a.patient_id, t.time, a.lab_app_date, l.address, a.test_id_list, a.doctor_id, "
			+ " CASE  WHEN a.doctor_id = 0 THEN 'Not Specify'  WHEN a.doctor_id != 0 THEN (SELECT CONCAT( d.f_name,' ', d.l_name) FROM doctor_details d WHERE doctor_id=a.doctor_id) END AS doctor_name, a.refference,"
			+ " GROUP_CONCAT( tt.lab_test_name SEPARATOR ', ')AS lab_test_name, CONCAT( p.f_name,' ', p.l_name)AS patient_name,"
			+ " a.lab_id, p.contact AS patient_contact, p.email AS patient_email, l.lab_name, a.del_status FROM lab_tests tt,"
			+ " t_lab_appointment_details a, lab_details l, appointment_time t, patient_details p WHERE"
			+ " a.lab_app_date BETWEEN :fromDate AND :toDate AND a.lab_id=l.lab_id AND p.patient_id=a.patient_id AND"
			+ "  a.patient_id=:patientId AND FIND_IN_SET(tt.lab_test_id, a.test_id_list)  AND t.time_id=a.time_id GROUP BY a.lab_app_id ORDER BY a.lab_app_date"
			+ " DESC, a.del_status, a.time_id",nativeQuery=true)
List<GetLabAppointment> getLabAppmtDetailsByPatientIdAndDate(@Param("patientId")int patientId, @Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value="SELECT a.lab_app_id, t.time_id , a.status, a.payment_status, a.total_amount, a.patient_id, t.time, a.lab_app_date, l.address, a.test_id_list, a.doctor_id, "
			+ " CASE  WHEN a.doctor_id = 0 THEN 'Not Specify'  WHEN a.doctor_id != 0 THEN (SELECT CONCAT( d.f_name,' ', d.l_name) FROM doctor_details d WHERE doctor_id=a.doctor_id) END AS doctor_name, a.refference,"
			+ " GROUP_CONCAT( tt.lab_test_name SEPARATOR ', ')AS lab_test_name, CONCAT( p.f_name,' ', p.l_name)AS patient_name,"
			+ " a.lab_id, p.contact AS patient_contact, p.email AS patient_email, l.lab_name, a.del_status FROM lab_tests tt,"
			+ " t_lab_appointment_details a, lab_details l, appointment_time t, patient_details p WHERE"
			+ " a.lab_app_date BETWEEN :fromDate AND :toDate AND a.lab_id=l.lab_id AND p.patient_id=a.patient_id AND"
			+ "  a.lab_id=:labId AND FIND_IN_SET(tt.lab_test_id, a.test_id_list)  AND t.time_id=a.time_id GROUP BY a.lab_app_id ORDER BY a.lab_app_date"
			+ " DESC, a.del_status, a.time_id",nativeQuery=true)
	List<GetLabAppointment> getLabAppmtDetailsByLabIdAndDate(@Param("labId")int labId, @Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value="SELECT a.lab_app_id, t.time_id , a.status, a.payment_status, a.total_amount, a.patient_id, t.time, a.lab_app_date, l.address, a.test_id_list, a.doctor_id, "
			+ " CASE  WHEN a.doctor_id = 0 THEN 'Not Specify'  WHEN a.doctor_id != 0 THEN (SELECT CONCAT( d.f_name,' ', d.l_name) FROM doctor_details d WHERE doctor_id=a.doctor_id) END AS doctor_name, a.refference,"
			+ " GROUP_CONCAT( tt.lab_test_name SEPARATOR ', ')AS lab_test_name, CONCAT( p.f_name,' ', p.l_name)AS patient_name,"
			+ " a.lab_id, p.contact AS patient_contact, p.email AS patient_email, l.lab_name, a.del_status FROM lab_tests tt,"
			+ " t_lab_appointment_details a, lab_details l, appointment_time t, patient_details p WHERE"
			+ "  a.lab_id=l.lab_id AND p.patient_id=a.patient_id AND"
			+ "  a.lab_id=:labId AND a.patient_id=:patientId AND FIND_IN_SET(tt.lab_test_id, a.test_id_list)  AND t.time_id=a.time_id GROUP BY a.lab_app_id ORDER BY a.lab_app_date"
			+ " DESC, a.del_status, a.time_id",nativeQuery=true)
	List<GetLabAppointment> getLabAppointmentByLabAndPatientId(@Param("patientId")int patientId,@Param("labId")int labId);

	@Query(value="SELECT a.lab_app_id, t.time_id , a.status, a.payment_status, a.total_amount, a.patient_id, t.time, a.lab_app_date, l.address, a.test_id_list,  a.doctor_id, "
			 +" CASE  WHEN a.doctor_id = 0 THEN 'Not Specify'  WHEN a.doctor_id != 0 THEN (SELECT CONCAT( d.f_name,' ', d.l_name) FROM doctor_details d WHERE doctor_id=a.doctor_id) END AS doctor_name, a.refference,"
			+ " GROUP_CONCAT( tt.lab_test_name SEPARATOR ', ')AS lab_test_name, CONCAT( p.f_name,' ', p.l_name)AS patient_name,"
			+ " a.lab_id, p.contact AS patient_contact, p.email AS patient_email, l.lab_name, a.del_status FROM lab_tests tt,"
			+ " t_lab_appointment_details a, lab_details l, appointment_time t, patient_details p WHERE"
			+ "  a.lab_id=l.lab_id AND p.patient_id=a.patient_id AND a.lab_app_id=:appointmentId AND"
			+ "     FIND_IN_SET(tt.lab_test_id, a.test_id_list)  AND t.time_id=a.time_id ",nativeQuery=true)
	GetLabAppointment getLabAppointmentByAppointmentId(@Param("appointmentId")int appointmentId);
	
	@Query(value="SELECT a.lab_app_id, t.time_id , a.status, a.payment_status, a.total_amount, a.patient_id, t.time, a.lab_app_date,"
			+ " l.address, a.test_id_list, a.doctor_id,  CASE  WHEN a.doctor_id = 0 THEN 'Not Specify'  WHEN a.doctor_id != 0 THEN (SELECT CONCAT( d.f_name,' ', d.l_name)"
			+ "  FROM doctor_details d  WHERE doctor_id=a.doctor_id) END AS doctor_name, a.refference,  GROUP_CONCAT( tt.lab_test_name SEPARATOR ', ')AS lab_test_name,"
			+ " CONCAT( p.f_name,' ', p.l_name)AS patient_name,  a.lab_id, p.contact AS patient_contact, p.email AS patient_email, l.lab_name, a.del_status"
			+ " FROM lab_tests tt, t_lab_appointment_details a, lab_details l, appointment_time t, patient_details p WHERE  a.lab_app_date <:date AND"
			+ " a.lab_id=l.lab_id AND p.patient_id=a.patient_id AND  p.family_id=:familyId AND a.rating_status=0 AND FIND_IN_SET(tt.lab_test_id, a.test_id_list)  AND"
			+ " t.time_id=a.time_id GROUP BY a.lab_app_id ORDER BY a.lab_app_date DESC, a.del_status, a.time_id",nativeQuery=true)
	List<GetLabAppointment> getLabAppointmentForRating(@Param("familyId")int familyId,@Param("date")String date);

	 
	@Query(value="SELECT a.lab_app_id, t.time_id , a.status, a.payment_status, a.total_amount, a.patient_id, t.time, a.lab_app_date, l.address, a.test_id_list, a.doctor_id, "
			+ " CASE  WHEN a.doctor_id = 0 THEN 'Not Specify'  WHEN a.doctor_id != 0 THEN (SELECT CONCAT( d.f_name,' ', d.l_name) FROM doctor_details d WHERE doctor_id=a.doctor_id) END AS doctor_name, a.refference,"
			+ " GROUP_CONCAT( tt.lab_test_name SEPARATOR ', ')AS lab_test_name, CONCAT( p.f_name,' ', p.l_name)AS patient_name,"
			+ " a.lab_id, p.contact AS patient_contact, p.email AS patient_email, l.lab_name, a.del_status FROM lab_tests tt,"
			+ " t_lab_appointment_details a, lab_details l, appointment_time t, patient_details p WHERE"
			+ " a.lab_app_date>=CURDATE() AND a.lab_id=l.lab_id AND p.patient_id=a.patient_id AND"
			+ "  a.patient_id=:patientId AND FIND_IN_SET(tt.lab_test_id, a.test_id_list)  AND t.time_id=a.time_id GROUP BY a.lab_app_id ORDER BY a.lab_app_date"
			+ " DESC, a.del_status, a.time_id",nativeQuery=true)
List<GetLabAppointment> getLabAppmtDetailsByPatientId(@Param("patientId")int patientId);

}

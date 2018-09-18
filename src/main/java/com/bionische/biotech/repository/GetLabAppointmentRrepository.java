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
	
	@Query(value="SELECT a.lab_app_id,t.time_id ,a.int_1,a.patient_id, t.time, a.lab_app_date, l.address, a.lab_test_id, tt.lab_test_name, a.patient_name, a.lab_id," + 
			"a.patient_contact, a.patient_email, l.lab_name, a.del_status FROM lab_tests tt, lab_appointments a, lab_details l," + 
			"appointment_time t WHERE a.int_1=4 AND a.int_2=0 AND a.lab_app_date<:date AND " + 
			"a.patient_id IN (SELECT p.patient_id FROM patient_details p WHERE p.family_id=:familyId) AND a.lab_id=l.lab_id AND a.lab_test_id=a.lab_test_id GROUP BY a.lab_app_id",nativeQuery=true)
	List<GetLabAppointment> getLabAppointmentForRating(@Param("familyId")int familyId,@Param("date")String date);
	
	
}

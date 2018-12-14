package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.PrescriptionDetails;

 
 
public interface AppointmentDetailsRepository extends JpaRepository<AppointmentDetails, Integer> {
	
AppointmentDetails  save(AppointmentDetails appointmentDetails);

List<AppointmentDetails> findByDoctorIdAndDate(int doctorId, String date);

List<AppointmentDetails> findByDelStatus(int delStatus);


@Query(value=" SELECT * from doctor_appointment where patient_id=:patientId AND date=:date AND del_status=0",nativeQuery=true)
List<AppointmentDetails> getAppointmentDetailsByPatient(@Param("patientId")int patientId, @Param("date")String date);

@Transactional
@Modifying
@Query("UPDATE AppointmentDetails a SET a.status =:status  WHERE a.appointId=:appId")
int updateStatusAppointment(@Param("appId")int appId, @Param("status")int status);

@Transactional
@Modifying
@Query("UPDATE AppointmentDetails a SET a.date =:date, a.time=:timeId,a.status=1  WHERE a.appointId=:appId")
int editAppointment(@Param("appId")int appId, @Param("date")String date, @Param("timeId")int timeId);

@Transactional
@Modifying
@Query("UPDATE AppointmentDetails  SET status =1 WHERE appointId=:appointId")
int updateDoctorAppointmentStatus(@Param("appointId")int appointId);

@Transactional
@Modifying
@Query("UPDATE AppointmentDetails  SET status =2 WHERE appointId=:appointId")
int cancelDoctorAppointmentByPatient(@Param("appointId")int appointId);


@Transactional
@Modifying
@Query("UPDATE AppointmentDetails  SET paymentStatus =:paymentStatus, amount=:amount, txnId=:txnId, orderId=:orderId, paymentDate=NOW() WHERE appointId=:appointId")
int updateAppointmentPayment(@Param("appointId")int appointId,@Param("paymentStatus")int paymentStatus,	@Param("amount")float amount,@Param("txnId")String txnId,@Param("orderId")String orderId);

}



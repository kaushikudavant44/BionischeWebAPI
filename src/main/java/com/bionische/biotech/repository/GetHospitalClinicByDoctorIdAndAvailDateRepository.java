package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetHospitalClinicByDoctorIdAndAvailDate;

public interface GetHospitalClinicByDoctorIdAndAvailDateRepository extends JpaRepository<GetHospitalClinicByDoctorIdAndAvailDate, Integer>{

	@Query(value="select h.hospital_id, h.hospital_name, h.type, h.contact_no, h.email_id, h.address, h.cityid,c.city_name, h.lat, h.longitude, dt.available_time"
			+ " from hospital_details h, city c, doctor_hospital_details dh, doc_available_time dt where dh.doctor_id=:doctorId AND dh.hospital_id=h.hospital_id AND "
			+ "h.del_status=0 AND dt.doctor_id=:doctorId AND dt.date=:date AND dt.hospital_id=h.hospital_id AND c.city_id=h.cityid",nativeQuery=true)
	List<GetHospitalClinicByDoctorIdAndAvailDate> getHospitalClinicByDoctorIdAndAvailDate(@Param("doctorId") int doctorId, @Param("date") String date);
}

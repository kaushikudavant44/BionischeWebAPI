package com.bionische.biotech.repository;

import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetDoctorHospitalDetails;

public interface GetDoctorHospitalDetailsRepository extends JpaRepository<GetDoctorHospitalDetails, Integer>{

	@Query(value="SELECT d.id,d.hospital_id, d.del_status, d.doctor_id, h.hospital_name, h.type from doctor_hospital_details d, hospital_details h where d.doctor_id=:doctorId AND d.hospital_id=h.hospital_id AND d.del_status=:delStatus AND h.del_status=:delStatus",nativeQuery=true)
	List<GetDoctorHospitalDetails> getHospitalDetailsByDoctorIdAndDelStatus(@Param("doctorId") int doctorId, @Param("delStatus") int delStatus);

	@Query(value="SELECT d.id,d.hospital_id, d.del_status, d.doctor_id, h.hospital_name, h.type from doctor_hospital_details d, hospital_details h where d.doctor_id=:doctorId AND d.hospital_id=h.hospital_id",nativeQuery=true)
	List<GetDoctorHospitalDetails> getHospitalDetailsByDoctorIdAndDelStatus(@Param("doctorId")int doctorId);
}

package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetHospitalDetails;
import com.bionische.biotech.model.GetHospitalDetailsByType;

public interface GetHospitalDetailsByTypeRepository extends JpaRepository<GetHospitalDetailsByType, Integer>{
	
	@Query(value="SELECT  h.type, h.hospital_name, h.contact_no, h.email_id, h.state_id,h.address,h.cityid,h.hospital_id,c.city_name,s.state_name \r\n" + 
			"FROM hospital_details h, city c, state s WHERE h.type=:type AND h.cityid=c.city_id AND h.state_id=s.state_id AND h.del_status=0;",nativeQuery=true)
	List<GetHospitalDetailsByType> findHospitalByType(@Param("type")int type);

}

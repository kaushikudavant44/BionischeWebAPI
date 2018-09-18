package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bionische.biotech.model.MedicalsInfo;

public interface MedicalsInfoRepository extends JpaRepository<MedicalsInfo, Integer> {
	
	@Query(value=" SELECT * from medicals_info where city_name=:cityName AND del_status=0",nativeQuery=true)
	List<MedicalsInfo> getMedicalsByCityName( @Param("cityName")String cityName);

	MedicalsInfo  save(MedicalsInfo medicalsInfo);
}

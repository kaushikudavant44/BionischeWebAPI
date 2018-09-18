package com.bionische.biotech.radiology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.radiology.model.IndicationsModel;

public interface PndtPatientIndicationRepository extends JpaRepository<IndicationsModel, Integer>{

	List<IndicationsModel> save(List<IndicationsModel> indicationsModelList);
	List<IndicationsModel> findByPndtId(int pndtId);
}

package com.bionische.biotech.radiology.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.biotech.model.Info;
import com.bionische.biotech.radiology.model.ChildsModel;
import com.bionische.biotech.radiology.model.IndicationsModel;
import com.bionische.biotech.radiology.model.PNDTPatientDetails;
import com.bionische.biotech.radiology.repository.PndtPatientChildRepository;
import com.bionische.biotech.radiology.repository.PndtPatientIndicationRepository;
import com.bionische.biotech.radiology.repository.PndtPatientRepository;

@Service
public class PndtPatientDetailsServiceImpl implements PndtPatientDetailsService {

	@Autowired
	PndtPatientRepository pndtPatientRepository;

	@Autowired
	PndtPatientIndicationRepository pndtPatientIndicationRepository;

	@Autowired
	PndtPatientChildRepository pndtPatientChildRepository;

	@Override
	public Info insertPndtPatientDetails(PNDTPatientDetails pndtPatientDetails) {

		Info info = new Info();
		try {

			PNDTPatientDetails pndtPatientDetailsResponse = pndtPatientRepository.save(pndtPatientDetails);

			System.out.println("cdscds" + pndtPatientDetails);
			int pndtId = pndtPatientDetailsResponse.getPndtId();

			for (int i = 0; i < pndtPatientDetails.getIndicationsModelList().size(); i++) {

				pndtPatientDetails.getIndicationsModelList().get(i).setPndtId(pndtId);
				pndtPatientIndicationRepository.save(pndtPatientDetails.getIndicationsModelList().get(i));

			}

			for (int i = 0; i < pndtPatientDetails.getChildsModelList().size(); i++) {

				pndtPatientDetails.getChildsModelList().get(i).setPndtId(pndtId);

				pndtPatientChildRepository.save(pndtPatientDetails.getChildsModelList().get(i));
			}

			if (pndtPatientDetailsResponse != null) {
				info.setError(false);
				info.setMessage("Success");
			} else {
				info.setError(true);
				info.setMessage("Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return info;

	}

	@Override
	public List<IndicationsModel> getIndicationByPndtId(int pndtId) {

		List<IndicationsModel> indicationModelList = new ArrayList<IndicationsModel>();
		try {
			indicationModelList = pndtPatientIndicationRepository.findByPndtId(pndtId);

		} catch (Exception e) {

		}

		return indicationModelList;
	}
	
	@Override
	public List<ChildsModel> getChildsByPndtId(int pndtId) {

		List<ChildsModel> childModelList = new ArrayList<ChildsModel>();
		try {
			childModelList = pndtPatientChildRepository.findByPndtId(pndtId);

		} catch (Exception e) {

		}

		return childModelList;
	}

}

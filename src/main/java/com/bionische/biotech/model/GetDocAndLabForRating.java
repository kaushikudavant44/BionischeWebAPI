package com.bionische.biotech.model;

import java.util.List;

public class GetDocAndLabForRating {
	
	List<ConsultingDetails> doctorsInfo;
	
	List<GetLabAppointment> labInfo;

	public List<ConsultingDetails> getDoctorsInfo() {
		return doctorsInfo;
	}

	public void setDoctorsInfo(List<ConsultingDetails> doctorsInfo) {
		this.doctorsInfo = doctorsInfo;
	}

	public List<GetLabAppointment> getLabInfo() {
		return labInfo;
	}

	public void setLabInfo(List<GetLabAppointment> labInfo) {
		this.labInfo = labInfo;
	}

	@Override
	public String toString() {
		return "GetDocAndLabForRating [doctorsInfo=" + doctorsInfo + ", labInfo=" + labInfo + "]";
	}
	
	

}

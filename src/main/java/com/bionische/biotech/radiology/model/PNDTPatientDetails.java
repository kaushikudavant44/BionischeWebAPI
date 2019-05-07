package com.bionische.biotech.radiology.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name = "pndt_patient_details")
public class PNDTPatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pndt_id")
	private int pndtId;
	
	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "state")
	private String state;

	@Column(name = "number_of_child")
	private int numberOfChild;

	@Column(name = "number_of_male_child")
	private int numberOfMaleChild;

	@Column(name = "number_of_female_child")
	private int numberOfFemaleChild;

	@Column(name = "relative_type")
	private String relativeType;

	@Column(name = "relative_name")
	private String relativeName;

	@Column(name = "address")
	private String address;

	@Column(name = "ref_doctor")
	private String refDoctor;

	@Column(name = "self_doctor")
	private String selfDoctor;

	@Column(name = "weeks_of_pregnancy")
	private String weeksOfPregnancy;

	@Column(name = "name_of_doctor")
	private String nameOfDoctor;

	@Column(name = "number_of_indication")
	private int numberOfIndication;

	@Column(name = "non_invasive_proc")
	private String nonInvasiveProc;

	@Column(name = "preg_women_obtain_date")
	private String pregWomenObtainDate;

	@Column(name = "date_proc_car_out")
	private String dateProcCarOut;

	@Column(name = "res_of_non_invasive_proc")
	private String resOfNonInvasiveProc;

	@Column(name = "res_of_prenatal_diagno_proc")
	private String resOfPreNatalDiagnoProc;

	@Column(name = "indication_mtp_abnormal")
	private String indicationMTPAbnormal;

	@Column(name = "gen_disease_history",nullable=true)
	private String genDiseaseHistory;

	@Column(name = "indication_diango_proc")
	private String indicationDiangoProc;

	@Column(name = "date_consent_of_prg_women")
	private String dateConsentOfPrgWomen;

	@Column(name = "invasive_proc_car_out")
	private String invasiveProcCarOut;

	@Column(name = "complication_invasive_proc")
	private String complicationInvasiveProc;

	@Column(name = "additional_test_recommended")
	private String additionalTestRecommended;

	@Column(name = "result_of_procedure")
	private String resultOfProcedure;

	@Column(name = "date_res_of_procedure")
	private String dateResOfProcedure;

	@Column(name = "invasive_prenatal_diagno_proc")
	private String invasivePreNatalDiagnoProc;

	@Column(name = "indication_mtp_abnormality")
	private String indicationMTPabnormality;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "lab_id")
	private int labId;

	@Column(name = "patient_type")
	private int patientType;

	@Column(name = "string1")
	private int string1;

	@Transient
	private List<IndicationsModel> indicationsModelList;

	@Transient
	private List<ChildsModel> childsModelList;

	public List<IndicationsModel> getIndicationsModelList() {
		return indicationsModelList;
	}

	public void setIndicationsModelList(List<IndicationsModel> indicationsModelList) {
		this.indicationsModelList = indicationsModelList;
	}

	public List<ChildsModel> getChildsModelList() {
		return childsModelList;
	}

	public void setChildsModelList(List<ChildsModel> childsModelList) {
		this.childsModelList = childsModelList;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	

	public int getPatientType() {
		return patientType;
	}

	public void setPatientType(int patientType) {
		this.patientType = patientType;
	}

	public int getString1() {
		return string1;
	}

	public void setString1(int string1) {
		this.string1 = string1;
	}

	

	

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNumberOfChild() {
		return numberOfChild;
	}

	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}

	public int getNumberOfMaleChild() {
		return numberOfMaleChild;
	}

	public void setNumberOfMaleChild(int numberOfMaleChild) {
		this.numberOfMaleChild = numberOfMaleChild;
	}

	public int getNumberOfFemaleChild() {
		return numberOfFemaleChild;
	}

	public void setNumberOfFemaleChild(int numberOfFemaleChild) {
		this.numberOfFemaleChild = numberOfFemaleChild;
	}

	public String getRelativeType() {
		return relativeType;
	}

	public void setRelativeType(String relativeType) {
		this.relativeType = relativeType;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRefDoctor() {
		return refDoctor;
	}

	public void setRefDoctor(String refDoctor) {
		this.refDoctor = refDoctor;
	}

	public String getSelfDoctor() {
		return selfDoctor;
	}

	public void setSelfDoctor(String selfDoctor) {
		this.selfDoctor = selfDoctor;
	}

	public String getWeeksOfPregnancy() {
		return weeksOfPregnancy;
	}

	public void setWeeksOfPregnancy(String weeksOfPregnancy) {
		this.weeksOfPregnancy = weeksOfPregnancy;
	}

	public String getNameOfDoctor() {
		return nameOfDoctor;
	}

	public void setNameOfDoctor(String nameOfDoctor) {
		this.nameOfDoctor = nameOfDoctor;
	}

	public int getNumberOfIndication() {
		return numberOfIndication;
	}

	public void setNumberOfIndication(int numberOfIndication) {
		this.numberOfIndication = numberOfIndication;
	}

	public String getNonInvasiveProc() {
		return nonInvasiveProc;
	}

	public void setNonInvasiveProc(String nonInvasiveProc) {
		this.nonInvasiveProc = nonInvasiveProc;
	}

	public String getPregWomenObtainDate() {
		return DateConverter.convertToDMY(pregWomenObtainDate);
	}

	public void setPregWomenObtainDate(String pregWomenObtainDate) {
		this.pregWomenObtainDate = pregWomenObtainDate;
	}

	public String getDateProcCarOut() {
		return dateProcCarOut;
	}

	public void setDateProcCarOut(String dateProcCarOut) {
		this.dateProcCarOut = dateProcCarOut;
	}

	public String getResOfNonInvasiveProc() {
		return resOfNonInvasiveProc;
	}

	public void setResOfNonInvasiveProc(String resOfNonInvasiveProc) {
		this.resOfNonInvasiveProc = resOfNonInvasiveProc;
	}

	public String getResOfPreNatalDiagnoProc() {
		return resOfPreNatalDiagnoProc;
	}

	public void setResOfPreNatalDiagnoProc(String resOfPreNatalDiagnoProc) {
		this.resOfPreNatalDiagnoProc = resOfPreNatalDiagnoProc;
	}

	public String getIndicationMTPAbnormal() {
		return indicationMTPAbnormal;
	}

	public void setIndicationMTPAbnormal(String indicationMTPAbnormal) {
		this.indicationMTPAbnormal = indicationMTPAbnormal;
	}

	public String getGenDiseaseHistory() {
		return genDiseaseHistory;
	}

	public void setGenDiseaseHistory(String genDiseaseHistory) {
		this.genDiseaseHistory = genDiseaseHistory;
	}

	public String getIndicationDiangoProc() {
		return indicationDiangoProc;
	}

	public void setIndicationDiangoProc(String indicationDiangoProc) {
		this.indicationDiangoProc = indicationDiangoProc;
	}

	public String getDateConsentOfPrgWomen() {
		return dateConsentOfPrgWomen;
	}

	public void setDateConsentOfPrgWomen(String dateConsentOfPrgWomen) {
		this.dateConsentOfPrgWomen = dateConsentOfPrgWomen;
	}

	public String getInvasiveProcCarOut() {
		return invasiveProcCarOut;
	}

	public void setInvasiveProcCarOut(String invasiveProcCarOut) {
		this.invasiveProcCarOut = invasiveProcCarOut;
	}

	public String getComplicationInvasiveProc() {
		return complicationInvasiveProc;
	}

	public void setComplicationInvasiveProc(String complicationInvasiveProc) {
		this.complicationInvasiveProc = complicationInvasiveProc;
	}

	public String getAdditionalTestRecommended() {
		return additionalTestRecommended;
	}

	public void setAdditionalTestRecommended(String additionalTestRecommended) {
		this.additionalTestRecommended = additionalTestRecommended;
	}

	public String getResultOfProcedure() {
		return resultOfProcedure;
	}

	public void setResultOfProcedure(String resultOfProcedure) {
		this.resultOfProcedure = resultOfProcedure;
	}

	public String getDateResOfProcedure() {
		return dateResOfProcedure;
	}

	public void setDateResOfProcedure(String dateResOfProcedure) {
		this.dateResOfProcedure = dateResOfProcedure;
	}

	public String getInvasivePreNatalDiagnoProc() {
		return invasivePreNatalDiagnoProc;
	}

	public void setInvasivePreNatalDiagnoProc(String invasivePreNatalDiagnoProc) {
		this.invasivePreNatalDiagnoProc = invasivePreNatalDiagnoProc;
	}

	public String getIndicationMTPabnormality() {
		return indicationMTPabnormality;
	}

	public void setIndicationMTPabnormality(String indicationMTPabnormality) {
		this.indicationMTPabnormality = indicationMTPabnormality;
	}

	public int getPndtId() {
		return pndtId;
	}

	public void setPndtId(int pndtId) {
		this.pndtId = pndtId;
	}

	@Override
	public String toString() {
		return "PNDTPatientDetails [pndtId=" + pndtId + ", patientName=" + patientName + ", state=" + state
				+ ", numberOfChild=" + numberOfChild + ", numberOfMaleChild=" + numberOfMaleChild
				+ ", numberOfFemaleChild=" + numberOfFemaleChild + ", relativeType=" + relativeType + ", relativeName="
				+ relativeName + ", address=" + address + ", refDoctor=" + refDoctor + ", selfDoctor=" + selfDoctor
				+ ", weeksOfPregnancy=" + weeksOfPregnancy + ", nameOfDoctor=" + nameOfDoctor + ", numberOfIndication="
				+ numberOfIndication + ", nonInvasiveProc=" + nonInvasiveProc + ", pregWomenObtainDate="
				+ pregWomenObtainDate + ", dateProcCarOut=" + dateProcCarOut + ", resOfNonInvasiveProc="
				+ resOfNonInvasiveProc + ", resOfPreNatalDiagnoProc=" + resOfPreNatalDiagnoProc
				+ ", indicationMTPAbnormal=" + indicationMTPAbnormal + ", genDiseaseHistory=" + genDiseaseHistory
				+ ", indicationDiangoProc=" + indicationDiangoProc + ", dateConsentOfPrgWomen=" + dateConsentOfPrgWomen
				+ ", invasiveProcCarOut=" + invasiveProcCarOut + ", complicationInvasiveProc="
				+ complicationInvasiveProc + ", additionalTestRecommended=" + additionalTestRecommended
				+ ", resultOfProcedure=" + resultOfProcedure + ", dateResOfProcedure=" + dateResOfProcedure
				+ ", invasivePreNatalDiagnoProc=" + invasivePreNatalDiagnoProc + ", indicationMTPabnormality="
				+ indicationMTPabnormality + ", delStatus=" + delStatus + ", labId=" + labId + ", patientType="
				+ patientType + ", string1=" + string1 + ", indicationsModelList=" + indicationsModelList
				+ ", childsModelList=" + childsModelList + "]";
	}

	

	

	

}

package com.bionische.biotech.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.insurance.model.CompaniesOnAge;
import com.bionische.biotech.model.City;
import com.bionische.biotech.model.ConsultingDetails;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.GetCompletedPrescription;
import com.bionische.biotech.model.GetDocAndLabForRating;
import com.bionische.biotech.model.GetLabAppointment;
import com.bionische.biotech.model.GetPrescriptionWithBill;
import com.bionische.biotech.model.GetReportDetailsForLab;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.MedicalDetails;
import com.bionische.biotech.model.MedicalsInfo;
import com.bionische.biotech.model.PrescriptionDetails;
import com.bionische.biotech.model.PrescriptionToMedical;
import com.bionische.biotech.model.SpecializationDetails;
import com.bionische.biotech.model.SubmitPrescBill;
import com.bionische.biotech.model.SubmitPrescriptioToPharmacy;
import com.bionische.biotech.repository.ConsultingDetailsRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.GetLabAppointmentRrepository;
import com.bionische.biotech.repository.GetPrescriptionWithBillRepository;
import com.bionische.biotech.repository.GetReportDetailsForLabRepository;
import com.bionische.biotech.repository.MedicalDetailsRepository;
import com.bionische.biotech.repository.MedicalsInfoRepository;
import com.bionische.biotech.repository.PrescriptionDetailsRepository;
import com.bionische.biotech.repository.PrescriptionToMedicalRepository;
import com.bionische.biotech.repository.SubmitPrescBillRepository;
import com.bionische.biotech.repository.SubmitPrescriptioToPharmacyRepository;

@RestController
public class ConsultingDetailsController {
	
	
	@Autowired
	ConsultingDetailsRepository consultingDetailsRepository;
	@Autowired
	PrescriptionDetailsRepository prescriptionDetailsRepository;
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	@Autowired
	MedicalsInfoRepository medicalsInfoRepository;
	@Autowired
	MedicalDetailsRepository medicalDetailsRepository;
	@Autowired
	PrescriptionToMedicalRepository prescriptionToMedicalRepository;
	@Autowired
	SubmitPrescriptioToPharmacyRepository submitPrescriptioToPharmacyRepository;
	@Autowired
	GetReportDetailsForLabRepository getReportDetailsForLabRepository; 
	@Autowired
	SubmitPrescBillRepository submitPrescBillRepository;
	@Autowired
	GetPrescriptionWithBillRepository getPrescriptionWithBillRepository;
	@Autowired
	GetLabAppointmentRrepository getLabAppointmentRrepository;
	
	@RequestMapping(value = { "/getConsultingByDoctorIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List getConsultingByDoctorIdAndDate(@RequestParam("doctorId") int doctorId,@RequestParam("patientId") int patientId,@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
	
	{
		System.out.println("patientId:"+patientId);
		System.out.println("doctorId:"+doctorId);
		System.out.println("startdate:"+startdate);
		System.out.println("enddate:"+enddate);
		
		
	List<ConsultingDetails> consultingList =new ArrayList<ConsultingDetails>();
		Info info=new Info();
		try {
			
			if(doctorId!=0)
			{
				 consultingList=consultingDetailsRepository.getConsultingDetailsByDoctor(doctorId,patientId);
				
			}
			else {
				System.out.println("hello");
				/*startdate=DateConverter.convertToYMD(startdate);
				enddate=DateConverter.convertToYMD(enddate);*/
				consultingList=consultingDetailsRepository.getConsultingDetailsByDate(startdate,enddate,patientId);
				
			}
			
			System.out.println("Consulting List "+consultingList.toString());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return consultingList;         
	}
	
	@RequestMapping(value = { "/getConsultingByDoctorAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List getConsultingByDoctorAndDate(@RequestParam("doctorId") int doctorId,@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
	
	{
		System.out.println("doctorId:"+doctorId);
		System.out.println("startdate:"+startdate);
		System.out.println("enddate:"+enddate);

	List<ConsultingDetails> consultingList =new ArrayList<ConsultingDetails>();
		Info info=new Info();
		try {
			
			
				
				consultingList=consultingDetailsRepository.getConsultingDetailsByDateANDdoctorId(startdate,enddate,doctorId);
				System.out.println("Consulting List "+consultingList.toString());

			}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return consultingList;
	}
	
	
	
	
	@RequestMapping(value = { "/getPrescriptionByMeetingId" }, method = RequestMethod.POST)
	public @ResponseBody List<PrescriptionDetails> getPrescriptionByMeetingId(@RequestParam("meetingId") int meetingId)
	
	{
		
		List<PrescriptionDetails> PrescriptionDetails = new ArrayList<PrescriptionDetails>();
		Info info=new Info();
		try {
			
			PrescriptionDetails=prescriptionDetailsRepository.findByMeetingId(meetingId);
				
			
			System.out.println("prescription list "+PrescriptionDetails.toString());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return PrescriptionDetails;
	}

	@RequestMapping(value = { "/getDoctorDetailsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List getDoctorDetailsByPatientId(@RequestParam("patientId") int patientId)
	
	{
		
		List<DoctorDetails> doctorDetails = new ArrayList<DoctorDetails>();
		Info info=new Info();
		try {
			System.out.println("cammmee");
			doctorDetails=doctorDetailsRepository.getDoctorsByPatientAppointment(patientId);
				
			
			System.out.println("prescription list "+doctorDetails.toString());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return doctorDetails;
	}
	
	// medicals by cityname
	@RequestMapping(value = { "/getMedicalsByCityName" }, method = RequestMethod.POST)
	public @ResponseBody List<MedicalsInfo> getMedicalsByCityName(@RequestParam("cityName") String cityName)
	
	{
		
		List<MedicalsInfo> medicalsInfo = new ArrayList<MedicalsInfo>();
		Info info=new Info();
		try {
			
			medicalsInfo=medicalsInfoRepository.getMedicalsByCityName(cityName);
				
			
			System.out.println("medicalsInfo list "+medicalsInfo.toString());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	
		return medicalsInfo;
	}
	
	// medicals by patientId
		@RequestMapping(value = { "/getMedicalsByPatientId" }, method = RequestMethod.POST)
		public @ResponseBody List<MedicalDetails> getMedicalsByPatientId(@RequestParam("patientId") int patientId)
		
		{
			
			List<MedicalDetails> medicalsInfo = new ArrayList<MedicalDetails>();
			System.out.println("patientIdddddddddddddddddddddddddddddddddd:"+patientId);
			try {
				
				medicalsInfo=medicalDetailsRepository.getMedicalsDetailsByPatient(patientId);
					
				
				System.out.println("medicalsInfo list "+medicalsInfo.toString());
				
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				
			}
		
			return medicalsInfo;
		}
		
		// medicals by pincode
				@RequestMapping(value = { "/getPharmacyByPincode" }, method = RequestMethod.POST)
				public @ResponseBody List<MedicalDetails> getPharmacyByPincode(@RequestParam("pincode") int pincode)
				
				{
					
					List<MedicalDetails> medicalsInfo = new ArrayList<MedicalDetails>();
					System.out.println("pincode:"+pincode);
					try {
						
						medicalsInfo=medicalDetailsRepository.getPharmacyByPincode(pincode);
							
						
						System.out.println("medicalsInfo list "+medicalsInfo.toString());
						
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
						
					}
				
					return medicalsInfo;
				}


	//insert presc details sent to medical
		@RequestMapping(value = { "/submitMedicineToPharmacy" }, method = RequestMethod.POST)
		public @ResponseBody Info submitMedicineToPharmacy(@RequestBody SubmitPrescriptioToPharmacy prescriptionToMedical)
		{
			SubmitPrescriptioToPharmacy prescriptionToMedicalRes=new SubmitPrescriptioToPharmacy();
			System.out.println("Comming List "+prescriptionToMedical.toString());
			Info info =new Info();
			try {
				prescriptionToMedicalRes=submitPrescriptioToPharmacyRepository.save(prescriptionToMedical); 
			System.out.println("finalllyyy:"+prescriptionToMedicalRes.toString());
			
			if(prescriptionToMedicalRes!=null)
			{
				info.setError(false);
				info.setMessage("Success");
			}
			else {
				info.setError(true);
				info.setMessage("Failed to insert");
			}
		} 
			catch (Exception e) {
				System.out.println(e.getMessage());
				info.setError(true);
				info.setMessage("Failed to insert");
			}
			
			
		
			return info;
		}
		
		//get presc details of medical
				@RequestMapping(value = { "/getPrescriptionsOfMedical" }, method = RequestMethod.POST)
				public @ResponseBody List<PrescriptionToMedical> getPrescriptionsOfMedical(@RequestParam("medicalId") int medicalId,@RequestParam("date") String date)
				{
					List<PrescriptionToMedical> prescriptionToMedicalRes=new ArrayList();
					List<PrescriptionToMedical> prescriptionToMedicalResFinal=new ArrayList();
					

					List<PrescriptionDetails> PrescriptionDetails = new ArrayList<PrescriptionDetails>();
					List<GetPrescriptionWithBill> getPrescriptionWithBill = new ArrayList<GetPrescriptionWithBill>();	
				
					Info info =new Info();
					try {
						prescriptionToMedicalRes=prescriptionToMedicalRepository.getPrescriptionsOfMedical(medicalId,date); 
						
						 for (PrescriptionToMedical orders : prescriptionToMedicalRes) 
						    {
							 PrescriptionToMedical prescriptionToMedical=new PrescriptionToMedical();
							 PrescriptionDetails=prescriptionDetailsRepository.findByMeetingId(orders.getMeetId());
							
							 prescriptionToMedical.setDate(orders.getDate());
							 prescriptionToMedical.setDelStatus(orders.getDelStatus());
							 prescriptionToMedical.setPatientContact(orders.getPatientContact());
							 prescriptionToMedical.setAddress(orders.getAddress());
							 prescriptionToMedical.setDeliveryType(orders.getDeliveryType());
							 prescriptionToMedical.setDoctorName(orders.getDoctorName());
							 prescriptionToMedical.setHospitalName(orders.getHospitalName());
							 prescriptionToMedical.setInt1(orders.getInt1());
							 prescriptionToMedical.setInt2(orders.getInt2());
							 prescriptionToMedical.setMedicalId(orders.getMedicalId());
							 prescriptionToMedical.setMeetId(orders.getMeetId());
							 prescriptionToMedical.setPatientName(orders.getPatientName());
							 prescriptionToMedical.setPatientRequestToMedicalId(orders.getPatientRequestToMedicalId());
							 prescriptionToMedical.setPrescriptionDetails(PrescriptionDetails);
							 prescriptionToMedical.setStatus(orders.getStatus());
							 prescriptionToMedical.setString1(orders.getString1());
							 prescriptionToMedical.setString2(orders.getString2());
							 prescriptionToMedical.setTime(orders.getTime());
							 prescriptionToMedical.setPincode(orders.getPincode());
						
							 prescriptionToMedicalResFinal.add(prescriptionToMedical);
							 
						    }
					
					
				} 
					catch (Exception e) {
						System.out.println(e.getMessage());
						
					}
					System.out.println("prescriptionToMedicalRes:"+prescriptionToMedicalResFinal.toString());
					
				
					return prescriptionToMedicalResFinal;
				}
				
				
				//get completed presc details of medical
				@RequestMapping(value = { "/getCompletedPrescOfMedical" }, method = RequestMethod.POST)
				public @ResponseBody List<GetCompletedPrescription> getCompletedPrescOfMedical(@RequestParam("medicalId") int medicalId,@RequestParam("date") String date)
				{
					List<PrescriptionToMedical> prescriptionToMedicalRes=new ArrayList();
					List<GetCompletedPrescription> prescriptionToMedicalResFinal=new ArrayList<GetCompletedPrescription>();
					
					List<GetPrescriptionWithBill> getPrescriptionWithBill = new ArrayList<GetPrescriptionWithBill>();
					
					System.out.println("medicalisdd:"+medicalId+"date:"+date);
				
					Info info =new Info();
					try {
						prescriptionToMedicalRes=prescriptionToMedicalRepository.getCompletedPrescOfMedical(medicalId,date); 
						System.out.println("prescriptionToMedicalRes:"+prescriptionToMedicalRes.toString());
						
						 for (PrescriptionToMedical orders : prescriptionToMedicalRes) 
						    {
							 GetCompletedPrescription prescriptionToMedical=new GetCompletedPrescription();
							 System.out.println("orders.getMeetId():"+orders.getMeetId());
							 getPrescriptionWithBill=getPrescriptionWithBillRepository.getCompletedPrescriptionAndBill(orders.getPatientRequestToMedicalId());
							 System.out.println("prescriptioooooooonbill:"+getPrescriptionWithBill.get(0).getTotalBill());
							
							 prescriptionToMedical.setDate(orders.getDate());
							 
							 prescriptionToMedical.setDelStatus(orders.getDelStatus());
							 prescriptionToMedical.setPatientContact(orders.getPatientContact());
							 prescriptionToMedical.setAddress(orders.getAddress());
							 prescriptionToMedical.setDeliveryType(orders.getDeliveryType());
							 prescriptionToMedical.setDoctorName(orders.getDoctorName());
							 prescriptionToMedical.setHospitalName(orders.getHospitalName());
							 prescriptionToMedical.setInt1(orders.getInt1());
							 prescriptionToMedical.setInt2(orders.getInt2());
							 prescriptionToMedical.setMedicalId(orders.getMedicalId());
							 prescriptionToMedical.setMeetId(orders.getMeetId());
							 prescriptionToMedical.setPatientName(orders.getPatientName());
							 prescriptionToMedical.setPatientRequestToMedicalId(orders.getPatientRequestToMedicalId());
							 prescriptionToMedical.setTotalBill(getPrescriptionWithBill.get(0).getTotalBill());
							 prescriptionToMedical.setStatus(orders.getStatus());
							 prescriptionToMedical.setString1(orders.getString1());
							 prescriptionToMedical.setString2(orders.getString2());
							 prescriptionToMedical.setTime(orders.getTime());
						     prescriptionToMedical.setGetPrescriptionWithBill(getPrescriptionWithBill);
							 prescriptionToMedicalResFinal.add(prescriptionToMedical);
							 
						    }
					System.out.println(prescriptionToMedicalRes.toString());
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
						
					}
				
					
				
					return prescriptionToMedicalResFinal;
				}
				
						
						//get presc details of medical
						@RequestMapping(value = { "/editDeliveredPrescription" }, method = RequestMethod.POST)
						public @ResponseBody Info editDeliveredPrescription(@RequestParam("patientRequestToMedicalId") int patientRequestToMedicalId)
						{
							
							Info info =new Info();
							try {
								int res=prescriptionToMedicalRepository.editDeliveredPrescription(patientRequestToMedicalId); 
							
							if(res>0)
							{
								info.setMessage("Your Appointment Change Successfully!!");
								info.setError(false);
							}
							else {
								info.setMessage("Your Appointment Change Failed!!");
								info.setError(true);
							}
							 
						}
						catch (Exception e) {
						e.printStackTrace();
						}
				        return info;
}
						
						
						
						@RequestMapping(value = { "/submitMedicalRegProcess" }, method = RequestMethod.POST)
						public @ResponseBody MedicalsInfo submitMedicalRegProcess(@RequestBody MedicalsInfo medicalsInfo)
						{
							MedicalsInfo medicalsInfoRes=new MedicalsInfo();
							
							try {
								medicalsInfoRes=medicalsInfoRepository.save(medicalsInfo); 
							System.out.println(medicalsInfoRes.toString());
							
							
						} 
							catch (Exception e) {
								System.out.println(e.getMessage());
								
							}
							
										
							return medicalsInfoRes;
						}
						
						// patient appointment  confirmed by doctor(get doctors)
						
						@RequestMapping(value = { "/getDoctorsByPatientApp" }, method = RequestMethod.POST)
						public @ResponseBody List getDoctorsByPatientApp(@RequestParam("patientId") int patientId)
						
						{
							
							List<DoctorDetails> doctorDetails = new ArrayList<DoctorDetails>();
						
							try {
								
								doctorDetails=doctorDetailsRepository.getDoctorsByPatientAppointment(patientId);
									
								
								System.out.println("prescription list "+doctorDetails.toString());
								
							}
							catch (Exception e) {
								// TODO: handle exception
								System.out.println(e.getMessage());
								
							}
						
							return doctorDetails;
						}
						
						@RequestMapping(value = { "/DoctorsAndLabsForRating" }, method = RequestMethod.POST)
						public @ResponseBody GetDocAndLabForRating DoctorsAndLabsForRating(@RequestParam("familyId") int familyId)
						
						{
														
							GetDocAndLabForRating getDocAndLabForRating =new GetDocAndLabForRating();
							Info info=new Info();
							try {
								String date= new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)));
								
									List<ConsultingDetails> consultingDetails=consultingDetailsRepository.getConsultingDetailsByRatingStatus(familyId,date);
									List<GetLabAppointment> getReportDetailsForLab=getLabAppointmentRrepository.getLabAppointmentForRating(familyId,date);
									
									getDocAndLabForRating.setDoctorsInfo(consultingDetails);
									getDocAndLabForRating.setLabInfo(getReportDetailsForLab);
									System.out.println("getDocAndLabForRating "+getDocAndLabForRating.toString());

								}
							catch (Exception e) {
								// TODO: handle exception
								System.out.println(e.getMessage());
								
							}
						
							return getDocAndLabForRating;
						}
						
						//submit presc bill to medical
						@RequestMapping(value = { "/submitBillToPharmacy" }, method = RequestMethod.POST)
						public @ResponseBody Info submitBillToPharmacy(@RequestBody List<SubmitPrescBill> SubmitPrescBillList)
						{
							SubmitPrescBill submitPrescBillRes = new SubmitPrescBill();
							System.out.println("Comming List "+SubmitPrescBillList.toString());
							Info info =new Info();
							submitPrescriptioToPharmacyRepository.updateCompletedPrescription(SubmitPrescBillList.get(0).getMedicalRequestId());
							try {
								for(int i=0;i<SubmitPrescBillList.size();i++)
								
								submitPrescBillRes=submitPrescBillRepository.save(SubmitPrescBillList.get(i)); 
							System.out.println(submitPrescBillRes.toString());
							
							if(submitPrescBillRes!=null)
							{
								info.setError(false);
								info.setMessage("Success");
							}
							else {
								info.setError(true);
								info.setMessage("Failed to insert");
							}
						} 
							catch (Exception e) {
								System.out.println(e.getMessage());
								info.setError(true);
								info.setMessage("Failed to insert");
							}
							
							
						
							return info;
						}
						
						//update paid status
						@RequestMapping(value = { "/updatePaidStatus" }, method = RequestMethod.POST)
						public @ResponseBody Info updatePaidStatus(@RequestParam("medicalRequestId") int medicalRequestId)
						{
							
							Info info =new Info();
							int res=submitPrescriptioToPharmacyRepository.updatePaidStatus(medicalRequestId);
							
							
							if(res!=0)
							{
								info.setError(false);
								info.setMessage("Success");
							}
							else {
								info.setError(true);
								info.setMessage("Failed to update");
							}
						
							
						
							return info;
						}
						
						//update paid status
						@RequestMapping(value = { "/updateDeliveredStatus" }, method = RequestMethod.POST)
						public @ResponseBody Info updateDeliveredStatus(@RequestParam("medicalRequestId") int medicalRequestId)
						{
							System.out.println("stattuuuuuuus:"+medicalRequestId);
							Info info =new Info();
							int res=submitPrescriptioToPharmacyRepository.updateDeliveredStatus(medicalRequestId);
							System.out.println(res);
							
							if(res!=0)
							{
								info.setError(false);
								info.setMessage("Success");
							}
							else {
								info.setError(true);
								info.setMessage("Failed to update");
							}
						
							
						
							return info;
						}
						
						//get completed presc details of medical
						@RequestMapping(value = { "/getHistoryOfMedical" }, method = RequestMethod.POST)
						public List<GetCompletedPrescription> getHistoryOfMedical(@RequestParam("medicalId") int medicalId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
						{
							List<PrescriptionToMedical> prescriptionToMedicalRes=new ArrayList();
							List<GetCompletedPrescription> prescriptionToMedicalResFinal=new ArrayList<GetCompletedPrescription>();
							
							
							List<GetPrescriptionWithBill> getPrescriptionWithBill = new ArrayList<GetPrescriptionWithBill>();
							
						System.out.println("ccccameeeeeeee:"+medicalId+"sdbngnd"+fromDate+toDate);
							Info info =new Info();
							try {
								prescriptionToMedicalRes=prescriptionToMedicalRepository.getHistoryOfMedical(medicalId,fromDate,toDate); 
								System.out.println("prescriptionToMedicalResHistory:"+prescriptionToMedicalRes.toString());
								
								 for (PrescriptionToMedical orders : prescriptionToMedicalRes) 
								    {
									 GetCompletedPrescription prescriptionToMedical=new GetCompletedPrescription();
									 System.out.println("orders.getMeetId():"+orders.getPatientRequestToMedicalId());
									 getPrescriptionWithBill=getPrescriptionWithBillRepository.getCompletedPrescriptionAndBill(orders.getPatientRequestToMedicalId());
									 System.out.println("prescriptioooooooonbill:"+getPrescriptionWithBill.toString());
									 
									 prescriptionToMedical.setDate(orders.getDate());
									
									 prescriptionToMedical.setDelStatus(orders.getDelStatus());
									
									 prescriptionToMedical.setPatientContact(orders.getPatientContact());
									 prescriptionToMedical.setAddress(orders.getAddress());
									 prescriptionToMedical.setDeliveryType(orders.getDeliveryType());
									 prescriptionToMedical.setDoctorName(orders.getDoctorName());
									 prescriptionToMedical.setHospitalName(orders.getHospitalName());
									 prescriptionToMedical.setInt1(orders.getInt1());
									 prescriptionToMedical.setInt2(orders.getInt2());
									 prescriptionToMedical.setMedicalId(orders.getMedicalId());
									 prescriptionToMedical.setMeetId(orders.getMeetId());
									 prescriptionToMedical.setPatientName(orders.getPatientName());
									 prescriptionToMedical.setPatientRequestToMedicalId(orders.getPatientRequestToMedicalId());
									 prescriptionToMedical.setTotalBill(getPrescriptionWithBill.get(0).getTotalBill());
									 prescriptionToMedical.setStatus(orders.getStatus());
									 prescriptionToMedical.setString1(orders.getString1());
									 prescriptionToMedical.setString2(getPrescriptionWithBill.get(0).getBillDate());
									 prescriptionToMedical.setTime(orders.getTime());
									 prescriptionToMedical.setGetPrescriptionWithBill(getPrescriptionWithBill);
									 prescriptionToMedicalResFinal.add(prescriptionToMedical);
									 
								    }
							System.out.println(prescriptionToMedicalRes.toString());
							}
							catch (Exception e) {
								System.out.println(e.getMessage());
								
							}
						
							
						
							return prescriptionToMedicalResFinal;

						}
					
						//having prescription
						@RequestMapping(value = { "/getConsultingByDoctorIdAndDatePresc" }, method = RequestMethod.POST)
						public @ResponseBody List getConsultingByDoctorIdAndDatePresc(@RequestParam("doctorId") int doctorId,@RequestParam("patientId") int patientId,@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate)
						
						{
							System.out.println("patientId:"+patientId);
							System.out.println("doctorId:"+doctorId);
							System.out.println("startdate:"+startdate);
							System.out.println("enddate:"+enddate);
							
							
						List<ConsultingDetails> consultingList =new ArrayList<ConsultingDetails>();
							Info info=new Info();
							try {
								
								if(doctorId!=0)
								{
									 consultingList=consultingDetailsRepository.getConsultingDetailsByDoctorHavePresc(doctorId,patientId);
									
								}
								else {
									System.out.println("hello");
									/*startdate=DateConverter.convertToYMD(startdate);
									enddate=DateConverter.convertToYMD(enddate);*/
									consultingList=consultingDetailsRepository.getConsultingDetailsByDateHavePresc(startdate,enddate,patientId);
									
								}
								
								System.out.println("Consulting List "+consultingList.toString());
								
							}
							catch (Exception e) {
								// TODO: handle exception
								System.out.println(e.getMessage());
								
							}
						
							return consultingList;         
						}
						
						
						
						//get completed presc details of medical
						@RequestMapping(value = { "/getHistoryOfMedicalToPatient" }, method = RequestMethod.POST)
						public List<GetCompletedPrescription> getHistoryOfMedicalToPatient(@RequestParam("patientId") int patientId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
						{
							List<PrescriptionToMedical> prescriptionToMedicalRes=new ArrayList();
							List<GetCompletedPrescription> prescriptionToMedicalResFinal=new ArrayList<GetCompletedPrescription>();
							
							
							List<GetPrescriptionWithBill> getPrescriptionWithBill = new ArrayList<GetPrescriptionWithBill>();
							
						
							Info info =new Info();
							try {
								prescriptionToMedicalRes=prescriptionToMedicalRepository.getHistoryOfMedicalToPatient(patientId,fromDate,toDate); 
								System.out.println("prescriptionToMedicalResHistory:"+prescriptionToMedicalRes.toString());
								
								 for (PrescriptionToMedical orders : prescriptionToMedicalRes) 
								    {
									 GetCompletedPrescription prescriptionToMedical=new GetCompletedPrescription();
									 System.out.println("orders.getMeetId():"+orders.getPatientRequestToMedicalId());
									 getPrescriptionWithBill=getPrescriptionWithBillRepository.getCompletedPrescriptionAndBill(orders.getPatientRequestToMedicalId());
									
									 System.out.println("prescriptioooooooonbill:"+getPrescriptionWithBill.get(0).getTotalBill());
									 System.out.println(getPrescriptionWithBill.get(0).getBillDate());
									 prescriptionToMedical.setMedicalName(orders.getMedicalName());
									 prescriptionToMedical.setDate(orders.getDate());
									 
									 prescriptionToMedical.setDelStatus(orders.getDelStatus());
									
									 prescriptionToMedical.setPatientContact(orders.getPatientContact());
									 prescriptionToMedical.setAddress(orders.getAddress());
									 prescriptionToMedical.setDeliveryType(orders.getDeliveryType());
									 prescriptionToMedical.setDoctorName(orders.getDoctorName());
									 prescriptionToMedical.setHospitalName(orders.getHospitalName());
									 prescriptionToMedical.setInt1(orders.getInt1());
									 prescriptionToMedical.setInt2(orders.getInt2());
									 prescriptionToMedical.setMedicalId(orders.getMedicalId());
									 prescriptionToMedical.setMeetId(orders.getMeetId());
									 prescriptionToMedical.setPatientName(orders.getPatientName());
									 prescriptionToMedical.setPatientRequestToMedicalId(orders.getPatientRequestToMedicalId());
									 prescriptionToMedical.setTotalBill(getPrescriptionWithBill.get(0).getTotalBill());
									 prescriptionToMedical.setStatus(orders.getStatus());
									 prescriptionToMedical.setString1(orders.getString1());
									 prescriptionToMedical.setString2(getPrescriptionWithBill.get(0).getBillDate());
									 prescriptionToMedical.setTime(orders.getTime());
									// prescriptionToMedical.setMedicalName(medicalName);
									 prescriptionToMedical.setGetPrescriptionWithBill(getPrescriptionWithBill);
									 prescriptionToMedicalResFinal.add(prescriptionToMedical);
									 
								    }
							System.out.println(prescriptionToMedicalResFinal.toString());
							}
							catch (Exception e) {
								System.out.println(e.getMessage());
								
							}
						
							
						
							return prescriptionToMedicalResFinal;

						}
						
						
						
						//get completed presc details of medical
						@RequestMapping(value = { "/getRecentHistoryOfMedicalToPatient" }, method = RequestMethod.POST)
						public List<GetCompletedPrescription> getRecentHistoryOfMedicalToPatient(@RequestParam("patientId") int patientId)
						{
							List<PrescriptionToMedical> prescriptionToMedicalRes=new ArrayList();
							List<GetCompletedPrescription> prescriptionToMedicalResFinal=new ArrayList<GetCompletedPrescription>();
							
							
							List<GetPrescriptionWithBill> getPrescriptionWithBill = new ArrayList<GetPrescriptionWithBill>();
							
						
							Info info =new Info();
							try {
								prescriptionToMedicalRes=prescriptionToMedicalRepository.getRecentHistoryOfMedicalToPatient(patientId); 
								System.out.println("prescriptionToMedicalResHistory:"+prescriptionToMedicalRes.toString());
								
								 for (PrescriptionToMedical orders : prescriptionToMedicalRes) 
								    {
									 GetCompletedPrescription prescriptionToMedical=new GetCompletedPrescription();
									 System.out.println("orders.getMeetId():"+orders.getPatientRequestToMedicalId());
									 getPrescriptionWithBill=getPrescriptionWithBillRepository.getCompletedPrescriptionAndBill(orders.getPatientRequestToMedicalId());
									
									 System.out.println("prescriptioooooooonbill:"+getPrescriptionWithBill.get(0).getTotalBill());
									 System.out.println(getPrescriptionWithBill.get(0).getBillDate());
									 prescriptionToMedical.setMedicalName(orders.getMedicalName());
									 prescriptionToMedical.setDate(orders.getDate());
									 
									 prescriptionToMedical.setDelStatus(orders.getDelStatus());
									
									 prescriptionToMedical.setPatientContact(orders.getPatientContact());
									 prescriptionToMedical.setAddress(orders.getAddress());
									 prescriptionToMedical.setDeliveryType(orders.getDeliveryType());
									 prescriptionToMedical.setDoctorName(orders.getDoctorName());
									 prescriptionToMedical.setHospitalName(orders.getHospitalName());
									 prescriptionToMedical.setInt1(orders.getInt1());
									 prescriptionToMedical.setInt2(orders.getInt2());
									 prescriptionToMedical.setMedicalId(orders.getMedicalId());
									 prescriptionToMedical.setMeetId(orders.getMeetId());
									 prescriptionToMedical.setPatientName(orders.getPatientName());
									 prescriptionToMedical.setPatientRequestToMedicalId(orders.getPatientRequestToMedicalId());
									 prescriptionToMedical.setTotalBill(getPrescriptionWithBill.get(0).getTotalBill());
									 prescriptionToMedical.setStatus(orders.getStatus());
									 prescriptionToMedical.setString1(orders.getString1());
									 prescriptionToMedical.setString2(getPrescriptionWithBill.get(0).getBillDate());
									 prescriptionToMedical.setTime(orders.getTime());
									// prescriptionToMedical.setMedicalName(medicalName);
									 prescriptionToMedical.setGetPrescriptionWithBill(getPrescriptionWithBill);
									 prescriptionToMedicalResFinal.add(prescriptionToMedical);
									 
								    }
							System.out.println(prescriptionToMedicalResFinal.toString());
							}
							catch (Exception e) {
								System.out.println(e.getMessage());
								
							}
						
							
						
							return prescriptionToMedicalResFinal;

						}
						
						
						
						@RequestMapping(value = { "/getPatientConsultingHistoryToDoctor" }, method = RequestMethod.POST)
						public @ResponseBody List getPatientConsultingHistoryToDoctor(@RequestParam("patientId") int patientId,@RequestParam("doctorId") int doctorId)
						
						{
							System.out.println("doctorId:"+doctorId);
							System.out.println("patientId:"+patientId);
							
						List<ConsultingDetails> consultingList =new ArrayList<ConsultingDetails>();
							Info info=new Info();
							try {
								
								
									
									consultingList=consultingDetailsRepository.getConsultingHistoryDetailsByDoctorAndPatientId(patientId,doctorId);
									System.out.println("Consulting List "+consultingList.toString());

								}
							catch (Exception e) {
								// TODO: handle exception
								System.out.println(e.getMessage());
								
							}
						
							return consultingList;
						}
						
						
}

package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.GetLabAppointment;
import com.bionische.biotech.model.GetLabForAppointment;
import com.bionische.biotech.model.GetPatientContactDetailsById;
import com.bionische.biotech.model.GetSuggestLabTestFromDoctor;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabNotification;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.PatientDetails;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.model.SuggestLabTestFromDoctor;
import com.bionische.biotech.model.lab.GetPatientReports;
import com.bionische.biotech.model.lab.LabAppointmentDetails;
import com.bionische.biotech.model.lab.PatientReportsDetails;
import com.bionische.biotech.model.lab.TestsInLab;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.GetLabAppointmentRrepository;
import com.bionische.biotech.repository.GetLabForAppointmentRepository;
import com.bionische.biotech.repository.GetPatientContactDetailsByIdRepository;
import com.bionische.biotech.repository.GetSuggestLabTestFromDoctorRepository;
import com.bionische.biotech.repository.LabNotificationRepository;
import com.bionische.biotech.repository.LabTestsRepository;
import com.bionische.biotech.repository.PatientDetailsRepository;
import com.bionische.biotech.repository.PatientNotificationRepository;
import com.bionische.biotech.repository.SuggestLabTestFromDoctorRepository;
import com.bionische.biotech.repository.lab.GetPatientReportsRepository;
import com.bionische.biotech.repository.lab.LabAppointmentDetailsRepository;
import com.bionische.biotech.repository.lab.PatientReportsDetailsRepository;
import com.bionische.biotech.repository.lab.TestsInLabRepository;
import com.bionische.biotech.service.SendEMailService;
import com.bionische.biotech.service.SendFcmNotificationService;

@RestController
@RequestMapping(value = { "/lab"})
public class LabPatientApiConrtoller {

	public final Log LOGGER = LogFactory.getLog(LabPatientApiConrtoller.class);
	@Autowired
	LabAppointmentDetailsRepository labAppointmentDetailsRepository;
	@Autowired
	LabTestsRepository labTestsRepository;
	@Autowired
	TestsInLabRepository testsInLabRepository;
	@Autowired
	GetLabForAppointmentRepository getLabForAppointmentRepository;
	
	@Autowired
	LabNotificationRepository labNotificationRepository;
	@Autowired
	AppointmentTimeRepository appointmentTimeRepository;
	@Autowired
	SendEMailService sendEMailService;
	@Autowired
	GetPatientContactDetailsByIdRepository getPatientContactDetailsByIdRepository;
	@Autowired
	GetLabAppointmentRrepository getLabAppointmentRrepository;
	@Autowired
	PatientReportsDetailsRepository patientReportsDetailsRepository;
	@Autowired
	GetPatientReportsRepository getPatientReportsRepository;
	@Autowired
	SuggestLabTestFromDoctorRepository suggestLabTestFromDoctorRepository;
	@Autowired
	GetSuggestLabTestFromDoctorRepository getSuggestLabTestFromDoctorRepository;
	@Autowired
	SendFcmNotificationService sendFcmNotificationService;
	@Autowired
	PatientDetailsRepository patientDetailsRepository;
	@Autowired
	PatientNotificationRepository patientNotificationRepository;
	
	@RequestMapping(value = { "/insertTestsInLab" }, method = RequestMethod.POST)
	public @ResponseBody TestsInLab insertTestsInLab(@Valid @RequestBody TestsInLab testsInLab) {
	
		try {
			TestsInLab testsInLabRes=testsInLabRepository.findByLabIdAndTestId(testsInLab.getLabId(), testsInLab.getTestId());
			if(testsInLabRes!=null)
				testsInLab.setId(testsInLabRes.getId());
			 
		return testsInLabRepository.save(testsInLab);
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = { "/getTestsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<LabTests> getTestsByLabId( @RequestParam("labId")int labId) {
	
		try {
			List<LabTests> labTestsList=labTestsRepository.getLabTestsByLabId(labId);
			 
			 
		return labTestsList;
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = { "/deleteTestsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteTestsByLabId( @RequestParam("labId")int labId,  @RequestParam("testId")int testId) {
	
		Info info=new Info();
		try {
			int res=testsInLabRepository.updateDelStatus(labId,testId, 1);
			 
			 
			 if(res>0)
			  {
				  info.setError(false);
				  info.setMessage(" Status Update Successfully");
			  }
			  else {
				  info.setError(true);
				  info.setMessage("Failed to Update  Status !!");
			  }
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return info;
	}
	
	
	
	@RequestMapping(value = { "/insertLabAppointment" }, method = RequestMethod.POST)
	public @ResponseBody LabAppointmentDetails insertLabAppointment(@Valid @RequestBody LabAppointmentDetails labAppointmentDetails) {
	
		try {
		LabAppointmentDetails labAppointmentDetailsRes=labAppointmentDetailsRepository.save(labAppointmentDetails);
		
		if(labAppointmentDetailsRes!=null) {
		GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(labAppointmentDetailsRes.getPatientId());
		sendEMailService.sendMail("Your Lab Appointment has been Successfully booked", "Your Lab Appointment has been Successfully booked", getPatientContactDetailsById.getEmail());
		LabNotification labNotification=new LabNotification();
		AppointmentTime appointmentTime=appointmentTimeRepository.findByTimeId(labAppointmentDetailsRes.getTimeId());
		
		//LabTests labTests=labTestsRepository.getTestDetailsByTestId(labAppointmentDetailsRes.getLabTestId());
		
		labNotification.setLabId(labAppointmentDetailsRes.getLabId());
		labNotification.setNotification(getPatientContactDetailsById.getfName()+" "+getPatientContactDetailsById.getlName()+" has booked appointment on DATE "+labAppointmentDetailsRes.getLabAppDate()+" and TIME "+appointmentTime.getTime());					
		labNotification.setStatus(0);
		labNotification.setString1("Appointment Booked");
		labNotification.setInt1(labAppointmentDetailsRes.getPatientId());
		labNotificationRepository.save(labNotification);
		}
		return labAppointmentDetailsRes;
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = { "/updateLabAppointmentStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateLabAppointmentStatus(@RequestParam("labAppId")int labAppId, @RequestParam("status")int status) {
		Info info=new Info();
		try {
			
			 info.setError(true);
		  int res=labAppointmentDetailsRepository.updateLabAppointmentStatus(labAppId, status);
		  GetLabAppointment getLabAppointment = getLabAppointmentRrepository.getLabAppointmentDetails(labAppId);
		  
		  if(res>0)
		  {
			  info.setError(false);
			  info.setMessage("Appointment Status Update Successfully");
			  
			  PatientNotification patientNotification = new PatientNotification();
				GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsByLabAppointId(labAppId);
				 
				sendEMailService.sendMail("Your Appointment Is edited!!", "Your Appointment edited!!" , getPatientContactDetailsById.getEmail());
				PatientDetails patientDetails=patientDetailsRepository.findByPatientId(getPatientContactDetailsById.getPatientId());
				patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
				 
				if(status==1)
				patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been confirmed for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime());					
				else if(status==2)
				patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been Cancel");					
				else if(status==3)
					patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been Reject By Lab");
				
				else if(status==5)
					patientNotification.setNotification("Your Reports has been uploaded by "+getLabAppointment.getLabName()+". Please find your report on profile. Note: To view your reports please do payment if pending. Thank you !! ");
				
				patientNotification.setStatus(0);
				
				patientNotification.setString1("Appointment Confirmed");
				
				patientNotification.setString2("lab");
				patientNotification.setInt1(getLabAppointment.getLabId());
				patientNotificationRepository.save(patientNotification);
				String confirmAppointmentNotification="";
				if(status==1)
				  confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been confirmed for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==2)
					  confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been Canceled for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==3)
					confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been Reject By Lab for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==5)
					confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" Your Reports has been uploaded by "+getLabAppointment.getLabName()+"Please find your report on profile. Note: To view your reports please do payment if pending. Thank you !!";
				
				System.out.println("token="+patientDetails.getString2());
				try {
				if(patientDetails.getInt1()==0) {
				
				sendFcmNotificationService.notifyUser(patientDetails.getString2(), "BIONISCHE", confirmAppointmentNotification, DateConverter.currentDateAndTime(),12);
				}else if(patientDetails.getInt1()==1) {
					
					sendFcmNotificationService.notifyiOSUser(patientDetails.getString2(), "BIONISCHE", confirmAppointmentNotification, DateConverter.currentDateAndTime(),12);	
				}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());// TODO: handle exception
				}
				
				
		  }
		  else {
			  info.setError(true);
			  info.setMessage("Failed to Update Appointment Status !!");
		  }
	 
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
			  info.setError(true);
			  info.setMessage("Failed to Update Appointment Status !!");
		}
		return info;
	}
	
	
	@RequestMapping(value = { "/collectSampleWithPaymentDetails" }, method = RequestMethod.POST)
	public @ResponseBody Info collectSampleWithPaymentDetails(@RequestParam("labAppId")int labAppId, @RequestParam("status")int status, @RequestParam("totalAmount")float totalAmount,@RequestParam("paidAmount")float paidAmount, @RequestParam("discount")float discount,  @RequestParam("amount")float amount,
			@RequestParam("amountType")int amountType, @RequestParam("paymentStatus")int paymentStatus) {
		Info info=new Info();
		try {
			
			 info.setError(true);
		  int res=labAppointmentDetailsRepository.collectSampleWithPaymentDetails(labAppId, status,totalAmount,  paidAmount, discount, amount, amountType, paymentStatus);
		  GetLabAppointment getLabAppointment = getLabAppointmentRrepository.getLabAppointmentDetails(labAppId);
		  if(res>0)
		  {
			  info.setError(false);
			  info.setMessage("Appointment Status Update Successfully");
			  
			  PatientNotification patientNotification = new PatientNotification();
				GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsByLabAppointId(labAppId);
				 
				sendEMailService.sendMail("Your Appointment Is edited!!", "Your Appointment edited!!" , getPatientContactDetailsById.getEmail());
				PatientDetails patientDetails=patientDetailsRepository.findByPatientId(getPatientContactDetailsById.getPatientId());
				patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
				 
				if(status==1)
				patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been confirmed for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime());					
				else if(status==2)
				patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been Cancel");					
				else if(status==3)
					patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been Reject By Lab");
				
				else if(status==5)
					patientNotification.setNotification("Your Reports has been uploaded by "+getLabAppointment.getLabName()+". Please find your report on profile. Note: To view your reports please do payment if pending. Thank you !! ");
				
				patientNotification.setStatus(0);
				
				patientNotification.setString1("Appointment Confirmed");
				
				patientNotification.setString2("lab");
				patientNotification.setInt1(getLabAppointment.getLabId());
				patientNotificationRepository.save(patientNotification);
				String confirmAppointmentNotification="";
				if(status==1)
				  confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been confirmed for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==2)
					  confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been Canceled for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==3)
					confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been Reject By Lab for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==5)
					confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" Your Reports has been uploaded by "+getLabAppointment.getLabName()+"Please find your report on profile. Note: To view your reports please do payment if pending. Thank you !!";
				
				System.out.println("token="+patientDetails.getString2());
				try {
				if(patientDetails.getInt1()==0) {
				
				sendFcmNotificationService.notifyUser(patientDetails.getString2(), "BIONISCHE", confirmAppointmentNotification, DateConverter.currentDateAndTime(),12);
				}else if(patientDetails.getInt1()==1) {
					
					sendFcmNotificationService.notifyiOSUser(patientDetails.getString2(), "BIONISCHE", confirmAppointmentNotification, DateConverter.currentDateAndTime(),12);	
				}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());// TODO: handle exception
				}
				
		  }
		  else {
			  info.setError(true);
			  info.setMessage("Failed to Update Appointment Status !!");
		  }
	 
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
			  info.setError(true);
			  info.setMessage("Failed to Update Appointment Status !!");
		}
		return info;
	}
	
	@RequestMapping(value = { "/editLabAppointmentByLab" }, method = RequestMethod.POST)
	public @ResponseBody Info editLabAppointmentByLab(@RequestParam("appId")int appId, @RequestParam("status")int status, @RequestParam("timeId")int timeId,  @RequestParam("date")String date) {
		Info info=new Info();
		try {
			
			 info.setError(true);
		  int res=labAppointmentDetailsRepository.editLabAppointmentByLab(appId, status, date, timeId);
		  GetLabAppointment getLabAppointment = getLabAppointmentRrepository.getLabAppointmentDetails(appId);
		  if(res>0)
		  {
			  info.setError(false);
			  info.setMessage("Appointment Status Update Successfully");
			  
			  PatientNotification patientNotification = new PatientNotification();
				GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsByLabAppointId(appId);
				 
				sendEMailService.sendMail("Your Appointment Is edited!!", "Your Appointment edited!!" , getPatientContactDetailsById.getEmail());
				PatientDetails patientDetails=patientDetailsRepository.findByPatientId(getPatientContactDetailsById.getPatientId());
				patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
				 
				if(status==1)
				patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been confirmed for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime());					
				else if(status==2)
				patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been Cancel");					
				else if(status==3)
					patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been Reject By Lab");
				
				else if(status==5)
					patientNotification.setNotification("Your Reports has been uploaded by "+getLabAppointment.getLabName()+". Please find your report on profile. Note: To view your reports please do payment if pending. Thank you !! ");
				
				patientNotification.setStatus(0);
				
				patientNotification.setString1("Appointment Confirmed");
				
				patientNotification.setString2("lab");
				patientNotification.setInt1(getLabAppointment.getLabId());
				patientNotificationRepository.save(patientNotification);
				String confirmAppointmentNotification="";
				if(status==1)
				  confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been confirmed for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==2)
					  confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been Canceled for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==3)
					confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" your appointment of "+getLabAppointment.getLabName()+" lab has been Reject By Lab for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime();
				else if(status==5)
					confirmAppointmentNotification="Hello, "+patientDetails.getfName()+" "+patientDetails.getlName()+" Your Reports has been uploaded by "+getLabAppointment.getLabName()+"Please find your report on profile. Note: To view your reports please do payment if pending. Thank you !!";
				
				System.out.println("token="+patientDetails.getString2());
				try {
				if(patientDetails.getInt1()==0) {
				
				sendFcmNotificationService.notifyUser(patientDetails.getString2(), "BIONISCHE", confirmAppointmentNotification, DateConverter.currentDateAndTime(),12);
				}else if(patientDetails.getInt1()==1) {
					
					sendFcmNotificationService.notifyiOSUser(patientDetails.getString2(), "BIONISCHE", confirmAppointmentNotification, DateConverter.currentDateAndTime(),12);	
				}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());// TODO: handle exception
				}
				
		  }
		  else {
			  info.setError(true);
			  info.setMessage("Failed to Update Appointment Status !!");
		  }
	 
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
			  info.setError(true);
			  info.setMessage("Failed to Update Appointment Status !!");
		}
		return info;
	}
	
	
	
	@RequestMapping(value = { "/getLabsByCityIdAndTestId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabForAppointment> getLabsByCityIdAndTestId(@RequestParam("cityId") int cityId, @RequestParam("testIdList") String  testIdList) {
		System.out.println("cccity "+cityId);
		// for(String ii:testIdList)
			 System.out.println(testIdList);
			 List<String> list = new ArrayList<String>(Arrays.asList(testIdList.split(",")));
		//System.out.println("testIdList "+testIdList.toString());
		try {
			//String testIds="%"+testId+"%";
			List<GetLabForAppointment> labDetailsListRes=getLabForAppointmentRepository.getLabForAppointmentByTestList(cityId,list);
			System.out.println("labDetailsListRes "+labDetailsListRes.toString());
			 
		 
			 return labDetailsListRes;
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = { "/getLabAppmtDetailsByPatientIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabAppointment> getLabAppmtDetailsByPatientIdAndDate(@RequestParam("patientId") int patientId, @RequestParam("fromDate") String  fromDate, @RequestParam("toDate") String  toDate) {
	 
		try {
		 
			List<GetLabAppointment> getLabAppointmentRes=getLabAppointmentRrepository.getLabAppmtDetailsByPatientIdAndDate(patientId,fromDate, toDate);
			System.out.println("labDetailsListRes "+getLabAppointmentRes.toString());
			 
		 
			 return getLabAppointmentRes;
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/getLabAppointmentByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabAppointment> getLabAppointmentByLabId(@RequestParam("labId") int labId, @RequestParam("fromDate") String  fromDate, @RequestParam("toDate") String  toDate) {
	 
		try {
		 
			List<GetLabAppointment> getLabAppointmentRes=getLabAppointmentRrepository.getLabAppmtDetailsByLabIdAndDate(labId,fromDate, toDate);
			System.out.println("labDetailsListRes "+getLabAppointmentRes.toString());
			 
		 
			 return getLabAppointmentRes;
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = { "/getLabAppointmentByLabAndPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabAppointment> getLabAppointmentByLabAndPatientId(@RequestParam("patientId") int patientId,@RequestParam("labId") int labId) {
	 
		try {
		 
			List<GetLabAppointment> getLabAppointmentRes=getLabAppointmentRrepository.getLabAppointmentByLabAndPatientId(patientId,labId);
			System.out.println("labDetailsListRes "+getLabAppointmentRes.toString());
			 
		 
			 return getLabAppointmentRes;
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = { "/getLabAppointmentByAppointmentId" }, method = RequestMethod.POST)
	public @ResponseBody GetLabAppointment getLabAppointmentByAppointmentId(@RequestParam("appointmentId") int appointmentId) {
	 
		try {
		 
			GetLabAppointment getLabAppointment=getLabAppointmentRrepository.getLabAppointmentByAppointmentId(appointmentId);
			System.out.println("labDetailsListRes "+getLabAppointment.toString());
			 
		 
			 return getLabAppointment;
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = { "/getLabTestByAppointmentId" }, method = RequestMethod.POST)
	  public @ResponseBody List<LabTests> getLabTestByAppointmentId( @RequestParam("appointmentId")int appointmentId) {
		
		try {
			List<LabTests> labTestsList=labTestsRepository.getLabTestsByAppointmentId(appointmentId);
			 
			 
		return labTestsList;
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	 
	
	@RequestMapping(value = { "/insertPatientReports" }, method = RequestMethod.POST)
	public @ResponseBody PatientReportsDetails insertPatientReports(@RequestBody PatientReportsDetails patientReportsDetails) {
	 
		try {
		 
			PatientReportsDetails patientReportsDetailsRes=patientReportsDetailsRepository.save(patientReportsDetails);
			System.out.println("patientReportsDetailsRes "+patientReportsDetailsRes.toString());
			 
		 
			 return patientReportsDetailsRes;
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping(value = { "/getPatientReportsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPatientReports> getPatientReportsByLabId(@RequestParam("labId")int labId, @RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate) {
	 
		try {
		return getPatientReportsRepository.getReportsByLabIdAndDate(labId, fromDate, toDate);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = { "/getPatientReportsByPatientId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPatientReports> getPatientReportsByPatientId(@RequestParam("patientId")int patientId, @RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate) {
	 
		try {
		return getPatientReportsRepository.getReportsByPatientIdAndDate(patientId, fromDate, toDate);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	@RequestMapping(value = { "/getLabAppointmentDetailsByAppointmentId" }, method = RequestMethod.POST)
	public @ResponseBody LabAppointmentDetails getLabAppointmentDetailsByAppointmentId( @RequestParam("appointmentId")int appointmentId) {
	
		try {
		return labAppointmentDetailsRepository.findByLabAppId(appointmentId);
		 
	 
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = { "/updateLabReportsPayment" }, method = RequestMethod.POST)
	public @ResponseBody Info updateLabReportsPayment(@RequestParam("appointmentId") int appointmentId,@RequestParam("txnStatus") int txnStatus,@RequestParam("txnId") String txnId,@RequestParam("orderId") String orderId,@RequestParam("txnAmt") float txnAmt)
	{
 
		
		Info info =new Info();
		info.setError(true);
		try {

			int resTransaction=labAppointmentDetailsRepository.updateLabAppointmentPayment(appointmentId, txnStatus, txnId, orderId, txnAmt);
			
			int reportStatusRes=patientReportsDetailsRepository.updatePaymentStatusByAppointmentId(appointmentId, txnStatus);
			if(reportStatusRes>0 ) {
				
				info.setError(true);
				info.setMessage("Payment updated");
			}
			else {
				info.setError(true);
				info.setMessage("Payment updated Failed");
			}
			 
			}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Problem in Lab report Payment updated");
		}
		return info;
	}
	
	  
	
	@RequestMapping(value = { "/getPatientReportByPatientAndDocId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPatientReports> getPatientReportByPatientAndDocId(@RequestParam("patientId")int patientId, @RequestParam("doctorId")int doctorId) {
	 
		try {
		return getPatientReportsRepository.getReportsByPatientIdAndDoctorId(patientId, doctorId);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = { "/saveTestsSuggestionAndRefferal" }, method = RequestMethod.POST)
	public @ResponseBody SuggestLabTestFromDoctor saveTestsSuggestionAndRefferal(@RequestBody SuggestLabTestFromDoctor suggestLabTestFromDoctor) {
	 
		try {
		return suggestLabTestFromDoctorRepository.save(suggestLabTestFromDoctor);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	 
	
	@RequestMapping(value = { "/getSuggestLabTestFromDoctor" }, method = RequestMethod.POST)
	public @ResponseBody GetSuggestLabTestFromDoctor getSuggestLabTestFromDoctor(@RequestParam("meetId")int meetId) {
	 
		try {
			return getSuggestLabTestFromDoctorRepository.getSuggestLabTestFromDoctor(meetId);
			
		}
	catch (Exception e) {
		
		// TODO: handle exception
	}
		return null;
	}
}

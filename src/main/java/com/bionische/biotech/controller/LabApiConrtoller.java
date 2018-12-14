package com.bionische.biotech.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.Common.DateConverter;
import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.AppointmentTimeList;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorNotification;
import com.bionische.biotech.model.GetDoctorRatingReviewCount;
import com.bionische.biotech.model.GetLabAppointment;
import com.bionische.biotech.model.GetLabForAppointment;
import com.bionische.biotech.model.GetLabRatingReview;
import com.bionische.biotech.model.GetPatientBornReport;
import com.bionische.biotech.model.GetPatientContactDetailsById;
import com.bionische.biotech.model.GetPatientLabReportAndBornReports;
import com.bionische.biotech.model.GetPatientReports;
import com.bionische.biotech.model.GetPatientUploadedReport;
import com.bionische.biotech.model.GetRatingCount;
import com.bionische.biotech.model.GetReportDetailsForLab;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabAppointment;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.LabNotification;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.LabTestsList;
import com.bionische.biotech.model.PateintReportPaymentDetails;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.model.ReportDetails;
import com.bionische.biotech.model.SharingReportWithDoc;
import com.bionische.biotech.model.TransactionDetails;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.BabyBornReportsRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.GetLabAppointmentRrepository;
import com.bionische.biotech.repository.GetLabForAppointmentRepository;
import com.bionische.biotech.repository.GetLabRatingReviewRepository;
import com.bionische.biotech.repository.GetPatientBornReportRepository;
import com.bionische.biotech.repository.GetPatientContactDetailsByIdRepository;
import com.bionische.biotech.repository.GetPatientReportsRepository;
import com.bionische.biotech.repository.GetPatientUploadedReportsRepository;
import com.bionische.biotech.repository.GetRatingCountRepository;
import com.bionische.biotech.repository.GetReportDetailsForLabRepository;
import com.bionische.biotech.repository.LabAppointmentRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.LabNotificationRepository;
import com.bionische.biotech.repository.LabTestsRepository;
import com.bionische.biotech.repository.PateintReportPaymentDetailsRepository;
import com.bionische.biotech.repository.PatientNotificationRepository;
import com.bionische.biotech.repository.ReportDetailsRepository;
import com.bionische.biotech.repository.SharingReportWithDocRepository;
import com.bionische.biotech.repository.TransactionDetailsRepository;
import com.bionische.biotech.service.CreateDirectoryService;
import com.bionische.biotech.service.SendEMailService;

@RestController
public class LabApiConrtoller {

	@Autowired
	LabDetailsRepository labDetailsRepository;
	
	@Autowired
	LabTestsRepository labTestsRepository;
	
	@Autowired
	LabAppointmentRepository labAppointmentRepository;
	
	@Autowired
	AppointmentTimeRepository appointmentTimeRepository;
	 
	@Autowired
	GetLabForAppointmentRepository getLabForAppointmentRepository;
	
	@Autowired
	GetLabRatingReviewRepository getLabRatingReviewRepository;
	
	@Autowired
	DoctorDetailsRepository doctorDetailsRepository;
	
	@Autowired
	GetReportDetailsForLabRepository getReportDetailsForLabRepository;
	
	@Autowired
	GetRatingCountRepository getRatingCountRepository;
	
	@Autowired
	LabNotificationRepository labNotificationRepository;
	
	@Autowired
	SendEMailService sendEMailService;
	
	@Autowired
	GetPatientContactDetailsByIdRepository getPatientContactDetailsByIdRepository;
	
	@Autowired
	PatientNotificationRepository patientNotificationRepository;
	
	@Autowired
	GetLabAppointmentRrepository getLabAppointmentRrepository;
	
	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;

	@Autowired
	PateintReportPaymentDetailsRepository pateintReportPaymentDetailsRepository;

@Autowired
LabTestsRepository labTypesRepository;

@Autowired
ReportDetailsRepository reportDetailsRepository;



@Autowired
GetPatientReportsRepository getPatientReportsRepository;

@Autowired
BabyBornReportsRepository babyBornReportsRepository;


@Autowired
GetPatientBornReportRepository getPatientBornReportRepository;

@Autowired
SharingReportWithDocRepository sharingReportWithDocRepository;

@Autowired
GetPatientUploadedReportsRepository getPatientUploadedReportsRepository;



@Autowired
CreateDirectoryService createDirectoryService;


	
	@RequestMapping(value = { "/getAllLabTests" }, method = RequestMethod.GET)
	public @ResponseBody LabTestsList getAllLabTests()
	{
	 
		LabTestsList labTestsList=new LabTestsList();
		List<LabTests> labTestsListRes =new ArrayList<LabTests>();
		Info info=new Info();
	 
		
		try {
			
			labTestsListRes=labTestsRepository.findByDelStatus(0);
			System.out.println("Test List "+labTestsListRes.toString());
			
			if(labTestsListRes!=null)
			{
				labTestsList.setLabTestsList(labTestsListRes);
				info.setError(false);
				info.setMessage("Success");
				labTestsList.setInfo(info);
			}
			else {
				info.setError(true);
				info.setMessage("Failed");
				labTestsList.setInfo(info);
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed");
			labTestsList.setInfo(info);
		}		
		return labTestsList;
	}
	
	@RequestMapping(value = { "/getLabsByCityId" }, method = RequestMethod.POST)
	public @ResponseBody List<LabDetails> getLabsByCityId(@RequestParam("cityId") int cityId) {
		System.out.println("cccity "+cityId);
		List<LabDetails> labDetailsList=new ArrayList<>();
		try {
			labDetailsList=labDetailsRepository.getByCityIdAndDelStatus(cityId);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return labDetailsList;
	}
	
	@RequestMapping(value = { "/getLabsByCityIdAndTestId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetLabForAppointment> getLabsByCityIdAndTestId(@RequestParam("cityId") int cityId, @RequestParam("testId") int testId) {
		System.out.println("cccity "+cityId);
		System.out.println("testIds "+testId);
		List<GetLabForAppointment> labDetailsList=new ArrayList<>();
		try {
			String testIds="%"+testId+"%";
			List<GetLabForAppointment> labDetailsListRes=getLabForAppointmentRepository.getLabForAppointment(cityId,testIds);
			System.out.println("labDetailsListRes "+labDetailsListRes.toString());
			List<String> testIdList=new ArrayList<String>();
			for(int i=0;i<labDetailsListRes.size();i++)
			{
				testIdList=new ArrayList<String>();
				testIdList= Arrays.asList(labDetailsListRes.get(i).getTeststypes().split(","));
				System.out.println("IN FORE "+testIdList);
				if(testIdList.contains(String.valueOf(testId)))
				{
					labDetailsList.add(labDetailsListRes.get(i));
					System.out.println(i);
				}
			}
			System.out.println("labDetailsList  "+labDetailsList.toString());
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return labDetailsList;
	}
	
	//Ganesh
			//Lab Rating Review
			@RequestMapping(value = { "/getLabReviewByLabId"}, method = RequestMethod.POST)
			public @ResponseBody List<GetLabRatingReview> getLabReviewByLabId(@RequestParam("labId") int labId) {
				System.out.println("labId "+labId);
				
			 
				List<GetLabRatingReview> getLabRatingReviewList=new ArrayList<GetLabRatingReview>();
				try {
					getLabRatingReviewList=getLabRatingReviewRepository.findByLabIdAndDelStatus(labId,0); 
					 
					 
				}
				catch (Exception e) {
				e.printStackTrace();
				}
		        return getLabRatingReviewList;
			}
			
			//amruta Lab Rating 
			@RequestMapping(value = { "/getLabRatingByLabId"}, method = RequestMethod.POST)
			public @ResponseBody GetRatingCount getLabRatingByLabId(@RequestParam("labId") int labId) {
				
				GetRatingCount getRatingCount= new GetRatingCount();
				try {
					getRatingCount=getRatingCountRepository.getLabRating(labId);
					System.out.println("getRatingCount:"+getRatingCount.toString());
				}
				catch (Exception e) {
				e.printStackTrace();
				}
		        return getRatingCount;
			}
	
	//Ganesh
		//Lab Rating Review
		@RequestMapping(value = { "/getLabReviewByLabIdForLab"}, method = RequestMethod.POST)
		public @ResponseBody GetDoctorRatingReviewCount getLabReviewByLabIdForLab(@RequestParam("labId") int labId) {
			System.out.println("labId "+labId);
			
			GetDoctorRatingReviewCount getDoctorRatingReviewCount=new GetDoctorRatingReviewCount();
			//List<GetLabRatingReview> getLabRatingReviewList=new ArrayList<GetLabRatingReview>();
			try {
				
				
				
				List<GetLabRatingReview> getLabRatingReviewList=getLabRatingReviewRepository.findByLabIdAndDelStatus(labId,0); 
				List<GetRatingCount> getRatingCountList =getRatingCountRepository.getLabRatingCount(labId);
				System.out.println("Lab Rating"+getRatingCountList.toString());
				int one=0;
				int two=0;
				int three=0;
				int four=0;
				int five=0;
				int sumOfRating=0;
				
				for(GetRatingCount list:getRatingCountList)
				{
					sumOfRating+=list.getCount();
				}
				for(GetRatingCount list:getRatingCountList)
				{
					if(list.getRating()==1)
					{
						one=list.getCount()*100/sumOfRating;
					}
					if(list.getRating()==2)
					{
						two=list.getCount()*100/sumOfRating;
					}
					if(list.getRating()==3)
					{
						three=list.getCount()*100/sumOfRating;
					}
					if(list.getRating()==4)
					{
						four=list.getCount()*100/sumOfRating;
					}
					if(list.getRating()==5)
					{
						five=list.getCount()*100/sumOfRating;
					}				
					
				}
				
				getDoctorRatingReviewCount.setOneStar(one);
				getDoctorRatingReviewCount.setTwoStar(two);
				getDoctorRatingReviewCount.setThreeStar(three);
				getDoctorRatingReviewCount.setFourStar(four);
				getDoctorRatingReviewCount.setFivaeStar(five);
				getDoctorRatingReviewCount.setLabRatingDetails(getLabRatingReviewList);
			}
			catch (Exception e) {
			e.printStackTrace();
			}
	        return getDoctorRatingReviewCount;
		}

	@RequestMapping(value = { "/getLabAppointmentTime" }, method = RequestMethod.POST)
	public @ResponseBody AppointmentTimeList getLabAppointmentTime(@RequestParam("labId") int labId, @RequestParam("date") String date, @RequestParam("fromTime") int fromTime, @RequestParam("toTime") int toTime) 
		{
		AppointmentTimeList appointmentTimeList=new AppointmentTimeList();
		
		List<AppointmentTime> appointmentTime=new ArrayList<>();
		List<AppointmentTime> allAppointmentTime=new ArrayList<>();
		
		try {
		
			System.out.println("details:"+labId+" "+date+" "+fromTime+" "+toTime);
		appointmentTime=appointmentTimeRepository.getLabAppointMent(fromTime,toTime);
		
		System.out.println("appointmentTime:"+appointmentTime.toString());
		appointmentTimeList.setAppointmentTimeList(appointmentTime);
		allAppointmentTime=	appointmentTimeRepository.getDoctorAppointMentTime(fromTime,toTime);
		appointmentTimeList.setAllAppointmentTimeList(allAppointmentTime);
		
		System.out.println("all:"+appointmentTimeList.getAllAppointmentTimeList().toString());
		System.out.println("booked:"+appointmentTimeList.getAppointmentTimeList().toString());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return appointmentTimeList;
		}
	
	
	@RequestMapping(value = { "/getTestsByLabId" }, method = RequestMethod.POST)
	public @ResponseBody List<LabTests> getTestsByLabId(@RequestParam("labId") int labId)
	{
		LabDetails LabDetails=new LabDetails();
		List<String> testIdList=new ArrayList<>();
		try {
			
			LabDetails=labDetailsRepository.findByLabIdAndDelStatus(labId, 0);
		
			testIdList = Arrays.asList(LabDetails.getTeststypes().split(","));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<LabTests> labTestsList=new ArrayList<>();
		
		try {
			
			labTestsList=labTestsRepository.getTestDetails(testIdList);
			System.out.println("Test List "+labTestsList.toString());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		
		
		return labTestsList;
	}
	
	@RequestMapping(value = { "/labAppointmentsByTest" }, method = RequestMethod.POST)
	public @ResponseBody List<LabAppointment> labAppointmentsByTest(@RequestParam("labId") int labId,@RequestParam("labTestId") int labTestId)
	{
		
		List<LabAppointment> appointmentList=new ArrayList<LabAppointment>();
		try {
			
			appointmentList=labAppointmentRepository.appointmentDetailsOfLab(labId,labTestId);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
			
		return appointmentList;
	}
	
	@RequestMapping(value = { "/insertLabAppointment" }, method = RequestMethod.POST)
	public @ResponseBody Info insertLabAppointment(@RequestBody LabAppointment  labAppointment)
	{
		Info info=new Info();
		try {
		LabAppointment labAppointmentRes=labAppointmentRepository.save(labAppointment);
	
		if(labAppointmentRes!=null)
		{
			GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(labAppointmentRes.getPatientId());
			sendEMailService.sendMail("Your Lab Appointment has been Successfully booked", "Your Lab Appointment has been Successfully booked", getPatientContactDetailsById.getEmail());
			LabNotification labNotification=new LabNotification();
			AppointmentTime appointmentTime=appointmentTimeRepository.findByTimeId(labAppointmentRes.getTimeId());
			
			LabTests labTests=labTestsRepository.getTestDetailsByTestId(labAppointmentRes.getLabTestId());
			
			labNotification.setLabId(labAppointmentRes.getLabId());
			labNotification.setNotification(getPatientContactDetailsById.getfName()+" "+getPatientContactDetailsById.getlName()+" has booked appointment for "+labTests.getLabTestName()+" on DATE "+labAppointmentRes.getLabAppDate()+" and TIME "+appointmentTime.getTime());					
			labNotification.setStatus(0);
			labNotification.setString1("Appointment Booked");
			labNotification.setInt1(labAppointmentRes.getPatientId());
			labNotificationRepository.save(labNotification);
			info.setError(false);
			info.setMessage("Appointment Book Successfully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem to Book Appointment!!");
		}
}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Problem in server to Book Appointment");
		}
	
		return info;
	}
	
	/*edit lab appointment by lab*/
	@RequestMapping(value = { "/editLabAppointmentByLab" }, method = RequestMethod.POST)
	public @ResponseBody Info editLabAppointmentByLab(@RequestParam("appId") int appId,@RequestParam("date") String date,@RequestParam("time") int time)
	{System.out.println("caaaaaaaame"+date);
		Info info=new Info();
	    int infoo=labAppointmentRepository.editLabAppointmentByLab(appId,date,time);
	    GetLabAppointment getLabAppointment = getLabAppointmentRrepository.getLabAppointmentDetails(appId);
	    
		if(infoo!=0)
		{
			PatientNotification patientNotification = new PatientNotification();
			GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsByLabAppointId(appId);
			 
			sendEMailService.sendMail("Your Appointment Is edited!!", "Your Appointment edited!!" , getPatientContactDetailsById.getEmail());
		
			patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
			patientNotification.setNotification("Your Appointment of "+getLabAppointment.getLabName()+"lab has been confirmed for "+getLabAppointment.getLabTestName()+" on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime());					
			patientNotification.setStatus(0);
			patientNotification.setString1("Appointment Confirmed");
			patientNotification.setString2("lab");
			patientNotification.setInt1(getLabAppointment.getLabId());
			patientNotificationRepository.save(patientNotification);
			info.setError(false);
			info.setMessage("Appointment edited Successfully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem to edit Appointment!!");
		}
		return info;
	}
	
	/*cancel lab appointment by lab*/
	@RequestMapping(value = { "/cancelLabAppointmentByLab" }, method = RequestMethod.POST)
	public @ResponseBody Info cancelLabAppointmentByLab(@RequestParam("appId") int appId, @RequestParam("status") int status)
	{System.out.println("caaaaaaaame"+appId);
		Info info=new Info();
	    int infoo=labAppointmentRepository.cancelLabAppointmentByLab(appId, status);
	    GetLabAppointment getLabAppointment = getLabAppointmentRrepository.getLabAppointmentDetails(appId);
	
		if(infoo!=0)
		{
			PatientNotification patientNotification = new PatientNotification();
			GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsByLabAppointId(appId);
			 
			sendEMailService.sendMail("Your Appointment Is Canceled!!", "Your Appointment Canceled!!" , getPatientContactDetailsById.getEmail());
		
			patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
			patientNotification.setNotification(getLabAppointment.getLabName()+" has cancelled appointment of "+getLabAppointment.getLabTestName()+" which was on DATE "+getLabAppointment.getDate()+" and TIME "+getLabAppointment.getTime());					
			patientNotification.setStatus(0);
			patientNotification.setString1("Appointment Cancelled");
			patientNotification.setString2("lab");
			patientNotification.setInt1(getLabAppointment.getLabId());
			patientNotificationRepository.save(patientNotification);
			info.setError(false);
			info.setMessage("Appointment canceled Successfully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem to cancel Appointment!!");
		}
		return info;
	}
	@RequestMapping(value = { "/getAllTime" }, method = RequestMethod.GET)
	public @ResponseBody List<LabDetails> getAllTime() {
	
		List<LabDetails> labDetailsList=new ArrayList<>();
		try {
			labDetailsList=labDetailsRepository.findByDelStatus(0);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return labDetailsList;
	}
	
	@RequestMapping(value = { "/getDoctosForLabAppointment" }, method = RequestMethod.POST)
	public @ResponseBody List<DoctorDetails> getDoctosForLabAppointment(@RequestParam ("patientId") int patientId)
	{
	
		
		List<DoctorDetails> doctorDetails=doctorDetailsRepository.getDoctorDetailsByPatientId(patientId);
	System.out.println("Doctor List "+doctorDetails.toString());
		return doctorDetails;
	}
	
	
	//Update LabAppointmentStatus
	//Ganesh
@RequestMapping(value = { "/updateLabAppointmentStatus"}, method = RequestMethod.POST)
public @ResponseBody Info updateLabAppointmentStatus(@RequestParam("appointId") int appointId) {
System.out.println("appointId "+appointId);

 
Info info=new Info();
try {
int res=labAppointmentRepository.updateLabAppointmentStatus(appointId);
		
		if(res>0)
		{
			GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsByLabAppointId(appointId);
			 
			sendEMailService.sendMail("Your Appointment Is edited!!", "Your Appointment edited!!" , getPatientContactDetailsById.getEmail());
		
			info.setError(false);
			info.setMessage("success");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to update");
		}
	 
	 
}
catch (Exception e) {
e.printStackTrace();
}
return info;
}

@RequestMapping(value = { "/getReportDetailsForLab" }, method = RequestMethod.POST)
public @ResponseBody List<GetReportDetailsForLab> getReportDetailsForLab(@RequestParam("labId") int labId,@RequestParam("testId") int testId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
{
	List<GetReportDetailsForLab> getReportDetailsForLabList=new ArrayList<GetReportDetailsForLab>();
	try {
		
		getReportDetailsForLabList=getReportDetailsForLabRepository.getReportDetailsForLab(labId,testId,fromDate,toDate);
	
				
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	return getReportDetailsForLabList;
}

@RequestMapping(value = { "/getLabDetailsByUsrname" }, method = RequestMethod.POST)
public @ResponseBody LabDetails getLabDetailsByUsrname(@RequestParam("userName") String uName)

{
	LabDetails labDetailsRes=new LabDetails();
	Info info=new Info();
 try {
	 labDetailsRes=	labDetailsRepository.findByUserNameAndDelStatus(uName,0);
	
	
 }
 catch (Exception e) {
System.out.println(e.getMessage());
}
 return labDetailsRes;
 
}

@RequestMapping(value = { "/addTestsToLab" }, method = RequestMethod.POST)
public @ResponseBody Info addTestsToLab(@RequestParam("labId") int labId,@RequestParam("testId") String testId)

{

	Info info=new Info();
 try {
	 testId=","+testId;	
	 int res=	labDetailsRepository.updateLabTest(testId,labId);
	 
	 if(res>0)
		{
			info.setError(false);
			info.setMessage("success");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to update");
		}
	 
	
	
 }
 catch (Exception e) {
System.out.println(e.getMessage());
}
 return info;
 
}

@RequestMapping(value = { "/deleteTestOfLab" }, method = RequestMethod.POST)
public @ResponseBody Info deleteTestOfLab(@RequestParam("labId") int labId,@RequestParam("testId") String testId)

{
	LabDetails labDetails=new LabDetails();
	Info info=new Info();
 try {
	 List<String> testIdList=new ArrayList<>();
		
			
	 labDetails=labDetailsRepository.findByLabIdAndDelStatus(labId, 0);
	 
     String tests = labDetails.getTeststypes();
     
     tests = tests.replaceAll(testId, "");
     
	 System.out.println("delete:"+tests);
	 
	 if(tests.contains(",,"))
	 {
		 System.out.println("1");
	 tests = tests.replaceAll(",,",",");
	 System.out.println("removing:"+tests);
	 }
	 else if (tests.endsWith(",")) 
	 {
		 System.out.println("2");
	 tests = tests.replaceFirst(".$","");
	 System.out.println("removing:"+tests);
	 }
	 else
	 {
		 System.out.println("3");
	 tests =  tests.substring(1);
	 System.out.println("removing:"+tests);
	 }
	 
	 int res = labDetailsRepository.updateLabTestAfterDelete(tests,labId);
	 
	 if(res>0)
		{
			info.setError(false);
			info.setMessage("delete successfull");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to delete");
		}
	 
	
	
 }
 catch (Exception e) {
System.out.println(e.getMessage());
}
 return info;
 
}

@RequestMapping(value = { "/updateLabProfilePic" }, method = RequestMethod.POST)
public @ResponseBody Info updateLabProfilePic(@RequestParam("labId") int labId,@RequestParam("profilePhoto") String profilePhoto)

{
	
	Info info=new Info();
 try {
	 	 
	 int res = labDetailsRepository.updateLabProfilePic(labId,profilePhoto);
	 
	 if(res>0)
		{
			info.setError(false);
			info.setMessage("delete successfull");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to delete");
		}
	 	
 }
 catch (Exception e) {
System.out.println(e.getMessage());
}
 return info;
 
}

@RequestMapping(value = { "/getAllLabTestsOfPatient" }, method = RequestMethod.POST)
public @ResponseBody LabTestsList getAllLabTestsOfPatient(@RequestParam("patientId") int patientId)
{
 
	LabTestsList labTestsList=new LabTestsList();
	List<LabTests> labTestsListRes =new ArrayList<LabTests>();
	Info info=new Info();
 
	
	try {
		
		labTestsListRes=labTestsRepository.getTestOfPatients(patientId);
		System.out.println("Test List "+labTestsListRes.toString());
		
		if(labTestsListRes!=null)
		{
			labTestsList.setLabTestsList(labTestsListRes);
			info.setError(false);
			info.setMessage("Success");
			labTestsList.setInfo(info);
		}
		else {
			info.setError(true);
			info.setMessage("Failed");
			labTestsList.setInfo(info);
			
		}
		
	}catch (Exception e) {
		System.out.println(e.getMessage());
		info.setError(true);
		info.setMessage("Failed");
		labTestsList.setInfo(info);
	}		
	return labTestsList;
}

@RequestMapping(value = { "/getLabNotification"}, method = RequestMethod.POST)
public @ResponseBody List<LabNotification> getLabNotification(@RequestParam("labId") int labId) {
	
	
    return  labNotificationRepository.findFirst20ByLabIdOrderByNotificationIdDesc(labId);
}

@RequestMapping(value = { "/changeLabNotificationStatus"}, method = RequestMethod.POST)
public @ResponseBody int changeLabNotificationStatus(@RequestParam("notificationId") int notificationId) {
	
	
    return  labNotificationRepository.updateLabNotificationStatus(notificationId,1);
}

@RequestMapping(value = { "/getAllLabNotification"}, method = RequestMethod.POST)
public @ResponseBody List<LabNotification> getAllLabNotification(@RequestParam("labId") int labId) {
	
	
    return  labNotificationRepository.findFirst100ByLabIdOrderByNotificationIdDesc(labId);
}



@RequestMapping(value = { "/getAllLabTypes" }, method = RequestMethod.POST)
public @ResponseBody List<LabTests> getAllLabTypes() {
	
	 List<LabTests> labList=labTypesRepository.findByDelStatus(0);
	
	return labList;
}

/** insert patient Report*/

@RequestMapping(value = { "/insertPatientReport" }, method = RequestMethod.POST)
public @ResponseBody ReportDetails insertPatientReport(@RequestBody ReportDetails reportDetails)
{
	System.out.println("Comming List "+reportDetails.toString());
	ReportDetails patientReport=new ReportDetails();
	Info info =new Info();
	try {
		patientReport=reportDetailsRepository.save(reportDetails);
		
	System.out.println(patientReport.toString());
	
	if(patientReport!=null)
	{
		LabDetails LabDetails = labDetailsRepository.findByLabId(patientReport.getLabId());
		LabTests LabTests = labTestsRepository.getTestDetailsByTestId(patientReport.getLabTestId());
		PatientNotification patientNotification = new PatientNotification();
		GetPatientContactDetailsById getPatientContactDetailsById=getPatientContactDetailsByIdRepository.getPatientContactDetailsById(patientReport.getPatientId());
		 
			sendEMailService.sendMail("Your  Report has been Successfully Uploaded", "Your  Report has been Successfully Uploaded", getPatientContactDetailsById.getEmail());
		
			patientNotification.setPatientId(getPatientContactDetailsById.getPatientId());
			patientNotification.setNotification(LabDetails.getLabName()+" has sent your "+LabTests.getLabTestName()+" report on DATE "+patientReport.getReportDate()+" and TIME "+patientReport.getReportTime());					
			patientNotification.setStatus(0);
			patientNotification.setString1("Lab Report");
			patientNotification.setString2("lrating");
			patientNotification.setInt1(patientReport.getLabId());
			patientNotificationRepository.save(patientNotification);
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

	return patientReport;
}





/** get patient report by test*/

@RequestMapping(value = { "/insertPatientOwnReport" }, method = RequestMethod.POST)
public @ResponseBody Info insertPatientOwnReport(@RequestBody ReportDetails reportDetails)
{
	System.out.println("Comming List "+reportDetails.toString());
	ReportDetails patientReport=new ReportDetails();
	Info info =new Info();
	try {
		patientReport=reportDetailsRepository.save(reportDetails);
	
	if(patientReport!=null)
	{
			info.setError(false);
			info.setMessage("Success");
		
	}
	else {
		info.setError(true);
		info.setMessage("Failed");
	}
}
	
	catch (Exception e) {
		System.out.println(e.getMessage());
		info.setError(true);
		info.setMessage("Failed to insert");
	}

	return info;
}



	@RequestMapping(value = { "/getPatientReportsByTest" }, method = RequestMethod.POST)
	public @ResponseBody List<ReportDetails> getPatientReportsByTest(@RequestParam("testId") int testId,@RequestParam("patientId") int patientId)
	
	{
		ReportDetails reportDetails=new ReportDetails();
		List<ReportDetails> reportDetailsList=new ArrayList<ReportDetails>();
	 try {
		 reportDetailsList=	reportDetailsRepository.findBylabTypesIdAndDelStatus(testId,patientId);
		
	 }
	 catch (Exception e) {
System.out.println(e.getMessage());
	}
	 return reportDetailsList;
	 
	}

	/** get patient report by test*/
	
	
	@RequestMapping(value = { "/getPatientReportsByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<ReportDetails> getPatientReportsByDate(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,@RequestParam("patientId") int patientId)
	
	{
		fromDate=DateConverter.convertToYMD(fromDate);
		toDate=DateConverter.convertToYMD(toDate);
		ReportDetails reportDetails=new ReportDetails();
		List<ReportDetails> reportDetailsList=new ArrayList<ReportDetails>();
	 try {
		 reportDetailsList=	reportDetailsRepository.findByreportDateAndpatientIdAndDelStatus(fromDate,toDate,patientId);
		
	 }
	 catch (Exception e) {
System.out.println(e.getMessage());
	}
	 return reportDetailsList;
	 
	}
	@RequestMapping(value = { "/insertLabDetails" }, method = RequestMethod.POST)
	public @ResponseBody LabDetails insertLabDetails(@RequestBody LabDetails labDetails)
	{
		 
		LabDetails labDetailsRes=new LabDetails();
		 
		try {
			if(labDetails.getLabId()==0) {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
			messageDigest.update(labDetails.getPassword().getBytes(),0, labDetails.getPassword().length());  
			String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
			if (hashedPass.length() < 32) {
			   hashedPass = "0" + hashedPass; 
			}
			labDetails.setPassword(hashedPass);
			}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		try {
			
			labDetailsRes=labDetailsRepository.save(labDetails);  
			if(labDetails.getLabId()!=0)
				createDirectoryService.createNewDirectorForLab(labDetailsRes.getLabId()+"");
			sendEMailService.sendMail("Your Lab has been Successfully Registered", "Your Lab has been Successfully Registered", labDetailsRes.getEmail());
			 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return labDetailsRes;
	}
	
	
	@RequestMapping(value = { "/getLabDetailsById" }, method = RequestMethod.POST)
	public @ResponseBody LabDetails getLabDetailsById(@RequestParam("labId") int labId)
	
	{
		LabDetails labDetailsRes=new LabDetails();
	 try {
		 labDetailsRes=	labDetailsRepository.findByLabId(labId);
		
	 }
	 catch (Exception e) {
System.out.println(e.getMessage());
	}
	 return labDetailsRes;
	 
	 
	}
	  
	@RequestMapping(value = { "/getPatientReportByPatient" }, method = RequestMethod.POST)
	public @ResponseBody GetPatientLabReportAndBornReports getPatientReportByPatient(@RequestParam("patientId") int patientId,@RequestParam("startDate") String startDate,@RequestParam("toDate") String toDate)
	{
		System.out.println("patientId "+patientId);
		GetPatientLabReportAndBornReports getPatientLabReportAndBornReports=new GetPatientLabReportAndBornReports();
		List<GetPatientReports> getPatientReportsList=new ArrayList<GetPatientReports>();
		List<GetPatientBornReport> getPatientBornReportList=new ArrayList<GetPatientBornReport>();
		List<GetPatientUploadedReport> getPatientUploadedReportList=new ArrayList<GetPatientUploadedReport>();
		try {
		 getPatientReportsList=getPatientReportsRepository.getPatientReport(patientId,startDate,toDate);			
		 getPatientUploadedReportList=getPatientUploadedReportsRepository.getSelfUploadedReports(patientId,startDate,toDate,0);
		 System.out.println("cnduscndhsbcshudcb"+getPatientUploadedReportList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		//System.out.println("getPatientReportsList "+getPatientReportsList.toString());
		
		try {
		 getPatientBornReportList=getPatientBornReportRepository.getpatientBornReport(patientId);
		System.out.println("getPatientBornReportList  "+getPatientBornReportList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		getPatientLabReportAndBornReports.setGetPatientBornReportList(getPatientBornReportList);
		getPatientLabReportAndBornReports.setGetPatientReportsList(getPatientReportsList);
		getPatientLabReportAndBornReports.setGetPatientUploadedReportList(getPatientUploadedReportList);
		System.out.println("getPatientLabReportAndBornReportsxx  "+getPatientLabReportAndBornReports.toString());
	return getPatientLabReportAndBornReports;
	
	
	
	}
	
	
	
	
	 
	
	
	@RequestMapping(value = { "/getPatientReportByPatientAndDocId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPatientReports> getPatientReportByPatientAndDocId(@RequestParam("patientId") int patientId,@RequestParam("doctorId") int doctorId)
	{
		List<GetPatientReports> getPatientReportListByreportId=new ArrayList<GetPatientReports>();
		SharingReportWithDoc sharingReportWithDocRes=new SharingReportWithDoc();
		
	    sharingReportWithDocRes=sharingReportWithDocRepository.getSharingInfo(patientId,doctorId);	
	    
	    System.out.println("sharingReportWithDocRes   "+sharingReportWithDocRes.toString());
	    
	    GetPatientReports getPatientReports = new GetPatientReports();
	    
		 
		
		List<String> reportIdList = Arrays.asList(sharingReportWithDocRes.getReportId().split(","));
		
		  
        
		getPatientReportListByreportId=getPatientReportsRepository.getPatientReport(reportIdList);
		 	
		
	return getPatientReportListByreportId;
	
	}
	
	@RequestMapping(value = { "/getPatientReportByPatientAndTest" }, method = RequestMethod.POST)
	public @ResponseBody GetPatientLabReportAndBornReports getPatientReportByPatientAndTest(@RequestParam("patientId") int patientId,@RequestParam("testId") int testId)
	{
		System.out.println("patientId "+patientId);
		GetPatientLabReportAndBornReports getPatientLabReportAndBornReports=new GetPatientLabReportAndBornReports();
		List<GetPatientReports> getPatientReportsList=new ArrayList<GetPatientReports>();
		List<GetPatientBornReport> getPatientBornReportList=new ArrayList<GetPatientBornReport>();
		List<GetPatientUploadedReport> getPatientUploadedReportList=new ArrayList<GetPatientUploadedReport>();
		try {
		 getPatientReportsList=getPatientReportsRepository.getPatientReportBTest(patientId,testId);			
		 getPatientUploadedReportList=getPatientUploadedReportsRepository.getSelfUploadedReports(patientId,testId,0);
		 System.out.println("cnduscndhsbcshudcb"+getPatientUploadedReportList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		//System.out.println("getPatientReportsList "+getPatientReportsList.toString());
		
		try {
		 getPatientBornReportList=getPatientBornReportRepository.getpatientBornReport(patientId);
		System.out.println("getPatientBornReportList  "+getPatientBornReportList.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		getPatientLabReportAndBornReports.setGetPatientBornReportList(getPatientBornReportList);
		getPatientLabReportAndBornReports.setGetPatientReportsList(getPatientReportsList);
		getPatientLabReportAndBornReports.setGetPatientUploadedReportList(getPatientUploadedReportList);
		System.out.println("getPatientLabReportAndBornReportsxx  "+getPatientLabReportAndBornReports.toString());
	return getPatientLabReportAndBornReports;
	
	
	
	}
	@RequestMapping(value = { "/updateLabAppointmentCompleteStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateLabAppointmentCompleteStatus(@RequestParam("appointId") int appointId)
	{
		Info info=new Info();
		try {
			
		int res=labAppointmentRepository.finishedAppointments(appointId);
		
		if(res!=0) {
			info.setMessage("Report submitted successfully");
		}else {
			info.setError(true);
		}
		

		} catch (Exception e) {
			// TODO: handle exception
		}
		return info;
	}
	
	@RequestMapping(value = { "/insertTestTransaction" }, method = RequestMethod.POST)
	public @ResponseBody Info insertTestTransaction(@RequestBody TransactionDetails transactionDetails)
	{
		
		
		Info info =new Info();
		try {
			TransactionDetails transactionDetailsRes=transactionDetailsRepository.save(transactionDetails);
			if(transactionDetailsRes!=null ) {
				
				int reportId=transactionDetailsRes.getReportId();
				ReportDetails reportDetails=reportDetailsRepository.findByReportId(reportId);
				if(reportDetails.getInt2()==1) {
				int paymentStatus=reportDetailsRepository.updatePaymentStatusByReportId(reportId);
				}
				
			}
			
			System.out.println("transactionDetailsRes"+transactionDetailsRes);
			
			
			}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return info;
	}

	@RequestMapping(value = { "/getLabPaymentInvoice" }, method = RequestMethod.POST)
	public @ResponseBody List<PateintReportPaymentDetails> getLabPaymentInvoice(@RequestParam("patientId") int patientId)
	
	{
		 List<PateintReportPaymentDetails>  reportDetailsRes=new ArrayList<>();
	 try {
		  reportDetailsRes=pateintReportPaymentDetailsRepository.findByPatientIdAndPaymentStatus(patientId,0);
		
	 }
	 catch (Exception e) {
System.out.println(e.getMessage());
	}
	 return reportDetailsRes;
	 
	 
	}
	
	
	
	@RequestMapping(value = { "/updateLabReportsPayment" }, method = RequestMethod.POST)
	public @ResponseBody Info updateLabReportsPayment(@RequestParam("reportId") int amountType,@RequestParam("reportId") int reportId,@RequestParam("txnTableId") int txnTableId,@RequestParam("txnStatus") int txnStatus,@RequestParam("txnId") String txnId,@RequestParam("orderId") String orderId,@RequestParam("txnAmt") float txnAmt)
	{
 
		
		Info info =new Info();
		info.setError(true);
		try {

			int resTransaction=transactionDetailsRepository.updateLabReportsPayment(amountType,txnTableId, txnStatus, txnId, orderId, txnAmt);
			
			int reportStatusRes=reportDetailsRepository.updatePaymentStatusByReportIdAndStatus(reportId, txnStatus);
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
}

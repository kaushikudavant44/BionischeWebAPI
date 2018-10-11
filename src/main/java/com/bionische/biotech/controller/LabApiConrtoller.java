package com.bionische.biotech.controller;

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

import com.bionische.biotech.model.AppointmentTime;
import com.bionische.biotech.model.AppointmentTimeList;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.DoctorNotification;
import com.bionische.biotech.model.GetDoctorRatingReviewCount;
import com.bionische.biotech.model.GetLabAppointment;
import com.bionische.biotech.model.GetLabForAppointment;
import com.bionische.biotech.model.GetLabRatingReview;
import com.bionische.biotech.model.GetPatientContactDetailsById;
import com.bionische.biotech.model.GetRatingCount;
import com.bionische.biotech.model.GetReportDetailsForLab;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabAppointment;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.LabNotification;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.LabTestsList;
import com.bionische.biotech.model.PatientNotification;
import com.bionische.biotech.repository.AppointmentTimeRepository;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.GetLabAppointmentRrepository;
import com.bionische.biotech.repository.GetLabForAppointmentRepository;
import com.bionische.biotech.repository.GetLabRatingReviewRepository;
import com.bionische.biotech.repository.GetPatientContactDetailsByIdRepository;
import com.bionische.biotech.repository.GetRatingCountRepository;
import com.bionische.biotech.repository.GetReportDetailsForLabRepository;
import com.bionische.biotech.repository.LabAppointmentRepository;
import com.bionische.biotech.repository.LabDetailsRepository;
import com.bionische.biotech.repository.LabNotificationRepository;
import com.bionische.biotech.repository.LabTestsRepository;
import com.bionische.biotech.repository.PatientNotificationRepository;
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
		appointmentTime=appointmentTimeRepository.getLabAppointMent(labId,date,fromTime,toTime);
		
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
}

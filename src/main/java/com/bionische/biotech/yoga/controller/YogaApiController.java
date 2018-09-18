package com.bionische.biotech.yoga.controller;

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
import com.bionische.biotech.bloodbank.model.BloodBankDetails;
import com.bionische.biotech.bloodbank.model.BloodBankRatingDetails;
import com.bionische.biotech.model.City;
import com.bionische.biotech.model.Country;
import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.model.GetAppointmentDetails;
import com.bionische.biotech.model.HospitalDetails;
import com.bionische.biotech.model.Info;
import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.model.SpecializationDetails;
import com.bionische.biotech.model.SpecializationDetailsList;
import com.bionische.biotech.model.State;
import com.bionische.biotech.repository.DoctorDetailsRepository;
import com.bionische.biotech.repository.HospitalDetailsRepository;
import com.bionische.biotech.stemcell.model.GetPatientEnrollDetails;
import com.bionische.biotech.stemcell.model.GetStemcellBankDetails;
import com.bionische.biotech.stemcell.model.PregnancyCalculator;
import com.bionische.biotech.stemcell.model.StemCellBankDetails;
import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;
import com.bionische.biotech.stemcell.model.PlanDetails;
import com.bionische.biotech.stemcell.model.PatientEnrollDetails;
import com.bionische.biotech.stemcell.repository.GetPatientEnrollDetailsRepository;
import com.bionische.biotech.stemcell.repository.GetStemcellBankDetailsRepository;
 
import com.bionische.biotech.stemcell.repository.StemCellBankDetailsRepository;
import com.bionische.biotech.stemcell.repository.StemCellBankRatingDetailsRepository;
import com.bionische.biotech.stemcell.repository.planDetailsRepository;
import com.bionische.biotech.yoga.model.BmiCalculatorDetails;
import com.bionische.biotech.yoga.model.DailyRoutine;
import com.bionische.biotech.yoga.model.DailyRoutineDetails;
import com.bionische.biotech.yoga.model.EventRegistration;
import com.bionische.biotech.yoga.model.GetUpcomingEvent;
import com.bionische.biotech.yoga.model.GetYogaTeacherDetails;
import com.bionische.biotech.yoga.model.HealthWellness;
import com.bionische.biotech.yoga.model.HealthWellnessDetails;
import com.bionische.biotech.yoga.model.Pranayama;
import com.bionische.biotech.yoga.model.PranayamaDetails;
import com.bionische.biotech.yoga.model.UpcomingEventDetails;
import com.bionische.biotech.yoga.model.Yoga;
import com.bionische.biotech.yoga.model.YogaTeacherDetails;
import com.bionische.biotech.yoga.model.YogaTeacherRatingDetails;
import com.bionische.biotech.yoga.model.YogaTypeDetails;
import com.bionische.biotech.yoga.repository.BmiCalculatorDetailsRepository;
import com.bionische.biotech.yoga.repository.DailyRoutineDetailsRepository;
import com.bionische.biotech.yoga.repository.DailyRoutineRepository;
import com.bionische.biotech.yoga.repository.EventRegistrationRepository;
import com.bionische.biotech.yoga.repository.GetUpcomingEventRepository;
import com.bionische.biotech.yoga.repository.GetYogaTeacherDetailsRepository;
import com.bionische.biotech.yoga.repository.HealthWellnessDetailsRepository;
import com.bionische.biotech.yoga.repository.HealthWellnessRepository;
import com.bionische.biotech.yoga.repository.PranayamaDetailsRepository;
import com.bionische.biotech.yoga.repository.PranayamaRepository;
import com.bionische.biotech.yoga.repository.UpcomingEventDetailsRepository;
import com.bionische.biotech.yoga.repository.YogaRepository;
import com.bionische.biotech.yoga.repository.YogaTeacherDetailsRepository;
import com.bionische.biotech.yoga.repository.YogaTeacherRatingDetailsRepository;
import com.bionische.biotech.yoga.repository.YogaTypeDetailsRepository;
import com.bionische.biotech.stemcell.repository.PatientEnrollDetailsRepository;
import com.bionische.biotech.stemcell.repository.PregnancyCalculatorRepository;

@RestController
public class YogaApiController {
	
	
	@Autowired
	YogaTeacherDetailsRepository yogaTeacherDetailsRepository;
	
	@Autowired
	GetYogaTeacherDetailsRepository getYogaTeacherDetailsRepository;
	
	
	@Autowired
	YogaTeacherRatingDetailsRepository yogaTeacherRatingDetailsRepository;
	
	@Autowired
	BmiCalculatorDetailsRepository bmiCalculatorDetailsRepository;
	
	@Autowired
	UpcomingEventDetailsRepository upcomingEventDetailsRepository;
	
	@Autowired
	EventRegistrationRepository  eventRegistrationRepository;
	@Autowired
	GetUpcomingEventRepository  getUpcomingEventRepository;
	
	@Autowired
	YogaRepository yogaRepository;
	
	@Autowired
	PranayamaRepository pranayamaRepository;

	@Autowired
	HealthWellnessRepository healthWellnessRepository;
	
	@Autowired
	HealthWellnessDetailsRepository healthWellnessDetailsRepository;
	
	@Autowired
	YogaTypeDetailsRepository yogaTypeDetailsRepository;
	
	@Autowired
	PranayamaDetailsRepository pranayamaDetailsRepository;
	
	@Autowired
	DailyRoutineRepository dailyRoutineRepository;
	
	@Autowired
	DailyRoutineDetailsRepository dailyRoutineDetailsRepository;
	
	//registartion of yoga teacher
	@RequestMapping(value = { "/insertYogaTeacherDetails" }, method = RequestMethod.POST)
	public @ResponseBody YogaTeacherDetails insertYogaTeacherDetails(@RequestBody YogaTeacherDetails yogaTeacherDetails)
	{
		System.out.println("Comming List "+yogaTeacherDetails.toString());
		YogaTeacherDetails yogaTeacherDetailsRes=new YogaTeacherDetails();
		 
		try {
			yogaTeacherDetailsRes=yogaTeacherDetailsRepository.save(yogaTeacherDetails); 
		System.out.println(yogaTeacherDetailsRes.toString());
		   
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return yogaTeacherDetailsRes;
	}
	
	// Get list Of teachers by location
	@RequestMapping(value = { "/getTeacherListBylocation"}, method = RequestMethod.POST)
	public @ResponseBody List<GetYogaTeacherDetails> getTeacherListBylocation(@RequestParam("location") String location) {
		System.out.println("location "+location);
		
		
		List<GetYogaTeacherDetails> yogaTeacherDetailsList=new ArrayList<>();
		try {
			yogaTeacherDetailsList=getYogaTeacherDetailsRepository.getTeacherListBylocation(location);
			System.out.println("YogaTeacherList" +yogaTeacherDetailsList.toString());  

		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return yogaTeacherDetailsList;
	}
	
	//get review of teacher by teacherId
	@RequestMapping(value = { "/getTeacherReviewByTeacherId"}, method = RequestMethod.POST)
	public @ResponseBody List<YogaTeacherRatingDetails> getTeacherReviewByTeacherId(@RequestParam("teacherId") int teacherId) {
		System.out.println("teacherId "+teacherId);
		
	 
		List<YogaTeacherRatingDetails> yogaTeacherRatingDetailsList=new ArrayList<YogaTeacherRatingDetails>();
		try {
			yogaTeacherRatingDetailsList=yogaTeacherRatingDetailsRepository.findByteacherIdAndDelStatus(teacherId,0); 
			System.out.println("BloodBankRatingDetailsList" +yogaTeacherRatingDetailsList);  
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return yogaTeacherRatingDetailsList;
	}
	
	//get location By City
	@RequestMapping(value = { "/getYogaTeacharLocationBycityId"}, method = RequestMethod.POST)
	public @ResponseBody List<YogaTeacherDetails> getYogaTeacharLocationBycityId(@RequestParam("cityId") int cityId) {
		System.out.println("cityId "+cityId);
		
	 
		List<YogaTeacherDetails> yogaTeacherDetails=new ArrayList<YogaTeacherDetails>();
		try {
			yogaTeacherDetails=yogaTeacherDetailsRepository.findByCityIdAndDelStatus(cityId,0); 
			System.out.println("yogaTeacherDetails" +yogaTeacherDetails);  
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return yogaTeacherDetails;
	}
	
	 
	//Strore value of Bmi Calculator
	@RequestMapping(value = { "/insertBmiCalculator" }, method = RequestMethod.POST)
	public @ResponseBody BmiCalculatorDetails insertBmiCalculator(@RequestBody BmiCalculatorDetails bmiCalculatorDetails)
	{
		System.out.println("Comming List "+bmiCalculatorDetails.toString());
		BmiCalculatorDetails bmiCalculatorDetailsRes=new BmiCalculatorDetails();
		 
		try {
			bmiCalculatorDetailsRes=bmiCalculatorDetailsRepository.save(bmiCalculatorDetails); 
		System.out.println(bmiCalculatorDetailsRes.toString());
		   
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return bmiCalculatorDetailsRes;
	}
	
	//store upcoming evenyts
	@RequestMapping(value = { "/insertUpcomingEventDetails" }, method = RequestMethod.POST)
	public @ResponseBody UpcomingEventDetails insertUpcomingEventDetails(@RequestBody UpcomingEventDetails upcomingEventDetails)
	{
		System.out.println("Upcomming List "+upcomingEventDetails.toString());
		UpcomingEventDetails UpcomingEventDetailsRes=new UpcomingEventDetails();
		 
		try {
			UpcomingEventDetailsRes=upcomingEventDetailsRepository.save(upcomingEventDetails); 
		System.out.println(UpcomingEventDetailsRes.toString());
		   
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	return UpcomingEventDetailsRes;
	}
	
	//get Upcoming events By teacherId
	@RequestMapping(value = { "/getUpcomingEventByteacherId"}, method = RequestMethod.POST)
	public @ResponseBody List<UpcomingEventDetails> getUpcomingEventByteacherId(@RequestParam("teacherId") int teacherId) {
		System.out.println("teacherId "+teacherId);
		
		
		List<UpcomingEventDetails> upcomingEventDetailsList=new ArrayList<>();
		try {
			upcomingEventDetailsList=upcomingEventDetailsRepository.getEventsByteacherId(teacherId);
			System.out.println("EventsList" +upcomingEventDetailsList.toString());  

		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return upcomingEventDetailsList;
	}
	
	//store event Registration
	@RequestMapping(value = { "/insertEventDetails" }, method = RequestMethod.POST)
	public @ResponseBody EventRegistration insertEventDetails(@RequestBody EventRegistration eventRegistration)
	{
		System.out.println("Comming List "+eventRegistration.toString());
		EventRegistration eventRegistrationRes=new EventRegistration();
		 
		try {
			eventRegistrationRes=eventRegistrationRepository.save(eventRegistration); 
		System.out.println(eventRegistrationRes.toString());
		   
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			 }
	return eventRegistrationRes;
	}
	
	//get all events
	@RequestMapping(value = { "/getAllEvents" }, method = RequestMethod.POST)
	public @ResponseBody List<GetUpcomingEvent> getAllEvents() {
		
		 List<GetUpcomingEvent> getupcomingEventDetailsList=getUpcomingEventRepository.findAll();
		
		return getupcomingEventDetailsList;
	}
	
	
	@RequestMapping(value = { "/getYogaDetailsBytypeId"}, method = RequestMethod.POST)
	public @ResponseBody List<YogaTypeDetails> getYogaDetailsBytypeId(@RequestParam("typeId") int typeId) {
		System.out.println(" typeId "+ typeId);
		
		
		List<YogaTypeDetails> yogaTypeDetailsList=new ArrayList<>();
		try {
			yogaTypeDetailsList=yogaTypeDetailsRepository.getEventsByTypeId(typeId);
			System.out.println("EventsList" +yogaTypeDetailsList.toString());  

		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return yogaTypeDetailsList;
	}	
	
	@RequestMapping(value = { "/getHealthDetailsByhealthtypeId"}, method = RequestMethod.POST)
	public @ResponseBody List<HealthWellnessDetails> getHealthDetailsByhealthtypeId(@RequestParam("healthTypeId") int healthTypeId) {
		System.out.println(" healthTypeId "+ healthTypeId);
		
		
		List<HealthWellnessDetails> healthWellnessDetails=new ArrayList<>();
		try {
			healthWellnessDetails=healthWellnessDetailsRepository.getHealthByHealthTypeId(healthTypeId);
			System.out.println("EventsList" +healthWellnessDetails.toString());  

		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return healthWellnessDetails;
	}	
	
	@RequestMapping(value = { "/getPranayamaDetailsBytypeId"}, method = RequestMethod.POST)
	public @ResponseBody List<PranayamaDetails> getPranayamaDetailsBytypeId(@RequestParam("pranayamaTypeId") int pranayamaTypeId) {
		System.out.println(" pranayamaTypeId "+ pranayamaTypeId);
		
		
		List<PranayamaDetails> PranayamaDetails=new ArrayList<>();
		try {
			PranayamaDetails=pranayamaDetailsRepository.getPranayamaByPranayamaTypeId(pranayamaTypeId);
			System.out.println("PranayamaDetails" +PranayamaDetails.toString());  

		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return PranayamaDetails;
	}	
	
	@RequestMapping(value = { "/getDailyRoutineDetailsBytypeId"}, method = RequestMethod.POST)
	public @ResponseBody List<DailyRoutineDetails> getDailyRoutineDetailsBytypeId(@RequestParam("dailyroutineTypeId") int dailyroutineTypeId) {
		System.out.println(" dailyroutineTypeId "+ dailyroutineTypeId);
		
		
		List<DailyRoutineDetails> dailyRoutineDetails=new ArrayList<>();
		try {
			dailyRoutineDetails=dailyRoutineDetailsRepository.getDailyRoutineByDailyroutineTypeId(dailyroutineTypeId);
			System.out.println("dailyRoutineDetails" +dailyRoutineDetails.toString());  

		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return dailyRoutineDetails;
	}	
	@RequestMapping(value = { "/getInstituteByLocation"}, method = RequestMethod.POST)
	public @ResponseBody List<YogaTeacherDetails> getInstituteByLocation(@RequestParam("location") String location) {
		System.out.println("location "+location);
		
	 
		List<YogaTeacherDetails> yogaTeacherDetailsList=new ArrayList<YogaTeacherDetails>();
		try {
			yogaTeacherDetailsList=yogaTeacherDetailsRepository.findByLocationAndDelStatus(location,0); 
			System.out.println("yogaTeacherDetailsList" +yogaTeacherDetailsList);  
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
        return yogaTeacherDetailsList;
	}
	
	
	@RequestMapping(value = { "/getyogaTypesByteacherId" }, method = RequestMethod.POST)
	public @ResponseBody List<Yoga> getyogaTypesByteacherId(@RequestParam("teacherId") int teacherId)
	{
		YogaTeacherDetails yogaTeacherDetails=new YogaTeacherDetails();
		List<String> yogatypesIdList=new ArrayList<>();
		try {
			
			yogaTeacherDetails=yogaTeacherDetailsRepository.findByTeacherId(teacherId);
		
			yogatypesIdList = Arrays.asList(yogaTeacherDetails.getYogaTypes().split(","));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<Yoga> yogatypesList=new ArrayList<>();
		
		try {
			
			yogatypesList=yogaRepository.getTypesDetails(yogatypesIdList);
			System.out.println("yogatype List "+yogatypesList.toString());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		
		
		return yogatypesList;
	}
	
	@RequestMapping(value = { "/gethealthByteacherId" }, method = RequestMethod.POST)
	public @ResponseBody List<HealthWellness> gethealthByteacherId(@RequestParam("teacherId") int teacherId)
	{
		YogaTeacherDetails yogaTeacherDetails=new YogaTeacherDetails();
		List<String> healthtypesIdList=new ArrayList<>();
		try {
			
			yogaTeacherDetails=yogaTeacherDetailsRepository.findByTeacherId(teacherId);
		
			healthtypesIdList = Arrays.asList(yogaTeacherDetails.getHealthWellnessTypes().split(","));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<HealthWellness> healthypesList=new ArrayList<>();
		
		try {
			
			healthypesList=healthWellnessRepository.getTypesDetails(healthtypesIdList);
			System.out.println("yogatype List "+healthypesList.toString());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return healthypesList;
	}
	
	@RequestMapping(value = { "/getpranayamaByteacherId" }, method = RequestMethod.POST)
	public @ResponseBody List<Pranayama> getpranayamaByteacherId(@RequestParam("teacherId") int teacherId)
	{
		YogaTeacherDetails yogaTeacherDetails=new YogaTeacherDetails();
		List<String> pranayamatypesIdList=new ArrayList<>();
		try {
			
			yogaTeacherDetails=yogaTeacherDetailsRepository.findByTeacherId(teacherId);
		
			pranayamatypesIdList = Arrays.asList(yogaTeacherDetails.getPranayamaTypes().split(","));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<Pranayama> ptypesList=new ArrayList<>();
		
		try {
			
			ptypesList=pranayamaRepository.getTypesDetails(pranayamatypesIdList);
			System.out.println("pranayama List "+ptypesList.toString());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
return ptypesList;
	}
	
	@RequestMapping(value = { "/getDailyRotineByteacherId" }, method = RequestMethod.POST)
	public @ResponseBody List<DailyRoutine> getDailyRotineByteacherId(@RequestParam("teacherId") int teacherId)
	{
		YogaTeacherDetails yogaTeacherDetails=new YogaTeacherDetails();
		List<String> dailytypesIdList=new ArrayList<>();
		try {
			
			yogaTeacherDetails=yogaTeacherDetailsRepository.findByTeacherId(teacherId);
		
			dailytypesIdList = Arrays.asList(yogaTeacherDetails.getDailyRoutineTypes().split(","));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<DailyRoutine> dtypesList=new ArrayList<>();
		
		try {
			
			dtypesList=dailyRoutineRepository.getTypesDetails(dailytypesIdList);
			System.out.println("pranayama List "+dtypesList.toString());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
return dtypesList;
	}
}



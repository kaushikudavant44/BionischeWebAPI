package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.LabTests;

public interface LabTestsRepository extends JpaRepository<LabTests, Integer> {

	List<LabTests> findByDelStatus(int delStatus);

	List<LabTests> findAll();

	@Query(value = " SELECT * from lab_tests where lab_test_id=:testId AND del_status=0", nativeQuery = true)
	LabTests getTestDetailsByTestId(@Param("testId") int testId);

	@Query(value = " SELECT * from lab_tests where lab_test_id IN(:testIdList) AND del_status=0", nativeQuery = true)
	List<LabTests> getTestDetails(@Param("testIdList") List<String> testIdList);

	/*@Query(value = " SELECT * FROM lab_tests WHERE lab_test_id IN (SELECT DISTINCT lab_test_id FROM patient_reports WHERE patient_id=:patientId)", nativeQuery = true)
	List<LabTests> getTestOfPatients(@Param("patientId") int patientId);
*/
	@Transactional
	@Modifying
	@Query("UPDATE LabTests  SET delStatus =:delStatus WHERE labTestId=:labTestId")
	int updateTestStatus(@Param("labTestId") int labTestId, @Param("delStatus") int delStatus);

	/*
	 * New Get lab test 2019-02-07 ganesh
	 */ @Query(value = " SELECT t.* from lab_tests t,t_tests_in_lab lt where t.lab_test_id=lt.test_id AND lt.lab_id=:labId AND lt.del_status=0 AND t.del_status=0", nativeQuery = true)
	List<LabTests> getLabTestsByLabId(@Param("labId") int labId);

	@Query(value = " SELECT t.* from lab_tests t,t_lab_appointment_details a where a.lab_app_id=:appointmentId AND FIND_IN_SET(t.lab_test_id, a.test_id_list) ", nativeQuery = true)
	List<LabTests> getLabTestsByAppointmentId(@Param("appointmentId")int appointmentId);

} 

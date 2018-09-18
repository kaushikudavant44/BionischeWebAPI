package com.bionische.biotech.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.yoga.model.BmiCalculatorDetails;
import com.bionische.biotech.yoga.model.GetYogaTeacherDetails;
import com.bionische.biotech.yoga.model.YogaTeacherDetails;

public interface BmiCalculatorDetailsRepository extends JpaRepository<BmiCalculatorDetails, Integer> {
	BmiCalculatorDetails save(BmiCalculatorDetails bmiCalculatorDetails);


}
  
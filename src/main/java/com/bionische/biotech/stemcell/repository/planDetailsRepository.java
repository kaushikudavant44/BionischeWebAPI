package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorDetails;
import com.bionische.biotech.stemcell.model.GetStemcellBankDetails;
import com.bionische.biotech.stemcell.model.PlanDetails;

public interface planDetailsRepository extends JpaRepository<PlanDetails, Integer>{

	//Stemcellrenewal getstemcellrenewalByStemCellBankId(int stemCellBankId);

	@Query(value="SELECT s.plan_id,s.plan_days, s.plan_name, s.stemcellbank_id, s.plan_type, s.plan_cost, s.message, s.terms_condition  from stemcellplan_details s where s.stemcellbank_id=:stemCellBankId AND s.del_status=0;",nativeQuery=true)
	//Stemcellrenewal getstemcellrenewalByStemCellBankId(@Param("stemCellBankId")int stemCellBankId);

	List<PlanDetails> getstemcellrenewalByStemCellBankId(@Param("stemCellBankId")int stemCellBankId);
	
		}


                  
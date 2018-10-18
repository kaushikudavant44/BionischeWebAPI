package com.bionische.biotech.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPrescriptionDetailsForOrder;

public interface GetPrescriptionDetailsForOrderRepository extends JpaRepository<GetPrescriptionDetailsForOrder, Integer>{

	@Query(value="SELECT o.prescription_order_details_id, o.request_id, o.prescription_id, o.quantity, o.price, o.status,"
			+ " o.del_status, p.medicine_name, p.medicine_timing, p.medicine_instruction, p.medicine_duration FROM"
			+ " prescription_order_details o, prescription_details p WHERE o.request_id=:requestId AND"
			+ " o.prescription_id=p.prescription_id",nativeQuery=true)
	List<GetPrescriptionDetailsForOrder> getPrescriptionDetailsForOrderByRequestIdId(@Param("requestId")int requestId);
}

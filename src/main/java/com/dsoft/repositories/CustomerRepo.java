package com.dsoft.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dsoft.entity.CustPersionalDetail;

public interface CustomerRepo extends CrudRepository<CustPersionalDetail, Long> {
	@Modifying(clearAutomatically=true)
	@Query("update CustPersionalDetail cust SET cust.isDeleted=:action where cust.custId=:custId")
	public int deleteCustomer(@Param("custId")Long custId,@Param("action")boolean action);
}

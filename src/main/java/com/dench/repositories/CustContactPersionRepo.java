package com.dench.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dench.entity.CustContactPersion;
import com.dench.entity.CustPersionalDetail;

public interface CustContactPersionRepo extends CrudRepository<CustContactPersion, Long>{
	public List<CustContactPersion> getCustContactPersionByCustomer(CustPersionalDetail custPersionalDetail);

}

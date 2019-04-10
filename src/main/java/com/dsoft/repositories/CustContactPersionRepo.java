package com.dsoft.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dsoft.entity.CustContactPersion;
import com.dsoft.entity.CustPersionalDetail;

public interface CustContactPersionRepo extends CrudRepository<CustContactPersion, Long>{
	public List<CustContactPersion> getCustContactPersionByCustomer(CustPersionalDetail custPersionalDetail);

}

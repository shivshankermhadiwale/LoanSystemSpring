package com.hgapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.ContactPersion;
import com.hgapp.entity.CustomerDetail;

public interface ContactPersionRepo extends CrudRepository<ContactPersion, Long>{
	public List<ContactPersion> getCustContactPersionByPersionId(CustomerDetail custPersionalDetail);

}

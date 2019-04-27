package com.hgapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.CustomerDetail;

public interface AddressRepo extends CrudRepository<AddressDetail, Long> {
	AddressDetail getCustAddressDetailByPersion(CustomerDetail custPersionalDetail);

}

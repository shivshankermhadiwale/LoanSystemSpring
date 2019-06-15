package com.hgapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.CustDetail;

public interface AddressRepo extends CrudRepository<AddressDetail, Long> {
	AddressDetail getCustAddressDetailByPersion(CustDetail custPersionalDetail);

}

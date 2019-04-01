package com.dench.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dench.entity.CustAddressDetail;

public interface CustAddressRepo extends CrudRepository<CustAddressDetail,Long > {

}

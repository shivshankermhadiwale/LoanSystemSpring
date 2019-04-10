package com.dsoft.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dsoft.entity.CustAddressDetail;

public interface CustAddressRepo extends CrudRepository<CustAddressDetail,Long > {

}

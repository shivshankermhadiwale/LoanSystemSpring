package com.dench.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dench.entity.SalesEnquiry;

public interface SalesEnqRepo extends CrudRepository<SalesEnquiry, Long>{

}

package com.dench.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dench.entity.PurchaseEnquiry;

public interface PurchaseEnqRepository extends CrudRepository<PurchaseEnquiry, Long> {

}

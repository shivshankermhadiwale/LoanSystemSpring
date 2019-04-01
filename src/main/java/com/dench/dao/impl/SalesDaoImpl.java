package com.dench.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.SalesDao;
import com.dench.entity.SalesEnquiry;
import com.dench.repositories.SalesEnqRepo;

@Repository
public class SalesDaoImpl implements SalesDao {
	@Autowired
	SalesEnqRepo salesEnqRepo;

	public SalesEnquiry addNewSalesEnq(SalesEnquiry salesEnq) {
		return salesEnqRepo.save(salesEnq);
	}

	public Optional<SalesEnquiry> getSalesEnqById(Long salesEnqId) {
		return salesEnqRepo.findById(salesEnqId);
	}
}

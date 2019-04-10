package com.dsoft.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsoft.dao.SalesDao;
import com.dsoft.entity.SalesEnquiry;
import com.dsoft.repositories.SalesEnqRepo;

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

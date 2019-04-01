package com.dench.dao;

import java.util.Optional;

import com.dench.entity.SalesEnquiry;

public interface SalesDao {
	public SalesEnquiry addNewSalesEnq(SalesEnquiry salesEnq);

	public Optional<SalesEnquiry> getSalesEnqById(Long salesEnqId);
}

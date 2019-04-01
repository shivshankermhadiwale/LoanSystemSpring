package com.dench.service;



import com.dench.entity.SalesEnquiry;

public interface SalesService {
	public SalesEnquiry addNewSalesEnq(SalesEnquiry salesEnq);

	public SalesEnquiry getSalesEnqById(Long salesEnqId);
}

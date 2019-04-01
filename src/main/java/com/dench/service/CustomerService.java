package com.dench.service;
import com.dench.dto.CustomerDto;
import com.dench.entity.CustPersionalDetail;

public interface CustomerService {
	public CustomerDto addNewCustomer(CustomerDto customer);
	public CustPersionalDetail findCustomerDetailById(Long custId);
	public String deleteCustomer(Long custId);
}

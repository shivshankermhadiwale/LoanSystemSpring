package com.dench.service;

import java.util.List;

import com.dench.dto.CustContactPersionDto;
import com.dench.dto.CustomerDto;
import com.dench.entity.CustPersionalDetail;

public interface CustomerService {
	public CustomerDto addNewCustomer(CustomerDto customer);

	public CustPersionalDetail findCustomerDetailById(Long custId);

	public String deleteCustomer(Long custId);

	public CustContactPersionDto addCustContactPersion(CustContactPersionDto contactPersionDto);

	public List<CustContactPersionDto> getCustContactPersionByCustId(Long custId);

	public List<CustPersionalDetail> getAllCustomersLst();
}

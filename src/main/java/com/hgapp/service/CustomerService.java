package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.CustContactPersionDto;
import com.hgapp.dto.CustomerDto;
import com.hgapp.entity.CustomerDetail;

public interface CustomerService {
	public CustomerDto addNewCustomer(CustomerDto customer);

	public CustomerDto findCustomerDetailById(Long custId);

	public String deleteCustomer(Long custId);

	public List<CustomerDetail> getAllCustomersLst();

	public CustContactPersionDto addCustContactPersion(CustContactPersionDto contactPersionDto);

	public List<CustContactPersionDto> getCustContactPersionByCustId(Long custId);

}

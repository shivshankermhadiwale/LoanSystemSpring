package com.dsoft.service;

import java.util.List;

import com.dsoft.dto.CustContactPersionDto;
import com.dsoft.dto.CustomerDto;
import com.dsoft.entity.CustPersionalDetail;

public interface CustomerService {
	public CustomerDto addNewCustomer(CustomerDto customer);

	public CustPersionalDetail findCustomerDetailById(Long custId);

	public String deleteCustomer(Long custId);

	public CustContactPersionDto addCustContactPersion(CustContactPersionDto contactPersionDto);

	public List<CustContactPersionDto> getCustContactPersionByCustId(Long custId);

	public List<CustPersionalDetail> getAllCustomersLst();
}

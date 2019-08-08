package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.CustContactPersionDto;
import com.hgapp.dto.CustomerDto;
import com.hgapp.entity.CustDetail;

public interface CustService {
	public CustomerDto addNewCustomer(CustomerDto customer);

	public CustomerDto editCustomerDetail(CustomerDto customer);

	public CustomerDto findCustomerDetailById(Long custId);

	public String deleteCustomer(Long custId);

	public List<CustDetail> getAllCustomersLst();

	public CustContactPersionDto addCustContactPersion(CustContactPersionDto contactPersionDto);

	public CustContactPersionDto editCustContactPersion(CustContactPersionDto contactPersionDto);

	public List<CustContactPersionDto> getCustContactPersionByCustId(Long custId);

}

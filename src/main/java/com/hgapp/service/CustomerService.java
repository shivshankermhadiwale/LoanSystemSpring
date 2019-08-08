package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.CustContactPersionDto;
import com.hgapp.dto.CustomerDto;
import com.hgapp.entity.CustDetail;

public interface CustomerService {
	public CustomerDto saveOrUpdateCustomerDtl(CustomerDto customer);

	/* public CustomerDto editCustomerDetail(CustomerDto customer); */

	public CustomerDto findCustomerDtlById(Long custId);

	public List<CustDetail> findAllCustomers();

	public String deleteCustomer(Long custId);

	public CustContactPersionDto saveOrUpdateAddressDetail(CustContactPersionDto contactPersionDto);

	/*public CustContactPersionDto editCustContactPersion(CustContactPersionDto contactPersionDto);*/

	public List<CustContactPersionDto> findContactPersionsByCustId(Long custId);

}

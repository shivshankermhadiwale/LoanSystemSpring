package com.hgapp.dao;

import java.util.List;
import java.util.Optional;

import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.ContactPersion;
import com.hgapp.entity.CustomerDetail;
import com.hgapp.entity.CustomerAudit;

public interface CustomerDao {
	public CustomerDetail addCustomerDetail(CustomerDetail custMaster);

	public Optional<CustomerDetail> findCustomerDetailById(Long custId);

	public int deleteCustomer(Long custId, boolean action);

	public List<CustomerDetail> getAllCustomersLst();

	/*public CustomerAudit findByCustomer(PersionDetail cusomer);*/
/*
	public CustomerAudit saveCustomerAudit(CustomerAudit custAudit);*/

	public AddressDetail addCustAddressDetail(AddressDetail custAddressDetail);

	public AddressDetail getCustAddDetailByCustId(CustomerDetail custPersionalDetail);

	public ContactPersion addCustContactPersion(ContactPersion contactPersions);

	public List<ContactPersion> getCustContactPersionByCustPersionalDetail(CustomerDetail custPersionalDetail);

}

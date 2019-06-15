package com.hgapp.dao;

import java.util.List;
import java.util.Optional;

import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.ContactPersion;
import com.hgapp.entity.CustDetail;
import com.hgapp.entity.CustAudit;

public interface CustDao {
	public CustDetail addCustomerDetail(CustDetail custMaster);

	public Optional<CustDetail> findCustomerDetailById(Long custId);

	public int deleteCustomer(Long custId, boolean action);

	public List<CustDetail> getAllCustomersLst();

	/*public CustomerAudit findByCustomer(PersionDetail cusomer);*/
/*
	public CustomerAudit saveCustomerAudit(CustomerAudit custAudit);*/

	public AddressDetail addCustAddressDetail(AddressDetail custAddressDetail);

	public AddressDetail getCustAddDetailByCustId(CustDetail custPersionalDetail);

	public ContactPersion addCustContactPersion(ContactPersion contactPersions);

	public List<ContactPersion> getCustContactPersionByCustPersionalDetail(CustDetail custPersionalDetail);

}

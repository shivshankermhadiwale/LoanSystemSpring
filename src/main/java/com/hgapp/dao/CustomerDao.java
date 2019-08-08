package com.hgapp.dao;

import java.util.List;
import java.util.Optional;

import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.ContactPersion;
import com.hgapp.entity.CustDetail;

public interface CustomerDao {
	public CustDetail addCustomerDetail(CustDetail custMaster);

	public Optional<CustDetail> findCustomerDetailById(Long custId);

	public int deleteCustomer(Long custId, boolean action);

	public List<CustDetail> getAllCustomersLst();

	public AddressDetail addCustAddressDetail(AddressDetail custAddressDetail);

	public AddressDetail getCustAddDetailByCustId(CustDetail custPersionalDetail);

	public ContactPersion addCustContactPersion(ContactPersion contactPersions);

	public Optional<ContactPersion> getCustContactPersionsById(Long contactPersionId);

	public List<ContactPersion> getCustContactPersionByCustPersionalDetail(CustDetail custPersionalDetail);

}

package com.dench.dao;

import java.util.List;
import java.util.Optional;

import com.dench.entity.CustAddressDetail;
import com.dench.entity.CustContactPersion;
import com.dench.entity.CustPersionalDetail;
import com.dench.entity.CustomerAudit;

public interface CustomerDao {
	public CustPersionalDetail addCustomerDetail(CustPersionalDetail custMaster);
	public CustAddressDetail addCustAddressDetail(CustAddressDetail custAddressDetail);

	public Optional<CustPersionalDetail> findCustomerDetailById(Long custId);

	public int deleteCustomer(Long custId, boolean action);

	public CustomerAudit findByCustomer(CustPersionalDetail cusomer);

	public CustomerAudit saveCustomerAudit(CustomerAudit custAudit);
	public CustContactPersion addCustContactPersion(CustContactPersion contactPersions);
	public List<CustContactPersion> getCustContactPersionByCustPersionalDetail(CustPersionalDetail custPersionalDetail);
	public List<CustPersionalDetail> getAllCustomersLst();
}

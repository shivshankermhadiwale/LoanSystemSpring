package com.dsoft.dao;

import java.util.List;
import java.util.Optional;

import com.dsoft.entity.CustAddressDetail;
import com.dsoft.entity.CustContactPersion;
import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.CustomerAudit;

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

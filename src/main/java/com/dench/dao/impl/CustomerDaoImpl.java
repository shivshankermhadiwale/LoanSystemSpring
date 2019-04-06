package com.dench.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.CustomerDao;
import com.dench.entity.CustAddressDetail;
import com.dench.entity.CustContactPersion;
import com.dench.entity.CustPersionalDetail;
import com.dench.entity.CustomerAudit;
import com.dench.repositories.CustAddressRepo;
import com.dench.repositories.CustContactPersionRepo;
import com.dench.repositories.CustomerAuditRepo;
import com.dench.repositories.CustomerRepo;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	CustAddressRepo custAddressRepo;
	@Autowired
	CustomerAuditRepo custAuditRepo;

	@Autowired
	CustContactPersionRepo custContactpersionRepo;
	@Override
	public CustPersionalDetail addCustomerDetail(CustPersionalDetail custMaster) {
		return customerRepo.save(custMaster);
	}

	public Optional<CustPersionalDetail> findCustomerDetailById(Long custId) {
		return customerRepo.findById(custId);
	}

	@Override
	public int deleteCustomer(Long custId, boolean action) {
		return customerRepo.deleteCustomer(custId, action);
	}

	public CustomerAudit findByCustomer(CustPersionalDetail customer) {
		return custAuditRepo.findByCustomer(customer);
	}

	public CustomerAudit saveCustomerAudit(CustomerAudit custAudit) {
		return custAuditRepo.save(custAudit);
	}

	@Override
	public CustAddressDetail addCustAddressDetail(CustAddressDetail custAddressDetail) {
		return custAddressRepo.save(custAddressDetail);
	}

	@Override
	public CustContactPersion addCustContactPersion(CustContactPersion contactPersions) {
		return custContactpersionRepo.save(contactPersions);
	}

	@Override
	public List<CustContactPersion> getCustContactPersionByCustPersionalDetail(CustPersionalDetail custPersionalDetail) {
		return custContactpersionRepo.getCustContactPersionByCustomer(custPersionalDetail);
	}

}

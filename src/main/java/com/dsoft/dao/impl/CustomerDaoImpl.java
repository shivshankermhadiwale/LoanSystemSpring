package com.dsoft.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsoft.dao.CustomerDao;
import com.dsoft.entity.CustAddressDetail;
import com.dsoft.entity.CustContactPersion;
import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.CustomerAudit;
import com.dsoft.repositories.CustAddressRepo;
import com.dsoft.repositories.CustContactPersionRepo;
import com.dsoft.repositories.CustomerAuditRepo;
import com.dsoft.repositories.CustomerRepo;

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

	@Override
	public List<CustPersionalDetail> getAllCustomersLst() {
		return (List<CustPersionalDetail>) customerRepo.findAll();
		
	}

}

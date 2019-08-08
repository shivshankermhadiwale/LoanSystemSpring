package com.hgapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.CustomerDao;
import com.hgapp.entity.AddressDetail;
import com.hgapp.entity.ContactPersion;
import com.hgapp.entity.CustDetail;
import com.hgapp.repositories.AddressRepo;
import com.hgapp.repositories.ContactPersionRepo;
import com.hgapp.repositories.CustomerRepo;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	AddressRepo custAddressRepo;

	@Autowired
	ContactPersionRepo custContactpersionRepo;

	@Override
	public CustDetail saveOrUpdateCustomerDtl(CustDetail custDetail) {
		try {
			return customerRepo.save(custDetail);
		} catch (DuplicateKeyException ex) {
			throw new DuplicateKeyException("Record Already Exist");
		}
	}

	public Optional<CustDetail> findCustomerDtlById(Long custId) {
		return customerRepo.findById(custId);
	}

	@Override
	public List<CustDetail> findAllCustomers() {
		return (List<CustDetail>) customerRepo.findAll();

	}

	@Override
	public int deleteCustomer(Long custId, boolean action) {
		return customerRepo.deleteCustomer(custId, action);
	}

	@Override
	public AddressDetail saveOrUpdateAddressDetail(AddressDetail custAddressDetail) {
		return custAddressRepo.save(custAddressDetail);
	}

	@Override
	public AddressDetail findAddressDetailByCustId(CustDetail custId) {
		return custAddressRepo.getCustAddressDetailByPersion(custId);
	}

	@Override
	public ContactPersion saveOrUpdateContactPersion(ContactPersion contactPersions) {
		return custContactpersionRepo.save(contactPersions);
	}

	@Override
	public Optional<ContactPersion> findContactPersionById(Long contactPersionId) {
		return custContactpersionRepo.findById(contactPersionId);
	}

	@Override
	public List<ContactPersion> findContactPersionsByCustId(CustDetail custid) {
		return custContactpersionRepo.getCustContactPersionByPersionId(custid);
	}

}

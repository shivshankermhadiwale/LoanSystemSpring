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
public class CustDaoImpl implements CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	AddressRepo custAddressRepo;

	@Autowired
	ContactPersionRepo custContactpersionRepo;

	@Override
	public CustDetail addCustomerDetail(CustDetail custMaster) {
		try {
			return customerRepo.save(custMaster);
		} catch (DuplicateKeyException ex) {
			throw new DuplicateKeyException("Record Already Exist");
		}
	}

	public Optional<CustDetail> findCustomerDetailById(Long custId) {
		return customerRepo.findById(custId);
	}

	@Override
	public int deleteCustomer(Long custId, boolean action) {
		return customerRepo.deleteCustomer(custId, action);
	}

	@Override
	public AddressDetail addCustAddressDetail(AddressDetail custAddressDetail) {
		return custAddressRepo.save(custAddressDetail);
	}

	@Override
	public ContactPersion addCustContactPersion(ContactPersion contactPersions) {
		return custContactpersionRepo.save(contactPersions);
	}

	@Override
	public List<ContactPersion> getCustContactPersionByCustPersionalDetail(CustDetail custPersionalDetail) {
		return custContactpersionRepo.getCustContactPersionByPersionId(custPersionalDetail);
	}

	@Override
	public List<CustDetail> getAllCustomersLst() {
		return (List<CustDetail>) customerRepo.findAll();

	}

	@Override
	public AddressDetail getCustAddDetailByCustId(CustDetail custPersionalDetail) {
		return custAddressRepo.getCustAddressDetailByPersion(custPersionalDetail);
	}

	@Override
	public Optional<ContactPersion> getCustContactPersionsById(Long contactPersionId) {
		return custContactpersionRepo.findById(contactPersionId);
	}

}

package com.dsoft.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsoft.dao.SupplierDao;
import com.dsoft.entity.Supplier;
import com.dsoft.repositories.SupplierRepository;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SupplierRepository supplierRepository;
	@Override
	public Supplier addNewSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Optional<Supplier> findSupplierById(Long suppId) {
		return supplierRepository.findById(suppId);
	}

}

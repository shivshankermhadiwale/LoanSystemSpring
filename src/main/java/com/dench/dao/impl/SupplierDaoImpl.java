package com.dench.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.SupplierDao;
import com.dench.entity.Supplier;
import com.dench.repositories.SupplierRepository;

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

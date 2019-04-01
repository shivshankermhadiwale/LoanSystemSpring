package com.dench.dao;

import java.util.Optional;

import com.dench.entity.Supplier;

public interface SupplierDao {
	public Supplier addNewSupplier(Supplier supplier);
	public Optional<Supplier> findSupplierById(Long suppId);
}

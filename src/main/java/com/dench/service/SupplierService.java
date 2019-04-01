package com.dench.service;

import com.dench.entity.Supplier;

public interface SupplierService {
	public Supplier addNewSupplier(Supplier supplier);
	public Supplier findSupplierById(Long suppId);
}

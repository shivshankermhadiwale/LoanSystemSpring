package com.dench.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dench.entity.Supplier;
import com.dench.entity.SupplierAudit;
import com.dench.exception.RecordNotFound;
import com.dench.service.DaoServicess;
import com.dench.service.SupplierService;
@Service
public class SupplierServiceImpl extends DaoServicess implements SupplierService {

	@Override
	public Supplier addNewSupplier(Supplier supplier) {
		SupplierAudit suppAudit = new SupplierAudit();
		suppAudit.setAction("Created");
		suppAudit.setLastUpdatedDatetime(LocalDateTime.now());
		suppAudit.setLastUpdatedUserDesignation("NA");
		suppAudit.setLastUpdatedUserId("1");
		suppAudit.setLastUpdatedUserName("NA");
		suppAudit.setLoggedInUserId("1");
		suppAudit.setUserDesignation("NA");
		suppAudit.setUserName("NA");
		suppAudit.setSupplier(supplier);
		suppAudit.setCreatedOnDateTime(LocalDateTime.now());
		supplier.setSuppAudit(suppAudit);
		return this.getDaoManager().getSupplierDao().addNewSupplier(supplier);
	}

	@Override
	public Supplier findSupplierById(Long suppId) {
		Optional<Supplier> supplier = this.getDaoManager().getSupplierDao().findSupplierById(suppId);
		if (!supplier.isPresent())
			throw new RecordNotFound("Supplier Not Founbd");
		return supplier.get();
	}

}

package com.dench.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.AuthDao;
import com.dench.dao.CustomerDao;
import com.dench.dao.DaoManger;
import com.dench.dao.ItemDao;
import com.dench.dao.PurchaseDao;
import com.dench.dao.SalesDao;
import com.dench.dao.SupplierDao;

@Repository
public class DaoMangerImpl implements DaoManger {
	@Autowired
	private CustomerDao custMasterDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private PurchaseDao purchaseDao;

	@Autowired
	private AuthDao authDao;
	@Autowired
	private SalesDao salesDao;

	public SalesDao getSalesDao() {
		return salesDao;
	}

	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}

	public AuthDao getAuthDao() {
		return authDao;
	}

	public void setAuthDao(AuthDao authDao) {
		this.authDao = authDao;
	}

	public CustomerDao getCustMasterDao() {
		return custMasterDao;
	}

	public PurchaseDao getPurchaseDao() {
		return purchaseDao;
	}

	public void setCustMasterDao(CustomerDao custMasterDao) {
		this.custMasterDao = custMasterDao;
	}

	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public CustomerDao getCustomerDao() {
		return custMasterDao;
	}

	public void setCustomerDao(CustomerDao custMasterDao) {
		this.custMasterDao = custMasterDao;
	}
}

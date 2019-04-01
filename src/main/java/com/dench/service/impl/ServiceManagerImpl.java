package com.dench.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dench.service.AuthSerivice;
import com.dench.service.CustomerService;
import com.dench.service.ItemService;
import com.dench.service.PurchaseService;
import com.dench.service.SalesService;
import com.dench.service.ServiceManager;
import com.dench.service.SupplierService;

@Service
public class ServiceManagerImpl implements ServiceManager {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private AuthSerivice authService;
	@Autowired
	private SalesService salesService;
	
	public SalesService getSalesService() {
		return salesService;
	}

	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}

	public AuthSerivice getAuthService() {
		return authService;
	}

	public void setAuthService(AuthSerivice authService) {
		this.authService = authService;
	}

	public PurchaseService getPurchaseService() {
		return purchaseService;
	}

	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService= purchaseService;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustService(CustomerService custService) {
		this.customerService = custService;
	}
}

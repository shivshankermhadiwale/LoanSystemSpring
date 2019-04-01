package com.dench.service;

public interface ServiceManager {
	public CustomerService getCustomerService();

	public ItemService getItemService();

	public SupplierService getSupplierService();

	public PurchaseService getPurchaseService();

	public AuthSerivice getAuthService();

	public SalesService getSalesService();
}

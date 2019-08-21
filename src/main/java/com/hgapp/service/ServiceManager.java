package com.hgapp.service;

public interface ServiceManager {
	public CustomerService getCustomerService();

	/*
	 * public ItemService getItemService();
	 * 
	 * public SupplierService getSupplierService();
	 * 
	 * public PurchaseService getPurchaseService();
	 */

	public AuthSerivice getAuthService();

	/* public SalesService getSalesService(); */

	public LoanAccountService getLoanService();

	public DownloadService getDownloadService();

	public ExpenseService getExpenseService();

	public FDAccountService getFdAccountService();

	public DashBoardService getDashBoardService();
}

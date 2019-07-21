package com.hgapp.dao;

public interface DaoManger {
	public CustDao getCustomerDao();

	/*
	 * public ItemDao getItemDao();
	 * 
	 * public SupplierDao getSupplierDao();
	 * 
	 * public PurchaseDao getPurchaseDao();
	 */
	public AuthDao getAuthDao();

	/* public SalesDao getSalesDao(); */

	public LoanAccountDao getLoanSectionDao();

	public UserRoleDao getUserRole();

	public ExpenseDao getExpenseDao();

	public FDAccountDao getFdAccountDao();

}

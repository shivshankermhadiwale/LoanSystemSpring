package com.hgapp.dao;

public interface DaoManger {
	public CustomerDao getCustomerDao();
/*
	public ItemDao getItemDao();

	public SupplierDao getSupplierDao();

	public PurchaseDao getPurchaseDao();
*/
	public AuthDao getAuthDao();

	/*public SalesDao getSalesDao();*/

	public LoanAmountDao getAmountDao();
}

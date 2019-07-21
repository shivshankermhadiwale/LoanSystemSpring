package com.hgapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.AuthDao;
import com.hgapp.dao.CustDao;
import com.hgapp.dao.DaoManger;
import com.hgapp.dao.ExpenseDao;
import com.hgapp.dao.FDAccountDao;
import com.hgapp.dao.LoanAccountDao;
import com.hgapp.dao.UserRoleDao;

@Repository
public class DaoMangerImpl implements DaoManger {
	@Autowired
	private CustDao custMasterDao;
	/*
	 * @Autowired private ItemDao itemDao;
	 */
	/*
	 * @Autowired private SupplierDao supplierDao;
	 * 
	 * @Autowired private PurchaseDao purchaseDao;
	 */

	@Autowired
	private AuthDao authDao;
	@Autowired
	private UserRoleDao userRole;
	/*
	 * @Autowired private SalesDao salesDao;
	 */
	@Autowired
	private LoanAccountDao loanSectionDao;

	@Autowired
	private ExpenseDao expenseDao;
	@Autowired
	private FDAccountDao fdAccountDao;

	/*
	 * public SalesDao getSalesDao() { return salesDao; }
	 * 
	 * public void setSalesDao(SalesDao salesDao) { this.salesDao = salesDao; }
	 */
	public AuthDao getAuthDao() {
		return authDao;
	}

	public void setAuthDao(AuthDao authDao) {
		this.authDao = authDao;
	}

	public CustDao getCustMasterDao() {
		return custMasterDao;
	}

	/*
	 * public PurchaseDao getPurchaseDao() { return purchaseDao; }
	 * 
	 * public void setCustMasterDao(CustomerDao custMasterDao) { this.custMasterDao
	 * = custMasterDao; }
	 * 
	 * public void setPurchaseDao(PurchaseDao purchaseDao) { this.purchaseDao =
	 * purchaseDao; }
	 * 
	 * public SupplierDao getSupplierDao() { return supplierDao; }
	 * 
	 * public void setSupplierDao(SupplierDao supplierDao) { this.supplierDao =
	 * supplierDao; }
	 */
	/*
	 * public ItemDao getItemDao() { return itemDao; }
	 * 
	 * public void setItemDao(ItemDao itemDao) { this.itemDao = itemDao; }
	 */

	public CustDao getCustomerDao() {
		return custMasterDao;
	}

	public void setCustomerDao(CustDao custMasterDao) {
		this.custMasterDao = custMasterDao;
	}

	public LoanAccountDao getLoanSectionDao() {
		return loanSectionDao;
	}

	public void setLoanSectionDao(LoanAccountDao loanSectionDao) {
		this.loanSectionDao = loanSectionDao;
	}

	public UserRoleDao getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleDao userRole) {
		this.userRole = userRole;
	}

	public ExpenseDao getExpenseDao() {
		return expenseDao;
	}

	public void setExpenseDao(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}

	public FDAccountDao getFdAccountDao() {
		return fdAccountDao;
	}

	public void setFdAccountDao(FDAccountDao fdAccountDao) {
		this.fdAccountDao = fdAccountDao;
	}
	

}

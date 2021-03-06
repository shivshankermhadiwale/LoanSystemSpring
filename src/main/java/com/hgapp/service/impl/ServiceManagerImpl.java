package com.hgapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgapp.service.AuthSerivice;
import com.hgapp.service.CustomerService;
import com.hgapp.service.DashBoardService;
import com.hgapp.service.DownloadService;
import com.hgapp.service.ExpenseService;
import com.hgapp.service.FDAccountService;
import com.hgapp.service.LoanAccountService;
import com.hgapp.service.ServiceManager;

@Service
public class ServiceManagerImpl implements ServiceManager {
	@Autowired
	private CustomerService customerService;
	/*
	 * @Autowired private ItemService itemService;
	 * 
	 * @Autowired private SupplierService supplierService;
	 * 
	 * @Autowired private PurchaseService purchaseService;
	 */
	@Autowired
	private AuthSerivice authService;
	/*
	 * @Autowired private SalesService salesService;
	 */
	@Autowired
	private LoanAccountService loanService;
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private FDAccountService fdAccountService;
	@Autowired
	private DashBoardService dashBoardService;

	/*
	 * public SalesService getSalesService() { return salesService; }
	 * 
	 * public void setSalesService(SalesService salesService) { this.salesService =
	 * salesService; }
	 */@Autowired
	private DownloadService downloadService;

	public AuthSerivice getAuthService() {
		return authService;
	}

	public void setAuthService(AuthSerivice authService) {
		this.authService = authService;
	}

	/*
	 * public PurchaseService getPurchaseService() { return purchaseService; }
	 * 
	 * public void setPurchaseService(PurchaseService purchaseService) {
	 * this.purchaseService= purchaseService; }
	 * 
	 * public ItemService getItemService() { return itemService; }
	 * 
	 * public SupplierService getSupplierService() { return supplierService; }
	 * 
	 * public void setSupplierService(SupplierService supplierService) {
	 * this.supplierService = supplierService; }
	 * 
	 * public void setItemService(ItemService itemService) { this.itemService =
	 * itemService; }
	 */

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustService(CustomerService custService) {
		this.customerService = custService;
	}

	public LoanAccountService getLoanService() {
		return loanService;
	}

	public void setLoanService(LoanAccountService loanService) {
		this.loanService = loanService;
	}

	public DownloadService getDownloadService() {
		return downloadService;
	}

	public void setDownloadService(DownloadService downloadService) {
		this.downloadService = downloadService;
	}

	public ExpenseService getExpenseService() {
		return expenseService;
	}

	public void setExpenseService(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	public FDAccountService getFdAccountService() {
		return fdAccountService;
	}

	public void setFdAccountService(FDAccountService fdAccountService) {
		this.fdAccountService = fdAccountService;
	}

	public DashBoardService getDashBoardService() {
		return dashBoardService;
	}

	public void setDashBoardService(DashBoardService dashBoardService) {
		this.dashBoardService = dashBoardService;
	}

}

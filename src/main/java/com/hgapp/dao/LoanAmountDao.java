package com.hgapp.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hgapp.entity.CustomerDetail;
import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;

public interface LoanAmountDao {
	public LoanAccountDetail createLoanNewAccount(LoanAccountDetail accountDetail);

	public Optional<LoanAccountDetail> getLoanAccountDetailByLoanId(Long loanAccid);

	public LoanInstallmentsDetail addPayment(LoanInstallmentsDetail emiDetail);

	public List<LoanInstallmentsDetail> getLoanInstallmentsByLoanId(LoanAccountDetail loanAccountDetail);

	public List<LoanAccountDetail> getLoanDetailByCustId(CustomerDetail custId);

	public int closeLoanAccount(String status, LocalDate lastUpdated, String remark, Long loanAccountNo);

	public List<LoanAccountDetail> getAllLoanAccount(String status);
}

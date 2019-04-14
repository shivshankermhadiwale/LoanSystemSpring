package com.dsoft.dao;

import java.util.List;
import java.util.Optional;

import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.LoanAccountDetail;
import com.dsoft.entity.LoanInstallmentsDetail;

public interface LoanAmountDao {
	public LoanAccountDetail createLoanNewAccount(LoanAccountDetail accountDetail);

	public Optional<LoanAccountDetail> getLoanAccountDetailByLoanId(Long loanAccid);

	public LoanInstallmentsDetail addPayment(LoanInstallmentsDetail emiDetail);

	public List<LoanInstallmentsDetail> getLoanInstallmentsByLoanId(LoanAccountDetail loanAccountDetail);

	public List<LoanAccountDetail> getLoanDetailByCustId(CustPersionalDetail custId);
}

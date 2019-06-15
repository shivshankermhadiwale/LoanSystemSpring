package com.hgapp.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hgapp.entity.CustDetail;
import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;
import com.hgapp.entity.LoanPenalty;

public interface LoanAccountDao {
	public LoanAccountDetail createLoanNewAccount(LoanAccountDetail accountDetail);

	public Optional<LoanAccountDetail> getLoanAccountDetailByLoanId(Long loanAccid);

	public LoanInstallmentsDetail addPayment(LoanInstallmentsDetail emiDetail);

	public List<LoanInstallmentsDetail> getLoanInstallmentsByLoanId(LoanAccountDetail loanAccountDetail);

	public List<LoanAccountDetail> getLoanDetailByCustId(CustDetail custId);

	public int closeLoanAccount(String status, LocalDate lastUpdated, String remark, Long loanAccountNo);

	public List<LoanAccountDetail> getAllLoanAccount(String status);

	public List<LoanInstallmentsDetail> getLoanInstallmentDetailsByPaymentDate(LocalDate paymentDate);

	public LoanPenalty addPenalty(LoanPenalty loanPenalty);

	public List<LoanPenalty> findDtlByLoanId(LoanAccountDetail accountDetail);
}

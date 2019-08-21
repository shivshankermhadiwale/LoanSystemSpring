package com.hgapp.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hgapp.entity.CustDetail;
import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;
import com.hgapp.entity.LoanPenalty;

public interface LoanAccountDao {
	public LoanAccountDetail saveOrUpdateLoanAccount(LoanAccountDetail accountDetail);

	public Optional<LoanAccountDetail> findByLoanId(Long loanAccid);

	public List<LoanAccountDetail> findCustId(CustDetail custId);

	public List<LoanAccountDetail> findByStatus(String status);

	public List<LoanAccountDetail> findByLoanStartDate(LocalDate loanStartDate);

	public int closeLoanAccount(String status, LocalDate lastUpdated, String remark, Long loanAccountNo);

	public LoanInstallmentsDetail saveOrUpdateEMI(LoanInstallmentsDetail emiDetail);

	public List<LoanInstallmentsDetail> findLoanEMIByFromDateAndToDate(LocalDate fromDate, LocalDate toDate);

	public List<LoanInstallmentsDetail> findEMIByLoanId(LoanAccountDetail loanAccountDetail);

	public List<LoanInstallmentsDetail> findEMIByLoanAccouuntNos(List<LoanAccountDetail> accountDetail);

	public List<LoanInstallmentsDetail> findEMIByPaymentDate(LocalDate paymentDate);

	public LoanPenalty saveOrUpdatePenalty(LoanPenalty loanPenalty);

	public List<LoanPenalty> findPendaltyByLoanId(LoanAccountDetail accountDetail);
}

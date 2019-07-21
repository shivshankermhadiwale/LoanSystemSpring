package com.hgapp.service;

import java.time.LocalDate;
import java.util.List;

import com.hgapp.dto.DashBoardRepo;
import com.hgapp.dto.LoanAccountDetailDto;
import com.hgapp.dto.LoanCollectionRepo;
import com.hgapp.dto.LoanEMIDetailDto;
import com.hgapp.dto.LoanPaymentDetailDto;
import com.hgapp.dto.LoanPenaltyDto;
import com.hgapp.dto.LoanRepoDto;

public interface LoanAccountService {
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail);

	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail);

	public LoanAccountDetailDto getLoanDetailByLoanId(Long loanAccountNo);

	public List<LoanAccountDetailDto> getLoanDetailByCustIdAndStatus(Long custId, String status);

	public List<LoanRepoDto> getLoanDisbursedByStatus(String status);

	public int closeLoanAccount(String status, String remark, Long loanAccountNo);

	public LoanPaymentDetailDto addLoanPaymentDtl(LoanPaymentDetailDto paymentDetailDto);

	public List<LoanRepoDto> getAllLoanAccount(String status);

	public DashBoardRepo getDashBoardData();

	public List<LoanPaymentDetailDto> getPendingLoanPayment();

	public List<LoanCollectionRepo> getTodayCollectionSummary();

	public LoanPenaltyDto addPenalty(LoanPenaltyDto loanPenaltyDto);

	public List<LoanPenaltyDto> findDtlByLoanId(Long accountId);

	public List<LoanCollectionRepo> getAllLoanInstallmentsByDate(LocalDate fromDate, LocalDate toDate);

}

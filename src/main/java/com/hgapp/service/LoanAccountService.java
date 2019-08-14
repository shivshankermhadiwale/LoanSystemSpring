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
	public LoanAccountDetailDto saveOrUpdateLoanAccount(LoanAccountDetailDto accountDetail);

	public LoanAccountDetailDto findByLoanId(Long loanAccountNo);

	public List<LoanRepoDto> findByStatus(String status);

	public List<LoanAccountDetailDto> findByCustIdAndStatus(Long custId, String status);

	public int closeLoanAccount(String status, String remark, Long loanAccountNo);

	public LoanEMIDetailDto saveOrUpdateEMI(LoanEMIDetailDto emiDetail);

	public List<LoanCollectionRepo> findLoanEMIByFromDateAndToDate(LocalDate fromDate, LocalDate toDate);

	public List<LoanCollectionRepo> findAllEMIByDaily();

	public LoanPaymentDetailDto saveOrUpdateLoanDisburserment(LoanPaymentDetailDto paymentDetailDto);

	public List<LoanRepoDto> findLoanDisbursementByStatus(String status);

	public List<LoanPaymentDetailDto> findPendingDisbursements();

	public LoanPenaltyDto saveOrUpdatePenalty(LoanPenaltyDto loanPenaltyDto);

	public List<LoanPenaltyDto> findPendaltyByLoanId(Long accountId);

	public DashBoardRepo getDashBoardData();

}

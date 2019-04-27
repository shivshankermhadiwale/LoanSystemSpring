package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.LoanAccountDetailDto;
import com.hgapp.dto.LoanEMIDetailDto;
import com.hgapp.dto.LoanRepoDto;

public interface LoanAmountService {
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail);

	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail);

	public LoanAccountDetailDto getLoanDetailByLoanId(Long loanAccountNo);

	public List<LoanAccountDetailDto> getLoanDetailByCustIdAndStatus(Long custId, String status);
	
	public int closeLoanAccount(String status,String remark,Long loanAccountNo);
	
	public List<LoanRepoDto> getAllLoanAccount(String status);
}

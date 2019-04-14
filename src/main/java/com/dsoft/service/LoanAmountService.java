package com.dsoft.service;

import java.util.List;

import com.dsoft.dto.LoanAccountDetailDto;
import com.dsoft.dto.LoanEMIDetailDto;

public interface LoanAmountService {
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail);

	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail);

	public LoanAccountDetailDto getLoanDetailByLoanId(Long loanAccountNo);

	public List<LoanAccountDetailDto> getLoanDetailByCustIdAndStatus(Long custId, String status);
}

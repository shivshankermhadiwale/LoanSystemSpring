package com.dsoft.service;

import com.dsoft.dto.LoanAccountDetailDto;
import com.dsoft.dto.LoanEMIDetailDto;

public interface LoanAmountService {
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail);

	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail);
}

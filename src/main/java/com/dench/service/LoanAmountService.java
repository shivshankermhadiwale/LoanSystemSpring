package com.dench.service;

import com.dench.dto.LoanAccountDetailDto;
import com.dench.dto.LoanEMIDetailDto;

public interface LoanAmountService {
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail);

	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail);
}

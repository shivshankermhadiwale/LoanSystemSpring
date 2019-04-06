package com.dench.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dench.dto.LoanAccountDetailDto;
import com.dench.dto.LoanEMIDetailDto;
import com.dench.entity.CustPersionalDetail;
import com.dench.entity.LoanAccountDetail;
import com.dench.service.DaoServicess;
import com.dench.service.LoanAmountService;

@Service
public class LoanAmountServiceImpl extends DaoServicess implements LoanAmountService {

	@Override
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail) {
		Optional<CustPersionalDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(Long.valueOf(accountDetail.getCustId()));
		if (!custPersionalDetail.isPresent())
			throw new NullPointerException("Customer Not Found");
		LoanAccountDetail loanAccountDetail = new LoanAccountDetail();
		loanAccountDetail.setCustId(custPersionalDetail.get());
		loanAccountDetail.setEmiAmount(accountDetail.getEmiAmount());
		loanAccountDetail.setEmiStartDate(accountDetail.getEmiStartDate());
		loanAccountDetail.setLoanDate(accountDetail.getLoanDate());
		loanAccountDetail.setLoanInterest(accountDetail.getLoanInterest());
		loanAccountDetail.setLoanTenureInMonths(accountDetail.getLoanTenureInMonths());
		loanAccountDetail.setLoanTenureInYears(accountDetail.getLoanTenureInYears());
		loanAccountDetail.setPrincipalAmount(Double.valueOf(accountDetail.getPrincipalAmount()));
		this.getDaoManager().getAmountDao().createLoanNewAccount(loanAccountDetail);
		return accountDetail;
	}

	@Override
	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.dsoft.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dsoft.dto.LoanAccountDetailDto;
import com.dsoft.dto.LoanEMIDetailDto;
import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.LoanAccountDetail;
import com.dsoft.service.DaoServicess;
import com.dsoft.service.LoanAmountService;

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
		loanAccountDetail.setInstallmentAmount(accountDetail.getEmiAmount());
		loanAccountDetail.setInstallmentSartDate(accountDetail.getEmiStartDate());
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

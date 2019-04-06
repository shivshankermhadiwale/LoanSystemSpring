package com.dench.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.LoanAmountDao;
import com.dench.entity.LoanAccountDetail;
import com.dench.entity.LoanEMIDetail;
import com.dench.repositories.LoanAccountDetailRepo;
import com.dench.repositories.LoanEMIDetailRepo;

@Repository
public class LoanAmountDaoImpl implements LoanAmountDao {

	@Autowired
	LoanAccountDetailRepo loanAccountDetailRepo;
	@Autowired
	LoanEMIDetailRepo loandEMIDetailRepo;

	@Override
	public LoanAccountDetail createLoanNewAccount(LoanAccountDetail accountDetail) {
		return loanAccountDetailRepo.save(accountDetail);
	}

	@Override
	public LoanEMIDetail addPayment(LoanEMIDetail emiDetail) {
		return loandEMIDetailRepo.save(emiDetail);
	}

}

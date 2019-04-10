package com.dsoft.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsoft.dao.LoanAmountDao;
import com.dsoft.entity.LoanAccountDetail;
import com.dsoft.entity.LoanEMIDetail;
import com.dsoft.repositories.LoanAccountDetailRepo;
import com.dsoft.repositories.LoanEMIDetailRepo;

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

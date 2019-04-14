package com.dsoft.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsoft.dao.LoanAmountDao;
import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.LoanAccountDetail;
import com.dsoft.entity.LoanInstallmentsDetail;
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
	public LoanInstallmentsDetail addPayment(LoanInstallmentsDetail emiDetail) {
		return loandEMIDetailRepo.save(emiDetail);
	}

	@Override
	public List<LoanAccountDetail> getLoanDetailByCustId(CustPersionalDetail custId) {
		return loanAccountDetailRepo.findByCustId(custId);
	}

	@Override
	public Optional<LoanAccountDetail> getLoanAccountDetailByLoanId(Long loanAccid) {
		return loanAccountDetailRepo.findById(loanAccid);
	}

	@Override
	public List<LoanInstallmentsDetail> getLoanInstallmentsByLoanId(LoanAccountDetail loanAccountDetail) {
		return loandEMIDetailRepo.getLoanInstallmentsByLoanAccouuntNo(loanAccountDetail);
	}

}

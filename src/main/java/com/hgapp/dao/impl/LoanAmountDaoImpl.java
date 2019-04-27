package com.hgapp.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.LoanAmountDao;
import com.hgapp.entity.CustomerDetail;
import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;
import com.hgapp.repositories.LoanAccountDetailRepo;
import com.hgapp.repositories.LoanEMIDetailRepo;

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
	public List<LoanAccountDetail> getLoanDetailByCustId(CustomerDetail custId) {
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

	@Override
	public int closeLoanAccount(String status, LocalDate lastUpdated, String remark, Long loanAccountNo) {
		return loanAccountDetailRepo.closeLoanAccount(status, lastUpdated, remark, loanAccountNo);
	}

	@Override
	public List<LoanAccountDetail> getAllLoanAccount(String status) {
		if(status.equalsIgnoreCase("All"))
			return (List<LoanAccountDetail>) loanAccountDetailRepo.findAll();
			else
				return loanAccountDetailRepo.findByLoanStatus(status);
	}

}

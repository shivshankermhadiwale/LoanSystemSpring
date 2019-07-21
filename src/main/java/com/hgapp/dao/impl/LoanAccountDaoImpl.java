package com.hgapp.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.LoanAccountDao;
import com.hgapp.entity.CustDetail;
import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;
import com.hgapp.entity.LoanPenalty;
import com.hgapp.repositories.LoanAccountDetailRepo;
import com.hgapp.repositories.LoanEMIDetailRepo;
import com.hgapp.repositories.LoanPenaltyRepo;

@Repository
public class LoanAccountDaoImpl implements LoanAccountDao {

	@Autowired
	LoanAccountDetailRepo loanAccountDetailRepo;
	@Autowired
	LoanEMIDetailRepo loandEMIDetailRepo;
	@Autowired
	LoanPenaltyRepo loanPenaltyRepo;

	@Override
	public LoanAccountDetail createLoanNewAccount(LoanAccountDetail accountDetail) {
		return loanAccountDetailRepo.save(accountDetail);
	}

	@Override
	public LoanInstallmentsDetail addPayment(LoanInstallmentsDetail emiDetail) {
		return loandEMIDetailRepo.save(emiDetail);
	}

	@Override
	public List<LoanAccountDetail> getLoanDetailByCustId(CustDetail custId) {
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
		if (status.equalsIgnoreCase("All"))
			return (List<LoanAccountDetail>) loanAccountDetailRepo.findAll();
		else
			return loanAccountDetailRepo.findByLoanStatus(status);
	}

	@Override
	public List<LoanInstallmentsDetail> getLoanInstallmentDetailsByPaymentDate(LocalDate paymentDate) {
		return loandEMIDetailRepo.getInstallmentDetailsByDate(paymentDate);
	}

	@Override
	public LoanPenalty addPenalty(LoanPenalty loanPenalty) {
		return loanPenaltyRepo.save(loanPenalty);
	}

	@Override
	public List<LoanPenalty> findDtlByLoanId(LoanAccountDetail accountDetail) {
		return loanPenaltyRepo.findByLoanAccountId(accountDetail);
	}

	@Override
	public List<LoanInstallmentsDetail> getAllLoanInstallmentsByDate(LocalDate fromDate, LocalDate toDate) {
		return loandEMIDetailRepo.findByPaymentDateBetween(fromDate, toDate);
	}
}

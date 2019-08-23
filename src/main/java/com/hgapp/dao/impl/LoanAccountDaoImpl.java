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
	public LoanAccountDetail saveOrUpdateLoanAccount(LoanAccountDetail accountDetail) {
		return loanAccountDetailRepo.save(accountDetail);
	}

	@Override
	public Optional<LoanAccountDetail> findByLoanId(Long loanAccid) {
		return loanAccountDetailRepo.findById(loanAccid);
	}

	@Override
	public List<LoanAccountDetail> findCustId(CustDetail custId) {
		return loanAccountDetailRepo.findByCustId(custId);
	}

	@Override
	public List<LoanAccountDetail> findByStatus(String status) {
		if (status.equalsIgnoreCase("All"))
			return (List<LoanAccountDetail>) loanAccountDetailRepo.findAll();
		else
			return loanAccountDetailRepo.findByLoanStatus(status);
	}

	@Override
	public int closeLoanAccount(String status, LocalDate lastUpdated, String remark, Long loanAccountNo) {
		return loanAccountDetailRepo.closeLoanAccount(status, lastUpdated, remark, loanAccountNo);
	}

	@Override
	public LoanInstallmentsDetail saveOrUpdateEMI(LoanInstallmentsDetail emiDetail) {
		return loandEMIDetailRepo.save(emiDetail);
	}

	@Override
	public List<LoanInstallmentsDetail> findEMIByLoanId(LoanAccountDetail loanAccountDetail) {
		return loandEMIDetailRepo.getLoanInstallmentsByLoanAccouuntNo(loanAccountDetail);
	}

	@Override
	public List<LoanInstallmentsDetail> findLoanEMIByFromDateAndToDate(LocalDate fromDate, LocalDate toDate) {
		return loandEMIDetailRepo.findByPaymentDateBetween(fromDate, toDate);
	}

	@Override
	public List<LoanInstallmentsDetail> findEMIByLoanAccouuntNos(List<LoanAccountDetail> accountDetail) {
		return loandEMIDetailRepo.findLoanInstallmentsByLoanAccouuntNoIn(accountDetail);
	}

	@Override
	public List<LoanInstallmentsDetail> findEMIByPaymentDate(LocalDate paymentDate) {
		return loandEMIDetailRepo.getInstallmentDetailsByDate(paymentDate);
	}

	@Override
	public LoanPenalty saveOrUpdatePenalty(LoanPenalty loanPenalty) {
		return loanPenaltyRepo.save(loanPenalty);
	}

	@Override
	public List<LoanPenalty> findPendaltyByLoanId(LoanAccountDetail accountDetail) {
		return loanPenaltyRepo.findByLoanAccountId(accountDetail);
	}

	@Override
	public List<LoanAccountDetail> findByLoanStartDate(LocalDate loanStartDate) {
		return loanAccountDetailRepo.findByLoanStartDate(loanStartDate);
	}

	@Override
	public List<LoanPenalty> findPenaltyByLoanAccountIdIn(List<LoanAccountDetail> accountDetail) {
		return loanPenaltyRepo.findByLoanAccountIdIn(accountDetail);
	}

}

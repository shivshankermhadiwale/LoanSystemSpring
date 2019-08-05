package com.hgapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.FDAccountDao;
import com.hgapp.entity.CustDetail;
import com.hgapp.entity.FDAccount;
import com.hgapp.entity.FDInterest;
import com.hgapp.repositories.FDAccountRepo;
import com.hgapp.repositories.FDInterestRepo;

@Repository
public class FDAccountDaoImpl implements FDAccountDao {
	@Autowired
	FDAccountRepo fdAccountRepo;
	@Autowired
	FDInterestRepo fdInterestRepo;

	@Override
	public FDAccount createNewFDAccount(FDAccount fdAccount) {
		return this.fdAccountRepo.save(fdAccount);
	}

	@Override
	public Optional<FDAccount> getFDAccountDtlByAccountId(Long accountNo) {
		return this.fdAccountRepo.findById(accountNo);
	}

	@Override
	public Iterable<FDAccount> getAllFDAccounts() {
		return this.fdAccountRepo.findAll();
	}

	@Override
	public List<FDAccount> findByIsActive(Byte isActive) {
		return this.fdAccountRepo.findByIsActive(isActive);
	}

	@Override
	public FDInterest addFDInterest(FDInterest fdInterest) {
		return this.fdInterestRepo.save(fdInterest);
	}

	@Override
	public List<FDInterest> getPaidInterest(FDAccount fdAccountId) {
		return fdInterestRepo.findByFdAccountId(fdAccountId);
	}

	@Override
	public List<FDAccount> getCustomerFdByCustId(CustDetail custDetail) {
		return fdAccountRepo.findByCustId(custDetail);
	}

}

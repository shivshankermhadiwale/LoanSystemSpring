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
	public FDAccount saveOrUpdateFDAccount(FDAccount fdAccount) {
		return this.fdAccountRepo.save(fdAccount);
	}

	@Override
	public Optional<FDAccount> findByAccountId(Long accountNo) {
		return this.fdAccountRepo.findById(accountNo);
	}

	@Override
	public List<FDAccount> findByCustId(CustDetail custDetail) {
		return fdAccountRepo.findByCustId(custDetail);
	}

	@Override
	public List<FDAccount> findByIsActive(Byte isActive) {
		return this.fdAccountRepo.findByIsActive(isActive);
	}

	@Override
	public Iterable<FDAccount> findAllFDAccounts() {
		return this.fdAccountRepo.findAll();
	}

	@Override
	public FDInterest saveOrUpdateInterest(FDInterest fdInterest) {
		return this.fdInterestRepo.save(fdInterest);
	}

	@Override
	public List<FDInterest> findPaidInterestByFdAccountNo(FDAccount fdAccountId) {
		return fdInterestRepo.findByFdAccountId(fdAccountId);
	}

	@Override
	public List<FDInterest> findPaidInterestByFdAccountNos(List<FDAccount> fdAccountId) {
		return fdInterestRepo.findByFdAccountIdIn(fdAccountId);
	}

}

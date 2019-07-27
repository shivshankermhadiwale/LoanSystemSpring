package com.hgapp.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.FDAccountDao;
import com.hgapp.entity.FDAccount;
import com.hgapp.repositories.FDAccountRepo;

@Repository
public class FDAccountDaoImpl implements FDAccountDao{
	@Autowired
	FDAccountRepo fdAccountRepo;

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

}

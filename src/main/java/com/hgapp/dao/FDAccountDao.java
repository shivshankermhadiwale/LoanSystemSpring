package com.hgapp.dao;

import java.util.List;
import java.util.Optional;

import com.hgapp.entity.CustDetail;
import com.hgapp.entity.FDAccount;
import com.hgapp.entity.FDInterest;

public interface FDAccountDao {
	public FDAccount saveOrUpdateFDAccount(FDAccount fdAccount);

	public Optional<FDAccount> findByAccountId(Long accountNo);

	public List<FDAccount> findByCustId(CustDetail custDetail);

	public Iterable<FDAccount> findAllFDAccounts();

	public List<FDAccount> findByIsActive(Byte isActive);

	public FDInterest saveOrUpdateInterest(FDInterest fdInterest);

	public List<FDInterest> findPaidInterestByFdAccountNo(FDAccount fdAccountId);

}

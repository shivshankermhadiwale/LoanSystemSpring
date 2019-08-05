package com.hgapp.dao;

import java.util.List;
import java.util.Optional;

import com.hgapp.entity.CustDetail;
import com.hgapp.entity.FDAccount;
import com.hgapp.entity.FDInterest;

public interface FDAccountDao {
	public FDAccount createNewFDAccount(FDAccount fdAccount);

	public Optional<FDAccount> getFDAccountDtlByAccountId(Long accountNo);

	public Iterable<FDAccount> getAllFDAccounts();

	public List<FDAccount> findByIsActive(Byte isActive);

	public FDInterest addFDInterest(FDInterest fdInterest);

	public List<FDInterest> getPaidInterest(FDAccount fdAccountId);
	
	public List<FDAccount> getCustomerFdByCustId(CustDetail custDetail);

}

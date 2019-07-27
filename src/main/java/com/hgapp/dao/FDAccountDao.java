package com.hgapp.dao;

import java.util.List;
import java.util.Optional;

import com.hgapp.entity.FDAccount;

public interface FDAccountDao {
	public FDAccount createNewFDAccount(FDAccount fdAccount);

	public Optional<FDAccount> getFDAccountDtlByAccountId(Long accountNo);

	public Iterable<FDAccount> getAllFDAccounts();

	public List<FDAccount> findByIsActive(Byte isActive);

}

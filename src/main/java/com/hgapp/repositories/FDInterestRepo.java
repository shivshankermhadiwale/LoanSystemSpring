package com.hgapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.FDAccount;
import com.hgapp.entity.FDInterest;

public interface FDInterestRepo extends CrudRepository<FDInterest, Long> {
	public List<FDInterest> findByFdAccountId(FDAccount fdAccountId);

	public List<FDInterest> findByFdAccountIdIn(List<FDAccount> fdAccountId);
}

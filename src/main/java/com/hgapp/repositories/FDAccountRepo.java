package com.hgapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.FDAccount;

public interface FDAccountRepo extends CrudRepository<FDAccount, Long> {
	public List<FDAccount> findByIsActive(Byte isActive);

}

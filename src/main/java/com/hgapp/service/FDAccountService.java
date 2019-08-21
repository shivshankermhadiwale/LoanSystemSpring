package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.FDAccountDto;
import com.hgapp.dto.FDInterestDto;
import com.hgapp.entity.CustDetail;

public interface FDAccountService {
	public FDAccountDto saveorUpdateFDAccount(FDAccountDto fdAccountDto);

	public List<FDAccountDto> findByIsActive(Byte isActive);

	public List<FDAccountDto> findByCustId(Long custId);

	public List<CustDetail> findAllFDHolders();

	public FDAccountDto findByAccountId(Long accountNo);

	public FDAccountDto closeAccount(FDAccountDto fdAccountDto);

	public FDInterestDto saveOrUpdateInterest(FDInterestDto fdInterestDto);

}

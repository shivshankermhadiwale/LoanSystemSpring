package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.FDAccountDto;

public interface FDAccountService {
	public FDAccountDto createNewFDAccount(FDAccountDto fdAccountDto);

	public FDAccountDto closeFDAccount(FDAccountDto fdAccountDto);

	public FDAccountDto getFDAccountDtlByAccountId(Long accountNo);

	public List<FDAccountDto> findFDByStatus(Byte isActive);


}

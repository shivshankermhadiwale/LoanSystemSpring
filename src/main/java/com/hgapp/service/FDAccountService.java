package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.FDAccountDto;
import com.hgapp.dto.FDInterestDto;

public interface FDAccountService {
	public FDAccountDto createNewFDAccount(FDAccountDto fdAccountDto);

	public FDAccountDto closeFDAccount(FDAccountDto fdAccountDto);

	public FDAccountDto getFDAccountDtlByAccountId(Long accountNo);

	public List<FDAccountDto> findFDByStatus(Byte isActive);

	public FDInterestDto addFDInterstAmt(FDInterestDto fdInterestDto);

	public List<FDAccountDto> getCustomerAllFD(Long custId);

}

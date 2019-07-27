package com.hgapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hgapp.dto.FDAccountDto;
import com.hgapp.entity.CustDetail;
import com.hgapp.entity.FDAccount;
import com.hgapp.exception.RecordNotFound;
import com.hgapp.service.DaoServicess;
import com.hgapp.service.FDAccountService;

@Service
public class FDAccountServiceImpl extends DaoServicess implements FDAccountService {

	@Override
	public FDAccountDto createNewFDAccount(FDAccountDto fdAccountDto) {
		Optional<CustDetail> custDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(fdAccountDto.getCustId());
		if (!custDetail.isPresent())
			throw new RecordNotFound("customer not found");
		FDAccount fdAccount = new FDAccount();
		fdAccount.setCustId(custDetail.get());
		fdAccount.setAmount(fdAccountDto.getAmount());
		fdAccount.setStartDate(fdAccountDto.getStartDate());
		fdAccount.setEndDate(fdAccountDto.getEndDate());
		fdAccount.setIterest(fdAccountDto.getInterest());
		fdAccount.setIterestAmt(fdAccountDto.getInterestAmt());
		fdAccount.setIsActive((byte) 1);
		fdAccount = this.getDaoManager().getFdAccountDao().createNewFDAccount(fdAccount);
		fdAccountDto.setAccountNo(fdAccount.getAccountNo());
		return fdAccountDto;
	}

	@Override
	public FDAccountDto getFDAccountDtlByAccountId(Long accountNo) {
		Optional<FDAccount> fdAccount = this.getDaoManager().getFdAccountDao().getFDAccountDtlByAccountId(accountNo);
		if (!fdAccount.isPresent())
			throw new RecordNotFound("FD Account Not Found");
		FDAccountDto fdAccountDto = new FDAccountDto();
		fdAccountDto.setAccountNo(fdAccount.get().getAccountNo());
		fdAccountDto.setCustName(fdAccount.get().getCustId().getFullName());
		fdAccountDto.setAmount(fdAccount.get().getAmount());
		fdAccountDto.setInterest(fdAccount.get().getIterest());
		fdAccountDto.setInterestAmt(fdAccount.get().getIterestAmt());
		fdAccountDto.setStartDate(fdAccount.get().getStartDate());
		fdAccountDto.setEndDate(fdAccount.get().getEndDate());
		fdAccountDto.setCustId(fdAccount.get().getCustId().getCustId());
		fdAccountDto.setClosingDate(fdAccount.get().getClosingDate());
		fdAccountDto.setRemark(fdAccount.get().getRemark());
		if (fdAccount.get().getIsActive() == 1)
			fdAccountDto.setIsActive("Active");
		else
			fdAccountDto.setIsActive("Closed");
		return fdAccountDto;
	}

	@Override
	public List<FDAccountDto> findFDByStatus(Byte isActive) {
		List<FDAccount> fdAccounts = null;
		if(isActive==null) 
			throw new NullPointerException("isActive not be null");
		if (isActive == 2)
			fdAccounts = (List<FDAccount>) this.getDaoManager().getFdAccountDao().getAllFDAccounts();
		else
			fdAccounts = this.getDaoManager().getFdAccountDao().findByIsActive(isActive);
		if (null != fdAccounts && fdAccounts.size() <0)
			throw new RecordNotFound("list is empty");
		List<FDAccountDto> accountDtos = fdAccounts.stream().map(fdAccount -> {
			FDAccountDto accountDto = new FDAccountDto();
			accountDto.setAccountNo(fdAccount.getAccountNo());
			accountDto.setCustName(fdAccount.getCustId().getFullName());
			accountDto.setAmount(fdAccount.getAmount());
			accountDto.setInterest(fdAccount.getIterest());
			accountDto.setInterestAmt(fdAccount.getIterestAmt());
			accountDto.setStartDate(fdAccount.getStartDate());
			accountDto.setEndDate(fdAccount.getEndDate());
			accountDto.setClosingDate(fdAccount.getClosingDate());
			return accountDto;
		}).collect(Collectors.toList());
		return accountDtos;
	}

	@Override
	public FDAccountDto closeFDAccount(FDAccountDto fdAccountDto) {
		Optional<FDAccount> fdAccount = this.getDaoManager().getFdAccountDao()
				.getFDAccountDtlByAccountId(fdAccountDto.getAccountNo());
		if (!fdAccount.isPresent())
			throw new RecordNotFound("FD Account Not Exist");
		fdAccount.get().setIterestAmt(fdAccountDto.getInterestAmt());
		fdAccount.get().setIterest(fdAccountDto.getInterest());
		fdAccount.get().setClosingDate(LocalDate.now());
		fdAccount.get().setRemark(fdAccountDto.getRemark());
		fdAccount.get().setIsActive((byte) 0);
		this.getDaoManager().getFdAccountDao().createNewFDAccount(fdAccount.get());
		return fdAccountDto;
	}

}

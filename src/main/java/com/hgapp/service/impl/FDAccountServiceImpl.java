package com.hgapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hgapp.dto.FDAccountDto;
import com.hgapp.dto.FDInterestDto;
import com.hgapp.entity.CustDetail;
import com.hgapp.entity.FDAccount;
import com.hgapp.entity.FDInterest;
import com.hgapp.exception.RecordNotFound;
import com.hgapp.service.DaoServicess;
import com.hgapp.service.FDAccountService;
import com.hgapp.utils.DateUtils;

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
		// fdAccount.setIterestAmt(fdAccountDto.getInterestAmt());
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
		List<FDInterest> fdInterests = this.getDaoManager().getFdAccountDao().getPaidInterest(fdAccount.get());
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

		if (fdInterests != null && fdInterests.size() > 0) {
			FDInterest latestPaidInterest = fdInterests.get(fdInterests.size() - 1);
			fdAccountDto.setInterstPayFrom(latestPaidInterest.getToDate().plusDays(1));
			List<FDInterestDto> fdInterestDtos = fdInterests.stream().map(fdInterestDtl -> {
				FDInterestDto fdInterestDto = new FDInterestDto();
				fdInterestDto.setFromDate(fdInterestDtl.getFromDate());
				fdInterestDto.setToDate(fdInterestDtl.getToDate());
				fdInterestDto.setInterestAmt(fdInterestDtl.getPaidInterest());
				fdInterestDto.setPaidDate(fdInterestDtl.getPaidDate());
				return fdInterestDto;
			}).collect(Collectors.toList());
			fdAccountDto.setPaidInterestHistory(fdInterestDtos);

		}
		if (fdAccountDto.getInterstPayFrom() == null)
			fdAccountDto.setInterstPayFrom(fdAccountDto.getStartDate());

		fdAccountDto.setPendingMonthsOfInterest(
				DateUtils.getMontDifference(fdAccountDto.getInterstPayFrom(), LocalDate.now()));
		if (fdAccountDto.getPendingMonthsOfInterest() > 0) {
			fdAccountDto.setPendingInterestAmt(this.calculateInterestAmt(fdAccountDto.getAmount(),
					fdAccountDto.getInterest(), fdAccountDto.getPendingMonthsOfInterest()));
			fdAccountDto.setInterestPayTo(
					fdAccountDto.getInterstPayFrom().plusMonths(fdAccountDto.getPendingMonthsOfInterest()));
		} else
			fdAccountDto.setInterestPayTo(fdAccountDto.getInterstPayFrom()
					.plusDays(DateUtils.getDays(fdAccountDto.getInterstPayFrom(), LocalDate.now())));
		return fdAccountDto;
	}

	@Override
	public List<FDAccountDto> findFDByStatus(Byte isActive) {
		List<FDAccount> fdAccounts = null;
		if (isActive == null)
			throw new NullPointerException("isActive not be null");
		if (isActive == 2)
			fdAccounts = (List<FDAccount>) this.getDaoManager().getFdAccountDao().getAllFDAccounts();
		else
			fdAccounts = this.getDaoManager().getFdAccountDao().findByIsActive(isActive);
		if (null != fdAccounts && fdAccounts.size() < 0)
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
		// fdAccount.get().setIterestAmt(fdAccountDto.getInterestAmt());
		// fdAccount.get().setIterest(fdAccountDto.getInterest());
		fdAccount.get().setClosingDate(LocalDate.now());
		fdAccount.get().setRemark(fdAccountDto.getRemark());
		fdAccount.get().setIsActive((byte) 0);
		this.getDaoManager().getFdAccountDao().createNewFDAccount(fdAccount.get());
		return fdAccountDto;
	}

	@Override
	public FDInterestDto addFDInterstAmt(FDInterestDto fdInterestDto) {
		Optional<FDAccount> fdAccount = this.getDaoManager().getFdAccountDao()
				.getFDAccountDtlByAccountId(fdInterestDto.getFdAccountId());
		if (!fdAccount.isPresent())
			throw new RecordNotFound("FD Account Not Exist");
		if (fdAccount.get().getIterestAmt() != null)
			fdAccount.get().setIterestAmt(fdInterestDto.getInterestAmt() + fdAccount.get().getIterestAmt());
		else
			fdAccount.get().setIterestAmt(fdInterestDto.getInterestAmt());
		FDInterest fdInterest = new FDInterest();
		fdInterest.setFdAccountId(fdAccount.get());
		fdInterest.setPaidInterest(fdInterestDto.getInterestAmt());
		fdInterest.setFromDate(fdInterestDto.getFromDate());
		fdInterest.setToDate(fdInterestDto.getToDate());
		fdInterest.setPaidDate(LocalDate.now());
		fdInterest.setPaidMode(fdInterestDto.getPaidMode());
		this.getDaoManager().getFdAccountDao().createNewFDAccount(fdAccount.get());
		fdInterest = this.getDaoManager().getFdAccountDao().addFDInterest(fdInterest);
		fdInterestDto.setInterestId(fdInterest.getInterestId());
		fdInterestDto.setPaidDate(fdInterest.getPaidDate());
		return fdInterestDto;
	}

	private Double calculateInterestAmt(double amount, float interest, int months) {
		Double montlyInterest = (amount / 100) * interest;
		return months * montlyInterest;
	}

	@Override
	public List<FDAccountDto> getCustomerAllFD(Long custId) {
		Optional<CustDetail> custDetail = this.getDaoManager().getCustomerDao().findCustomerDetailById(custId);
		if (!custDetail.isPresent())
			throw new RecordNotFound("Customer Not Found");
		List<FDAccount> fdAccounts = this.getDaoManager().getFdAccountDao().getCustomerFdByCustId(custDetail.get());
		if (fdAccounts != null && fdAccounts.size() > 0) {
			List<FDAccountDto> accountDtos = fdAccounts.stream().map(fdaccountdtl -> {
				FDAccountDto accountDto = new FDAccountDto();
				accountDto.setAccountNo(fdaccountdtl.getAccountNo());
				accountDto.setAmount(fdaccountdtl.getAmount());
				accountDto.setInterest(fdaccountdtl.getIterest());
				accountDto.setStartDate(fdaccountdtl.getStartDate());
				accountDto.setEndDate(fdaccountdtl.getEndDate());
				accountDto.setInterestAmt(fdaccountdtl.getIterestAmt());
				accountDto.setClosingDate(fdaccountdtl.getClosingDate());
				if (fdaccountdtl.getIsActive() == 1)
					accountDto.setIsActive("Active");
				else
					accountDto.setIsActive("Closed");
				return accountDto;
			}).collect(Collectors.toList());
			return accountDtos;
		}
		return null;
	}

}

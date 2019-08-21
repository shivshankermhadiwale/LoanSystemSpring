package com.hgapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hgapp.dto.DashBoardRepo;
import com.hgapp.entity.FDAccount;
import com.hgapp.entity.FDInterest;
import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.service.DaoServicess;
import com.hgapp.service.DashBoardService;

@Service
public class DashBoardServiceImpl extends DaoServicess implements DashBoardService {

	@Override
	public DashBoardRepo getDashBoardData() {
		DashBoardRepo dashBoardRepo = new DashBoardRepo();
		List<LoanAccountDetail> accountDetails = this.getDaoManager().getLoanSectionDao().findByStatus("Opened");
		/*
		 * List<LoanInstallmentsDetail> installmentsDetails =
		 * this.getDaoManager().getLoanSectionDao()
		 * .findEMIByLoanAccouuntNos(accountDetails);
		 */
		Double totalOpenedLoanCollection = accountDetails.stream()
				.filter(totalCollection -> totalCollection.getTotalCollection() != null)
				.mapToDouble(totalCollection -> totalCollection.getTotalCollection()).sum();
		Long count = accountDetails.stream().collect(Collectors.counting());
		Double totalPrinceAmount = accountDetails.stream()
				.mapToDouble(princeAmount -> princeAmount.getPrincipalAmount()).sum();
		Double totalDisburesment = accountDetails.stream()
				.filter(disburseAmount -> disburseAmount.getDisburseAmt() != null)
				.mapToDouble(disburseAmount -> disburseAmount.getDisburseAmt()).sum();
		dashBoardRepo.setPendingDisbursement((double) 0);
		accountDetails.forEach(accountDetail -> {
			if (accountDetail.getDisburseAmt() == null)
				accountDetail.setDisburseAmt((double) 0);
			dashBoardRepo.setPendingDisbursement(dashBoardRepo.getPendingDisbursement()
					+ (accountDetail.getLoanAmt() - accountDetail.getDisburseAmt()));
		});
		/*
		 * Double todayCollection = installmentsDetails.stream()
		 * .mapToDouble(installmentsDetail ->
		 * installmentsDetail.getPaymentAmount()).sum();
		 */
		// if (installmentsDetails != null && installmentsDetails.size() > 0)
		// dashBoardRepo.setTodayTotalCollection(todayCollection);
		dashBoardRepo.setTotalOpenedLoanAccount(count);
		dashBoardRepo.setTotalActiveLoanCollection(totalOpenedLoanCollection);
		dashBoardRepo.setTotalRunningLoanAmt(totalPrinceAmount);
		dashBoardRepo.setTotalDisburesements(totalDisburesment);
		
		// dashBoardRepo.setPendingCollections(totalRunningLoanAmt -
		// totalOpenedLoanCollection);
		List<FDAccount> fdAccounts = this.getDaoManager().getFdAccountDao().findByIsActive((byte) 1);
		List<FDInterest> fdInterests = this.getDaoManager().getFdAccountDao()
				.findPaidInterestByFdAccountNos(fdAccounts);
		Long totalFdAccounts = fdAccounts.stream().collect(Collectors.counting());
		Double totalFdAmount = fdAccounts.stream().mapToDouble(fdAccount -> fdAccount.getAmount()).sum();
		Double fdPaidInterest = fdInterests.stream().mapToDouble(fdInterest -> fdInterest.getPaidInterest()).sum();
		dashBoardRepo.setFdPaidInterest(fdPaidInterest);
		dashBoardRepo.setTotalFdAmount(totalFdAmount);
		dashBoardRepo.setTotalActiveFdAcc(totalFdAccounts);
		
		return dashBoardRepo;
	}

}

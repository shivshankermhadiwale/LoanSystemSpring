package com.hgapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hgapp.dto.DashBoardRepo;
import com.hgapp.dto.LoanAccountDetailDto;
import com.hgapp.dto.LoanCollectionRepo;
import com.hgapp.dto.LoanEMIDetailDto;
import com.hgapp.dto.LoanPaymentDetailDto;
import com.hgapp.dto.LoanPenaltyDto;
import com.hgapp.dto.LoanRepoDto;
import com.hgapp.entity.CustDetail;
import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;
import com.hgapp.entity.LoanPenalty;
import com.hgapp.exception.RecordNotFound;
import com.hgapp.service.DaoServicess;
import com.hgapp.service.LoanAccountService;

@Transactional
@Service
public class LoanAccountServiceImpl extends DaoServicess implements LoanAccountService {

	@Override
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail) {
		Optional<CustDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(Long.valueOf(accountDetail.getCustId()));
		if (!custPersionalDetail.isPresent())
			throw new RecordNotFound("Customer Not Found");
		LoanAccountDetail loanAccountDetail = new LoanAccountDetail();
		loanAccountDetail.setCustId(custPersionalDetail.get());
		loanAccountDetail.setPrincipalAmount(accountDetail.getPrincipalAmount());
		loanAccountDetail.setInterest(accountDetail.getInterest());
		loanAccountDetail.setInterestAmt(accountDetail.getInterestAmt());
		loanAccountDetail.setDepositeAmt(accountDetail.getDepositeAmt());
		loanAccountDetail.setProcessingFees(accountDetail.getProcessingFees());
		loanAccountDetail.setLoanAmt(accountDetail.getLoanAmt());
		loanAccountDetail.setLoanStartDate(accountDetail.getLoanStartDate());
		loanAccountDetail.setLoanEndDate(accountDetail.getLoanEndDate());
		loanAccountDetail.setInstallMentType(accountDetail.getInstallMentType());
		loanAccountDetail.setInstallments(accountDetail.getInstallments());
		loanAccountDetail.setInstallmentAmount(accountDetail.getInstallmentAmount());
		loanAccountDetail.setLastUpdated(LocalDate.now());
		loanAccountDetail.setLoanStatus("Opened");
		LoanAccountDetail createdAccountDetail = this.getDaoManager().getLoanSectionDao()
				.createLoanNewAccount(loanAccountDetail);
		accountDetail.setLoanAccountNo(createdAccountDetail.getLoanAccountNo());
		return accountDetail;
	}

	@Override
	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail) {
		Optional<LoanAccountDetail> accountDetail = this.getDaoManager().getLoanSectionDao()
				.getLoanAccountDetailByLoanId(emiDetail.getLoanAccNo());
		if (!accountDetail.isPresent())
			throw new RecordNotFound("Account Details Not Found");
		LoanInstallmentsDetail loanEMIDetail = new LoanInstallmentsDetail();
		loanEMIDetail.setLoanAccouuntNo(accountDetail.get());
		loanEMIDetail.setPaymentAmount(emiDetail.getPayment());
		loanEMIDetail.setPaymentMode(emiDetail.getPaymentMethod());
		loanEMIDetail.setPaymentDate(LocalDate.now());
		loanEMIDetail = this.getDaoManager().getLoanSectionDao().addPayment(loanEMIDetail);
		Double currCollection = accountDetail.get().getTotalCollection() != null
				? accountDetail.get().getTotalCollection()
				: 0.00;
		currCollection = currCollection + Double.valueOf(emiDetail.getPayment());
		accountDetail.get().setTotalCollection(currCollection);
		this.getDaoManager().getLoanSectionDao().createLoanNewAccount(accountDetail.get());
		emiDetail.setPaymentId(loanEMIDetail.getPaymentId());
		return emiDetail;
	}

	@Override
	public List<LoanAccountDetailDto> getLoanDetailByCustIdAndStatus(Long custId, String status) {
		if (custId == null)
			throw new RecordNotFound("custId May Not Be Empty");
		Optional<CustDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(Long.valueOf(custId));
		if (!custPersionalDetail.isPresent())

			throw new RecordNotFound("Customer Not Found");
		List<LoanAccountDetailDto> accountDetails = null;
		if (status.equalsIgnoreCase("Opened")) {
			accountDetails = this.getDaoManager().getLoanSectionDao().getLoanDetailByCustId(custPersionalDetail.get())
					.stream().map(loandetail -> {
						LoanAccountDetailDto accountDetailDto = new LoanAccountDetailDto();
						// accountDetailDto.setLoanAccountNo(String.valueOf(loandetail.getLoanAccountNo()));
						/*
						 * accountDetailDto.setPrincipalAmount(String.valueOf(loandetail.
						 * getPrincipalAmount()));
						 * accountDetailDto.setEmiAmount(loandetail.getInstallmentAmount());
						 * accountDetailDto.setTotalCollection(loandetail.getTotalCollection());
						 */
						return accountDetailDto;
					}).collect(Collectors.toList());
		}

		return accountDetails;
	}

	@Override
	public LoanAccountDetailDto getLoanDetailByLoanId(Long loanAccountNo) {
		Optional<LoanAccountDetail> accountDetail = this.getDaoManager().getLoanSectionDao()
				.getLoanAccountDetailByLoanId(loanAccountNo);
		if (!accountDetail.isPresent())
			throw new RecordNotFound("Account Not Exist");
		LoanAccountDetailDto accountDetailDto = new LoanAccountDetailDto();
		accountDetailDto.setCustId(accountDetail.get().getCustId().getCustId());
		accountDetailDto.setCustFullName(accountDetail.get().getCustId().getFullName());
		accountDetailDto.setPrincipalAmount(accountDetail.get().getPrincipalAmount());
		accountDetailDto.setInterest(accountDetail.get().getInterest());
		accountDetailDto.setInterestAmt(accountDetail.get().getInterestAmt());
		accountDetailDto.setDepositeAmt(accountDetail.get().getDepositeAmt());
		accountDetailDto.setProcessingFees(accountDetail.get().getProcessingFees());
		accountDetailDto.setLoanAmt(accountDetail.get().getLoanAmt());
		accountDetailDto.setLoanStartDate(accountDetail.get().getLoanStartDate());
		accountDetailDto.setLoanEndDate(accountDetail.get().getLoanEndDate());
		accountDetailDto.setInstallMentType(accountDetail.get().getInstallMentType());
		accountDetailDto.setInstallments(accountDetail.get().getInstallments());
		accountDetailDto.setInstallmentAmount(accountDetail.get().getInstallmentAmount());
		accountDetailDto.setLoanAccountNo(accountDetail.get().getLoanAccountNo());
		accountDetailDto.setTotalCollection(accountDetail.get().getTotalCollection());
		accountDetailDto.setLoanStatus(accountDetail.get().getLoanStatus());
		accountDetailDto.setPaymentMode(accountDetail.get().getPaymentMode());
		if (null != accountDetail.get().getPaymentDate())
			accountDetailDto.setPaymentDate(String.valueOf(accountDetail.get().getPaymentDate()));
		List<LoanInstallmentsDetail> installmentsDetails = this.getDaoManager().getLoanSectionDao()
				.getLoanInstallmentsByLoanId(accountDetail.get());
		if (installmentsDetails != null && installmentsDetails.size() > 0) {
			List<LoanEMIDetailDto> detailDtos = installmentsDetails.stream().map(installmets -> {
				LoanEMIDetailDto detailDto = new LoanEMIDetailDto();
				detailDto.setPayment(installmets.getPaymentAmount());
				detailDto.setPaymentDate(String.valueOf(installmets.getPaymentDate()));
				detailDto.setPaymentId(installmets.getPaymentId());
				detailDto.setPaymentMethod("Daily");
				return detailDto;
			}).collect(Collectors.toList());
			accountDetailDto.setLoanCollections(detailDtos);
		}

		return accountDetailDto;
	}

	@Override
	public int closeLoanAccount(String status, String remark, Long loanAccountNo) {
		if (loanAccountNo == null)
			throw new NullPointerException("Loan Account Number May Not Be Null");
		Optional<LoanAccountDetail> accountDetail = this.getDaoManager().getLoanSectionDao()
				.getLoanAccountDetailByLoanId(loanAccountNo);
		if (!accountDetail.isPresent())
			throw new RecordNotFound("Record Not Found");
		int i = this.getDaoManager().getLoanSectionDao().closeLoanAccount(status, LocalDate.now(), remark,
				loanAccountNo);
		return i;
	}

	@Override
	public List<LoanRepoDto> getAllLoanAccount(String status) {

		List<LoanRepoDto> accountDetailRepos = this.getDaoManager().getLoanSectionDao().getAllLoanAccount(status)
				.stream().map(accountDetail -> {
					LoanRepoDto loanRepoDto = new LoanRepoDto();
					loanRepoDto.setFullName(accountDetail.getCustId().getFullName());
					loanRepoDto.setLoanAccountNo(accountDetail.getLoanAccountNo());
					loanRepoDto.setPrincipalAmount(accountDetail.getPrincipalAmount());
					loanRepoDto.setLoanAmt(accountDetail.getLoanAmt());
					loanRepoDto.setTotalCollection(accountDetail.getTotalCollection());
					if (accountDetail.getTotalCollection() == null)
						accountDetail.setTotalCollection(0.00);
					loanRepoDto.setRemainCollection(accountDetail.getPrincipalAmount()
							- accountDetail.getTotalCollection() - accountDetail.getDepositeAmt());
					loanRepoDto.setLoanEndigDate(String.valueOf(accountDetail.getLoanEndDate()));
					return loanRepoDto;
				}).collect(Collectors.toList());
		return accountDetailRepos;
	}

	@Override
	public DashBoardRepo getDashBoardData() {
		DashBoardRepo dashBoardRepo = new DashBoardRepo();
		List<LoanAccountDetail> accountDetails = this.getDaoManager().getLoanSectionDao().getAllLoanAccount("Opened");
		Double totalOpenedLoanCollection = accountDetails.stream()
				.filter(totalCollection -> totalCollection.getTotalCollection() != null)
				.mapToDouble(totalCollection -> totalCollection.getTotalCollection()).sum();
		Long count = accountDetails.stream().filter(totalCollection -> totalCollection.getPaymentDate() != null)
				.collect(Collectors.counting());
		Double totalRunningLoanAmt = accountDetails.stream()
				.filter(totalCollection -> totalCollection.getPaymentDate() != null)
				.mapToDouble(totalCollection -> totalCollection.getLoanAmt()).sum();
		dashBoardRepo.setTotalOpenedLoanAccount(count);
		dashBoardRepo.setTotalActiveLoanCollection(totalOpenedLoanCollection);
		dashBoardRepo.setTotalRunningLoanAmt(totalRunningLoanAmt);
		dashBoardRepo.setPendingCollections(totalRunningLoanAmt - totalOpenedLoanCollection);
		return dashBoardRepo;
	}

	@Override
	public LoanPaymentDetailDto addLoanPaymentDtl(LoanPaymentDetailDto paymentDetailDto) {
		Optional<LoanAccountDetail> accountDetail = this.getDaoManager().getLoanSectionDao()
				.getLoanAccountDetailByLoanId(paymentDetailDto.getLoanAccountNo());
		if (!accountDetail.isPresent())
			throw new RecordNotFound("Not Found Loan Account");
		accountDetail.get().setPaymentDate(LocalDate.now());
		accountDetail.get().setPaymentMode(paymentDetailDto.getPaymentMode());
		accountDetail.get().setLastUpdated(LocalDate.now());
		this.getDaoManager().getLoanSectionDao().createLoanNewAccount(accountDetail.get());
		return paymentDetailDto;
	}

	@Override
	public List<LoanPaymentDetailDto> getPendingLoanPayment() {
		List<LoanAccountDetail> openedAccountDetailLst = this.getDaoManager().getLoanSectionDao()
				.getAllLoanAccount("Opened");
		if (openedAccountDetailLst != null && openedAccountDetailLst.size() > 0) {
			List<LoanPaymentDetailDto> loanPendingPaymentDetails = openedAccountDetailLst.stream()
					.filter(paymentDate -> paymentDate.getPaymentDate() == null).map(pendingLoanPayment -> {
						LoanPaymentDetailDto loanPaymentDetailDto = new LoanPaymentDetailDto();
						loanPaymentDetailDto.setCustFullName(pendingLoanPayment.getCustId().getFullName());
						loanPaymentDetailDto.setLoanAmt(pendingLoanPayment.getLoanAmt());
						loanPaymentDetailDto.setLoanAccountNo(pendingLoanPayment.getLoanAccountNo());
						return loanPaymentDetailDto;

					}).collect(Collectors.toList());
			return loanPendingPaymentDetails;
		}

		return null;
	}

	@Override
	public List<LoanCollectionRepo> getTodayCollectionSummary() {
		List<LoanInstallmentsDetail> installmentsDetails = this.getDaoManager().getLoanSectionDao()
				.getLoanInstallmentDetailsByPaymentDate(LocalDate.now());
		if (installmentsDetails != null && installmentsDetails.size() > 0) {
			List<LoanCollectionRepo> collectionRepos = installmentsDetails.stream().map(installMentData -> {
				LoanCollectionRepo loanCollectionRepo = new LoanCollectionRepo();
				loanCollectionRepo.setAccNo(installMentData.getLoanAccouuntNo().getLoanAccountNo());
				loanCollectionRepo.setFullName(installMentData.getLoanAccouuntNo().getCustId().getFullName());
				loanCollectionRepo.setPayment(installMentData.getPaymentAmount());
				return loanCollectionRepo;
			}).collect(Collectors.toList());
			return collectionRepos;
		}
		return null;
	}

	@Override
	public LoanPenaltyDto addPenalty(LoanPenaltyDto loanPenaltyDto) {
		Optional<LoanAccountDetail> accountDetail = this.getDaoManager().getLoanSectionDao()
				.getLoanAccountDetailByLoanId(loanPenaltyDto.getLoanAccountId());
		if (!accountDetail.isPresent())
			throw new RecordNotFound("Loan Account Not Exist");
		LoanPenalty loanPenalty = new LoanPenalty();
		loanPenalty.setLoanAccountId(accountDetail.get());
		loanPenalty.setPenaltyAmt(loanPenaltyDto.getPenaltyAmt());
		loanPenalty.setPenaltyDate(LocalDate.now());
		if (loanPenaltyDto.getRemark() != null)
			loanPenalty.setRemark(loanPenaltyDto.getRemark());
		loanPenalty = this.getDaoManager().getLoanSectionDao().addPenalty(loanPenalty);
		loanPenaltyDto.setLoanPenaltyId(loanPenalty.getLoanPenaltyId());
		loanPenaltyDto.setPenaltyDate(loanPenalty.getPenaltyDate());
		return loanPenaltyDto;
	}

	@Override
	public List<LoanPenaltyDto> findDtlByLoanId(Long accountId) {
		if (accountId == null)
			throw new NullPointerException("accountId may not be null");
		Optional<LoanAccountDetail> accountDetail = this.getDaoManager().getLoanSectionDao()
				.getLoanAccountDetailByLoanId(accountId);
		if (!accountDetail.isPresent())
			throw new RecordNotFound("Loan Account Not Exist");
		List<LoanPenalty> loanPenalties = this.getDaoManager().getLoanSectionDao().findDtlByLoanId(accountDetail.get());
		if (loanPenalties == null || loanPenalties.size() < 0)
			throw new RecordNotFound("Record Not Exist");
		List<LoanPenaltyDto> penaltyDtos = loanPenalties.stream().map(pendaltDtl -> {
			LoanPenaltyDto loanPenaltyDto = new LoanPenaltyDto();
			loanPenaltyDto.setLoanPenaltyId(pendaltDtl.getLoanPenaltyId());
			loanPenaltyDto.setPenaltyAmt(pendaltDtl.getPenaltyAmt());
			loanPenaltyDto.setPenaltyDate(pendaltDtl.getPenaltyDate());
			if (pendaltDtl.getRemark() != null)
				loanPenaltyDto.setRemark(pendaltDtl.getRemark());
			return loanPenaltyDto;
		}).collect(Collectors.toList());
		return penaltyDtos;
	}

}
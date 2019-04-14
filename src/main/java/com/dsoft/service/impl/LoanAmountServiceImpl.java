package com.dsoft.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dsoft.dto.LoanAccountDetailDto;
import com.dsoft.dto.LoanEMIDetailDto;
import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.LoanAccountDetail;
import com.dsoft.entity.LoanInstallmentsDetail;
import com.dsoft.exception.RecordNotFound;
import com.dsoft.service.DaoServicess;
import com.dsoft.service.LoanAmountService;
import com.dsoft.utils.DateUtils;

@Service
public class LoanAmountServiceImpl extends DaoServicess implements LoanAmountService {

	@Override
	public LoanAccountDetailDto createLoanNewAccount(LoanAccountDetailDto accountDetail) {
		Optional<CustPersionalDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
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
		loanAccountDetail.setLoanEndDate(accountDetail.getLoanStartDate());
		loanAccountDetail.setLoanEndDate(accountDetail.getLoanEndDate());
		loanAccountDetail.setInstallMentType(accountDetail.getInstallMentType());
		loanAccountDetail.setInstallments(accountDetail.getInstallments());
		loanAccountDetail.setInstallmentAmount(accountDetail.getInstallmentAmount());
		loanAccountDetail.setLastUpdated(LocalDate.now());
		loanAccountDetail.setLoanStatus("Opened");
		this.getDaoManager().getAmountDao().createLoanNewAccount(loanAccountDetail);
		return accountDetail;
	}

	@Override
	public LoanEMIDetailDto addPayment(LoanEMIDetailDto emiDetail) {
		Optional<LoanAccountDetail> accountDetail = this.getDaoManager().getAmountDao()
				.getLoanAccountDetailByLoanId(emiDetail.getLoanAccNo());
		if (!accountDetail.isPresent())
			throw new RecordNotFound("Account Details Not Found");
		LoanInstallmentsDetail loanEMIDetail = new LoanInstallmentsDetail();
		loanEMIDetail.setLoanAccouuntNo(accountDetail.get());
		loanEMIDetail.setPaymentAmount(emiDetail.getPayment());
		loanEMIDetail.setPaymentMode(emiDetail.getPaymentMethod());
		loanEMIDetail.setPaymentDate(LocalDate.now());
		loanEMIDetail = this.getDaoManager().getAmountDao().addPayment(loanEMIDetail);
		Double currCollection = accountDetail.get().getTotalCollection() != null
				? accountDetail.get().getTotalCollection()
				: 0.00;
		currCollection = currCollection + Double.valueOf(emiDetail.getPayment());
		accountDetail.get().setTotalCollection(currCollection);
		this.getDaoManager().getAmountDao().createLoanNewAccount(accountDetail.get());
		emiDetail.setPaymentId(loanEMIDetail.getPaymentId());
		return emiDetail;
	}

	@Override
	public List<LoanAccountDetailDto> getLoanDetailByCustIdAndStatus(Long custId, String status) {
		if (custId == null)
			throw new RecordNotFound("custId May Not Be Empty");
		Optional<CustPersionalDetail> custPersionalDetail = this.getDaoManager().getCustomerDao()
				.findCustomerDetailById(Long.valueOf(custId));
		if (!custPersionalDetail.isPresent())

			throw new RecordNotFound("Customer Not Found");
		List<LoanAccountDetailDto> accountDetails = null;
		if (status.equalsIgnoreCase("Opened")) {
			accountDetails = this.getDaoManager().getAmountDao().getLoanDetailByCustId(custPersionalDetail.get())
					.stream().map(loandetail -> {
						LoanAccountDetailDto accountDetailDto = new LoanAccountDetailDto();
					//	accountDetailDto.setLoanAccountNo(String.valueOf(loandetail.getLoanAccountNo()));
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
		Optional<LoanAccountDetail> accountDetail=this.getDaoManager().getAmountDao().getLoanAccountDetailByLoanId(loanAccountNo);
		if(!accountDetail.isPresent())
			throw new RecordNotFound("Account Not Exist");
		LoanAccountDetailDto accountDetailDto=new LoanAccountDetailDto();
		accountDetailDto.setCustId(accountDetail.get().getCustId().getCustId());
		accountDetailDto.setCustFullName(accountDetail.get().getCustId().getFullName());
		accountDetailDto.setPrincipalAmount(accountDetail.get().getPrincipalAmount());
		accountDetailDto.setInterest(accountDetail.get().getInterest());
		accountDetailDto.setInterestAmt(accountDetail.get().getInterestAmt());
		accountDetailDto.setDepositeAmt(accountDetail.get().getDepositeAmt());
		accountDetailDto.setProcessingFees(accountDetail.get().getProcessingFees());
		accountDetailDto.setLoanAmt(accountDetail.get().getLoanAmt());
		accountDetailDto.setLoanEndDate(accountDetail.get().getLoanStartDate());
		accountDetailDto.setLoanEndDate(accountDetail.get().getLoanEndDate());
		accountDetailDto.setInstallMentType(accountDetail.get().getInstallMentType());
		accountDetailDto.setInstallments(accountDetail.get().getInstallments());
		accountDetailDto.setInstallmentAmount(accountDetail.get().getInstallmentAmount());
		accountDetailDto.setLoanAccountNo(accountDetail.get().getLoanAccountNo());
		accountDetailDto.setTotalCollection(accountDetail.get().getTotalCollection());
		List<LoanInstallmentsDetail> installmentsDetails=this.getDaoManager().getAmountDao().getLoanInstallmentsByLoanId(accountDetail.get());
		if(installmentsDetails!=null&&installmentsDetails.size()>0) {
			List<LoanEMIDetailDto> detailDtos=installmentsDetails.stream().map(installmets->{
				LoanEMIDetailDto detailDto=new LoanEMIDetailDto();
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

}

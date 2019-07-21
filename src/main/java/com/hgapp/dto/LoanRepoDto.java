package com.hgapp.dto;

import java.io.Serializable;

public class LoanRepoDto implements Serializable {

	private static final long serialVersionUID = -4908643518207065370L;
	private String fullName;
	private Long loanAccountNo;
	private Double loanAmt;
	private Double totalCollection;
	private Double remainCollection;
	private String loanEndigDate;
	private String loanStatus;
	private String paymentDate;
	private String paymentMode;
	private Double principalAmount;
	private Double disburseAmt;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getLoanAccountNo() {
		return loanAccountNo;
	}

	public void setLoanAccountNo(Long loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	public Double getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(Double loanAmt) {
		this.loanAmt = loanAmt;
	}

	public Double getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(Double totalCollection) {
		this.totalCollection = totalCollection;
	}

	public Double getRemainCollection() {
		return remainCollection;
	}

	public void setRemainCollection(Double remainCollection) {
		this.remainCollection = remainCollection;
	}

	public String getLoanEndigDate() {
		return loanEndigDate;
	}

	public void setLoanEndigDate(String loanEndigDate) {
		this.loanEndigDate = loanEndigDate;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getDisburseAmt() {
		return disburseAmt;
	}

	public void setDisburseAmt(Double disburseAmt) {
		this.disburseAmt = disburseAmt;
	}

}

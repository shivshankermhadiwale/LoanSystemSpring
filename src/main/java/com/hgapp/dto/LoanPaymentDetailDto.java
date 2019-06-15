package com.hgapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoanPaymentDetailDto implements Serializable {
	private static final long serialVersionUID = 3644844770290435440L;
	@NotNull(message = "loanAccountNo may not be null")
	private Long loanAccountNo;
	private String paymentMode;
	private String custFullName;
	private Double loanAmt;

	public Long getLoanAccountNo() {
		return loanAccountNo;
	}

	public void setLoanAccountNo(Long loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCustFullName() {
		return custFullName;
	}

	public void setCustFullName(String custFullName) {
		this.custFullName = custFullName;
	}

	public Double getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(Double loanAmt) {
		this.loanAmt = loanAmt;
	}

}

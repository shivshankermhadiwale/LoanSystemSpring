package com.dench.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOAN_ACCOUNT_DETAIL")
public class LoanAccountDetail implements Serializable {
	private static final long serialVersionUID = 5901789227124639010L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanAccountNo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private CustPersionalDetail custId;
	private Double principalAmount;
	private LocalDate loanDate;
	private LocalDate emiStartDate;
	private Double emiAmount;
	private Float loanInterest;
	private Integer loanTenureInMonths;
	private Integer loanTenureInYears;
	private Double totalCollection;
	private LocalDate loanEndingDate;

	public Long getLoanAccountNo() {
		return loanAccountNo;
	}

	public void setLoanAccountNo(Long loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	public CustPersionalDetail getCustId() {
		return custId;
	}

	public void setCustId(CustPersionalDetail custId) {
		this.custId = custId;
	}

	public Double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getEmiStartDate() {
		return emiStartDate;
	}

	public void setEmiStartDate(LocalDate emiStartDate) {
		this.emiStartDate = emiStartDate;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Float getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(Float loanInterest) {
		this.loanInterest = loanInterest;
	}

	public Integer getLoanTenureInMonths() {
		return loanTenureInMonths;
	}

	public void setLoanTenureInMonths(Integer loanTenureInMonths) {
		this.loanTenureInMonths = loanTenureInMonths;
	}

	public Integer getLoanTenureInYears() {
		return loanTenureInYears;
	}

	public void setLoanTenureInYears(Integer loanTenureInYears) {
		this.loanTenureInYears = loanTenureInYears;
	}

	public Double getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(Double totalCollection) {
		this.totalCollection = totalCollection;
	}

	public LocalDate getLoanEndingDate() {
		return loanEndingDate;
	}

	public void setLoanEndingDate(LocalDate loanEndingDate) {
		this.loanEndingDate = loanEndingDate;
	}

}

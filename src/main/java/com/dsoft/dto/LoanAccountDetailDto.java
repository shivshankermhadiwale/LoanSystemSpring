package com.dsoft.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class LoanAccountDetailDto implements Serializable {

	private static final long serialVersionUID = -2282881913238864262L;
	private String loanAccountNo;
	@JoinColumn(name = "cust_id")
	private String custId;
	private String principalAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private LocalDate loanDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private LocalDate emiStartDate;
	private Double emiAmount;
	private Float loanInterest;
	private Integer loanTenureInMonths;
	private Integer loanTenureInYears;
	private Double totalCollection;
	private LocalDate loanEndingDate;

	public String getLoanAccountNo() {
		return loanAccountNo;
	}

	public void setLoanAccountNo(String loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(String principalAmount) {
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

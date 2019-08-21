package com.hgapp.dto;

public class LoanSummaryDto {
	private Long newAccounts;
	private Double loanAmounts;
	private Double disbursements;
	private Double penalty;
	private Double collections;
	private int closedAccounts;

	public Long getNewAccounts() {
		return newAccounts;
	}

	public void setNewAccounts(Long newAccounts) {
		this.newAccounts = newAccounts;
	}

	public Double getLoanAmounts() {
		return loanAmounts;
	}

	public void setLoanAmounts(Double loanAmounts) {
		this.loanAmounts = loanAmounts;
	}

	public Double getDisbursements() {
		return disbursements;
	}

	public void setDisbursements(Double disbursements) {
		this.disbursements = disbursements;
	}

	public Double getPenalty() {
		return penalty;
	}

	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}

	public Double getCollections() {
		return collections;
	}

	public void setCollections(Double collections) {
		this.collections = collections;
	}

	public int getClosedAccounts() {
		return closedAccounts;
	}

	public void setClosedAccounts(int closedAccounts) {
		this.closedAccounts = closedAccounts;
	}

}

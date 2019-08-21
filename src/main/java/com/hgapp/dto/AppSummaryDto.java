package com.hgapp.dto;

public class AppSummaryDto {
	private Double openingBalance;
	private Double expenses;
	private LoanSummaryDto loanSummary;
	private FDSummaryDto fdSummary;

	public LoanSummaryDto getLoanSummary() {
		return loanSummary;
	}

	public void setLoanSummary(LoanSummaryDto loanSummary) {
		this.loanSummary = loanSummary;
	}

	public FDSummaryDto getFdSummary() {
		return fdSummary;
	}

	public void setFdSummary(FDSummaryDto fdSummary) {
		this.fdSummary = fdSummary;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

}

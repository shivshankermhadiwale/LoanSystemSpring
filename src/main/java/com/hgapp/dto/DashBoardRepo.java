package com.hgapp.dto;

import java.io.Serializable;

public class DashBoardRepo implements Serializable {
	private static final long serialVersionUID = -6058906565740138063L;
	private Double totalActiveLoanCollection;
	private Long totalOpenedLoanAccount;
	private Double totalRunningLoanAmt;
	private Double pendingCollections;
	private Double todayTotalCollection;

	public Double getTotalActiveLoanCollection() {
		return totalActiveLoanCollection;
	}

	public void setTotalActiveLoanCollection(Double totalActiveLoanCollection) {
		this.totalActiveLoanCollection = totalActiveLoanCollection;
	}

	public Double getTotalRunningLoanAmt() {
		return totalRunningLoanAmt;
	}

	public void setTotalRunningLoanAmt(Double totalRunningLoanAmt) {
		this.totalRunningLoanAmt = totalRunningLoanAmt;
	}

	public Long getTotalOpenedLoanAccount() {
		return totalOpenedLoanAccount;
	}

	public void setTotalOpenedLoanAccount(Long totalOpenedLoanAccount) {
		this.totalOpenedLoanAccount = totalOpenedLoanAccount;
	}

	public Double getPendingCollections() {
		return pendingCollections;
	}

	public void setPendingCollections(Double pendingCollections) {
		this.pendingCollections = pendingCollections;
	}

	public Double getTodayTotalCollection() {
		return todayTotalCollection;
	}

	public void setTodayTotalCollection(Double todayTotalCollection) {
		this.todayTotalCollection = todayTotalCollection;
	}

}

package com.hgapp.dto;

public class FDSummaryDto {
	private int newFd;
	private Double fdAmount;
	private Double paidInterest;
	private int closedFd;
	private Double clodedFDAmount;

	public int getNewFd() {
		return newFd;
	}

	public void setNewFd(int newFd) {
		this.newFd = newFd;
	}

	public Double getFdAmount() {
		return fdAmount;
	}

	public void setFdAmount(Double fdAmount) {
		this.fdAmount = fdAmount;
	}

	public Double getPaidInterest() {
		return paidInterest;
	}

	public void setPaidInterest(Double paidInterest) {
		this.paidInterest = paidInterest;
	}

	public int getClosedFd() {
		return closedFd;
	}

	public void setClosedFd(int closedFd) {
		this.closedFd = closedFd;
	}

	public Double getClodedFDAmount() {
		return clodedFDAmount;
	}

	public void setClodedFDAmount(Double clodedFDAmount) {
		this.clodedFDAmount = clodedFDAmount;
	}

}

package com.hgapp.service;

import com.hgapp.dto.AppSummaryDto;
import com.hgapp.dto.DashBoardRepo;

public interface DashBoardService {
	public DashBoardRepo getDashBoardData();

	public AppSummaryDto getAllSummaryReport(String loanstatus,String fdStatus);
}

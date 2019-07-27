package com.hgapp.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

public interface DownloadService {
	public  ResponseEntity<?> customerPdfDownload(Long custId) throws IOException;
	public ResponseEntity<?> downloandLoanAccounts(String status);
	public ResponseEntity<?> downloandCustomerFD(Long fdId);
}

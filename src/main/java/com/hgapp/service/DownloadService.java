package com.hgapp.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

public interface DownloadService {
	public  ResponseEntity<?> customerPdfDownload(Long custId) throws IOException;
}

package com.hgapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController extends ControllerManager {
	private static final Logger logger = LogManager.getLogger(DashBoardController.class);

	@GetMapping("/getData")
	public ResponseEntity<?> getDashBoardData() {
		return new ResponseEntity<>(this.getServiceManager().getLoanService().getDashBoardData(), HttpStatus.OK);

	}

	@GetMapping("/getPendingLoanPayments")
	public ResponseEntity<?> getPendingLoanPayments() {
		return new ResponseEntity<>(this.getServiceManager().getLoanService().getPendingLoanPayment(), HttpStatus.OK);

	}
}

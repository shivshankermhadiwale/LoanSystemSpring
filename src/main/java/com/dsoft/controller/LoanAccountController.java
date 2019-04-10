package com.dsoft.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsoft.dto.LoanAccountDetailDto;
import com.dsoft.dto.LoanEMIDetailDto;

@RestController
@RequestMapping("/Loan")
public class LoanAccountController extends ControllerManager {
	private static final Logger logger = LogManager.getLogger(LoanAccountController.class);

	@PostMapping("/createLoanAccount")
	public ResponseEntity<?> creatLoanAccount(@RequestBody @Valid LoanAccountDetailDto accountDetail, Errors errors) {
		logger.info(" : Creating New Loan Account Process Begins------");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getAmountService().createLoanNewAccount(accountDetail));

	}

	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayment(@RequestBody @Valid LoanEMIDetailDto detail,Errors errors){
		logger.info(" : Adding Payment Of Customer Process Begins------");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getAmountService().addPayment(detail));
		
	}

}

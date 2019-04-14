package com.dsoft.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/getLoanDetailByLoanId/{loanAccountNo}")
	public ResponseEntity<?> getLoanDetailByLoanId(@PathVariable Long loanAccountNo) {
		logger.info(" : Calling Get Loan Detail By CustId and Loan Status Process Begins------");
		if (loanAccountNo == null)
			throw new NullPointerException("loanAccountNo May Not Be Null");
		return ResponseEntity
				.ok(this.getServiceManager().getAmountService().getLoanDetailByLoanId(loanAccountNo));

	}

	@GetMapping("/getLoanDetailByCustId/{custId}/{loanStatus}")
	public ResponseEntity<?> getLoanDetailByCustId(@PathVariable String custId, @PathVariable String loanStatus) {
		logger.info(" : Calling Get Loan Detail By CustId and Loan Status Process Begins------");
		if (custId == null || loanStatus == null || loanStatus.isEmpty())
			throw new NullPointerException("CustId/LoanStatus May Not Be Null");
		return ResponseEntity
				.ok(this.getServiceManager().getAmountService().getLoanDetailByCustIdAndStatus(Long.valueOf(custId), loanStatus));

	}

	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayment(@RequestBody @Valid LoanEMIDetailDto detail, Errors errors) {
		logger.info(" : Adding Payment Of Customer Process Begins------");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getAmountService().addPayment(detail));

	}

}

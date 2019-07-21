package com.hgapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgapp.dto.LoanAccountDetailDto;
import com.hgapp.dto.LoanEMIDetailDto;
import com.hgapp.dto.LoanPaymentDetailDto;
import com.hgapp.dto.LoanPenaltyDto;

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
		return ResponseEntity.ok(this.getServiceManager().getLoanService().createLoanNewAccount(accountDetail));

	}

	@PostMapping("/makeLoanPayment")
	public ResponseEntity<?> makeLoanPayment(@RequestBody @Valid LoanPaymentDetailDto paymentDetailDto, Errors errors) {
		logger.info(" : loan disbursing process begins-----");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getLoanService().addLoanPaymentDtl(paymentDetailDto));

	}

	@GetMapping("/getLoanDetailByLoanId/{loanAccountNo}")
	public ResponseEntity<?> getLoanDetailByLoanId(@PathVariable Long loanAccountNo) {
		logger.info(" : Calling Get Loan Detail By CustId and Loan Status Process Begins------");
		if (loanAccountNo == null)
			throw new NullPointerException("loanAccountNo May Not Be Null");
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getLoanDetailByLoanId(loanAccountNo));

	}

	@GetMapping("/getLoanDetailByCustId/{custId}/{loanStatus}")
	public ResponseEntity<?> getLoanDetailByCustId(@PathVariable String custId, @PathVariable String loanStatus) {
		logger.info(" : Calling Get Loan Detail By CustId and Loan Status Process Begins------");
		if (custId == null || loanStatus == null || loanStatus.isEmpty())
			throw new NullPointerException("CustId/LoanStatus May Not Be Null");
		return ResponseEntity.ok(this.getServiceManager().getLoanService()
				.getLoanDetailByCustIdAndStatus(Long.valueOf(custId), loanStatus));

	}

	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayment(@RequestBody @Valid LoanEMIDetailDto detail, Errors errors) {
		logger.info(" : Adding Payment Of Customer Process Begins------");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getLoanService().addPayment(detail));

	}

	@PostMapping("/closeLoanAccount")
	public ResponseEntity<?> closeLoanAccoung(@RequestBody String requestBody) throws IOException {
		logger.info(" : Closing Loan Account------" + requestBody);
		if (requestBody == null || requestBody.trim().isEmpty())
			throw new NullPointerException("Request Body Is Empty");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(requestBody);
		String loanStatus = "", remark = "";
		Long loanId = null;
		if (jsonNode.has("loanAccountNo"))
			loanId = jsonNode.get("loanAccountNo").asLong();
		if (jsonNode.has("loanStatus"))
			loanStatus = jsonNode.get("loanStatus").asText();
		if (jsonNode.has("remark"))
			remark = jsonNode.get("remark").asText();

		return ResponseEntity
				.ok(this.getServiceManager().getLoanService().closeLoanAccount(loanStatus, remark, loanId));
	}

	@GetMapping("/getLoanDetailByStatus/{status}")
	public ResponseEntity<?> getLoanDetailByStatus(@PathVariable String status) {
		logger.info(" : Calling Loan Report------");
		if (status == null || status.isEmpty())
			throw new NullPointerException("Input Data Missing");
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getAllLoanAccount(status));

	}

	@GetMapping("/getTodayCollectionSummary")
	public ResponseEntity<?> getTodayCollectionSummary() {
		logger.info(" : Getting Today Collection Summary------");
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getTodayCollectionSummary());

	}

	@GetMapping("/get-penalty-by-loanAccountId/{loanAccountId}")
	public ResponseEntity<?> getPenaltyByLoanAccountId(@PathVariable Long loanAccountId) {
		logger.info(" : Getting Loan Penalty By LoanAccountId------");
		return ResponseEntity.ok(this.getServiceManager().getLoanService().findDtlByLoanId(loanAccountId));

	}

	@PostMapping("/add-loan-penalty")
	public ResponseEntity<?> addLoanPenalty(@RequestBody @Valid LoanPenaltyDto loanPenaltyDto, Errors errors) {
		logger.info(" : adding loan penalty------");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getLoanService().addPenalty(loanPenaltyDto));

	}

	@GetMapping("/get-loan-disbursed-by-loan-status/{loanStatus}")
	public ResponseEntity<?> getLoanDisbursedByLoanStatus(@PathVariable String loanStatus) {
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getLoanDisbursedByStatus(loanStatus));

	}
	@GetMapping("/get-payment-collection-by-date/{fromDate}/{toDate}")
	public ResponseEntity<?> getLoanDisbursedByLoanStatus(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate, 
		    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getAllLoanInstallmentsByDate(fromDate, toDate));

	}
	@RequestMapping(value = "/download-loan-account/{loanStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> downloadCustPDF(@PathVariable String loanStatus) throws IOException {
		return this.getServiceManager().getDownloadService().downloandLoanAccounts(loanStatus);

	}

}

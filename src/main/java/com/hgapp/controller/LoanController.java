package com.hgapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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
public class LoanController extends ControllerManager {
	private static final Logger logger = LogManager.getLogger(LoanController.class);

	@PostMapping("/new")
	public ResponseEntity<?> newLoanAccount(@RequestBody @Valid LoanAccountDetailDto accountDetail, Errors errors) {
		logger.info(":Creating New Loan Account Process Begins------");
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getLoanService().createLoanNewAccount(accountDetail));

	}

	@GetMapping("/find/{loanAccountNo}")
	public ResponseEntity<?> findLoanDetailByLoanId(@PathVariable Long loanAccountNo) {
		logger.info(":Finding Loan Detail Of--" + loanAccountNo);
		if (loanAccountNo == null)
			throw new NullPointerException("loanAccountNo May Not Be Null");
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getLoanDetailByLoanId(loanAccountNo));

	}

	@GetMapping("/find/{custId}/{loanStatus}")
	public ResponseEntity<?> findLoanDetailByCustIdAndStatus(@PathVariable String custId,
			@PathVariable String loanStatus) {
		logger.info(" : Calling Get Loan Detail By CustId and Loan Status Process Begins------");
		if (custId == null || loanStatus == null || loanStatus.isEmpty())
			throw new NullPointerException("CustId/LoanStatus May Not Be Null");
		return ResponseEntity.ok(this.getServiceManager().getLoanService()
				.getLoanDetailByCustIdAndStatus(Long.valueOf(custId), loanStatus));

	}

	@GetMapping("/find-all/{status}")
	public ResponseEntity<?> findAllByStatus(@PathVariable String status) {
		logger.info(":Find All Loan Accounts By Status--" + status);
		if (status == null || status.isEmpty())
			throw new NullPointerException("Input Data Missing");
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getAllLoanAccount(status));

	}

	@PostMapping("/close")
	public ResponseEntity<?> closeLoanAccount(@RequestBody String requestBody) throws IOException {
		logger.info(":Closing Loan Account--" + requestBody);
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

	@PostMapping("/disburse")
	public ResponseEntity<?> disburseLoan(@RequestBody @Valid LoanPaymentDetailDto paymentDetailDto, Errors errors) {
		logger.info(":Disbursing Loan To--" + paymentDetailDto.getCustFullName());
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getLoanService().addLoanPaymentDtl(paymentDetailDto));

	}

	@GetMapping("/find-disbursement/{loanStatus}")
	public ResponseEntity<?> findLoanDisbursementByLoanStatus(@PathVariable String loanStatus) {
		logger.info(":Find loan Disbursement Of Loan Status--" + loanStatus);
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getLoanDisbursedByStatus(loanStatus));

	}

	@GetMapping("/find-pending-disbursements")
	public ResponseEntity<?> getPendingEMI() {
		logger.info(":finding pending loand disbursements--");
		return new ResponseEntity<>(this.getServiceManager().getLoanService().getPendingLoanPayment(), HttpStatus.OK);

	}

	@PostMapping("/add-emi")
	public ResponseEntity<?> addEMI(@RequestBody @Valid LoanEMIDetailDto detail, Errors errors) {
		logger.info(":Adding EMI Of--" + detail.getLoanAccNo());
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getLoanService().addPayment(detail));

	}

	@GetMapping("/get-emi/{fromDate}/{toDate}")
	public ResponseEntity<?> findEMIDetailsByFromDateAndToDate(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
		return ResponseEntity
				.ok(this.getServiceManager().getLoanService().getAllLoanInstallmentsByDate(fromDate, toDate));

	}

	@GetMapping("/get-daily-paid-emi")
	public ResponseEntity<?> getTodayCollectionSummary() {
		logger.info(":Get Daily Paid EMI--");
		return ResponseEntity.ok(this.getServiceManager().getLoanService().getTodayCollectionSummary());

	}

	@GetMapping("/get-penalty/{loanAccountId}")
	public ResponseEntity<?> getPenaltyByLoanAccountId(@PathVariable Long loanAccountId) {
		logger.info(":Getting Loan Penalty Of--" + loanAccountId);
		return ResponseEntity.ok(this.getServiceManager().getLoanService().findDtlByLoanId(loanAccountId));

	}

	@PostMapping("/add-penalty")
	public ResponseEntity<?> addLoanPenalty(@RequestBody @Valid LoanPenaltyDto loanPenaltyDto, Errors errors) {
		logger.info(":Adding loan penalty Of Accont--" + loanPenaltyDto.getLoanAccountId());
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getLoanService().addPenalty(loanPenaltyDto));

	}

	@RequestMapping(value = "/download-loan-accounts/{loanStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> downloadLoanAccountsByStatus(@PathVariable String loanStatus) throws IOException {
		logger.info(":Downloading Loan Accounts Of Status--" + loanStatus);
		return this.getServiceManager().getDownloadService().downloandLoanAccounts(loanStatus);

	}

	@GetMapping("/dashboard")
	public ResponseEntity<?> getDashBoardData() {
		return new ResponseEntity<>(this.getServiceManager().getLoanService().getDashBoardData(), HttpStatus.OK);

	}

}
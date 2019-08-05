package com.hgapp.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.hgapp.dto.FDAccountDto;
import com.hgapp.dto.FDInterestDto;

@RestController
@RequestMapping("/FD")
public class FDAccountController extends ControllerManager {

	@PostMapping("/new-fd")
	public ResponseEntity<?> createNewFD(@Valid @RequestBody FDAccountDto fdAccountDto, Errors errors) {
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getFdAccountService().createNewFDAccount(fdAccountDto));
	}

	@PostMapping("/close-fd")
	public ResponseEntity<?> closeFD(@Valid @RequestBody FDAccountDto fdAccountDto, Errors errors) {
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getFdAccountService().closeFDAccount(fdAccountDto));
	}

	@GetMapping("/find-fd-by-accountid/{fdId}")
	public ResponseEntity<?> findAccountById(@PathVariable Long fdId) {
		return ResponseEntity.ok(this.getServiceManager().getFdAccountService().getFDAccountDtlByAccountId(fdId));
	}

	@RequestMapping(value = "/downloadFDPDF/{fdId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> downloadCustPDF(@PathVariable Long fdId) throws IOException {
		return this.getServiceManager().getDownloadService().downloandCustomerFD(fdId);

	}

	@RequestMapping(value = "/get-fds-by-status/{fdStatus}")
	public ResponseEntity<?> getFdsBySatus(@PathVariable Byte fdStatus) throws IOException {
		return ResponseEntity.ok(this.getServiceManager().getFdAccountService().findFDByStatus(fdStatus));

	}

	@PostMapping("/pay-fd-intersamt")
	public ResponseEntity<?> payFDInterestAmt(@Valid @RequestBody FDInterestDto fdInterestDto, Errors errors) {
		if (errors.hasErrors())
			return ResponseEntity.ok(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return ResponseEntity.ok(this.getServiceManager().getFdAccountService().addFDInterstAmt(fdInterestDto));
	}

	@GetMapping("/get-cust-fd-lst/{custId}")
	public ResponseEntity<?> getCustomerFDs(@PathVariable Long custId) {
		return ResponseEntity.ok(this.getServiceManager().getFdAccountService().getCustomerAllFD(custId));
	}

}

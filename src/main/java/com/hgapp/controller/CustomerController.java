package com.hgapp.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hgapp.dto.CustContactPersionDto;
import com.hgapp.dto.CustomerDto;

@RestController
@RequestMapping("/customer")
public class CustomerController extends ControllerManager {
	private final Logger logger = LogManager.getLogger(CustomerController.class);

	@PostMapping("/addNew")
	public ResponseEntity<?> addNewCustomer(@Valid @RequestBody CustomerDto customer, Errors error)
			throws MethodArgumentNotValidException {
		logger.info(" : Adding New Customer Process Begins------");
		if (error.hasErrors())
			return new ResponseEntity<>(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<>(this.getServiceManager().getCustomerService().addNewCustomer(customer),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> findAllCustomer() {
		return new ResponseEntity<>(this.getServiceManager().getCustomerService().getAllCustomersLst(),
				HttpStatus.ACCEPTED);
	}

	@PostMapping("/addContactPersions")
	public ResponseEntity<?> addContactPersion(@Valid @RequestBody CustContactPersionDto custContact, Errors error)
			throws MethodArgumentNotValidException {
		logger.info(" : Adding New Contact Persion Of Customer------");
		if (error.hasErrors())
			return new ResponseEntity<>(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<>(this.getServiceManager().getCustomerService().addCustContactPersion(custContact),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/findContactPersionByCustId/{custId}")
	public ResponseEntity<?> findCustContactByCusId(@PathVariable Long custId) {
		logger.info(" : Find Customer Conatact By Cust Id Process Begins------");
		if (custId == null)
			throw new NullPointerException("custId Is Empty");
		return new ResponseEntity<>(this.getServiceManager().getCustomerService().getCustContactPersionByCustId(custId),
				HttpStatus.OK);
	}

	@GetMapping("/findById/{custId}")
	public ResponseEntity<?> findCustomerById(@PathVariable Long custId) {
		logger.info(" : Find Customer By Id Process Begins------");
		if (custId == null)
			throw new NullPointerException("custId Is Empty");
		return new ResponseEntity<>(this.getServiceManager().getCustomerService().findCustomerDetailById(custId),
				HttpStatus.OK);
	}

	@DeleteMapping("/delete/{custId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable Long custId) {
		if (custId == null)
			throw new NullPointerException(" : Delete customer By Id Process Begins---");
		return ResponseEntity.ok(this.getServiceManager().getCustomerService().deleteCustomer(custId));

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer() {
		return null;
	}

	@RequestMapping(value = "/downloadCustPDF/{custId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> downloadCustPDF(@PathVariable Long custId) throws IOException {
		return this.getServiceManager().getDownloadService().customerPdfDownload(custId);

	}
}

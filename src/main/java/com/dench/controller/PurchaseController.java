package com.dench.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dench.entity.PurchaseEnquiry;
import com.dench.entity.PurchaseQuatation;

@RestController
@RequestMapping("/purchase")
public class PurchaseController extends ControllerManager {
	private static final Logger logger = LogManager.getLogger(PurchaseController.class);

	@PostMapping("/enquiry/add-new")
	public ResponseEntity<?> addPurchaseEnquiry(@Valid @RequestBody PurchaseEnquiry purchaseEnq, Errors error) {
		logger.info("Adding Purchase Enquiry Procedd Begins----");
		if (error.hasErrors())
			return ResponseEntity.ok(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return new ResponseEntity<>(this.getServiceManager().getPurchaseService().addNewPurchaseEnquiry(purchaseEnq),
				HttpStatus.OK);
	}

	@GetMapping("/enquiry/find-by-id/{purchaseEnqId}")
	public ResponseEntity<?> findPurchaseEnquiry(@PathVariable Long purchaseEnqId) {
		logger.info("Finding Purchase Enquire By Id Begin----");
		if (purchaseEnqId == null)
			throw new NullPointerException("Please Enter Purchase Enquiry No.");
		return new ResponseEntity<>(
				this.getServiceManager().getPurchaseService().findPurchaseEnquiryById(purchaseEnqId), HttpStatus.OK);
	}

	@PostMapping("/quatation/add-new")
	public ResponseEntity<?> addPurchasePurchaseQuatation(@Valid @RequestBody PurchaseQuatation purchaseQuatation,
			Errors error) {
		logger.info("Adding Purchase Quatation Process Begins----");
		if (error.hasErrors())
			return ResponseEntity.ok(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return new ResponseEntity<>(
				this.getServiceManager().getPurchaseService().addNewPurchaseQuatation(purchaseQuatation),
				HttpStatus.OK);
	}

	@GetMapping("/quatation/find-by-id/{purchaseEnqId}")
	public ResponseEntity<?> findPurchaseQuatationById(@PathVariable Long purchaseQuatationId) {
		logger.info("Finding Purchase Quatation By Id Begin----");
		if (purchaseQuatationId == null)
			throw new NullPointerException("Please Enter Purchase Enquiry No.");
		return new ResponseEntity<>(
				this.getServiceManager().getPurchaseService().finPurchaseQuatationById(purchaseQuatationId),
				HttpStatus.OK);
	}
}

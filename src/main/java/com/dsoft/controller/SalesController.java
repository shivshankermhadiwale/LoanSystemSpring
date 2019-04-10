package com.dsoft.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsoft.entity.SalesEnquiry;

@RestController
@RequestMapping("/sales")
public class SalesController extends ControllerManager {
	private Logger logger = LogManager.getLogger(SalesController.class);

	@PostMapping("/enquiry/addNew")
	public ResponseEntity<?> addNewSaleEnqu(@RequestBody SalesEnquiry salesEnqury) {
		logger.info(":Adding New Sales Enquiry Proceess Begins...... ");
		return ResponseEntity.ok(this.getServiceManager().getSalesService().addNewSalesEnq(salesEnqury));
	}

	@GetMapping("/enquiry/findById/{salesEnqId}")
	public ResponseEntity<?> findSalesEnqById(@PathVariable Long salesEnqId) {
		logger.info(":Adding New Sales Enquiry Proceess Begins...... ");
		return ResponseEntity.ok(this.getServiceManager().getSalesService().getSalesEnqById(salesEnqId));
	}
}

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

import com.dench.entity.Supplier;

@RestController
@RequestMapping("/supplier")
public class SupplierController extends ControllerManager {
	private static final Logger logger = LogManager.getLogger(ControllerManager.class);

	@PostMapping("/new-supplier")
	public ResponseEntity<?> addNewSupplier(@Valid @RequestBody Supplier supplier, Errors error) {
		logger.info("Adding New Supplier Process Begins---");
		if (error.hasErrors())
			return ResponseEntity.ok(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()));
		return new ResponseEntity<>(this.getServiceManager().getSupplierService().addNewSupplier(supplier),
				HttpStatus.OK);

	}

	@GetMapping("/find-by-id/{suppId}")
	public ResponseEntity<?> findSupplierById(@PathVariable Long suppId) {
		logger.info("Finding Supplier By ID Process Begins---");
		if (suppId == null)
			throw new NullPointerException("Supplier Id Is Empty");
		return new ResponseEntity<>(this.getServiceManager().getSupplierService().findSupplierById(suppId),
				HttpStatus.OK);
	}

}

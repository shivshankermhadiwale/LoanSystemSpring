package com.hgapp.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgapp.dto.ExpenseDto;
import com.hgapp.entity.ExpenseTypes;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController extends ControllerManager {
	@PostMapping(value = "/add-details")
	public ResponseEntity<?> addExpenseDetails(@Valid @RequestBody ExpenseDto expenseDetailDto, Errors errors) {
		if (errors.hasErrors())
			return new ResponseEntity<>(
					errors.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(this.getServiceManager().getExpenseService().addExpenses(expenseDetailDto));

	}

	@PostMapping(value = "/add-expense-type")
	public ResponseEntity<?> addExpenseTypes(@RequestBody ExpenseTypes expenseTypes) {
		return ResponseEntity.ok(this.getServiceManager().getExpenseService().addExpenseTypes(expenseTypes));
	}

	@GetMapping(value = "/get-expense-types")
	public ResponseEntity<?> getExpenseTypes() {
		return ResponseEntity.ok(this.getServiceManager().getExpenseService().getAllExpenseTypes());
	}

	@PostMapping(value = "/get-expense-detail")
	public ResponseEntity<?> getExpenseDetailByDate(@RequestBody ExpenseDto expenseDto) {
		return ResponseEntity.ok(this.getServiceManager().getExpenseService().getExpenseDetailByDate(expenseDto));
	}

}

package com.hgapp.service;

import java.util.List;

import com.hgapp.dto.ExpenseDto;
import com.hgapp.entity.ExpenseDetail;
import com.hgapp.entity.ExpenseTypes;

public interface ExpenseService {
	public ExpenseDto addExpenses(ExpenseDto expenseDetailDto);

	public List<ExpenseDetail> getExpenseDetailByDate(ExpenseDto expenseDto);

	public List<ExpenseTypes> getAllExpenseTypes();

	public ExpenseTypes addExpenseTypes(ExpenseTypes expenseTypes);

}

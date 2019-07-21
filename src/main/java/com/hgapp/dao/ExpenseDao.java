package com.hgapp.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hgapp.entity.ExpenseDetail;
import com.hgapp.entity.ExpenseTypes;

public interface ExpenseDao {
	public ExpenseTypes addExpenseTypes(ExpenseTypes expenseTypes);

	public List<ExpenseTypes> getAllExpenseTypes();

	public ExpenseDetail addExpense(ExpenseDetail expenseDetail);

	public List<ExpenseDetail> getExpenseDetailByDate(LocalDate fromDate, LocalDate toDate);

	public Optional<ExpenseTypes> getExpenseTypeById(Long expenseTypeId);
}

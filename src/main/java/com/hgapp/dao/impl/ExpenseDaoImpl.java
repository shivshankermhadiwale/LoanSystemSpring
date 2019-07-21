package com.hgapp.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgapp.dao.ExpenseDao;
import com.hgapp.entity.ExpenseDetail;
import com.hgapp.entity.ExpenseTypes;
import com.hgapp.repositories.ExpenseDetailRepo;
import com.hgapp.repositories.ExpenseTypesRepo;
@Repository
public class ExpenseDaoImpl implements ExpenseDao {

	@Autowired
	ExpenseDetailRepo expenseDetailRepo;
	@Autowired
	ExpenseTypesRepo expenseTypeRepo;

	@Override
	public ExpenseDetail addExpense(ExpenseDetail expenseDetail) {
		return expenseDetailRepo.save(expenseDetail);
	}

	@Override
	public ExpenseTypes addExpenseTypes(ExpenseTypes expenseTypes) {
		return expenseTypeRepo.save(expenseTypes);
	}

	@Override
	public List<ExpenseTypes> getAllExpenseTypes() {
		return (List<ExpenseTypes>) expenseTypeRepo.findAll();
	}

	@Override
	public List<ExpenseDetail> getExpenseDetailByDate(LocalDate fromDate, LocalDate toDate) {
		return expenseDetailRepo.getExpenseDetailByDate(fromDate, toDate);
	}

	public Optional<ExpenseTypes> getExpenseTypeById(Long expenseTypeId) {
		return expenseTypeRepo.findById(expenseTypeId);
	}

}

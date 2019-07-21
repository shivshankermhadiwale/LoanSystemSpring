package com.hgapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hgapp.dto.ExpenseDto;
import com.hgapp.entity.ExpenseDetail;
import com.hgapp.entity.ExpenseTypes;
import com.hgapp.exception.RecordNotFound;
import com.hgapp.service.DaoServicess;
import com.hgapp.service.ExpenseService;

@Service
public class ExpenseServiceImpl extends DaoServicess implements ExpenseService {

	@Override
	public ExpenseDto addExpenses(ExpenseDto expenseDetailDto) {
		Optional<ExpenseTypes> expenseTypes = this.getDaoManager().getExpenseDao()
				.getExpenseTypeById(expenseDetailDto.getExpenseTypeId());
		if (!expenseTypes.isPresent())
			throw new RecordNotFound("Expense Type Not Exist");
		ExpenseDetail expenseDetail = new ExpenseDetail();
		expenseDetail.setExpenseType(expenseTypes.get());
		expenseDetail.setFromDate(expenseDetailDto.getFromDate());
		expenseDetail.setToDate(expenseDetailDto.getToDate());
		expenseDetail.setRemark(expenseDetailDto.getRemark());
		expenseDetail.setAmount(expenseDetailDto.getAmount());
		expenseDetail = this.getDaoManager().getExpenseDao().addExpense(expenseDetail);
		expenseDetailDto.setExpenseId(expenseDetail.getExpenseId());
		return expenseDetailDto;
	}

	@Override
	public List<ExpenseDetail> getExpenseDetailByDate(ExpenseDto expenseDto) {
		return this.getDaoManager().getExpenseDao().getExpenseDetailByDate(expenseDto.getFromDate(), expenseDto.getToDate());
	}

	@Override
	public List<ExpenseTypes> getAllExpenseTypes() {
		return this.getDaoManager().getExpenseDao().getAllExpenseTypes();
		/*;
		return this.getDaoManager().getExpenseDao().getAllExpenseTypes().stream().filter(expenseName->expenseName.getExpenseType()!=null)
				.collect(Collectors.toMap(ExpenseTypes::getExpenseTypeId, ExpenseTypes::getExpenseType));
	*/}

	@Override
	public ExpenseTypes addExpenseTypes(ExpenseTypes reqExpenseTypes) {
		if (reqExpenseTypes.getExpenseType() == null && reqExpenseTypes.getExpenseType().length() < 0)
			throw new NullPointerException("expense type may not be null/empty");
		ExpenseTypes expenseTypes = new ExpenseTypes();
		expenseTypes.setExpenseType(reqExpenseTypes.getExpenseType());
		expenseTypes.setLastUpodatedDate(LocalDate.now());
		expenseTypes = this.getDaoManager().getExpenseDao().addExpenseTypes(expenseTypes);
		return expenseTypes;
	}

}

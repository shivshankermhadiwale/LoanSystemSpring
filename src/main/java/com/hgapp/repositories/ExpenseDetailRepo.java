package com.hgapp.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hgapp.entity.ExpenseDetail;

public interface ExpenseDetailRepo extends CrudRepository<ExpenseDetail, Long> {
	@Query(" from ExpenseDetail where fromDate>=:fromDate and toDate>=:toDate")
	List<ExpenseDetail> getExpenseDetailByDate(@Param("fromDate") LocalDate fromDate,
			@Param("toDate") LocalDate toDate);

}

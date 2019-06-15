package com.hgapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanPenalty;

public interface LoanPenaltyRepo extends CrudRepository<LoanPenalty, Long>{
	public List<LoanPenalty> findByLoanAccountId(LoanAccountDetail accountDetail);

}

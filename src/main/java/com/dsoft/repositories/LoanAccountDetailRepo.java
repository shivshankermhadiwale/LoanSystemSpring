package com.dsoft.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.LoanAccountDetail;

public interface LoanAccountDetailRepo extends CrudRepository<LoanAccountDetail, Long> {

	public List<LoanAccountDetail> findByCustId(CustPersionalDetail custId);
}

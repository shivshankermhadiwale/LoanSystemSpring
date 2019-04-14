package com.dsoft.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dsoft.entity.LoanAccountDetail;
import com.dsoft.entity.LoanInstallmentsDetail;

public interface LoanEMIDetailRepo extends CrudRepository<LoanInstallmentsDetail, Long> {
	public List<LoanInstallmentsDetail> getLoanInstallmentsByLoanAccouuntNo(LoanAccountDetail accountDetail);

}

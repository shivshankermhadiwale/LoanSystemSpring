package com.hgapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;

public interface LoanEMIDetailRepo extends CrudRepository<LoanInstallmentsDetail, Long> {
	public List<LoanInstallmentsDetail> getLoanInstallmentsByLoanAccouuntNo(LoanAccountDetail accountDetail);

}

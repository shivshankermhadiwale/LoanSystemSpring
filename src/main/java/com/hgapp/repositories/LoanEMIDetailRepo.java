package com.hgapp.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hgapp.entity.LoanAccountDetail;
import com.hgapp.entity.LoanInstallmentsDetail;

public interface LoanEMIDetailRepo extends CrudRepository<LoanInstallmentsDetail, Long> {
	public List<LoanInstallmentsDetail> getLoanInstallmentsByLoanAccouuntNo(LoanAccountDetail accountDetail);

	@Query("from LoanInstallmentsDetail where paymentDate=:paymentDate")
	public List<LoanInstallmentsDetail> getInstallmentDetailsByDate(@Param("paymentDate") LocalDate paymentDate);

}

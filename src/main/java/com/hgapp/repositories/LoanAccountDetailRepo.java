package com.hgapp.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hgapp.entity.CustomerDetail;
import com.hgapp.entity.LoanAccountDetail;

public interface LoanAccountDetailRepo extends CrudRepository<LoanAccountDetail, Long> {

	public List<LoanAccountDetail> findByCustId(CustomerDetail custId);
	public List<LoanAccountDetail> findByLoanStatus(String loanStatus);

	@Modifying(clearAutomatically = true)
	@Query("update LoanAccountDetail loanDetail SET loanDetail.loanStatus=:status,loanDetail.lastUpdated=:lastUpdated,loanDetail.remark=:remark where loanDetail.loanAccountNo=:loanAccountNo")
	public int closeLoanAccount(@Param("status") String status, @Param("lastUpdated") LocalDate lastUpdated,
			@Param("remark") String remark, @Param("loanAccountNo") Long loanAccountNo);
}

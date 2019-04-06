package com.dench.dao;

import com.dench.entity.LoanAccountDetail;
import com.dench.entity.LoanEMIDetail;

public interface LoanAmountDao {
 public LoanAccountDetail createLoanNewAccount(LoanAccountDetail accountDetail);
 public LoanEMIDetail addPayment(LoanEMIDetail emiDetail);
}

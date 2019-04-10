package com.dsoft.dao;

import com.dsoft.entity.LoanAccountDetail;
import com.dsoft.entity.LoanEMIDetail;

public interface LoanAmountDao {
 public LoanAccountDetail createLoanNewAccount(LoanAccountDetail accountDetail);
 public LoanEMIDetail addPayment(LoanEMIDetail emiDetail);
}

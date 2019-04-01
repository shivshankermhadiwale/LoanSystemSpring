package com.dench.repositories;
import org.springframework.data.repository.CrudRepository;

import com.dench.entity.CustPersionalDetail;
import com.dench.entity.CustomerAudit;

public interface CustomerAuditRepo extends CrudRepository<CustomerAudit,Long >{
	public CustomerAudit findByCustomer(CustPersionalDetail customer);
}

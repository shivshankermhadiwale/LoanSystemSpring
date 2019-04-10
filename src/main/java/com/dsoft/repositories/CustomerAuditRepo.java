package com.dsoft.repositories;
import org.springframework.data.repository.CrudRepository;

import com.dsoft.entity.CustPersionalDetail;
import com.dsoft.entity.CustomerAudit;

public interface CustomerAuditRepo extends CrudRepository<CustomerAudit,Long >{
	public CustomerAudit findByCustomer(CustPersionalDetail customer);
}

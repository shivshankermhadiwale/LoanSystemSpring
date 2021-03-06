package com.hgapp.service.impl;
/*package com.dsoft.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.dsoft.entity.SalesEnquiry;
import com.dsoft.entity.SalesEnquiryAudit;
import com.dsoft.exception.RecordNotFound;
import com.dsoft.service.DaoServicess;
import com.dsoft.service.SalesService;

@Service
public class SalesServiceImpl extends DaoServicess implements SalesService {

	@Override
	public SalesEnquiry addNewSalesEnq(SalesEnquiry salesEnq) {
		SalesEnquiryAudit salesEnqAudit = new SalesEnquiryAudit();
		salesEnqAudit.setAction("Created");
		salesEnqAudit.setLastUpdatedDatetime(LocalDateTime.now());
		salesEnqAudit.setLastUpdatedUserDesignation("NA");
		salesEnqAudit.setLastUpdatedUserId("1");
		salesEnqAudit.setLastUpdatedUserName("NA");
		salesEnqAudit.setLoggedInUserId("1");
		salesEnqAudit.setUserDesignation("NA");
		salesEnqAudit.setUserName("NA");
		salesEnqAudit.setSalesEnquirey(salesEnq);
		salesEnqAudit.setCreatedOnDateTime(LocalDateTime.now());
		salesEnq.setSalesEnqAudit(salesEnqAudit);
		return this.getDaoManager().getSalesDao().addNewSalesEnq(salesEnq);
	}

	@Override
	public SalesEnquiry getSalesEnqById(Long salesEnqId) {
		Optional<SalesEnquiry> salesEnq = this.getDaoManager().getSalesDao().getSalesEnqById(salesEnqId);
		if (!salesEnq.isPresent())
			throw new RecordNotFound("Record Not Exist");
		return salesEnq.get();
	}

}
*/
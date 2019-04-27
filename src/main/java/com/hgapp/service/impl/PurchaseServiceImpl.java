package com.hgapp.service.impl;
/*package com.dsoft.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.dsoft.entity.PurchaseEnquiry;
import com.dsoft.entity.PurchaseEnquiryAudit;
import com.dsoft.entity.PurchaseQuatation;
import com.dsoft.entity.PurchaseQuatationAudit;
import com.dsoft.exception.RecordNotFound;
import com.dsoft.service.DaoServicess;
import com.dsoft.service.PurchaseService;

@Service
public class PurchaseServiceImpl extends DaoServicess implements PurchaseService {

	@Override
	public PurchaseEnquiry addNewPurchaseEnquiry(PurchaseEnquiry purchaseEnquiry) {
		PurchaseEnquiryAudit purchaseEnqAudit = new PurchaseEnquiryAudit();
		purchaseEnqAudit.setAction("Created");
		purchaseEnqAudit.setLastUpdatedDatetime(LocalDateTime.now());
		purchaseEnqAudit.setLastUpdatedUserDesignation("NA");
		purchaseEnqAudit.setLastUpdatedUserId("1");
		purchaseEnqAudit.setLastUpdatedUserName("NA");
		purchaseEnqAudit.setLoggedInUserId("1");
		purchaseEnqAudit.setUserDesignation("NA");
		purchaseEnqAudit.setUserName("NA");
		purchaseEnqAudit.setPurchaseEnquirey(purchaseEnquiry);
		purchaseEnqAudit.setCreatedOnDateTime(LocalDateTime.now());
		purchaseEnquiry.setPurchaseEnqAudit(purchaseEnqAudit);

		return this.getDaoManager().getPurchaseDao().addNewPurchaseEnquiry(purchaseEnquiry);
	}

	@Override
	public PurchaseEnquiry findPurchaseEnquiryById(Long purchaseEnqId) {
		Optional<PurchaseEnquiry> purchaseEnq = this.getDaoManager().getPurchaseDao()
				.findPurchaseEnquiryById(purchaseEnqId);
		if (!purchaseEnq.isPresent())
			throw new RecordNotFound("Purchase Enquiry Not Found");
		return purchaseEnq.get();
	}

	@Override
	public PurchaseQuatation addNewPurchaseQuatation(PurchaseQuatation purchaseQuatation) {
		PurchaseQuatationAudit purchaseQuaAudit = new PurchaseQuatationAudit();
		purchaseQuaAudit.setAction("Created");
		purchaseQuaAudit.setLastUpdatedDatetime(LocalDateTime.now());
		purchaseQuaAudit.setLastUpdatedUserDesignation("NA");
		purchaseQuaAudit.setLastUpdatedUserId("1");
		purchaseQuaAudit.setLastUpdatedUserName("NA");
		purchaseQuaAudit.setLoggedInUserId("1");
		purchaseQuaAudit.setUserDesignation("NA");
		purchaseQuaAudit.setUserName("NA");
		purchaseQuaAudit.setPurchaseQuatation(purchaseQuatation);
		purchaseQuaAudit.setCreatedOnDateTime(LocalDateTime.now());
		purchaseQuatation.setPurchaseQuatationAudit(purchaseQuaAudit);
		return this.getDaoManager().getPurchaseDao().addNewPurchaseQuatation(purchaseQuatation);
	}

	@Override
	public PurchaseQuatation finPurchaseQuatationById(Long purchaseQuatationId) {
		Optional<PurchaseQuatation> purchaseQuatation = this.getDaoManager().getPurchaseDao()
				.finPurchaseQuatationById(purchaseQuatationId);
		if (!purchaseQuatation.isPresent())
			throw new RecordNotFound("Purchase Quatation Not Found");
		return purchaseQuatation.get();
	}

}
*/
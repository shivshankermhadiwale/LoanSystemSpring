package com.dsoft.service;

import com.dsoft.entity.PurchaseEnquiry;
import com.dsoft.entity.PurchaseQuatation;

public interface PurchaseService {
	public PurchaseEnquiry addNewPurchaseEnquiry(PurchaseEnquiry purchaseEnquiry);

	public PurchaseEnquiry findPurchaseEnquiryById(Long purchaseEnqId);

	public PurchaseQuatation addNewPurchaseQuatation(PurchaseQuatation purchaseQuatation);

	public PurchaseQuatation finPurchaseQuatationById(Long purchaseQuatationId);
}

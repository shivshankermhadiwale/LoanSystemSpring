package com.dench.service;

import com.dench.entity.PurchaseEnquiry;
import com.dench.entity.PurchaseQuatation;

public interface PurchaseService {
	public PurchaseEnquiry addNewPurchaseEnquiry(PurchaseEnquiry purchaseEnquiry);

	public PurchaseEnquiry findPurchaseEnquiryById(Long purchaseEnqId);

	public PurchaseQuatation addNewPurchaseQuatation(PurchaseQuatation purchaseQuatation);

	public PurchaseQuatation finPurchaseQuatationById(Long purchaseQuatationId);
}

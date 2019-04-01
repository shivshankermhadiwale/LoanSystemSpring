package com.dench.dao;

import java.util.Optional;

import com.dench.entity.PurchaseEnquiry;
import com.dench.entity.PurchaseQuatation;

public interface PurchaseDao {
	public PurchaseEnquiry addNewPurchaseEnquiry(PurchaseEnquiry purchaseEnquiry);

	public Optional<PurchaseEnquiry> findPurchaseEnquiryById(Long purchaseEnqId);

	public PurchaseQuatation addNewPurchaseQuatation(PurchaseQuatation purchaseQuatation);

	public Optional<PurchaseQuatation> finPurchaseQuatationById(Long purchaseQuatationId);
}

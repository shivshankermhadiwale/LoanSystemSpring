package com.dench.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dench.dao.PurchaseDao;
import com.dench.entity.PurchaseEnquiry;
import com.dench.entity.PurchaseQuatation;
import com.dench.repositories.PurchaseEnqRepository;
import com.dench.repositories.PurchaseQuatationRepository;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
	@Autowired
	private PurchaseEnqRepository purchaseEnqRepo;
	@Autowired
	PurchaseQuatationRepository purchaseQuatationRepo;

	@Override
	public PurchaseEnquiry addNewPurchaseEnquiry(PurchaseEnquiry purchaseEnquiry) {
		return purchaseEnqRepo.save(purchaseEnquiry);
	}

	@Override
	public Optional<PurchaseEnquiry> findPurchaseEnquiryById(Long purchaseEnqId) {
		return purchaseEnqRepo.findById(purchaseEnqId);
	}

	@Override
	public PurchaseQuatation addNewPurchaseQuatation(PurchaseQuatation purchaseQuatation) {
		return purchaseQuatationRepo.save(purchaseQuatation);
	}

	@Override
	public Optional<PurchaseQuatation> finPurchaseQuatationById(Long purchaseQuatationId) {
		return purchaseQuatationRepo.findById(purchaseQuatationId);
	}

}

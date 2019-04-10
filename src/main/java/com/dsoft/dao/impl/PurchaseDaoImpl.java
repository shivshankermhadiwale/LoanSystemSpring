package com.dsoft.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsoft.dao.PurchaseDao;
import com.dsoft.entity.PurchaseEnquiry;
import com.dsoft.entity.PurchaseQuatation;
import com.dsoft.repositories.PurchaseEnqRepository;
import com.dsoft.repositories.PurchaseQuatationRepository;

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

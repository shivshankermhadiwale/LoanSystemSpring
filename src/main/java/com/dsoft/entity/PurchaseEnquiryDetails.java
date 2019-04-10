package com.dsoft.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_Enquiry_Details")
public class PurchaseEnquiryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long peDetailId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_enqu_id")
	private PurchaseEnquiry purchaseEnquiry;
	private String itemName;
	private String RMSubGrade;
	private String RMSize;
	private Double rate;

	public Long getPeDetailId() {
		return peDetailId;
	}

	public PurchaseEnquiry getPurchaseEnquiry() {
		return purchaseEnquiry;
	}

	public String getItemName() {
		return itemName;
	}

	public String getRMSubGrade() {
		return RMSubGrade;
	}

	public String getRMSize() {
		return RMSize;
	}

	public Double getRate() {
		return rate;
	}

	public void setPeDetailId(Long peDetailId) {
		this.peDetailId = peDetailId;
	}

	public void setPurchaseEnquiry(PurchaseEnquiry purchaseEnquiry) {
		this.purchaseEnquiry = purchaseEnquiry;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setRMSubGrade(String rMSubGrade) {
		RMSubGrade = rMSubGrade;
	}

	public void setRMSize(String rMSize) {
		RMSize = rMSize;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

}

package com.dsoft.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase_quatation_detail")
public class PurchaseQuatationDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long quatationDetailId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="purchase_quatation_id")
	private PurchaseQuatation purchaseQuatation;
	private String itemName;
	private String RMSubGrade;
	private String RMSize;
	private Integer quantity;
	private String rate;
	public Long getQuatationDetailId() {
		return quatationDetailId;
	}
	public PurchaseQuatation getPurchaseQuatation() {
		return purchaseQuatation;
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
	public Integer getQuantity() {
		return quantity;
	}
	public String getRate() {
		return rate;
	}
	public void setQuatationDetailId(Long quatationDetailId) {
		this.quatationDetailId = quatationDetailId;
	}
	public void setPurchaseQuatation(PurchaseQuatation purchaseQuatation) {
		this.purchaseQuatation = purchaseQuatation;
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
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	

}

package com.dench.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_quatation")
public class PurchaseQuatation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseQuatationId;
	@OneToOne
	@JoinColumn(name = "supp_id")
	private Supplier supplier;
	private String quatationNo;
	private LocalDateTime quatationdate;
	private String termsAndCondition;
	private Double purchaseQuatationAmt;
	private Boolean isDeleted;
	@OneToMany(mappedBy = "purchaseQuatation")
	private Set<PurchaseQuatationDetail> purchaseQuataionDetails = new HashSet<PurchaseQuatationDetail>();
	@OneToOne(fetch=FetchType.LAZY,mappedBy="purchaseQuatation",cascade=CascadeType.ALL)
	private PurchaseQuatationAudit purchaseQuatationAudit;
	
	public PurchaseQuatationAudit getPurchaseQuatationAudit() {
		return purchaseQuatationAudit;
	}

	public void setPurchaseQuatationAudit(PurchaseQuatationAudit purchaseQuatationAudit) {
		this.purchaseQuatationAudit = purchaseQuatationAudit;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<PurchaseQuatationDetail> getPurchaseQuataionDetails() {
		return purchaseQuataionDetails;
	}

	public void setPurchaseQuataionDetails(Set<PurchaseQuatationDetail> purchaseQuataionDetails) {
		this.purchaseQuataionDetails = purchaseQuataionDetails;
	}

	public Long getPurchaseQuatationId() {
		return purchaseQuatationId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public String getQuatationNo() {
		return quatationNo;
	}

	public LocalDateTime getQuatationdate() {
		return quatationdate;
	}

	public String getTermsAndCondition() {
		return termsAndCondition;
	}

	public void setPurchaseQuatationId(Long purchaseQuatationId) {
		this.purchaseQuatationId = purchaseQuatationId;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setQuatationNo(String quatationNo) {
		this.quatationNo = quatationNo;
	}

	public void setQuatationdate(LocalDateTime quatationdate) {
		this.quatationdate = quatationdate;
	}

	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	public Double getPurchaseQuatationAmt() {
		return purchaseQuatationAmt;
	}

	public void setPurchaseQuatationAmt(Double purchaseQuatationAmt) {
		this.purchaseQuatationAmt = purchaseQuatationAmt;
	}


}

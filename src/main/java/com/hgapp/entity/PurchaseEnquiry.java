package com.hgapp.entity;
/*package com.dsoft.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "purchase_enquiry")
public class PurchaseEnquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseEnquId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supp_id")
	private Supplier supplier;
	@OneToMany(mappedBy = "purchaseEnquiry")
	private Set<PurchaseEnquiryDetails> purchaseEnqDetails = new HashSet<PurchaseEnquiryDetails>();
	private String Enqno;
	private LocalDate enqDate;
	private String termsAndCond;
	private boolean isDeleted=false;
	@OneToOne(mappedBy = "purchaseEnquirey", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PurchaseEnquiryAudit purchaseEnqAudit;

	public PurchaseEnquiryAudit getPurchaseEnqAudit() {
		return purchaseEnqAudit;
	}

	public void setPurchaseEnqAudit(PurchaseEnquiryAudit purchaseEnqAudit) {
		this.purchaseEnqAudit = purchaseEnqAudit;
	}

	public Set<PurchaseEnquiryDetails> getPurchaseEnqDetails() {
		return purchaseEnqDetails;
	}

	public void setPurchaseEnqDetails(Set<PurchaseEnquiryDetails> purchaseEnqDetails) {
		this.purchaseEnqDetails = purchaseEnqDetails;
	}

	
	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getEnqno() {
		return Enqno;
	}

	public void setEnqno(String enqno) {
		Enqno = enqno;
	}

	public Long getPurchaseEnquId() {
		return purchaseEnquId;
	}

	public void setPurchaseEnquId(Long purchaseEnquId) {
		this.purchaseEnquId = purchaseEnquId;
	}

	public LocalDate getEnqDate() {
		return enqDate;
	}

	public void setEnqDate(LocalDate enqDate) {
		this.enqDate = enqDate;
	}

	public String getTermsAndCond() {
		return termsAndCond;
	}

	public void setTermsAndCond(String termsAndCond) {
		this.termsAndCond = termsAndCond;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}
*/
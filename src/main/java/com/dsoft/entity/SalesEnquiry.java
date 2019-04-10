package com.dsoft.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales_enquiry")
public class SalesEnquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long selesEnqId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private CustPersionalDetail customer;
	private String enqNo;
	private LocalDate enqDate;
	private String termsAndCond;
	private boolean isDeleted;
	@OneToMany(mappedBy = "salesEnquiry")
	private Set<SalesEnquiryDetails> salesEnqDetails = new HashSet<SalesEnquiryDetails>();
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "salesEnquirey", cascade = CascadeType.ALL)
	private SalesEnquiryAudit salesEnqAudit;

	public Set<SalesEnquiryDetails> getSalesEnqDetails() {
		return salesEnqDetails;
	}

	public void setSalesEnqDetails(Set<SalesEnquiryDetails> salesEnqDetails) {
		this.salesEnqDetails = salesEnqDetails;
	}

	public Long getSelesEnqId() {
		return selesEnqId;
	}

	public CustPersionalDetail getCustomer() {
		return customer;
	}

	public LocalDate getEnqDate() {
		return enqDate;
	}

	public String getTermsAndCond() {
		return termsAndCond;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setSelesEnqId(Long selesEnqId) {
		this.selesEnqId = selesEnqId;
	}

	public void setCustomer(CustPersionalDetail customer) {
		this.customer = customer;
	}

	public String getEnqNo() {
		return enqNo;
	}

	public SalesEnquiryAudit getSalesEnqAudit() {
		return salesEnqAudit;
	}

	public void setEnqNo(String enqNo) {
		this.enqNo = enqNo;
	}

	public void setSalesEnqAudit(SalesEnquiryAudit salesEnqAudit) {
		this.salesEnqAudit = salesEnqAudit;
	}

	public void setEnqDate(LocalDate enqDate) {
		this.enqDate = enqDate;
	}

	public void setTermsAndCond(String termsAndCond) {
		this.termsAndCond = termsAndCond;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}

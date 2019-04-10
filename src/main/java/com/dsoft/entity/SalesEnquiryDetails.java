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
@Table(name = "sales_enqu_details")
public class SalesEnquiryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salesEnquDetailId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sales_enqu_id")
	private SalesEnquiry salesEnquiry;
	private String itemName;
	private String RMSubGrade;
	private String RMSize;
	private Double rate;

	public Long getSalesEnquDetailId() {
		return salesEnquDetailId;
	}

	public SalesEnquiry getSalesEnquiry() {
		return salesEnquiry;
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

	public void setSalesEnquDetailId(Long salesEnquDetailId) {
		this.salesEnquDetailId = salesEnquDetailId;
	}

	public void setSalesEnquiry(SalesEnquiry salesEnquiry) {
		this.salesEnquiry = salesEnquiry;
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

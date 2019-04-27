package com.hgapp.entity;
/*package com.dsoft.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Purchase_Enquiry_Audit")
public class PurchaseEnquiryAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseAuditId;
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = " purchase_enqu_id")
	private PurchaseEnquiry purchaseEnquirey;
	private String loggedInUserId;
	private String userName;
	private String userDesignation;
	private LocalDateTime createdOnDateTime;
	private String lastUpdatedUserId;
	private String lastUpdatedUserName;
	private String lastUpdatedUserDesignation;
	private LocalDateTime lastUpdatedDatetime;
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getPurchaseAuditId() {
		return purchaseAuditId;
	}

	public PurchaseEnquiry getPurchaseEnquirey() {
		return purchaseEnquirey;
	}

	public String getLoggedInUserId() {
		return loggedInUserId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public String getLastUpdatedUserId() {
		return lastUpdatedUserId;
	}

	public String getLastUpdatedUserName() {
		return lastUpdatedUserName;
	}

	public String getLastUpdatedUserDesignation() {
		return lastUpdatedUserDesignation;
	}

	public void setPurchaseAuditId(Long purchaseAuditId) {
		this.purchaseAuditId = purchaseAuditId;
	}

	public void setPurchaseEnquirey(PurchaseEnquiry purchaseEnquirey) {
		this.purchaseEnquirey = purchaseEnquirey;
	}

	public void setLoggedInUserId(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

	public void setLastUpdatedUserId(String lastUpdatedUserId) {
		this.lastUpdatedUserId = lastUpdatedUserId;
	}

	public void setLastUpdatedUserName(String lastUpdatedUserName) {
		this.lastUpdatedUserName = lastUpdatedUserName;
	}

	public void setLastUpdatedUserDesignation(String lastUpdatedUserDesignation) {
		this.lastUpdatedUserDesignation = lastUpdatedUserDesignation;
	}

	public LocalDateTime getCreatedOnDateTime() {
		return createdOnDateTime;
	}

	public LocalDateTime getLastUpdatedDatetime() {
		return lastUpdatedDatetime;
	}

	public void setCreatedOnDateTime(LocalDateTime createdOnDateTime) {
		this.createdOnDateTime = createdOnDateTime;
	}

	public void setLastUpdatedDatetime(LocalDateTime lastUpdatedDatetime) {
		this.lastUpdatedDatetime = lastUpdatedDatetime;
	}

}
*/
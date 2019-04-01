package com.dench.entity;

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
@Table(name = "purchase_quatation_audit")
public class PurchaseQuatationAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseQuatationAuditId;
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_quatation_id")
	private PurchaseQuatation purchaseQuatation;
	private String loggedInUserId;
	private String userName;
	private String userDesignation;
	private LocalDateTime createdOnDateTime;
	private String lastUpdatedUserId;
	private String lastUpdatedUserName;
	private String lastUpdatedUserDesignation;
	private LocalDateTime lastUpdatedDatetime;
	private String action;

	public Long getPurchaseQuatationAuditId() {
		return purchaseQuatationAuditId;
	}

	public PurchaseQuatation getPurchaseQuatation() {
		return purchaseQuatation;
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

	public String getAction() {
		return action;
	}

	public void setPurchaseQuatationAuditId(Long purchaseQuatationAuditId) {
		this.purchaseQuatationAuditId = purchaseQuatationAuditId;
	}

	public void setPurchaseQuatation(PurchaseQuatation purchaseQuatation) {
		this.purchaseQuatation = purchaseQuatation;
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

	public void setAction(String action) {
		this.action = action;
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

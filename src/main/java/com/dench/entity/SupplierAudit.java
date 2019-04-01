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
@Table(name = "Supp_Audit_Info")
public class SupplierAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long suppAuditId;
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supp_id")
	private Supplier supplier;
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

	public String getLastUpdatedUserId() {
		return lastUpdatedUserId;
	}

	public String getLastUpdatedUserName() {
		return lastUpdatedUserName;
	}

	public String getLastUpdatedUserDesignation() {
		return lastUpdatedUserDesignation;
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

	public Long getSuppAuditId() {
		return suppAuditId;
	}

	public void setSuppAuditId(Long suppAuditId) {
		this.suppAuditId = suppAuditId;
	}

	public String getLoggedInUserId() {
		return loggedInUserId;
	}

	public void setLoggedInUserId(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public LocalDateTime getCreatedOnDateTime() {
		return createdOnDateTime;
	}

	public LocalDateTime getLastUpdatedDatetime() {
		return lastUpdatedDatetime;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setCreatedOnDateTime(LocalDateTime createdOnDateTime) {
		this.createdOnDateTime = createdOnDateTime;
	}

	public void setLastUpdatedDatetime(LocalDateTime lastUpdatedDatetime) {
		this.lastUpdatedDatetime = lastUpdatedDatetime;
	}

	

}

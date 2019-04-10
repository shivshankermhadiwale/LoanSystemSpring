package com.dsoft.entity;
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
@Table(name = "salse_enqu_audit")
public class SalesEnquiryAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salesEnuAuditId;
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sales_Enqu_Id")
	private SalesEnquiry salesEnquirey;
	private String loggedInUserId;
	private String userName;
	private String userDesignation;
	private LocalDateTime createdOnDateTime;
	private String lastUpdatedUserId;
	private String lastUpdatedUserName;
	private String lastUpdatedUserDesignation;
	private LocalDateTime lastUpdatedDatetime;
	private String action;
	
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

	public Long getSalesEnuAuditId() {
		return salesEnuAuditId;
	}

	public SalesEnquiry getSalesEnquirey() {
		return salesEnquirey;
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

	public void setSalesEnuAuditId(Long salesEnuAuditId) {
		this.salesEnuAuditId = salesEnuAuditId;
	}

	public void setSalesEnquirey(SalesEnquiry salesEnquirey) {
		this.salesEnquirey = salesEnquirey;
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

}

package com.dench.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "customer")
public class CustPersionalDetail implements Serializable {
	private static final long serialVersionUID = 1288664445708805109L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	private String fullName;
	private String shortName;
	private Short custType;
	private String registrationNo;
	private LocalDate registrationDate;
	private String GSTINNo;
	private String PANNo;
	private String adharNo;
	private Boolean isDeleted=false;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private CustomerAudit custAudit;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<CustContactPersion> custContactPersionsInfo = new HashSet<CustContactPersion>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<CustAddressDetail> custCommunicationInfo = new HashSet<CustAddressDetail>();

	public CustomerAudit getCustAudit() {
		return custAudit;
	}

	public void setCustAudit(CustomerAudit custAudit) {
		this.custAudit = custAudit;
	}

	

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Short getCustType() {
		return custType;
	}

	public void setCustType(Short custType) {
		this.custType = custType;
	}
	

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getGSTINNo() {
		return GSTINNo;
	}

	public void setGSTINNo(String gSTINNo) {
		GSTINNo = gSTINNo;
	}

	public String getPANNo() {
		return PANNo;
	}

	public void setPANNo(String pANNo) {
		PANNo = pANNo;
	}

	public Set<CustContactPersion> getCustContactPersionsInfo() {
		return custContactPersionsInfo;
	}

	public void setCustContactPersionsInfo(Set<CustContactPersion> custContactPersionsInfo) {
		this.custContactPersionsInfo = custContactPersionsInfo;
	}

	public Set<CustAddressDetail> getCustCommunicationInfo() {
		return custCommunicationInfo;
	}

	public void setCustCommunicationInfo(Set<CustAddressDetail> custCommunicationInfo) {
		this.custCommunicationInfo = custCommunicationInfo;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	
}

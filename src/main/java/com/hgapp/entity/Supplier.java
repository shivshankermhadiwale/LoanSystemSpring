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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_Detail")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long suppId;
	private String supplierName;
	private String shortName;
	private String websiteUrl;
	private String supplierCompanyName;
	private Short supplierType;
	private String companyRegistrationIdentificationNo;
	private LocalDate registrationDate;
	private String GSTINNo;
	private String PANNo;
	private Boolean isDeleted=false;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL)
	private Set<SupplierContactPersionsInfo> suppContactPersionsInfo = new HashSet<SupplierContactPersionsInfo>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL)
	private Set<SupplierCommunicationInfo> suppCommunicationInfo = new HashSet<SupplierCommunicationInfo>();
	@OneToOne(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private SupplierAudit suppAudit;

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<SupplierCommunicationInfo> getSuppCommunicationInfo() {
		return suppCommunicationInfo;
	}

	public void setSuppCommunicationInfo(Set<SupplierCommunicationInfo> suppCommunicationInfo) {
		this.suppCommunicationInfo = suppCommunicationInfo;
	}

	public Set<SupplierContactPersionsInfo> getSuppContactPersionsInfo() {
		return suppContactPersionsInfo;
	}

	public void setSuppContactPersionsInfo(Set<SupplierContactPersionsInfo> suppContactPersionsInfo) {
		this.suppContactPersionsInfo = suppContactPersionsInfo;
	}

	public Long getSuppId() {
		return suppId;
	}

	public void setSuppId(Long suppId) {
		this.suppId = suppId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getSupplierCompanyName() {
		return supplierCompanyName;
	}

	public void setSupplierCompanyName(String supplierCompanyName) {
		this.supplierCompanyName = supplierCompanyName;
	}

	public Short getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(Short supplierType) {
		this.supplierType = supplierType;
	}

	public String getCompanyRegistrationIdentificationNo() {
		return companyRegistrationIdentificationNo;
	}

	public void setCompanyRegistrationIdentificationNo(String companyRegistrationIdentificationNo) {
		this.companyRegistrationIdentificationNo = companyRegistrationIdentificationNo;
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

	public SupplierAudit getSuppAudit() {
		return suppAudit;
	}

	public void setSuppAudit(SupplierAudit suppAudit) {
		this.suppAudit = suppAudit;
	}
	
}
*/
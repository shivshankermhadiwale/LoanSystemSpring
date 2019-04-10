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
@Table(name = "Supplier_Communication_Info")
public class SupplierCommunicationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long suppCommunicationId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supp_id")
	private Supplier supplier;
	private String addressType;
	private String address;
	private int city;
	private int district;
	private int state;
	private int country;
	private int zipCode;
	private String email;
	private String LLNo;
	private String mobNo;
	private String altNo;

	public Long getSuppCommunicationId() {
		return suppCommunicationId;
	}

	public void setSuppCommunicationId(Long suppCommunicationId) {
		this.suppCommunicationId = suppCommunicationId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLLNo() {
		return LLNo;
	}

	public void setLLNo(String lLNo) {
		LLNo = lLNo;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getAltNo() {
		return altNo;
	}

	public void setAltNo(String altNo) {
		this.altNo = altNo;
	}
}

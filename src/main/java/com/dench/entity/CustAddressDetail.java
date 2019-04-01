package com.dench.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Communication_Info")
public class CustAddressDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custCommunicationId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private CustPersionalDetail customer;
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

	public Long getCustCommunicationId() {
		return custCommunicationId;
	}

	public void setCustCommunicationId(Long custCommunicationId) {
		this.custCommunicationId = custCommunicationId;
	}

	public CustPersionalDetail getCustomer() {
		return customer;
	}

	public void setCustomer(CustPersionalDetail customer) {
		this.customer = customer;
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

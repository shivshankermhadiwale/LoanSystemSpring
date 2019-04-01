package com.dench.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerDto implements Serializable {
	private static final long serialVersionUID = 415982864064630044L;
	private Long custId;
	private String fullName;
	private String shortName;
	private Short custType;
	private String registrationNo;
	private LocalDate registrationDate;
	private String GSTINNo;
	private String PANNo;
	private String adharNo;
	private AddressDto addressDto = new AddressDto();

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
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

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

}

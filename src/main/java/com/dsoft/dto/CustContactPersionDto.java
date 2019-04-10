package com.dsoft.dto;

import java.io.Serializable;

public class CustContactPersionDto implements Serializable {

	private static final long serialVersionUID = -134229937167465569L;
	private Long custId;
	private String fullName;
	private String designation;
	private AddressDto address = new AddressDto();

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

}

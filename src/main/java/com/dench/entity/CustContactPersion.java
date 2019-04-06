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
@Table(name = "Customer_Contact_Persions_Info")
public class CustContactPersion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custContactPersionId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private CustPersionalDetail customer;
	private String fullName;
	private String email;
	private String contactNo;;
	private String designation;
	

	public Long getCustContactPersionId() {
		return custContactPersionId;
	}

	public void setCustContactPersionId(Long custContactPersionId) {
		this.custContactPersionId = custContactPersionId;
	}
	
	public CustPersionalDetail getCustomer() {
		return customer;
	}

	public void setCustomer(CustPersionalDetail customer) {
		this.customer = customer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getDesignation() {
		return designation;
	}



	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}

package com.hgapp.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contact_Persions")
public class ContactPersion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactPersionId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persion_id")
	private CustomerDetail persionId;
	private String fullName;
	private String designation;
	private String email;
	private String phone1;


	public CustomerDetail getPersionId() {
		return persionId;
	}

	public void setPersionId(CustomerDetail persionId) {
		this.persionId = persionId;
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

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getContactPersionId() {
		return contactPersionId;
	}

	public void setContactPersionId(Long contactPersionId) {
		this.contactPersionId = contactPersionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	

}

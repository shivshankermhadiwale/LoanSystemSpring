package com.dench.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_Contact_Persions_Info")
public class SupplierContactPersionsInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long suppContactPersionId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supp_id")
	private Supplier supplier;
	private String email;
	private String cell;
	private String LLNo;
	private String ExtnNo;
	private String name;
	private String designation;
	private LocalDate DOB;

	public Long getSuppContactPersionId() {
		return suppContactPersionId;
	}

	public void setSuppContactPersionId(Long suppContactPersionId) {
		this.suppContactPersionId = suppContactPersionId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getLLNo() {
		return LLNo;
	}

	public void setLLNo(String lLNo) {
		LLNo = lLNo;
	}

	public String getExtnNo() {
		return ExtnNo;
	}

	public void setExtnNo(String extnNo) {
		ExtnNo = extnNo;
	}

}

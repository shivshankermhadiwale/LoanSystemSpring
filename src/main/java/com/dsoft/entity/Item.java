package com.dsoft.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	private String itemCode;
	private String itemName;
	private String itemDesc;
	private String rmSubGrade;
	private String rmsize;
	private Double price;
	private String purchaseUnit;
	private String bilingUnit;
	private String HSNNo;
	private Double purchaseRate;
	private Double salesRate; 
	private String category;
	private Integer inStock;
	private Integer maximumStock;
	private Integer minimumStoc;
	private String itemSource;
	private String itemProcessFlow;
	private String subCat;
	@ManyToOne
	@JoinColumn(name="supp_id")
	private Supplier supplierName;
	private String conversionRatio;
	@OneToOne(fetch=FetchType.LAZY,mappedBy="item",cascade=CascadeType.ALL)
	private ItemAudit itemAudit=null;
	
	public ItemAudit getItemAudit() {
		return itemAudit;
	}
	public void setItemAudit(ItemAudit itemAudit) {
		this.itemAudit = itemAudit;
	}
	public String getItemSource() {
		return itemSource;
	}
	public String getItemProcessFlow() {
		return itemProcessFlow;
	}
	public String getSubCat() {
		return subCat;
	}
	public Supplier getSupplierName() {
		return supplierName;
	}
	public String getConversionRatio() {
		return conversionRatio;
	}
	public void setItemSource(String itemSource) {
		this.itemSource = itemSource;
	}
	public void setItemProcessFlow(String itemProcessFlow) {
		this.itemProcessFlow = itemProcessFlow;
	}
	public void setSubCat(String subCat) {
		this.subCat = subCat;
	}
	public void setSupplierName(Supplier supplierName) {
		this.supplierName = supplierName;
	}
	public void setConversionRatio(String conversionRatio) {
		this.conversionRatio = conversionRatio;
	}
	public String getPurchaseUnit() {
		return purchaseUnit;
	}
	public String getBilingUnit() {
		return bilingUnit;
	}
	public String getHSNNo() {
		return HSNNo;
	}
	public Double getPurchaseRate() {
		return purchaseRate;
	}
	public Double getSalesRate() {
		return salesRate;
	}
	public String getCategory() {
		return category;
	}
	public Integer getInStock() {
		return inStock;
	}
	public Integer getMaximumStock() {
		return maximumStock;
	}
	public Integer getMinimumStoc() {
		return minimumStoc;
	}
	public String getItemType() {
		return itemType;
	}
	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	public void setBilingUnit(String bilingUnit) {
		this.bilingUnit = bilingUnit;
	}
	public void setHSNNo(String hSNNo) {
		HSNNo = hSNNo;
	}
	public void setPurchaseRate(Double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}
	public void setSalesRate(Double salesRate) {
		this.salesRate = salesRate;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}
	public void setMaximumStock(Integer maximumStock) {
		this.maximumStock = maximumStock;
	}
	public void setMinimumStoc(Integer minimumStoc) {
		this.minimumStoc = minimumStoc;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	private String itemType;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getRmSubGrade() {
		return rmSubGrade;
	}
	public void setRmSubGrade(String rmSubGrade) {
		this.rmSubGrade = rmSubGrade;
	}
	public String getRmsize() {
		return rmsize;
	}
	public void setRmsize(String rmsize) {
		this.rmsize = rmsize;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	

}

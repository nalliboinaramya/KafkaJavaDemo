package com.ikea.kafkademoproject.customserializer;

import java.util.Date;

public class Supplier {
	
	Integer id;
	String supplierName;
	Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Supplier(Integer id, String supplierName, Date date) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.date = date;
	}
	public Supplier() {
	}
	
	

}

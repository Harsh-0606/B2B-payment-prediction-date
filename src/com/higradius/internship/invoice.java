package com.higradius.internship;

import java.sql.*;

public class invoice {
	private String customerNO;
	private Long invoiceNO;
	private Integer invoiceAmount;
	private Date    dueDate;
	private String  customerName;
	private Date PreddictedPaymentDate;
	private String notes;
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	
	public String getCustomerNO() {
		return customerNO;
	}
	public void setCustomerNO(String customerNO) {
		this.customerNO = customerNO;
	}
	public Long getInvoiceNO() {
		return invoiceNO;
	}
	public void setInvoiceNO(Long invoiceNO) {
		this.invoiceNO = invoiceNO;
	}
	public Integer getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(Integer invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getPreddictedPaymentDate() {
		return PreddictedPaymentDate;
	}
	public void setPreddictedPaymentDate(Date preddictedPaymentDate) {
		PreddictedPaymentDate = preddictedPaymentDate;
	}
	
}

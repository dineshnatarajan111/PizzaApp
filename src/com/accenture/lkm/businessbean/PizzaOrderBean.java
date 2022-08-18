package com.accenture.lkm.businessbean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PizzaOrderBean {
	
	private Integer orderId;
	@NotNull
	private Integer pizzaId;
	@Size(min = 3,max = 30)
	private String customerName;
	@Size(max = 10,min = 10)
	private String contactNumber;
	private Double bill;
	@NotNull
	private Integer numberOfPiecesOrdered;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Integer getNumberOfPiecesOrdered() {
		return numberOfPiecesOrdered;
	}
	public void setNumberOfPiecesOrdered(Integer numberOfPiecesOrdered) {
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}
	

}

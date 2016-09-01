package com.xebia.yakshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderInfo {
	private String customer;
	
	@JsonProperty(value="order")
	private YakProducts order;
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public YakProducts getOrder() {
		return order;
	}
	public void setOrder(YakProducts order) {
		this.order = order;
	}
	
	

}

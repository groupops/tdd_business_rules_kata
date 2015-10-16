package com.epam.model;

public class Payment {
	
	private String productName;

	public Payment(String name) {
		this.productName = name;
	}

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}
}

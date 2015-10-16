package com.epam.model;

import java.math.BigDecimal;

public class CommissionPayment {

	private BigDecimal amount;

	public CommissionPayment(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}

package com.epam.process;

import java.math.BigDecimal;
import java.util.List;

import com.epam.model.CommissionPayment;
import com.epam.model.PackingSlip;
import com.epam.model.Payment;

public class PhysicalProductPaymentProcessor implements PaymentProcessor {

	private List<PackingSlip> packingSlips;
	private List<CommissionPayment> commissionPayments;
	
	public PhysicalProductPaymentProcessor(List<PackingSlip> packingSlips, List<CommissionPayment> commissionPayments) {
		this.packingSlips = packingSlips;
		this.commissionPayments = commissionPayments;
	}

	@Override
	public void processPayment(Payment payment) {
		PackingSlip packingSlip = new PackingSlip(payment.getName());
		packingSlips.add(packingSlip);
		
		CommissionPayment commissionPayment = new CommissionPayment(new BigDecimal("5.0"));
		commissionPayments.add(commissionPayment);
	}
}

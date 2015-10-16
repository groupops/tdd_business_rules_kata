package com.epam.process;

import com.epam.model.Membership;
import com.epam.model.Payment;

public class MembershipPaymentProcessor implements PaymentProcessor {

	Membership membership;
	
	public MembershipPaymentProcessor(Membership membership) {
		this.membership = membership;
	}

	@Override
	public void processPayment(Payment payment) {
		membership.setActive(true);
	}

}

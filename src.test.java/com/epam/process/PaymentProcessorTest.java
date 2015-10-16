package com.epam.process;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.epam.model.CommissionPayment;
import com.epam.model.Membership;
import com.epam.model.PackingSlip;
import com.epam.model.Payment;
import com.epam.model.Purpose;

public class PaymentProcessorTest {
	
	// paymentForPhysicalProductPackingSlipGenerated
	// paymentForPhysicalProductCommissionPaymentGenerated
	// paymentForMembershipMembershipActivated
	// paymentForMembershipUpgradeMembershipUpgradeApplied
	// paymentForBookCommissionPaymentGenerated
	// paymentForBookDuplicatePackingCreated
	// paymentForMembershipOwnerInformed
	// paymentForMembershipUpgradeOwnerInformed
	// paymentForVideoLearnSkiFirstAidAdded

	private PaymentProcessor paymentProcessor;
	private Membership membership;
	private List<PackingSlip> packingSlips = new ArrayList<>();
	private List<CommissionPayment> commissionPayments = new ArrayList<>();
	private Payment payment;

	@Given("Physical Product Processor is given")
    @Aliases(values={"a new Processor is given"})
    public void thePhysicalProductProcessorIsGiven() {
		paymentProcessor = new PhysicalProductPaymentProcessor(packingSlips, commissionPayments);
	}
	
	@When("I process payment for physical product")
    public void processPaymentForPhysicalProduct() {
		payment = new Payment("table");
		paymentProcessor.processPayment(payment);
    }
     
    @Then("Packing slip generated")
    @Aliases(values={"Packing slip $slip"})
    public void packingSlipGenerated(List<Purpose> purposes) {
    	List<PackingSlip> expectedPackingSlips = Arrays.asList(new PackingSlip("table"));
    	
    	assertEquals(expectedPackingSlips, packingSlips);
    }
    
    @Then("Commission payment generated")
    @Aliases(values={"Commission payment $payment"})
    public void commissionPaymentGenerated(List<Purpose> purposes) {
    	List<CommissionPayment> expectedCommissionPayments = Arrays.asList(new CommissionPayment(new BigDecimal("5.0")));
    	
    	assertEquals(expectedCommissionPayments, commissionPayments);
    }

    @Given("Membership Processor is given")
    @Aliases(values={"a new payment is given"})
    public void theAnagramMakerIsGiven() {
		paymentProcessor = new MembershipPaymentProcessor(membership);
	}
    
    @When("I process payment for membership")
    public void processPaymentForMembership() {
		payment = new Payment("membership");
		paymentProcessor.processPayment(payment);
    }
     
    @Then("Membership activated")
    @Aliases(values={"Membership $membership"})
    public void membershipActivated(List<Purpose> purposes) {
    	Membership expectedMembership = new Membership();
    	expectedMembership.setActive(true);
    	
    	assertEquals(expectedMembership, membership);
    }
}

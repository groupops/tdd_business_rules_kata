package com.epam.tdd_business_rules_kata;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static com.epam.tdd_business_rules_kata.configuration.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhysicalProductBusinessRuleTest {

  private Payment payment;
  private PaymentExecutor paymentExecutor;

  public PhysicalProductBusinessRuleTest() {

  }

  @Test
  public void physicalProductBusinessRuleStory() throws Exception {
    aBehaviouralTestRunner().usingStepsFrom(this)
        .withStory("physical_product_business_rule.story").run();
  }

  @Given("that I am using Payment program")
  public void runPaymentProgram() {
    paymentExecutor = new PaymentExecutor();
  }

  @When("I get the payment for $physicalProduct")
  public void getPhysicalProductPayment(String physicalProduct) {
    payment = new Payment(new PhysicalProductBusinessRule());
    paymentExecutor.executePayment(payment);
  }

  @Then("the program generate $packingSlipForShipping")
  public void getPhysicalProductDescription(String packingSlipForShipping) {
    String paymentDescription = payment.getDescription();

    assertThat(paymentDescription, is(equalTo(packingSlipForShipping)));
  }

}

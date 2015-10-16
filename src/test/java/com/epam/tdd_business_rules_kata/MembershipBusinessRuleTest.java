package com.epam.tdd_business_rules_kata;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static com.epam.tdd_business_rules_kata.configuration.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MembershipBusinessRuleTest {

  private Payment payment;
  private Membership membership;
  private PaymentExecutor paymentExecutor;

  public MembershipBusinessRuleTest() {

  }

  @Test
  public void membershipBusinessRuleStory() throws Exception {
    aBehaviouralTestRunner().usingStepsFrom(this)
        .withStory("membership_business_rule.story").run();
  }

  @Given("that I am using Payment program")
  public void runPaymentProgram() {
    paymentExecutor = new PaymentExecutor();
  }

  @When("I get the payment for $membershipPayment")
  public void getMembershipPayment(String membershipPayment) {
    membership = new Membership();
    membership.setActive(true);
    payment = new Payment(new MembershipBusinessRule());
    paymentExecutor.executePayment(payment);
  }

  @Then("the membership is $isActive")
  public void getMembershipDescription(boolean isActive) {
    boolean isMembershipActive = membership.isActive();

    assertThat(isMembershipActive, is(equalTo(isActive)));
  }

}

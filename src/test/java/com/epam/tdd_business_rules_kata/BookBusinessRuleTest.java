package com.epam.tdd_business_rules_kata;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import static com.epam.tdd_business_rules_kata.configuration.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookBusinessRuleTest {

  private Payment payment;
  private PaymentExecutor paymentExecutor;

  public BookBusinessRuleTest() {

  }

  @Test
  public void bookBusinessRuleStory() throws Exception {
    aBehaviouralTestRunner().usingStepsFrom(this)
        .withStory("book_business_rule.story").run();
  }

  @Given("that I am using Payment program")
  public void runPaymentProgram() {
    paymentExecutor = new PaymentExecutor();
  }

  @When("I get the payment for $bookPayment")
  public void getBookPayment(String bookPayment) {
    payment = new Payment(new BookBusinessRule());
    paymentExecutor.executePayment(payment);
  }

  @Then("the program generate $duplicatePackingSlip")
  public void getBookDescription(String duplicatePackingSlip) {
    String paymentDescription = payment.getDescription();

    assertThat(paymentDescription, is(equalTo(duplicatePackingSlip)));
  }

}

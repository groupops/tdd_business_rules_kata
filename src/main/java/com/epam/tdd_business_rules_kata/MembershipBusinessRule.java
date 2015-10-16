package com.epam.tdd_business_rules_kata;

public class MembershipBusinessRule implements BusinessRule {

  private Membership membership;

  public MembershipBusinessRule() {
    membership = new Membership();
  }

  @Override
  public void doBusinessSteps() {
    activateMembership();
  }

  @Override
  public String getStepsDescription() {
    return membership.getDescription();
  }

  private void activateMembership() {
    membership.setActive(true);
  }

}

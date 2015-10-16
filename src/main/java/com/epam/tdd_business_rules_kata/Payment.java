package com.epam.tdd_business_rules_kata;

public class Payment {

  private BusinessRule businessRule;

  public Payment(BusinessRule businessRule){
    this.businessRule = businessRule;
  }

  public void doRequiredSteps(){
    businessRule.doBusinessSteps();
  }

  public String getDescription(){
    return businessRule.getStepsDescription();
  }

}

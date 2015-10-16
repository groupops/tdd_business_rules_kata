package com.epam.tdd_business_rules_kata;

public class PhysicalProductBusinessRule implements BusinessRule {

  private PackingSlip slipForShipping;

  @Override
  public void doBusinessSteps() {
    getPackingSlip();
  }

  @Override
  public String getStepsDescription(){
    return "a packing slip for shipping";
  }

  private PackingSlip getPackingSlip(){
    return new PackingSlip();
  }

}

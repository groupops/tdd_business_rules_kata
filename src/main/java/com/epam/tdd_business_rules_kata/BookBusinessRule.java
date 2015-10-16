package com.epam.tdd_business_rules_kata;

import java.util.ArrayList;
import java.util.List;

public class BookBusinessRule implements BusinessRule {

  private PackingSlip slipForShipping;
  private PackingSlip slipForRoyaltyDepartament;
  private List<PackingSlip> packingSlips;

  @Override
  public void doBusinessSteps() {
    getDoublePackingSlip();
  }

  @Override
  public String getStepsDescription() {
    return "a duplicate packing slip for the royalty department";
  }

  private List<PackingSlip> getDoublePackingSlip() {
    packingSlips = new ArrayList<>();
    slipForShipping = new PackingSlip();
    slipForRoyaltyDepartament = new PackingSlip();
    packingSlips.add(slipForShipping);
    packingSlips.add(slipForRoyaltyDepartament);

    return packingSlips;
  }

}

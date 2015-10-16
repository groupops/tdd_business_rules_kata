package com.epam.tdd_business_rules_kata;

public class Membership {

  private boolean isActive;
  private final String ACTIVE = "active";
  private final String INACTIVE = "inactive";

  public Membership() {
    this.isActive = false;
  }

  public boolean isActive() {
    return isActive;
  }

  void setActive(boolean isActive) {
    isActive = true;
  }

  public String getDescription() {
    return isActive ? ACTIVE : INACTIVE;
  }

}

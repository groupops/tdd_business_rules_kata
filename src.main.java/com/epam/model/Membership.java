package com.epam.model;

public class Membership {

	private boolean active;
	private boolean upgraded;
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isUpgraded() {
		return upgraded;
	}
	
	public void setUpgraded(boolean upgraded) {
		this.upgraded = upgraded;
	}
}

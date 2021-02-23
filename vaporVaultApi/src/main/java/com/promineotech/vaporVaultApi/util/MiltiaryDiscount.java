package com.promineotech.vaporVaultApi.util;

public enum MiltiaryDiscount {

	none(.00),
	military(.10);
	
private double discount;
	
MiltiaryDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
}

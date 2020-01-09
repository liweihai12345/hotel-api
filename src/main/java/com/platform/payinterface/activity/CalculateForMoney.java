package com.platform.payinterface.activity;


public class CalculateForMoney implements CalculateInterface {

	@Override
	public Double getCalculateForMoney(Double price) {
		
		return price;
	}

	@Override
	public Double getCalculateForDiscount(Double price, Double dis) {
		
		return price-price*dis;
	}

	

	

}

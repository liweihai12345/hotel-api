package com.platform.payinterface.activity;

public class ActivityMoney implements ActivityFactory {

	@Override
	public CalculateInterface createFullMoneyCut() {
		
		return new CalculateForMoney();
	}

	@Override
	public CalculateInterface createFullCountCut() {
		
		return new CalculateForMoney();
	}



}

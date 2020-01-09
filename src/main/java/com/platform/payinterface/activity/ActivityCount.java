package com.platform.payinterface.activity;

public class ActivityCount implements ActivityFactory {

	@Override
	public CalculateInterface createFullMoneyCut() {
		
		return new CalculateForCount();
	}

	@Override
	public CalculateInterface createFullCountCut() {
		
		return new CalculateForCount();
	}

	

}

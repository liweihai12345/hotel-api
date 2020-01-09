package com.platform.payinterface;

import java.util.Map;

public class PayControlContext {

	private IPayStrategy strategy;
	
	public PayControlContext(IPayStrategy strategy){
		this.strategy=strategy;
	}
	/**
	 * 支付宝构造初始请求参数
	 * @param code
	 * @param newamount
	 * @return
	 */
	public Map<String, String> buildAppResponseParam(String code,String newamount){
		
		return this.strategy.buildAppResponseParam( code, newamount);
	}
	/**
	 * 支付宝回调验签
	 * @param requestMap
	 * @return
	 */
	public Boolean buildNotifyVerify(Map<String,String> requestMap){
		
		return this.strategy.buildNotifyVerify(requestMap);
	}
	
}

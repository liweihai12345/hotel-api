package com.platform.payinterface;

import java.util.Map;

public interface IPayStrategy {
	
	public Map<String, String> buildAppResponseParam(String code, String newamount);
	
	public Boolean buildNotifyVerify(Map<String, String> map);
}

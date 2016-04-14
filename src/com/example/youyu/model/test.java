package com.example.youyu.model;

import java.util.List;

public class test {
	// Gson

	private int errNum;
	private String errMsg;
	private List<wherecity> retData;

	public class wherecity {
		private String province_cn;
		private String province_cn1;
		private String province_cn2;
		private String province_cn3;
		private String province_cn4;
	}

	public int getErrNum() {
		return errNum;
	}

	public void setErrNum(int errNum) {
		this.errNum = errNum;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public List<wherecity> getRetData() {
		return retData;
	}

	public void setRetData(List<wherecity> retData) {
		this.retData = retData;
	}
	
	public static void getJson(String json){
		Gson gson = new Gson();
		
	}
}

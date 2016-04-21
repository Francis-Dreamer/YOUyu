package com.example.youyu;

import android.app.Application;

public class DataApplication extends Application {
	/**
	 * 请求地址的地址头
	 */
	public final String url_top = "http://211.149.198.8:9805";

	/**
	 * 请求地址的属性
	 */
	public final String url_type = "/travel/api/";

	/**
	 * 登录接口名
	 */
	public final String url_Login = "login";

	/**
	 * 闹的接口名
	 */
	public final String url_Nao = "action_name: content_list";

}

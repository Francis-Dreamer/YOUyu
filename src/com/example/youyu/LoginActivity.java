package com.example.youyu;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.example.youyu.R;
import com.example.youyu.util.HttpPost;
import com.example.youyu.util.HttpPost.OnSendListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 登录
 * @author 陈佳智
 *
 */
public class LoginActivity extends Activity{

	String mobile;
	String password;
	EditText edit_tel;
	EditText edit_password;
	DataApplication application;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		application=(DataApplication) getApplication();
		
		
		initView();
	}
	
	/**
	 * 初始化界面
	 */
	private void initView(){
		@SuppressWarnings("unused")
		ImageView back=(ImageView) findViewById(R.id.back);
		TextView register=(TextView) findViewById(R.id.register); 
		TextView login_username=(TextView) findViewById(R.id.login_username);
		
		edit_tel=(EditText) findViewById(R.id.tel);
		edit_password=(EditText) findViewById(R.id.password);
		
		register.setOnClickListener(clickListener);
		login_username.setOnClickListener(clickListener);
	}
	
	OnClickListener clickListener=new OnClickListener() {
		Intent intent;
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login_username:
				login();
				break;
			case R.id.register:
				intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};
	
	/**
	 * 登录方法
	 */
	private void login(){
		String url=application.url_top+application.url_type+"login";
		mobile=edit_tel.getText().toString();
		password=edit_password.getText().toString();
		
		
		try {
			HttpPost httpPost=HttpPost.parseUrl(url);
			Map<String, String> map=new HashMap<String, String>();
			map.put("mobile", mobile);
			map.put("password", password);
			httpPost.putMap(map);
			httpPost.send();
			httpPost.setOnSendListener(new OnSendListener() {
				
				public void start() {
					
				}
				
				public void end(String result) {
					Log.e("返回参数", result);
				}
			});
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}

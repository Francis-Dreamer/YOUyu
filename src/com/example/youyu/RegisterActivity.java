package com.example.youyu;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.example.youyu.util.HttpPost;
import com.example.youyu.util.HttpPost.OnSendListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity{
	
	String mobile;
	String password;
	String repassword;
	String mobile_code;
	EditText edit_phone;
	EditText edit_yanzhengma;
	EditText edit_password;
	EditText edit_repassword;
	TextView text_yanzhengma;
	Button button_add;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		
		initView();
		
		
	}


	/**
	 * 初始化页面
	 */
	private void initView() {
		edit_phone=(EditText) findViewById(R.id.edit_phone);
		edit_yanzhengma=(EditText) findViewById(R.id.edit_yanzhengma);
		edit_password=(EditText) findViewById(R.id.edit_password);
		edit_repassword=(EditText) findViewById(R.id.edit_repassword);
		text_yanzhengma = (TextView) findViewById(R.id.text_yanzhengma);
		button_add=(Button) findViewById(R.id.button_add);
		
		
		button_add.setOnClickListener(clickListener);
		text_yanzhengma.setOnClickListener(clickListener);
	}
	
	
	OnClickListener clickListener=new OnClickListener() {
		
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.text_yanzhengma:
				getCode();
				break;
			case R.id.button_add:
				register();
				break;
			default:
				break;
			}
		}
	};
	
	/**
	 * 获取验证码
	 */
	private void getCode(){
		String url="http://211.149.198.8:9805//api/sms";
		mobile=edit_phone.getText().toString();
		try {
			HttpPost httpPost=HttpPost.parseUrl(url);
			httpPost.putString("mobile", mobile);
			httpPost.send();
			
			httpPost.setOnSendListener(new OnSendListener() {
				
				public void start() {
					
				}
				
				public void end(String result) {
					Log.e("验证码", result);
				}
			});
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 注册
	 */
	private void register(){
		mobile=edit_phone.getText().toString();
		password=edit_password.getText().toString();
		repassword=edit_repassword.getText().toString();
		mobile_code=edit_yanzhengma.getText().toString();
		
		String url="http://211.149.198.8:9805//api/reg";
		
		try {
			HttpPost httpPost=HttpPost.parseUrl(url);
			Map<String, String> map=new HashMap<String, String>();
			map.put("mobile ", mobile);
			map.put("password", password);
			map.put("repassword", repassword);
			map.put("mobile_code", mobile_code);
			httpPost.putMap(map);
			httpPost.send();
			httpPost.setOnSendListener(new OnSendListener() {
				
				public void start() {
					
				}
				
				public void end(String result) {
					Log.e("result", result);
					
				}
			});
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

package com.example.youyu;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.youyu.util.HttpPost;
import com.example.youyu.util.HttpPost.OnSendListener;
import com.google.gson.JsonObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 修改密码
 * 
 * @author 陈佳智
 * 
 */
public class ChangePasswordActivity extends Activity {

	LinearLayout yanzhengma_linearlayout;
	LinearLayout confirm_linearlayout;
	String mobile;
	String mobile_code;
	String password;
	String repassword;
	EditText change_tel;
	EditText edit_verify_code;
	EditText edit_new_password;
	EditText edit_confirm_password;
	DataApplication application;
	TextView get_verify_code;
	TextView next;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);
		application=(DataApplication) getApplication();
		initView();
	}

	/**
	 * 初始化页面
	 */
	private void initView() {
		ImageView back = (ImageView) findViewById(R.id.back);
		TextView next = (TextView) findViewById(R.id.next);
		TextView ok = (TextView) findViewById(R.id.ok);
		yanzhengma_linearlayout = (LinearLayout) findViewById(R.id.yanzhengma_linearlayout);
		confirm_linearlayout = (LinearLayout) findViewById(R.id.confirm_linearlayout);
		
		change_tel=(EditText) findViewById(R.id.change_tel);
		edit_verify_code=(EditText) findViewById(R.id.edit_verify_code);
		edit_new_password=(EditText) findViewById(R.id.edit_new_password);
		edit_confirm_password=(EditText) findViewById(R.id.edit_confirm_password);
		
		get_verify_code=(TextView) findViewById(R.id.get_verify_code);
		
		
		get_verify_code.setOnClickListener(clickListener);
		back.setOnClickListener(clickListener);
		next.setOnClickListener(clickListener);
		ok.setOnClickListener(clickListener);
	}

	OnClickListener clickListener = new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.next:
				verifyCode();
				break;
			case R.id.ok:
				changePassword();
		
				break;
			case R.id.get_verify_code:
				getCode();
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
		String url=application.url_top+application.url_type+"sms";
		mobile=change_tel.getText().toString();
	
		
		try {
			HttpPost httpPost=HttpPost.parseUrl(url);
			httpPost.putString("mobile", mobile);
			
			httpPost.send();
			httpPost.setOnSendListener(new OnSendListener() {
				
				public void start() {
					
				}
				
				public void end(String result) {
					Log.e("获取验证码", result);
				}
			});
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 判定验证码
	 */
	private void verifyCode(){
		String url=application.url_top+application.url_type+"verify";
		mobile=change_tel.getText().toString();
		mobile_code=edit_verify_code.getText().toString();
		
		try {
			HttpPost httpPost=HttpPost.parseUrl(url);
			Map<String, String> map=new HashMap<String, String>();
			map.put("mobile", mobile);
			map.put("mobile_code", mobile_code);
			httpPost.putMap(map);
			httpPost.send();
			httpPost.setOnSendListener(new OnSendListener() {
				
				public void start() {
					
				}
				
				public void end(String result) {
					try {
						JSONObject jsonObject=new JSONObject(result);
						int status=jsonObject.getInt("status");
						String message=jsonObject.getString("message");
						if(status==1){
							yanzhengma_linearlayout.setVisibility(View.GONE);
							confirm_linearlayout.setVisibility(View.VISIBLE);
						}else{
							Toast.makeText(getApplicationContext(), "验证失败", Toast.LENGTH_SHORT).show();
						}
						Log.e("status", status+"");
						Log.e("message", message);
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}
			});
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void changePassword(){
		String url=application.url_top+application.url_type+"updatepw";
		password=edit_new_password.getText().toString();
		repassword=edit_confirm_password.getText().toString();
		mobile=change_tel.getText().toString();
		
		try {
			HttpPost httpPost=HttpPost.parseUrl(url);
			Map<String, String> map=new HashMap<String, String>();
			map.put("mobile", mobile);
			map.put("password", password);
			map.put("repassword", repassword);
			httpPost.putMap(map);
			httpPost.send();
			httpPost.setOnSendListener(new OnSendListener() {
				
				public void start() {
					
				}
				
				public void end(String result) {
					Log.e("修改密码", result);
					int status;
					try {
						JSONObject jsonObject=new JSONObject(result);
						status=jsonObject.getInt("status");
						if(status==1){
							Intent intent=new Intent(ChangePasswordActivity.this,LoginActivity.class);
							startActivity(intent);
						}else{
							Toast.makeText(getApplicationContext(), "密码修改失败", Toast.LENGTH_SHORT).show();
						}
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}
			});
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

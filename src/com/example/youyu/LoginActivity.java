package com.example.youyu;

import com.example.youyu.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 登录
 * @author 陈佳智
 *
 */
public class LoginActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		initView();
	}
	
	/**
	 * 初始化界面
	 */
	private void initView(){
		ImageView back=(ImageView) findViewById(R.id.back);
		
		TextView login_username=(TextView) findViewById(R.id.login_username);
		
		login_username.setOnClickListener(clickListener);
	}
	
	OnClickListener clickListener=new OnClickListener() {
		
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login_username:
				Intent intent=new Intent(LoginActivity.this,AfterLoginActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
	};
}

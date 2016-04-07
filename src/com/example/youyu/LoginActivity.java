package com.example.youyu;

import com.example.youyu.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

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
		
		
		
		
	}
}

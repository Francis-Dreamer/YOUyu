package com.example.youyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 设置
 * @author 陈佳智
 *
 */
public class SetActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		
		initView();
	}
		
	/**
	 * 初始化页面
	 */
	private void initView(){
		ImageView back=(ImageView) findViewById(R.id.back);
		RelativeLayout personal_data_relativelayout=(RelativeLayout) findViewById(R.id.personal_data_relativelayout);
		RelativeLayout tel_relativelayout=(RelativeLayout) findViewById(R.id.tel_relativelayout);
		
		
		personal_data_relativelayout.setOnClickListener(clickListener);
		tel_relativelayout.setOnClickListener(clickListener);
		back.setOnClickListener(clickListener);
	}
	
	OnClickListener clickListener=new OnClickListener() {
		Intent intent=new Intent();
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.personal_data_relativelayout:
				intent.setClass(SetActivity.this, ChangePersonalDataActivity.class);
				startActivity(intent);
				break;
			case R.id.tel_relativelayout:
				intent.setClass(SetActivity.this, ChangePasswordActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};
}

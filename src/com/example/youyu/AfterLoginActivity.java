package com.example.youyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 登陆后
 * @author 陈佳智
 *
 */
public class AfterLoginActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_afterlogin);
		
		initView();
	}
	
	/**
	 * 初始化页面
	 */
	private void initView(){
		RelativeLayout drafts_relativelayout=(RelativeLayout) findViewById(R.id.drafts_relativelayout);
		RelativeLayout message_relativelayout=(RelativeLayout) findViewById(R.id.message_relativelayout);
		RelativeLayout more_set_relativelayout=(RelativeLayout) findViewById(R.id.more_set_relativelayout);
		ImageView mycollection=(ImageView) findViewById(R.id.mycollection);
		ImageView mystrategy=(ImageView) findViewById(R.id.mystrategy);
		
		
		mycollection.setOnClickListener(clickListener);
		mystrategy.setOnClickListener(clickListener);
		drafts_relativelayout.setOnClickListener(clickListener);
		message_relativelayout.setOnClickListener(clickListener);
		more_set_relativelayout.setOnClickListener(clickListener);
	}
	
	OnClickListener clickListener=new OnClickListener() {
		Intent intent=new Intent();
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.drafts_relativelayout:
				intent.setClass(AfterLoginActivity.this, DraftsBoxActivity.class);
				startActivity(intent);
				break;
			case R.id.message_relativelayout:
				intent.setClass(AfterLoginActivity.this, MessageActivity.class);
				startActivity(intent);
				break;
			case R.id.more_set_relativelayout:
				intent.setClass(AfterLoginActivity.this, SetActivity.class);
				startActivity(intent);
				break;
			case R.id.mycollection:
				intent.setClass(AfterLoginActivity.this, MyCollectionActivity.class);
				startActivity(intent);
				break;
			case R.id.mystrategy:
				intent.setClass(AfterLoginActivity.this, MyStrategyActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};
}

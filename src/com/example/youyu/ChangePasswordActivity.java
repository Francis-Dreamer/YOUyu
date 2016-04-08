package com.example.youyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 修改密码
 * 
 * @author 陈佳智
 * 
 */
public class ChangePasswordActivity extends Activity {

	LinearLayout yanzhengma_linearlayout;
	LinearLayout confirm_linearlayout;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);

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
				yanzhengma_linearlayout.setVisibility(View.GONE);
				confirm_linearlayout.setVisibility(View.VISIBLE);
				break;
			case R.id.ok:
				Intent intent=new Intent(ChangePasswordActivity.this,LoginActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};

}

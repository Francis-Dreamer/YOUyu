package com.example.youyu;

import com.example.youyu.util.SharedPreferencesUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 设置
 * 
 * @author 陈佳智
 * 
 */
public class SetActivity extends Activity {

	private TextView tv_out;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);

		initView();
	}

	/**
	 * 初始化页面
	 */
	private void initView() {
		ImageView back = (ImageView) findViewById(R.id.back);
		RelativeLayout personal_data_relativelayout = (RelativeLayout) findViewById(R.id.personal_data_relativelayout);
		RelativeLayout tel_relativelayout = (RelativeLayout) findViewById(R.id.tel_relativelayout);

		personal_data_relativelayout.setOnClickListener(clickListener);
		tel_relativelayout.setOnClickListener(clickListener);
		back.setOnClickListener(clickListener);

		tv_out = (TextView) findViewById(R.id.out);
		if (checkLogin()) {
			tv_out.setVisibility(View.VISIBLE);
		} else {
			tv_out.setVisibility(View.GONE);
		}
		tv_out.setOnClickListener(clickListener);
	}

	OnClickListener clickListener = new OnClickListener() {
		Intent intent = new Intent();
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.back:
				finish();
				break;
			case R.id.personal_data_relativelayout:
				intent.setClass(SetActivity.this,
						ChangePersonalDataActivity.class);
				startActivity(intent);
				break;
			case R.id.tel_relativelayout:
				intent.setClass(SetActivity.this, ChangePasswordActivity.class);
				startActivity(intent);
				break;
			case R.id.out:
				SharedPreferencesUtil.deleteData(getApplicationContext());
				Toast.makeText(getApplicationContext(), "退出登录成功！",
						Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	};

	private boolean checkLogin() {
		String tok = SharedPreferencesUtil.getData(getApplicationContext());
		if (!TextUtils.isEmpty(tok)) {
			return true;
		}
		return false;
	}
}

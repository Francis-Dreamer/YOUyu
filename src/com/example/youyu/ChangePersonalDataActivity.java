package com.example.youyu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * 修改个人资料
 * 
 * @author 陈佳智
 * 
 */
public class ChangePersonalDataActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_personaldata);

		initView();
	}

	/**
	 * 初始化页面
	 */
	private void initView() {
		ImageView back = (ImageView) findViewById(R.id.back);
		
		
		back.setOnClickListener(clickListener);
	}

	OnClickListener clickListener = new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.back:
				finish();
				break;

			default:
				break;
			}
		}
	};

}

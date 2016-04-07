package com.example.youyu;

import com.example.youyu.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class TanActivity extends Activity {

	ImageView image_search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tan);
		image_search = (ImageView) findViewById(R.id.image_search);

		image_search.setOnClickListener(ocl);
	}

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			switch (v.getId()) {
			case R.id.image_search:
				intent.setClass(getApplicationContext(), SearchActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
	};
}

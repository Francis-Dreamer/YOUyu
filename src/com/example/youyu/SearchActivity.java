package com.example.youyu;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SearchActivity extends Activity {
	LinearLayout linear_huanyipi;
	EditText edit_search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		linear_huanyipi = (LinearLayout) findViewById(R.id.linear_huanyipi);
		edit_search = (EditText) findViewById(R.id.edit_search);
		edit_search.addTextChangedListener(new EditChangedListener());
		
		
		linear_huanyipi.setOnClickListener(ocl);
	}

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.linear_huanyipi:

				break;

			default:
				break;
			}
		}
	};

	class EditChangedListener implements TextWatcher {
		// private CharSequenec temp;//监听前的文本
		@SuppressWarnings("unused")
		private int editStart;// 光标开始位置
		@SuppressWarnings("unused")
		private int editEnd;// 光标结束位置
		// private final int charMaxNum = 10;

		@Override
		public void afterTextChanged(Editable arg0) {

		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

		}
	}
}

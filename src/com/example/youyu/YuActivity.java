package com.example.youyu;

import com.example.youyu.baseadapter.YuBaseAdapter;
import com.example.youyu.model.YuModel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class YuActivity extends Activity {
	ListView listView;
	TextView top_tittle;
	YuBaseAdapter adapter;
	ImageView image_share;
	YuModel yuModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yu);
		initView();
	}

	/*
	 * 初始化控件
	 */
	private void initView() {
		yuModel = new YuModel();
		listView = (ListView) findViewById(R.id.listview_yu);
		// 获取渝的数据集合
		yuModel.getData();
		adapter = new YuBaseAdapter(this, yuModel.getList());
		listView.setAdapter(adapter);
	}
}

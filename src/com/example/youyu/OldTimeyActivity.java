package com.example.youyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.youyu.baseadapter.OldTimeyBaseAdapter;
import com.example.youyu.model.OldTimeYModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 往期回顾
 * 
 * @author Administrator
 * 
 */
public class OldTimeyActivity extends Activity {
	ExpandableListView listView;
	OldTimeyBaseAdapter oldTimeyBaseAdapter;
	Map<String, List<String>> map = null;
	List<OldTimeYModel> list;
	OldTimeYModel model;
	ImageView top_imageview;
	TextView top_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yu_oldtimey);
		initView();
	}

	private void initView() {
		listView = (ExpandableListView) findViewById(R.id.listview_yu_oldtimey);
		top_imageview = (ImageView) findViewById(R.id.top_imageview);
		top_title = (TextView) findViewById(R.id.top_title);
		// 设置标题
		top_imageview.setBackgroundResource(R.drawable.fanhui);
		top_title.setText("往期回顾");
		top_imageview.setOnClickListener(clickListener);
		// 获取数据并放入ExpandableListView中
		getData();
		oldTimeyBaseAdapter = new OldTimeyBaseAdapter(list, this);
		listView.setAdapter(oldTimeyBaseAdapter);
	}
	/*
	 * 点击事件
	 */
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			//点击销毁页面
			finish();
		}
	};
	public void getData() {
		list = new ArrayList<OldTimeYModel>();
		for (int i = 0; i < 12; i++) {
			model = new OldTimeYModel();
			model.setMonth(i + "月");
			list.add(model);
		}
	}
}

package com.example.youyu;

import java.util.List;

import com.example.youyu.adapter.MyCollectionAdapter;
import com.example.youyu.model.MyCollectionModel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyCollectionActivity extends Activity{

	List<MyCollectionModel> data;
	ListView listView;
	MyCollectionAdapter adapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mycollection);
		
		initView();
	}
	
	/**
	 * 初始化页面
	 */
	private void initView(){
		listView=(ListView) findViewById(R.id.mycollection_listview);
		data=MyCollectionModel.getData();
		adapter=new MyCollectionAdapter(data, this);
		listView.setAdapter(adapter);
	}
}

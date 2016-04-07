package com.example.youyu;

import java.util.List;
import com.example.youyu.adapter.MyStrategyAdapter;
import com.example.youyu.model.MyStrategyModel;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * 我的攻略
 * @author Administrator
 *
 */
public class MyStrategyActivity extends Activity{

	List<MyStrategyModel> data;
	MyStrategyAdapter adapter;
	ListView listView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mystrategy);
		
		initView();
	}
	
	/**
	 * 初始化页面
	 */
	private void initView(){
		
		listView=(ListView) findViewById(R.id.mystrategy_listview);
		data=MyStrategyModel.getData();
		adapter=new MyStrategyAdapter(data, this);
		listView.setAdapter(adapter);
	}
	
}

package com.example.youyu;

import java.util.List;
import com.example.youyu.adapter.MyStrategyAdapter;
import com.example.youyu.model.MyStrategyModel;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 我的攻略
 * @author 陈佳智
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
		ImageView back=(ImageView) findViewById(R.id.back);
		
		listView=(ListView) findViewById(R.id.mystrategy_listview);
		data=MyStrategyModel.getData();
		adapter=new MyStrategyAdapter(data, this);
		listView.setAdapter(adapter);
		
		back.setOnClickListener(clickListener);
	}
	
	OnClickListener clickListener=new OnClickListener() {
		
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

package com.example.youyu;

import java.util.List;
import com.example.youyu.adapter.MyCollectionAdapter;
import com.example.youyu.model.MyCollectionModel;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 我的收藏
 * @author 陈佳智
 *
 */
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
		
		ImageView back=(ImageView) findViewById(R.id.back);
		
		
		listView=(ListView) findViewById(R.id.mycollection_listview);
		data=MyCollectionModel.getData();
		adapter=new MyCollectionAdapter(data, this);
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

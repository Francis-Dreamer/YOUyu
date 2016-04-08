package com.example.youyu;

import java.util.List;

import com.example.youyu.adapter.DraftboxsAdapter;
import com.example.youyu.model.DraftboxsModel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * 草稿箱
 * @author Administrator
 *
 */
public class DraftsBoxActivity extends Activity{
	
	List<DraftboxsModel> data;
	ListView listView;
	DraftboxsAdapter adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_draftsbox);
		
		initView();
	}
	
	/**
	 *初始化页面
	 */
	private void initView(){
		listView=(ListView) findViewById(R.id.draftsbox_listview);
		data=DraftboxsModel.getData();
		adapter=new DraftboxsAdapter(data, this);
		listView.setAdapter(adapter);
	}
}

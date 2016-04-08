package com.example.youyu;

import java.util.List;

import com.example.youyu.adapter.MessageAdapter;
import com.example.youyu.model.MessageModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 消息
 * 
 * @author 陈佳智
 * 
 */
public class MessageActivity extends Activity {

	MessageAdapter adapter;
	List<MessageModel> data;
	ListView listView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);

		initView();
	}

	/**
	 * 初始化页面
	 */
	private void initView() {
		
		ImageView back=(ImageView) findViewById(R.id.back);
		
		
		listView = (ListView) findViewById(R.id.message_listview);
		data = MessageModel.getData();
		adapter = new MessageAdapter(data, this);
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

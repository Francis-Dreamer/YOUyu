package com.example.youyu;

import com.example.youyu.adapter.CommentBaseAdapter;
import com.example.youyu.model.CommentModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 评论界面
 */
public class CommentActivity extends Activity{
	ListView listView;
	CommentModel commentModel;
	CommentBaseAdapter adapter;
	ImageView top_imageview;
	TextView top_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comment);
		initView();
	}
	/**
	 * 初始化控件
	 */
	private void initView() {
		listView=(ListView)findViewById(R.id.listview_comment);
		top_imageview = (ImageView) findViewById(R.id.top_imageview);
		top_title = (TextView) findViewById(R.id.top_title);
		// 设置标题
		top_imageview.setImageResource(R.drawable.fanhui);
		top_title.setText("往期回顾");
		top_imageview.setOnClickListener(clickListener);
		
		commentModel=new CommentModel();
		commentModel.getData();
		adapter=new CommentBaseAdapter(commentModel.getList(),this);
		listView.setAdapter(adapter);
	}
	
	/**
	 * 点击事件
	 */
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.top_imageview:
				finish();
				break;

			default:
				break;
			}
		}
	};
}

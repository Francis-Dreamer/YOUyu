package com.example.youyu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.youyu.baseadapter.YuBaseAdapter;
import com.example.youyu.model.YuModel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class YuActivity extends Activity {
	ListView listView;
	TextView top_tittle;
	YuBaseAdapter adapter;
	YuModel yuModel;
	ImageView top_imageview,yu_image,image_share;
	TextView text_name,text,text_number,top_title;
	TextView weather,yu_image_by,time;
	PopupWindow popupWindow;
	LayoutInflater inflater;
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
		top_imageview = (ImageView) findViewById(R.id.top_imageview);
		top_title = (TextView) findViewById(R.id.top_title);
		text = (TextView) findViewById(R.id.yu_text);
		text_number = (TextView) findViewById(R.id.yu_textnumber);
		text_name = (TextView) findViewById(R.id.yu_text_tittle);
		weather = (TextView) findViewById(R.id.yu_weather);
		time = (TextView) findViewById(R.id.yu_date);
		image_share = (ImageView) findViewById(R.id.yu_share);
		yu_image_by=(TextView)findViewById(R.id.yu_image_by);
		yu_image=(ImageView)findViewById(R.id.yu_image);
		top_title.setText("游渝");
		// 获取渝的数据
		getModelData();
		getData();
	}

	@SuppressLint("SimpleDateFormat")
	private void getData() {
		image_share.setOnClickListener(clickListener);
		yu_image.setOnClickListener(clickListener);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		text.setText(yuModel.getText());
		text_name.setText(yuModel.getText_name());
		text_number.setText("第" + yuModel.getText_number() + "篇");
		weather.setText("今日天气：" + yuModel.getWeather());
		yu_image_by.setText("photo by:Tristain Kwan");
		time.setText(dateFormat.format(date));
	}
	private void getModelData(){
		yuModel.setText("是否考虑该好好读书卡还给客户给大家看还是感慨");
		yuModel.setText_name("2016重庆吃货心愿单");
		yuModel.setText_number("一");
		yuModel.setWeather("晴");
	}
	/**
	 * 点击事件
	 */
	OnClickListener clickListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.yu_share:
				popWindow();
				break;
			case R.id.share_quxiao:
				// 销毁弹出框
				popupWindow.dismiss();
				break;
			case R.id.yu_image:
				//跳转到往期回顾
				Intent intent=new Intent(YuActivity.this,OldTimeyActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};

	/*
	 * 点击分享出现popWindow
	 */
	@SuppressLint("InflateParams")
	public void popWindow() {
		View view = inflater.inflate(R.layout.activity_yu_shaarepopupwindow,
				null);
		// 获取屏幕宽度
		WindowManager wm = this.getWindowManager();
		@SuppressWarnings("deprecation")
		int width = wm.getDefaultDisplay().getWidth();
		final int height = view.findViewById(R.id.share_pop).getTop();
		popupWindow = new PopupWindow(view, width, 585, true);
		popupWindow.setAnimationStyle(R.style.AnimBottom);
		popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
		ImageView imageView = (ImageView) view.findViewById(R.id.share_quxiao);
		imageView.setOnClickListener(clickListener);
		view.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						popupWindow.dismiss();
					}
				}
				return true;
			}
		});
	}
}

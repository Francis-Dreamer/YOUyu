package com.example.youyu;

import com.example.youyu.baseadapter.EatWishBaseAdapter;
import com.example.youyu.model.EatWishModel;
import com.example.youyu.view.MyLinearLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * 吃货心愿单
 * 
 * @author Administrator
 * 
 */
public class EatWishActivity extends Activity {
	ImageView top_imageview;
	TextView top_title;
	ImageView image_search;
	ListView listView;
	EatWishBaseAdapter adapter;
	EatWishModel eatWishModel;
	PopupWindow popupWindow;
	MyLinearLayout eatwish_pop;
	int ll_height;
	int ll_width;
	WindowManager.LayoutParams lp;
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eatwish);
		initView();
	}

	/**
	 * 初始化控件
	 */
	@SuppressLint("InflateParams")
	private void initView() {
		top_imageview = (ImageView) findViewById(R.id.top_imageview);
		image_search = (ImageView) findViewById(R.id.image_search);
		top_title = (TextView) findViewById(R.id.top_title);
		listView = (ListView) findViewById(R.id.listview_eatwish);
		layout=(LinearLayout)findViewById(R.id.main);
		// 添加headerView
		LayoutInflater inflater;
		inflater = LayoutInflater.from(this);
		View viewheader = inflater.inflate(R.layout.listview_headview, null);
		listView.addHeaderView(viewheader);
		eatWishModel = new EatWishModel();// 初始化吃货心愿单的数据类 并存入数据
		eatWishModel.getData();
		adapter = new EatWishBaseAdapter(eatWishModel.getList(), this);
		listView.setAdapter(adapter);
		top_imageview.setImageResource(R.drawable.fanhui);
		top_title.setText("2016年重庆吃货心愿单");
		image_search.setImageResource(R.drawable.gengduo);
		image_search.setOnClickListener(clickListener);// 更多跳转到分享页面
		top_imageview.setOnClickListener(clickListener);// 返回上一界面
	}

	@SuppressLint("InflateParams")
	public void popWindow() {
		LayoutInflater inflater = LayoutInflater.from(this);
		View view = inflater.inflate(R.layout.activity_eatwish_popupwindow,
				null);
		eatwish_pop = (MyLinearLayout) view.findViewById(R.id.eatwish_pop);

		// 取得popup window中要显示的控件的高度
		eatwish_pop.measure(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		ll_width = eatwish_pop.getMeasuredWidth();
		ll_height = eatwish_pop.getMeasuredHeight();
		popupWindow = new PopupWindow(view, ll_width, ll_height, true);
		Rect frame = new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		//获取信号栏高度
		int statusBarHeight = frame.top;
		popupWindow.setAnimationStyle(R.style.AppTheme);
		popupWindow.showAtLocation(view, Gravity.TOP|Gravity.RIGHT, 0, statusBarHeight);
		ImageView imageView = (ImageView) view.findViewById(R.id.wish_cancel);
		imageView.setOnClickListener(clickListener);
		view.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < ll_height) {
						lp.alpha = 1f;
						getWindow().setAttributes(lp);
						popupWindow.dismiss();
					}
				}
				return true;
			}
		});
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.image_search:
				Log.i("tag", "tag");
				// 设置背景颜色变暗
				lp = getWindow().getAttributes();
				lp.alpha = 0.3f;
				getWindow().setAttributes(lp);
				popWindow();
				break;
			case R.id.wish_cancel:
				// 销毁弹出框
				lp.alpha = 1f;
				getWindow().setAttributes(lp);
				popupWindow.dismiss();
				break;
			case R.id.top_imageview:
				finish();
				break;
			default:
				break;
			}

		}
	};
}

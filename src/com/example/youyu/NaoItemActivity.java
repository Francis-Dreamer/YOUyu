package com.example.youyu;

import com.example.youyu.model.NaoModel;
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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * 吃货心愿单
 * 
 * @author Administrator
 * 
 */
public class NaoItemActivity extends Activity {
	private ImageView top_imageview,image_search;
	private TextView top_title;
	
	private TextView tv_title,tv_content,tv_address;
	private ImageView iv_pic;
	
	private PopupWindow popupWindow;
	private MyLinearLayout eatwish_pop;
	private  int ll_height;
	private int ll_width;
	private WindowManager.LayoutParams lp;
	
	private NaoModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nao_item_item);
		
		initBundleData();
		
		initView();
	}

	/**
	 * 获取传递的bundle数据
	 */
	private void initBundleData() {
		model = new NaoModel();
		Bundle bundle = getIntent().getExtras();
		model.setName(bundle.getString("name"));
		model.setName(bundle.getString("path"));
	}

	/**
	 * 初始化控件
	 */
	@SuppressLint("InflateParams")
	private void initView() {
		top_imageview = (ImageView) findViewById(R.id.top_imageview);
		image_search = (ImageView) findViewById(R.id.image_search);
		top_title = (TextView) findViewById(R.id.top_title);
		
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
		// 获取信号栏高度
		int statusBarHeight = frame.top;
		popupWindow.setAnimationStyle(R.style.AppTheme);
		popupWindow.showAtLocation(view, Gravity.TOP | Gravity.RIGHT, 0,
				statusBarHeight);
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

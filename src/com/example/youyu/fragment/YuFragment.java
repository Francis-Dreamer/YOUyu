package com.example.youyu.fragment;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.youyu.CommentActivity;
import com.example.youyu.EatWishActivity;
import com.example.youyu.OldTimeyActivity;
import com.example.youyu.R;
import com.example.youyu.baseadapter.YuBaseAdapter;
import com.example.youyu.baseadapter.YuImageBaseAdapter;
import com.example.youyu.model.YuModel;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class YuFragment extends Fragment {
	ListView listView;
	TextView top_tittle;
	YuBaseAdapter adapter;
	YuModel yuModel;
	ImageView top_imageview, yu_image, image_share, yu_comment;
	TextView text_name, text, text_number, top_title;
	TextView weather, yu_image_by, time;
	PopupWindow popupWindow;
	LayoutInflater inflater;
	LinearLayout title_layout;
	YuImageBaseAdapter imageBaseAdapter;
	List<View> views;
	View view;
	View yu_view;
	ViewPager viewPager;
	private EdgeEffectCompat leftEdge;
	private EdgeEffectCompat rightEdge;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_yu, null);
		viewPager = (ViewPager) view.findViewById(R.id.viewpager_yu);
		loadView();
		return view;
	}

	@SuppressLint("InflateParams")
	private void loadView() {
		views = new ArrayList<View>();
		LayoutInflater inflater = LayoutInflater.from(getActivity());
		for (int i = 0; i < 5; i++) {
			yu_view = inflater.inflate(R.layout.listview_yu, null);
			initView();
			yuModel=new YuModel();
			yuModel.getData();
			List<YuModel> list = yuModel.getList();
			yuModel=(YuModel)list.get(i);
			getData();
			views.add(yu_view);
		}
		lastOntouch();// 滑动到最后页跳转
		// 初始化Adapter
		imageBaseAdapter = new YuImageBaseAdapter(views);
		viewPager.setAdapter(imageBaseAdapter);
		viewPager.setCurrentItem(4);
		viewPager.setOnPageChangeListener(listener);
	}

	/*
	 * 初始化控件
	 */
	private void initView() {
		text = (TextView) yu_view.findViewById(R.id.yu_text);
		text_number = (TextView) yu_view.findViewById(R.id.yu_textnumber);
		text_name = (TextView) yu_view.findViewById(R.id.yu_text_tittle);
		title_layout = (LinearLayout) yu_view.findViewById(R.id.title_layout);
		weather = (TextView) yu_view.findViewById(R.id.yu_weather);
		time = (TextView) yu_view.findViewById(R.id.yu_date);
		image_share = (ImageView) yu_view.findViewById(R.id.yu_share);
		yu_image_by = (TextView) yu_view.findViewById(R.id.yu_image_by);
		yu_image = (ImageView) yu_view.findViewById(R.id.yu_image);
		yu_comment = (ImageView) yu_view.findViewById(R.id.yu_comment);
		yu_comment.setOnClickListener(clickListener);
		image_share.setOnClickListener(clickListener);
		yu_image.setOnClickListener(clickListener);
		title_layout.setOnClickListener(clickListener);
		text_name.setOnClickListener(clickListener);
	}

	@SuppressLint("SimpleDateFormat")
	private void getData() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		time.setText(dateFormat.format(date));
		text.setText(yuModel.getText());
		text_name.setText(yuModel.getText_name());
		text_number.setText("第" + yuModel.getText_number() + "篇");
		weather.setText("今日天气：" + yuModel.getWeather());
		yu_image_by.setText("photo by:Tristain Kwan");
	}

	/**
	 * 点击事件
	 */
	OnClickListener clickListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
			case R.id.yu_share:
				popWindow();
				break;
			case R.id.share_quxiao:
				// 销毁弹出框
				popupWindow.dismiss();
				break;
			case R.id.yu_image:
				// 跳转到往期回顾
				intent = new Intent(getActivity(), OldTimeyActivity.class);
				startActivity(intent);
				break;
			case R.id.title_layout:
				// 跳转到吃货心愿单
				intent = new Intent(getActivity(), EatWishActivity.class);
				startActivity(intent);
				break;
			case R.id.yu_comment:
				// 跳转到评论列表
				intent = new Intent(getActivity(), CommentActivity.class);
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
		inflater = LayoutInflater.from(getActivity());
		View view = inflater.inflate(R.layout.activity_yu_shaarepopupwindow,
				null);
		// 获取屏幕宽度
		WindowManager wm = getActivity().getWindowManager();
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

	/**
	 * ViewPager滑动相应事件
	 */
	OnPageChangeListener listener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			if (leftEdge != null && !leftEdge.isFinished()) {// 到了最后一张并且还继续拖动，出现蓝色限制边条了
				// 跳转到往期回顾
				Log.i("tag", "onPageScrolled");
				Intent intent = new Intent(getActivity(),
						OldTimeyActivity.class);
				startActivityForResult(intent, 0);
			}
		}
	};

	private void lastOntouch() {
		try {
			Field leftEdgeField = viewPager.getClass().getDeclaredField(
					"mLeftEdge");
			Field rightEdgeField = viewPager.getClass().getDeclaredField(
					"mRightEdge");
			if (leftEdgeField != null && rightEdgeField != null) {
				leftEdgeField.setAccessible(true);
				rightEdgeField.setAccessible(true);
				leftEdge = (EdgeEffectCompat) leftEdgeField.get(viewPager);
				rightEdge = (EdgeEffectCompat) rightEdgeField.get(viewPager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

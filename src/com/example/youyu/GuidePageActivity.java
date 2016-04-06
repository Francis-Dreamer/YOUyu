package com.example.youyu;

import java.util.ArrayList;
import java.util.List;

import com.example.swimyu.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 引导页
 */
public class GuidePageActivity extends Activity {
	ViewPager viewPager;
	FaceImageAdapter faceImageAdapter;
	private List<View> views;
	RelativeLayout relativeLayout;
	private int currentItem = 0; // 当前图片的索引号
	private GestureDetector gestureDetector; // 用户滑动
	private int flaggingWidth;// 互动翻页所需滚动的长度是当前屏幕宽度的1/3
	// 引导页图片资源
	private int[] guide_pic = { R.drawable.home_yindao_chi,
			R.drawable.home_yindao_he, R.drawable.home_yindao_wan,
			R.drawable.home_yindao_le };
	Button button;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide_page);
		viewPager = (ViewPager) findViewById(R.id.guide_page_viewpager);
		views = new ArrayList<View>();
		// 初始化图片
		initView();
		gestureDetector = new GestureDetector(new GuideViewTouch());
		// 获取分辨率
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		flaggingWidth = dm.widthPixels / 3;

	}

	/**
	 * 初始化图片
	 */
	private void initView() {
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		// 初始化引导图片列表
		for (int i = 0; i < guide_pic.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setLayoutParams(mParams);
			imageView.setImageResource(guide_pic[i]);
			views.add(imageView);
		}
		// 初始化Adapter
		faceImageAdapter = new FaceImageAdapter(views);
		viewPager.setAdapter(faceImageAdapter);
		viewPager.setOnPageChangeListener(onPageChangeListener);
	}

	/**
	 * 点击跳转到登录页
	 */
	private void GoToMainActivity() {
		Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	/**
	 * viewpager滑动响应事件
	 */
	ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			currentItem = position;
		}

		@Override
		public void onPageSelected(int position) {

		}

		@Override
		public void onPageScrollStateChanged(int state) {

		}
	};

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) {
			event.setAction(MotionEvent.ACTION_CANCEL);
		}
		return super.dispatchTouchEvent(event);
	}

	private class GuideViewTouch extends SimpleOnGestureListener {

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (currentItem == guide_pic.length-1) {
				if (Math.abs(e1.getX() - e2.getX()) > Math.abs(e1.getY()
						- e2.getY())
						&& (e1.getX() - e2.getX() <= (-flaggingWidth) || e1
								.getX() - e2.getX() >= flaggingWidth)) {
					if (e1.getX() - e2.getX() >= flaggingWidth) {
						GoToMainActivity();
						return true;
					}
				}
			}
			return false;
		}
	}

}

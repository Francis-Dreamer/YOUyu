package com.example.youyu;

import java.util.ArrayList;
import java.util.List;

import com.example.youyu.baseadapter.AllPageFragmentAdapter;
import com.example.youyu.fragment.NaoFragment;
import com.example.youyu.fragment.TanFragment;
import com.example.youyu.fragment.YuFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * 所有的页面
 * 
 * @author Administrator
 * 
 */
public class AllPageFragmentActivity extends FragmentActivity {
	List<Fragment> list;
	ImageView top_imageview;
	NaoFragment naoFragment;
	YuFragment yuFragment;
	TanFragment tanFragment;
	ViewPager viewPager;
	RadioGroup radioGroup;
	RadioButton radio_yu, radio_nao, radio_tan;
	TextView top_title;
	ImageView image_search;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_allpagefragment);
		initView();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		top_imageview = (ImageView) findViewById(R.id.top_imageview);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		radioGroup = (RadioGroup) findViewById(R.id.bottom_menu);
		top_title=(TextView)findViewById(R.id.top_title);
		radio_yu = (RadioButton) findViewById(R.id.yu);
		radio_nao = (RadioButton) findViewById(R.id.nao);
		radio_tan = (RadioButton) findViewById(R.id.tan);
		image_search = (ImageView) findViewById(R.id.image_search);
		naoFragment = new NaoFragment();
		yuFragment = new YuFragment();
		tanFragment = new TanFragment();
		list = new ArrayList<Fragment>();
		list.add(yuFragment);
		list.add(naoFragment);
		list.add(tanFragment);
		AllPageFragmentAdapter allPageFragmentAdapter = new AllPageFragmentAdapter(
				getSupportFragmentManager(), list);
		viewPager.setAdapter(allPageFragmentAdapter);
		
		image_search.setVisibility(View.GONE);
		viewPager.setOnPageChangeListener(changeListener);
		radioGroup.setOnCheckedChangeListener(checkedChangeListener);
		image_search.setOnClickListener(clickListener);
		top_imageview.setOnClickListener(clickListener);
		radio_nao.setChecked(true);
		top_title.setText("游渝");
	}

	/**
	 * 点击事件
	 */
	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			switch (v.getId()) {
			case R.id.top_imageview:
				intent.setClass(AllPageFragmentActivity.this,AfterLoginActivity.class);
				startActivity(intent);
				break;
			case R.id.image_search:
				intent.setClass(AllPageFragmentActivity.this, SearchActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};
	/**
	 * viewpager滑动响应事件
	 */
	OnPageChangeListener changeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
			case 0:
				radio_nao.setChecked(false);
				radio_yu.setChecked(true);
				radio_tan.setChecked(false);
				break;
			case 1:
				radio_nao.setChecked(true);
				radio_yu.setChecked(false);
				radio_tan.setChecked(false);
				break;
			case 2:
				radio_nao.setChecked(false);
				radio_yu.setChecked(false);
				radio_tan.setChecked(true);
				break;

			default:
				break;
			}

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};
	/**
	 * 底部菜单点击事件
	 */
	OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.yu:
				//渝
				viewPager.setCurrentItem(0);
				image_search.setVisibility(View.GONE);
				break;
			case R.id.nao:
				//闹
				viewPager.setCurrentItem(1);
				image_search.setVisibility(View.GONE);
				break;
			case R.id.tan:
				//探
				image_search.setVisibility(View.VISIBLE);
				viewPager.setCurrentItem(2);
				break;
			default:
				break;
			}
		}
	};
}

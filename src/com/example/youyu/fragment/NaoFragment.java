package com.example.youyu.fragment;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.youyu.EatWishActivity;
import com.example.youyu.R;
import com.example.youyu.adapter.NaoAdapter;
import com.example.youyu.model.NaoModel;

public class NaoFragment extends Fragment implements OnCheckedChangeListener,
		OnItemClickListener {
	private View view;
	private RadioGroup radioGroup;
	private ListView listView;
	private List<NaoModel> data_eat;
	private List<NaoModel> data_dreak;
	private List<NaoModel> data_play;
	private List<NaoModel> data_happy;
	private NaoAdapter adapter;
	// 导航的选项标识
	private int flog = 1;
	// 滑动 状态
	private boolean isScroll = false;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_nao, null);

		initData();

		initView();

		return view;
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		data_eat = NaoModel.getData();
		data_dreak = NaoModel.getData();
		data_play = NaoModel.getData();
		data_happy = NaoModel.getData();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		radioGroup = (RadioGroup) view.findViewById(R.id.rg_nao_radiogroup);
		radioGroup.setOnCheckedChangeListener(this);

		listView = (ListView) view.findViewById(R.id.lv_nao_listview);
		listView.setOnItemClickListener(this);
		adapter = new NaoAdapter(getActivity(), data_eat);
		listView.setAdapter(adapter);
		listView.setOnScrollListener(onScrollListener);
	}

	OnScrollListener onScrollListener = new OnScrollListener() {
		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			Log.i("onScroll", "scrollState = " + scrollState);
			switch (scrollState) {
			case OnScrollListener.SCROLL_STATE_IDLE://空闲状态  
				isScroll = false;
				break;
			case OnScrollListener.SCROLL_STATE_FLING://滚动状态 
				isScroll = true;
				break;
			case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL://触摸后滚动  
				isScroll = true;
				break;
			default:
				break;
			}
		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			Log.i("onScroll", "firstVisibleItem = " + firstVisibleItem);
			Log.i("onScroll", "visibleItemCount = " + visibleItemCount);
			Log.i("onScroll", "totalItemCount = " + totalItemCount);
			if (isScroll) {
				View c = view.getChildAt(0);
				if (c != null) {
					// 当前显示的第一个item划上去的长度
					float top = Math.abs(c.getTop());
					Log.i("onScroll", "top = " + top);
					// 当前显示的第一个item的高度
					float len = view.getChildAt(0).getHeight();
					Log.i("onScroll", "len = " + len);
					float bi = top / len;
					Log.i("onScroll", "bi = " + bi);

					switch (flog) {
					case 1:
						data_eat.get(firstVisibleItem + 1).setHeight(
								(float) (250 * (1 + 0.6 * bi)));
						data_eat.get(firstVisibleItem + 1).setAlph(
								(float) (0.6 - 0.6 * bi));
						adapter.setData(data_eat);
						break;
					case 2:
						data_dreak.get(firstVisibleItem + 1).setHeight(
								(float) (250 * (1 + 0.6 * bi)));
						data_dreak.get(firstVisibleItem + 1).setAlph(
								(float) (0.6 - 0.6 * bi));
						adapter.setData(data_dreak);
						break;
					case 3:
						data_play.get(firstVisibleItem + 1).setHeight(
								(float) (250 * (1 + 0.6 * bi)));
						data_play.get(firstVisibleItem + 1).setAlph(
								(float) (0.6 - 0.6 * bi));
						adapter.setData(data_play);
						break;
					case 4:
						data_happy.get(firstVisibleItem + 1).setHeight(
								(float) (250 * (1 + 0.6 * bi)));
						data_happy.get(firstVisibleItem + 1).setAlph(
								(float) (0.6 - 0.6 * bi));
						adapter.setData(data_happy);
						break;
					default:
						break;
					}
				}
			}
		}
	};

	/**
	 * 乐
	 */
	private void happy() {
		flog = 4;
		adapter.setData(data_happy);
	}

	/**
	 * 玩
	 */
	private void play() {
		flog = 3;
		adapter.setData(data_play);
	}

	/**
	 * 喝
	 */
	private void dreak() {
		flog = 2;
		adapter.setData(data_dreak);
	}

	/**
	 * 吃
	 */
	private void eat() {
		flog = 1;
		adapter.setData(data_eat);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rbtn_nao_eat:
			eat();
			break;
		case R.id.rbtn_nao_dreak:
			dreak();
			break;
		case R.id.rbtn_nao_play:
			play();
			break;
		case R.id.rbtn_nao_happy:
			happy();
			break;
		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(getActivity(), EatWishActivity.class);
		switch (flog) {
		case 1:
			NaoModel model = data_eat.get(position);

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		default:
			break;
		}
	}
}

package com.example.youyu.fragment;

import com.example.youyu.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class NaoFragment extends Fragment implements OnCheckedChangeListener, OnItemClickListener{
	private View view;
	private RadioGroup radioGroup;
	private ListView listView;
	private ImageView iv_icon;
	private TextView tv_title;
	
	
	@SuppressLint("InflateParams") @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_nao, null);
		
		initView();
		initData();
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	/**
	 * 初始化数据
	 */
	private void initData() {
		
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		iv_icon = (ImageView) view.findViewById(R.id.top_imageview);
		iv_icon.setImageResource(R.drawable.nao_icon);
		tv_title = (TextView) view.findViewById(R.id.top_title);
		tv_title.setText("游渝");
		
		radioGroup = (RadioGroup) view.findViewById(R.id.rg_nao_radiogroup);
		radioGroup.setOnCheckedChangeListener(this);
		
		listView = (ListView) view.findViewById(R.id.lv_nao_listview);
		listView.setOnItemClickListener(this);
	}

	
	
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
	}
}

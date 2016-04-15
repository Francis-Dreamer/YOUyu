package com.example.youyu.adapter;

import java.util.List;

import com.example.youyu.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("ResourceAsColor")
public class TanSearchAdapter extends BaseAdapter {
	/** 点击的item的position */
	private int clickPosition = -1;
	private List<String> data;
	private LayoutInflater inflater;
	
	/**
	 * 判断是否点击加载后面的数据
	 */
	private boolean flog = false;
	
	
	public TanSearchAdapter() {

	}
	public TanSearchAdapter(Context context, List<String> data) {
		this.data = data;
		this.inflater = LayoutInflater.from(context);
	}

	/**
	 * 获取点击的item的position值
	 * 
	 * @param position
	 */
	public void setSelectPosition(int position) {
		this.clickPosition = position;
		this.notifyDataSetChanged();
	}
	
	/**
	 * 设置是否加载更多数据
	 * @param flog
	 */
	public void setIsAddData(boolean flog){
		this.flog = flog;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if(data.size() > 8){
			if(flog){
				data.size();
			}
			return 8;
		}
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int arg0) {
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.activity_myview, null);
			holder.layout = (RelativeLayout) convertView.findViewById(R.id.rlayout_myview_rlayout);
			holder.tv_name = (TextView) convertView.findViewById(R.id.tv_myview_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_name.setText(data.get(position));
		
		if(position == clickPosition){
			//点击item后，改变样式
			holder.tv_name.setTextColor(R.color.icon_xuanzhong);
			holder.layout.setBackgroundResource(R.drawable.xuanzhong);
		}else{
			//否则，变成默认的样式
			holder.tv_name.setTextColor(R.color.textcolor_ziti);
			holder.layout.setBackgroundResource(R.drawable.juxing);
		}
		
		if(!flog){//判断当前是否处于加载更多数据的状态
			if(position == 7){
				//
				holder.tv_name.setText("...");
			}
		}
		
		
		return parent;
	}

	class ViewHolder {
		RelativeLayout layout;
		TextView tv_name;
	}
}

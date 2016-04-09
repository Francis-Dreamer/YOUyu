package com.example.youyu.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.youyu.R;
import com.example.youyu.model.NaoModel;

public class NaoAdapter extends BaseAdapter {

	private List<NaoModel> data;
	private LayoutInflater inflater;

	public NaoAdapter() {
	}

	public NaoAdapter(Context context, List<NaoModel> data) {
		this.data = data;
		inflater = LayoutInflater.from(context);
	}

	public void setData(List<NaoModel> data) {
		this.data = data;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.activity_nao_item, null);
			holder.llayout = (LinearLayout) convertView
					.findViewById(R.id.llayout_nao_item_bottom);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.iv_nao_item_picture);
			holder.tv_bottom = (TextView) convertView
					.findViewById(R.id.tv_nao_item_bottom_title);
			holder.tv_center = (TextView) convertView
					.findViewById(R.id.tv_nao_item_center_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		NaoModel model = (NaoModel) getItem(position);
		if (position == 0) {
			holder.llayout.setVisibility(View.VISIBLE);
			holder.tv_center.setVisibility(View.GONE);
			holder.tv_bottom.setText(model.getName() + "");
		} else {
			holder.llayout.setVisibility(View.GONE);
			holder.tv_center.setVisibility(View.VISIBLE);
			holder.tv_center.setText(model.getName() + "");
		}
		holder.imageView.setImageResource(Integer.parseInt(model.getPath()));
		return convertView;
	}

	class ViewHolder {
		ImageView imageView;
		TextView tv_bottom, tv_center;
		LinearLayout llayout;
	}
}

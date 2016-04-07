package com.example.youyu.adapter;

import java.util.ArrayList;

import com.example.youyu.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DongtaiBaseAdapter extends BaseAdapter {
	LayoutInflater inflater;
	Context context;
	ArrayList<Dongtai_data> list;

	public DongtaiBaseAdapter() {
	}

	public DongtaiBaseAdapter(Context context, ArrayList<Dongtai_data> list) {
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHodler viewHodler;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.dongtai_item, null);
			viewHodler = new ViewHodler();
			viewHodler.image_ciqiko = (ImageView) convertView.findViewById(R.id.image_ciqiko);
			viewHodler.text_ciqiko = (TextView) convertView.findViewById(R.id.text_ciqiko);
			viewHodler.image_ciqikoyonghutouxiang = (ImageView) convertView
					.findViewById(R.id.image_ciqikoyonghutouxiang);
			viewHodler.text_yonghu = (TextView) convertView.findViewById(R.id.text_yonghu);
			viewHodler.text_biaoti = (TextView) convertView.findViewById(R.id.text_biaoti);
			viewHodler.text_leirong = (TextView) convertView.findViewById(R.id.text_leirong);

			convertView.setTag(viewHodler);
		}
		viewHodler = (ViewHodler) convertView.getTag();

		viewHodler.image_ciqiko.setImageResource(list.get(position).getImage_ciqiko());
		viewHodler.text_ciqiko.setText(list.get(position).getText_ciqiko());
		viewHodler.image_ciqikoyonghutouxiang.setImageResource(list.get(position).getImage_ciqikoyonghutouxiang());
		viewHodler.text_yonghu.setText(list.get(position).getText_yonghu());
		viewHodler.text_biaoti.setText(list.get(position).getText_biaoti());
		viewHodler.text_leirong.setText(list.get(position).getText_leirong());

		return convertView;
	}

	class ViewHodler {

		public TextView text_leirong;
		public TextView text_biaoti;
		public TextView text_yonghu;
		public ImageView image_ciqikoyonghutouxiang;
		public TextView text_ciqiko;
		public ImageView image_ciqiko;

	}
}

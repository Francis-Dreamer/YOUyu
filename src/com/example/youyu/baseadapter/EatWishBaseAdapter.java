package com.example.youyu.baseadapter;

import java.util.List;

import com.example.youyu.R;
import com.example.youyu.model.EatWishModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EatWishBaseAdapter extends BaseAdapter {
	List<EatWishModel> list;
	LayoutInflater inflater;
	Context context;

	public EatWishBaseAdapter() {

	}

	public EatWishBaseAdapter(List<EatWishModel> list, Context context) {
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_eatwish, null);
			holder.title = (TextView) convertView
					.findViewById(R.id.eatwish_title);
			holder.english_title = (TextView) convertView
					.findViewById(R.id.eatwish_english_name);
			holder.text = (TextView) convertView
					.findViewById(R.id.eatwish_text);
			holder.address = (TextView) convertView
					.findViewById(R.id.eatwish_address);
			holder.text_image = (ImageView) convertView
					.findViewById(R.id.eatwish_image);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		EatWishModel eatWishModel = (EatWishModel) getItem(position);
		holder.title.setText(eatWishModel.getWish_title());
		holder.english_title.setText(eatWishModel.getWish_english_title());
		holder.text.setText(eatWishModel.getWish_text());
		holder.address.setText(eatWishModel.getWish_address());
		holder.text_image.setImageResource(R.drawable.text_peitu);
		return convertView;
	}

	class ViewHolder {
		ImageView text_image;
		TextView title;
		TextView english_title;
		TextView text;
		TextView address;
	}
}

package com.example.youyu.adapter;

import java.util.Date;
import java.util.List;

import com.example.youyu.R;
import com.example.youyu.model.CommentModel;
import com.example.youyu.view.RelativeDateFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CommentBaseAdapter extends BaseAdapter {
	LayoutInflater inflater;
	List<CommentModel> list;
	Context context;

	public CommentBaseAdapter() {

	}

	public CommentBaseAdapter(List<CommentModel> list, Context context) {
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

	@SuppressWarnings("static-access")
	@SuppressLint({ "SimpleDateFormat", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {

		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_comment, null);
			holder.comment_name = (TextView) convertView
					.findViewById(R.id.comment_name);
			holder.comment_text = (TextView) convertView
					.findViewById(R.id.comment_text);
			holder.user_name = (TextView) convertView
					.findViewById(R.id.username);
			holder.user_name_text = (TextView) convertView
					.findViewById(R.id.username_text);
			holder.comment_pic = (ImageView) convertView
					.findViewById(R.id.comment_icon);
			holder.comment_time = (TextView) convertView
					.findViewById(R.id.comment_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Date date=new Date();
		long time=date.getTime();
		RelativeDateFormat dateFormat=new RelativeDateFormat();
		
		CommentModel commentModel = (CommentModel) getItem(position);
		holder.comment_name.setText(commentModel.getComment_name());
		holder.comment_text.setText(commentModel.getComment_text());
		holder.user_name.setText(commentModel.getUser_name());
		holder.user_name_text.setText(commentModel.getUser_name_text());
		holder.comment_pic.setImageResource(commentModel.getComment_pic());
		holder.comment_time.setText(dateFormat.format(time));
		return convertView;
	}

	class ViewHolder {
		ImageView comment_pic;
		TextView comment_name;
		TextView comment_text;
		TextView comment_time;
		TextView user_name;
		TextView user_name_text;
	}
}

package com.example.youyu.baseadapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.youyu.R;
import com.example.youyu.YuActivity;
import com.example.youyu.model.YuModel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class YuBaseAdapter extends BaseAdapter {
	Context context;
	List<YuModel> list;
	LayoutInflater inflater;
	PopupWindow popupWindow;

	public YuBaseAdapter() {
	}

	public YuBaseAdapter(Context context, List<YuModel> list) {
		this.context = context;
		this.list = list;
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

	@SuppressLint({ "SimpleDateFormat", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_yu, null);
			holder.text = (TextView) convertView.findViewById(R.id.yu_text);
			holder.text_number = (TextView) convertView
					.findViewById(R.id.yu_textnumber);
			holder.text_name = (TextView) convertView
					.findViewById(R.id.yu_text_tittle);
			holder.weather = (TextView) convertView
					.findViewById(R.id.yu_weather);
			holder.time = (TextView) convertView.findViewById(R.id.yu_date);
			holder.image_share = (ImageView) convertView
					.findViewById(R.id.yu_share);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		YuModel model = (YuModel) list.get(position);
		holder.image_share.setOnClickListener(clickListener);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		holder.text.setText(model.getText());
		holder.text_name.setText(model.getText_name());
		holder.text_number.setText("第" + model.getText_number() + "篇");
		holder.weather.setText("今日天气：" + model.getWeather());
		holder.time.setText(dateFormat.format(date));
		return convertView;
	}

	class ViewHolder {
		TextView text_number;
		TextView text_name;
		TextView text;
		TextView weather;
		TextView time;
		ImageView image_share;
	}

	/**
	 * 点击事件
	 */
	OnClickListener clickListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.yu_share:
				popWindow();
				break;
			case R.id.share_quxiao:
				// 销毁弹出框
				popupWindow.dismiss();
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
		View view = inflater.inflate(R.layout.activity_yu_shaarepopupwindow,
				null);
		// 获取屏幕宽度
		WindowManager wm = ((Activity) context).getWindowManager();
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
}

package com.example.youyu.baseadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.youyu.R;
import com.example.youyu.model.OldTimeYModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OldTimeGridViewBaseAdapter extends BaseAdapter{
	private Context mContext; 
	private List<OldTimeYModel> mList; 
	LayoutInflater inflater;
	public OldTimeGridViewBaseAdapter(){
		
	}
public OldTimeGridViewBaseAdapter(Context mContext,List<OldTimeYModel>  mList){
	this.mContext = mContext; 
	this.mList = mList; 
	inflater=LayoutInflater.from(mContext);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_yu_oldtimey_image,
					null);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.this_month_image);
			holder.pic_name = (TextView) convertView
					.findViewById(R.id.image_text_name);
			convertView.setTag(holder);
		}
		OldTimeYModel model=(OldTimeYModel)getItem(position);
		holder = (ViewHolder) convertView.getTag();
		holder.imageView.setImageResource(model.getPic());
		holder.pic_name.setText(model.getPic_name());
		return convertView;
	}
	class ViewHolder {
		TextView pic_name;
		ImageView imageView;
	}
}

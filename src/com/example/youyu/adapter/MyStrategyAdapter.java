package com.example.youyu.adapter;

import java.util.List;

import com.example.youyu.R;
import com.example.youyu.model.MyStrategyModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyStrategyAdapter extends BaseAdapter{

	Context context;
	LayoutInflater inflater;
	List<MyStrategyModel> data;
	
	public MyStrategyAdapter(){
		
	}
	
	public MyStrategyAdapter(List<MyStrategyModel> data,Context context){
		this.data=data;
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	
	public void setData(List<MyStrategyModel> data){
		this.data=data;
		this.notifyDataSetChanged();
	}
	
	public int getCount() {
		if(data!=null){
			return data.size();
		}else{
			return 0;
		}
	}

	public Object getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
	
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.every_mystrategy, null);
			holder.title=(TextView) convertView.findViewById(R.id.strategy_title);
			holder.content=(TextView) convertView.findViewById(R.id.strategy_content);
			holder.time=(TextView) convertView.findViewById(R.id.strategy_time);
			holder.pic1=(ImageView) convertView.findViewById(R.id.pic1);
			holder.pic2=(ImageView) convertView.findViewById(R.id.pic2);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		MyStrategyModel model=(MyStrategyModel) getItem(position);
		holder.title.setText(model.getTitle());
		holder.content.setText(model.getContent());
		holder.time.setText(model.getTime());
		holder.pic1.setImageResource(Integer.parseInt(model.getPic1()));
		holder.pic2.setImageResource(Integer.parseInt(model.getPic2()));
		
		return convertView;
	}

	class ViewHolder{
		TextView title;
		TextView content;
		TextView time;
		ImageView pic1;
		ImageView pic2;
	}
}
